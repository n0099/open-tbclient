package com.baidu.swan.games.h.a;

import com.baidu.swan.apps.an.x;
import java.io.File;
/* loaded from: classes2.dex */
public class b {
    public static File HZ() {
        return new File(x.Ur().get(0).mPath, "baidu/aigames_debug_game_core/");
    }

    public static String WX() {
        return x.Ur().get(0).mPath + File.separator + "baidu/aigames_debug_game_core/";
    }

    public static void Ia() {
        File HZ = HZ();
        if (HZ.exists()) {
            com.baidu.swan.c.a.deleteFile(HZ);
        }
    }

    public static File Ib() {
        File HZ = HZ();
        if (!HZ.exists()) {
            HZ.mkdirs();
        }
        return new File(HZ, "debugGameCore.zip");
    }
}
