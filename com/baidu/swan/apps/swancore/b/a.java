package com.baidu.swan.apps.swancore.b;

import android.util.Log;
import com.baidu.swan.apps.b;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a {
    private static final boolean DEBUG = b.DEBUG;
    private static JSONObject bWn;

    public static synchronized JSONObject afz() {
        JSONObject jSONObject;
        synchronized (a.class) {
            if (bWn != null) {
                if (DEBUG) {
                    Log.d("SwanCoreConfigHelper", "return cache obj : " + bWn.toString());
                }
                jSONObject = bWn;
            } else {
                JSONObject rawSwitch = com.baidu.swan.apps.w.a.Uc().getRawSwitch();
                if (rawSwitch == null) {
                    bWn = new JSONObject();
                    if (DEBUG) {
                        Log.d("SwanCoreConfigHelper", "raw switch is null, return empty obj");
                    }
                    jSONObject = bWn;
                } else {
                    Iterator<String> keys = rawSwitch.keys();
                    while (keys.hasNext()) {
                        if (!keys.next().startsWith("swanswitch")) {
                            keys.remove();
                        }
                    }
                    bWn = rawSwitch;
                    if (DEBUG) {
                        Log.d("SwanCoreConfigHelper", "return new obj : " + bWn.toString());
                    }
                    jSONObject = bWn;
                }
            }
        }
        return jSONObject;
    }

    public static synchronized void afA() {
        synchronized (a.class) {
            if (DEBUG) {
                Log.d("SwanCoreConfigHelper", "release cache ab obj ");
            }
            bWn = null;
        }
    }

    public static JSONObject afB() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("abTestSwitch", afz());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
