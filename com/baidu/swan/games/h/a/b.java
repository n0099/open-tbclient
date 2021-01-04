package com.baidu.swan.games.h.a;

import com.baidu.swan.c.d;
import java.io.File;
/* loaded from: classes9.dex */
public class b {
    public static File axX() {
        return com.baidu.swan.games.l.a.xH("aigames_debug_extension_core");
    }

    public static void axY() {
        File axX = axX();
        if (axX.exists()) {
            d.deleteFile(axX);
        }
    }

    public static File axZ() {
        File axX = axX();
        if (!axX.exists()) {
            axX.mkdirs();
        }
        return new File(axX, "debugExtensionCore.zip");
    }
}
