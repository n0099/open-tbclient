package com.baidu.swan.apps.swancore.c;

import android.text.TextUtils;
import com.baidu.swan.apps.an.v;
import com.baidu.swan.apps.c;
import com.baidu.swan.apps.storage.b.f;
import com.baidu.swan.c.b;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class a {
    private static final boolean DEBUG = c.DEBUG;

    public static File Bq() {
        return new File(v.Me().get(0).mPath, "baidu/aiapps_debug_swan_core/");
    }

    public static void Br() {
        File Bq = Bq();
        if (Bq.exists()) {
            b.deleteFile(Bq);
        }
    }

    public static File Bs() {
        File Bq = Bq();
        if (!Bq.exists()) {
            Bq.mkdirs();
        }
        return new File(Bq, "debugSwanCore.zip");
    }

    public static long KS() {
        return f.KL().getLong("aiapps_cur_debug_ver_key", 0L);
    }

    public static void KT() {
        JSONObject jSONObject;
        File file = new File(Bq().getPath(), "pkginfo.json");
        if (file.exists()) {
            try {
                jSONObject = new JSONObject(b.B(file));
            } catch (JSONException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
                jSONObject = null;
            }
            if (jSONObject != null) {
                String optString = jSONObject.optString("version_name");
                if (!TextUtils.isEmpty(optString)) {
                    f.KL().putLong("aiapps_cur_debug_ver_key", com.baidu.swan.apps.swancore.b.hg(optString));
                }
            }
        }
    }
}
