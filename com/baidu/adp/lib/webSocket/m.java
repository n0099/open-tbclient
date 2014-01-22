package com.baidu.adp.lib.webSocket;

import java.util.ArrayList;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class m {
    private static m a = null;
    private String[] d;
    private l h;
    private String b = null;
    private List<BasicNameValuePair> c = null;
    private String e = null;
    private o f = null;
    private ArrayList<l> g = new ArrayList<>();

    public static synchronized m a() {
        m mVar;
        synchronized (m.class) {
            if (a == null) {
                a = new m();
            }
            mVar = a;
        }
        return mVar;
    }

    public void a(String str, String str2, String[] strArr, List<BasicNameValuePair> list) {
        this.b = str;
        this.e = str2;
        this.d = strArr;
        this.c = list;
        if (k()) {
            com.baidu.adp.lib.g.e.d("----ws init " + str);
        }
    }

    private m() {
        this.h = null;
        this.h = new n(this);
    }

    public boolean b() {
        if (k()) {
            com.baidu.adp.lib.g.g.a();
            com.baidu.adp.lib.g.e.d("----open");
        }
        if (this.f != null) {
            if (this.f.e() || this.f.f()) {
                if (k()) {
                    com.baidu.adp.lib.g.e.d("----WebSocketConnection connecting");
                }
                return true;
            }
            this.f.a(1, (String) null);
            this.f = null;
        }
        this.f = new o();
        try {
            am amVar = new am();
            amVar.a(this.e);
            this.f.a(this.b, this.d, this.h, amVar, this.c);
            return true;
        } catch (WebSocketException e) {
            this.f = null;
            return false;
        }
    }

    public void a(int i) {
        if (this.f != null) {
            o oVar = this.f;
            this.f = null;
            oVar.a(i, (String) null);
            if (this.f != null) {
                com.baidu.adp.lib.g.e.a("close is opened and thread is leaded!!!");
                this.f = null;
            }
        }
    }

    public void c() {
        a(1);
    }

    public boolean d() {
        if (k()) {
            com.baidu.adp.lib.g.g.a();
        }
        return (this.f == null || !this.f.f() || this.f.d()) ? false : true;
    }

    public boolean e() {
        if (k()) {
            com.baidu.adp.lib.g.g.a();
        }
        return this.f != null && this.f.f();
    }

    public boolean f() {
        if (k()) {
            com.baidu.adp.lib.g.g.a();
        }
        return this.f != null && this.f.e();
    }

    public synchronized boolean a(d dVar) {
        boolean z = false;
        synchronized (this) {
            if (dVar != null) {
                com.baidu.adp.lib.g.g.a();
                if (this.f != null) {
                    z = this.f.a(dVar);
                } else if (dVar != null) {
                    dVar.a(1);
                }
            }
        }
        return z;
    }

    public boolean a(l lVar) {
        if (lVar != null) {
            synchronized (m.class) {
                if (!this.g.contains(lVar)) {
                    return this.g.add(lVar);
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
