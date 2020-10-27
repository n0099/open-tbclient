package com.baidu.swan.games.c;

import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.tbadk.TbConfig;
import com.baidu.webkit.internal.ETAG;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
public class i {
    private static volatile boolean czm = false;
    private static volatile boolean dNy = false;
    private static volatile List<com.baidu.swan.apps.event.a.b> dNz = new ArrayList();

    private i() {
    }

    public static void eq(boolean z) {
        czm = z;
        com.baidu.swan.apps.console.c.eq(z);
    }

    public static void aSf() {
        synchronized (i.class) {
            dNz = new ArrayList();
        }
        dNy = false;
    }

    public static void aSg() {
        if (czm && !dNy) {
            synchronized (i.class) {
                if (dNz != null) {
                    for (int i = 0; i < dNz.size(); i++) {
                        com.baidu.swan.apps.v.f.axo().a("console", dNz.get(i));
                    }
                    dNz.clear();
                    dNz = null;
                }
            }
            dNy = true;
        }
    }

    private static String lT(int i) {
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

    public static void ar(int i, String str) {
        cT(lT(i), str);
    }

    public static void cT(String str, String str2) {
        if (czm) {
            a(c.cR(str, str2));
        }
    }

    public static void cU(String str, String str2) {
        if (czm) {
            a(c.cS(str, str2));
        }
    }

    private static void a(com.baidu.swan.apps.event.a.b bVar) {
        if (!dNy) {
            synchronized (i.class) {
                if (dNz != null) {
                    dNz.add(bVar);
                    return;
                }
            }
        }
        com.baidu.swan.apps.v.f.axo().a("console", bVar);
    }
}
