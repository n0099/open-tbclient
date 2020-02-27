package com.baidu.swan.apps.swancore.b;

import android.util.Log;
import com.baidu.swan.apps.b;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a {
    private static final boolean DEBUG = b.DEBUG;
    private static JSONObject bWa;

    public static synchronized JSONObject afu() {
        JSONObject jSONObject;
        synchronized (a.class) {
            if (bWa != null) {
                if (DEBUG) {
                    Log.d("SwanCoreConfigHelper", "return cache obj : " + bWa.toString());
                }
                jSONObject = bWa;
            } else {
                JSONObject rawSwitch = com.baidu.swan.apps.w.a.TX().getRawSwitch();
                if (rawSwitch == null) {
                    bWa = new JSONObject();
                    if (DEBUG) {
                        Log.d("SwanCoreConfigHelper", "raw switch is null, return empty obj");
                    }
                    jSONObject = bWa;
                } else {
                    Iterator<String> keys = rawSwitch.keys();
                    while (keys.hasNext()) {
                        if (!keys.next().startsWith("swanswitch")) {
                            keys.remove();
                        }
                    }
                    bWa = rawSwitch;
                    if (DEBUG) {
                        Log.d("SwanCoreConfigHelper", "return new obj : " + bWa.toString());
                    }
                    jSONObject = bWa;
                }
            }
        }
        return jSONObject;
    }

    public static synchronized void afv() {
        synchronized (a.class) {
            if (DEBUG) {
                Log.d("SwanCoreConfigHelper", "release cache ab obj ");
            }
            bWa = null;
        }
    }

    public static JSONObject afw() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("abTestSwitch", afu());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
