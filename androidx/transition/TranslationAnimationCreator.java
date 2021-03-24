package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TimeInterpolator;
import android.view.View;
/* loaded from: classes.dex */
public class TranslationAnimationCreator {

    /* loaded from: classes.dex */
    public static class TransitionPositionListener extends AnimatorListenerAdapter {
        public final View mMovingView;
        public float mPausedX;
        public float mPausedY;
        public final int mStartX;
        public final int mStartY;
        public final float mTerminalX;
        public final float mTerminalY;
        public int[] mTransitionPosition;
        public final View mViewInHierarchy;

        public TransitionPositionListener(View view, View view2, int i, int i2, float f2, float f3) {
            this.mMovingView = view;
            this.mViewInHierarchy = view2;
            this.mStartX = i - Math.round(view.getTranslationX());
            this.mStartY = i2 - Math.round(this.mMovingView.getTranslationY());
            this.mTerminalX = f2;
            this.mTerminalY = f3;
            int[] iArr = (int[]) this.mViewInHierarchy.getTag(R.id.transition_position);
            this.mTransitionPosition = iArr;
            if (iArr != null) {
                this.mViewInHierarchy.setTag(R.id.transition_position, null);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            if (this.mTransitionPosition == null) {
                this.mTransitionPosition = new int[2];
            }
            this.mTransitionPosition[0] = Math.round(this.mStartX + this.mMovingView.getTranslationX());
            this.mTransitionPosition[1] = Math.round(this.mStartY + this.mMovingView.getTranslationY());
            this.mViewInHierarchy.setTag(R.id.transition_position, this.mTransitionPosition);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.mMovingView.setTranslationX(this.mTerminalX);
            this.mMovingView.setTranslationY(this.mTerminalY);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
        public void onAnimationPause(Animator animator) {
            this.mPausedX = this.mMovingView.getTranslationX();
            this.mPausedY = this.mMovingView.getTranslationY();
            this.mMovingView.setTranslationX(this.mTerminalX);
            this.mMovingView.setTranslationY(this.mTerminalY);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
        public void onAnimationResume(Animator animator) {
            this.mMovingView.setTranslationX(this.mPausedX);
            this.mMovingView.setTranslationY(this.mPausedY);
        }
    }

    public static Animator createAnimation(View view, TransitionValues transitionValues, int i, int i2, float f2, float f3, float f4, float f5, TimeInterpolator timeInterpolator) {
        float f6;
        float f7;
        float translationX = view.getTranslationX();
        float translationY = view.getTranslationY();
        int[] iArr = (int[]) transitionValues.view.getTag(R.id.transition_position);
        if (iArr != null) {
            f6 = (iArr[0] - i) + translationX;
            f7 = (iArr[1] - i2) + translationY;
        } else {
            f6 = f2;
            f7 = f3;
        }
        int round = i + Math.round(f6 - translationX);
        int round2 = i2 + Math.round(f7 - translationY);
        view.setTranslationX(f6);
        view.setTranslationY(f7);
        if (f6 == f4 && f7 == f5) {
            return null;
        }
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(view, PropertyValuesHolder.ofFloat(View.TRANSLATION_X, f6, f4), PropertyValuesHolder.ofFloat(View.TRANSLATION_Y, f7, f5));
        TransitionPositionListener transitionPositionListener = new TransitionPositionListener(view, transitionValues.view, round, round2, translationX, translationY);
        ofPropertyValuesHolder.addListener(transitionPositionListener);
        AnimatorUtils.addPauseListener(ofPropertyValuesHolder, transitionPositionListener);
        ofPropertyValuesHolder.setInterpolator(timeInterpolator);
        return ofPropertyValuesHolder;
    }
}
