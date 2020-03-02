package com.baidu.swan.games.d;

import com.baidu.swan.d.c;
import java.io.File;
/* loaded from: classes11.dex */
public class b {
    public static File RT() {
        return com.baidu.swan.games.k.a.ph("aigames_debug_dashboard");
    }

    public static void RU() {
        File RT = RT();
        if (RT.exists()) {
            c.deleteFile(RT);
        }
    }

    public static File RV() {
        File RT = RT();
        if (!RT.exists()) {
            RT.mkdirs();
        }
        return new File(RT, "debugDashboard.zip");
    }

    public static String ano() {
        return "meter.js";
    }
}
