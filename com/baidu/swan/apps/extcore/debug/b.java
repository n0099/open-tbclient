package com.baidu.swan.apps.extcore.debug;

import com.baidu.swan.apps.an.x;
import java.io.File;
/* loaded from: classes2.dex */
public final class b {
    public static File HZ() {
        return new File(x.Ur().get(0).mPath, "baidu/aiapps_debug_extension_core/");
    }

    public static void Ia() {
        File HZ = HZ();
        if (HZ.exists()) {
            com.baidu.swan.c.a.deleteFile(HZ);
        }
    }

    public static File Ib() {
        File HZ = HZ();
        if (!HZ.exists()) {
            HZ.mkdirs();
        }
        return new File(HZ, "debugExtensionCore.zip");
    }
}
