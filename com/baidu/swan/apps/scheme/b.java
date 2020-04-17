package com.baidu.swan.apps.scheme;
/* loaded from: classes7.dex */
public class b {
    private static volatile a cpz;

    public static synchronized a alP() {
        a aVar;
        synchronized (b.class) {
            if (cpz == null) {
                cpz = new a();
            }
            aVar = cpz;
        }
        return aVar;
    }
}
