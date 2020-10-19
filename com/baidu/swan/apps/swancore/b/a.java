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

    public static File apK() {
        return new File(com.baidu.swan.apps.u.a.a.getStorageList().get(0).mPath, "/aiapps_debug_swan_core/");
    }

    public static void apL() {
        File apK = apK();
        if (apK.exists()) {
            d.deleteFile(apK);
        }
    }

    public static File apM() {
        File apK = apK();
        if (!apK.exists()) {
            apK.mkdirs();
        }
        return new File(apK, "debugSwanCore.zip");
    }

    public static long aGG() {
        return h.aGy().getLong("aiapps_cur_debug_ver_key", 0L);
    }

    public static boolean aGH() {
        JSONObject jSONObject;
        File file = new File(apK().getPath(), "pkginfo.json");
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
                    h.aGy().putLong("aiapps_cur_debug_ver_key", com.baidu.swan.apps.swancore.b.ti(optString));
                }
                return true;
            }
            return false;
        }
        return false;
    }
}
