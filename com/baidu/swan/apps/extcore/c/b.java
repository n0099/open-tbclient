package com.baidu.swan.apps.extcore.c;

import com.baidu.swan.c.d;
import java.io.File;
/* loaded from: classes3.dex */
public final class b {
    public static File amY() {
        return new File(com.baidu.swan.apps.u.a.a.getStorageList().get(0).mPath, "/aiapps_debug_extension_core/");
    }

    public static void amZ() {
        File amY = amY();
        if (amY.exists()) {
            d.deleteFile(amY);
        }
    }

    public static File ana() {
        File amY = amY();
        if (!amY.exists()) {
            amY.mkdirs();
        }
        return new File(amY, "debugExtensionCore.zip");
    }
}
