package com.baidu.swan.apps.extcore.c;

import com.baidu.swan.c.d;
import java.io.File;
/* loaded from: classes9.dex */
public final class b {
    public static File axX() {
        return new File(com.baidu.swan.apps.u.a.a.getStorageList().get(0).mPath, "/aiapps_debug_extension_core/");
    }

    public static void axY() {
        File axX = axX();
        if (axX.exists()) {
            d.deleteFile(axX);
        }
    }

    public static File axZ() {
        File axX = axX();
        if (!axX.exists()) {
            axX.mkdirs();
        }
        return new File(axX, "debugExtensionCore.zip");
    }
}
