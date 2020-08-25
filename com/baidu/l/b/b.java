package com.baidu.l.b;
/* loaded from: classes14.dex */
public class b {
    private static volatile a bEy;

    public static synchronized a TQ() {
        a aVar;
        synchronized (b.class) {
            if (bEy == null) {
                bEy = new a();
            }
            aVar = bEy;
        }
        return aVar;
    }
}
