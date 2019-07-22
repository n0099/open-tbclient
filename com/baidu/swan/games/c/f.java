package com.baidu.swan.games.c;

import com.baidu.mobstat.Config;
import com.baidu.tbadk.TbConfig;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class f {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final String TAG = f.class.getSimpleName();
    private static volatile boolean anE = false;
    private static volatile boolean bfQ = false;
    private static volatile List<com.baidu.swan.apps.m.a.b> bfR = new ArrayList();

    private f() {
    }

    public static void aW(boolean z) {
        anE = z;
        com.baidu.swan.apps.console.c.aW(z);
    }

    public static void Rk() {
        synchronized (f.class) {
            bfR = new ArrayList();
        }
        bfQ = false;
    }

    public static void Rl() {
        if (anE && !bfQ) {
            synchronized (f.class) {
                if (bfR != null) {
                    for (int i = 0; i < bfR.size(); i++) {
                        com.baidu.swan.apps.w.e.GF().a("console", bfR.get(i));
                    }
                    bfR.clear();
                    bfR = null;
                }
            }
            bfQ = true;
        }
    }

    private static String eV(int i) {
        switch (i) {
            case 1:
                return TbConfig.TMP_LOG_DIR_NAME;
            case 2:
            case 6:
                return "debug";
            case 3:
                return Config.LAUNCH_INFO;
            case 4:
                return "error";
            case 5:
                return "warn";
            default:
                return TbConfig.TMP_LOG_DIR_NAME;
        }
    }

    public static void u(int i, String str) {
        aT(eV(i), str);
    }

    public static void aT(String str, String str2) {
        if (anE) {
            a(c.aR(str, str2));
        }
    }

    public static void aU(String str, String str2) {
        if (anE) {
            a(c.aS(str, str2));
        }
    }

    private static void a(com.baidu.swan.apps.m.a.b bVar) {
        if (!bfQ) {
            synchronized (f.class) {
                if (bfR != null) {
                    bfR.add(bVar);
                    return;
                }
            }
        }
        com.baidu.swan.apps.w.e.GF().a("console", bVar);
    }
}
