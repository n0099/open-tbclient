package com.baidu.swan.apps.extcore.d;

import com.baidu.swan.apps.as.ac;
import com.baidu.swan.d.c;
import java.io.File;
/* loaded from: classes11.dex */
public final class b {
    public static File ZK() {
        return new File(ac.getStorageList().get(0).mPath, "/aiapps_debug_extension_core/");
    }

    public static void ZL() {
        File ZK = ZK();
        if (ZK.exists()) {
            c.deleteFile(ZK);
        }
    }

    public static File ZM() {
        File ZK = ZK();
        if (!ZK.exists()) {
            ZK.mkdirs();
        }
        return new File(ZK, "debugExtensionCore.zip");
    }
}
