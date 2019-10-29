package com.baidu.swan.apps.scheme;
/* loaded from: classes2.dex */
public class b {
    private static volatile a bln;

    public static synchronized a RI() {
        a aVar;
        synchronized (b.class) {
            if (bln == null) {
                bln = new a();
            }
            aVar = bln;
        }
        return aVar;
    }
}
