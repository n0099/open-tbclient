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

    public static File Cr() {
        return new File(x.OJ().get(0).wV, "baidu/aiapps_debug_swan_core/");
    }

    public static void Cs() {
        File Cr = Cr();
        if (Cr.exists()) {
            com.baidu.swan.c.a.deleteFile(Cr);
        }
    }

    public static File Ct() {
        File Cr = Cr();
        if (!Cr.exists()) {
            Cr.mkdirs();
        }
        return new File(Cr, "debugSwanCore.zip");
    }

    public static long Np() {
        return f.Ni().getLong("aiapps_cur_debug_ver_key", 0L);
    }

    public static void Nq() {
        JSONObject jSONObject;
        File file = new File(Cr().getPath(), "pkginfo.json");
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
                    f.Ni().putLong("aiapps_cur_debug_ver_key", com.baidu.swan.apps.swancore.b.hI(optString));
                }
            }
        }
    }
}
