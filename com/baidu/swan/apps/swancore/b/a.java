package com.baidu.swan.apps.swancore.b;

import android.text.TextUtils;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.swan.apps.b;
import com.baidu.swan.apps.storage.c.h;
import com.baidu.swan.c.d;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class a {
    private static final boolean DEBUG = b.DEBUG;

    public static File amY() {
        return new File(com.baidu.swan.apps.u.a.a.getStorageList().get(0).mPath, "/aiapps_debug_swan_core/");
    }

    public static void amZ() {
        File amY = amY();
        if (amY.exists()) {
            d.deleteFile(amY);
        }
    }

    public static File ana() {
        File amY = amY();
        if (!amY.exists()) {
            amY.mkdirs();
        }
        return new File(amY, "debugSwanCore.zip");
    }

    public static long aDX() {
        return h.aDP().getLong("aiapps_cur_debug_ver_key", 0L);
    }

    public static boolean aDY() {
        JSONObject jSONObject;
        File file = new File(amY().getPath(), "pkginfo.json");
        if (file.exists()) {
            try {
                jSONObject = new JSONObject(d.readFileData(file));
            } catch (JSONException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
                jSONObject = null;
            }
            if (jSONObject != null) {
                String optString = jSONObject.optString(SharedPrefConfig.VERSION_NAME);
                if (!TextUtils.isEmpty(optString)) {
                    h.aDP().putLong("aiapps_cur_debug_ver_key", com.baidu.swan.apps.swancore.b.sw(optString));
                }
                return true;
            }
            return false;
        }
        return false;
    }
}
