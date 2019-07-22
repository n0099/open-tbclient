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

    public static File Da() {
        return new File(x.Pz().get(0).wX, "baidu/aiapps_debug_swan_core/");
    }

    public static void Db() {
        File Da = Da();
        if (Da.exists()) {
            com.baidu.swan.c.a.deleteFile(Da);
        }
    }

    public static File Dc() {
        File Da = Da();
        if (!Da.exists()) {
            Da.mkdirs();
        }
        return new File(Da, "debugSwanCore.zip");
    }

    public static long Oe() {
        return f.NX().getLong("aiapps_cur_debug_ver_key", 0L);
    }

    public static void Of() {
        JSONObject jSONObject;
        File file = new File(Da().getPath(), "pkginfo.json");
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
                    f.NX().putLong("aiapps_cur_debug_ver_key", com.baidu.swan.apps.swancore.b.hO(optString));
                }
            }
        }
    }
}
