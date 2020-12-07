package com.baidu.swan.apps.performance;

import android.util.Log;
import java.util.Date;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes25.dex */
public class e {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static JSONObject dos;

    public static void aGd() {
        try {
            dos = i.aGg().aGb();
            if (dos != null) {
                dos.put("_ts", com.baidu.swan.apps.ap.j.a(new Date(), "yyyy-MM-dd HH:mm:ss"));
            }
        } catch (JSONException e) {
            if (DEBUG) {
                Log.e("PerformanceUbcSnapshot", "JSONException:", e);
            }
        }
    }

    public static JSONObject aGe() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject aGb = i.aGg().aGb();
            if (aGb == null || !aGb.has("events")) {
                aGb = dos != null ? dos : jSONObject;
            }
            jSONObject = aGb;
        } catch (JSONException e) {
            if (DEBUG) {
                Log.e("PerformanceUbcSnapshot", "JSONException:", e);
            }
        }
        dos = null;
        return jSONObject;
    }
}
