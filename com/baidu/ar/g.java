package com.baidu.ar;

import com.baidu.ar.bean.ARResource;
/* loaded from: classes3.dex */
public class g {
    private static g a;
    private boolean b = false;
    private boolean c = false;
    private a d;
    private ARResource e;

    /* loaded from: classes3.dex */
    public static class a {
        public int a;
        public int b;
    }

    public static g a() {
        if (a == null) {
            synchronized (g.class) {
                if (a == null) {
                    a = new g();
                }
            }
        }
        return a;
    }

    public synchronized void a(ARResource aRResource) {
        this.e = aRResource;
    }

    public synchronized void a(a aVar) {
        this.d = aVar;
    }
}
