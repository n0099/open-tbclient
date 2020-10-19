package com.baidu.swan.apps.ao;

import com.baidu.swan.apps.ap.i;
import com.baidu.swan.apps.b;
import com.baidu.swan.games.i.k;
import com.baidu.swan.games.utils.so.e;
/* loaded from: classes10.dex */
public class a {
    private static final boolean DEBUG = b.DEBUG;
    private static int doR = 0;

    public static void as(int i, int i2) {
        com.baidu.swan.apps.extcore.cores.a.apH().al(i, i2);
        i.aIa();
        if (i == 0) {
            doR = 2;
        } else if (i2 > i) {
            doR = 1;
            k.aQR();
            e.a.aTC();
        }
    }

    public static int aHE() {
        return doR;
    }
}
