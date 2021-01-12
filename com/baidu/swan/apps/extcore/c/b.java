package com.baidu.swan.apps.extcore.c;

import com.baidu.swan.c.d;
import java.io.File;
/* loaded from: classes8.dex */
public final class b {
    public static File aue() {
        return new File(com.baidu.swan.apps.u.a.a.getStorageList().get(0).mPath, "/aiapps_debug_extension_core/");
    }

    public static void auf() {
        File aue = aue();
        if (aue.exists()) {
            d.deleteFile(aue);
        }
    }

    public static File aug() {
        File aue = aue();
        if (!aue.exists()) {
            aue.mkdirs();
        }
        return new File(aue, "debugExtensionCore.zip");
    }
}
