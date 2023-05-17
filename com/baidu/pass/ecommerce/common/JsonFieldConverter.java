package com.baidu.pass.ecommerce.common;

import com.baidu.sapi2.utils.Log;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class JsonFieldConverter {
    public static final String TAG = "JsonFieldConverter";

    public static void putInt(String str, int i, JSONObject jSONObject) {
        try {
            jSONObject.put(str, i);
        } catch (JSONException e) {
            Log.e(TAG, "put int field key=" + str + " value=" + i + " is error " + e.getMessage());
        }
    }

    public static void putStr(String str, MapObject mapObject, JSONObject jSONObject) {
        try {
            jSONObject.put(str, mapObject.getStrValue(str));
        } catch (JSONException e) {
            Log.e(TAG, "put String field " + str + " is error " + e.getMessage());
        }
    }

    public static void putInt(String str, MapObject mapObject, JSONObject jSONObject) {
        try {
            jSONObject.put(str, mapObject.getIntValue(str));
        } catch (JSONException e) {
            Log.e(TAG, "put int field " + str + " is error " + e.getMessage());
        }
    }

    public static void putStr(String str, String str2, JSONObject jSONObject) {
        try {
            jSONObject.put(str, str2);
        } catch (JSONException e) {
            Log.e(TAG, "put String field key=" + str + " value=" + str2 + " is error " + e.getMessage());
        }
    }

    public static void putJsonObj(String str, JSONObject jSONObject, JSONObject jSONObject2) {
        try {
            jSONObject2.put(str, jSONObject);
        } catch (JSONException unused) {
            Log.e(TAG, "put JsonObj field " + str + " is error");
        }
    }
}
