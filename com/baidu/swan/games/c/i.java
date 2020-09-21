package com.baidu.swan.games.c;

import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.tbadk.TbConfig;
import com.baidu.webkit.internal.ETAG;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class i {
    private static volatile boolean cev = false;
    private static volatile boolean dsZ = false;
    private static volatile List<com.baidu.swan.apps.event.a.b> dta = new ArrayList();

    private i() {
    }

    public static void dH(boolean z) {
        cev = z;
        com.baidu.swan.apps.console.c.dH(z);
    }

    public static void aNC() {
        synchronized (i.class) {
            dta = new ArrayList();
        }
        dsZ = false;
    }

    public static void aND() {
        if (cev && !dsZ) {
            synchronized (i.class) {
                if (dta != null) {
                    for (int i = 0; i < dta.size(); i++) {
                        com.baidu.swan.apps.v.f.asJ().a("console", dta.get(i));
                    }
                    dta.clear();
                    dta = null;
                }
            }
            dsZ = true;
        }
    }

    private static String ll(int i) {
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

    public static void ae(int i, String str) {
        cH(ll(i), str);
    }

    public static void cH(String str, String str2) {
        if (cev) {
            a(c.cF(str, str2));
        }
    }

    public static void cI(String str, String str2) {
        if (cev) {
            a(c.cG(str, str2));
        }
    }

    private static void a(com.baidu.swan.apps.event.a.b bVar) {
        if (!dsZ) {
            synchronized (i.class) {
                if (dta != null) {
                    dta.add(bVar);
                    return;
                }
            }
        }
        com.baidu.swan.apps.v.f.asJ().a("console", bVar);
    }
}
