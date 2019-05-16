package com.baidu.swan.apps.extcore.debug;

import com.baidu.swan.apps.an.x;
import java.io.File;
/* loaded from: classes2.dex */
public final class b {
    public static File Cr() {
        return new File(x.OJ().get(0).wV, "baidu/aiapps_debug_extension_core/");
    }

    public static void Cs() {
        File Cr = Cr();
        if (Cr.exists()) {
            com.baidu.swan.c.a.deleteFile(Cr);
        }
    }

    public static File Ct() {
        File Cr = Cr();
        if (!Cr.exists()) {
            Cr.mkdirs();
        }
        return new File(Cr, "debugExtensionCore.zip");
    }
}
