package com.baidu.swan.games.k.a;

import com.baidu.swan.c.d;
import java.io.File;
/* loaded from: classes10.dex */
public class b {
    public static File auf() {
        return com.baidu.swan.games.l.a.xg("aigames_debug_game_core");
    }

    public static void aug() {
        File auf = auf();
        if (auf.exists()) {
            d.deleteFile(auf);
        }
    }

    public static File auh() {
        File auf = auf();
        if (!auf.exists()) {
            auf.mkdirs();
        }
        return new File(auf, "debugGameCore.zip");
    }
}
