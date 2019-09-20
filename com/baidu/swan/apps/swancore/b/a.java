package com.baidu.swan.apps.swancore.b;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.b;
import com.baidu.swan.apps.core.j.c;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a {
    private static final boolean DEBUG = b.DEBUG;

    public static boolean hR(String str) {
        if (TextUtils.isEmpty(str)) {
            if (DEBUG) {
                Log.d("SwanCoreConfigHelper", "error url!");
                return false;
            }
            return false;
        }
        Uri parse = Uri.parse(str);
        if (parse == null) {
            if (DEBUG) {
                Log.d("SwanCoreConfigHelper", "error uri!");
                return false;
            }
            return false;
        }
        String path = parse.getPath();
        String str2 = c.BU().Cm() != null ? c.BU().Cm().aXh + "/abtest/config.js" : "/abtest/config.js";
        if (DEBUG) {
            Log.d("SwanCoreConfigHelper", "path:" + path);
            Log.d("SwanCoreConfigHelper", "configCheckPath:" + str2);
        }
        return TextUtils.isEmpty(parse.getHost()) && TextUtils.equals(str2, path);
    }

    public static InputStream Of() {
        String str = "";
        if (com.baidu.swan.apps.u.a.Er() != null) {
            str = Og().toString();
        }
        String str2 = "(function(global){global.extraConfig= {abTestSwitch:" + str + "}})(window)";
        if (DEBUG) {
            Log.d("SwanCoreConfigHelper", "result :" + str2);
        }
        return new ByteArrayInputStream(str2.getBytes());
    }

    private static JSONObject Og() {
        JSONObject wo = com.baidu.swan.apps.u.a.Er().wo();
        Iterator<String> keys = wo.keys();
        while (keys.hasNext()) {
            if (!keys.next().startsWith("swanswitch")) {
                keys.remove();
            }
        }
        return wo;
    }

    public static JSONObject Oh() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("abTestSwitch", Og());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
