package com.baidu.swan.apps.swancore.c;

import android.text.TextUtils;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.swan.apps.as.ac;
import com.baidu.swan.apps.b;
import com.baidu.swan.apps.storage.c.h;
import com.baidu.swan.d.c;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public final class a {
    private static final boolean DEBUG = b.DEBUG;

    public static File Ph() {
        return new File(ac.getStorageList().get(0).mPath, "/aiapps_debug_swan_core/");
    }

    public static void Pi() {
        File Ph = Ph();
        if (Ph.exists()) {
            c.deleteFile(Ph);
        }
    }

    public static File Pj() {
        File Ph = Ph();
        if (!Ph.exists()) {
            Ph.mkdirs();
        }
        return new File(Ph, "debugSwanCore.zip");
    }

    public static long acM() {
        return h.acE().getLong("aiapps_cur_debug_ver_key", 0L);
    }

    public static boolean acN() {
        JSONObject jSONObject;
        File file = new File(Ph().getPath(), "pkginfo.json");
        if (file.exists()) {
            try {
                jSONObject = new JSONObject(c.readFileData(file));
            } catch (JSONException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
                jSONObject = null;
            }
            if (jSONObject != null) {
                String optString = jSONObject.optString(SharedPrefConfig.VERSION_NAME);
                if (!TextUtils.isEmpty(optString)) {
                    h.acE().putLong("aiapps_cur_debug_ver_key", com.baidu.swan.apps.swancore.b.lX(optString));
                }
                return true;
            }
            return false;
        }
        return false;
    }
}
