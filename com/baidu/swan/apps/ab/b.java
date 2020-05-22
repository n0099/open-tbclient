package com.baidu.swan.apps.ab;
/* loaded from: classes7.dex */
public class b {
    private static volatile a cqJ;

    public static synchronized a akV() {
        a aVar;
        synchronized (b.class) {
            if (cqJ == null) {
                cqJ = new a();
            }
            aVar = cqJ;
        }
        return aVar;
    }
}
