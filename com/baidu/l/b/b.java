package com.baidu.l.b;
/* loaded from: classes19.dex */
public class b {
    private static volatile a bGD;

    public static synchronized a Uz() {
        a aVar;
        synchronized (b.class) {
            if (bGD == null) {
                bGD = new a();
            }
            aVar = bGD;
        }
        return aVar;
    }
}
