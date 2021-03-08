package com.baidu.swan.apps.an;

import com.baidu.swan.apps.ao.i;
import com.baidu.swan.apps.b;
import com.baidu.swan.games.i.k;
import com.baidu.swan.games.utils.so.e;
/* loaded from: classes8.dex */
public class a {
    private static final boolean DEBUG = b.DEBUG;
    private static int dPY = 0;

    public static void ao(int i, int i2) {
        com.baidu.swan.apps.extcore.cores.a.auC().ag(i, i2);
        i.aNN();
        if (i == 0) {
            dPY = 2;
        } else if (i2 > i) {
            dPY = 1;
            k.aWy();
            e.a.aZj();
        }
    }

    public static int aNr() {
        return dPY;
    }
}
