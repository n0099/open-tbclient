package com.baidu.swan.b;
/* loaded from: classes2.dex */
public final class b extends com.baidu.swan.c.d {
    private static volatile b bQv;

    public b() {
        super("aiapp_open_stat");
    }

    public static b adr() {
        if (bQv == null) {
            synchronized (b.class) {
                if (bQv == null) {
                    bQv = new b();
                }
            }
        }
        return bQv;
    }
}
