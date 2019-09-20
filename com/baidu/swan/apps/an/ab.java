package com.baidu.swan.apps.an;

import android.text.TextUtils;
import android.util.Log;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class ab {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public static int PI() {
        JSONObject ix = ix(getAppId());
        if (ix != null) {
            return ix.optInt("launch_count", 0);
        }
        return 0;
    }

    public static long PJ() {
        long currentTimeMillis = System.currentTimeMillis();
        JSONObject ix = ix(getAppId());
        long optLong = ix != null ? ix.optLong("foreground_aiapp_last_time_local", 0L) : 0L;
        if (ix != null) {
            return ix.optLong("visit_duration", 0L) + (currentTimeMillis - optLong);
        }
        return 0L;
    }

    public static void PK() {
        c(getAppId(), "visit_duration", Long.valueOf(PJ()));
    }

    public static void PL() {
        c(getAppId(), "launch_count", Integer.valueOf(PI() + 1));
    }

    public static void PM() {
        c(getAppId(), "foreground_aiapp_last_time_local", Long.valueOf(System.currentTimeMillis()));
    }

    public static String getCurrentDate() {
        return e.a(e.Po(), "yyyy-MM-dd");
    }

    public static boolean an(JSONObject jSONObject) {
        String currentDate = getCurrentDate();
        String optString = jSONObject.optString("date", "");
        return TextUtils.isEmpty(optString) || !optString.equals(currentDate);
    }

    public static JSONObject ix(String str) {
        JSONObject jSONObject;
        JSONException e;
        String string = com.baidu.swan.apps.storage.b.f.Ob().getString("dailyInfo", "");
        if (DEBUG) {
            Log.i("SwanAppUserVisitInfoUtils", string);
        }
        try {
            JSONObject jSONObject2 = TextUtils.isEmpty(string) ? new JSONObject() : new JSONObject(string);
            if (an(jSONObject2)) {
                jSONObject2.put("date", getCurrentDate());
            }
            jSONObject = jSONObject2.optJSONObject(str);
            if (jSONObject == null) {
                try {
                    jSONObject2.put(str, new JSONObject());
                    com.baidu.swan.apps.storage.b.f.Ob().putString("dailyInfo", jSONObject2.toString());
                } catch (JSONException e2) {
                    e = e2;
                    if (DEBUG) {
                        Log.e("SwanAppUserVisitInfoUtils", e.getMessage());
                    }
                    return jSONObject;
                }
            }
        } catch (JSONException e3) {
            jSONObject = null;
            e = e3;
        }
        return jSONObject;
    }

    public static void c(String str, String str2, Object obj) {
        JSONObject jSONObject;
        String string = com.baidu.swan.apps.storage.b.f.Ob().getString("dailyInfo", "");
        if (DEBUG) {
            Log.i("SwanAppUserVisitInfoUtils", TextUtils.isEmpty(string) ? "dailyinfo is null" : string);
        }
        try {
            if (TextUtils.isEmpty(string)) {
                jSONObject = new JSONObject();
            } else {
                jSONObject = new JSONObject(string);
            }
            JSONObject optJSONObject = jSONObject.optJSONObject(str);
            if (optJSONObject != null) {
                optJSONObject.put(str2, obj);
            } else {
                jSONObject.put(str, new JSONObject());
            }
            com.baidu.swan.apps.storage.b.f.Ob().putString("dailyInfo", jSONObject.toString());
        } catch (JSONException e) {
            if (DEBUG) {
                Log.e("SwanAppUserVisitInfoUtils", e.getMessage());
            }
        }
    }

    private static String getAppId() {
        return com.baidu.swan.apps.ae.b.Mh() != null ? com.baidu.swan.apps.ae.b.Mh().id : "";
    }
}
