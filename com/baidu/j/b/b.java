package com.baidu.j.b;
/* loaded from: classes7.dex */
public class b {
    private static volatile a aPT;

    public static synchronized a Ew() {
        a aVar;
        synchronized (b.class) {
            if (aPT == null) {
                aPT = new a();
            }
            aVar = aPT;
        }
        return aVar;
    }
}
