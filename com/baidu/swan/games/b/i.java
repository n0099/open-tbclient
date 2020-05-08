package com.baidu.swan.games.b;

import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.tbadk.TbConfig;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes11.dex */
public class i {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final String TAG = i.class.getSimpleName();
    private static volatile boolean bIk = false;
    private static volatile boolean cLB = false;
    private static volatile List<com.baidu.swan.apps.n.a.b> cLC = new ArrayList();

    private i() {
    }

    public static void de(boolean z) {
        bIk = z;
        com.baidu.swan.apps.console.c.de(z);
    }

    public static void avC() {
        synchronized (i.class) {
            cLC = new ArrayList();
        }
        cLB = false;
    }

    public static void avD() {
        if (bIk && !cLB) {
            synchronized (i.class) {
                if (cLC != null) {
                    for (int i = 0; i < cLC.size(); i++) {
                        com.baidu.swan.apps.y.f.aeJ().a("console", cLC.get(i));
                    }
                    cLC.clear();
                    cLC = null;
                }
            }
            cLB = true;
        }
    }

    private static String hW(int i) {
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

    public static void Y(int i, String str) {
        bN(hW(i), str);
    }

    public static void bN(String str, String str2) {
        if (bIk) {
            a(c.bL(str, str2));
        }
    }

    public static void bO(String str, String str2) {
        if (bIk) {
            a(c.bM(str, str2));
        }
    }

    private static void a(com.baidu.swan.apps.n.a.b bVar) {
        if (!cLB) {
            synchronized (i.class) {
                if (cLC != null) {
                    cLC.add(bVar);
                    return;
                }
            }
        }
        com.baidu.swan.apps.y.f.aeJ().a("console", bVar);
    }
}
