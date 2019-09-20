package com.baidu.swan.games.c;

import com.baidu.mobstat.Config;
import com.baidu.tbadk.TbConfig;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class f {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final String TAG = f.class.getSimpleName();
    private static volatile boolean aoc = false;
    private static volatile boolean bgo = false;
    private static volatile List<com.baidu.swan.apps.m.a.b> bgp = new ArrayList();

    private f() {
    }

    public static void aW(boolean z) {
        aoc = z;
        com.baidu.swan.apps.console.c.aW(z);
    }

    public static void Ro() {
        synchronized (f.class) {
            bgp = new ArrayList();
        }
        bgo = false;
    }

    public static void Rp() {
        if (aoc && !bgo) {
            synchronized (f.class) {
                if (bgp != null) {
                    for (int i = 0; i < bgp.size(); i++) {
                        com.baidu.swan.apps.w.e.GJ().a("console", bgp.get(i));
                    }
                    bgp.clear();
                    bgp = null;
                }
            }
            bgo = true;
        }
    }

    private static String eW(int i) {
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
        aT(eW(i), str);
    }

    public static void aT(String str, String str2) {
        if (aoc) {
            a(c.aR(str, str2));
        }
    }

    public static void aU(String str, String str2) {
        if (aoc) {
            a(c.aS(str, str2));
        }
    }

    private static void a(com.baidu.swan.apps.m.a.b bVar) {
        if (!bgo) {
            synchronized (f.class) {
                if (bgp != null) {
                    bgp.add(bVar);
                    return;
                }
            }
        }
        com.baidu.swan.apps.w.e.GJ().a("console", bVar);
    }
}
