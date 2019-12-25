package com.baidu.swan.games.j.a;

import java.io.File;
/* loaded from: classes9.dex */
public class b {
    public static File Ph() {
        return com.baidu.swan.games.k.a.oP("aigames_debug_game_core");
    }

    public static void Pi() {
        File Ph = Ph();
        if (Ph.exists()) {
            com.baidu.swan.d.c.deleteFile(Ph);
        }
    }

    public static File Pj() {
        File Ph = Ph();
        if (!Ph.exists()) {
            Ph.mkdirs();
        }
        return new File(Ph, "debugGameCore.zip");
    }
}
