package com.baidu.swan.apps.extcore.d;

import com.baidu.swan.apps.as.ac;
import com.baidu.swan.d.c;
import java.io.File;
/* loaded from: classes11.dex */
public final class b {
    public static File RW() {
        return new File(ac.getStorageList().get(0).mPath, "/aiapps_debug_extension_core/");
    }

    public static void RX() {
        File RW = RW();
        if (RW.exists()) {
            c.deleteFile(RW);
        }
    }

    public static File RY() {
        File RW = RW();
        if (!RW.exists()) {
            RW.mkdirs();
        }
        return new File(RW, "debugExtensionCore.zip");
    }
}
