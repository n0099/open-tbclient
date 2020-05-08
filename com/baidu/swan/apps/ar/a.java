package com.baidu.swan.apps.ar;

import com.baidu.swan.apps.as.g;
import com.baidu.swan.apps.b;
import com.baidu.swan.games.h.j;
/* loaded from: classes11.dex */
public class a {
    private static final boolean DEBUG = b.DEBUG;
    private static int cxq = 0;

    public static void ai(int i, int i2) {
        com.baidu.swan.apps.extcore.cores.a.ZI().ac(i, i2);
        g.aoO();
        if (i == 0) {
            cxq = 2;
        } else if (i2 > i) {
            cxq = 1;
            j.awh();
        }
    }

    public static int aoA() {
        return cxq;
    }
}
