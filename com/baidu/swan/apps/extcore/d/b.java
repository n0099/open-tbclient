package com.baidu.swan.apps.extcore.d;

import com.baidu.swan.apps.as.ac;
import com.baidu.swan.d.c;
import java.io.File;
/* loaded from: classes10.dex */
public final class b {
    public static File PD() {
        return new File(ac.getStorageList().get(0).mPath, "/aiapps_debug_extension_core/");
    }

    public static void PE() {
        File PD = PD();
        if (PD.exists()) {
            c.deleteFile(PD);
        }
    }

    public static File PF() {
        File PD = PD();
        if (!PD.exists()) {
            PD.mkdirs();
        }
        return new File(PD, "debugExtensionCore.zip");
    }
}
