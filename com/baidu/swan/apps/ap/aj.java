package com.baidu.swan.apps.ap;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.ui.animview.praise.guide.ControlShowManager;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class aj {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public static int aMQ() {
        JSONObject uw = uw(getAppId());
        if (uw != null) {
            return uw.optInt("launch_count", 0);
        }
        return 0;
    }

    public static long aMR() {
        long currentTimeMillis = System.currentTimeMillis();
        JSONObject uw = uw(getAppId());
        long optLong = uw != null ? uw.optLong("foreground_aiapp_last_time_local", 0L) : 0L;
        if (uw != null) {
            return uw.optLong("visit_duration", 0L) + (currentTimeMillis - optLong);
        }
        return 0L;
    }

    public static void aMS() {
        d(getAppId(), "visit_duration", Long.valueOf(aMR()));
    }

    public static void cz(long j) {
        d(getAppId(), "foreground_aiapp_last_time_local", Long.valueOf(j));
    }

    public static String getCurrentDate() {
        return j.a(j.aMv(), ControlShowManager.DAY_TIME_FORMAT);
    }

    public static boolean ci(JSONObject jSONObject) {
        String currentDate = getCurrentDate();
        String optString = jSONObject.optString("date", "");
        return TextUtils.isEmpty(optString) || !optString.equals(currentDate);
    }

    public static JSONObject uw(String str) {
        JSONObject jSONObject;
        JSONException e;
        String string = com.baidu.swan.apps.storage.c.h.aKS().getString("dailyInfo", "");
        if (DEBUG) {
            Log.i("SwanAppUserVisitInfoUtils", "dailyInfo:" + string);
        }
        try {
            JSONObject jSONObject2 = TextUtils.isEmpty(string) ? new JSONObject() : new JSONObject(string);
            if (ci(jSONObject2)) {
                jSONObject2.put("date", getCurrentDate());
            }
            jSONObject = jSONObject2.optJSONObject(str);
            if (jSONObject == null) {
                try {
                    jSONObject2.put(str, new JSONObject());
                    com.baidu.swan.apps.storage.c.h.aKS().putString("dailyInfo", jSONObject2.toString());
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

    public static void d(String str, String str2, Object obj) {
        JSONObject jSONObject;
        String string = com.baidu.swan.apps.storage.c.h.aKS().getString("dailyInfo", "");
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
            com.baidu.swan.apps.storage.c.h.aKS().putString("dailyInfo", jSONObject.toString());
        } catch (JSONException e) {
            if (DEBUG) {
                Log.e("SwanAppUserVisitInfoUtils", e.getMessage());
            }
        }
    }

    private static String getAppId() {
        return com.baidu.swan.apps.runtime.e.aHu() != null ? com.baidu.swan.apps.runtime.e.aHu().id : "";
    }
}
