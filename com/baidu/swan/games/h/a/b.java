package com.baidu.swan.games.h.a;

import com.baidu.swan.apps.an.v;
import java.io.File;
/* loaded from: classes2.dex */
public class b {
    public static File Bq() {
        return new File(v.Me().get(0).mPath, "baidu/aigames_debug_game_core/");
    }

    public static String Op() {
        return v.Me().get(0).mPath + File.separator + "baidu/aigames_debug_game_core/";
    }

    public static void Br() {
        File Bq = Bq();
        if (Bq.exists()) {
            com.baidu.swan.c.b.deleteFile(Bq);
        }
    }

    public static File Bs() {
        File Bq = Bq();
        if (!Bq.exists()) {
            Bq.mkdirs();
        }
        return new File(Bq, "debugGameCore.zip");
    }
}
