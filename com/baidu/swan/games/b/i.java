package com.baidu.swan.games.b;

import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.tbadk.TbConfig;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
public class i {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final String TAG = i.class.getSimpleName();
    private static volatile boolean bfv = false;
    private static volatile boolean cii = false;
    private static volatile List<com.baidu.swan.apps.n.a.b> cij = new ArrayList();

    private i() {
    }

    public static void bZ(boolean z) {
        bfv = z;
        com.baidu.swan.apps.console.c.bZ(z);
    }

    public static void akW() {
        synchronized (i.class) {
            cij = new ArrayList();
        }
        cii = false;
    }

    public static void akX() {
        if (bfv && !cii) {
            synchronized (i.class) {
                if (cij != null) {
                    for (int i = 0; i < cij.size(); i++) {
                        com.baidu.swan.apps.y.f.UC().a("console", cij.get(i));
                    }
                    cij.clear();
                    cij = null;
                }
            }
            cii = true;
        }
    }

    private static String hy(int i) {
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

    public static void F(int i, String str) {
        bu(hy(i), str);
    }

    public static void bu(String str, String str2) {
        if (bfv) {
            a(c.bs(str, str2));
        }
    }

    public static void bv(String str, String str2) {
        if (bfv) {
            a(c.bt(str, str2));
        }
    }

    private static void a(com.baidu.swan.apps.n.a.b bVar) {
        if (!cii) {
            synchronized (i.class) {
                if (cij != null) {
                    cij.add(bVar);
                    return;
                }
            }
        }
        com.baidu.swan.apps.y.f.UC().a("console", bVar);
    }
}
