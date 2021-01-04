package com.baidu.swan.apps.swancore.a;

import android.util.Log;
import com.baidu.swan.apps.b;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class a {
    private static final boolean DEBUG = b.DEBUG;
    private static JSONObject dOX;

    public static synchronized JSONObject aPM() {
        JSONObject jSONObject;
        synchronized (a.class) {
            if (dOX != null) {
                if (DEBUG) {
                    Log.d("SwanCoreConfigHelper", "return cache obj : " + dOX.toString());
                }
                jSONObject = dOX;
            } else {
                JSONObject rawSwitch = com.baidu.swan.apps.t.a.aAu().getRawSwitch();
                if (rawSwitch == null) {
                    dOX = new JSONObject();
                    if (DEBUG) {
                        Log.d("SwanCoreConfigHelper", "raw switch is null, return empty obj");
                    }
                    jSONObject = dOX;
                } else {
                    Iterator<String> keys = rawSwitch.keys();
                    while (keys.hasNext()) {
                        if (!keys.next().startsWith("swanswitch")) {
                            keys.remove();
                        }
                    }
                    dOX = rawSwitch;
                    if (DEBUG) {
                        Log.d("SwanCoreConfigHelper", "return new obj : " + dOX.toString());
                    }
                    jSONObject = dOX;
                }
            }
        }
        return jSONObject;
    }

    public static synchronized void aPN() {
        synchronized (a.class) {
            if (DEBUG) {
                Log.d("SwanCoreConfigHelper", "release cache ab obj ");
            }
            dOX = null;
        }
    }

    public static JSONObject aPO() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("abTestSwitch", aPM());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
