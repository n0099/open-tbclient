package com.baidu.swan.games.c;

import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.tbadk.TbConfig;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class i {
    private static volatile boolean cKz = false;
    private static volatile boolean ecQ = false;
    private static volatile List<com.baidu.swan.apps.event.a.b> ecR = new ArrayList();

    private i() {
    }

    public static void eW(boolean z) {
        cKz = z;
        com.baidu.swan.apps.console.c.eW(z);
    }

    public static void aVD() {
        synchronized (i.class) {
            ecR = new ArrayList();
        }
        ecQ = false;
    }

    public static void aVE() {
        if (cKz && !ecQ) {
            synchronized (i.class) {
                if (ecR != null) {
                    for (int i = 0; i < ecR.size(); i++) {
                        com.baidu.swan.apps.v.f.azN().a("console", ecR.get(i));
                    }
                    ecR.clear();
                    ecR = null;
                }
            }
            ecQ = true;
        }
    }

    private static String kZ(int i) {
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

    public static void ay(int i, String str) {
        cX(kZ(i), str);
    }

    public static void cX(String str, String str2) {
        if (cKz) {
            a(c.cV(str, str2));
        }
    }

    public static void cY(String str, String str2) {
        if (cKz) {
            a(c.cW(str, str2));
        }
    }

    private static void a(com.baidu.swan.apps.event.a.b bVar) {
        if (!ecQ) {
            synchronized (i.class) {
                if (ecR != null) {
                    ecR.add(bVar);
                    return;
                }
            }
        }
        com.baidu.swan.apps.v.f.azN().a("console", bVar);
    }
}
