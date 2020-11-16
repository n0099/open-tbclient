package com.baidu.swan.apps.ao;

import com.baidu.swan.apps.ap.i;
import com.baidu.swan.apps.b;
import com.baidu.swan.games.i.k;
import com.baidu.swan.games.utils.so.e;
/* loaded from: classes7.dex */
public class a {
    private static final boolean DEBUG = b.DEBUG;
    private static int dBC = 0;

    public static void at(int i, int i2) {
        com.baidu.swan.apps.extcore.cores.a.atu().am(i, i2);
        i.aLM();
        if (i == 0) {
            dBC = 2;
        } else if (i2 > i) {
            dBC = 1;
            k.aUD();
            e.a.aXo();
        }
    }

    public static int aLq() {
        return dBC;
    }
}
