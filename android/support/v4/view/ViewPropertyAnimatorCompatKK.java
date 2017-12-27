package android.support.v4.view;

import android.animation.ValueAnimator;
import android.view.View;
/* loaded from: classes2.dex */
class ViewPropertyAnimatorCompatKK {
    public static void setUpdateListener(final View view, final ViewPropertyAnimatorUpdateListener viewPropertyAnimatorUpdateListener) {
        ValueAnimator.AnimatorUpdateListener animatorUpdateListener = null;
        if (viewPropertyAnimatorUpdateListener != null) {
            animatorUpdateListener = new ValueAnimator.AnimatorUpdateListener() { // from class: android.support.v4.view.ViewPropertyAnimatorCompatKK.1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    ViewPropertyAnimatorUpdateListener.this.onAnimationUpdate(view);
                }
            };
        }
        view.animate().setUpdateListener(animatorUpdateListener);
    }
}
