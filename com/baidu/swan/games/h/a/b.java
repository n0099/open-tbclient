package com.baidu.swan.games.h.a;

import com.baidu.swan.e.d;
import java.io.File;
/* loaded from: classes11.dex */
public class b {
    public static File acK() {
        return com.baidu.swan.games.l.a.rW("aigames_debug_extension_core");
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
