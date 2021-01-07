package com.baidu.swan.games.k.a;

import com.baidu.swan.c.d;
import java.io.File;
/* loaded from: classes9.dex */
public class b {
    public static File axY() {
        return com.baidu.swan.games.l.a.xH("aigames_debug_game_core");
    }

    public static void axZ() {
        File axY = axY();
        if (axY.exists()) {
            d.deleteFile(axY);
        }
    }

    public static File aya() {
        File axY = axY();
        if (!axY.exists()) {
            axY.mkdirs();
        }
        return new File(axY, "debugGameCore.zip");
    }
}
