package com.baidu.swan.apps.ao;

import com.baidu.swan.apps.ap.i;
import com.baidu.swan.apps.b;
import com.baidu.swan.games.i.k;
import com.baidu.swan.games.utils.so.e;
/* loaded from: classes8.dex */
public class a {
    private static final boolean DEBUG = b.DEBUG;
    private static int daH = 0;

    public static void at(int i, int i2) {
        com.baidu.swan.apps.extcore.cores.a.aml().am(i, i2);
        i.aEH();
        if (i == 0) {
            daH = 2;
        } else if (i2 > i) {
            daH = 1;
            k.aNx();
            e.a.aQh();
        }
    }

    public static int aEl() {
        return daH;
    }
}
