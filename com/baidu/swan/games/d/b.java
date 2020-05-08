package com.baidu.swan.games.d;

import com.baidu.swan.d.c;
import java.io.File;
/* loaded from: classes11.dex */
public class b {
    public static File ZK() {
        return com.baidu.swan.games.k.a.qt("aigames_debug_dashboard");
    }

    public static void ZL() {
        File ZK = ZK();
        if (ZK.exists()) {
            c.deleteFile(ZK);
        }
    }

    public static File ZM() {
        File ZK = ZK();
        if (!ZK.exists()) {
            ZK.mkdirs();
        }
        return new File(ZK, "debugDashboard.zip");
    }

    public static String avE() {
        return "meter.js";
    }
}
