package android.support.v4.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Build;
/* loaded from: classes.dex */
public class h {
    private static final k b;

    /* renamed from: a  reason: collision with root package name */
    private Object f356a;

    static {
        if (Build.VERSION.SDK_INT >= 14) {
            b = new j();
        } else {
            b = new i();
        }
    }

    public h(Context context) {
        this.f356a = b.a(context);
    }

    public void a(int i, int i2) {
        b.a(this.f356a, i, i2);
    }

    public boolean a() {
        return b.a(this.f356a);
    }

    public void b() {
        b.b(this.f356a);
    }

    public boolean a(float f) {
        return b.a(this.f356a, f);
    }

    public boolean c() {
        return b.c(this.f356a);
    }

    public boolean a(Canvas canvas) {
        return b.a(this.f356a, canvas);
    }
}
