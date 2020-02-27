package com.baidu.swan.games.j.a;

import java.io.File;
/* loaded from: classes11.dex */
public class b {
    public static File RR() {
        return com.baidu.swan.games.k.a.ph("aigames_debug_game_core");
    }

    public static void RS() {
        File RR = RR();
        if (RR.exists()) {
            com.baidu.swan.d.c.deleteFile(RR);
        }
    }

    public static File RT() {
        File RR = RR();
        if (!RR.exists()) {
            RR.mkdirs();
        }
        return new File(RR, "debugGameCore.zip");
    }
}
