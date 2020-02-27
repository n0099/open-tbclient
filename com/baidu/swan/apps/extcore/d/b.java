package com.baidu.swan.apps.extcore.d;

import com.baidu.swan.apps.as.ac;
import com.baidu.swan.d.c;
import java.io.File;
/* loaded from: classes11.dex */
public final class b {
    public static File RR() {
        return new File(ac.getStorageList().get(0).mPath, "/aiapps_debug_extension_core/");
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
        return new File(RR, "debugExtensionCore.zip");
    }
}
