package com.baidu.mobads.sdk.internal;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class ConvertUtils {
    public static JSONArray array2Json(double[] dArr) {
        JSONArray jSONArray = null;
        if (dArr == null) {
            return null;
        }
        try {
            JSONArray jSONArray2 = new JSONArray();
            for (double d2 : dArr) {
                try {
                    jSONArray2.put(d2);
                } catch (Exception e2) {
                    e = e2;
                    jSONArray = jSONArray2;
                    XAdLogger.getInstance().d(e);
                    return jSONArray;
                }
            }
            return jSONArray2;
        } catch (Exception e3) {
            e = e3;
        }
    }

    public static JSONObject combineJson(JSONObject jSONObject, JSONObject jSONObject2) throws JSONException {
        if (jSONObject2 != null && jSONObject2.length() > 0) {
            Iterator<String> keys = jSONObject2.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                jSONObject.put(next, jSONObject2.opt(next));
            }
        }
        return jSONObject;
    }

    public static JSONObject hashMap2Json(HashMap<String, Object> hashMap) {
        if (hashMap == null || hashMap.isEmpty()) {
            return null;
        }
        try {
            return new JSONObject(hashMap);
        } catch (Exception unused) {
            XAdLogger.getInstance().d("hashMap2Json error");
            return null;
        }
    }

    public static HashMap<String, String> json2HashMap(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        HashMap<String, String> hashMap = new HashMap<>();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            try {
                String next = keys.next();
                hashMap.put(next, jSONObject.optString(next));
            } catch (Exception unused) {
                XAdLogger.getInstance().d("json2HashMap error");
            }
        }
        return hashMap;
    }

    public static JSONArray list2Json(List<String[]> list) {
        JSONArray jSONArray = new JSONArray();
        for (int i2 = 0; i2 < list.size(); i2++) {
            try {
                JSONArray jSONArray2 = new JSONArray();
                for (int i3 = 0; i3 < list.get(i2).length; i3++) {
                    jSONArray2.put(list.get(i2)[i3]);
                }
                jSONArray.put(jSONArray2);
            } catch (Exception e2) {
                XAdLogger.getInstance().d(e2);
            }
        }
        return jSONArray;
    }

    public static Object optObjectFromJson(JSONObject jSONObject, String str) {
        return (jSONObject != null && jSONObject.has(str)) ? jSONObject.opt(str) : "";
    }
}
