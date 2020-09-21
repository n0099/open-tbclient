package com.baidu.swan.apps.performance;

import android.util.Log;
import java.util.Date;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class e {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static JSONObject cIC;

    public static void awy() {
        try {
            cIC = i.awB().aww();
            if (cIC != null) {
                cIC.put("_ts", com.baidu.swan.apps.ap.j.a(new Date(), "yyyy-MM-dd HH:mm:ss"));
            }
        } catch (JSONException e) {
            if (DEBUG) {
                Log.e("PerformanceUbcSnapshot", "JSONException:", e);
            }
        }
    }

    public static JSONObject awz() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject aww = i.awB().aww();
            if (aww == null || !aww.has("events")) {
                aww = cIC != null ? cIC : jSONObject;
            }
            jSONObject = aww;
        } catch (JSONException e) {
            if (DEBUG) {
                Log.e("PerformanceUbcSnapshot", "JSONException:", e);
            }
        }
        cIC = null;
        return jSONObject;
    }
}
