package com.baidu.swan.apps.extcore.c;

import com.baidu.swan.c.d;
import java.io.File;
/* loaded from: classes25.dex */
public final class b {
    public static File awF() {
        return new File(com.baidu.swan.apps.u.a.a.getStorageList().get(0).mPath, "/aiapps_debug_extension_core/");
    }

    public static void awG() {
        File awF = awF();
        if (awF.exists()) {
            d.deleteFile(awF);
        }
    }

    public static File awH() {
        File awF = awF();
        if (!awF.exists()) {
            awF.mkdirs();
        }
        return new File(awF, "debugExtensionCore.zip");
    }
}
