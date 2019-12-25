package com.baidu.swan.facade.requred.a.a;
/* loaded from: classes4.dex */
public class b {
    private static volatile a cbt;

    public static synchronized a agQ() {
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
