package com.baidu.swan.games.c;

import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.tbadk.TbConfig;
import com.baidu.webkit.internal.ETAG;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class i {
    private static volatile boolean cct = false;
    private static volatile boolean dqW = false;
    private static volatile List<com.baidu.swan.apps.event.a.b> dqX = new ArrayList();

    private i() {
    }

    public static void dJ(boolean z) {
        cct = z;
        com.baidu.swan.apps.console.c.dJ(z);
    }

    public static void aMR() {
        synchronized (i.class) {
            dqX = new ArrayList();
        }
        dqW = false;
    }

    public static void aMS() {
        if (cct && !dqW) {
            synchronized (i.class) {
                if (dqX != null) {
                    for (int i = 0; i < dqX.size(); i++) {
                        com.baidu.swan.apps.v.f.arY().a("console", dqX.get(i));
                    }
                    dqX.clear();
                    dqX = null;
                }
            }
            dqW = true;
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
        if (cct) {
            a(c.cF(str, str2));
        }
    }

    public static void cI(String str, String str2) {
        if (cct) {
            a(c.cG(str, str2));
        }
    }

    private static void a(com.baidu.swan.apps.event.a.b bVar) {
        if (!dqW) {
            synchronized (i.class) {
                if (dqX != null) {
                    dqX.add(bVar);
                    return;
                }
            }
        }
        com.baidu.swan.apps.v.f.arY().a("console", bVar);
    }
}
