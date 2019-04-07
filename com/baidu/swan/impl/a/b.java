package com.baidu.swan.impl.a;
/* loaded from: classes2.dex */
public class b {
    private static volatile a bgA;

    public static synchronized a PK() {
        a aVar;
        synchronized (b.class) {
            if (bgA == null) {
                bgA = new a();
            }
            aVar = bgA;
        }
        return aVar;
    }
}
