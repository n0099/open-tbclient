package com.baidu.swan.apps.scheme;
/* loaded from: classes19.dex */
public class d {
    private static volatile c dsZ;

    public static synchronized c aHS() {
        c cVar;
        synchronized (d.class) {
            if (dsZ == null) {
                dsZ = new c();
            }
            cVar = dsZ;
        }
        return cVar;
    }
}
