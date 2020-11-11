package com.baidu.swan.apps.performance;

import android.util.Log;
import java.util.Date;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class e {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static JSONObject djb;

    public static void aDD() {
        try {
            djb = i.aDG().aDB();
            if (djb != null) {
                djb.put("_ts", com.baidu.swan.apps.ap.j.a(new Date(), "yyyy-MM-dd HH:mm:ss"));
            }
        } catch (JSONException e) {
            if (DEBUG) {
                Log.e("PerformanceUbcSnapshot", "JSONException:", e);
            }
        }
    }

    public static JSONObject aDE() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject aDB = i.aDG().aDB();
            if (aDB == null || !aDB.has("events")) {
                aDB = djb != null ? djb : jSONObject;
            }
            jSONObject = aDB;
        } catch (JSONException e) {
            if (DEBUG) {
                Log.e("PerformanceUbcSnapshot", "JSONException:", e);
            }
        }
        djb = null;
        return jSONObject;
    }
}
