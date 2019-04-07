package com.baidu.swan.games.h.a;

import com.baidu.swan.apps.an.v;
import java.io.File;
/* loaded from: classes2.dex */
public class b {
    public static File Bo() {
        return new File(v.Mc().get(0).mPath, "baidu/aigames_debug_game_core/");
    }

    public static String On() {
        return v.Mc().get(0).mPath + File.separator + "baidu/aigames_debug_game_core/";
    }

    public static void Bp() {
        File Bo = Bo();
        if (Bo.exists()) {
            com.baidu.swan.c.b.deleteFile(Bo);
        }
    }

    public static File Bq() {
        File Bo = Bo();
        if (!Bo.exists()) {
            Bo.mkdirs();
        }
        return new File(Bo, "debugGameCore.zip");
    }
}
