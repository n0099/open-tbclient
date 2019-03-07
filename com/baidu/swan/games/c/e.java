package com.baidu.swan.games.c;

import com.baidu.tbadk.TbConfig;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class e {
    private static final boolean DEBUG = com.baidu.swan.apps.c.DEBUG;
    private static final String TAG = e.class.getSimpleName();
    private static volatile boolean amJ = false;
    private static volatile boolean bbc = false;
    private static volatile List<com.baidu.swan.apps.m.a.b> bbd = new ArrayList();

    private e() {
    }

    public static void aR(boolean z) {
        amJ = z;
        com.baidu.swan.apps.console.c.aR(z);
    }

    public static void NC() {
        synchronized (e.class) {
            bbd = new ArrayList();
        }
        bbc = false;
    }

    public static void ND() {
        if (amJ && !bbc) {
            synchronized (e.class) {
                if (bbd != null) {
                    for (int i = 0; i < bbd.size(); i++) {
                        com.baidu.swan.apps.w.e.Ec().a("console", bbd.get(i));
                    }
                    bbd.clear();
                    bbd = null;
                }
            }
            bbc = true;
        }
    }

    private static String eC(int i) {
        switch (i) {
            case 1:
                return TbConfig.TMP_LOG_DIR_NAME;
            case 2:
            case 6:
                return "debug";
            case 3:
                return "info";
            case 4:
                return "error";
            case 5:
                return "warn";
            default:
                return TbConfig.TMP_LOG_DIR_NAME;
        }
    }

    public static void t(int i, String str) {
        aQ(eC(i), str);
    }

    public static void aQ(String str, String str2) {
        if (amJ) {
            a(b.aO(str, str2));
        }
    }

    public static void aR(String str, String str2) {
        if (amJ) {
            a(b.aP(str, str2));
        }
    }

    private static void a(com.baidu.swan.apps.m.a.b bVar) {
        if (!bbc) {
            synchronized (e.class) {
                if (bbd != null) {
                    bbd.add(bVar);
                    return;
                }
            }
        }
        com.baidu.swan.apps.w.e.Ec().a("console", bVar);
    }
}
