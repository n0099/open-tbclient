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
/* loaded from: classes11.dex */
public final class a {
    private static final boolean DEBUG = b.DEBUG;

    public static File ZL() {
        return new File(ac.getStorageList().get(0).mPath, "/aiapps_debug_swan_core/");
    }

    public static void ZM() {
        File ZL = ZL();
        if (ZL.exists()) {
            c.deleteFile(ZL);
        }
    }

    public static File ZN() {
        File ZL = ZL();
        if (!ZL.exists()) {
            ZL.mkdirs();
        }
        return new File(ZL, "debugSwanCore.zip");
    }

    public static long anH() {
        return h.anz().getLong("aiapps_cur_debug_ver_key", 0L);
    }

    public static boolean anI() {
        JSONObject jSONObject;
        File file = new File(ZL().getPath(), "pkginfo.json");
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
                    h.anz().putLong("aiapps_cur_debug_ver_key", com.baidu.swan.apps.swancore.b.nB(optString));
                }
                return true;
            }
            return false;
        }
        return false;
    }
}
