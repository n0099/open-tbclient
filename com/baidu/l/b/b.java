package com.baidu.l.b;
/* loaded from: classes19.dex */
public class b {
    private static volatile a bZI;

    public static synchronized a aag() {
        a aVar;
        synchronized (b.class) {
            if (bZI == null) {
                bZI = new a();
            }
            aVar = bZI;
        }
        return aVar;
    }
}
