package com.baidu.swan.apps.extcore.debug;

import com.baidu.swan.apps.an.x;
import java.io.File;
/* loaded from: classes2.dex */
public final class b {
    public static File HY() {
        return new File(x.Ut().get(0).mPath, "baidu/aiapps_debug_extension_core/");
    }

    public static void HZ() {
        File HY = HY();
        if (HY.exists()) {
            com.baidu.swan.c.a.deleteFile(HY);
        }
    }

    public static File Ia() {
        File HY = HY();
        if (!HY.exists()) {
            HY.mkdirs();
        }
        return new File(HY, "debugExtensionCore.zip");
    }
}
