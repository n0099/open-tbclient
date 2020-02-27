package com.baidu.swan.games.d;

import com.baidu.swan.d.c;
import java.io.File;
/* loaded from: classes11.dex */
public class b {
    public static File RR() {
        return com.baidu.swan.games.k.a.ph("aigames_debug_dashboard");
    }

    public static void RS() {
        File RR = RR();
        if (RR.exists()) {
            c.deleteFile(RR);
        }
    }

    public static File RT() {
        File RR = RR();
        if (!RR.exists()) {
            RR.mkdirs();
        }
        return new File(RR, "debugDashboard.zip");
    }

    public static String anm() {
        return "meter.js";
    }
}
