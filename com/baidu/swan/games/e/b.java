package com.baidu.swan.games.e;

import com.baidu.swan.c.d;
import java.io.File;
/* loaded from: classes8.dex */
public class b {
    public static File aue() {
        return com.baidu.swan.games.l.a.ww("aigames_debug_dashboard");
    }

    public static void auf() {
        File aue = aue();
        if (aue.exists()) {
            d.deleteFile(aue);
        }
    }

    public static File aug() {
        File aue = aue();
        if (!aue.exists()) {
            aue.mkdirs();
        }
        return new File(aue, "debugDashboard.zip");
    }

    public static String aVF() {
        return "meter.js";
    }
}
