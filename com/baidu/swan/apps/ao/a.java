package com.baidu.swan.apps.ao;

import com.baidu.swan.apps.ap.i;
import com.baidu.swan.apps.b;
import com.baidu.swan.games.i.k;
import com.baidu.swan.games.utils.so.e;
/* loaded from: classes25.dex */
public class a {
    private static final boolean DEBUG = b.DEBUG;
    private static int dIA = 0;

    public static void av(int i, int i2) {
        com.baidu.swan.apps.extcore.cores.a.awC().ao(i, i2);
        i.aOT();
        if (i == 0) {
            dIA = 2;
        } else if (i2 > i) {
            dIA = 1;
            k.aXI();
            e.a.bat();
        }
    }

    public static int aOx() {
        return dIA;
    }
}
