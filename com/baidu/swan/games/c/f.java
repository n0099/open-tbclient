package com.baidu.swan.games.c;

import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.TbConfig;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class f {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final String TAG = f.class.getSimpleName();
    private static volatile boolean aHb = false;
    private static volatile boolean byq = false;
    private static volatile List<com.baidu.swan.apps.m.a.b> byr = new ArrayList();

    private f() {
    }

    public static void bo(boolean z) {
        aHb = z;
        com.baidu.swan.apps.console.c.bo(z);
    }

    public static void Wd() {
        synchronized (f.class) {
            byr = new ArrayList();
        }
        byq = false;
    }

    public static void We() {
        if (aHb && !byq) {
            synchronized (f.class) {
                if (byr != null) {
                    for (int i = 0; i < byr.size(); i++) {
                        com.baidu.swan.apps.w.e.LE().a("console", byr.get(i));
                    }
                    byr.clear();
                    byr = null;
                }
            }
            byq = true;
        }
    }

    private static String fQ(int i) {
        switch (i) {
            case 1:
                return TbConfig.TMP_LOG_DIR_NAME;
            case 2:
            case 6:
                return "debug";
            case 3:
                return Config.LAUNCH_INFO;
            case 4:
                return BdStatsConstant.StatsType.ERROR;
            case 5:
                return "warn";
            default:
                return TbConfig.TMP_LOG_DIR_NAME;
        }
    }

    public static void x(int i, String str) {
        ba(fQ(i), str);
    }

    public static void ba(String str, String str2) {
        if (aHb) {
            a(c.aY(str, str2));
        }
    }

    public static void bb(String str, String str2) {
        if (aHb) {
            a(c.aZ(str, str2));
        }
    }

    private static void a(com.baidu.swan.apps.m.a.b bVar) {
        if (!byq) {
            synchronized (f.class) {
                if (byr != null) {
                    byr.add(bVar);
                    return;
                }
            }
        }
        com.baidu.swan.apps.w.e.LE().a("console", bVar);
    }
}
