package com.baidu.swan.apps.extcore.d;

import com.baidu.swan.apps.as.ac;
import com.baidu.swan.d.c;
import java.io.File;
/* loaded from: classes9.dex */
public final class b {
    public static File Ph() {
        return new File(ac.getStorageList().get(0).mPath, "/aiapps_debug_extension_core/");
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
        return new File(Ph, "debugExtensionCore.zip");
    }
}
