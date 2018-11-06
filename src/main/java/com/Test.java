package com;/**
 * @Auther: dell
 * @Date: 2018/11/6 14:32
 * @Description:
 */

import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName Test
 * @Description TODO
 * @Author whc
 * @Date 2018/11/06 14:32
 * @Version 1.0
 */
public class Test {


    public static void main(String[] args) {

        Map<String,String> parm = new HashMap<>();
        parm.put("city","深圳市");
        //https://www.sojson.com/open/api/weather/json.shtml
        //https://www.sojson.com/api/weather.html
        String result = HttpRequest.sendGet("http://t.weather.sojson.com/api/weather/city/101030100", null);

        //获取主要信息
        JSONObject jsonObject = JSONObject.parseObject(result);
        Map<String,Object> o = (Map<String,Object>)jsonObject.get("data");
        List<Map<String,Object>> forecast = (List<Map<String,Object>>)o.get("forecast");

        List<Map<String, Object>> maps = forecast.subList(0, 3);

        for (Map<String, Object> map : maps) {
            System.out.println("日期：" + map.get("date") + " || 天气：" + map.get("type"));
        }


    }

}
