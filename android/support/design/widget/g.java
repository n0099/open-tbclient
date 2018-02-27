package android.support.design.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.support.design.R;
import android.support.design.widget.a;
import android.support.design.widget.i;
import android.support.design.widget.s;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class g extends i {
    private final q oG;
    n oH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(ab abVar, o oVar, s.d dVar) {
        super(abVar, oVar, dVar);
        this.oG = new q();
        this.oG.a(PRESSED_ENABLED_STATE_SET, a(new b()));
        this.oG.a(oY, a(new b()));
        this.oG.a(ENABLED_STATE_SET, a(new c()));
        this.oG.a(EMPTY_STATE_SET, a(new a()));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // android.support.design.widget.i
    public void a(ColorStateList colorStateList, PorterDuff.Mode mode, int i, int i2) {
        Drawable[] drawableArr;
        this.oS = DrawableCompat.wrap(bX());
        DrawableCompat.setTintList(this.oS, colorStateList);
        if (mode != null) {
            DrawableCompat.setTintMode(this.oS, mode);
        }
        this.oT = DrawableCompat.wrap(bX());
        DrawableCompat.setTintList(this.oT, E(i));
        if (i2 > 0) {
            this.oU = a(i2, colorStateList);
            drawableArr = new Drawable[]{this.oU, this.oS, this.oT};
        } else {
            this.oU = null;
            drawableArr = new Drawable[]{this.oS, this.oT};
        }
        this.oV = new LayerDrawable(drawableArr);
        this.oH = new n(this.oZ.getContext(), this.oV, this.pa.getRadius(), this.oW, this.oW + this.oX);
        this.oH.m(false);
        this.pa.setBackgroundDrawable(this.oH);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // android.support.design.widget.i
    public void setBackgroundTintList(ColorStateList colorStateList) {
        if (this.oS != null) {
            DrawableCompat.setTintList(this.oS, colorStateList);
        }
        if (this.oU != null) {
            this.oU.a(colorStateList);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // android.support.design.widget.i
    public void setBackgroundTintMode(PorterDuff.Mode mode) {
        if (this.oS != null) {
            DrawableCompat.setTintMode(this.oS, mode);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // android.support.design.widget.i
    public void setRippleColor(int i) {
        if (this.oT != null) {
            DrawableCompat.setTintList(this.oT, E(i));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // android.support.design.widget.i
    public float getElevation() {
        return this.oW;
    }

    @Override // android.support.design.widget.i
    void c(float f, float f2) {
        if (this.oH != null) {
            this.oH.d(f, this.oX + f);
            bV();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // android.support.design.widget.i
    public void c(int[] iArr) {
        this.oG.d(iArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // android.support.design.widget.i
    public void bO() {
        this.oG.jumpToCurrentState();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // android.support.design.widget.i
    public void a(final i.a aVar, final boolean z) {
        if (!bZ()) {
            this.oR = 1;
            Animation loadAnimation = AnimationUtils.loadAnimation(this.oZ.getContext(), R.anim.design_fab_out);
            loadAnimation.setInterpolator(android.support.design.widget.a.kC);
            loadAnimation.setDuration(200L);
            loadAnimation.setAnimationListener(new a.animation.Animation$AnimationListenerC0002a() { // from class: android.support.design.widget.g.1
                @Override // android.support.design.widget.a.animation.Animation$AnimationListenerC0002a, android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    g.this.oR = 0;
                    g.this.oZ.e(8, z);
                    if (aVar != null) {
                        aVar.bM();
                    }
                }
            });
            this.oZ.startAnimation(loadAnimation);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // android.support.design.widget.i
    public void b(final i.a aVar, boolean z) {
        if (!bY()) {
            this.oR = 2;
            this.oZ.e(0, z);
            Animation loadAnimation = AnimationUtils.loadAnimation(this.oZ.getContext(), R.anim.design_fab_in);
            loadAnimation.setDuration(200L);
            loadAnimation.setInterpolator(android.support.design.widget.a.kD);
            loadAnimation.setAnimationListener(new a.animation.Animation$AnimationListenerC0002a() { // from class: android.support.design.widget.g.2
                @Override // android.support.design.widget.a.animation.Animation$AnimationListenerC0002a, android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    g.this.oR = 0;
                    if (aVar != null) {
                        aVar.bL();
                    }
                }
            });
            this.oZ.startAnimation(loadAnimation);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // android.support.design.widget.i
    public void bP() {
    }

    @Override // android.support.design.widget.i
    void c(Rect rect) {
        this.oH.getPadding(rect);
    }

    private s a(d dVar) {
        s cE = this.pd.cE();
        cE.setInterpolator(oQ);
        cE.setDuration(100L);
        cE.a((s.a) dVar);
        cE.a((s.c) dVar);
        cE.e(0.0f, 1.0f);
        return cE;
    }

    /* loaded from: classes2.dex */
    private abstract class d extends s.b implements s.c {
        private boolean oL;
        private float oM;
        private float oN;

        protected abstract float bQ();

        private d() {
        }

        @Override // android.support.design.widget.s.c
        public void a(s sVar) {
            if (!this.oL) {
                this.oM = g.this.oH.cd();
                this.oN = bQ();
                this.oL = true;
            }
            g.this.oH.o(this.oM + ((this.oN - this.oM) * sVar.getAnimatedFraction()));
        }

        @Override // android.support.design.widget.s.b, android.support.design.widget.s.a
        public void b(s sVar) {
            g.this.oH.o(this.oN);
            this.oL = false;
        }
    }

    /* loaded from: classes2.dex */
    private class c extends d {
        c() {
            super();
        }

        @Override // android.support.design.widget.g.d
        protected float bQ() {
            return g.this.oW;
        }
    }

    /* loaded from: classes2.dex */
    private class b extends d {
        b() {
            super();
        }

        @Override // android.support.design.widget.g.d
        protected float bQ() {
            return g.this.oW + g.this.oX;
        }
    }

    /* loaded from: classes2.dex */
    private class a extends d {
        a() {
            super();
        }

        @Override // android.support.design.widget.g.d
        protected float bQ() {
            return 0.0f;
        }
    }

    private static ColorStateList E(int i) {
        return new ColorStateList(new int[][]{oY, PRESSED_ENABLED_STATE_SET, new int[0]}, new int[]{i, i, 0});
    }
}
