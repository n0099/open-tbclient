package android.support.v4.widget;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g extends af {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ DrawerLayout f337a;
    private final int b;
    private ad c;
    private final Runnable d;

    public void a() {
        this.f337a.removeCallbacks(this.d);
    }

    @Override // android.support.v4.widget.af
    public boolean a(View view, int i) {
        return this.f337a.g(view) && this.f337a.a(view, this.b) && this.f337a.a(view) == 0;
    }

    @Override // android.support.v4.widget.af
    public void a(int i) {
        this.f337a.a(this.b, i, this.c.c());
    }

    @Override // android.support.v4.widget.af
    public void a(View view, int i, int i2, int i3, int i4) {
        float width;
        int width2 = view.getWidth();
        if (this.f337a.a(view, 3)) {
            width = (width2 + i) / width2;
        } else {
            width = (this.f337a.getWidth() - i) / width2;
        }
        this.f337a.b(view, width);
        view.setVisibility(width == 0.0f ? 4 : 0);
        this.f337a.invalidate();
    }

    @Override // android.support.v4.widget.af
    public void b(View view, int i) {
        ((e) view.getLayoutParams()).c = false;
        b();
    }

    private void b() {
        View a2 = this.f337a.a(this.b == 3 ? 5 : 3);
        if (a2 != null) {
            this.f337a.i(a2);
        }
    }

    @Override // android.support.v4.widget.af
    public void a(View view, float f, float f2) {
        int width;
        float d = this.f337a.d(view);
        int width2 = view.getWidth();
        if (this.f337a.a(view, 3)) {
            width = (f > 0.0f || (f == 0.0f && d > 0.5f)) ? 0 : -width2;
        } else {
            width = this.f337a.getWidth();
            if (f < 0.0f || (f == 0.0f && d < 0.5f)) {
                width -= width2;
            }
        }
        this.c.a(width, view.getTop());
        this.f337a.invalidate();
    }

    @Override // android.support.v4.widget.af
    public void a(int i, int i2) {
        this.f337a.postDelayed(this.d, 160L);
    }

    @Override // android.support.v4.widget.af
    public boolean b(int i) {
        return false;
    }

    @Override // android.support.v4.widget.af
    public void b(int i, int i2) {
        View a2;
        if ((i & 1) == 1) {
            a2 = this.f337a.a(3);
        } else {
            a2 = this.f337a.a(5);
        }
        if (a2 != null && this.f337a.a(a2) == 0) {
            this.c.a(a2, i2);
        }
    }

    @Override // android.support.v4.widget.af
    public int a(View view) {
        return view.getWidth();
    }

    @Override // android.support.v4.widget.af
    public int a(View view, int i, int i2) {
        if (this.f337a.a(view, 3)) {
            return Math.max(-view.getWidth(), Math.min(i, 0));
        }
        int width = this.f337a.getWidth();
        return Math.max(width - view.getWidth(), Math.min(i, width));
    }

    @Override // android.support.v4.widget.af
    public int b(View view, int i, int i2) {
        return view.getTop();
    }
}
