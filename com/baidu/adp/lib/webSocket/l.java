package com.baidu.adp.lib.webSocket;

import java.util.ArrayList;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class l {

    /* renamed from: a  reason: collision with root package name */
    private static l f536a = null;
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
            if (f536a == null) {
                f536a = new l();
            }
            lVar = f536a;
        }
        return lVar;
    }

    public void a(String str, String str2, String[] strArr, List<BasicNameValuePair> list) {
        this.b = str;
        this.e = str2;
        this.d = strArr;
        this.c = list;
        if (k()) {
            com.baidu.adp.lib.h.d.d("----ws init " + str);
        }
    }

    private l() {
        this.h = null;
        this.h = new m(this);
    }

    public boolean b() {
        if (k()) {
            com.baidu.adp.lib.h.f.a();
            com.baidu.adp.lib.h.d.d("----open");
        }
        if (this.f != null) {
            if (this.f.e() || this.f.f()) {
                if (k()) {
                    com.baidu.adp.lib.h.d.d("----WebSocketConnection connecting");
                }
                return true;
            }
            this.f.a(1, (String) null);
            this.f = null;
        }
        this.f = new n();
        try {
            ai aiVar = new ai();
            aiVar.a(this.e);
            this.f.a(this.b, this.d, this.h, aiVar, this.c);
            return true;
        } catch (WebSocketException e) {
            this.f = null;
            return false;
        }
    }

    public void a(int i) {
        if (this.f != null) {
            n nVar = this.f;
            this.f = null;
            nVar.a(i, (String) null);
            if (this.f != null) {
                com.baidu.adp.lib.h.d.a("close is opened and thread is leaded!!!");
                this.f = null;
            }
        }
    }

    public void c() {
        a(1);
    }

    public boolean d() {
        if (k()) {
            com.baidu.adp.lib.h.f.a();
        }
        return (this.f == null || !this.f.f() || this.f.d()) ? false : true;
    }

    public boolean e() {
        if (k()) {
            com.baidu.adp.lib.h.f.a();
        }
        return this.f != null && this.f.f();
    }

    public boolean f() {
        if (k()) {
            com.baidu.adp.lib.h.f.a();
        }
        return this.f != null && this.f.e();
    }

    public synchronized boolean a(am amVar) {
        boolean z = false;
        synchronized (this) {
            if (amVar != null) {
                if (k()) {
                    com.baidu.adp.lib.h.f.a();
                    com.baidu.adp.lib.h.d.d("----sendMessage data = " + amVar.c());
                }
                if (this.f != null) {
                    z = this.f.a(amVar);
                } else if (amVar.d() != null) {
                    amVar.d().b(amVar);
                }
            }
        }
        return z;
    }

    public boolean a(k kVar) {
        if (kVar != null) {
            synchronized (l.class) {
                if (!this.g.contains(kVar)) {
                    return this.g.add(kVar);
                }
            }
        }
        return false;
    }

    private boolean k() {
        return com.baidu.adp.a.b.a().b();
    }

    public void g() {
        if (this.f != null) {
            this.f.g();
        }
    }

    public long h() {
        if (this.f != null) {
            return this.f.h();
        }
        return 0L;
    }

    public void i() {
        if (this.f != null) {
            this.f.i();
        }
    }

    public long j() {
        if (this.f != null) {
            return this.f.j();
        }
        return 0L;
    }
}
