package android.support.v4.app;

import android.app.Activity;
import android.os.Build;
import android.view.View;
/* loaded from: classes.dex */
public class ActionBarDrawerToggle implements android.support.v4.widget.d {
    private static final b a;
    private final Activity b;
    private boolean c;
    private e d;
    private final int e;
    private final int f;
    private Object g;

    static {
        if (Build.VERSION.SDK_INT >= 11) {
            a = new d();
        } else {
            a = new c();
        }
    }

    @Override // android.support.v4.widget.d
    public void a(View view, float f) {
        float min;
        float a2 = this.d.a();
        if (f > 0.5f) {
            min = Math.max(a2, Math.max(0.0f, f - 0.5f) * 2.0f);
        } else {
            min = Math.min(a2, f * 2.0f);
        }
        this.d.a(min);
    }

    @Override // android.support.v4.widget.d
    public void a(View view) {
        this.d.a(1.0f);
        if (this.c) {
            this.g = a.a(this.g, this.b, this.e);
        }
    }

    @Override // android.support.v4.widget.d
    public void b(View view) {
        this.d.a(0.0f);
        if (this.c) {
            this.g = a.a(this.g, this.b, this.f);
        }
    }

    @Override // android.support.v4.widget.d
    public void a(int i) {
    }
}
