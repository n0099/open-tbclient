package com.baidu.c.a.e;

import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes13.dex */
public class c {
    public static String g(JSONObject jSONObject, String str) {
        if (jSONObject != null && !TextUtils.isEmpty(str) && jSONObject.has(str)) {
            return jSONObject.optString(str);
        }
        return "";
    }

    public static double h(JSONObject jSONObject, String str) {
        if (jSONObject == null || TextUtils.isEmpty(str) || !jSONObject.has(str)) {
            return -10000.0d;
        }
        return jSONObject.optDouble(str);
    }

    public static boolean b(double d, double d2) {
        return Math.abs(d - d2) <= 0.001d;
    }

    public static int i(JSONObject jSONObject, String str) {
        if (jSONObject == null || TextUtils.isEmpty(str) || !jSONObject.has(str)) {
            return Integer.MIN_VALUE;
        }
        return jSONObject.optInt(str);
    }
}
