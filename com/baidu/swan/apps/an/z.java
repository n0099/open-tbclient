package com.baidu.swan.apps.an;

import android.text.TextUtils;
import android.util.Log;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class z {
    private static final boolean DEBUG = com.baidu.swan.apps.c.DEBUG;

    public static int Mi() {
        JSONObject hK = hK(getAppId());
        if (hK != null) {
            return hK.optInt("launch_count", 0);
        }
        return 0;
    }

    public static long Mj() {
        long currentTimeMillis = System.currentTimeMillis();
        JSONObject hK = hK(getAppId());
        long optLong = hK != null ? hK.optLong("foreground_aiapp_last_time_local", 0L) : 0L;
        if (hK != null) {
            return hK.optLong("visit_duration", 0L) + (currentTimeMillis - optLong);
        }
        return 0L;
    }

    public static void Mk() {
        b(getAppId(), "visit_duration", Long.valueOf(Mj()));
    }

    public static void Ml() {
        b(getAppId(), "launch_count", Integer.valueOf(Mi() + 1));
    }

    public static void Mm() {
        b(getAppId(), "foreground_aiapp_last_time_local", Long.valueOf(System.currentTimeMillis()));
    }

    public static String getCurrentDate() {
        return e.a(e.LQ(), "yyyy-MM-dd");
    }

    public static boolean al(JSONObject jSONObject) {
        String currentDate = getCurrentDate();
        String optString = jSONObject.optString("date", "");
        return TextUtils.isEmpty(optString) || !optString.equals(currentDate);
    }

    public static JSONObject hK(String str) {
        JSONObject jSONObject;
        JSONException e;
        String string = com.baidu.swan.apps.storage.b.f.KL().getString("dailyInfo", "");
        if (DEBUG) {
            Log.i("SwanAppUserVisitInfoUtils", string);
        }
        try {
            JSONObject jSONObject2 = TextUtils.isEmpty(string) ? new JSONObject() : new JSONObject(string);
            if (al(jSONObject2)) {
                jSONObject2.put("date", getCurrentDate());
            }
            jSONObject = jSONObject2.optJSONObject(str);
            if (jSONObject == null) {
                try {
                    jSONObject2.put(str, new JSONObject());
                    com.baidu.swan.apps.storage.b.f.KL().putString("dailyInfo", jSONObject2.toString());
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

    public static void b(String str, String str2, Object obj) {
        JSONObject jSONObject;
        String string = com.baidu.swan.apps.storage.b.f.KL().getString("dailyInfo", "");
        if (DEBUG) {
            Log.i("SwanAppUserVisitInfoUtils", string);
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
            com.baidu.swan.apps.storage.b.f.KL().putString("dailyInfo", jSONObject.toString());
        } catch (JSONException e) {
            if (DEBUG) {
                Log.e("SwanAppUserVisitInfoUtils", e.getMessage());
            }
        }
    }

    private static String getAppId() {
        return com.baidu.swan.apps.ae.b.IX() != null ? com.baidu.swan.apps.ae.b.IX().id : "";
    }
}
