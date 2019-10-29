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
    private static volatile boolean aHt = false;
    private static volatile boolean bzh = false;
    private static volatile List<com.baidu.swan.apps.m.a.b> bzi = new ArrayList();

    private f() {
    }

    public static void bo(boolean z) {
        aHt = z;
        com.baidu.swan.apps.console.c.bo(z);
    }

    public static void Wf() {
        synchronized (f.class) {
            bzi = new ArrayList();
        }
        bzh = false;
    }

    public static void Wg() {
        if (aHt && !bzh) {
            synchronized (f.class) {
                if (bzi != null) {
                    for (int i = 0; i < bzi.size(); i++) {
                        com.baidu.swan.apps.w.e.LD().a("console", bzi.get(i));
                    }
                    bzi.clear();
                    bzi = null;
                }
            }
            bzh = true;
        }
    }

    private static String fR(int i) {
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

    public static void y(int i, String str) {
        ba(fR(i), str);
    }

    public static void ba(String str, String str2) {
        if (aHt) {
            a(c.aY(str, str2));
        }
    }

    public static void bb(String str, String str2) {
        if (aHt) {
            a(c.aZ(str, str2));
        }
    }

    private static void a(com.baidu.swan.apps.m.a.b bVar) {
        if (!bzh) {
            synchronized (f.class) {
                if (bzi != null) {
                    bzi.add(bVar);
                    return;
                }
            }
        }
        com.baidu.swan.apps.w.e.LD().a("console", bVar);
    }
}
