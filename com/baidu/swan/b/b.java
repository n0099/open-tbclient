package com.baidu.swan.b;
/* loaded from: classes2.dex */
public final class b extends com.baidu.swan.c.d {
    private static volatile b bPE;

    public b() {
        super("aiapp_open_stat");
    }

    public static b adp() {
        if (bPE == null) {
            synchronized (b.class) {
                if (bPE == null) {
                    bPE = new b();
                }
            }
        }
        return bPE;
    }
}
