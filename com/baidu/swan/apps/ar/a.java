package com.baidu.swan.apps.ar;

import com.baidu.swan.apps.as.g;
import com.baidu.swan.apps.b;
import com.baidu.swan.games.h.j;
/* loaded from: classes11.dex */
public class a {
    private static final boolean DEBUG = b.DEBUG;
    private static int bYs = 0;

    public static void af(int i, int i2) {
        com.baidu.swan.apps.extcore.cores.a.RU().Z(i, i2);
        g.agK();
        if (i == 0) {
            bYs = 2;
        } else if (i2 > i) {
            bYs = 1;
            j.anU();
        }
    }

    public static int agw() {
        return bYs;
    }
}
