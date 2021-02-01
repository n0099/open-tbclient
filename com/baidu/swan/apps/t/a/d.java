package com.baidu.swan.apps.t.a;
/* loaded from: classes7.dex */
public class d {
    private static volatile c dfv;

    public static synchronized c ayr() {
        c cVar;
        synchronized (d.class) {
            if (dfv == null) {
                dfv = new c();
            }
            cVar = dfv;
        }
        return cVar;
    }
}
