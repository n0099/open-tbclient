package com.baidu.swan.apps.ar;

import com.baidu.swan.apps.as.g;
import com.baidu.swan.apps.b;
import com.baidu.swan.games.h.j;
/* loaded from: classes10.dex */
public class a {
    private static final boolean DEBUG = b.DEBUG;
    private static int bUb = 0;

    public static void af(int i, int i2) {
        com.baidu.swan.apps.extcore.cores.a.PB().Z(i, i2);
        g.aer();
        if (i == 0) {
            bUb = 2;
        } else if (i2 > i) {
            bUb = 1;
            j.alC();
        }
    }

    public static int aed() {
        return bUb;
    }
}
