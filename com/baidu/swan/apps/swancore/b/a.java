package com.baidu.swan.apps.swancore.b;

import android.text.TextUtils;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.swan.apps.aq.ad;
import com.baidu.swan.apps.b;
import com.baidu.swan.apps.storage.c.h;
import com.baidu.swan.e.d;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public final class a {
    private static final boolean DEBUG = b.DEBUG;

    public static File acK() {
        return new File(ad.getStorageList().get(0).mPath, "/aiapps_debug_swan_core/");
    }

    public static void acL() {
        File acK = acK();
        if (acK.exists()) {
            d.deleteFile(acK);
        }
    }

    public static File acM() {
        File acK = acK();
        if (!acK.exists()) {
            acK.mkdirs();
        }
        return new File(acK, "debugSwanCore.zip");
    }

    public static long arW() {
        return h.arO().getLong("aiapps_cur_debug_ver_key", 0L);
    }

    public static boolean arX() {
        JSONObject jSONObject;
        File file = new File(acK().getPath(), "pkginfo.json");
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
                    h.arO().putLong("aiapps_cur_debug_ver_key", com.baidu.swan.apps.swancore.b.pi(optString));
                }
                return true;
            }
            return false;
        }
        return false;
    }
}
