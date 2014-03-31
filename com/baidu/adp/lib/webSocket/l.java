package com.baidu.adp.lib.webSocket;

import java.util.ArrayList;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class l {
    private static l a = null;
    private String[] d;
    private k h;
    private String b = null;
    private List<BasicNameValuePair> c = null;
    private String e = null;
    private n f = null;
    private ArrayList<k> g = new ArrayList<>();

    public static synchronized l a() {
        l lVar;
        synchronized (l.class) {
            if (a == null) {
                a = new l();
            }
            lVar = a;
        }
        return lVar;
    }

    public final void a(String str, String str2, String[] strArr, List<BasicNameValuePair> list) {
        this.b = str;
        this.e = str2;
        this.d = strArr;
        this.c = list;
        if (com.baidu.adp.a.b.a().d()) {
            com.baidu.adp.lib.util.f.e("----ws init " + str);
        }
    }

    private l() {
        this.h = null;
        this.h = new m(this);
    }

    public final boolean b() {
        if (com.baidu.adp.a.b.a().d()) {
            com.baidu.adp.lib.util.i.b();
            com.baidu.adp.lib.util.f.e("----open");
        }
        if (this.f != null) {
            if (this.f.d() || this.f.e()) {
                if (com.baidu.adp.a.b.a().d()) {
                    com.baidu.adp.lib.util.f.e("----WebSocketConnection connecting");
                }
                return true;
            }
            this.f.a(1, (String) null);
            this.f = null;
        }
        this.f = new n();
        try {
            al alVar = new al();
            alVar.a(this.e);
            this.f.a(this.b, this.d, this.h, alVar, this.c);
            return true;
        } catch (WebSocketException e) {
            this.f = null;
            return false;
        }
    }

    public final void a(int i) {
        if (this.f != null) {
            n nVar = this.f;
            this.f = null;
            nVar.a(i, (String) null);
            if (this.f != null) {
                com.baidu.adp.lib.util.f.b("close is opened and thread is leaded!!!");
                this.f = null;
            }
        }
    }

    public final boolean c() {
        if (com.baidu.adp.a.b.a().d()) {
            com.baidu.adp.lib.util.i.b();
        }
        return (this.f == null || !this.f.e() || this.f.c()) ? false : true;
    }

    public final boolean d() {
        if (com.baidu.adp.a.b.a().d()) {
            com.baidu.adp.lib.util.i.b();
        }
        return this.f != null && this.f.e();
    }

    public final boolean e() {
        if (com.baidu.adp.a.b.a().d()) {
            com.baidu.adp.lib.util.i.b();
        }
        return this.f != null && this.f.d();
    }

    public final synchronized boolean a(d dVar) {
        boolean z = false;
        synchronized (this) {
            if (dVar != null) {
                com.baidu.adp.lib.util.i.b();
                if (this.f != null) {
                    z = this.f.a(dVar);
                } else if (dVar != null) {
                    dVar.a(1);
                }
            }
        }
        return z;
    }

    public final boolean a(k kVar) {
        if (kVar != null) {
            synchronized (l.class) {
                if (!this.g.contains(kVar)) {
                    return this.g.add(kVar);
                }
            }
        }
        return false;
    }

    public final void f() {
        if (this.f != null) {
            this.f.f();
        }
    }

    public final long g() {
        if (this.f != null) {
            return this.f.g();
        }
        return 0L;
    }

    public final void h() {
        if (this.f != null) {
            this.f.h();
        }
    }

    public final long i() {
        if (this.f != null) {
            return this.f.i();
        }
        return 0L;
    }

    public final long j() {
        if (this.f != null) {
            return this.f.j();
        }
        return 0L;
    }

    public final String k() {
        if (this.f != null) {
            return this.f.k();
        }
        return null;
    }

    public final long l() {
        return this.f.l();
    }
}
