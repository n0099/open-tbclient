package com.baidu.swan.apps.swancore.b;

import android.text.TextUtils;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.swan.apps.b;
import com.baidu.swan.apps.storage.c.h;
import com.baidu.swan.c.d;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class a {
    private static final boolean DEBUG = b.DEBUG;

    public static File atx() {
        return new File(com.baidu.swan.apps.u.a.a.getStorageList().get(0).mPath, "/aiapps_debug_swan_core/");
    }

    public static void aty() {
        File atx = atx();
        if (atx.exists()) {
            d.deleteFile(atx);
        }
    }

    public static File atz() {
        File atx = atx();
        if (!atx.exists()) {
            atx.mkdirs();
        }
        return new File(atx, "debugSwanCore.zip");
    }

    public static long aKs() {
        return h.aKk().getLong("aiapps_cur_debug_ver_key", 0L);
    }

    public static boolean aKt() {
        JSONObject jSONObject;
        File file = new File(atx().getPath(), "pkginfo.json");
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
                    h.aKk().putLong("aiapps_cur_debug_ver_key", com.baidu.swan.apps.swancore.b.tK(optString));
                }
                return true;
            }
            return false;
        }
        return false;
    }
}
