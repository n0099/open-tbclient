package com.baidu.swan.apps.performance;

import android.util.Log;
import java.util.Date;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class e {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static JSONObject doC;

    public static void aDD() {
        try {
            doC = i.aDG().aDB();
            if (doC != null) {
                doC.put("_ts", com.baidu.swan.apps.ao.j.a(new Date(), "yyyy-MM-dd HH:mm:ss"));
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
                aDB = doC != null ? doC : jSONObject;
            }
            jSONObject = aDB;
        } catch (JSONException e) {
            if (DEBUG) {
                Log.e("PerformanceUbcSnapshot", "JSONException:", e);
            }
        }
        doC = null;
        return jSONObject;
    }
}
