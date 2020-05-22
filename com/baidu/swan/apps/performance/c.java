package com.baidu.swan.apps.performance;

import android.util.Log;
import java.util.Date;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static JSONObject crC;

    public static void alu() {
        try {
            crC = g.alx().als();
            if (crC != null) {
                crC.put("_ts", com.baidu.swan.apps.aq.i.a(new Date(), "yyyy-MM-dd HH:mm:ss"));
            }
        } catch (JSONException e) {
            if (DEBUG) {
                Log.e("PerformanceUbcSnapshot", "JSONException:", e);
            }
        }
    }

    public static JSONObject alv() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject als = g.alx().als();
            if (als == null || !als.has("events")) {
                als = crC != null ? crC : jSONObject;
            }
            jSONObject = als;
        } catch (JSONException e) {
            if (DEBUG) {
                Log.e("PerformanceUbcSnapshot", "JSONException:", e);
            }
        }
        crC = null;
        return jSONObject;
    }
}
