package com.baidu.swan.apps.z;
/* loaded from: classes19.dex */
public class b {
    private static volatile a cHJ;

    public static synchronized a avY() {
        a aVar;
        synchronized (b.class) {
            if (cHJ == null) {
                cHJ = new a();
            }
            aVar = cHJ;
        }
        return aVar;
    }
}
