package com.baidu.tbadk.a;

import android.graphics.Bitmap;
/* loaded from: classes.dex */
public class d {
    private static d a = null;
    private com.baidu.adp.lib.c.a b;
    private com.baidu.adp.lib.c.a c;

    public static synchronized d a() {
        d dVar;
        synchronized (d.class) {
            if (a == null) {
                a = new d();
            }
            dVar = a;
        }
        return dVar;
    }

    private d() {
        this.b = null;
        this.c = null;
        this.b = new com.baidu.adp.lib.c.a(0);
        this.c = new e(this, 0);
    }

    public void a(int i, int i2) {
        a(i);
        b(i2);
    }

    public void a(int i) {
        this.b.b(i);
    }

    public void b(int i) {
        this.c.b(i);
    }

    public void a(String str, Bitmap bitmap) {
        if (bitmap != null && this.b != null) {
            f fVar = new f(this);
            fVar.b = bitmap;
            this.b.a(str, fVar);
        }
    }

    public void a(String str, Bitmap bitmap, boolean z) {
        if (bitmap != null && this.c != null) {
            f fVar = new f(this);
            fVar.b = bitmap;
            fVar.c = z;
            this.c.a(str, fVar);
        }
    }

    public void b(String str, Bitmap bitmap) {
        if (bitmap != null && this.c != null) {
            f fVar = new f(this);
            fVar.b = bitmap;
            this.c.a(str, fVar);
        }
    }

    public void a(String str) {
        this.b.b(str);
    }

    public void c(int i) {
        this.c.a(i);
    }

    public Bitmap b(String str) {
        Bitmap bitmap;
        f fVar = (f) this.b.a(str);
        if (fVar == null) {
            return null;
        }
        bitmap = fVar.b;
        return bitmap;
    }

    public Bitmap c(String str) {
        Bitmap bitmap;
        f fVar = (f) this.c.a(str);
        if (fVar == null) {
            return null;
        }
        bitmap = fVar.b;
        return bitmap;
    }

    public f d(String str) {
        return (f) this.c.a(str);
    }

    public void b() {
        this.b.b();
        this.c.b();
    }

    public String toString() {
        return "pic:" + this.c.toString() + "  photo:" + this.b.toString();
    }
}
