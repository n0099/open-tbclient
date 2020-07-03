package com.baidu.swan.games.e;

import com.baidu.swan.e.d;
import java.io.File;
/* loaded from: classes11.dex */
public class b {
    public static File adQ() {
        return com.baidu.swan.games.l.a.se("aigames_debug_dashboard");
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
        return new File(adQ, "debugDashboard.zip");
    }

    public static String aAz() {
        return "meter.js";
    }
}
