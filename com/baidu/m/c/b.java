package com.baidu.m.c;

import android.text.TextUtils;
import android.util.Log;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public static void f(String str, String str2, JSONObject jSONObject) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || jSONObject == null) {
            if (DEBUG) {
                Log.e("RTCEventCallback", "dispatchStateChangeEvent failed slaveId: " + str + " ,rtcId: " + str2);
                return;
            }
            return;
        }
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.putOpt("info", jSONObject);
            String jSONObject3 = jSONObject2.toString();
            if (!TextUtils.isEmpty(jSONObject3)) {
                JSONObject jSONObject4 = new JSONObject();
                try {
                    jSONObject4.put("lType", "statechange");
                    jSONObject4.put("rtcId", str2);
                    jSONObject4.put("data", jSONObject3);
                    jSONObject4.put("wvID", str);
                } catch (JSONException e) {
                    if (DEBUG) {
                        e.printStackTrace();
                    }
                }
                com.baidu.swan.apps.view.b.b.a.a(str, str2, "RTC", "statechange", jSONObject4);
            }
        } catch (JSONException e2) {
            if (DEBUG) {
                Log.d("RTCEventCallback", Log.getStackTraceString(e2));
            }
        }
    }
}
