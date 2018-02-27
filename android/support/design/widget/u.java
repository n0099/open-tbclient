package android.support.design.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.support.design.widget.s;
import android.view.animation.Interpolator;
/* loaded from: classes2.dex */
class u extends s.e {
    private final ValueAnimator sD = new ValueAnimator();

    @Override // android.support.design.widget.s.e
    public void start() {
        this.sD.start();
    }

    @Override // android.support.design.widget.s.e
    public boolean isRunning() {
        return this.sD.isRunning();
    }

    @Override // android.support.design.widget.s.e
    public void setInterpolator(Interpolator interpolator) {
        this.sD.setInterpolator(interpolator);
    }

    @Override // android.support.design.widget.s.e
    public void a(final s.e.b bVar) {
        this.sD.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: android.support.design.widget.u.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                bVar.cC();
            }
        });
    }

    @Override // android.support.design.widget.s.e
    public void a(final s.e.a aVar) {
        this.sD.addListener(new AnimatorListenerAdapter() { // from class: android.support.design.widget.u.2
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
        this.sD.setIntValues(i, i2);
    }

    @Override // android.support.design.widget.s.e
    public int cA() {
        return ((Integer) this.sD.getAnimatedValue()).intValue();
    }

    @Override // android.support.design.widget.s.e
    public void e(float f, float f2) {
        this.sD.setFloatValues(f, f2);
    }

    @Override // android.support.design.widget.s.e
    public float cB() {
        return ((Float) this.sD.getAnimatedValue()).floatValue();
    }

    @Override // android.support.design.widget.s.e
    public void setDuration(long j) {
        this.sD.setDuration(j);
    }

    @Override // android.support.design.widget.s.e
    public void cancel() {
        this.sD.cancel();
    }

    @Override // android.support.design.widget.s.e
    public float getAnimatedFraction() {
        return this.sD.getAnimatedFraction();
    }

    @Override // android.support.design.widget.s.e
    public void end() {
        this.sD.end();
    }

    @Override // android.support.design.widget.s.e
    public long getDuration() {
        return this.sD.getDuration();
    }
}
