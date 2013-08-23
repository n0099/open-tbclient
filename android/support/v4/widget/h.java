package android.support.v4.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Build;
/* loaded from: classes.dex */
public class h {
    private static final k b;

    /* renamed from: a  reason: collision with root package name */
    private Object f342a;

    static {
        if (Build.VERSION.SDK_INT >= 14) {
            b = new j();
        } else {
            b = new i();
        }
    }

    public h(Context context) {
        this.f342a = b.a(context);
    }

    public void a(int i, int i2) {
        b.a(this.f342a, i, i2);
    }

    public boolean a() {
        return b.a(this.f342a);
    }

    public void b() {
        b.b(this.f342a);
    }

    public boolean a(float f) {
        return b.a(this.f342a, f);
    }

    public boolean c() {
        return b.c(this.f342a);
    }

    public boolean a(Canvas canvas) {
        return b.a(this.f342a, canvas);
    }
}
