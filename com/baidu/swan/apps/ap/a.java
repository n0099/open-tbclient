package com.baidu.swan.apps.ap;

import com.baidu.swan.apps.aq.i;
import com.baidu.swan.apps.b;
import com.baidu.swan.games.i.k;
import com.baidu.swan.games.utils.so.e;
/* loaded from: classes7.dex */
public class a {
    private static final boolean DEBUG = b.DEBUG;
    private static int cRB = 0;

    public static void an(int i, int i2) {
        com.baidu.swan.apps.extcore.cores.a.afe().ah(i, i2);
        i.awx();
        if (i == 0) {
            cRB = 2;
        } else if (i2 > i) {
            cRB = 1;
            k.aEJ();
            e.a.aHp();
        }
    }

    public static int awc() {
        return cRB;
    }
}
