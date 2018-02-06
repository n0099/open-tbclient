package android.support.design.widget;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.StateListAnimator;
import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.support.design.widget.s;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.view.View;
@TargetApi(21)
/* loaded from: classes2.dex */
class j extends h {
    private InsetDrawable ph;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(ab abVar, o oVar, s.d dVar) {
        super(abVar, oVar, dVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // android.support.design.widget.g, android.support.design.widget.i
    public void a(ColorStateList colorStateList, PorterDuff.Mode mode, int i, int i2) {
        Drawable drawable;
        this.oT = DrawableCompat.wrap(bX());
        DrawableCompat.setTintList(this.oT, colorStateList);
        if (mode != null) {
            DrawableCompat.setTintMode(this.oT, mode);
        }
        if (i2 > 0) {
            this.oV = a(i2, colorStateList);
            drawable = new LayerDrawable(new Drawable[]{this.oV, this.oT});
        } else {
            this.oV = null;
            drawable = this.oT;
        }
        this.oU = new RippleDrawable(ColorStateList.valueOf(i), drawable, null);
        this.oW = this.oU;
        this.pd.setBackgroundDrawable(this.oU);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // android.support.design.widget.g, android.support.design.widget.i
    public void setRippleColor(int i) {
        if (this.oU instanceof RippleDrawable) {
            ((RippleDrawable) this.oU).setColor(ColorStateList.valueOf(i));
        } else {
            super.setRippleColor(i);
        }
    }

    @Override // android.support.design.widget.g, android.support.design.widget.i
    void c(float f, float f2) {
        StateListAnimator stateListAnimator = new StateListAnimator();
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ObjectAnimator.ofFloat(this.pa, "elevation", f).setDuration(0L)).with(ObjectAnimator.ofFloat(this.pa, View.TRANSLATION_Z, f2).setDuration(100L));
        animatorSet.setInterpolator(oR);
        stateListAnimator.addState(PRESSED_ENABLED_STATE_SET, animatorSet);
        AnimatorSet animatorSet2 = new AnimatorSet();
        animatorSet2.play(ObjectAnimator.ofFloat(this.pa, "elevation", f).setDuration(0L)).with(ObjectAnimator.ofFloat(this.pa, View.TRANSLATION_Z, f2).setDuration(100L));
        animatorSet2.setInterpolator(oR);
        stateListAnimator.addState(oZ, animatorSet2);
        AnimatorSet animatorSet3 = new AnimatorSet();
        AnimatorSet animatorSet4 = new AnimatorSet();
        animatorSet4.play(ObjectAnimator.ofFloat(this.pa, View.TRANSLATION_Z, 0.0f).setDuration(100L)).after(100L);
        animatorSet3.play(ObjectAnimator.ofFloat(this.pa, "elevation", f).setDuration(0L)).with(animatorSet4);
        animatorSet3.setInterpolator(oR);
        stateListAnimator.addState(ENABLED_STATE_SET, animatorSet3);
        AnimatorSet animatorSet5 = new AnimatorSet();
        animatorSet5.play(ObjectAnimator.ofFloat(this.pa, "elevation", 0.0f).setDuration(0L)).with(ObjectAnimator.ofFloat(this.pa, View.TRANSLATION_Z, 0.0f).setDuration(0L));
        animatorSet5.setInterpolator(oR);
        stateListAnimator.addState(EMPTY_STATE_SET, animatorSet5);
        this.pa.setStateListAnimator(stateListAnimator);
        if (this.pd.bN()) {
            bV();
        }
    }

    @Override // android.support.design.widget.g, android.support.design.widget.i
    public float getElevation() {
        return this.pa.getElevation();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // android.support.design.widget.g, android.support.design.widget.i
    public void bP() {
        bV();
    }

    @Override // android.support.design.widget.i
    void d(Rect rect) {
        if (this.pd.bN()) {
            this.ph = new InsetDrawable(this.oU, rect.left, rect.top, rect.right, rect.bottom);
            this.pd.setBackgroundDrawable(this.ph);
            return;
        }
        this.pd.setBackgroundDrawable(this.oU);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // android.support.design.widget.g, android.support.design.widget.i
    public void c(int[] iArr) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // android.support.design.widget.g, android.support.design.widget.i
    public void bO() {
    }

    @Override // android.support.design.widget.h, android.support.design.widget.i
    boolean bR() {
        return false;
    }

    @Override // android.support.design.widget.i
    b bW() {
        return new c();
    }

    @Override // android.support.design.widget.g, android.support.design.widget.i
    void c(Rect rect) {
        if (this.pd.bN()) {
            float radius = this.pd.getRadius();
            float elevation = getElevation() + this.oY;
            int ceil = (int) Math.ceil(n.b(elevation, radius, false));
            int ceil2 = (int) Math.ceil(n.a(elevation, radius, false));
            rect.set(ceil, ceil2, ceil, ceil2);
            return;
        }
        rect.set(0, 0, 0, 0);
    }
}
