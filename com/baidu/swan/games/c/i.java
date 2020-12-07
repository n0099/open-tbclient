package com.baidu.swan.games.c;

import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.tbadk.TbConfig;
import com.baidu.webkit.internal.ETAG;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes25.dex */
public class i {
    private static volatile boolean cKq = false;
    private static volatile boolean dYG = false;
    private static volatile List<com.baidu.swan.apps.event.a.b> dYH = new ArrayList();

    private i() {
    }

    public static void eR(boolean z) {
        cKq = z;
        com.baidu.swan.apps.console.c.eR(z);
    }

    public static void aXc() {
        synchronized (i.class) {
            dYH = new ArrayList();
        }
        dYG = false;
    }

    public static void aXd() {
        if (cKq && !dYG) {
            synchronized (i.class) {
                if (dYH != null) {
                    for (int i = 0; i < dYH.size(); i++) {
                        com.baidu.swan.apps.v.f.aCp().a("console", dYH.get(i));
                    }
                    dYH.clear();
                    dYH = null;
                }
            }
            dYG = true;
        }
    }

    private static String mx(int i) {
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
        cZ(mx(i), str);
    }

    public static void cZ(String str, String str2) {
        if (cKq) {
            a(c.cX(str, str2));
        }
    }

    public static void da(String str, String str2) {
        if (cKq) {
            a(c.cY(str, str2));
        }
    }

    private static void a(com.baidu.swan.apps.event.a.b bVar) {
        if (!dYG) {
            synchronized (i.class) {
                if (dYH != null) {
                    dYH.add(bVar);
                    return;
                }
            }
        }
        com.baidu.swan.apps.v.f.aCp().a("console", bVar);
    }
}
