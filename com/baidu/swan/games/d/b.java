package com.baidu.swan.games.d;

import com.baidu.swan.d.c;
import java.io.File;
/* loaded from: classes11.dex */
public class b {
    public static File ZL() {
        return com.baidu.swan.games.k.a.qt("aigames_debug_dashboard");
    }

    public static void ZM() {
        File ZL = ZL();
        if (ZL.exists()) {
            c.deleteFile(ZL);
        }
    }

    public static File ZN() {
        File ZL = ZL();
        if (!ZL.exists()) {
            ZL.mkdirs();
        }
        return new File(ZL, "debugDashboard.zip");
    }

    public static String avE() {
        return "meter.js";
    }
}
