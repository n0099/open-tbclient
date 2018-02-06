package com.baidu.ar.f;
/* loaded from: classes3.dex */
public class b {
    private static b a;
    private byte[] b;
    private f c;
    private Object d = new Object();
    private byte[] e;

    public static b a() {
        if (a == null) {
            synchronized (b.class) {
                if (a == null) {
                    a = new b();
                }
            }
        }
        return a;
    }

    public void b() {
        this.b = null;
        this.e = null;
        this.c = null;
    }
}
