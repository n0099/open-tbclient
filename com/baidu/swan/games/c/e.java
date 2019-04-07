package com.baidu.swan.games.c;

import com.baidu.tbadk.TbConfig;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class e {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final String TAG = e.class.getSimpleName();
    private static volatile boolean amO = false;
    private static volatile boolean bbg = false;
    private static volatile List<com.baidu.swan.apps.m.a.b> bbh = new ArrayList();

    private e() {
    }

    public static void aR(boolean z) {
        amO = z;
        com.baidu.swan.apps.console.c.aR(z);
    }

    public static void NA() {
        synchronized (e.class) {
            bbh = new ArrayList();
        }
        bbg = false;
    }

    public static void NB() {
        if (amO && !bbg) {
            synchronized (e.class) {
                if (bbh != null) {
                    for (int i = 0; i < bbh.size(); i++) {
                        com.baidu.swan.apps.w.e.Ea().a("console", bbh.get(i));
                    }
                    bbh.clear();
                    bbh = null;
                }
            }
            bbg = true;
        }
    }

    private static String eB(int i) {
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
        aQ(eB(i), str);
    }

    public static void aQ(String str, String str2) {
        if (amO) {
            a(b.aO(str, str2));
        }
    }

    public static void aR(String str, String str2) {
        if (amO) {
            a(b.aP(str, str2));
        }
    }

    private static void a(com.baidu.swan.apps.m.a.b bVar) {
        if (!bbg) {
            synchronized (e.class) {
                if (bbh != null) {
                    bbh.add(bVar);
                    return;
                }
            }
        }
        com.baidu.swan.apps.w.e.Ea().a("console", bVar);
    }
}
