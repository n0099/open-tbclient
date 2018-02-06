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
        this.mRotation = this.pa.getRotation();
    }

    @Override // android.support.design.widget.i
    boolean bR() {
        return true;
    }

    @Override // android.support.design.widget.i
    void bS() {
        float rotation = this.pa.getRotation();
        if (this.mRotation != rotation) {
            this.mRotation = rotation;
            bU();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // android.support.design.widget.g, android.support.design.widget.i
    public void a(final i.a aVar, final boolean z) {
        if (!bZ()) {
            this.pa.animate().cancel();
            if (bT()) {
                this.oS = 1;
                this.pa.animate().scaleX(0.0f).scaleY(0.0f).alpha(0.0f).setDuration(200L).setInterpolator(a.kC).setListener(new AnimatorListenerAdapter() { // from class: android.support.design.widget.h.1
                    private boolean oP;

                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                        h.this.pa.e(0, z);
                        this.oP = false;
                    }

                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                        this.oP = true;
                    }

                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        h.this.oS = 0;
                        if (!this.oP) {
                            h.this.pa.e(8, z);
                            if (aVar != null) {
                                aVar.bM();
                            }
                        }
                    }
                });
                return;
            }
            this.pa.e(8, z);
            if (aVar != null) {
                aVar.bM();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // android.support.design.widget.g, android.support.design.widget.i
    public void b(final i.a aVar, final boolean z) {
        if (!bY()) {
            this.pa.animate().cancel();
            if (bT()) {
                this.oS = 2;
                if (this.pa.getVisibility() != 0) {
                    this.pa.setAlpha(0.0f);
                    this.pa.setScaleY(0.0f);
                    this.pa.setScaleX(0.0f);
                }
                this.pa.animate().scaleX(1.0f).scaleY(1.0f).alpha(1.0f).setDuration(200L).setInterpolator(a.kD).setListener(new AnimatorListenerAdapter() { // from class: android.support.design.widget.h.2
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                        h.this.pa.e(0, z);
                    }

                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        h.this.oS = 0;
                        if (aVar != null) {
                            aVar.bL();
                        }
                    }
                });
                return;
            }
            this.pa.e(0, z);
            this.pa.setAlpha(1.0f);
            this.pa.setScaleY(1.0f);
            this.pa.setScaleX(1.0f);
            if (aVar != null) {
                aVar.bL();
            }
        }
    }

    private boolean bT() {
        return ViewCompat.isLaidOut(this.pa) && !this.pa.isInEditMode();
    }

    private void bU() {
        if (Build.VERSION.SDK_INT == 19) {
            if (this.mRotation % 90.0f != 0.0f) {
                if (this.pa.getLayerType() != 1) {
                    this.pa.setLayerType(1, null);
                }
            } else if (this.pa.getLayerType() != 0) {
                this.pa.setLayerType(0, null);
            }
        }
        if (this.oI != null) {
            this.oI.setRotation(-this.mRotation);
        }
        if (this.oV != null) {
            this.oV.setRotation(-this.mRotation);
        }
    }
}
