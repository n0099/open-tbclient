package com.baidu.swan.games.c;

import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.tbadk.TbConfig;
import com.baidu.webkit.internal.ETAG;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
public class i {
    private static volatile boolean cqL = false;
    private static volatile boolean dFb = false;
    private static volatile List<com.baidu.swan.apps.event.a.b> dFc = new ArrayList();

    private i() {
    }

    public static void ed(boolean z) {
        cqL = z;
        com.baidu.swan.apps.console.c.ed(z);
    }

    public static void aQl() {
        synchronized (i.class) {
            dFc = new ArrayList();
        }
        dFb = false;
    }

    public static void aQm() {
        if (cqL && !dFb) {
            synchronized (i.class) {
                if (dFc != null) {
                    for (int i = 0; i < dFc.size(); i++) {
                        com.baidu.swan.apps.v.f.avu().a("console", dFc.get(i));
                    }
                    dFc.clear();
                    dFc = null;
                }
            }
            dFb = true;
        }
    }

    private static String lI(int i) {
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

    public static void ap(int i, String str) {
        cM(lI(i), str);
    }

    public static void cM(String str, String str2) {
        if (cqL) {
            a(c.cK(str, str2));
        }
    }

    public static void cN(String str, String str2) {
        if (cqL) {
            a(c.cL(str, str2));
        }
    }

    private static void a(com.baidu.swan.apps.event.a.b bVar) {
        if (!dFb) {
            synchronized (i.class) {
                if (dFc != null) {
                    dFc.add(bVar);
                    return;
                }
            }
        }
        com.baidu.swan.apps.v.f.avu().a("console", bVar);
    }
}
