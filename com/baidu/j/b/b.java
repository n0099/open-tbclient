package com.baidu.j.b;
/* loaded from: classes4.dex */
public class b {
    private static volatile a aKA;

    public static synchronized a BC() {
        a aVar;
        synchronized (b.class) {
            if (aKA == null) {
                aKA = new a();
            }
            aVar = aKA;
        }
        return aVar;
    }
}
