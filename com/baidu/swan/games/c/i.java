package com.baidu.swan.games.c;

import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.tbadk.TbConfig;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class i {
    private static volatile boolean cPl = false;
    private static volatile boolean ehD = false;
    private static volatile List<com.baidu.swan.apps.event.a.b> ehE = new ArrayList();

    private i() {
    }

    public static void fa(boolean z) {
        cPl = z;
        com.baidu.swan.apps.console.c.fa(z);
    }

    public static void aZw() {
        synchronized (i.class) {
            ehE = new ArrayList();
        }
        ehD = false;
    }

    public static void aZx() {
        if (cPl && !ehD) {
            synchronized (i.class) {
                if (ehE != null) {
                    for (int i = 0; i < ehE.size(); i++) {
                        com.baidu.swan.apps.v.f.aDG().a("console", ehE.get(i));
                    }
                    ehE.clear();
                    ehE = null;
                }
            }
            ehD = true;
        }
    }

    private static String mF(int i) {
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

    public static void ax(int i, String str) {
        cY(mF(i), str);
    }

    public static void cY(String str, String str2) {
        if (cPl) {
            a(c.cW(str, str2));
        }
    }

    public static void cZ(String str, String str2) {
        if (cPl) {
            a(c.cX(str, str2));
        }
    }

    private static void a(com.baidu.swan.apps.event.a.b bVar) {
        if (!ehD) {
            synchronized (i.class) {
                if (ehE != null) {
                    ehE.add(bVar);
                    return;
                }
            }
        }
        com.baidu.swan.apps.v.f.aDG().a("console", bVar);
    }
}
