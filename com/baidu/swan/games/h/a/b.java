package com.baidu.swan.games.h.a;

import com.baidu.swan.apps.an.x;
import java.io.File;
/* loaded from: classes2.dex */
public class b {
    public static File Da() {
        return new File(x.Pz().get(0).wX, "baidu/aigames_debug_game_core/");
    }

    public static String Se() {
        return x.Pz().get(0).wX + File.separator + "baidu/aigames_debug_game_core/";
    }

    public static void Db() {
        File Da = Da();
        if (Da.exists()) {
            com.baidu.swan.c.a.deleteFile(Da);
        }
    }

    public static File Dc() {
        File Da = Da();
        if (!Da.exists()) {
            Da.mkdirs();
        }
        return new File(Da, "debugGameCore.zip");
    }
}
