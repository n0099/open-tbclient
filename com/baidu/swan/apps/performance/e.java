package com.baidu.swan.apps.performance;

import android.util.Log;
import java.util.Date;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class e {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static JSONObject cGy;

    public static void avP() {
        try {
            cGy = i.avS().avN();
            if (cGy != null) {
                cGy.put("_ts", com.baidu.swan.apps.ap.j.a(new Date(), "yyyy-MM-dd HH:mm:ss"));
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
                avN = cGy != null ? cGy : jSONObject;
            }
            jSONObject = avN;
        } catch (JSONException e) {
            if (DEBUG) {
                Log.e("PerformanceUbcSnapshot", "JSONException:", e);
            }
        }
        cGy = null;
        return jSONObject;
    }
}
