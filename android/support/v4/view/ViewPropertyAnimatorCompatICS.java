package android.support.v4.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.animation.Interpolator;
/* loaded from: classes2.dex */
class ViewPropertyAnimatorCompatICS {
    ViewPropertyAnimatorCompatICS() {
    }

    public static void setDuration(View view2, long j) {
        view2.animate().setDuration(j);
    }

    public static void alpha(View view2, float f) {
        view2.animate().alpha(f);
    }

    public static void translationX(View view2, float f) {
        view2.animate().translationX(f);
    }

    public static void translationY(View view2, float f) {
        view2.animate().translationY(f);
    }

    public static long getDuration(View view2) {
        return view2.animate().getDuration();
    }

    public static void setInterpolator(View view2, Interpolator interpolator) {
        view2.animate().setInterpolator(interpolator);
    }

    public static void setStartDelay(View view2, long j) {
        view2.animate().setStartDelay(j);
    }

    public static long getStartDelay(View view2) {
        return view2.animate().getStartDelay();
    }

    public static void alphaBy(View view2, float f) {
        view2.animate().alphaBy(f);
    }

    public static void rotation(View view2, float f) {
        view2.animate().rotation(f);
    }

    public static void rotationBy(View view2, float f) {
        view2.animate().rotationBy(f);
    }

    public static void rotationX(View view2, float f) {
        view2.animate().rotationX(f);
    }

    public static void rotationXBy(View view2, float f) {
        view2.animate().rotationXBy(f);
    }

    public static void rotationY(View view2, float f) {
        view2.animate().rotationY(f);
    }

    public static void rotationYBy(View view2, float f) {
        view2.animate().rotationYBy(f);
    }

    public static void scaleX(View view2, float f) {
        view2.animate().scaleX(f);
    }

    public static void scaleXBy(View view2, float f) {
        view2.animate().scaleXBy(f);
    }

    public static void scaleY(View view2, float f) {
        view2.animate().scaleY(f);
    }

    public static void scaleYBy(View view2, float f) {
        view2.animate().scaleYBy(f);
    }

    public static void cancel(View view2) {
        view2.animate().cancel();
    }

    public static void x(View view2, float f) {
        view2.animate().x(f);
    }

    public static void xBy(View view2, float f) {
        view2.animate().xBy(f);
    }

    public static void y(View view2, float f) {
        view2.animate().y(f);
    }

    public static void yBy(View view2, float f) {
        view2.animate().yBy(f);
    }

    public static void translationXBy(View view2, float f) {
        view2.animate().translationXBy(f);
    }

    public static void translationYBy(View view2, float f) {
        view2.animate().translationYBy(f);
    }

    public static void start(View view2) {
        view2.animate().start();
    }

    public static void setListener(final View view2, final ViewPropertyAnimatorListener viewPropertyAnimatorListener) {
        if (viewPropertyAnimatorListener != null) {
            view2.animate().setListener(new AnimatorListenerAdapter() { // from class: android.support.v4.view.ViewPropertyAnimatorCompatICS.1
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
