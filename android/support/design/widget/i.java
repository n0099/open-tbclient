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
    Drawable oT;
    Drawable oU;
    b oV;
    Drawable oW;
    float oX;
    float oY;
    final ab pa;
    final o pd;
    final s.d pe;
    private ViewTreeObserver.OnPreDrawListener pf;
    static final Interpolator oR = android.support.design.widget.a.kC;
    static final int[] PRESSED_ENABLED_STATE_SET = {16842919, 16842910};
    static final int[] oZ = {16842908, 16842910};
    static final int[] ENABLED_STATE_SET = {16842910};
    static final int[] EMPTY_STATE_SET = new int[0];
    int oS = 0;
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

    abstract void b(Rect rect);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void b(a aVar, boolean z);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void b(int[] iArr);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void bO();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void bP();

    abstract void c(float f, float f2);

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
        this.pa = abVar;
        this.pd = oVar;
        this.pe = dVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void setElevation(float f) {
        if (this.oX != f) {
            this.oX = f;
            c(f, this.oY);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void i(float f) {
        if (this.oY != f) {
            this.oY = f;
            c(this.oX, f);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Drawable getContentBackground() {
        return this.oW;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void bV() {
        Rect rect = this.mTmpRect;
        b(rect);
        c(rect);
        this.pd.e(rect.left, rect.top, rect.right, rect.bottom);
    }

    void c(Rect rect) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onAttachedToWindow() {
        if (bR()) {
            bv();
            this.pa.getViewTreeObserver().addOnPreDrawListener(this.pf);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onDetachedFromWindow() {
        if (this.pf != null) {
            this.pa.getViewTreeObserver().removeOnPreDrawListener(this.pf);
            this.pf = null;
        }
    }

    boolean bR() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b a(int i, ColorStateList colorStateList) {
        Context context = this.pa.getContext();
        b bW = bW();
        bW.b(ContextCompat.getColor(context, R.color.design_fab_stroke_top_outer_color), ContextCompat.getColor(context, R.color.design_fab_stroke_top_inner_color), ContextCompat.getColor(context, R.color.design_fab_stroke_end_inner_color), ContextCompat.getColor(context, R.color.design_fab_stroke_end_outer_color));
        bW.b(i);
        bW.a(colorStateList);
        return bW;
    }

    b bW() {
        return new b();
    }

    void bS() {
    }

    private void bv() {
        if (this.pf == null) {
            this.pf = new ViewTreeObserver.OnPreDrawListener() { // from class: android.support.design.widget.i.1
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
        return this.pa.getVisibility() != 0 ? this.oS == 2 : this.oS != 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean bZ() {
        return this.pa.getVisibility() == 0 ? this.oS == 1 : this.oS != 2;
    }
}
