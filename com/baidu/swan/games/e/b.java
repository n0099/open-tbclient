package com.baidu.swan.games.e;

import com.baidu.swan.c.d;
import java.io.File;
/* loaded from: classes10.dex */
public class b {
    public static File arE() {
        return com.baidu.swan.games.l.a.wS("aigames_debug_dashboard");
    }

    public static void arF() {
        File arE = arE();
        if (arE.exists()) {
            d.deleteFile(arE);
        }
    }

    public static File arG() {
        File arE = arE();
        if (!arE.exists()) {
            arE.mkdirs();
        }
        return new File(arE, "debugDashboard.zip");
    }

    public static String aSh() {
        return "meter.js";
    }
}
