package com.baidu.swan.b;
/* loaded from: classes2.dex */
public final class b extends com.baidu.swan.c.d {
    private static volatile b bxP;

    public b() {
        super("aiapp_open_stat");
    }

    public static b YC() {
        if (bxP == null) {
            synchronized (b.class) {
                if (bxP == null) {
                    bxP = new b();
                }
            }
        }
        return bxP;
    }
}
