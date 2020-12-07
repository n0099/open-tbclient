package com.baidu.swan.apps.ap;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.ui.animview.praise.guide.ControlShowManager;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes25.dex */
public class aj {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public static int aPp() {
        JSONObject uY = uY(getAppId());
        if (uY != null) {
            return uY.optInt("launch_count", 0);
        }
        return 0;
    }

    public static long aPq() {
        long currentTimeMillis = System.currentTimeMillis();
        JSONObject uY = uY(getAppId());
        long optLong = uY != null ? uY.optLong("foreground_aiapp_last_time_local", 0L) : 0L;
        if (uY != null) {
            return uY.optLong("visit_duration", 0L) + (currentTimeMillis - optLong);
        }
        return 0L;
    }

    public static void aPr() {
        d(getAppId(), "visit_duration", Long.valueOf(aPq()));
    }

    public static void cY(long j) {
        d(getAppId(), "foreground_aiapp_last_time_local", Long.valueOf(j));
    }

    public static String getCurrentDate() {
        return j.a(j.aOU(), ControlShowManager.DAY_TIME_FORMAT);
    }

    public static boolean ce(JSONObject jSONObject) {
        String currentDate = getCurrentDate();
        String optString = jSONObject.optString("date", "");
        return TextUtils.isEmpty(optString) || !optString.equals(currentDate);
    }

    public static JSONObject uY(String str) {
        JSONObject jSONObject;
        JSONException e;
        String string = com.baidu.swan.apps.storage.c.h.aNr().getString("dailyInfo", "");
        if (DEBUG) {
            Log.i("SwanAppUserVisitInfoUtils", "dailyInfo:" + string);
        }
        try {
            JSONObject jSONObject2 = TextUtils.isEmpty(string) ? new JSONObject() : new JSONObject(string);
            if (ce(jSONObject2)) {
                jSONObject2.put("date", getCurrentDate());
            }
            jSONObject = jSONObject2.optJSONObject(str);
            if (jSONObject == null) {
                try {
                    jSONObject2.put(str, new JSONObject());
                    com.baidu.swan.apps.storage.c.h.aNr().putString("dailyInfo", jSONObject2.toString());
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
        String string = com.baidu.swan.apps.storage.c.h.aNr().getString("dailyInfo", "");
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
            com.baidu.swan.apps.storage.c.h.aNr().putString("dailyInfo", jSONObject.toString());
        } catch (JSONException e) {
            if (DEBUG) {
                Log.e("SwanAppUserVisitInfoUtils", e.getMessage());
            }
        }
    }

    private static String getAppId() {
        return com.baidu.swan.apps.runtime.e.aJU() != null ? com.baidu.swan.apps.runtime.e.aJU().id : "";
    }
}
