package com.baidu.swan.games.k.a;

import com.baidu.swan.c.d;
import java.io.File;
/* loaded from: classes9.dex */
public class b {
    public static File auC() {
        return com.baidu.swan.games.l.a.wP("aigames_debug_game_core");
    }

    public static void auD() {
        File auC = auC();
        if (auC.exists()) {
            d.deleteFile(auC);
        }
    }

    public static File auE() {
        File auC = auC();
        if (!auC.exists()) {
            auC.mkdirs();
        }
        return new File(auC, "debugGameCore.zip");
    }
}
