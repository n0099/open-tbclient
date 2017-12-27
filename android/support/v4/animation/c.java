package android.support.v4.animation;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.View;
/* loaded from: classes2.dex */
class c implements android.support.v4.animation.a {
    private TimeInterpolator wh;

    @Override // android.support.v4.animation.a
    public ValueAnimatorCompat emptyValueAnimator() {
        return new b(ValueAnimator.ofFloat(0.0f, 1.0f));
    }

    /* loaded from: classes2.dex */
    static class b implements ValueAnimatorCompat {
        final Animator wk;

        public b(Animator animator) {
            this.wk = animator;
        }

        @Override // android.support.v4.animation.ValueAnimatorCompat
        public void setTarget(View view) {
            this.wk.setTarget(view);
        }

        @Override // android.support.v4.animation.ValueAnimatorCompat
        public void addListener(AnimatorListenerCompat animatorListenerCompat) {
            this.wk.addListener(new a(animatorListenerCompat, this));
        }

        @Override // android.support.v4.animation.ValueAnimatorCompat
        public void setDuration(long j) {
            this.wk.setDuration(j);
        }

        @Override // android.support.v4.animation.ValueAnimatorCompat
        public void start() {
            this.wk.start();
        }

        @Override // android.support.v4.animation.ValueAnimatorCompat
        public void cancel() {
            this.wk.cancel();
        }

        @Override // android.support.v4.animation.ValueAnimatorCompat
        public void addUpdateListener(final AnimatorUpdateListenerCompat animatorUpdateListenerCompat) {
            if (this.wk instanceof ValueAnimator) {
                ((ValueAnimator) this.wk).addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: android.support.v4.animation.c.b.1
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        animatorUpdateListenerCompat.onAnimationUpdate(b.this);
                    }
                });
            }
        }

        @Override // android.support.v4.animation.ValueAnimatorCompat
        public float getAnimatedFraction() {
            return ((ValueAnimator) this.wk).getAnimatedFraction();
        }
    }

    /* loaded from: classes2.dex */
    static class a implements Animator.AnimatorListener {
        final AnimatorListenerCompat wi;
        final ValueAnimatorCompat wj;

        public a(AnimatorListenerCompat animatorListenerCompat, ValueAnimatorCompat valueAnimatorCompat) {
            this.wi = animatorListenerCompat;
            this.wj = valueAnimatorCompat;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            this.wi.onAnimationStart(this.wj);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.wi.onAnimationEnd(this.wj);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.wi.onAnimationCancel(this.wj);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            this.wi.onAnimationRepeat(this.wj);
        }
    }

    @Override // android.support.v4.animation.a
    public void clearInterpolator(View view) {
        if (this.wh == null) {
            this.wh = new ValueAnimator().getInterpolator();
        }
        view.animate().setInterpolator(this.wh);
    }
}
