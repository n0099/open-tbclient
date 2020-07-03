package com.baidu.poly.util;

import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.ArrayMap;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class e {
    public static <K, V> Map<K, V> Or() {
        return Build.VERSION.SDK_INT >= 19 ? new ArrayMap() : new HashMap();
    }

    public static Bundle j(Map<String, String> map) {
        Bundle bundle = new Bundle();
        for (String str : map.keySet()) {
            bundle.putString(str, map.get(str));
        }
        return bundle;
    }

    public static JSONObject k(Map<String, String> map) {
        JSONObject jSONObject = new JSONObject();
        for (String str : map.keySet()) {
            jSONObject.put(str, map.get(str));
        }
        return jSONObject;
    }

    public static Map<String, String> aa(JSONObject jSONObject) {
        Map<String, String> Or = Or();
        if (jSONObject != null) {
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                if (!TextUtils.isEmpty(next)) {
                    Or.put(next, jSONObject.optString(next));
                }
            }
        }
        return Or;
    }
}
