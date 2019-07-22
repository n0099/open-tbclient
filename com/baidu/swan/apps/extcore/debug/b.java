package com.baidu.swan.apps.extcore.debug;

import com.baidu.swan.apps.an.x;
import java.io.File;
/* loaded from: classes2.dex */
public final class b {
    public static File Da() {
        return new File(x.Pz().get(0).wX, "baidu/aiapps_debug_extension_core/");
    }

    public static void Db() {
        File Da = Da();
        if (Da.exists()) {
            com.baidu.swan.c.a.deleteFile(Da);
        }
    }

    public static File Dc() {
        File Da = Da();
        if (!Da.exists()) {
            Da.mkdirs();
        }
        return new File(Da, "debugExtensionCore.zip");
    }
}
