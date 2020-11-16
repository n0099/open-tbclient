package com.baidu.swan.apps.swancore.a;

import android.util.Log;
import com.baidu.swan.apps.b;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class a {
    private static final boolean DEBUG = b.DEBUG;
    private static JSONObject dzu;

    public static synchronized JSONObject aKp() {
        JSONObject jSONObject;
        synchronized (a.class) {
            if (dzu != null) {
                if (DEBUG) {
                    Log.d("SwanCoreConfigHelper", "return cache obj : " + dzu.toString());
                }
                jSONObject = dzu;
            } else {
                JSONObject rawSwitch = com.baidu.swan.apps.t.a.avV().getRawSwitch();
                if (rawSwitch == null) {
                    dzu = new JSONObject();
                    if (DEBUG) {
                        Log.d("SwanCoreConfigHelper", "raw switch is null, return empty obj");
                    }
                    jSONObject = dzu;
                } else {
                    Iterator<String> keys = rawSwitch.keys();
                    while (keys.hasNext()) {
                        if (!keys.next().startsWith("swanswitch")) {
                            keys.remove();
                        }
                    }
                    dzu = rawSwitch;
                    if (DEBUG) {
                        Log.d("SwanCoreConfigHelper", "return new obj : " + dzu.toString());
                    }
                    jSONObject = dzu;
                }
            }
        }
        return jSONObject;
    }

    public static synchronized void aKq() {
        synchronized (a.class) {
            if (DEBUG) {
                Log.d("SwanCoreConfigHelper", "release cache ab obj ");
            }
            dzu = null;
        }
    }

    public static JSONObject aKr() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("abTestSwitch", aKp());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
