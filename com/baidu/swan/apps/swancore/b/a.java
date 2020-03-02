package com.baidu.swan.apps.swancore.b;

import android.util.Log;
import com.baidu.swan.apps.b;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a {
    private static final boolean DEBUG = b.DEBUG;
    private static JSONObject bWb;

    public static synchronized JSONObject afw() {
        JSONObject jSONObject;
        synchronized (a.class) {
            if (bWb != null) {
                if (DEBUG) {
                    Log.d("SwanCoreConfigHelper", "return cache obj : " + bWb.toString());
                }
                jSONObject = bWb;
            } else {
                JSONObject rawSwitch = com.baidu.swan.apps.w.a.TZ().getRawSwitch();
                if (rawSwitch == null) {
                    bWb = new JSONObject();
                    if (DEBUG) {
                        Log.d("SwanCoreConfigHelper", "raw switch is null, return empty obj");
                    }
                    jSONObject = bWb;
                } else {
                    Iterator<String> keys = rawSwitch.keys();
                    while (keys.hasNext()) {
                        if (!keys.next().startsWith("swanswitch")) {
                            keys.remove();
                        }
                    }
                    bWb = rawSwitch;
                    if (DEBUG) {
                        Log.d("SwanCoreConfigHelper", "return new obj : " + bWb.toString());
                    }
                    jSONObject = bWb;
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
            bWb = null;
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
