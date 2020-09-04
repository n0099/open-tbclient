package com.baidu.l.b;
/* loaded from: classes14.dex */
public class b {
    private static volatile a bEC;

    public static synchronized a TQ() {
        a aVar;
        synchronized (b.class) {
            if (bEC == null) {
                bEC = new a();
            }
            aVar = bEC;
        }
        return aVar;
    }
}
