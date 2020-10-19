package com.baidu.swan.apps.extcore.c;

import com.baidu.swan.c.d;
import java.io.File;
/* loaded from: classes10.dex */
public final class b {
    public static File apK() {
        return new File(com.baidu.swan.apps.u.a.a.getStorageList().get(0).mPath, "/aiapps_debug_extension_core/");
    }

    public static void apL() {
        File apK = apK();
        if (apK.exists()) {
            d.deleteFile(apK);
        }
    }

    public static File apM() {
        File apK = apK();
        if (!apK.exists()) {
            apK.mkdirs();
        }
        return new File(apK, "debugExtensionCore.zip");
    }
}
