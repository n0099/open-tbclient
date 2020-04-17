package com.baidu.g.b;
/* loaded from: classes7.dex */
public class b {
    private static volatile a bmj;

    public static synchronized a KO() {
        a aVar;
        synchronized (b.class) {
            if (bmj == null) {
                bmj = new a();
            }
            aVar = bmj;
        }
        return aVar;
    }
}
