package com.baidu.swan.games.g.a;

import com.baidu.swan.d.c;
import java.io.File;
/* loaded from: classes11.dex */
public class b {
    public static File RW() {
        return com.baidu.swan.games.k.a.pg("aigames_debug_extension_core");
    }

    public static void RX() {
        File RW = RW();
        if (RW.exists()) {
            c.deleteFile(RW);
        }
    }

    public static File RY() {
        File RW = RW();
        if (!RW.exists()) {
            RW.mkdirs();
        }
        return new File(RW, "debugExtensionCore.zip");
    }
}
