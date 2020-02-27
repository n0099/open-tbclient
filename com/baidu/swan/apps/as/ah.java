package com.baidu.swan.apps.as;

import android.text.TextUtils;
import android.util.Log;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class ah {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public static int agW() {
        JSONObject mT = mT(getAppId());
        if (mT != null) {
            return mT.optInt("launch_count", 0);
        }
        return 0;
    }

    public static long agX() {
        long currentTimeMillis = System.currentTimeMillis();
        JSONObject mT = mT(getAppId());
        long optLong = mT != null ? mT.optLong("foreground_aiapp_last_time_local", 0L) : 0L;
        if (mT != null) {
            return mT.optLong("visit_duration", 0L) + (currentTimeMillis - optLong);
        }
        return 0L;
    }

    public static void agY() {
        c(getAppId(), "visit_duration", Long.valueOf(agX()));
    }

    public static void agZ() {
        c(getAppId(), "launch_count", Integer.valueOf(agW() + 1));
    }

    public static void aha() {
        c(getAppId(), "foreground_aiapp_last_time_local", Long.valueOf(System.currentTimeMillis()));
    }

    public static String getCurrentDate() {
        return h.getFormatDate(h.getCurrDate(), "yyyy-MM-dd");
    }

    public static boolean bb(JSONObject jSONObject) {
        String currentDate = getCurrentDate();
        String optString = jSONObject.optString("date", "");
        return TextUtils.isEmpty(optString) || !optString.equals(currentDate);
    }

    public static JSONObject mT(String str) {
        JSONObject jSONObject;
        JSONException e;
        String string = com.baidu.swan.apps.storage.c.h.afp().getString("dailyInfo", "");
        if (DEBUG) {
            Log.i("SwanAppUserVisitInfoUtils", "dailyInfo:" + string);
        }
        try {
            JSONObject jSONObject2 = TextUtils.isEmpty(string) ? new JSONObject() : new JSONObject(string);
            if (bb(jSONObject2)) {
                jSONObject2.put("date", getCurrentDate());
            }
            jSONObject = jSONObject2.optJSONObject(str);
            if (jSONObject == null) {
                try {
                    jSONObject2.put(str, new JSONObject());
                    com.baidu.swan.apps.storage.c.h.afp().putString("dailyInfo", jSONObject2.toString());
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
        String string = com.baidu.swan.apps.storage.c.h.afp().getString("dailyInfo", "");
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
            com.baidu.swan.apps.storage.c.h.afp().putString("dailyInfo", jSONObject.toString());
        } catch (JSONException e) {
            if (DEBUG) {
                Log.e("SwanAppUserVisitInfoUtils", e.getMessage());
            }
        }
    }

    private static String getAppId() {
        return com.baidu.swan.apps.runtime.e.acD() != null ? com.baidu.swan.apps.runtime.e.acD().id : "";
    }
}
