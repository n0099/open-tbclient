package com.baidu.swan.apps.performance;

import android.util.Log;
import java.util.Date;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class e {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static JSONObject cGC;

    public static void avP() {
        try {
            cGC = i.avS().avN();
            if (cGC != null) {
                cGC.put("_ts", com.baidu.swan.apps.ap.j.a(new Date(), "yyyy-MM-dd HH:mm:ss"));
            }
        } catch (JSONException e) {
            if (DEBUG) {
                Log.e("PerformanceUbcSnapshot", "JSONException:", e);
            }
        }
    }

    public static JSONObject avQ() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject avN = i.avS().avN();
            if (avN == null || !avN.has("events")) {
                avN = cGC != null ? cGC : jSONObject;
            }
            jSONObject = avN;
        } catch (JSONException e) {
            if (DEBUG) {
                Log.e("PerformanceUbcSnapshot", "JSONException:", e);
            }
        }
        cGC = null;
        return jSONObject;
    }
}
