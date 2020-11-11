package com.baidu.swan.games.c;

import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.tbadk.TbConfig;
import com.baidu.webkit.internal.ETAG;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
public class i {
    private static volatile boolean cFf = false;
    private static volatile boolean dTq = false;
    private static volatile List<com.baidu.swan.apps.event.a.b> dTr = new ArrayList();

    private i() {
    }

    public static void ez(boolean z) {
        cFf = z;
        com.baidu.swan.apps.console.c.ez(z);
    }

    public static void aUF() {
        synchronized (i.class) {
            dTr = new ArrayList();
        }
        dTq = false;
    }

    public static void aUG() {
        if (cFf && !dTq) {
            synchronized (i.class) {
                if (dTr != null) {
                    for (int i = 0; i < dTr.size(); i++) {
                        com.baidu.swan.apps.v.f.azO().a("console", dTr.get(i));
                    }
                    dTr.clear();
                    dTr = null;
                }
            }
            dTq = true;
        }
    }

    private static String md(int i) {
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
        cT(md(i), str);
    }

    public static void cT(String str, String str2) {
        if (cFf) {
            a(c.cR(str, str2));
        }
    }

    public static void cU(String str, String str2) {
        if (cFf) {
            a(c.cS(str, str2));
        }
    }

    private static void a(com.baidu.swan.apps.event.a.b bVar) {
        if (!dTq) {
            synchronized (i.class) {
                if (dTr != null) {
                    dTr.add(bVar);
                    return;
                }
            }
        }
        com.baidu.swan.apps.v.f.azO().a("console", bVar);
    }
}
