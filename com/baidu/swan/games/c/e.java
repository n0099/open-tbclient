package com.baidu.swan.games.c;

import com.baidu.tbadk.TbConfig;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class e {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final String TAG = e.class.getSimpleName();
    private static volatile boolean amK = false;
    private static volatile boolean bbd = false;
    private static volatile List<com.baidu.swan.apps.m.a.b> bbe = new ArrayList();

    private e() {
    }

    public static void aR(boolean z) {
        amK = z;
        com.baidu.swan.apps.console.c.aR(z);
    }

    public static void NC() {
        synchronized (e.class) {
            bbe = new ArrayList();
        }
        bbd = false;
    }

    public static void ND() {
        if (amK && !bbd) {
            synchronized (e.class) {
                if (bbe != null) {
                    for (int i = 0; i < bbe.size(); i++) {
                        com.baidu.swan.apps.w.e.Ec().a("console", bbe.get(i));
                    }
                    bbe.clear();
                    bbe = null;
                }
            }
            bbd = true;
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
        if (amK) {
            a(b.aO(str, str2));
        }
    }

    public static void aR(String str, String str2) {
        if (amK) {
            a(b.aP(str, str2));
        }
    }

    private static void a(com.baidu.swan.apps.m.a.b bVar) {
        if (!bbd) {
            synchronized (e.class) {
                if (bbe != null) {
                    bbe.add(bVar);
                    return;
                }
            }
        }
        com.baidu.swan.apps.w.e.Ec().a("console", bVar);
    }
}
