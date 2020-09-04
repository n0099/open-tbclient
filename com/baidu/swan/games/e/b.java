package com.baidu.swan.games.e;

import com.baidu.swan.c.d;
import java.io.File;
/* loaded from: classes8.dex */
public class b {
    public static File amo() {
        return com.baidu.swan.games.l.a.vu("aigames_debug_dashboard");
    }

    public static void amp() {
        File amo = amo();
        if (amo.exists()) {
            d.deleteFile(amo);
        }
    }

    public static File amq() {
        File amo = amo();
        if (!amo.exists()) {
            amo.mkdirs();
        }
        return new File(amo, "debugDashboard.zip");
    }

    public static String aMT() {
        return "meter.js";
    }
}
