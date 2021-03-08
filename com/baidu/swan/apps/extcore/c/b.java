package com.baidu.swan.apps.extcore.c;

import com.baidu.swan.c.d;
import java.io.File;
/* loaded from: classes8.dex */
public final class b {
    public static File auF() {
        return new File(com.baidu.swan.apps.u.a.a.getStorageList().get(0).mPath, "/aiapps_debug_extension_core/");
    }

    public static void auG() {
        File auF = auF();
        if (auF.exists()) {
            d.deleteFile(auF);
        }
    }

    public static File auH() {
        File auF = auF();
        if (!auF.exists()) {
            auF.mkdirs();
        }
        return new File(auF, "debugExtensionCore.zip");
    }
}
