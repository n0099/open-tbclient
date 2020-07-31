package com.baidu.swan.apps.extcore.c;

import com.baidu.swan.d.d;
import java.io.File;
/* loaded from: classes7.dex */
public final class b {
    public static File afh() {
        return new File(com.baidu.swan.apps.u.a.a.getStorageList().get(0).mPath, "/aiapps_debug_extension_core/");
    }

    public static void afi() {
        File afh = afh();
        if (afh.exists()) {
            d.deleteFile(afh);
        }
    }

    public static File afj() {
        File afh = afh();
        if (!afh.exists()) {
            afh.mkdirs();
        }
        return new File(afh, "debugExtensionCore.zip");
    }
}
