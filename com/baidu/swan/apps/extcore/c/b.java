package com.baidu.swan.apps.extcore.c;

import com.baidu.swan.c.d;
import java.io.File;
/* loaded from: classes10.dex */
public final class b {
    public static File auf() {
        return new File(com.baidu.swan.apps.u.a.a.getStorageList().get(0).mPath, "/aiapps_debug_extension_core/");
    }

    public static void aug() {
        File auf = auf();
        if (auf.exists()) {
            d.deleteFile(auf);
        }
    }

    public static File auh() {
        File auf = auf();
        if (!auf.exists()) {
            auf.mkdirs();
        }
        return new File(auf, "debugExtensionCore.zip");
    }
}
