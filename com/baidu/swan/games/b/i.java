package com.baidu.swan.games.b;

import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.tbadk.TbConfig;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes11.dex */
public class i {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final String TAG = i.class.getSimpleName();
    private static volatile boolean bjX = false;
    private static volatile boolean cmz = false;
    private static volatile List<com.baidu.swan.apps.n.a.b> cmA = new ArrayList();

    private i() {
    }

    public static void ci(boolean z) {
        bjX = z;
        com.baidu.swan.apps.console.c.ci(z);
    }

    public static void anp() {
        synchronized (i.class) {
            cmA = new ArrayList();
        }
        cmz = false;
    }

    public static void anq() {
        if (bjX && !cmz) {
            synchronized (i.class) {
                if (cmA != null) {
                    for (int i = 0; i < cmA.size(); i++) {
                        com.baidu.swan.apps.y.f.WV().a("console", cmA.get(i));
                    }
                    cmA.clear();
                    cmA = null;
                }
            }
            cmz = true;
        }
    }

    private static String hP(int i) {
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

    public static void H(int i, String str) {
        bC(hP(i), str);
    }

    public static void bC(String str, String str2) {
        if (bjX) {
            a(c.bA(str, str2));
        }
    }

    public static void bD(String str, String str2) {
        if (bjX) {
            a(c.bB(str, str2));
        }
    }

    private static void a(com.baidu.swan.apps.n.a.b bVar) {
        if (!cmz) {
            synchronized (i.class) {
                if (cmA != null) {
                    cmA.add(bVar);
                    return;
                }
            }
        }
        com.baidu.swan.apps.y.f.WV().a("console", bVar);
    }
}
