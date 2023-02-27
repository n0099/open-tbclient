package com.baidu.ar.c;

import android.os.Looper;
import android.text.TextUtils;
/* loaded from: classes.dex */
public class c {
    public b iA;
    public com.baidu.ar.bus.a iz;

    /* loaded from: classes.dex */
    public static class a {
        public static c iB = new c();
    }

    public c() {
        this.iz = new com.baidu.ar.bus.a();
        this.iA = new b();
    }

    public static c cd() {
        return a.iB;
    }

    public int R(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        return this.iA.R(str);
    }

    public void a(Looper looper) {
        this.iz.b(looper);
    }

    public void a(Object obj) {
        this.iz.d(obj);
    }

    public void b(Object obj) {
        this.iz.e(obj);
    }

    public void c(Object obj) {
        this.iz.f(obj);
    }

    public boolean c(com.baidu.ar.c.a aVar) {
        this.iA.a(aVar);
        return true;
    }
}
