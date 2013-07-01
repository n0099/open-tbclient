package android.support.v4.widget;

import android.widget.Scroller;
/* loaded from: classes.dex */
class o implements n {
    @Override // android.support.v4.widget.n
    public boolean a(Object obj) {
        return ((Scroller) obj).isFinished();
    }

    @Override // android.support.v4.widget.n
    public int b(Object obj) {
        return ((Scroller) obj).getCurrX();
    }

    @Override // android.support.v4.widget.n
    public int c(Object obj) {
        return ((Scroller) obj).getCurrY();
    }

    @Override // android.support.v4.widget.n
    public boolean d(Object obj) {
        return ((Scroller) obj).computeScrollOffset();
    }

    @Override // android.support.v4.widget.n
    public void a(Object obj, int i, int i2, int i3, int i4, int i5) {
        ((Scroller) obj).startScroll(i, i2, i3, i4, i5);
    }

    @Override // android.support.v4.widget.n
    public void e(Object obj) {
        ((Scroller) obj).abortAnimation();
    }

    @Override // android.support.v4.widget.n
    public int f(Object obj) {
        return ((Scroller) obj).getFinalX();
    }

    @Override // android.support.v4.widget.n
    public int g(Object obj) {
        return ((Scroller) obj).getFinalY();
    }
}
