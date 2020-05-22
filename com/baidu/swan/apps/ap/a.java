package com.baidu.swan.apps.ap;

import com.baidu.swan.apps.aq.h;
import com.baidu.swan.apps.b;
import com.baidu.swan.games.i.k;
import com.baidu.swan.games.utils.so.e;
/* loaded from: classes11.dex */
public class a {
    private static final boolean DEBUG = b.DEBUG;
    private static int cJv = 0;

    public static void al(int i, int i2) {
        com.baidu.swan.apps.extcore.cores.a.acI().af(i, i2);
        h.atp();
        if (i == 0) {
            cJv = 2;
        } else if (i2 > i) {
            cJv = 1;
            k.azY();
            e.aCv();
        }
    }

    public static int asV() {
        return cJv;
    }
}
