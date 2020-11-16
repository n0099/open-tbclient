package com.baidu.ar.c;

import android.os.Looper;
import android.text.TextUtils;
/* loaded from: classes12.dex */
public class c {
    private com.baidu.ar.bus.a ik;
    private b il;

    /* loaded from: classes12.dex */
    private static class a {
        private static c im = new c();
    }

    private c() {
        this.ik = new com.baidu.ar.bus.a();
        this.il = new b();
    }

    public static c ce() {
        return a.im;
    }

    public int O(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        return this.il.O(str);
    }

    public void a(Looper looper) {
        this.ik.b(looper);
    }

    public void a(Object obj) {
        this.ik.d(obj);
    }

    public void b(Object obj) {
        this.ik.e(obj);
    }

    public void c(Object obj) {
        this.ik.f(obj);
    }

    public boolean c(com.baidu.ar.c.a aVar) {
        this.il.a(aVar);
        return true;
    }
}
