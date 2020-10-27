package com.baidu.swan.apps.ao;

import com.baidu.swan.apps.ap.i;
import com.baidu.swan.apps.b;
import com.baidu.swan.games.i.k;
import com.baidu.swan.games.utils.so.e;
/* loaded from: classes10.dex */
public class a {
    private static final boolean DEBUG = b.DEBUG;
    private static int dxr = 0;

    public static void at(int i, int i2) {
        com.baidu.swan.apps.extcore.cores.a.arB().am(i, i2);
        i.aJU();
        if (i == 0) {
            dxr = 2;
        } else if (i2 > i) {
            dxr = 1;
            k.aSL();
            e.a.aVw();
        }
    }

    public static int aJy() {
        return dxr;
    }
}
