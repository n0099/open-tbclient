package com.baidu.swan.facade.requred.a.a;
/* loaded from: classes7.dex */
public class b {
    private static volatile a cfX;

    public static synchronized a ajC() {
        a aVar;
        synchronized (b.class) {
            if (cfX == null) {
                cfX = new a();
            }
            aVar = cfX;
        }
        return aVar;
    }
}
