package android.support.design.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.support.design.R;
import android.support.design.widget.s;
import android.support.v4.content.ContextCompat;
import android.view.ViewTreeObserver;
import android.view.animation.Interpolator;
/* loaded from: classes2.dex */
abstract class i {
    Drawable oS;
    Drawable oT;
    b oU;
    Drawable oV;
    float oW;
    float oX;
    final ab oZ;
    final o pa;
    final s.d pd;
    private ViewTreeObserver.OnPreDrawListener pe;
    static final Interpolator oQ = android.support.design.widget.a.kC;
    static final int[] PRESSED_ENABLED_STATE_SET = {16842919, 16842910};
    static final int[] oY = {16842908, 16842910};
    static final int[] ENABLED_STATE_SET = {16842910};
    static final int[] EMPTY_STATE_SET = new int[0];
    int oR = 0;
    private final Rect mTmpRect = new Rect();

    /* loaded from: classes2.dex */
    interface a {
        void bL();

        void bM();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void a(ColorStateList colorStateList, PorterDuff.Mode mode, int i, int i2);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void a(a aVar, boolean z);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void b(a aVar, boolean z);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void bO();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void bP();

    abstract void c(float f, float f2);

    abstract void c(Rect rect);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void c(int[] iArr);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract float getElevation();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void setBackgroundTintList(ColorStateList colorStateList);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void setBackgroundTintMode(PorterDuff.Mode mode);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void setRippleColor(int i);

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(ab abVar, o oVar, s.d dVar) {
        this.oZ = abVar;
        this.pa = oVar;
        this.pd = dVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void setElevation(float f) {
        if (this.oW != f) {
            this.oW = f;
            c(f, this.oX);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void m(float f) {
        if (this.oX != f) {
            this.oX = f;
            c(this.oW, f);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Drawable getContentBackground() {
        return this.oV;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void bV() {
        Rect rect = this.mTmpRect;
        c(rect);
        d(rect);
        this.pa.e(rect.left, rect.top, rect.right, rect.bottom);
    }

    void d(Rect rect) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onAttachedToWindow() {
        if (bR()) {
            bv();
            this.oZ.getViewTreeObserver().addOnPreDrawListener(this.pe);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onDetachedFromWindow() {
        if (this.pe != null) {
            this.oZ.getViewTreeObserver().removeOnPreDrawListener(this.pe);
            this.pe = null;
        }
    }

    boolean bR() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b a(int i, ColorStateList colorStateList) {
        Context context = this.oZ.getContext();
        b bW = bW();
        bW.b(ContextCompat.getColor(context, R.color.design_fab_stroke_top_outer_color), ContextCompat.getColor(context, R.color.design_fab_stroke_top_inner_color), ContextCompat.getColor(context, R.color.design_fab_stroke_end_inner_color), ContextCompat.getColor(context, R.color.design_fab_stroke_end_outer_color));
        bW.f(i);
        bW.a(colorStateList);
        return bW;
    }

    b bW() {
        return new b();
    }

    void bS() {
    }

    private void bv() {
        if (this.pe == null) {
            this.pe = new ViewTreeObserver.OnPreDrawListener() { // from class: android.support.design.widget.i.1
                @Override // android.view.ViewTreeObserver.OnPreDrawListener
                public boolean onPreDraw() {
                    i.this.bS();
                    return true;
                }
            };
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public GradientDrawable bX() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(1);
        gradientDrawable.setColor(-1);
        return gradientDrawable;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean bY() {
        return this.oZ.getVisibility() != 0 ? this.oR == 2 : this.oR != 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean bZ() {
        return this.oZ.getVisibility() == 0 ? this.oR == 1 : this.oR != 2;
    }
}
