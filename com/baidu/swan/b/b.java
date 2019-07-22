package com.baidu.swan.b;
/* loaded from: classes2.dex */
public final class b extends com.baidu.swan.c.d {
    private static volatile b bxr;

    public b() {
        super("aiapp_open_stat");
    }

    public static b Yy() {
        if (bxr == null) {
            synchronized (b.class) {
                if (bxr == null) {
                    bxr = new b();
                }
            }
        }
        return bxr;
    }
}
