package com.baidu.swan.games.k.a;

import com.baidu.swan.c.d;
import java.io.File;
/* loaded from: classes8.dex */
public class b {
    public static File auF() {
        return com.baidu.swan.games.l.a.wW("aigames_debug_game_core");
    }

    public static void auG() {
        File auF = auF();
        if (auF.exists()) {
            d.deleteFile(auF);
        }
    }

    public static File auH() {
        File auF = auF();
        if (!auF.exists()) {
            auF.mkdirs();
        }
        return new File(auF, "debugGameCore.zip");
    }
}
