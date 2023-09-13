package androidx.transition;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.core.content.res.TypedArrayUtils;
import androidx.core.view.ViewCompat;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import org.xmlpull.v1.XmlPullParser;
/* loaded from: classes.dex */
public class Slide extends Visibility {
    public static final String PROPNAME_SCREEN_POSITION = "android:slide:screenPosition";
    public CalculateSlide mSlideCalculator;
    public int mSlideEdge;
    public static final TimeInterpolator sDecelerate = new DecelerateInterpolator();
    public static final TimeInterpolator sAccelerate = new AccelerateInterpolator();
    public static final CalculateSlide sCalculateLeft = new CalculateSlideHorizontal() { // from class: androidx.transition.Slide.1
        @Override // androidx.transition.Slide.CalculateSlide
        public float getGoneX(ViewGroup viewGroup, View view2) {
            return view2.getTranslationX() - viewGroup.getWidth();
        }
    };
    public static final CalculateSlide sCalculateStart = new CalculateSlideHorizontal() { // from class: androidx.transition.Slide.2
        @Override // androidx.transition.Slide.CalculateSlide
        public float getGoneX(ViewGroup viewGroup, View view2) {
            boolean z = true;
            if (ViewCompat.getLayoutDirection(viewGroup) != 1) {
                z = false;
            }
            if (z) {
                return view2.getTranslationX() + viewGroup.getWidth();
            }
            return view2.getTranslationX() - viewGroup.getWidth();
        }
    };
    public static final CalculateSlide sCalculateTop = new CalculateSlideVertical() { // from class: androidx.transition.Slide.3
        @Override // androidx.transition.Slide.CalculateSlide
        public float getGoneY(ViewGroup viewGroup, View view2) {
            return view2.getTranslationY() - viewGroup.getHeight();
        }
    };
    public static final CalculateSlide sCalculateRight = new CalculateSlideHorizontal() { // from class: androidx.transition.Slide.4
        @Override // androidx.transition.Slide.CalculateSlide
        public float getGoneX(ViewGroup viewGroup, View view2) {
            return view2.getTranslationX() + viewGroup.getWidth();
        }
    };
    public static final CalculateSlide sCalculateEnd = new CalculateSlideHorizontal() { // from class: androidx.transition.Slide.5
        @Override // androidx.transition.Slide.CalculateSlide
        public float getGoneX(ViewGroup viewGroup, View view2) {
            boolean z = true;
            if (ViewCompat.getLayoutDirection(viewGroup) != 1) {
                z = false;
            }
            if (z) {
                return view2.getTranslationX() - viewGroup.getWidth();
            }
            return view2.getTranslationX() + viewGroup.getWidth();
        }
    };
    public static final CalculateSlide sCalculateBottom = new CalculateSlideVertical() { // from class: androidx.transition.Slide.6
        @Override // androidx.transition.Slide.CalculateSlide
        public float getGoneY(ViewGroup viewGroup, View view2) {
            return view2.getTranslationY() + viewGroup.getHeight();
        }
    };

    /* loaded from: classes.dex */
    public interface CalculateSlide {
        float getGoneX(ViewGroup viewGroup, View view2);

        float getGoneY(ViewGroup viewGroup, View view2);
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    /* loaded from: classes.dex */
    public @interface GravityFlag {
    }

    /* loaded from: classes.dex */
    public static abstract class CalculateSlideHorizontal implements CalculateSlide {
        public CalculateSlideHorizontal() {
        }

        @Override // androidx.transition.Slide.CalculateSlide
        public float getGoneY(ViewGroup viewGroup, View view2) {
            return view2.getTranslationY();
        }
    }

    /* loaded from: classes.dex */
    public static abstract class CalculateSlideVertical implements CalculateSlide {
        public CalculateSlideVertical() {
        }

        @Override // androidx.transition.Slide.CalculateSlide
        public float getGoneX(ViewGroup viewGroup, View view2) {
            return view2.getTranslationX();
        }
    }

    public Slide() {
        this.mSlideCalculator = sCalculateBottom;
        this.mSlideEdge = 80;
        setSlideEdge(80);
    }

    public int getSlideEdge() {
        return this.mSlideEdge;
    }

    public Slide(int i) {
        this.mSlideCalculator = sCalculateBottom;
        this.mSlideEdge = 80;
        setSlideEdge(i);
    }

    private void captureValues(TransitionValues transitionValues) {
        int[] iArr = new int[2];
        transitionValues.f1028view.getLocationOnScreen(iArr);
        transitionValues.values.put(PROPNAME_SCREEN_POSITION, iArr);
    }

    @Override // androidx.transition.Visibility, androidx.transition.Transition
    public void captureEndValues(@NonNull TransitionValues transitionValues) {
        super.captureEndValues(transitionValues);
        captureValues(transitionValues);
    }

    @Override // androidx.transition.Visibility, androidx.transition.Transition
    public void captureStartValues(@NonNull TransitionValues transitionValues) {
        super.captureStartValues(transitionValues);
        captureValues(transitionValues);
    }

    @SuppressLint({"RestrictedApi"})
    public Slide(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSlideCalculator = sCalculateBottom;
        this.mSlideEdge = 80;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, Styleable.SLIDE);
        int namedInt = TypedArrayUtils.getNamedInt(obtainStyledAttributes, (XmlPullParser) attributeSet, "slideEdge", 0, 80);
        obtainStyledAttributes.recycle();
        setSlideEdge(namedInt);
    }

    @Override // androidx.transition.Visibility
    public Animator onAppear(ViewGroup viewGroup, View view2, TransitionValues transitionValues, TransitionValues transitionValues2) {
        if (transitionValues2 == null) {
            return null;
        }
        int[] iArr = (int[]) transitionValues2.values.get(PROPNAME_SCREEN_POSITION);
        float translationX = view2.getTranslationX();
        float translationY = view2.getTranslationY();
        return TranslationAnimationCreator.createAnimation(view2, transitionValues2, iArr[0], iArr[1], this.mSlideCalculator.getGoneX(viewGroup, view2), this.mSlideCalculator.getGoneY(viewGroup, view2), translationX, translationY, sDecelerate, this);
    }

    @Override // androidx.transition.Visibility
    public Animator onDisappear(ViewGroup viewGroup, View view2, TransitionValues transitionValues, TransitionValues transitionValues2) {
        if (transitionValues == null) {
            return null;
        }
        int[] iArr = (int[]) transitionValues.values.get(PROPNAME_SCREEN_POSITION);
        return TranslationAnimationCreator.createAnimation(view2, transitionValues, iArr[0], iArr[1], view2.getTranslationX(), view2.getTranslationY(), this.mSlideCalculator.getGoneX(viewGroup, view2), this.mSlideCalculator.getGoneY(viewGroup, view2), sAccelerate, this);
    }

    public void setSlideEdge(int i) {
        if (i != 3) {
            if (i != 5) {
                if (i != 48) {
                    if (i != 80) {
                        if (i != 8388611) {
                            if (i == 8388613) {
                                this.mSlideCalculator = sCalculateEnd;
                            } else {
                                throw new IllegalArgumentException("Invalid slide direction");
                            }
                        } else {
                            this.mSlideCalculator = sCalculateStart;
                        }
                    } else {
                        this.mSlideCalculator = sCalculateBottom;
                    }
                } else {
                    this.mSlideCalculator = sCalculateTop;
                }
            } else {
                this.mSlideCalculator = sCalculateRight;
            }
        } else {
            this.mSlideCalculator = sCalculateLeft;
        }
        this.mSlideEdge = i;
        SidePropagation sidePropagation = new SidePropagation();
        sidePropagation.setSide(i);
        setPropagation(sidePropagation);
    }
}
