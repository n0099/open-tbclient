package com.airbnb.lottie.d;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.os.Build;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
/* loaded from: classes3.dex */
public abstract class a extends ValueAnimator {
    private final Set<ValueAnimator.AnimatorUpdateListener> HC = new CopyOnWriteArraySet();
    private final Set<Animator.AnimatorListener> HD = new CopyOnWriteArraySet();

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public long getStartDelay() {
        throw new UnsupportedOperationException("LottieAnimator does not support getStartDelay.");
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public void setStartDelay(long j) {
        throw new UnsupportedOperationException("LottieAnimator does not support setStartDelay.");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.animation.ValueAnimator, android.animation.Animator
    public ValueAnimator setDuration(long j) {
        throw new UnsupportedOperationException("LottieAnimator does not support setDuration.");
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public void setInterpolator(TimeInterpolator timeInterpolator) {
        throw new UnsupportedOperationException("LottieAnimator does not support setInterpolator.");
    }

    @Override // android.animation.ValueAnimator
    public void addUpdateListener(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.HC.add(animatorUpdateListener);
    }

    @Override // android.animation.ValueAnimator
    public void removeUpdateListener(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.HC.remove(animatorUpdateListener);
    }

    @Override // android.animation.ValueAnimator
    public void removeAllUpdateListeners() {
        this.HC.clear();
    }

    @Override // android.animation.Animator
    public void addListener(Animator.AnimatorListener animatorListener) {
        this.HD.add(animatorListener);
    }

    @Override // android.animation.Animator
    public void removeListener(Animator.AnimatorListener animatorListener) {
        this.HD.remove(animatorListener);
    }

    @Override // android.animation.Animator
    public void removeAllListeners() {
        this.HD.clear();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void W(boolean z) {
        for (Animator.AnimatorListener animatorListener : this.HD) {
            if (Build.VERSION.SDK_INT >= 26) {
                animatorListener.onAnimationStart(this, z);
            } else {
                animatorListener.onAnimationStart(this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void kr() {
        for (Animator.AnimatorListener animatorListener : this.HD) {
            animatorListener.onAnimationRepeat(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void X(boolean z) {
        for (Animator.AnimatorListener animatorListener : this.HD) {
            if (Build.VERSION.SDK_INT >= 26) {
                animatorListener.onAnimationEnd(this, z);
            } else {
                animatorListener.onAnimationEnd(this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ks() {
        for (Animator.AnimatorListener animatorListener : this.HD) {
            animatorListener.onAnimationCancel(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void kt() {
        for (ValueAnimator.AnimatorUpdateListener animatorUpdateListener : this.HC) {
            animatorUpdateListener.onAnimationUpdate(this);
        }
    }
}
