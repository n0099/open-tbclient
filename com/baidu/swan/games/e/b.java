package com.baidu.swan.games.e;

import com.baidu.swan.d.d;
import java.io.File;
/* loaded from: classes7.dex */
public class b {
    public static File afh() {
        return com.baidu.swan.games.l.a.td("aigames_debug_dashboard");
    }

    public static void afi() {
        File afh = afh();
        if (afh.exists()) {
            d.deleteFile(afh);
        }
    }

    public static File afj() {
        File afh = afh();
        if (!afh.exists()) {
            afh.mkdirs();
        }
        return new File(afh, "debugDashboard.zip");
    }

    public static String aEe() {
        return "meter.js";
    }
}
