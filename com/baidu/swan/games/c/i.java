package com.baidu.swan.games.c;

import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.tbadk.TbConfig;
import com.baidu.webkit.internal.ETAG;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class i {
    private static volatile boolean cco = false;
    private static volatile boolean dqS = false;
    private static volatile List<com.baidu.swan.apps.event.a.b> dqT = new ArrayList();

    private i() {
    }

    public static void dI(boolean z) {
        cco = z;
        com.baidu.swan.apps.console.c.dI(z);
    }

    public static void aMR() {
        synchronized (i.class) {
            dqT = new ArrayList();
        }
        dqS = false;
    }

    public static void aMS() {
        if (cco && !dqS) {
            synchronized (i.class) {
                if (dqT != null) {
                    for (int i = 0; i < dqT.size(); i++) {
                        com.baidu.swan.apps.v.f.arY().a("console", dqT.get(i));
                    }
                    dqT.clear();
                    dqT = null;
                }
            }
            dqS = true;
        }
    }

    private static String la(int i) {
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

    public static void ad(int i, String str) {
        cH(la(i), str);
    }

    public static void cH(String str, String str2) {
        if (cco) {
            a(c.cF(str, str2));
        }
    }

    public static void cI(String str, String str2) {
        if (cco) {
            a(c.cG(str, str2));
        }
    }

    private static void a(com.baidu.swan.apps.event.a.b bVar) {
        if (!dqS) {
            synchronized (i.class) {
                if (dqT != null) {
                    dqT.add(bVar);
                    return;
                }
            }
        }
        com.baidu.swan.apps.v.f.arY().a("console", bVar);
    }
}
