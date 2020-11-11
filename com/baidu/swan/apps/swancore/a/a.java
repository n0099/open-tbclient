package com.baidu.swan.apps.swancore.a;

import android.util.Log;
import com.baidu.swan.apps.b;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class a {
    private static final boolean DEBUG = b.DEBUG;
    private static JSONObject dBb;

    public static synchronized JSONObject aKX() {
        JSONObject jSONObject;
        synchronized (a.class) {
            if (dBb != null) {
                if (DEBUG) {
                    Log.d("SwanCoreConfigHelper", "return cache obj : " + dBb.toString());
                }
                jSONObject = dBb;
            } else {
                JSONObject rawSwitch = com.baidu.swan.apps.t.a.awD().getRawSwitch();
                if (rawSwitch == null) {
                    dBb = new JSONObject();
                    if (DEBUG) {
                        Log.d("SwanCoreConfigHelper", "raw switch is null, return empty obj");
                    }
                    jSONObject = dBb;
                } else {
                    Iterator<String> keys = rawSwitch.keys();
                    while (keys.hasNext()) {
                        if (!keys.next().startsWith("swanswitch")) {
                            keys.remove();
                        }
                    }
                    dBb = rawSwitch;
                    if (DEBUG) {
                        Log.d("SwanCoreConfigHelper", "return new obj : " + dBb.toString());
                    }
                    jSONObject = dBb;
                }
            }
        }
        return jSONObject;
    }

    public static synchronized void aKY() {
        synchronized (a.class) {
            if (DEBUG) {
                Log.d("SwanCoreConfigHelper", "release cache ab obj ");
            }
            dBb = null;
        }
    }

    public static JSONObject aKZ() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("abTestSwitch", aKX());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
