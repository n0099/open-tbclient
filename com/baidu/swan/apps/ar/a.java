package com.baidu.swan.apps.ar;

import com.baidu.swan.apps.as.g;
import com.baidu.swan.apps.b;
import com.baidu.swan.games.h.j;
/* loaded from: classes11.dex */
public class a {
    private static final boolean DEBUG = b.DEBUG;
    private static int bYf = 0;

    public static void af(int i, int i2) {
        com.baidu.swan.apps.extcore.cores.a.RP().Z(i, i2);
        g.agF();
        if (i == 0) {
            bYf = 2;
        } else if (i2 > i) {
            bYf = 1;
            j.anP();
        }
    }

    public static int agr() {
        return bYf;
    }
}
