package com.baidu.swan.apps.swancore.a;

import android.util.Log;
import com.baidu.swan.apps.b;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class a {
    private static final boolean DEBUG = b.DEBUG;
    private static JSONObject dMp;

    public static synchronized JSONObject aMm() {
        JSONObject jSONObject;
        synchronized (a.class) {
            if (dMp != null) {
                if (DEBUG) {
                    Log.d("SwanCoreConfigHelper", "return cache obj : " + dMp.toString());
                }
                jSONObject = dMp;
            } else {
                JSONObject rawSwitch = com.baidu.swan.apps.t.a.awZ().getRawSwitch();
                if (rawSwitch == null) {
                    dMp = new JSONObject();
                    if (DEBUG) {
                        Log.d("SwanCoreConfigHelper", "raw switch is null, return empty obj");
                    }
                    jSONObject = dMp;
                } else {
                    Iterator<String> keys = rawSwitch.keys();
                    while (keys.hasNext()) {
                        if (!keys.next().startsWith("swanswitch")) {
                            keys.remove();
                        }
                    }
                    dMp = rawSwitch;
                    if (DEBUG) {
                        Log.d("SwanCoreConfigHelper", "return new obj : " + dMp.toString());
                    }
                    jSONObject = dMp;
                }
            }
        }
        return jSONObject;
    }

    public static synchronized void aMn() {
        synchronized (a.class) {
            if (DEBUG) {
                Log.d("SwanCoreConfigHelper", "release cache ab obj ");
            }
            dMp = null;
        }
    }

    public static JSONObject aMo() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("abTestSwitch", aMm());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
