package com.baidu.swan.apps.ao;

import android.text.TextUtils;
import android.util.Log;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class aj {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public static int aOj() {
        JSONObject um = um(getAppId());
        if (um != null) {
            return um.optInt("launch_count", 0);
        }
        return 0;
    }

    public static long aOk() {
        long currentTimeMillis = System.currentTimeMillis();
        JSONObject um = um(getAppId());
        long optLong = um != null ? um.optLong("foreground_aiapp_last_time_local", 0L) : 0L;
        if (um != null) {
            return um.optLong("visit_duration", 0L) + (currentTimeMillis - optLong);
        }
        return 0L;
    }

    public static void aOl() {
        d(getAppId(), "visit_duration", Long.valueOf(aOk()));
    }

    public static void df(long j) {
        d(getAppId(), "foreground_aiapp_last_time_local", Long.valueOf(j));
    }

    public static String getCurrentDate() {
        return j.a(j.aNO(), "yyyy-MM-dd");
    }

    public static boolean cl(JSONObject jSONObject) {
        String currentDate = getCurrentDate();
        String optString = jSONObject.optString("date", "");
        return TextUtils.isEmpty(optString) || !optString.equals(currentDate);
    }

    public static JSONObject um(String str) {
        String string = com.baidu.swan.apps.storage.c.h.aMk().getString("dailyInfo", "");
        if (DEBUG) {
            Log.i("SwanAppUserVisitInfoUtils", "dailyInfo:" + string);
        }
        JSONObject jSONObject = null;
        try {
            JSONObject jSONObject2 = TextUtils.isEmpty(string) ? new JSONObject() : new JSONObject(string);
            if (cl(jSONObject2)) {
                jSONObject2.put("date", getCurrentDate());
            }
            jSONObject = jSONObject2.optJSONObject(str);
            if (jSONObject == null) {
                jSONObject2.put(str, new JSONObject());
                com.baidu.swan.apps.storage.c.h.aMk().putString("dailyInfo", jSONObject2.toString());
            }
        } catch (JSONException e) {
            if (DEBUG) {
                Log.e("SwanAppUserVisitInfoUtils", e.getMessage());
            }
        }
        return jSONObject;
    }

    public static void d(String str, String str2, Object obj) {
        JSONObject jSONObject;
        String string = com.baidu.swan.apps.storage.c.h.aMk().getString("dailyInfo", "");
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
            com.baidu.swan.apps.storage.c.h.aMk().putString("dailyInfo", jSONObject.toString());
        } catch (JSONException e) {
            if (DEBUG) {
                Log.e("SwanAppUserVisitInfoUtils", e.getMessage());
            }
        }
    }

    private static String getAppId() {
        return com.baidu.swan.apps.runtime.e.aIN() != null ? com.baidu.swan.apps.runtime.e.aIN().id : "";
    }
}
