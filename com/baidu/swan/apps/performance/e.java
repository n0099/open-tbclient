package com.baidu.swan.apps.performance;

import android.util.Log;
import java.util.Date;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class e {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static JSONObject cUF;

    public static void azj() {
        try {
            cUF = i.azm().azh();
            if (cUF != null) {
                cUF.put("_ts", com.baidu.swan.apps.ap.j.a(new Date(), "yyyy-MM-dd HH:mm:ss"));
            }
        } catch (JSONException e) {
            if (DEBUG) {
                Log.e("PerformanceUbcSnapshot", "JSONException:", e);
            }
        }
    }

    public static JSONObject azk() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject azh = i.azm().azh();
            if (azh == null || !azh.has("events")) {
                azh = cUF != null ? cUF : jSONObject;
            }
            jSONObject = azh;
        } catch (JSONException e) {
            if (DEBUG) {
                Log.e("PerformanceUbcSnapshot", "JSONException:", e);
            }
        }
        cUF = null;
        return jSONObject;
    }
}
