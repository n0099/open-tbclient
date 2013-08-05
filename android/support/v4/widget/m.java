package android.support.v4.widget;

import android.os.Build;
/* loaded from: classes.dex */
public class m {
    static final n b;

    /* renamed from: a  reason: collision with root package name */
    Object f339a;

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
        return b.a(this.f339a);
    }

    public int b() {
        return b.b(this.f339a);
    }

    public int c() {
        return b.c(this.f339a);
    }

    public int d() {
        return b.f(this.f339a);
    }

    public int e() {
        return b.g(this.f339a);
    }

    public boolean f() {
        return b.d(this.f339a);
    }

    public void a(int i, int i2, int i3, int i4, int i5) {
        b.a(this.f339a, i, i2, i3, i4, i5);
    }

    public void g() {
        b.e(this.f339a);
    }
}
