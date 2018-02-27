package android.support.design.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.os.Build;
import android.support.design.widget.i;
import android.support.design.widget.s;
import android.support.v4.view.ViewCompat;
/* loaded from: classes2.dex */
class h extends g {
    private float mRotation;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(ab abVar, o oVar, s.d dVar) {
        super(abVar, oVar, dVar);
        this.mRotation = this.oZ.getRotation();
    }

    @Override // android.support.design.widget.i
    boolean bR() {
        return true;
    }

    @Override // android.support.design.widget.i
    void bS() {
        float rotation = this.oZ.getRotation();
        if (this.mRotation != rotation) {
            this.mRotation = rotation;
            bU();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // android.support.design.widget.g, android.support.design.widget.i
    public void a(final i.a aVar, final boolean z) {
        if (!bZ()) {
            this.oZ.animate().cancel();
            if (bT()) {
                this.oR = 1;
                this.oZ.animate().scaleX(0.0f).scaleY(0.0f).alpha(0.0f).setDuration(200L).setInterpolator(a.kC).setListener(new AnimatorListenerAdapter() { // from class: android.support.design.widget.h.1
                    private boolean oO;

                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                        h.this.oZ.e(0, z);
                        this.oO = false;
                    }

                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                        this.oO = true;
                    }

                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        h.this.oR = 0;
                        if (!this.oO) {
                            h.this.oZ.e(8, z);
                            if (aVar != null) {
                                aVar.bM();
                            }
                        }
                    }
                });
                return;
            }
            this.oZ.e(8, z);
            if (aVar != null) {
                aVar.bM();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // android.support.design.widget.g, android.support.design.widget.i
    public void b(final i.a aVar, final boolean z) {
        if (!bY()) {
            this.oZ.animate().cancel();
            if (bT()) {
                this.oR = 2;
                if (this.oZ.getVisibility() != 0) {
                    this.oZ.setAlpha(0.0f);
                    this.oZ.setScaleY(0.0f);
                    this.oZ.setScaleX(0.0f);
                }
                this.oZ.animate().scaleX(1.0f).scaleY(1.0f).alpha(1.0f).setDuration(200L).setInterpolator(a.kD).setListener(new AnimatorListenerAdapter() { // from class: android.support.design.widget.h.2
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                        h.this.oZ.e(0, z);
                    }

                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        h.this.oR = 0;
                        if (aVar != null) {
                            aVar.bL();
                        }
                    }
                });
                return;
            }
            this.oZ.e(0, z);
            this.oZ.setAlpha(1.0f);
            this.oZ.setScaleY(1.0f);
            this.oZ.setScaleX(1.0f);
            if (aVar != null) {
                aVar.bL();
            }
        }
    }

    private boolean bT() {
        return ViewCompat.isLaidOut(this.oZ) && !this.oZ.isInEditMode();
    }

    private void bU() {
        if (Build.VERSION.SDK_INT == 19) {
            if (this.mRotation % 90.0f != 0.0f) {
                if (this.oZ.getLayerType() != 1) {
                    this.oZ.setLayerType(1, null);
                }
            } else if (this.oZ.getLayerType() != 0) {
                this.oZ.setLayerType(0, null);
            }
        }
        if (this.oH != null) {
            this.oH.setRotation(-this.mRotation);
        }
        if (this.oU != null) {
            this.oU.setRotation(-this.mRotation);
        }
    }
}
