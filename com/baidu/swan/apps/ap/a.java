package com.baidu.swan.apps.ap;

import com.baidu.swan.apps.aq.h;
import com.baidu.swan.apps.b;
import com.baidu.swan.games.i.k;
import com.baidu.swan.games.utils.so.e;
/* loaded from: classes11.dex */
public class a {
    private static final boolean DEBUG = b.DEBUG;
    private static int cOf = 0;

    public static void an(int i, int i2) {
        com.baidu.swan.apps.extcore.cores.a.adO().ah(i, i2);
        h.auv();
        if (i == 0) {
            cOf = 2;
        } else if (i2 > i) {
            cOf = 1;
            k.aBe();
            e.aDB();
        }
    }

    public static int aub() {
        return cOf;
    }
}
