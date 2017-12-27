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
    private final q oH;
    n oI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(ab abVar, o oVar, s.d dVar) {
        super(abVar, oVar, dVar);
        this.oH = new q();
        this.oH.a(PRESSED_ENABLED_STATE_SET, a(new b()));
        this.oH.a(oZ, a(new b()));
        this.oH.a(ENABLED_STATE_SET, a(new c()));
        this.oH.a(EMPTY_STATE_SET, a(new a()));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // android.support.design.widget.i
    public void a(ColorStateList colorStateList, PorterDuff.Mode mode, int i, int i2) {
        Drawable[] drawableArr;
        this.oT = DrawableCompat.wrap(bX());
        DrawableCompat.setTintList(this.oT, colorStateList);
        if (mode != null) {
            DrawableCompat.setTintMode(this.oT, mode);
        }
        this.oU = DrawableCompat.wrap(bX());
        DrawableCompat.setTintList(this.oU, E(i));
        if (i2 > 0) {
            this.oV = a(i2, colorStateList);
            drawableArr = new Drawable[]{this.oV, this.oT, this.oU};
        } else {
            this.oV = null;
            drawableArr = new Drawable[]{this.oT, this.oU};
        }
        this.oW = new LayerDrawable(drawableArr);
        this.oI = new n(this.pa.getContext(), this.oW, this.pd.getRadius(), this.oX, this.oX + this.oY);
        this.oI.k(false);
        this.pd.setBackgroundDrawable(this.oI);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // android.support.design.widget.i
    public void setBackgroundTintList(ColorStateList colorStateList) {
        if (this.oT != null) {
            DrawableCompat.setTintList(this.oT, colorStateList);
        }
        if (this.oV != null) {
            this.oV.a(colorStateList);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // android.support.design.widget.i
    public void setBackgroundTintMode(PorterDuff.Mode mode) {
        if (this.oT != null) {
            DrawableCompat.setTintMode(this.oT, mode);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // android.support.design.widget.i
    public void setRippleColor(int i) {
        if (this.oU != null) {
            DrawableCompat.setTintList(this.oU, E(i));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // android.support.design.widget.i
    public float getElevation() {
        return this.oX;
    }

    @Override // android.support.design.widget.i
    void c(float f, float f2) {
        if (this.oI != null) {
            this.oI.d(f, this.oY + f);
            bV();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // android.support.design.widget.i
    public void b(int[] iArr) {
        this.oH.c(iArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // android.support.design.widget.i
    public void bO() {
        this.oH.jumpToCurrentState();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // android.support.design.widget.i
    public void a(final i.a aVar, final boolean z) {
        if (!bZ()) {
            this.oS = 1;
            Animation loadAnimation = AnimationUtils.loadAnimation(this.pa.getContext(), R.anim.design_fab_out);
            loadAnimation.setInterpolator(android.support.design.widget.a.kC);
            loadAnimation.setDuration(200L);
            loadAnimation.setAnimationListener(new a.animation.Animation$AnimationListenerC0002a() { // from class: android.support.design.widget.g.1
                @Override // android.support.design.widget.a.animation.Animation$AnimationListenerC0002a, android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    g.this.oS = 0;
                    g.this.pa.b(8, z);
                    if (aVar != null) {
                        aVar.bM();
                    }
                }
            });
            this.pa.startAnimation(loadAnimation);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // android.support.design.widget.i
    public void b(final i.a aVar, boolean z) {
        if (!bY()) {
            this.oS = 2;
            this.pa.b(0, z);
            Animation loadAnimation = AnimationUtils.loadAnimation(this.pa.getContext(), R.anim.design_fab_in);
            loadAnimation.setDuration(200L);
            loadAnimation.setInterpolator(android.support.design.widget.a.kD);
            loadAnimation.setAnimationListener(new a.animation.Animation$AnimationListenerC0002a() { // from class: android.support.design.widget.g.2
                @Override // android.support.design.widget.a.animation.Animation$AnimationListenerC0002a, android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    g.this.oS = 0;
                    if (aVar != null) {
                        aVar.bL();
                    }
                }
            });
            this.pa.startAnimation(loadAnimation);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // android.support.design.widget.i
    public void bP() {
    }

    @Override // android.support.design.widget.i
    void b(Rect rect) {
        this.oI.getPadding(rect);
    }

    private s a(d dVar) {
        s cE = this.pe.cE();
        cE.setInterpolator(oR);
        cE.setDuration(100L);
        cE.a((s.a) dVar);
        cE.a((s.c) dVar);
        cE.e(0.0f, 1.0f);
        return cE;
    }

    /* loaded from: classes2.dex */
    private abstract class d extends s.b implements s.c {
        private boolean oM;
        private float oN;
        private float oO;

        protected abstract float bQ();

        private d() {
        }

        @Override // android.support.design.widget.s.c
        public void a(s sVar) {
            if (!this.oM) {
                this.oN = g.this.oI.cd();
                this.oO = bQ();
                this.oM = true;
            }
            g.this.oI.k(this.oN + ((this.oO - this.oN) * sVar.getAnimatedFraction()));
        }

        @Override // android.support.design.widget.s.b, android.support.design.widget.s.a
        public void b(s sVar) {
            g.this.oI.k(this.oO);
            this.oM = false;
        }
    }

    /* loaded from: classes2.dex */
    private class c extends d {
        c() {
            super();
        }

        @Override // android.support.design.widget.g.d
        protected float bQ() {
            return g.this.oX;
        }
    }

    /* loaded from: classes2.dex */
    private class b extends d {
        b() {
            super();
        }

        @Override // android.support.design.widget.g.d
        protected float bQ() {
            return g.this.oX + g.this.oY;
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
        return new ColorStateList(new int[][]{oZ, PRESSED_ENABLED_STATE_SET, new int[0]}, new int[]{i, i, 0});
    }
}
