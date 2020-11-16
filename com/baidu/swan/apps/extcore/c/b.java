package com.baidu.swan.apps.extcore.c;

import com.baidu.swan.c.d;
import java.io.File;
/* loaded from: classes7.dex */
public final class b {
    public static File atx() {
        return new File(com.baidu.swan.apps.u.a.a.getStorageList().get(0).mPath, "/aiapps_debug_extension_core/");
    }

    public static void aty() {
        File atx = atx();
        if (atx.exists()) {
            d.deleteFile(atx);
        }
    }

    public static File atz() {
        File atx = atx();
        if (!atx.exists()) {
            atx.mkdirs();
        }
        return new File(atx, "debugExtensionCore.zip");
    }
}
