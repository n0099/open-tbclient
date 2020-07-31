package com.baidu.swan.games.c;

import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.tbadk.TbConfig;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class i {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final String TAG = i.class.getSimpleName();
    private static volatile boolean bWG = false;
    private static volatile boolean dgJ = false;
    private static volatile List<com.baidu.swan.apps.event.a.b> dgK = new ArrayList();

    private i() {
    }

    public static void dz(boolean z) {
        bWG = z;
        com.baidu.swan.apps.console.c.dz(z);
    }

    public static void aEc() {
        synchronized (i.class) {
            dgK = new ArrayList();
        }
        dgJ = false;
    }

    public static void aEd() {
        if (bWG && !dgJ) {
            synchronized (i.class) {
                if (dgK != null) {
                    for (int i = 0; i < dgK.size(); i++) {
                        com.baidu.swan.apps.v.f.akr().a("console", dgK.get(i));
                    }
                    dgK.clear();
                    dgK = null;
                }
            }
            dgJ = true;
        }
    }

    private static String iR(int i) {
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

    public static void af(int i, String str) {
        cn(iR(i), str);
    }

    public static void cn(String str, String str2) {
        if (bWG) {
            a(c.cl(str, str2));
        }
    }

    public static void co(String str, String str2) {
        if (bWG) {
            a(c.cm(str, str2));
        }
    }

    private static void a(com.baidu.swan.apps.event.a.b bVar) {
        if (!dgJ) {
            synchronized (i.class) {
                if (dgK != null) {
                    dgK.add(bVar);
                    return;
                }
            }
        }
        com.baidu.swan.apps.v.f.akr().a("console", bVar);
    }
}
