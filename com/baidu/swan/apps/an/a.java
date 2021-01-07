package com.baidu.swan.apps.an;

import com.baidu.swan.apps.ao.i;
import com.baidu.swan.apps.b;
import com.baidu.swan.games.i.k;
import com.baidu.swan.games.utils.so.e;
/* loaded from: classes9.dex */
public class a {
    private static final boolean DEBUG = b.DEBUG;
    private static int dRf = 0;

    public static void ar(int i, int i2) {
        com.baidu.swan.apps.extcore.cores.a.axV().aj(i, i2);
        i.aRl();
        if (i == 0) {
            dRf = 2;
        } else if (i2 > i) {
            dRf = 1;
            k.bad();
            e.a.bcO();
        }
    }

    public static int aQP() {
        return dRf;
    }
}
