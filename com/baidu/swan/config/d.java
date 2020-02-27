package com.baidu.swan.config;

import android.util.Log;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.swan.config.core.ConfigNode;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class d {
    public static void aiV() {
        if (!com.baidu.swan.config.core.c.aiY()) {
            if (e.DEBUG) {
                Log.i("SwanConfig", "getConfig: 命中MaxAge策略，不请求");
                return;
            }
            return;
        }
        JSONObject a = a(ConfigNode.values());
        if (a != null) {
            a(a, new com.baidu.swan.config.core.d());
        }
    }

    private static void a(JSONObject jSONObject, ResponseCallback responseCallback) {
        if (e.DEBUG) {
            Log.i("SwanConfig", "getConfigInternal: " + jSONObject.toString());
        }
        com.baidu.swan.config.core.e.b(jSONObject, responseCallback);
    }

    private static JSONObject a(ConfigNode[] configNodeArr) {
        com.baidu.swan.config.core.a.c a;
        if (configNodeArr == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            for (ConfigNode configNode : configNodeArr) {
                if (configNode != null && (a = com.baidu.swan.config.core.a.b.a(configNode)) != null) {
                    jSONObject.put(configNode.getName(), a.ajb());
                }
            }
            return jSONObject;
        } catch (JSONException e) {
            if (e.DEBUG) {
                e.printStackTrace();
                return null;
            }
            return null;
        }
    }
}
