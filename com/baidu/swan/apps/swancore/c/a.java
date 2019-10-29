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

    public static File HY() {
        return new File(x.Ut().get(0).mPath, "baidu/aiapps_debug_swan_core/");
    }

    public static void HZ() {
        File HY = HY();
        if (HY.exists()) {
            com.baidu.swan.c.a.deleteFile(HY);
        }
    }

    public static File Ia() {
        File HY = HY();
        if (!HY.exists()) {
            HY.mkdirs();
        }
        return new File(HY, "debugSwanCore.zip");
    }

    public static long SY() {
        return f.SR().getLong("aiapps_cur_debug_ver_key", 0L);
    }

    public static void SZ() {
        JSONObject jSONObject;
        File file = new File(HY().getPath(), "pkginfo.json");
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
                    f.SR().putLong("aiapps_cur_debug_ver_key", com.baidu.swan.apps.swancore.b.iu(optString));
                }
            }
        }
    }
}
