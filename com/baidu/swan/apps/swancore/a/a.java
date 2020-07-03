package com.baidu.swan.apps.swancore.a;

import android.util.Log;
import com.baidu.swan.apps.b;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a {
    private static final boolean DEBUG = b.DEBUG;
    private static JSONObject cLW;

    public static synchronized JSONObject ata() {
        JSONObject jSONObject;
        synchronized (a.class) {
            if (cLW != null) {
                if (DEBUG) {
                    Log.d("SwanCoreConfigHelper", "return cache obj : " + cLW.toString());
                }
                jSONObject = cLW;
            } else {
                JSONObject rawSwitch = com.baidu.swan.apps.u.a.aga().getRawSwitch();
                if (rawSwitch == null) {
                    cLW = new JSONObject();
                    if (DEBUG) {
                        Log.d("SwanCoreConfigHelper", "raw switch is null, return empty obj");
                    }
                    jSONObject = cLW;
                } else {
                    Iterator<String> keys = rawSwitch.keys();
                    while (keys.hasNext()) {
                        if (!keys.next().startsWith("swanswitch")) {
                            keys.remove();
                        }
                    }
                    cLW = rawSwitch;
                    if (DEBUG) {
                        Log.d("SwanCoreConfigHelper", "return new obj : " + cLW.toString());
                    }
                    jSONObject = cLW;
                }
            }
        }
        return jSONObject;
    }

    public static synchronized void atb() {
        synchronized (a.class) {
            if (DEBUG) {
                Log.d("SwanCoreConfigHelper", "release cache ab obj ");
            }
            cLW = null;
        }
    }

    public static JSONObject atc() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("abTestSwitch", ata());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
