package com.baidu.swan.apps.z;
/* loaded from: classes20.dex */
public class b {
    private static volatile a dig;

    public static synchronized a aDd() {
        a aVar;
        synchronized (b.class) {
            if (dig == null) {
                dig = new a();
            }
            aVar = dig;
        }
        return aVar;
    }
}
