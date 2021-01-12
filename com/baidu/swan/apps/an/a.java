package com.baidu.swan.apps.an;

import com.baidu.swan.apps.ao.i;
import com.baidu.swan.apps.b;
import com.baidu.swan.games.i.k;
import com.baidu.swan.games.utils.so.e;
/* loaded from: classes8.dex */
public class a {
    private static final boolean DEBUG = b.DEBUG;
    private static int dMt = 0;

    public static void ar(int i, int i2) {
        com.baidu.swan.apps.extcore.cores.a.aub().aj(i, i2);
        i.aNr();
        if (i == 0) {
            dMt = 2;
        } else if (i2 > i) {
            dMt = 1;
            k.aWj();
            e.a.aYU();
        }
    }

    public static int aMV() {
        return dMt;
    }
}
