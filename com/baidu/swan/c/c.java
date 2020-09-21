package com.baidu.swan.c;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes24.dex */
public class c {
    public static String c(JSONObject jSONObject, String str, String str2) {
        return jSONObject == null ? str2 : jSONObject.optString(str, str2);
    }

    public static JSONObject a(String str, JSONObject jSONObject, String str2) {
        if (TextUtils.isEmpty(str)) {
            str = "NA";
        }
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        try {
            if (TextUtils.isEmpty(c(jSONObject, str2, null))) {
                jSONObject.put(str2, str);
            }
        } catch (JSONException e) {
        }
        return jSONObject;
    }
}
