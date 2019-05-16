package com.baidu.swan.games.c;

import com.baidu.tbadk.TbConfig;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class f {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final String TAG = f.class.getSimpleName();
    private static volatile boolean anb = false;
    private static volatile boolean bfe = false;
    private static volatile List<com.baidu.swan.apps.m.a.b> bff = new ArrayList();

    private f() {
    }

    public static void aT(boolean z) {
        anb = z;
        com.baidu.swan.apps.console.c.aT(z);
    }

    public static void Qr() {
        synchronized (f.class) {
            bff = new ArrayList();
        }
        bfe = false;
    }

    public static void Qs() {
        if (anb && !bfe) {
            synchronized (f.class) {
                if (bff != null) {
                    for (int i = 0; i < bff.size(); i++) {
                        com.baidu.swan.apps.w.e.FV().a("console", bff.get(i));
                    }
                    bff.clear();
                    bff = null;
                }
            }
            bfe = true;
        }
    }

    private static String eR(int i) {
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

    public static void u(int i, String str) {
        aT(eR(i), str);
    }

    public static void aT(String str, String str2) {
        if (anb) {
            a(c.aR(str, str2));
        }
    }

    public static void aU(String str, String str2) {
        if (anb) {
            a(c.aS(str, str2));
        }
    }

    private static void a(com.baidu.swan.apps.m.a.b bVar) {
        if (!bfe) {
            synchronized (f.class) {
                if (bff != null) {
                    bff.add(bVar);
                    return;
                }
            }
        }
        com.baidu.swan.apps.w.e.FV().a("console", bVar);
    }
}
