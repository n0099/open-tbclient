package com.baidu.swan.impl.a;
/* loaded from: classes2.dex */
public class b {
    private static volatile a bgw;

    public static synchronized a PM() {
        a aVar;
        synchronized (b.class) {
            if (bgw == null) {
                bgw = new a();
            }
            aVar = bgw;
        }
        return aVar;
    }
}
