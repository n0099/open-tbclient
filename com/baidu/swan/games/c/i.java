package com.baidu.swan.games.c;

import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.tbadk.TbConfig;
import com.baidu.webkit.internal.ETAG;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class i {
    private static volatile boolean cDv = false;
    private static volatile boolean dRI = false;
    private static volatile List<com.baidu.swan.apps.event.a.b> dRJ = new ArrayList();

    private i() {
    }

    public static void eC(boolean z) {
        cDv = z;
        com.baidu.swan.apps.console.c.eC(z);
    }

    public static void aTX() {
        synchronized (i.class) {
            dRJ = new ArrayList();
        }
        dRI = false;
    }

    public static void aTY() {
        if (cDv && !dRI) {
            synchronized (i.class) {
                if (dRJ != null) {
                    for (int i = 0; i < dRJ.size(); i++) {
                        com.baidu.swan.apps.v.f.azg().a("console", dRJ.get(i));
                    }
                    dRJ.clear();
                    dRJ = null;
                }
            }
            dRI = true;
        }
    }

    private static String lZ(int i) {
        switch (i) {
            case 1:
                return TbConfig.TMP_LOG_DIR_NAME;
            case 2:
            case 6:
                return ETAG.KEY_DEBUG;
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

    public static void av(int i, String str) {
        cS(lZ(i), str);
    }

    public static void cS(String str, String str2) {
        if (cDv) {
            a(c.cQ(str, str2));
        }
    }

    public static void cT(String str, String str2) {
        if (cDv) {
            a(c.cR(str, str2));
        }
    }

    private static void a(com.baidu.swan.apps.event.a.b bVar) {
        if (!dRI) {
            synchronized (i.class) {
                if (dRJ != null) {
                    dRJ.add(bVar);
                    return;
                }
            }
        }
        com.baidu.swan.apps.v.f.azg().a("console", bVar);
    }
}
