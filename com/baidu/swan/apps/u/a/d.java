package com.baidu.swan.apps.u.a;
/* loaded from: classes7.dex */
public class d {
    private static volatile c clJ;

    public static synchronized c ahk() {
        c cVar;
        synchronized (d.class) {
            if (clJ == null) {
                clJ = new c();
            }
            cVar = clJ;
        }
        return cVar;
    }
}
