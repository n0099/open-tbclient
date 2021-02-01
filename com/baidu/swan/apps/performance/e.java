package com.baidu.swan.apps.performance;

import android.util.Log;
import java.util.Date;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class e {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static JSONObject dqN;

    public static void aDY() {
        try {
            dqN = i.aEb().aDX();
            if (dqN != null) {
                dqN.put("_ts", com.baidu.swan.apps.ao.j.a(new Date(), "yyyy-MM-dd HH:mm:ss"));
            }
        } catch (JSONException e) {
            if (DEBUG) {
                Log.e("PerformanceUbcSnapshot", "JSONException:", e);
            }
        }
    }

    public static JSONObject aDZ() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject aDX = i.aEb().aDX();
            if (aDX == null || !aDX.has("events")) {
                aDX = dqN != null ? dqN : jSONObject;
            }
            jSONObject = aDX;
        } catch (JSONException e) {
            if (DEBUG) {
                Log.e("PerformanceUbcSnapshot", "JSONException:", e);
            }
        }
        dqN = null;
        return jSONObject;
    }
}
