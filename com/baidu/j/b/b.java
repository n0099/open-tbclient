package com.baidu.j.b;
/* loaded from: classes7.dex */
public class b {
    private static volatile a aPR;

    public static synchronized a Eu() {
        a aVar;
        synchronized (b.class) {
            if (aPR == null) {
                aPR = new a();
            }
            aVar = aPR;
        }
        return aVar;
    }
}
