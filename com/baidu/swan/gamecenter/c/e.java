package com.baidu.swan.gamecenter.c;
/* loaded from: classes7.dex */
public class e {
    private static volatile d ebR;

    public static synchronized d aTE() {
        d dVar;
        synchronized (e.class) {
            if (ebR == null) {
                ebR = new d();
            }
            dVar = ebR;
        }
        return dVar;
    }
}
