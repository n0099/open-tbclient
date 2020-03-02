package com.baidu.swan.games.b;

import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.tbadk.TbConfig;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes11.dex */
public class i {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final String TAG = i.class.getSimpleName();
    private static volatile boolean bjJ = false;
    private static volatile boolean cmn = false;
    private static volatile List<com.baidu.swan.apps.n.a.b> cmo = new ArrayList();

    private i() {
    }

    public static void ch(boolean z) {
        bjJ = z;
        com.baidu.swan.apps.console.c.ch(z);
    }

    public static void anm() {
        synchronized (i.class) {
            cmo = new ArrayList();
        }
        cmn = false;
    }

    public static void ann() {
        if (bjJ && !cmn) {
            synchronized (i.class) {
                if (cmo != null) {
                    for (int i = 0; i < cmo.size(); i++) {
                        com.baidu.swan.apps.y.f.WS().a("console", cmo.get(i));
                    }
                    cmo.clear();
                    cmo = null;
                }
            }
            cmn = true;
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
        if (bjJ) {
            a(c.bB(str, str2));
        }
    }

    public static void bE(String str, String str2) {
        if (bjJ) {
            a(c.bC(str, str2));
        }
    }

    private static void a(com.baidu.swan.apps.n.a.b bVar) {
        if (!cmn) {
            synchronized (i.class) {
                if (cmo != null) {
                    cmo.add(bVar);
                    return;
                }
            }
        }
        com.baidu.swan.apps.y.f.WS().a("console", bVar);
    }
}
