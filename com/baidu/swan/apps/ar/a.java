package com.baidu.swan.apps.ar;

import com.baidu.swan.apps.as.g;
import com.baidu.swan.apps.b;
import com.baidu.swan.games.h.j;
/* loaded from: classes11.dex */
public class a {
    private static final boolean DEBUG = b.DEBUG;
    private static int bYh = 0;

    public static void af(int i, int i2) {
        com.baidu.swan.apps.extcore.cores.a.RR().Z(i, i2);
        g.agH();
        if (i == 0) {
            bYh = 2;
        } else if (i2 > i) {
            bYh = 1;
            j.anR();
        }
    }

    public static int agt() {
        return bYh;
    }
}
