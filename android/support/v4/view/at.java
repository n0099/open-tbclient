package android.support.v4.view;

import android.graphics.Paint;
import android.view.View;
/* loaded from: classes.dex */
class at extends as {
    @Override // android.support.v4.view.ar
    long a() {
        return az.a();
    }

    @Override // android.support.v4.view.ar, android.support.v4.view.ax
    public void a(View view, int i, Paint paint) {
        az.a(view, i, paint);
    }

    @Override // android.support.v4.view.ar, android.support.v4.view.ax
    public int d(View view) {
        return az.a(view);
    }

    @Override // android.support.v4.view.ar, android.support.v4.view.ax
    public void a(View view, Paint paint) {
        a(view, d(view), paint);
        view.invalidate();
    }
}
