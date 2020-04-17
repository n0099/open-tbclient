package com.baidu.swan.apps.swancore.b;

import android.util.Log;
import com.baidu.swan.apps.b;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a {
    private static final boolean DEBUG = b.DEBUG;
    private static JSONObject cve;

    public static synchronized JSONObject anE() {
        JSONObject jSONObject;
        synchronized (a.class) {
            if (cve != null) {
                if (DEBUG) {
                    Log.d("SwanCoreConfigHelper", "return cache obj : " + cve.toString());
                }
                jSONObject = cve;
            } else {
                JSONObject rawSwitch = com.baidu.swan.apps.w.a.abR().getRawSwitch();
                if (rawSwitch == null) {
                    cve = new JSONObject();
                    if (DEBUG) {
                        Log.d("SwanCoreConfigHelper", "raw switch is null, return empty obj");
                    }
                    jSONObject = cve;
                } else {
                    Iterator<String> keys = rawSwitch.keys();
                    while (keys.hasNext()) {
                        if (!keys.next().startsWith("swanswitch")) {
                            keys.remove();
                        }
                    }
                    cve = rawSwitch;
                    if (DEBUG) {
                        Log.d("SwanCoreConfigHelper", "return new obj : " + cve.toString());
                    }
                    jSONObject = cve;
                }
            }
        }
        return jSONObject;
    }

    public static synchronized void anF() {
        synchronized (a.class) {
            if (DEBUG) {
                Log.d("SwanCoreConfigHelper", "release cache ab obj ");
            }
            cve = null;
        }
    }

    public static JSONObject anG() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("abTestSwitch", anE());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
