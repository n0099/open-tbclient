package com.baidu.swan.apps.performance;

import android.util.Log;
import java.util.Date;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static JSONObject cwq;

    public static void amA() {
        try {
            cwq = g.amD().amy();
            if (cwq != null) {
                cwq.put("_ts", com.baidu.swan.apps.aq.i.a(new Date(), "yyyy-MM-dd HH:mm:ss"));
            }
        } catch (JSONException e) {
            if (DEBUG) {
                Log.e("PerformanceUbcSnapshot", "JSONException:", e);
            }
        }
    }

    public static JSONObject amB() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject amy = g.amD().amy();
            if (amy == null || !amy.has("events")) {
                amy = cwq != null ? cwq : jSONObject;
            }
            jSONObject = amy;
        } catch (JSONException e) {
            if (DEBUG) {
                Log.e("PerformanceUbcSnapshot", "JSONException:", e);
            }
        }
        cwq = null;
        return jSONObject;
    }
}
