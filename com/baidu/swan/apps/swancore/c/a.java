package com.baidu.swan.apps.swancore.c;

import android.text.TextUtils;
import com.baidu.swan.apps.an.v;
import com.baidu.swan.apps.b;
import com.baidu.swan.apps.storage.b.f;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class a {
    private static final boolean DEBUG = b.DEBUG;

    public static File Bo() {
        return new File(v.Mc().get(0).mPath, "baidu/aiapps_debug_swan_core/");
    }

    public static void Bp() {
        File Bo = Bo();
        if (Bo.exists()) {
            com.baidu.swan.c.b.deleteFile(Bo);
        }
    }

    public static File Bq() {
        File Bo = Bo();
        if (!Bo.exists()) {
            Bo.mkdirs();
        }
        return new File(Bo, "debugSwanCore.zip");
    }

    public static long KQ() {
        return f.KJ().getLong("aiapps_cur_debug_ver_key", 0L);
    }

    public static void KR() {
        JSONObject jSONObject;
        File file = new File(Bo().getPath(), "pkginfo.json");
        if (file.exists()) {
            try {
                jSONObject = new JSONObject(com.baidu.swan.c.b.B(file));
            } catch (JSONException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
                jSONObject = null;
            }
            if (jSONObject != null) {
                String optString = jSONObject.optString("version_name");
                if (!TextUtils.isEmpty(optString)) {
                    f.KJ().putLong("aiapps_cur_debug_ver_key", com.baidu.swan.apps.swancore.b.hh(optString));
                }
            }
        }
    }
}
