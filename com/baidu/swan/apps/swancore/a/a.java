package com.baidu.swan.apps.swancore.a;

import android.util.Log;
import com.baidu.swan.apps.b;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class a {
    private static final boolean DEBUG = b.DEBUG;
    private static JSONObject cYx;

    public static synchronized JSONObject aDk() {
        JSONObject jSONObject;
        synchronized (a.class) {
            if (cYx != null) {
                if (DEBUG) {
                    Log.d("SwanCoreConfigHelper", "return cache obj : " + cYx.toString());
                }
                jSONObject = cYx;
            } else {
                JSONObject rawSwitch = com.baidu.swan.apps.t.a.aoM().getRawSwitch();
                if (rawSwitch == null) {
                    cYx = new JSONObject();
                    if (DEBUG) {
                        Log.d("SwanCoreConfigHelper", "raw switch is null, return empty obj");
                    }
                    jSONObject = cYx;
                } else {
                    Iterator<String> keys = rawSwitch.keys();
                    while (keys.hasNext()) {
                        if (!keys.next().startsWith("swanswitch")) {
                            keys.remove();
                        }
                    }
                    cYx = rawSwitch;
                    if (DEBUG) {
                        Log.d("SwanCoreConfigHelper", "return new obj : " + cYx.toString());
                    }
                    jSONObject = cYx;
                }
            }
        }
        return jSONObject;
    }

    public static synchronized void aDl() {
        synchronized (a.class) {
            if (DEBUG) {
                Log.d("SwanCoreConfigHelper", "release cache ab obj ");
            }
            cYx = null;
        }
    }

    public static JSONObject aDm() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("abTestSwitch", aDk());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
