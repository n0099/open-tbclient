package com.baidu.swan.apps.performance;

import android.util.Log;
import java.util.Date;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class e {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static JSONObject cyE;

    public static void anU() {
        try {
            cyE = i.anX().anS();
            if (cyE != null) {
                cyE.put("_ts", com.baidu.swan.apps.aq.j.a(new Date(), "yyyy-MM-dd HH:mm:ss"));
            }
        } catch (JSONException e) {
            if (DEBUG) {
                Log.e("PerformanceUbcSnapshot", "JSONException:", e);
            }
        }
    }

    public static JSONObject anV() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject anS = i.anX().anS();
            if (anS == null || !anS.has("events")) {
                anS = cyE != null ? cyE : jSONObject;
            }
            jSONObject = anS;
        } catch (JSONException e) {
            if (DEBUG) {
                Log.e("PerformanceUbcSnapshot", "JSONException:", e);
            }
        }
        cyE = null;
        return jSONObject;
    }
}
