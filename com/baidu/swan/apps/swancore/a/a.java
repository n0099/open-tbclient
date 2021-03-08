package com.baidu.swan.apps.swancore.a;

import android.util.Log;
import com.baidu.swan.apps.b;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class a {
    private static final boolean DEBUG = b.DEBUG;
    private static JSONObject dNQ;

    public static synchronized JSONObject aMp() {
        JSONObject jSONObject;
        synchronized (a.class) {
            if (dNQ != null) {
                if (DEBUG) {
                    Log.d("SwanCoreConfigHelper", "return cache obj : " + dNQ.toString());
                }
                jSONObject = dNQ;
            } else {
                JSONObject rawSwitch = com.baidu.swan.apps.t.a.axc().getRawSwitch();
                if (rawSwitch == null) {
                    dNQ = new JSONObject();
                    if (DEBUG) {
                        Log.d("SwanCoreConfigHelper", "raw switch is null, return empty obj");
                    }
                    jSONObject = dNQ;
                } else {
                    Iterator<String> keys = rawSwitch.keys();
                    while (keys.hasNext()) {
                        if (!keys.next().startsWith("swanswitch")) {
                            keys.remove();
                        }
                    }
                    dNQ = rawSwitch;
                    if (DEBUG) {
                        Log.d("SwanCoreConfigHelper", "return new obj : " + dNQ.toString());
                    }
                    jSONObject = dNQ;
                }
            }
        }
        return jSONObject;
    }

    public static synchronized void aMq() {
        synchronized (a.class) {
            if (DEBUG) {
                Log.d("SwanCoreConfigHelper", "release cache ab obj ");
            }
            dNQ = null;
        }
    }

    public static JSONObject aMr() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("abTestSwitch", aMp());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
