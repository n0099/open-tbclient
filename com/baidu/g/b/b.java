package com.baidu.g.b;
/* loaded from: classes7.dex */
public class b {
    private static volatile a byF;

    public static synchronized a NQ() {
        a aVar;
        synchronized (b.class) {
            if (byF == null) {
                byF = new a();
            }
            aVar = byF;
        }
        return aVar;
    }
}
