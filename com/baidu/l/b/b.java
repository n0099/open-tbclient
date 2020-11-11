package com.baidu.l.b;
/* loaded from: classes20.dex */
public class b {
    private static volatile a cbt;

    public static synchronized a aaP() {
        a aVar;
        synchronized (b.class) {
            if (cbt == null) {
                cbt = new a();
            }
            aVar = cbt;
        }
        return aVar;
    }
}
