package com.baidu.swan.apps.performance;

import android.util.Log;
import java.util.Date;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class e {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static JSONObject dtr;

    public static void aHw() {
        try {
            dtr = i.aHz().aHu();
            if (dtr != null) {
                dtr.put("_ts", com.baidu.swan.apps.ao.j.a(new Date(), "yyyy-MM-dd HH:mm:ss"));
            }
        } catch (JSONException e) {
            if (DEBUG) {
                Log.e("PerformanceUbcSnapshot", "JSONException:", e);
            }
        }
    }

    public static JSONObject aHx() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject aHu = i.aHz().aHu();
            if (aHu == null || !aHu.has("events")) {
                aHu = dtr != null ? dtr : jSONObject;
            }
            jSONObject = aHu;
        } catch (JSONException e) {
            if (DEBUG) {
                Log.e("PerformanceUbcSnapshot", "JSONException:", e);
            }
        }
        dtr = null;
        return jSONObject;
    }
}
