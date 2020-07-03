package com.baidu.swan.games.c;

import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.tbadk.TbConfig;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes11.dex */
public class i {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final String TAG = i.class.getSimpleName();
    private static volatile boolean bVP = false;
    private static volatile boolean dba = false;
    private static volatile List<com.baidu.swan.apps.event.a.b> dbb = new ArrayList();

    private i() {
    }

    public static void dw(boolean z) {
        bVP = z;
        com.baidu.swan.apps.console.c.dw(z);
    }

    public static void aAx() {
        synchronized (i.class) {
            dbb = new ArrayList();
        }
        dba = false;
    }

    public static void aAy() {
        if (bVP && !dba) {
            synchronized (i.class) {
                if (dbb != null) {
                    for (int i = 0; i < dbb.size(); i++) {
                        com.baidu.swan.apps.w.f.ajb().a("console", dbb.get(i));
                    }
                    dbb.clear();
                    dbb = null;
                }
            }
            dba = true;
        }
    }

    private static String iA(int i) {
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

    public static void ae(int i, String str) {
        ck(iA(i), str);
    }

    public static void ck(String str, String str2) {
        if (bVP) {
            a(c.ci(str, str2));
        }
    }

    public static void cl(String str, String str2) {
        if (bVP) {
            a(c.cj(str, str2));
        }
    }

    private static void a(com.baidu.swan.apps.event.a.b bVar) {
        if (!dba) {
            synchronized (i.class) {
                if (dbb != null) {
                    dbb.add(bVar);
                    return;
                }
            }
        }
        com.baidu.swan.apps.w.f.ajb().a("console", bVar);
    }
}
