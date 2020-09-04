package com.baidu.swan.apps.t.a;
/* loaded from: classes14.dex */
public class b {
    private static volatile a cvt;

    public static synchronized a aqe() {
        a aVar;
        synchronized (b.class) {
            if (cvt == null) {
                cvt = new a();
            }
            aVar = cvt;
        }
        return aVar;
    }
}
