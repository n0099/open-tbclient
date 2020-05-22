package com.baidu.swan.bdprivate.e;
/* loaded from: classes7.dex */
public class c {
    private static volatile b cOF;

    public static synchronized b auT() {
        b bVar;
        synchronized (c.class) {
            if (cOF == null) {
                cOF = new b();
            }
            bVar = cOF;
        }
        return bVar;
    }
}
