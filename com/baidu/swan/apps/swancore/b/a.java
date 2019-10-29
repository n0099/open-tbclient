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

    public static boolean iv(String str) {
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
        String str2 = c.GO().Hg() != null ? c.GO().Hg().bql + "/abtest/config.js" : "/abtest/config.js";
        if (DEBUG) {
            Log.d("SwanCoreConfigHelper", "path:" + path);
            Log.d("SwanCoreConfigHelper", "configCheckPath:" + str2);
        }
        return TextUtils.isEmpty(parse.getHost()) && TextUtils.equals(str2, path);
    }

    public static InputStream SV() {
        String str = "";
        if (com.baidu.swan.apps.u.a.Jl() != null) {
            str = SW().toString();
        }
        String str2 = "(function(global){global.extraConfig= {abTestSwitch:" + str + "}})(window)";
        if (DEBUG) {
            Log.d("SwanCoreConfigHelper", "result :" + str2);
        }
        return new ByteArrayInputStream(str2.getBytes());
    }

    private static JSONObject SW() {
        JSONObject Bi = com.baidu.swan.apps.u.a.Jl().Bi();
        Iterator<String> keys = Bi.keys();
        while (keys.hasNext()) {
            if (!keys.next().startsWith("swanswitch")) {
                keys.remove();
            }
        }
        return Bi;
    }

    public static JSONObject SX() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("abTestSwitch", SW());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
