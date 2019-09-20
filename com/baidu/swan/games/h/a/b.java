package com.baidu.swan.games.h.a;

import com.baidu.swan.apps.an.x;
import java.io.File;
/* loaded from: classes2.dex */
public class b {
    public static File De() {
        return new File(x.PD().get(0).wX, "baidu/aigames_debug_game_core/");
    }

    public static String Si() {
        return x.PD().get(0).wX + File.separator + "baidu/aigames_debug_game_core/";
    }

    public static void Df() {
        File De = De();
        if (De.exists()) {
            com.baidu.swan.c.a.deleteFile(De);
        }
    }

    public static File Dg() {
        File De = De();
        if (!De.exists()) {
            De.mkdirs();
        }
        return new File(De, "debugGameCore.zip");
    }
}
