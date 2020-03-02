package com.baidu.swan.games.j.a;

import java.io.File;
/* loaded from: classes11.dex */
public class b {
    public static File RT() {
        return com.baidu.swan.games.k.a.ph("aigames_debug_game_core");
    }

    public static void RU() {
        File RT = RT();
        if (RT.exists()) {
            com.baidu.swan.d.c.deleteFile(RT);
        }
    }

    public static File RV() {
        File RT = RT();
        if (!RT.exists()) {
            RT.mkdirs();
        }
        return new File(RT, "debugGameCore.zip");
    }
}
