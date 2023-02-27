package com.baidu.searchbox.crius.util;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class CriusUtil {
    public static float convertFloatValue(double d, float f) {
        return (float) (d * (d < 1.0d ? 10.0d : f));
    }

    public static float positive(float f) {
        if (f >= 0.0f) {
            return f;
        }
        return 0.0f;
    }

    public static boolean equalsDouble(double d, double d2) {
        if (Math.abs(d - d2) <= 0.001d) {
            return true;
        }
        return false;
    }

    public static double getDoubleIfExist(JSONObject jSONObject, String str) {
        if (jSONObject == null || TextUtils.isEmpty(str) || !jSONObject.has(str)) {
            return -10000.0d;
        }
        return jSONObject.optDouble(str);
    }

    public static int getIntIfExist(JSONObject jSONObject, String str) {
        if (jSONObject == null || TextUtils.isEmpty(str) || !jSONObject.has(str)) {
            return Integer.MIN_VALUE;
        }
        return jSONObject.optInt(str);
    }

    public static String getStringIfExist(JSONObject jSONObject, String str) {
        if (jSONObject == null || TextUtils.isEmpty(str) || !jSONObject.has(str)) {
            return "";
        }
        return jSONObject.optString(str);
    }

    public static Map<String, String> getMapIfExist(JSONObject jSONObject, String str) {
        JSONObject optJSONObject;
        if (jSONObject == null || TextUtils.isEmpty(str) || (optJSONObject = jSONObject.optJSONObject(str)) == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        Iterator<String> keys = optJSONObject.keys();
        while (keys != null && keys.hasNext()) {
            String next = keys.next();
            String optString = optJSONObject.optString(next);
            if (!TextUtils.isEmpty(next) && !TextUtils.isEmpty(optString)) {
                hashMap.put(next, optString);
            }
        }
        return hashMap;
    }
}
