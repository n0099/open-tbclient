package com.baidu.swan.games.h.a;

import com.baidu.swan.apps.an.x;
import java.io.File;
/* loaded from: classes2.dex */
public class b {
    public static File Cr() {
        return new File(x.OJ().get(0).wV, "baidu/aigames_debug_game_core/");
    }

    public static String Rl() {
        return x.OJ().get(0).wV + File.separator + "baidu/aigames_debug_game_core/";
    }

    public static void Cs() {
        File Cr = Cr();
        if (Cr.exists()) {
            com.baidu.swan.c.a.deleteFile(Cr);
        }
    }

    public static File Ct() {
        File Cr = Cr();
        if (!Cr.exists()) {
            Cr.mkdirs();
        }
        return new File(Cr, "debugGameCore.zip");
    }
}
