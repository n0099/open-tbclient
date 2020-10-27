package com.baidu.swan.apps.performance;

import android.util.Log;
import java.util.Date;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class e {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static JSONObject dde;

    public static void aBd() {
        try {
            dde = i.aBg().aBb();
            if (dde != null) {
                dde.put("_ts", com.baidu.swan.apps.ap.j.a(new Date(), "yyyy-MM-dd HH:mm:ss"));
            }
        } catch (JSONException e) {
            if (DEBUG) {
                Log.e("PerformanceUbcSnapshot", "JSONException:", e);
            }
        }
    }

    public static JSONObject aBe() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject aBb = i.aBg().aBb();
            if (aBb == null || !aBb.has("events")) {
                aBb = dde != null ? dde : jSONObject;
            }
            jSONObject = aBb;
        } catch (JSONException e) {
            if (DEBUG) {
                Log.e("PerformanceUbcSnapshot", "JSONException:", e);
            }
        }
        dde = null;
        return jSONObject;
    }
}
