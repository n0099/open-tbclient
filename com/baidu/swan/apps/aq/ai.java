package com.baidu.swan.apps.aq;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.ui.animview.praise.guide.ControlShowManager;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class ai {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public static int atI() {
        JSONObject pO = pO(getAppId());
        if (pO != null) {
            return pO.optInt("launch_count", 0);
        }
        return 0;
    }

    public static long atJ() {
        long currentTimeMillis = System.currentTimeMillis();
        JSONObject pO = pO(getAppId());
        long optLong = pO != null ? pO.optLong("foreground_aiapp_last_time_local", 0L) : 0L;
        if (pO != null) {
            return pO.optLong("visit_duration", 0L) + (currentTimeMillis - optLong);
        }
        return 0L;
    }

    public static void atK() {
        d(getAppId(), "visit_duration", Long.valueOf(atJ()));
    }

    public static void atL() {
        d(getAppId(), "launch_count", Integer.valueOf(atI() + 1));
    }

    public static void atM() {
        d(getAppId(), "foreground_aiapp_last_time_local", Long.valueOf(System.currentTimeMillis()));
    }

    public static String getCurrentDate() {
        return i.a(i.atq(), ControlShowManager.DAY_TIME_FORMAT);
    }

    public static boolean bv(JSONObject jSONObject) {
        String currentDate = getCurrentDate();
        String optString = jSONObject.optString("date", "");
        return TextUtils.isEmpty(optString) || !optString.equals(currentDate);
    }

    public static JSONObject pO(String str) {
        JSONObject jSONObject;
        JSONException e;
        String string = com.baidu.swan.apps.storage.c.h.arO().getString("dailyInfo", "");
        if (DEBUG) {
            Log.i("SwanAppUserVisitInfoUtils", "dailyInfo:" + string);
        }
        try {
            JSONObject jSONObject2 = TextUtils.isEmpty(string) ? new JSONObject() : new JSONObject(string);
            if (bv(jSONObject2)) {
                jSONObject2.put("date", getCurrentDate());
            }
            jSONObject = jSONObject2.optJSONObject(str);
            if (jSONObject == null) {
                try {
                    jSONObject2.put(str, new JSONObject());
                    com.baidu.swan.apps.storage.c.h.arO().putString("dailyInfo", jSONObject2.toString());
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
        String string = com.baidu.swan.apps.storage.c.h.arO().getString("dailyInfo", "");
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
            com.baidu.swan.apps.storage.c.h.arO().putString("dailyInfo", jSONObject.toString());
        } catch (JSONException e) {
            if (DEBUG) {
                Log.e("SwanAppUserVisitInfoUtils", e.getMessage());
            }
        }
    }

    private static String getAppId() {
        return com.baidu.swan.apps.runtime.e.aoF() != null ? com.baidu.swan.apps.runtime.e.aoF().id : "";
    }
}
