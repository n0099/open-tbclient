package com.baidu.swan.apps.performance;

import android.util.Log;
import java.util.Date;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class e {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static JSONObject dsp;

    public static void aEb() {
        try {
            dsp = i.aEe().aEa();
            if (dsp != null) {
                dsp.put("_ts", com.baidu.swan.apps.ao.j.a(new Date(), "yyyy-MM-dd HH:mm:ss"));
            }
        } catch (JSONException e) {
            if (DEBUG) {
                Log.e("PerformanceUbcSnapshot", "JSONException:", e);
            }
        }
    }

    public static JSONObject aEc() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject aEa = i.aEe().aEa();
            if (aEa == null || !aEa.has("events")) {
                aEa = dsp != null ? dsp : jSONObject;
            }
            jSONObject = aEa;
        } catch (JSONException e) {
            if (DEBUG) {
                Log.e("PerformanceUbcSnapshot", "JSONException:", e);
            }
        }
        dsp = null;
        return jSONObject;
    }
}
