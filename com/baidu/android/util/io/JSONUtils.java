package com.baidu.android.util.io;

import android.text.TextUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
@Deprecated
/* loaded from: classes2.dex */
public final class JSONUtils {
    public static final boolean DEBUG = false;
    public static final String TAG = "JSONUtils";

    public static <T> T get(JSONObject jSONObject, String str, Class<T> cls) {
        if (jSONObject == null) {
            return null;
        }
        T t = (T) jSONObject.opt(str);
        if (cls.isInstance(t)) {
            return t;
        }
        return null;
    }

    public static boolean getBoolean(JSONObject jSONObject, String str, boolean z) {
        Boolean bool = (Boolean) get(jSONObject, str, Boolean.class);
        return bool == null ? z : bool.booleanValue();
    }

    public static float getFloat(JSONObject jSONObject, String str, float f2) {
        return jSONObject == null ? f2 : (float) jSONObject.optDouble(str, f2);
    }

    public static int getInt(JSONObject jSONObject, String str, int i) {
        return ((Integer) get(jSONObject, str, Integer.class)) == null ? i : ((Integer) get(jSONObject, str, Integer.class)).intValue();
    }

    public static String getIntOrString(JSONObject jSONObject, String str) {
        Integer num = (Integer) get(jSONObject, str, Integer.class);
        if (num == null) {
            return (String) get(jSONObject, str, String.class);
        }
        return num.toString();
    }

    public static <T> T getItem(JSONArray jSONArray, int i, Class<T> cls) {
        T t = (T) jSONArray.opt(i);
        if (cls.isInstance(t)) {
            return t;
        }
        return null;
    }

    public static JSONArray getJSONArray(JSONObject jSONObject, String str) {
        return (JSONArray) get(jSONObject, str, JSONArray.class);
    }

    public static JSONObject getJSONObject(JSONObject jSONObject, String str) {
        return (JSONObject) get(jSONObject, str, JSONObject.class);
    }

    public static JSONObject getJSONObjectItem(JSONArray jSONArray, int i) {
        return (JSONObject) getItem(jSONArray, i, JSONObject.class);
    }

    public static String getString(JSONObject jSONObject, String str) {
        return (String) get(jSONObject, str, String.class);
    }

    public static JSONObject parseString(String str) {
        if (TextUtils.isEmpty(str)) {
            return new JSONObject();
        }
        try {
            return new JSONObject(str);
        } catch (JSONException unused) {
            return new JSONObject();
        }
    }

    public static Object get(JSONObject jSONObject, String str) {
        return get(jSONObject, str, Object.class);
    }
}
