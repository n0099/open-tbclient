package com.baidu.swan.apps.extcore.c;

import com.baidu.swan.c.d;
import java.io.File;
/* loaded from: classes9.dex */
public final class b {
    public static File axY() {
        return new File(com.baidu.swan.apps.u.a.a.getStorageList().get(0).mPath, "/aiapps_debug_extension_core/");
    }

    public static void axZ() {
        File axY = axY();
        if (axY.exists()) {
            d.deleteFile(axY);
        }
    }

    public static File aya() {
        File axY = axY();
        if (!axY.exists()) {
            axY.mkdirs();
        }
        return new File(axY, "debugExtensionCore.zip");
    }
}
