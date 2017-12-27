package android.support.design.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.support.design.widget.s;
import android.view.animation.Interpolator;
/* loaded from: classes2.dex */
class u extends s.e {
    private final ValueAnimator sE = new ValueAnimator();

    @Override // android.support.design.widget.s.e
    public void start() {
        this.sE.start();
    }

    @Override // android.support.design.widget.s.e
    public boolean isRunning() {
        return this.sE.isRunning();
    }

    @Override // android.support.design.widget.s.e
    public void setInterpolator(Interpolator interpolator) {
        this.sE.setInterpolator(interpolator);
    }

    @Override // android.support.design.widget.s.e
    public void a(final s.e.b bVar) {
        this.sE.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: android.support.design.widget.u.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                bVar.cC();
            }
        });
    }

    @Override // android.support.design.widget.s.e
    public void a(final s.e.a aVar) {
        this.sE.addListener(new AnimatorListenerAdapter() { // from class: android.support.design.widget.u.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                aVar.onAnimationStart();
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                aVar.onAnimationEnd();
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                aVar.cD();
            }
        });
    }

    @Override // android.support.design.widget.s.e
    public void q(int i, int i2) {
        this.sE.setIntValues(i, i2);
    }

    @Override // android.support.design.widget.s.e
    public int cA() {
        return ((Integer) this.sE.getAnimatedValue()).intValue();
    }

    @Override // android.support.design.widget.s.e
    public void e(float f, float f2) {
        this.sE.setFloatValues(f, f2);
    }

    @Override // android.support.design.widget.s.e
    public float cB() {
        return ((Float) this.sE.getAnimatedValue()).floatValue();
    }

    @Override // android.support.design.widget.s.e
    public void setDuration(long j) {
        this.sE.setDuration(j);
    }

    @Override // android.support.design.widget.s.e
    public void cancel() {
        this.sE.cancel();
    }

    @Override // android.support.design.widget.s.e
    public float getAnimatedFraction() {
        return this.sE.getAnimatedFraction();
    }

    @Override // android.support.design.widget.s.e
    public void end() {
        this.sE.end();
    }

    @Override // android.support.design.widget.s.e
    public long getDuration() {
        return this.sE.getDuration();
    }
}
