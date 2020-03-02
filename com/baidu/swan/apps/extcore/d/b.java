package com.baidu.swan.apps.extcore.d;

import com.baidu.swan.apps.as.ac;
import com.baidu.swan.d.c;
import java.io.File;
/* loaded from: classes11.dex */
public final class b {
    public static File RT() {
        return new File(ac.getStorageList().get(0).mPath, "/aiapps_debug_extension_core/");
    }

    public static void RU() {
        File RT = RT();
        if (RT.exists()) {
            c.deleteFile(RT);
        }
    }

    public static File RV() {
        File RT = RT();
        if (!RT.exists()) {
            RT.mkdirs();
        }
        return new File(RT, "debugExtensionCore.zip");
    }
}
