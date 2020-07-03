package com.baidu.swan.apps.aq;

import android.text.TextUtils;
import android.util.Log;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public final class t {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public static JSONObject parseString(String str) {
        if (TextUtils.isEmpty(str)) {
            return new JSONObject();
        }
        try {
            return new JSONObject(str);
        } catch (JSONException e) {
            if (DEBUG) {
                Log.w("JSONUtils", "JSONObject parsed error!!", e);
            }
            return new JSONObject();
        }
    }

    public static JSONArray pP(String str) {
        if (TextUtils.isEmpty(str)) {
            return new JSONArray();
        }
        try {
            return new JSONArray(str);
        } catch (JSONException e) {
            if (DEBUG) {
                Log.w("JSONUtils", "JSONArray parsed error!!", e);
            }
            return new JSONArray();
        }
    }

    public static float getFloat(JSONObject jSONObject, String str, float f) {
        return jSONObject == null ? f : (float) jSONObject.optDouble(str, f);
    }
}
