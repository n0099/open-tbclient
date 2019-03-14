package com.baidu.swan.impl.a;
/* loaded from: classes2.dex */
public class b {
    private static volatile a bgx;

    public static synchronized a PM() {
        a aVar;
        synchronized (b.class) {
            if (bgx == null) {
                bgx = new a();
            }
            aVar = bgx;
        }
        return aVar;
    }
}
