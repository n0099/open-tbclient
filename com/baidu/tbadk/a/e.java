package com.baidu.tbadk.a;
/* loaded from: classes.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    private static e f833a = new e();
    private com.baidu.adp.lib.b.a<String, com.baidu.adp.widget.a.c> b;
    private com.baidu.adp.lib.b.a<String, com.baidu.adp.widget.a.c> c;

    public static e a() {
        return f833a;
    }

    private e() {
        this.b = null;
        this.c = null;
        this.b = new f(this, 0);
        this.c = new g(this, 0);
    }

    public void a(int i, int i2) {
        a(i);
        b(i2);
    }

    public void a(int i) {
        this.b.c(i);
    }

    public void b(int i) {
        this.c.c(i);
    }

    public int b() {
        return this.c.d();
    }

    public void a(String str, com.baidu.adp.widget.a.c cVar) {
        if (cVar != null && this.b != null) {
            this.b.a(str, cVar);
        }
    }

    public boolean c(int i) {
        return this.c.a(i);
    }

    public void a(String str, com.baidu.adp.widget.a.c cVar, boolean z) {
        if (cVar != null && this.c != null) {
            if (com.baidu.adp.lib.f.d.a()) {
                com.baidu.adp.lib.f.d.c("image joined cache:" + cVar.h() + ", size:" + cVar.d());
            }
            this.c.a(str, cVar);
        }
    }

    public void b(String str, com.baidu.adp.widget.a.c cVar) {
        a(str, cVar, false);
    }

    public void a(String str) {
        this.b.b((com.baidu.adp.lib.b.a<String, com.baidu.adp.widget.a.c>) str);
    }

    public com.baidu.adp.widget.a.c b(String str) {
        return this.b.a((com.baidu.adp.lib.b.a<String, com.baidu.adp.widget.a.c>) str);
    }

    public com.baidu.adp.widget.a.c c(String str) {
        return this.c.a((com.baidu.adp.lib.b.a<String, com.baidu.adp.widget.a.c>) str);
    }

    public com.baidu.adp.widget.a.c d(String str) {
        return this.c.a((com.baidu.adp.lib.b.a<String, com.baidu.adp.widget.a.c>) str);
    }

    public void c() {
        this.b.b();
        this.c.b();
    }

    public String toString() {
        return "pic:" + this.c.toString() + "  photo:" + this.b.toString();
    }
}
