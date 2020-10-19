package com.baidu.swan.games.k.a;

import com.baidu.swan.c.d;
import java.io.File;
/* loaded from: classes10.dex */
public class b {
    public static File apK() {
        return com.baidu.swan.games.l.a.wz("aigames_debug_game_core");
    }

    public static void apL() {
        File apK = apK();
        if (apK.exists()) {
            d.deleteFile(apK);
        }
    }

    public static File apM() {
        File apK = apK();
        if (!apK.exists()) {
            apK.mkdirs();
        }
        return new File(apK, "debugGameCore.zip");
    }
}
