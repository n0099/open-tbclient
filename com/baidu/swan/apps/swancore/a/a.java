package com.baidu.swan.apps.swancore.a;

import android.util.Log;
import com.baidu.swan.apps.b;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class a {
    private static final boolean DEBUG = b.DEBUG;
    private static JSONObject dKl;

    public static synchronized JSONObject aLT() {
        JSONObject jSONObject;
        synchronized (a.class) {
            if (dKl != null) {
                if (DEBUG) {
                    Log.d("SwanCoreConfigHelper", "return cache obj : " + dKl.toString());
                }
                jSONObject = dKl;
            } else {
                JSONObject rawSwitch = com.baidu.swan.apps.t.a.awB().getRawSwitch();
                if (rawSwitch == null) {
                    dKl = new JSONObject();
                    if (DEBUG) {
                        Log.d("SwanCoreConfigHelper", "raw switch is null, return empty obj");
                    }
                    jSONObject = dKl;
                } else {
                    Iterator<String> keys = rawSwitch.keys();
                    while (keys.hasNext()) {
                        if (!keys.next().startsWith("swanswitch")) {
                            keys.remove();
                        }
                    }
                    dKl = rawSwitch;
                    if (DEBUG) {
                        Log.d("SwanCoreConfigHelper", "return new obj : " + dKl.toString());
                    }
                    jSONObject = dKl;
                }
            }
        }
        return jSONObject;
    }

    public static synchronized void aLU() {
        synchronized (a.class) {
            if (DEBUG) {
                Log.d("SwanCoreConfigHelper", "release cache ab obj ");
            }
            dKl = null;
        }
    }

    public static JSONObject aLV() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("abTestSwitch", aLT());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
