package com.baidu.swan.b;
/* loaded from: classes2.dex */
public final class b extends com.baidu.swan.c.d {
    private static volatile b bwA;

    public b() {
        super("aiapp_open_stat");
    }

    public static b XC() {
        if (bwA == null) {
            synchronized (b.class) {
                if (bwA == null) {
                    bwA = new b();
                }
            }
        }
        return bwA;
    }
}
