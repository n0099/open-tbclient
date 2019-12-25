package com.baidu.swan.games.b;

import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.tbadk.TbConfig;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class i {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final String TAG = i.class.getSimpleName();
    private static volatile boolean beF = false;
    private static volatile boolean chU = false;
    private static volatile List<com.baidu.swan.apps.n.a.b> chV = new ArrayList();

    private i() {
    }

    public static void bU(boolean z) {
        beF = z;
        com.baidu.swan.apps.console.c.bU(z);
    }

    public static void akD() {
        synchronized (i.class) {
            chV = new ArrayList();
        }
        chU = false;
    }

    public static void akE() {
        if (beF && !chU) {
            synchronized (i.class) {
                if (chV != null) {
                    for (int i = 0; i < chV.size(); i++) {
                        com.baidu.swan.apps.y.f.Uf().a("console", chV.get(i));
                    }
                    chV.clear();
                    chV = null;
                }
            }
            chU = true;
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

    public static void D(int i, String str) {
        bt(hy(i), str);
    }

    public static void bt(String str, String str2) {
        if (beF) {
            a(c.br(str, str2));
        }
    }

    public static void bu(String str, String str2) {
        if (beF) {
            a(c.bs(str, str2));
        }
    }

    private static void a(com.baidu.swan.apps.n.a.b bVar) {
        if (!chU) {
            synchronized (i.class) {
                if (chV != null) {
                    chV.add(bVar);
                    return;
                }
            }
        }
        com.baidu.swan.apps.y.f.Uf().a("console", bVar);
    }
}
