package com.baidu.swan.apps.extcore.debug;

import com.baidu.swan.apps.an.x;
import java.io.File;
/* loaded from: classes2.dex */
public final class b {
    public static File De() {
        return new File(x.PD().get(0).wX, "baidu/aiapps_debug_extension_core/");
    }

    public static void Df() {
        File De = De();
        if (De.exists()) {
            com.baidu.swan.c.a.deleteFile(De);
        }
    }

    public static File Dg() {
        File De = De();
        if (!De.exists()) {
            De.mkdirs();
        }
        return new File(De, "debugExtensionCore.zip");
    }
}
