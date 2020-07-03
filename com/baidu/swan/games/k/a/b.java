package com.baidu.swan.games.k.a;

import com.baidu.swan.e.d;
import java.io.File;
/* loaded from: classes11.dex */
public class b {
    public static File adQ() {
        return com.baidu.swan.games.l.a.se("aigames_debug_game_core");
    }

    public static void adR() {
        File adQ = adQ();
        if (adQ.exists()) {
            d.deleteFile(adQ);
        }
    }

    public static File adS() {
        File adQ = adQ();
        if (!adQ.exists()) {
            adQ.mkdirs();
        }
        return new File(adQ, "debugGameCore.zip");
    }
}
