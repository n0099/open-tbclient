package com.baidu.swan.apps.swancore.b;

import android.util.Log;
import com.baidu.swan.apps.b;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class a {
    private static final boolean DEBUG = b.DEBUG;
    private static JSONObject bRm;

    public static synchronized JSONObject acJ() {
        JSONObject jSONObject;
        synchronized (a.class) {
            if (bRm != null) {
                if (DEBUG) {
                    Log.d("SwanCoreConfigHelper", "return cache obj : " + bRm.toString());
                }
                jSONObject = bRm;
            } else {
                JSONObject rawSwitch = com.baidu.swan.apps.w.a.Rn().getRawSwitch();
                if (rawSwitch == null) {
                    bRm = new JSONObject();
                    if (DEBUG) {
                        Log.d("SwanCoreConfigHelper", "raw switch is null, return empty obj");
                    }
                    jSONObject = bRm;
                } else {
                    Iterator<String> keys = rawSwitch.keys();
                    while (keys.hasNext()) {
                        if (!keys.next().startsWith("swanswitch")) {
                            keys.remove();
                        }
                    }
                    bRm = rawSwitch;
                    if (DEBUG) {
                        Log.d("SwanCoreConfigHelper", "return new obj : " + bRm.toString());
                    }
                    jSONObject = bRm;
                }
            }
        }
        return jSONObject;
    }

    public static synchronized void acK() {
        synchronized (a.class) {
            if (DEBUG) {
                Log.d("SwanCoreConfigHelper", "release cache ab obj ");
            }
            bRm = null;
        }
    }

    public static JSONObject acL() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("abTestSwitch", acJ());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
