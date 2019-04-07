package com.baidu.swan.apps.extcore.d;

import com.baidu.swan.apps.an.v;
import java.io.File;
/* loaded from: classes2.dex */
public final class b {
    public static File Bo() {
        return new File(v.Mc().get(0).mPath, "baidu/aiapps_debug_extension_core/");
    }

    public static void Bp() {
        File Bo = Bo();
        if (Bo.exists()) {
            com.baidu.swan.c.b.deleteFile(Bo);
        }
    }

    public static File Bq() {
        File Bo = Bo();
        if (!Bo.exists()) {
            Bo.mkdirs();
        }
        return new File(Bo, "debugExtensionCore.zip");
    }
}
