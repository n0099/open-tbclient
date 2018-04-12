package android.support.v4.animation;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.View;
/* loaded from: classes2.dex */
class HoneycombMr1AnimatorCompatProvider implements AnimatorProvider {
    private TimeInterpolator mDefaultInterpolator;

    @Override // android.support.v4.animation.AnimatorProvider
    public ValueAnimatorCompat emptyValueAnimator() {
        return new HoneycombValueAnimatorCompat(ValueAnimator.ofFloat(0.0f, 1.0f));
    }

    /* loaded from: classes2.dex */
    static class HoneycombValueAnimatorCompat implements ValueAnimatorCompat {
        final Animator mWrapped;

        public HoneycombValueAnimatorCompat(Animator animator) {
            this.mWrapped = animator;
        }

        @Override // android.support.v4.animation.ValueAnimatorCompat
        public void setTarget(View view2) {
            this.mWrapped.setTarget(view2);
        }

        @Override // android.support.v4.animation.ValueAnimatorCompat
        public void addListener(AnimatorListenerCompat animatorListenerCompat) {
            this.mWrapped.addListener(new AnimatorListenerCompatWrapper(animatorListenerCompat, this));
        }

        @Override // android.support.v4.animation.ValueAnimatorCompat
        public void setDuration(long j) {
            this.mWrapped.setDuration(j);
        }

        @Override // android.support.v4.animation.ValueAnimatorCompat
        public void start() {
            this.mWrapped.start();
        }

        @Override // android.support.v4.animation.ValueAnimatorCompat
        public void cancel() {
            this.mWrapped.cancel();
        }

        @Override // android.support.v4.animation.ValueAnimatorCompat
        public void addUpdateListener(final AnimatorUpdateListenerCompat animatorUpdateListenerCompat) {
            if (this.mWrapped instanceof ValueAnimator) {
                ((ValueAnimator) this.mWrapped).addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: android.support.v4.animation.HoneycombMr1AnimatorCompatProvider.HoneycombValueAnimatorCompat.1
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        animatorUpdateListenerCompat.onAnimationUpdate(HoneycombValueAnimatorCompat.this);
                    }
                });
            }
        }

        @Override // android.support.v4.animation.ValueAnimatorCompat
        public float getAnimatedFraction() {
            return ((ValueAnimator) this.mWrapped).getAnimatedFraction();
        }
    }

    /* loaded from: classes2.dex */
    static class AnimatorListenerCompatWrapper implements Animator.AnimatorListener {
        final ValueAnimatorCompat mValueAnimatorCompat;
        final AnimatorListenerCompat mWrapped;

        public AnimatorListenerCompatWrapper(AnimatorListenerCompat animatorListenerCompat, ValueAnimatorCompat valueAnimatorCompat) {
            this.mWrapped = animatorListenerCompat;
            this.mValueAnimatorCompat = valueAnimatorCompat;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            this.mWrapped.onAnimationStart(this.mValueAnimatorCompat);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.mWrapped.onAnimationEnd(this.mValueAnimatorCompat);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.mWrapped.onAnimationCancel(this.mValueAnimatorCompat);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            this.mWrapped.onAnimationRepeat(this.mValueAnimatorCompat);
        }
    }

    @Override // android.support.v4.animation.AnimatorProvider
    public void clearInterpolator(View view2) {
        if (this.mDefaultInterpolator == null) {
            this.mDefaultInterpolator = new ValueAnimator().getInterpolator();
        }
        view2.animate().setInterpolator(this.mDefaultInterpolator);
    }
}
