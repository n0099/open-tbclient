package com.baidu.swan.apps.swancore.b;

import android.text.TextUtils;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.swan.apps.b;
import com.baidu.swan.apps.storage.c.h;
import com.baidu.swan.c.d;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public final class a {
    private static final boolean DEBUG = b.DEBUG;

    public static File auF() {
        return new File(com.baidu.swan.apps.u.a.a.getStorageList().get(0).mPath, "/aiapps_debug_swan_core/");
    }

    public static void auG() {
        File auF = auF();
        if (auF.exists()) {
            d.deleteFile(auF);
        }
    }

    public static File auH() {
        File auF = auF();
        if (!auF.exists()) {
            auF.mkdirs();
        }
        return new File(auF, "debugSwanCore.zip");
    }

    public static long aMs() {
        return h.aMk().getLong("aiapps_cur_debug_ver_key", 0L);
    }

    public static boolean aMt() {
        JSONObject jSONObject;
        File file = new File(auF().getPath(), "pkginfo.json");
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
                    h.aMk().putLong("aiapps_cur_debug_ver_key", com.baidu.swan.apps.swancore.b.tD(optString));
                }
                return true;
            }
            return false;
        }
        return false;
    }
}
