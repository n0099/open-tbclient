package com.baidu.swan.bdprivate.b;
/* loaded from: classes7.dex */
public class c {
    private static volatile b cSv;

    public static synchronized b avT() {
        b bVar;
        synchronized (c.class) {
            if (cSv == null) {
                cSv = new b();
            }
            bVar = cSv;
        }
        return bVar;
    }
}
