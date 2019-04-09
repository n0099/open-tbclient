package com.baidu.swan.impl.a;
/* loaded from: classes2.dex */
public class b {
    private static volatile a bgB;

    public static synchronized a PK() {
        a aVar;
        synchronized (b.class) {
            if (bgB == null) {
                bgB = new a();
            }
            aVar = bgB;
        }
        return aVar;
    }
}
