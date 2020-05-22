package com.baidu.swan.apps.swancore.a;

import android.util.Log;
import com.baidu.swan.apps.b;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a {
    private static final boolean DEBUG = b.DEBUG;
    private static JSONObject cHm;

    public static synchronized JSONObject arT() {
        JSONObject jSONObject;
        synchronized (a.class) {
            if (cHm != null) {
                if (DEBUG) {
                    Log.d("SwanCoreConfigHelper", "return cache obj : " + cHm.toString());
                }
                jSONObject = cHm;
            } else {
                JSONObject rawSwitch = com.baidu.swan.apps.u.a.aeU().getRawSwitch();
                if (rawSwitch == null) {
                    cHm = new JSONObject();
                    if (DEBUG) {
                        Log.d("SwanCoreConfigHelper", "raw switch is null, return empty obj");
                    }
                    jSONObject = cHm;
                } else {
                    Iterator<String> keys = rawSwitch.keys();
                    while (keys.hasNext()) {
                        if (!keys.next().startsWith("swanswitch")) {
                            keys.remove();
                        }
                    }
                    cHm = rawSwitch;
                    if (DEBUG) {
                        Log.d("SwanCoreConfigHelper", "return new obj : " + cHm.toString());
                    }
                    jSONObject = cHm;
                }
            }
        }
        return jSONObject;
    }

    public static synchronized void arU() {
        synchronized (a.class) {
            if (DEBUG) {
                Log.d("SwanCoreConfigHelper", "release cache ab obj ");
            }
            cHm = null;
        }
    }

    public static JSONObject arV() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("abTestSwitch", arT());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
