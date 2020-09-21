package com.baidu.swan.apps.swancore.a;

import android.util.Log;
import com.baidu.swan.apps.b;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {
    private static final boolean DEBUG = b.DEBUG;
    private static JSONObject daz;

    public static synchronized JSONObject aDU() {
        JSONObject jSONObject;
        synchronized (a.class) {
            if (daz != null) {
                if (DEBUG) {
                    Log.d("SwanCoreConfigHelper", "return cache obj : " + daz.toString());
                }
                jSONObject = daz;
            } else {
                JSONObject rawSwitch = com.baidu.swan.apps.t.a.apx().getRawSwitch();
                if (rawSwitch == null) {
                    daz = new JSONObject();
                    if (DEBUG) {
                        Log.d("SwanCoreConfigHelper", "raw switch is null, return empty obj");
                    }
                    jSONObject = daz;
                } else {
                    Iterator<String> keys = rawSwitch.keys();
                    while (keys.hasNext()) {
                        if (!keys.next().startsWith("swanswitch")) {
                            keys.remove();
                        }
                    }
                    daz = rawSwitch;
                    if (DEBUG) {
                        Log.d("SwanCoreConfigHelper", "return new obj : " + daz.toString());
                    }
                    jSONObject = daz;
                }
            }
        }
        return jSONObject;
    }

    public static synchronized void aDV() {
        synchronized (a.class) {
            if (DEBUG) {
                Log.d("SwanCoreConfigHelper", "release cache ab obj ");
            }
            daz = null;
        }
    }

    public static JSONObject aDW() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("abTestSwitch", aDU());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
