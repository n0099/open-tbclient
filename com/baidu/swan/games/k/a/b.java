package com.baidu.swan.games.k.a;

import com.baidu.swan.c.d;
import java.io.File;
/* loaded from: classes10.dex */
public class b {
    public static File arE() {
        return com.baidu.swan.games.l.a.wS("aigames_debug_game_core");
    }

    public static void arF() {
        File arE = arE();
        if (arE.exists()) {
            d.deleteFile(arE);
        }
    }

    public static File arG() {
        File arE = arE();
        if (!arE.exists()) {
            arE.mkdirs();
        }
        return new File(arE, "debugGameCore.zip");
    }
}
