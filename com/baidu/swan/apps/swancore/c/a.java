package com.baidu.swan.apps.swancore.c;

import android.text.TextUtils;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.swan.apps.an.x;
import com.baidu.swan.apps.b;
import com.baidu.swan.apps.storage.b.f;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class a {
    private static final boolean DEBUG = b.DEBUG;

    public static File HZ() {
        return new File(x.Ur().get(0).mPath, "baidu/aiapps_debug_swan_core/");
    }

    public static void Ia() {
        File HZ = HZ();
        if (HZ.exists()) {
            com.baidu.swan.c.a.deleteFile(HZ);
        }
    }

    public static File Ib() {
        File HZ = HZ();
        if (!HZ.exists()) {
            HZ.mkdirs();
        }
        return new File(HZ, "debugSwanCore.zip");
    }

    public static long Ta() {
        return f.ST().getLong("aiapps_cur_debug_ver_key", 0L);
    }

    public static void Tb() {
        JSONObject jSONObject;
        File file = new File(HZ().getPath(), "pkginfo.json");
        if (file.exists()) {
            try {
                jSONObject = new JSONObject(com.baidu.swan.c.a.l(file));
            } catch (JSONException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
                jSONObject = null;
            }
            if (jSONObject != null) {
                String optString = jSONObject.optString(SharedPrefConfig.VERSION_NAME);
                if (!TextUtils.isEmpty(optString)) {
                    f.ST().putLong("aiapps_cur_debug_ver_key", com.baidu.swan.apps.swancore.b.iu(optString));
                }
            }
        }
    }
}
