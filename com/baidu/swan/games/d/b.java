package com.baidu.swan.games.d;

import com.baidu.swan.d.c;
import java.io.File;
/* loaded from: classes10.dex */
public class b {
    public static File PD() {
        return com.baidu.swan.games.k.a.oS("aigames_debug_dashboard");
    }

    public static void PE() {
        File PD = PD();
        if (PD.exists()) {
            c.deleteFile(PD);
        }
    }

    public static File PF() {
        File PD = PD();
        if (!PD.exists()) {
            PD.mkdirs();
        }
        return new File(PD, "debugDashboard.zip");
    }

    public static String akY() {
        return "meter.js";
    }
}
