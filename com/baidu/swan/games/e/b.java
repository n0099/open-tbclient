package com.baidu.swan.games.e;

import com.baidu.swan.c.d;
import java.io.File;
/* loaded from: classes3.dex */
public class b {
    public static File amY() {
        return com.baidu.swan.games.l.a.vN("aigames_debug_dashboard");
    }

    public static void amZ() {
        File amY = amY();
        if (amY.exists()) {
            d.deleteFile(amY);
        }
    }

    public static File ana() {
        File amY = amY();
        if (!amY.exists()) {
            amY.mkdirs();
        }
        return new File(amY, "debugDashboard.zip");
    }

    public static String aNE() {
        return "meter.js";
    }
}
