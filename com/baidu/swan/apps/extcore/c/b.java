package com.baidu.swan.apps.extcore.c;

import com.baidu.swan.apps.aq.ad;
import com.baidu.swan.e.d;
import java.io.File;
/* loaded from: classes11.dex */
public final class b {
    public static File adQ() {
        return new File(ad.getStorageList().get(0).mPath, "/aiapps_debug_extension_core/");
    }

    public static void adR() {
        File adQ = adQ();
        if (adQ.exists()) {
            d.deleteFile(adQ);
        }
    }

    public static File adS() {
        File adQ = adQ();
        if (!adQ.exists()) {
            adQ.mkdirs();
        }
        return new File(adQ, "debugExtensionCore.zip");
    }
}
