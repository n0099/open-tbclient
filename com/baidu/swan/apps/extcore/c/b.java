package com.baidu.swan.apps.extcore.c;

import com.baidu.swan.c.d;
import java.io.File;
/* loaded from: classes8.dex */
public final class b {
    public static File amo() {
        return new File(com.baidu.swan.apps.u.a.a.getStorageList().get(0).mPath, "/aiapps_debug_extension_core/");
    }

    public static void amp() {
        File amo = amo();
        if (amo.exists()) {
            d.deleteFile(amo);
        }
    }

    public static File amq() {
        File amo = amo();
        if (!amo.exists()) {
            amo.mkdirs();
        }
        return new File(amo, "debugExtensionCore.zip");
    }
}
