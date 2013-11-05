package android.support.v4.widget;

import android.os.Build;
/* loaded from: classes.dex */
public class m {
    static final n b;

    /* renamed from: a  reason: collision with root package name */
    Object f357a;

    static {
        int i = Build.VERSION.SDK_INT;
        if (i >= 14) {
            b = new q();
        } else if (i >= 9) {
            b = new p();
        } else {
            b = new o();
        }
    }

    public boolean a() {
        return b.a(this.f357a);
    }

    public int b() {
        return b.b(this.f357a);
    }

    public int c() {
        return b.c(this.f357a);
    }

    public int d() {
        return b.f(this.f357a);
    }

    public int e() {
        return b.g(this.f357a);
    }

    public boolean f() {
        return b.d(this.f357a);
    }

    public void a(int i, int i2, int i3, int i4, int i5) {
        b.a(this.f357a, i, i2, i3, i4, i5);
    }

    public void g() {
        b.e(this.f357a);
    }
}
