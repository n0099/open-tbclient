package com.baidu.swan.games.e;

import com.baidu.swan.c.d;
import java.io.File;
/* loaded from: classes7.dex */
public class b {
    public static File atx() {
        return com.baidu.swan.games.l.a.xb("aigames_debug_dashboard");
    }

    public static void aty() {
        File atx = atx();
        if (atx.exists()) {
            d.deleteFile(atx);
        }
    }

    public static File atz() {
        File atx = atx();
        if (!atx.exists()) {
            atx.mkdirs();
        }
        return new File(atx, "debugDashboard.zip");
    }

    public static String aTZ() {
        return "meter.js";
    }
}
