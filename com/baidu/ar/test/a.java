package com.baidu.ar.test;

import com.baidu.ar.parser.ARResourceKey;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {
    private static String a;

    public static String a() {
        return a;
    }

    public static JSONObject a(int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(ARResourceKey.HTTP_ERR_CODE, "0");
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("ar_key", "8f5ac06e23d3d10fcd6e9299f8793a89");
            jSONObject2.put("ar_recognition_image_url", "http://ar-fm.cdn.bcebos.com/content-online/upload/traceImage/20170306/ar_inner_175251.jpg");
            jSONObject2.put(ARResourceKey.HTTP_AR_RESOURCE, "http://ar-fm.cdn.bcebos.com/content-online/main/build/10000092/main_10000092_20170307213535.zip");
            jSONObject2.put("ar_udt_resource", "");
            JSONArray jSONArray = new JSONArray();
            jSONArray.put("http://ar-fm.cdn.bcebos.com/content-online/main/build/10000092/main_10000092_20170307213535.zip");
            jSONObject2.put(ARResourceKey.HTTP_AR_MULTI_RESOURCE, jSONArray);
            jSONObject2.put("ar_type", String.valueOf(i));
            jSONObject2.put(ARResourceKey.AR_HARDWARE_SATISFIED, true);
            jSONObject2.put(ARResourceKey.HTTP_AR_MD5, "dc02704021b7ad249ea7f5b3282437eb");
            jSONObject2.put(ARResourceKey.HTTP_REFUSED, "0");
            JSONArray jSONArray2 = new JSONArray();
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("video", true);
            jSONArray2.put(jSONObject3);
            jSONObject2.put(ARResourceKey.HTTP_POWER, jSONArray2);
            jSONObject2.put(ARResourceKey.HTTP_VERSION_CODE, "1489068966");
            jSONObject2.put(ARResourceKey.AR_CODE_URL, "http://ar-fm.cdn.bcebos.com/content-online/so/lib_res_1.zip");
            jSONObject2.put("ar_code_version", 9);
            jSONObject.put(ARResourceKey.HTTP_RET, jSONObject2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
