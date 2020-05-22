package com.baidu.swan.games.c;

import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.tbadk.TbConfig;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes11.dex */
public class i {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final String TAG = i.class.getSimpleName();
    private static volatile boolean bRb = false;
    private static volatile boolean cWo = false;
    private static volatile List<com.baidu.swan.apps.event.a.b> cWp = new ArrayList();

    private i() {
    }

    public static void dr(boolean z) {
        bRb = z;
        com.baidu.swan.apps.console.c.dr(z);
    }

    public static void azr() {
        synchronized (i.class) {
            cWp = new ArrayList();
        }
        cWo = false;
    }

    public static void azs() {
        if (bRb && !cWo) {
            synchronized (i.class) {
                if (cWp != null) {
                    for (int i = 0; i < cWp.size(); i++) {
                        com.baidu.swan.apps.w.f.ahV().a("console", cWp.get(i));
                    }
                    cWp.clear();
                    cWp = null;
                }
            }
            cWo = true;
        }
    }

    private static String in(int i) {
        switch (i) {
            case 1:
                return TbConfig.TMP_LOG_DIR_NAME;
            case 2:
            case 6:
                return "debug";
            case 3:
                return "info";
            case 4:
                return BdStatsConstant.StatsType.ERROR;
            case 5:
                return "warn";
            default:
                return TbConfig.TMP_LOG_DIR_NAME;
        }
    }

    public static void ac(int i, String str) {
        ci(in(i), str);
    }

    public static void ci(String str, String str2) {
        if (bRb) {
            a(c.cg(str, str2));
        }
    }

    public static void cj(String str, String str2) {
        if (bRb) {
            a(c.ch(str, str2));
        }
    }

    private static void a(com.baidu.swan.apps.event.a.b bVar) {
        if (!cWo) {
            synchronized (i.class) {
                if (cWp != null) {
                    cWp.add(bVar);
                    return;
                }
            }
        }
        com.baidu.swan.apps.w.f.ahV().a("console", bVar);
    }
}
