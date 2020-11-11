package com.baidu.swan.apps.ao;

import com.baidu.swan.apps.ap.i;
import com.baidu.swan.apps.b;
import com.baidu.swan.games.i.k;
import com.baidu.swan.games.utils.so.e;
/* loaded from: classes10.dex */
public class a {
    private static final boolean DEBUG = b.DEBUG;
    private static int dDj = 0;

    public static void at(int i, int i2) {
        com.baidu.swan.apps.extcore.cores.a.auc().am(i, i2);
        i.aMu();
        if (i == 0) {
            dDj = 2;
        } else if (i2 > i) {
            dDj = 1;
            k.aVl();
            e.a.aXW();
        }
    }

    public static int aLY() {
        return dDj;
    }
}
