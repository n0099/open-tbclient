package com.baidu.swan.apps.ao;

import com.baidu.swan.apps.ap.i;
import com.baidu.swan.apps.b;
import com.baidu.swan.games.i.k;
import com.baidu.swan.games.utils.so.e;
/* loaded from: classes3.dex */
public class a {
    private static final boolean DEBUG = b.DEBUG;
    private static int dcI = 0;

    public static void at(int i, int i2) {
        com.baidu.swan.apps.extcore.cores.a.amV().am(i, i2);
        i.aFr();
        if (i == 0) {
            dcI = 2;
        } else if (i2 > i) {
            dcI = 1;
            k.aOi();
            e.a.aQT();
        }
    }

    public static int aEV() {
        return dcI;
    }
}
