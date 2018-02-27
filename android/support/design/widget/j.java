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
    private InsetDrawable pg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(ab abVar, o oVar, s.d dVar) {
        super(abVar, oVar, dVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // android.support.design.widget.g, android.support.design.widget.i
    public void a(ColorStateList colorStateList, PorterDuff.Mode mode, int i, int i2) {
        Drawable drawable;
        this.oS = DrawableCompat.wrap(bX());
        DrawableCompat.setTintList(this.oS, colorStateList);
        if (mode != null) {
            DrawableCompat.setTintMode(this.oS, mode);
        }
        if (i2 > 0) {
            this.oU = a(i2, colorStateList);
            drawable = new LayerDrawable(new Drawable[]{this.oU, this.oS});
        } else {
            this.oU = null;
            drawable = this.oS;
        }
        this.oT = new RippleDrawable(ColorStateList.valueOf(i), drawable, null);
        this.oV = this.oT;
        this.pa.setBackgroundDrawable(this.oT);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // android.support.design.widget.g, android.support.design.widget.i
    public void setRippleColor(int i) {
        if (this.oT instanceof RippleDrawable) {
            ((RippleDrawable) this.oT).setColor(ColorStateList.valueOf(i));
        } else {
            super.setRippleColor(i);
        }
    }

    @Override // android.support.design.widget.g, android.support.design.widget.i
    void c(float f, float f2) {
        StateListAnimator stateListAnimator = new StateListAnimator();
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ObjectAnimator.ofFloat(this.oZ, "elevation", f).setDuration(0L)).with(ObjectAnimator.ofFloat(this.oZ, View.TRANSLATION_Z, f2).setDuration(100L));
        animatorSet.setInterpolator(oQ);
        stateListAnimator.addState(PRESSED_ENABLED_STATE_SET, animatorSet);
        AnimatorSet animatorSet2 = new AnimatorSet();
        animatorSet2.play(ObjectAnimator.ofFloat(this.oZ, "elevation", f).setDuration(0L)).with(ObjectAnimator.ofFloat(this.oZ, View.TRANSLATION_Z, f2).setDuration(100L));
        animatorSet2.setInterpolator(oQ);
        stateListAnimator.addState(oY, animatorSet2);
        AnimatorSet animatorSet3 = new AnimatorSet();
        AnimatorSet animatorSet4 = new AnimatorSet();
        animatorSet4.play(ObjectAnimator.ofFloat(this.oZ, View.TRANSLATION_Z, 0.0f).setDuration(100L)).after(100L);
        animatorSet3.play(ObjectAnimator.ofFloat(this.oZ, "elevation", f).setDuration(0L)).with(animatorSet4);
        animatorSet3.setInterpolator(oQ);
        stateListAnimator.addState(ENABLED_STATE_SET, animatorSet3);
        AnimatorSet animatorSet5 = new AnimatorSet();
        animatorSet5.play(ObjectAnimator.ofFloat(this.oZ, "elevation", 0.0f).setDuration(0L)).with(ObjectAnimator.ofFloat(this.oZ, View.TRANSLATION_Z, 0.0f).setDuration(0L));
        animatorSet5.setInterpolator(oQ);
        stateListAnimator.addState(EMPTY_STATE_SET, animatorSet5);
        this.oZ.setStateListAnimator(stateListAnimator);
        if (this.pa.bN()) {
            bV();
        }
    }

    @Override // android.support.design.widget.g, android.support.design.widget.i
    public float getElevation() {
        return this.oZ.getElevation();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // android.support.design.widget.g, android.support.design.widget.i
    public void bP() {
        bV();
    }

    @Override // android.support.design.widget.i
    void d(Rect rect) {
        if (this.pa.bN()) {
            this.pg = new InsetDrawable(this.oT, rect.left, rect.top, rect.right, rect.bottom);
            this.pa.setBackgroundDrawable(this.pg);
            return;
        }
        this.pa.setBackgroundDrawable(this.oT);
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
        if (this.pa.bN()) {
            float radius = this.pa.getRadius();
            float elevation = getElevation() + this.oX;
            int ceil = (int) Math.ceil(n.b(elevation, radius, false));
            int ceil2 = (int) Math.ceil(n.a(elevation, radius, false));
            rect.set(ceil, ceil2, ceil, ceil2);
            return;
        }
        rect.set(0, 0, 0, 0);
    }
}
