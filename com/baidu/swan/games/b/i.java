package com.baidu.swan.games.b;

import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.tbadk.TbConfig;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes11.dex */
public class i {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final String TAG = i.class.getSimpleName();
    private static volatile boolean bIf = false;
    private static volatile boolean cLv = false;
    private static volatile List<com.baidu.swan.apps.n.a.b> cLw = new ArrayList();

    private i() {
    }

    public static void de(boolean z) {
        bIf = z;
        com.baidu.swan.apps.console.c.de(z);
    }

    public static void avC() {
        synchronized (i.class) {
            cLw = new ArrayList();
        }
        cLv = false;
    }

    public static void avD() {
        if (bIf && !cLv) {
            synchronized (i.class) {
                if (cLw != null) {
                    for (int i = 0; i < cLw.size(); i++) {
                        com.baidu.swan.apps.y.f.aeK().a("console", cLw.get(i));
                    }
                    cLw.clear();
                    cLw = null;
                }
            }
            cLv = true;
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
        if (bIf) {
            a(c.bL(str, str2));
        }
    }

    public static void bO(String str, String str2) {
        if (bIf) {
            a(c.bM(str, str2));
        }
    }

    private static void a(com.baidu.swan.apps.n.a.b bVar) {
        if (!cLv) {
            synchronized (i.class) {
                if (cLw != null) {
                    cLw.add(bVar);
                    return;
                }
            }
        }
        com.baidu.swan.apps.y.f.aeK().a("console", bVar);
    }
}
