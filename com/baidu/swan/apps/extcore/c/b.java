package com.baidu.swan.apps.extcore.c;

import com.baidu.swan.c.d;
import java.io.File;
/* loaded from: classes10.dex */
public final class b {
    public static File arE() {
        return new File(com.baidu.swan.apps.u.a.a.getStorageList().get(0).mPath, "/aiapps_debug_extension_core/");
    }

    public static void arF() {
        File arE = arE();
        if (arE.exists()) {
            d.deleteFile(arE);
        }
    }

    public static File arG() {
        File arE = arE();
        if (!arE.exists()) {
            arE.mkdirs();
        }
        return new File(arE, "debugExtensionCore.zip");
    }
}
