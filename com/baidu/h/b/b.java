package com.baidu.h.b;
/* loaded from: classes14.dex */
public class b {
    private static volatile a byR;

    public static synchronized a NW() {
        a aVar;
        synchronized (b.class) {
            if (byR == null) {
                byR = new a();
            }
            aVar = byR;
        }
        return aVar;
    }
}
