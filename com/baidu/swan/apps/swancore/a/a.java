package com.baidu.swan.apps.swancore.a;

import android.util.Log;
import com.baidu.swan.apps.b;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes25.dex */
public class a {
    private static final boolean DEBUG = b.DEBUG;
    private static JSONObject dGt;

    public static synchronized JSONObject aNw() {
        JSONObject jSONObject;
        synchronized (a.class) {
            if (dGt != null) {
                if (DEBUG) {
                    Log.d("SwanCoreConfigHelper", "return cache obj : " + dGt.toString());
                }
                jSONObject = dGt;
            } else {
                JSONObject rawSwitch = com.baidu.swan.apps.t.a.azd().getRawSwitch();
                if (rawSwitch == null) {
                    dGt = new JSONObject();
                    if (DEBUG) {
                        Log.d("SwanCoreConfigHelper", "raw switch is null, return empty obj");
                    }
                    jSONObject = dGt;
                } else {
                    Iterator<String> keys = rawSwitch.keys();
                    while (keys.hasNext()) {
                        if (!keys.next().startsWith("swanswitch")) {
                            keys.remove();
                        }
                    }
                    dGt = rawSwitch;
                    if (DEBUG) {
                        Log.d("SwanCoreConfigHelper", "return new obj : " + dGt.toString());
                    }
                    jSONObject = dGt;
                }
            }
        }
        return jSONObject;
    }

    public static synchronized void aNx() {
        synchronized (a.class) {
            if (DEBUG) {
                Log.d("SwanCoreConfigHelper", "release cache ab obj ");
            }
            dGt = null;
        }
    }

    public static JSONObject aNy() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("abTestSwitch", aNw());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
