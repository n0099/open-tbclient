package android.support.v4.animation;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.View;
/* loaded from: classes2.dex */
class c implements android.support.v4.animation.a {
    private TimeInterpolator wg;

    @Override // android.support.v4.animation.a
    public ValueAnimatorCompat emptyValueAnimator() {
        return new b(ValueAnimator.ofFloat(0.0f, 1.0f));
    }

    /* loaded from: classes2.dex */
    static class b implements ValueAnimatorCompat {
        final Animator wj;

        public b(Animator animator) {
            this.wj = animator;
        }

        @Override // android.support.v4.animation.ValueAnimatorCompat
        public void setTarget(View view) {
            this.wj.setTarget(view);
        }

        @Override // android.support.v4.animation.ValueAnimatorCompat
        public void addListener(AnimatorListenerCompat animatorListenerCompat) {
            this.wj.addListener(new a(animatorListenerCompat, this));
        }

        @Override // android.support.v4.animation.ValueAnimatorCompat
        public void setDuration(long j) {
            this.wj.setDuration(j);
        }

        @Override // android.support.v4.animation.ValueAnimatorCompat
        public void start() {
            this.wj.start();
        }

        @Override // android.support.v4.animation.ValueAnimatorCompat
        public void cancel() {
            this.wj.cancel();
        }

        @Override // android.support.v4.animation.ValueAnimatorCompat
        public void addUpdateListener(final AnimatorUpdateListenerCompat animatorUpdateListenerCompat) {
            if (this.wj instanceof ValueAnimator) {
                ((ValueAnimator) this.wj).addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: android.support.v4.animation.c.b.1
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        animatorUpdateListenerCompat.onAnimationUpdate(b.this);
                    }
                });
            }
        }

        @Override // android.support.v4.animation.ValueAnimatorCompat
        public float getAnimatedFraction() {
            return ((ValueAnimator) this.wj).getAnimatedFraction();
        }
    }

    /* loaded from: classes2.dex */
    static class a implements Animator.AnimatorListener {
        final AnimatorListenerCompat wh;
        final ValueAnimatorCompat wi;

        public a(AnimatorListenerCompat animatorListenerCompat, ValueAnimatorCompat valueAnimatorCompat) {
            this.wh = animatorListenerCompat;
            this.wi = valueAnimatorCompat;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            this.wh.onAnimationStart(this.wi);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.wh.onAnimationEnd(this.wi);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.wh.onAnimationCancel(this.wi);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            this.wh.onAnimationRepeat(this.wi);
        }
    }

    @Override // android.support.v4.animation.a
    public void clearInterpolator(View view) {
        if (this.wg == null) {
            this.wg = new ValueAnimator().getInterpolator();
        }
        view.animate().setInterpolator(this.wg);
    }
}
