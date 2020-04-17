package com.baidu.swan.apps.extcore.d;

import com.baidu.swan.apps.as.ac;
import com.baidu.swan.d.c;
import java.io.File;
/* loaded from: classes11.dex */
public final class b {
    public static File ZL() {
        return new File(ac.getStorageList().get(0).mPath, "/aiapps_debug_extension_core/");
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
        return new File(ZL, "debugExtensionCore.zip");
    }
}
