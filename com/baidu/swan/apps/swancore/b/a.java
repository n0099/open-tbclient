package com.baidu.swan.apps.swancore.b;

import android.text.TextUtils;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.swan.apps.b;
import com.baidu.swan.apps.storage.c.h;
import com.baidu.swan.c.d;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class a {
    private static final boolean DEBUG = b.DEBUG;

    public static File auf() {
        return new File(com.baidu.swan.apps.u.a.a.getStorageList().get(0).mPath, "/aiapps_debug_swan_core/");
    }

    public static void aug() {
        File auf = auf();
        if (auf.exists()) {
            d.deleteFile(auf);
        }
    }

    public static File auh() {
        File auf = auf();
        if (!auf.exists()) {
            auf.mkdirs();
        }
        return new File(auf, "debugSwanCore.zip");
    }

    public static long aLa() {
        return h.aKS().getLong("aiapps_cur_debug_ver_key", 0L);
    }

    public static boolean aLb() {
        JSONObject jSONObject;
        File file = new File(auf().getPath(), "pkginfo.json");
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
                    h.aKS().putLong("aiapps_cur_debug_ver_key", com.baidu.swan.apps.swancore.b.tP(optString));
                }
                return true;
            }
            return false;
        }
        return false;
    }
}
