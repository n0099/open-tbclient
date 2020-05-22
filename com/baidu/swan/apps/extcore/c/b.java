package com.baidu.swan.apps.extcore.c;

import com.baidu.swan.apps.aq.ad;
import com.baidu.swan.e.d;
import java.io.File;
/* loaded from: classes11.dex */
public final class b {
    public static File acK() {
        return new File(ad.getStorageList().get(0).mPath, "/aiapps_debug_extension_core/");
    }

    public static void acL() {
        File acK = acK();
        if (acK.exists()) {
            d.deleteFile(acK);
        }
    }

    public static File acM() {
        File acK = acK();
        if (!acK.exists()) {
            acK.mkdirs();
        }
        return new File(acK, "debugExtensionCore.zip");
    }
}
