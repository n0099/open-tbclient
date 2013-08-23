package com.baidu.tbadk.a;
/* loaded from: classes.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    private static e f821a = new e();
    private com.baidu.adp.lib.b.a b;
    private com.baidu.adp.lib.b.a c;

    public static e a() {
        return f821a;
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

    public void a(String str, com.baidu.adp.widget.a.b bVar) {
        if (bVar != null && this.b != null) {
            this.b.a(str, bVar);
        }
    }

    public boolean c(int i) {
        return this.c.a(i);
    }

    public void a(String str, com.baidu.adp.widget.a.b bVar, boolean z) {
        if (bVar != null && this.c != null) {
            if (com.baidu.adp.lib.e.d.a()) {
                com.baidu.adp.lib.e.d.c("image joined cache:" + bVar.h() + ", size:" + bVar.d());
            }
            this.c.a(str, bVar);
        }
    }

    public void b(String str, com.baidu.adp.widget.a.b bVar) {
        a(str, bVar, false);
    }

    public void a(String str) {
        this.b.b(str);
    }

    public com.baidu.adp.widget.a.b b(String str) {
        return (com.baidu.adp.widget.a.b) this.b.a(str);
    }

    public com.baidu.adp.widget.a.b c(String str) {
        return (com.baidu.adp.widget.a.b) this.c.a(str);
    }

    public com.baidu.adp.widget.a.b d(String str) {
        return (com.baidu.adp.widget.a.b) this.c.a(str);
    }

    public void c() {
        this.b.b();
        this.c.b();
    }

    public String toString() {
        return "pic:" + this.c.toString() + "  photo:" + this.b.toString();
    }
}
