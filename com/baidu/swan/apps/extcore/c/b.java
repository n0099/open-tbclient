package com.baidu.swan.apps.extcore.c;

import com.baidu.swan.c.d;
import java.io.File;
/* loaded from: classes9.dex */
public final class b {
    public static File auC() {
        return new File(com.baidu.swan.apps.u.a.a.getStorageList().get(0).mPath, "/aiapps_debug_extension_core/");
    }

    public static void auD() {
        File auC = auC();
        if (auC.exists()) {
            d.deleteFile(auC);
        }
    }

    public static File auE() {
        File auC = auC();
        if (!auC.exists()) {
            auC.mkdirs();
        }
        return new File(auC, "debugExtensionCore.zip");
    }
}
