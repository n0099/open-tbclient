package com.baidu.swan.apps.swancore.b;

import android.util.Log;
import com.baidu.swan.apps.b;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a {
    private static final boolean DEBUG = b.DEBUG;
    private static JSONObject cvk;

    public static synchronized JSONObject anD() {
        JSONObject jSONObject;
        synchronized (a.class) {
            if (cvk != null) {
                if (DEBUG) {
                    Log.d("SwanCoreConfigHelper", "return cache obj : " + cvk.toString());
                }
                jSONObject = cvk;
            } else {
                JSONObject rawSwitch = com.baidu.swan.apps.w.a.abQ().getRawSwitch();
                if (rawSwitch == null) {
                    cvk = new JSONObject();
                    if (DEBUG) {
                        Log.d("SwanCoreConfigHelper", "raw switch is null, return empty obj");
                    }
                    jSONObject = cvk;
                } else {
                    Iterator<String> keys = rawSwitch.keys();
                    while (keys.hasNext()) {
                        if (!keys.next().startsWith("swanswitch")) {
                            keys.remove();
                        }
                    }
                    cvk = rawSwitch;
                    if (DEBUG) {
                        Log.d("SwanCoreConfigHelper", "return new obj : " + cvk.toString());
                    }
                    jSONObject = cvk;
                }
            }
        }
        return jSONObject;
    }

    public static synchronized void anE() {
        synchronized (a.class) {
            if (DEBUG) {
                Log.d("SwanCoreConfigHelper", "release cache ab obj ");
            }
            cvk = null;
        }
    }

    public static JSONObject anF() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("abTestSwitch", anD());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
