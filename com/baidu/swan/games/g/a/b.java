package com.baidu.swan.games.g.a;

import com.baidu.swan.d.c;
import java.io.File;
/* loaded from: classes10.dex */
public class b {
    public static File PD() {
        return com.baidu.swan.games.k.a.oS("aigames_debug_extension_core");
    }

    public static void PE() {
        File PD = PD();
        if (PD.exists()) {
            c.deleteFile(PD);
        }
    }

    public static File PF() {
        File PD = PD();
        if (!PD.exists()) {
            PD.mkdirs();
        }
        return new File(PD, "debugExtensionCore.zip");
    }
}
