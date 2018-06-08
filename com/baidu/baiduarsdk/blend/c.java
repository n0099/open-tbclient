package com.baidu.baiduarsdk.blend;
/* loaded from: classes3.dex */
public class c {
    private com.baidu.baiduarsdk.a a;
    private d b;

    public c(d dVar) {
        this.b = null;
        com.baidu.baiduarsdk.a aVar = new com.baidu.baiduarsdk.a();
        this.b = dVar;
        aVar.a(dVar);
        this.a = aVar;
        this.a.a(1);
    }

    private void f() {
        if (this.a != null) {
            this.a.a(null, 0, 0);
            this.a.d();
        }
    }

    public void a() {
        if (this.a != null) {
            this.a.c();
        }
    }

    public void a(int i) {
        if (this.a != null) {
            this.a.a(i);
        }
    }

    public void a(Object obj, int i, int i2) {
        if (this.a != null) {
            this.a.a(obj, i, i2);
        }
    }

    public void a(Runnable runnable) {
        if (this.a != null) {
            this.a.a(runnable);
        }
    }

    public void b() {
        if (this.a != null) {
            this.a.b();
        }
    }

    public void c() {
        a(new Runnable() { // from class: com.baidu.baiduarsdk.blend.c.1
            @Override // java.lang.Runnable
            public void run() {
                c.this.b.b();
            }
        });
        b();
        f();
    }

    public void d() {
        if (this.a != null) {
            this.a.a();
        }
    }

    public com.baidu.baiduarsdk.a e() {
        return this.a;
    }
}
