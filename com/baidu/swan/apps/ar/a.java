package com.baidu.swan.apps.ar;

import com.baidu.swan.apps.as.g;
import com.baidu.swan.apps.b;
import com.baidu.swan.games.h.j;
/* loaded from: classes9.dex */
public class a {
    private static final boolean DEBUG = b.DEBUG;
    private static int bTP = 0;

    public static void ab(int i, int i2) {
        com.baidu.swan.apps.extcore.cores.a.Pf().V(i, i2);
        g.adY();
        if (i == 0) {
            bTP = 2;
        } else if (i2 > i) {
            bTP = 1;
            j.alj();
        }
    }

    public static int adK() {
        return bTP;
    }
}
