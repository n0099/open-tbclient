package com.baidu.swan.apps.u.a;
/* loaded from: classes7.dex */
public class b {
    private static volatile a clH;

    public static synchronized a ahj() {
        a aVar;
        synchronized (b.class) {
            if (clH == null) {
                clH = new a();
            }
            aVar = clH;
        }
        return aVar;
    }
}
