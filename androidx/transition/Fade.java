package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.core.content.res.TypedArrayUtils;
import androidx.core.view.ViewCompat;
/* loaded from: classes.dex */
public class Fade extends Visibility {
    public static final int IN = 1;
    public static final String LOG_TAG = "Fade";
    public static final int OUT = 2;
    public static final String PROPNAME_TRANSITION_ALPHA = "android:fade:transitionAlpha";

    /* loaded from: classes.dex */
    public static class FadeAnimatorListener extends AnimatorListenerAdapter {
        public boolean mLayerTypeChanged = false;
        public final View mView;

        public FadeAnimatorListener(View view2) {
            this.mView = view2;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            ViewUtils.setTransitionAlpha(this.mView, 1.0f);
            if (this.mLayerTypeChanged) {
                this.mView.setLayerType(0, null);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (ViewCompat.hasOverlappingRendering(this.mView) && this.mView.getLayerType() == 0) {
                this.mLayerTypeChanged = true;
                this.mView.setLayerType(2, null);
            }
        }
    }

    public Fade() {
    }

    public Fade(int i) {
        setMode(i);
    }

    @Override // androidx.transition.Visibility, androidx.transition.Transition
    public void captureStartValues(@NonNull TransitionValues transitionValues) {
        super.captureStartValues(transitionValues);
        transitionValues.values.put(PROPNAME_TRANSITION_ALPHA, Float.valueOf(ViewUtils.getTransitionAlpha(transitionValues.f1029view)));
    }

    @SuppressLint({"RestrictedApi"})
    public Fade(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, Styleable.FADE);
        setMode(TypedArrayUtils.getNamedInt(obtainStyledAttributes, (XmlResourceParser) attributeSet, "fadingMode", 0, getMode()));
        obtainStyledAttributes.recycle();
    }

    public static float getStartAlpha(TransitionValues transitionValues, float f) {
        Float f2;
        if (transitionValues != null && (f2 = (Float) transitionValues.values.get(PROPNAME_TRANSITION_ALPHA)) != null) {
            return f2.floatValue();
        }
        return f;
    }

    private Animator createAnimation(final View view2, float f, float f2) {
        if (f == f2) {
            return null;
        }
        ViewUtils.setTransitionAlpha(view2, f);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view2, ViewUtils.TRANSITION_ALPHA, f2);
        ofFloat.addListener(new FadeAnimatorListener(view2));
        addListener(new TransitionListenerAdapter() { // from class: androidx.transition.Fade.1
            @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
            public void onTransitionEnd(@NonNull Transition transition) {
                ViewUtils.setTransitionAlpha(view2, 1.0f);
                ViewUtils.clearNonTransitionAlpha(view2);
                transition.removeListener(this);
            }
        });
        return ofFloat;
    }

    @Override // androidx.transition.Visibility
    public Animator onAppear(ViewGroup viewGroup, View view2, TransitionValues transitionValues, TransitionValues transitionValues2) {
        float f = 0.0f;
        float startAlpha = getStartAlpha(transitionValues, 0.0f);
        if (startAlpha != 1.0f) {
            f = startAlpha;
        }
        return createAnimation(view2, f, 1.0f);
    }

    @Override // androidx.transition.Visibility
    public Animator onDisappear(ViewGroup viewGroup, View view2, TransitionValues transitionValues, TransitionValues transitionValues2) {
        ViewUtils.saveNonTransitionAlpha(view2);
        return createAnimation(view2, getStartAlpha(transitionValues, 1.0f), 0.0f);
    }
}
