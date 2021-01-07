package com.baidu.swan.apps.performance;

import android.util.Log;
import java.util.Date;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class e {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static JSONObject dtr;

    public static void aHx() {
        try {
            dtr = i.aHA().aHv();
            if (dtr != null) {
                dtr.put("_ts", com.baidu.swan.apps.ao.j.a(new Date(), "yyyy-MM-dd HH:mm:ss"));
            }
        } catch (JSONException e) {
            if (DEBUG) {
                Log.e("PerformanceUbcSnapshot", "JSONException:", e);
            }
        }
    }

    public static JSONObject aHy() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject aHv = i.aHA().aHv();
            if (aHv == null || !aHv.has("events")) {
                aHv = dtr != null ? dtr : jSONObject;
            }
            jSONObject = aHv;
        } catch (JSONException e) {
            if (DEBUG) {
                Log.e("PerformanceUbcSnapshot", "JSONException:", e);
            }
        }
        dtr = null;
        return jSONObject;
    }
}
