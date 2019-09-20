package com.baidu.swan.apps.swancore.c;

import android.text.TextUtils;
import com.baidu.swan.apps.an.x;
import com.baidu.swan.apps.b;
import com.baidu.swan.apps.storage.b.f;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class a {
    private static final boolean DEBUG = b.DEBUG;

    public static File De() {
        return new File(x.PD().get(0).wX, "baidu/aiapps_debug_swan_core/");
    }

    public static void Df() {
        File De = De();
        if (De.exists()) {
            com.baidu.swan.c.a.deleteFile(De);
        }
    }

    public static File Dg() {
        File De = De();
        if (!De.exists()) {
            De.mkdirs();
        }
        return new File(De, "debugSwanCore.zip");
    }

    public static long Oi() {
        return f.Ob().getLong("aiapps_cur_debug_ver_key", 0L);
    }

    public static void Oj() {
        JSONObject jSONObject;
        File file = new File(De().getPath(), "pkginfo.json");
        if (file.exists()) {
            try {
                jSONObject = new JSONObject(com.baidu.swan.c.a.v(file));
            } catch (JSONException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
                jSONObject = null;
            }
            if (jSONObject != null) {
                String optString = jSONObject.optString("version_name");
                if (!TextUtils.isEmpty(optString)) {
                    f.Ob().putLong("aiapps_cur_debug_ver_key", com.baidu.swan.apps.swancore.b.hQ(optString));
                }
            }
        }
    }
}
