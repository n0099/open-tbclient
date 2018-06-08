package com.baidu.ar.util;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class ArResourceUtils {
    private static String a(String str) {
        return FileUtils.readFileText(ARFileUtils.getDefaultJsonPath(str));
    }

    private static String b(String str) {
        return FileUtils.readFileText(ARFileUtils.getTargetJsonPath(str));
    }

    private static String c(String str) {
        return FileUtils.readFileText(ARFileUtils.getResConfigJsonPath(str));
    }

    public static String generateResult(String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("unzip_path", str);
            jSONObject.put("defalt_json", a(str));
            jSONObject.put("target_json", b(str));
            jSONObject.put("res_config", c(str));
            return jSONObject.toString();
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
