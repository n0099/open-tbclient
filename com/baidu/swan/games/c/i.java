package com.baidu.swan.games.c;

import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.tbadk.TbConfig;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class i {
    private static volatile boolean cMN = false;
    private static volatile boolean eeX = false;
    private static volatile List<com.baidu.swan.apps.event.a.b> eeY = new ArrayList();

    private i() {
    }

    public static void eY(boolean z) {
        cMN = z;
        com.baidu.swan.apps.console.c.eY(z);
    }

    public static void aVP() {
        synchronized (i.class) {
            eeY = new ArrayList();
        }
        eeX = false;
    }

    public static void aVQ() {
        if (cMN && !eeX) {
            synchronized (i.class) {
                if (eeY != null) {
                    for (int i = 0; i < eeY.size(); i++) {
                        com.baidu.swan.apps.v.f.aAl().a("console", eeY.get(i));
                    }
                    eeY.clear();
                    eeY = null;
                }
            }
            eeX = true;
        }
    }

    private static String lc(int i) {
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

    public static void aC(int i, String str) {
        cR(lc(i), str);
    }

    public static void cR(String str, String str2) {
        if (cMN) {
            a(c.cP(str, str2));
        }
    }

    public static void cS(String str, String str2) {
        if (cMN) {
            a(c.cQ(str, str2));
        }
    }

    private static void a(com.baidu.swan.apps.event.a.b bVar) {
        if (!eeX) {
            synchronized (i.class) {
                if (eeY != null) {
                    eeY.add(bVar);
                    return;
                }
            }
        }
        com.baidu.swan.apps.v.f.aAl().a("console", bVar);
    }
}
