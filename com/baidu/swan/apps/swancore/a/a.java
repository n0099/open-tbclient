package com.baidu.swan.apps.swancore.a;

import android.util.Log;
import com.baidu.swan.apps.b;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class a {
    private static final boolean DEBUG = b.DEBUG;
    private static JSONObject dmH;

    public static synchronized JSONObject aGD() {
        JSONObject jSONObject;
        synchronized (a.class) {
            if (dmH != null) {
                if (DEBUG) {
                    Log.d("SwanCoreConfigHelper", "return cache obj : " + dmH.toString());
                }
                jSONObject = dmH;
            } else {
                JSONObject rawSwitch = com.baidu.swan.apps.t.a.asi().getRawSwitch();
                if (rawSwitch == null) {
                    dmH = new JSONObject();
                    if (DEBUG) {
                        Log.d("SwanCoreConfigHelper", "raw switch is null, return empty obj");
                    }
                    jSONObject = dmH;
                } else {
                    Iterator<String> keys = rawSwitch.keys();
                    while (keys.hasNext()) {
                        if (!keys.next().startsWith("swanswitch")) {
                            keys.remove();
                        }
                    }
                    dmH = rawSwitch;
                    if (DEBUG) {
                        Log.d("SwanCoreConfigHelper", "return new obj : " + dmH.toString());
                    }
                    jSONObject = dmH;
                }
            }
        }
        return jSONObject;
    }

    public static synchronized void aGE() {
        synchronized (a.class) {
            if (DEBUG) {
                Log.d("SwanCoreConfigHelper", "release cache ab obj ");
            }
            dmH = null;
        }
    }

    public static JSONObject aGF() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("abTestSwitch", aGD());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
