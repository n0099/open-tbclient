package com.baidu.swan.apps.swancore.a;

import android.util.Log;
import com.baidu.swan.apps.b;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class a {
    private static final boolean DEBUG = b.DEBUG;
    private static JSONObject cPr;

    public static synchronized JSONObject avb() {
        JSONObject jSONObject;
        synchronized (a.class) {
            if (cPr != null) {
                if (DEBUG) {
                    Log.d("SwanCoreConfigHelper", "return cache obj : " + cPr.toString());
                }
                jSONObject = cPr;
            } else {
                JSONObject rawSwitch = com.baidu.swan.apps.t.a.ahm().getRawSwitch();
                if (rawSwitch == null) {
                    cPr = new JSONObject();
                    if (DEBUG) {
                        Log.d("SwanCoreConfigHelper", "raw switch is null, return empty obj");
                    }
                    jSONObject = cPr;
                } else {
                    Iterator<String> keys = rawSwitch.keys();
                    while (keys.hasNext()) {
                        if (!keys.next().startsWith("swanswitch")) {
                            keys.remove();
                        }
                    }
                    cPr = rawSwitch;
                    if (DEBUG) {
                        Log.d("SwanCoreConfigHelper", "return new obj : " + cPr.toString());
                    }
                    jSONObject = cPr;
                }
            }
        }
        return jSONObject;
    }

    public static synchronized void avc() {
        synchronized (a.class) {
            if (DEBUG) {
                Log.d("SwanCoreConfigHelper", "release cache ab obj ");
            }
            cPr = null;
        }
    }

    public static JSONObject avd() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("abTestSwitch", avb());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
