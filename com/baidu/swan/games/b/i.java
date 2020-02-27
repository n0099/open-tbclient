package com.baidu.swan.games.b;

import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.tbadk.TbConfig;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes11.dex */
public class i {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final String TAG = i.class.getSimpleName();
    private static volatile boolean bjI = false;
    private static volatile boolean cmm = false;
    private static volatile List<com.baidu.swan.apps.n.a.b> cmn = new ArrayList();

    private i() {
    }

    public static void ch(boolean z) {
        bjI = z;
        com.baidu.swan.apps.console.c.ch(z);
    }

    public static void ank() {
        synchronized (i.class) {
            cmn = new ArrayList();
        }
        cmm = false;
    }

    public static void anl() {
        if (bjI && !cmm) {
            synchronized (i.class) {
                if (cmn != null) {
                    for (int i = 0; i < cmn.size(); i++) {
                        com.baidu.swan.apps.y.f.WQ().a("console", cmn.get(i));
                    }
                    cmn.clear();
                    cmn = null;
                }
            }
            cmm = true;
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
        bD(hP(i), str);
    }

    public static void bD(String str, String str2) {
        if (bjI) {
            a(c.bB(str, str2));
        }
    }

    public static void bE(String str, String str2) {
        if (bjI) {
            a(c.bC(str, str2));
        }
    }

    private static void a(com.baidu.swan.apps.n.a.b bVar) {
        if (!cmm) {
            synchronized (i.class) {
                if (cmn != null) {
                    cmn.add(bVar);
                    return;
                }
            }
        }
        com.baidu.swan.apps.y.f.WQ().a("console", bVar);
    }
}
