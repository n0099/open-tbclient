package com.baidu.swan.apps.aq;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.ui.animview.praise.guide.ControlShowManager;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class ak {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public static int awU() {
        JSONObject qI = qI(getAppId());
        if (qI != null) {
            return qI.optInt("launch_count", 0);
        }
        return 0;
    }

    public static long awV() {
        long currentTimeMillis = System.currentTimeMillis();
        JSONObject qI = qI(getAppId());
        long optLong = qI != null ? qI.optLong("foreground_aiapp_last_time_local", 0L) : 0L;
        if (qI != null) {
            return qI.optLong("visit_duration", 0L) + (currentTimeMillis - optLong);
        }
        return 0L;
    }

    public static void awW() {
        e(getAppId(), "visit_duration", Long.valueOf(awV()));
    }

    public static void awX() {
        e(getAppId(), "launch_count", Integer.valueOf(awU() + 1));
    }

    public static void awY() {
        e(getAppId(), "foreground_aiapp_last_time_local", Long.valueOf(System.currentTimeMillis()));
    }

    public static String getCurrentDate() {
        return j.a(j.awy(), ControlShowManager.DAY_TIME_FORMAT);
    }

    public static boolean bH(JSONObject jSONObject) {
        String currentDate = getCurrentDate();
        String optString = jSONObject.optString("date", "");
        return TextUtils.isEmpty(optString) || !optString.equals(currentDate);
    }

    public static JSONObject qI(String str) {
        JSONObject jSONObject;
        JSONException e;
        String string = com.baidu.swan.apps.storage.c.h.auW().getString("dailyInfo", "");
        if (DEBUG) {
            Log.i("SwanAppUserVisitInfoUtils", "dailyInfo:" + string);
        }
        try {
            JSONObject jSONObject2 = TextUtils.isEmpty(string) ? new JSONObject() : new JSONObject(string);
            if (bH(jSONObject2)) {
                jSONObject2.put("date", getCurrentDate());
            }
            jSONObject = jSONObject2.optJSONObject(str);
            if (jSONObject == null) {
                try {
                    jSONObject2.put(str, new JSONObject());
                    com.baidu.swan.apps.storage.c.h.auW().putString("dailyInfo", jSONObject2.toString());
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

    public static void e(String str, String str2, Object obj) {
        JSONObject jSONObject;
        String string = com.baidu.swan.apps.storage.c.h.auW().getString("dailyInfo", "");
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
            com.baidu.swan.apps.storage.c.h.auW().putString("dailyInfo", jSONObject.toString());
        } catch (JSONException e) {
            if (DEBUG) {
                Log.e("SwanAppUserVisitInfoUtils", e.getMessage());
            }
        }
    }

    private static String getAppId() {
        return com.baidu.swan.apps.runtime.e.arv() != null ? com.baidu.swan.apps.runtime.e.arv().id : "";
    }
}
