package com.baidu.swan.apps.swancore.a;

import android.util.Log;
import com.baidu.swan.apps.b;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class a {
    private static final boolean DEBUG = b.DEBUG;
    private static JSONObject dvj;

    public static synchronized JSONObject aIx() {
        JSONObject jSONObject;
        synchronized (a.class) {
            if (dvj != null) {
                if (DEBUG) {
                    Log.d("SwanCoreConfigHelper", "return cache obj : " + dvj.toString());
                }
                jSONObject = dvj;
            } else {
                JSONObject rawSwitch = com.baidu.swan.apps.t.a.aud().getRawSwitch();
                if (rawSwitch == null) {
                    dvj = new JSONObject();
                    if (DEBUG) {
                        Log.d("SwanCoreConfigHelper", "raw switch is null, return empty obj");
                    }
                    jSONObject = dvj;
                } else {
                    Iterator<String> keys = rawSwitch.keys();
                    while (keys.hasNext()) {
                        if (!keys.next().startsWith("swanswitch")) {
                            keys.remove();
                        }
                    }
                    dvj = rawSwitch;
                    if (DEBUG) {
                        Log.d("SwanCoreConfigHelper", "return new obj : " + dvj.toString());
                    }
                    jSONObject = dvj;
                }
            }
        }
        return jSONObject;
    }

    public static synchronized void aIy() {
        synchronized (a.class) {
            if (DEBUG) {
                Log.d("SwanCoreConfigHelper", "release cache ab obj ");
            }
            dvj = null;
        }
    }

    public static JSONObject aIz() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("abTestSwitch", aIx());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
