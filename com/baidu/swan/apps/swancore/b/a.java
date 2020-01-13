package com.baidu.swan.apps.swancore.b;

import android.util.Log;
import com.baidu.swan.apps.b;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class a {
    private static final boolean DEBUG = b.DEBUG;
    private static JSONObject bRW;

    public static synchronized JSONObject adg() {
        JSONObject jSONObject;
        synchronized (a.class) {
            if (bRW != null) {
                if (DEBUG) {
                    Log.d("SwanCoreConfigHelper", "return cache obj : " + bRW.toString());
                }
                jSONObject = bRW;
            } else {
                JSONObject rawSwitch = com.baidu.swan.apps.w.a.RJ().getRawSwitch();
                if (rawSwitch == null) {
                    bRW = new JSONObject();
                    if (DEBUG) {
                        Log.d("SwanCoreConfigHelper", "raw switch is null, return empty obj");
                    }
                    jSONObject = bRW;
                } else {
                    Iterator<String> keys = rawSwitch.keys();
                    while (keys.hasNext()) {
                        if (!keys.next().startsWith("swanswitch")) {
                            keys.remove();
                        }
                    }
                    bRW = rawSwitch;
                    if (DEBUG) {
                        Log.d("SwanCoreConfigHelper", "return new obj : " + bRW.toString());
                    }
                    jSONObject = bRW;
                }
            }
        }
        return jSONObject;
    }

    public static synchronized void adh() {
        synchronized (a.class) {
            if (DEBUG) {
                Log.d("SwanCoreConfigHelper", "release cache ab obj ");
            }
            bRW = null;
        }
    }

    public static JSONObject adi() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("abTestSwitch", adg());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
