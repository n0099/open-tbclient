package com.baidu.swan.apps.swancore.b;

import android.util.Log;
import com.baidu.swan.apps.b;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a {
    private static final boolean DEBUG = b.DEBUG;
    private static JSONObject bWc;

    public static synchronized JSONObject afw() {
        JSONObject jSONObject;
        synchronized (a.class) {
            if (bWc != null) {
                if (DEBUG) {
                    Log.d("SwanCoreConfigHelper", "return cache obj : " + bWc.toString());
                }
                jSONObject = bWc;
            } else {
                JSONObject rawSwitch = com.baidu.swan.apps.w.a.TZ().getRawSwitch();
                if (rawSwitch == null) {
                    bWc = new JSONObject();
                    if (DEBUG) {
                        Log.d("SwanCoreConfigHelper", "raw switch is null, return empty obj");
                    }
                    jSONObject = bWc;
                } else {
                    Iterator<String> keys = rawSwitch.keys();
                    while (keys.hasNext()) {
                        if (!keys.next().startsWith("swanswitch")) {
                            keys.remove();
                        }
                    }
                    bWc = rawSwitch;
                    if (DEBUG) {
                        Log.d("SwanCoreConfigHelper", "return new obj : " + bWc.toString());
                    }
                    jSONObject = bWc;
                }
            }
        }
        return jSONObject;
    }

    public static synchronized void afx() {
        synchronized (a.class) {
            if (DEBUG) {
                Log.d("SwanCoreConfigHelper", "release cache ab obj ");
            }
            bWc = null;
        }
    }

    public static JSONObject afy() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("abTestSwitch", afw());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
