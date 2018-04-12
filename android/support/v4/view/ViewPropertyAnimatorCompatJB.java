package android.support.v4.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
/* loaded from: classes2.dex */
class ViewPropertyAnimatorCompatJB {
    ViewPropertyAnimatorCompatJB() {
    }

    public static void withStartAction(View view2, Runnable runnable) {
        view2.animate().withStartAction(runnable);
    }

    public static void withEndAction(View view2, Runnable runnable) {
        view2.animate().withEndAction(runnable);
    }

    public static void withLayer(View view2) {
        view2.animate().withLayer();
    }

    public static void setListener(final View view2, final ViewPropertyAnimatorListener viewPropertyAnimatorListener) {
        if (viewPropertyAnimatorListener != null) {
            view2.animate().setListener(new AnimatorListenerAdapter() { // from class: android.support.v4.view.ViewPropertyAnimatorCompatJB.1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    ViewPropertyAnimatorListener.this.onAnimationCancel(view2);
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    ViewPropertyAnimatorListener.this.onAnimationEnd(view2);
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    ViewPropertyAnimatorListener.this.onAnimationStart(view2);
                }
            });
        } else {
            view2.animate().setListener(null);
        }
    }
}
