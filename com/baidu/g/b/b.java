package com.baidu.g.b;
/* loaded from: classes7.dex */
public class b {
    private static volatile a bmo;

    public static synchronized a KN() {
        a aVar;
        synchronized (b.class) {
            if (bmo == null) {
                bmo = new a();
            }
            aVar = bmo;
        }
        return aVar;
    }
}
