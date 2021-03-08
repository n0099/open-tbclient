package com.baidu.swan.games.c;

import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.tbadk.TbConfig;
import com.baidu.webkit.internal.ETAG;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class i {
    private static volatile boolean cOn = false;
    private static volatile boolean egz = false;
    private static volatile List<com.baidu.swan.apps.event.a.b> egA = new ArrayList();

    private i() {
    }

    public static void eY(boolean z) {
        cOn = z;
        com.baidu.swan.apps.console.c.eY(z);
    }

    public static void aVS() {
        synchronized (i.class) {
            egA = new ArrayList();
        }
        egz = false;
    }

    public static void aVT() {
        if (cOn && !egz) {
            synchronized (i.class) {
                if (egA != null) {
                    for (int i = 0; i < egA.size(); i++) {
                        com.baidu.swan.apps.v.f.aAo().a("console", egA.get(i));
                    }
                    egA.clear();
                    egA = null;
                }
            }
            egz = true;
        }
    }

    private static String ld(int i) {
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

    public static void aC(int i, String str) {
        cR(ld(i), str);
    }

    public static void cR(String str, String str2) {
        if (cOn) {
            a(c.cP(str, str2));
        }
    }

    public static void cS(String str, String str2) {
        if (cOn) {
            a(c.cQ(str, str2));
        }
    }

    private static void a(com.baidu.swan.apps.event.a.b bVar) {
        if (!egz) {
            synchronized (i.class) {
                if (egA != null) {
                    egA.add(bVar);
                    return;
                }
            }
        }
        com.baidu.swan.apps.v.f.aAo().a("console", bVar);
    }
}
