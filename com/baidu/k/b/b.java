package com.baidu.k.b;
/* loaded from: classes7.dex */
public class b {
    private static volatile a cmN;

    public static synchronized a adg() {
        a aVar;
        synchronized (b.class) {
            if (cmN == null) {
                cmN = new a();
            }
            aVar = cmN;
        }
        return aVar;
    }
}
