package android.support.v4.view;

import android.graphics.Paint;
import android.view.View;
/* loaded from: classes.dex */
class ar implements ax {
    @Override // android.support.v4.view.ax
    public boolean a(View view, int i) {
        return false;
    }

    @Override // android.support.v4.view.ax
    public int a(View view) {
        return 2;
    }

    @Override // android.support.v4.view.ax
    public void a(View view, a aVar) {
    }

    @Override // android.support.v4.view.ax
    public void b(View view) {
        view.postInvalidateDelayed(a());
    }

    @Override // android.support.v4.view.ax
    public void a(View view, int i, int i2, int i3, int i4) {
        view.postInvalidateDelayed(a(), i, i2, i3, i4);
    }

    @Override // android.support.v4.view.ax
    public void a(View view, Runnable runnable) {
        view.postDelayed(runnable, a());
    }

    long a() {
        return 10L;
    }

    @Override // android.support.v4.view.ax
    public int c(View view) {
        return 0;
    }

    @Override // android.support.v4.view.ax
    public void b(View view, int i) {
    }

    @Override // android.support.v4.view.ax
    public void a(View view, int i, Paint paint) {
    }

    @Override // android.support.v4.view.ax
    public int d(View view) {
        return 0;
    }

    @Override // android.support.v4.view.ax
    public void a(View view, Paint paint) {
    }

    @Override // android.support.v4.view.ax
    public int e(View view) {
        return 0;
    }
}
