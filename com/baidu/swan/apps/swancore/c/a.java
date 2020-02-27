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

    public static File RR() {
        return new File(ac.getStorageList().get(0).mPath, "/aiapps_debug_swan_core/");
    }

    public static void RS() {
        File RR = RR();
        if (RR.exists()) {
            c.deleteFile(RR);
        }
    }

    public static File RT() {
        File RR = RR();
        if (!RR.exists()) {
            RR.mkdirs();
        }
        return new File(RR, "debugSwanCore.zip");
    }

    public static long afx() {
        return h.afp().getLong("aiapps_cur_debug_ver_key", 0L);
    }

    public static boolean afy() {
        JSONObject jSONObject;
        File file = new File(RR().getPath(), "pkginfo.json");
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
                    h.afp().putLong("aiapps_cur_debug_ver_key", com.baidu.swan.apps.swancore.b.mp(optString));
                }
                return true;
            }
            return false;
        }
        return false;
    }
}
