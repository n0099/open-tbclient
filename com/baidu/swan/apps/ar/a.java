package com.baidu.swan.apps.ar;

import com.baidu.swan.apps.as.g;
import com.baidu.swan.apps.b;
import com.baidu.swan.games.h.j;
/* loaded from: classes11.dex */
public class a {
    private static final boolean DEBUG = b.DEBUG;
    private static int cxk = 0;

    public static void ai(int i, int i2) {
        com.baidu.swan.apps.extcore.cores.a.ZJ().ac(i, i2);
        g.aoP();
        if (i == 0) {
            cxk = 2;
        } else if (i2 > i) {
            cxk = 1;
            j.awh();
        }
    }

    public static int aoB() {
        return cxk;
    }
}
