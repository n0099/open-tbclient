package com.baidu.swan.games.h.a;

import com.baidu.swan.apps.an.x;
import java.io.File;
/* loaded from: classes2.dex */
public class b {
    public static File HY() {
        return new File(x.Ut().get(0).mPath, "baidu/aigames_debug_game_core/");
    }

    public static String WZ() {
        return x.Ut().get(0).mPath + File.separator + "baidu/aigames_debug_game_core/";
    }

    public static void HZ() {
        File HY = HY();
        if (HY.exists()) {
            com.baidu.swan.c.a.deleteFile(HY);
        }
    }

    public static File Ia() {
        File HY = HY();
        if (!HY.exists()) {
            HY.mkdirs();
        }
        return new File(HY, "debugGameCore.zip");
    }
}
