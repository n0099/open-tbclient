package com.baidu.swan.apps.performance;

import android.util.Log;
import java.util.Date;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class e {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static JSONObject dhr;

    public static void aCV() {
        try {
            dhr = i.aCY().aCT();
            if (dhr != null) {
                dhr.put("_ts", com.baidu.swan.apps.ap.j.a(new Date(), "yyyy-MM-dd HH:mm:ss"));
            }
        } catch (JSONException e) {
            if (DEBUG) {
                Log.e("PerformanceUbcSnapshot", "JSONException:", e);
            }
        }
    }

    public static JSONObject aCW() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject aCT = i.aCY().aCT();
            if (aCT == null || !aCT.has("events")) {
                aCT = dhr != null ? dhr : jSONObject;
            }
            jSONObject = aCT;
        } catch (JSONException e) {
            if (DEBUG) {
                Log.e("PerformanceUbcSnapshot", "JSONException:", e);
            }
        }
        dhr = null;
        return jSONObject;
    }
}
