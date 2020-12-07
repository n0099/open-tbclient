package com.baidu.swan.games.h.a;

import com.baidu.swan.c.d;
import java.io.File;
/* loaded from: classes25.dex */
public class b {
    public static File awF() {
        return com.baidu.swan.games.l.a.xI("aigames_debug_extension_core");
    }

    public static void awG() {
        File awF = awF();
        if (awF.exists()) {
            d.deleteFile(awF);
        }
    }

    public static File awH() {
        File awF = awF();
        if (!awF.exists()) {
            awF.mkdirs();
        }
        return new File(awF, "debugExtensionCore.zip");
    }
}
