package com.baidu.swan.apps.an;

import com.baidu.swan.apps.ao.i;
import com.baidu.swan.apps.b;
import com.baidu.swan.games.i.k;
import com.baidu.swan.games.utils.so.e;
/* loaded from: classes9.dex */
public class a {
    private static final boolean DEBUG = b.DEBUG;
    private static int dOx = 0;

    public static void ao(int i, int i2) {
        com.baidu.swan.apps.extcore.cores.a.auz().ag(i, i2);
        i.aNK();
        if (i == 0) {
            dOx = 2;
        } else if (i2 > i) {
            dOx = 1;
            k.aWv();
            e.a.aZg();
        }
    }

    public static int aNo() {
        return dOx;
    }
}
