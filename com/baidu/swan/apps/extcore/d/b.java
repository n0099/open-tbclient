package com.baidu.swan.apps.extcore.d;

import com.baidu.swan.apps.an.v;
import java.io.File;
/* loaded from: classes2.dex */
public final class b {
    public static File Bq() {
        return new File(v.Me().get(0).mPath, "baidu/aiapps_debug_extension_core/");
    }

    public static void Br() {
        File Bq = Bq();
        if (Bq.exists()) {
            com.baidu.swan.c.b.deleteFile(Bq);
        }
    }

    public static File Bs() {
        File Bq = Bq();
        if (!Bq.exists()) {
            Bq.mkdirs();
        }
        return new File(Bq, "debugExtensionCore.zip");
    }
}
