package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.content.res.TypedArrayUtils;
import androidx.transition.AnimatorUtils;
import androidx.transition.Transition;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes.dex */
public abstract class Visibility extends Transition {
    public static final int MODE_IN = 1;
    public static final int MODE_OUT = 2;
    public static final String PROPNAME_SCREEN_LOCATION = "android:visibility:screenLocation";
    public int mMode;
    public static final String PROPNAME_VISIBILITY = "android:visibility:visibility";
    public static final String PROPNAME_PARENT = "android:visibility:parent";
    public static final String[] sTransitionProperties = {PROPNAME_VISIBILITY, PROPNAME_PARENT};

    @SuppressLint({"UniqueConstants"})
    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    /* loaded from: classes.dex */
    public @interface Mode {
    }

    /* loaded from: classes.dex */
    public static class VisibilityInfo {
        public ViewGroup mEndParent;
        public int mEndVisibility;
        public boolean mFadeIn;
        public ViewGroup mStartParent;
        public int mStartVisibility;
        public boolean mVisibilityChange;
    }

    public Animator onAppear(ViewGroup viewGroup, View view2, TransitionValues transitionValues, TransitionValues transitionValues2) {
        return null;
    }

    public Animator onDisappear(ViewGroup viewGroup, View view2, TransitionValues transitionValues, TransitionValues transitionValues2) {
        return null;
    }

    /* loaded from: classes.dex */
    public static class DisappearListener extends AnimatorListenerAdapter implements Transition.TransitionListener, AnimatorUtils.AnimatorPauseListenerCompat {
        public boolean mCanceled = false;
        public final int mFinalVisibility;
        public boolean mLayoutSuppressed;
        public final ViewGroup mParent;
        public final boolean mSuppressLayout;
        public final View mView;

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }

        @Override // androidx.transition.Transition.TransitionListener
        public void onTransitionCancel(@NonNull Transition transition) {
        }

        @Override // androidx.transition.Transition.TransitionListener
        public void onTransitionStart(@NonNull Transition transition) {
        }

        public DisappearListener(View view2, int i, boolean z) {
            this.mView = view2;
            this.mFinalVisibility = i;
            this.mParent = (ViewGroup) view2.getParent();
            this.mSuppressLayout = z;
            suppressLayout(true);
        }

        private void hideViewWhenNotCanceled() {
            if (!this.mCanceled) {
                ViewUtils.setTransitionVisibility(this.mView, this.mFinalVisibility);
                ViewGroup viewGroup = this.mParent;
                if (viewGroup != null) {
                    viewGroup.invalidate();
                }
            }
            suppressLayout(false);
        }

        private void suppressLayout(boolean z) {
            ViewGroup viewGroup;
            if (this.mSuppressLayout && this.mLayoutSuppressed != z && (viewGroup = this.mParent) != null) {
                this.mLayoutSuppressed = z;
                ViewGroupUtils.suppressLayout(viewGroup, z);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.mCanceled = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            hideViewWhenNotCanceled();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener, androidx.transition.AnimatorUtils.AnimatorPauseListenerCompat
        public void onAnimationPause(Animator animator) {
            if (!this.mCanceled) {
                ViewUtils.setTransitionVisibility(this.mView, this.mFinalVisibility);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener, androidx.transition.AnimatorUtils.AnimatorPauseListenerCompat
        public void onAnimationResume(Animator animator) {
            if (!this.mCanceled) {
                ViewUtils.setTransitionVisibility(this.mView, 0);
            }
        }

        @Override // androidx.transition.Transition.TransitionListener
        public void onTransitionEnd(@NonNull Transition transition) {
            hideViewWhenNotCanceled();
            transition.removeListener(this);
        }

        @Override // androidx.transition.Transition.TransitionListener
        public void onTransitionPause(@NonNull Transition transition) {
            suppressLayout(false);
        }

        @Override // androidx.transition.Transition.TransitionListener
        public void onTransitionResume(@NonNull Transition transition) {
            suppressLayout(true);
        }
    }

    public Visibility() {
        this.mMode = 3;
    }

    public int getMode() {
        return this.mMode;
    }

    @Override // androidx.transition.Transition
    @Nullable
    public String[] getTransitionProperties() {
        return sTransitionProperties;
    }

    @SuppressLint({"RestrictedApi"})
    public Visibility(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mMode = 3;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, Styleable.VISIBILITY_TRANSITION);
        int namedInt = TypedArrayUtils.getNamedInt(obtainStyledAttributes, (XmlResourceParser) attributeSet, "transitionVisibilityMode", 0, 0);
        obtainStyledAttributes.recycle();
        if (namedInt != 0) {
            setMode(namedInt);
        }
    }

    @Override // androidx.transition.Transition
    public boolean isTransitionRequired(TransitionValues transitionValues, TransitionValues transitionValues2) {
        if (transitionValues == null && transitionValues2 == null) {
            return false;
        }
        if (transitionValues != null && transitionValues2 != null && transitionValues2.values.containsKey(PROPNAME_VISIBILITY) != transitionValues.values.containsKey(PROPNAME_VISIBILITY)) {
            return false;
        }
        VisibilityInfo visibilityChangeInfo = getVisibilityChangeInfo(transitionValues, transitionValues2);
        if (!visibilityChangeInfo.mVisibilityChange) {
            return false;
        }
        if (visibilityChangeInfo.mStartVisibility != 0 && visibilityChangeInfo.mEndVisibility != 0) {
            return false;
        }
        return true;
    }

    private void captureValues(TransitionValues transitionValues) {
        transitionValues.values.put(PROPNAME_VISIBILITY, Integer.valueOf(transitionValues.f1028view.getVisibility()));
        transitionValues.values.put(PROPNAME_PARENT, transitionValues.f1028view.getParent());
        int[] iArr = new int[2];
        transitionValues.f1028view.getLocationOnScreen(iArr);
        transitionValues.values.put(PROPNAME_SCREEN_LOCATION, iArr);
    }

    @Override // androidx.transition.Transition
    public void captureEndValues(@NonNull TransitionValues transitionValues) {
        captureValues(transitionValues);
    }

    @Override // androidx.transition.Transition
    public void captureStartValues(@NonNull TransitionValues transitionValues) {
        captureValues(transitionValues);
    }

    public boolean isVisible(TransitionValues transitionValues) {
        if (transitionValues == null) {
            return false;
        }
        int intValue = ((Integer) transitionValues.values.get(PROPNAME_VISIBILITY)).intValue();
        View view2 = (View) transitionValues.values.get(PROPNAME_PARENT);
        if (intValue != 0 || view2 == null) {
            return false;
        }
        return true;
    }

    public void setMode(int i) {
        if ((i & (-4)) == 0) {
            this.mMode = i;
            return;
        }
        throw new IllegalArgumentException("Only MODE_IN and MODE_OUT flags are allowed");
    }

    private VisibilityInfo getVisibilityChangeInfo(TransitionValues transitionValues, TransitionValues transitionValues2) {
        VisibilityInfo visibilityInfo = new VisibilityInfo();
        visibilityInfo.mVisibilityChange = false;
        visibilityInfo.mFadeIn = false;
        if (transitionValues != null && transitionValues.values.containsKey(PROPNAME_VISIBILITY)) {
            visibilityInfo.mStartVisibility = ((Integer) transitionValues.values.get(PROPNAME_VISIBILITY)).intValue();
            visibilityInfo.mStartParent = (ViewGroup) transitionValues.values.get(PROPNAME_PARENT);
        } else {
            visibilityInfo.mStartVisibility = -1;
            visibilityInfo.mStartParent = null;
        }
        if (transitionValues2 != null && transitionValues2.values.containsKey(PROPNAME_VISIBILITY)) {
            visibilityInfo.mEndVisibility = ((Integer) transitionValues2.values.get(PROPNAME_VISIBILITY)).intValue();
            visibilityInfo.mEndParent = (ViewGroup) transitionValues2.values.get(PROPNAME_PARENT);
        } else {
            visibilityInfo.mEndVisibility = -1;
            visibilityInfo.mEndParent = null;
        }
        if (transitionValues != null && transitionValues2 != null) {
            if (visibilityInfo.mStartVisibility == visibilityInfo.mEndVisibility && visibilityInfo.mStartParent == visibilityInfo.mEndParent) {
                return visibilityInfo;
            }
            int i = visibilityInfo.mStartVisibility;
            int i2 = visibilityInfo.mEndVisibility;
            if (i != i2) {
                if (i == 0) {
                    visibilityInfo.mFadeIn = false;
                    visibilityInfo.mVisibilityChange = true;
                } else if (i2 == 0) {
                    visibilityInfo.mFadeIn = true;
                    visibilityInfo.mVisibilityChange = true;
                }
            } else if (visibilityInfo.mEndParent == null) {
                visibilityInfo.mFadeIn = false;
                visibilityInfo.mVisibilityChange = true;
            } else if (visibilityInfo.mStartParent == null) {
                visibilityInfo.mFadeIn = true;
                visibilityInfo.mVisibilityChange = true;
            }
        } else if (transitionValues == null && visibilityInfo.mEndVisibility == 0) {
            visibilityInfo.mFadeIn = true;
            visibilityInfo.mVisibilityChange = true;
        } else if (transitionValues2 == null && visibilityInfo.mStartVisibility == 0) {
            visibilityInfo.mFadeIn = false;
            visibilityInfo.mVisibilityChange = true;
        }
        return visibilityInfo;
    }

    @Override // androidx.transition.Transition
    @Nullable
    public Animator createAnimator(@NonNull ViewGroup viewGroup, @Nullable TransitionValues transitionValues, @Nullable TransitionValues transitionValues2) {
        VisibilityInfo visibilityChangeInfo = getVisibilityChangeInfo(transitionValues, transitionValues2);
        if (visibilityChangeInfo.mVisibilityChange) {
            if (visibilityChangeInfo.mStartParent != null || visibilityChangeInfo.mEndParent != null) {
                if (visibilityChangeInfo.mFadeIn) {
                    return onAppear(viewGroup, transitionValues, visibilityChangeInfo.mStartVisibility, transitionValues2, visibilityChangeInfo.mEndVisibility);
                }
                return onDisappear(viewGroup, transitionValues, visibilityChangeInfo.mStartVisibility, transitionValues2, visibilityChangeInfo.mEndVisibility);
            }
            return null;
        }
        return null;
    }

    public Animator onAppear(ViewGroup viewGroup, TransitionValues transitionValues, int i, TransitionValues transitionValues2, int i2) {
        if ((this.mMode & 1) != 1 || transitionValues2 == null) {
            return null;
        }
        if (transitionValues == null) {
            View view2 = (View) transitionValues2.f1028view.getParent();
            if (getVisibilityChangeInfo(getMatchedTransitionValues(view2, false), getTransitionValues(view2, false)).mVisibilityChange) {
                return null;
            }
        }
        return onAppear(viewGroup, transitionValues2.f1028view, transitionValues, transitionValues2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:42:0x008a, code lost:
        if (r17.mCanRemoveViews != false) goto L52;
     */
    /* JADX WARN: Removed duplicated region for block: B:27:0x004b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Animator onDisappear(final ViewGroup viewGroup, TransitionValues transitionValues, int i, TransitionValues transitionValues2, int i2) {
        View view2;
        View view3;
        boolean z;
        boolean z2;
        View view4;
        if ((this.mMode & 2) != 2 || transitionValues == null) {
            return null;
        }
        final View view5 = transitionValues.f1028view;
        if (transitionValues2 != null) {
            view2 = transitionValues2.f1028view;
        } else {
            view2 = null;
        }
        final View view6 = (View) view5.getTag(com.baidu.tieba.R.id.obfuscated_res_0x7f09211f);
        if (view6 != null) {
            view4 = null;
            z2 = true;
        } else if (view2 != null && view2.getParent() != null) {
            if (i2 == 4 || view5 == view2) {
                view3 = view2;
                z = false;
                view2 = null;
                if (z) {
                }
                z2 = false;
                View view7 = view3;
                view6 = view2;
                view4 = view7;
            }
            view2 = null;
            view3 = null;
            z = true;
            if (z) {
            }
            z2 = false;
            View view72 = view3;
            view6 = view2;
            view4 = view72;
        } else {
            if (view2 != null) {
                view3 = null;
                z = false;
                if (z) {
                    if (view5.getParent() != null) {
                        if (view5.getParent() instanceof View) {
                            View view8 = (View) view5.getParent();
                            if (!getVisibilityChangeInfo(getTransitionValues(view8, true), getMatchedTransitionValues(view8, true)).mVisibilityChange) {
                                view2 = TransitionUtils.copyViewImage(viewGroup, view5, view8);
                            } else {
                                int id = view8.getId();
                                if (view8.getParent() == null) {
                                    if (id != -1) {
                                        if (viewGroup.findViewById(id) != null) {
                                        }
                                    }
                                }
                            }
                        }
                    }
                    view4 = view3;
                    z2 = false;
                    view6 = view5;
                }
                z2 = false;
                View view722 = view3;
                view6 = view2;
                view4 = view722;
            }
            view2 = null;
            view3 = null;
            z = true;
            if (z) {
            }
            z2 = false;
            View view7222 = view3;
            view6 = view2;
            view4 = view7222;
        }
        if (view6 != null) {
            if (!z2) {
                int[] iArr = (int[]) transitionValues.values.get(PROPNAME_SCREEN_LOCATION);
                int i3 = iArr[0];
                int i4 = iArr[1];
                int[] iArr2 = new int[2];
                viewGroup.getLocationOnScreen(iArr2);
                view6.offsetLeftAndRight((i3 - iArr2[0]) - view6.getLeft());
                view6.offsetTopAndBottom((i4 - iArr2[1]) - view6.getTop());
                ViewGroupUtils.getOverlay(viewGroup).add(view6);
            }
            Animator onDisappear = onDisappear(viewGroup, view6, transitionValues, transitionValues2);
            if (!z2) {
                if (onDisappear == null) {
                    ViewGroupUtils.getOverlay(viewGroup).remove(view6);
                } else {
                    view5.setTag(com.baidu.tieba.R.id.obfuscated_res_0x7f09211f, view6);
                    addListener(new TransitionListenerAdapter() { // from class: androidx.transition.Visibility.1
                        @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
                        public void onTransitionEnd(@NonNull Transition transition) {
                            view5.setTag(com.baidu.tieba.R.id.obfuscated_res_0x7f09211f, null);
                            ViewGroupUtils.getOverlay(viewGroup).remove(view6);
                            transition.removeListener(this);
                        }

                        @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
                        public void onTransitionPause(@NonNull Transition transition) {
                            ViewGroupUtils.getOverlay(viewGroup).remove(view6);
                        }

                        @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
                        public void onTransitionResume(@NonNull Transition transition) {
                            if (view6.getParent() == null) {
                                ViewGroupUtils.getOverlay(viewGroup).add(view6);
                            } else {
                                Visibility.this.cancel();
                            }
                        }
                    });
                }
            }
            return onDisappear;
        } else if (view4 == null) {
            return null;
        } else {
            int visibility = view4.getVisibility();
            ViewUtils.setTransitionVisibility(view4, 0);
            Animator onDisappear2 = onDisappear(viewGroup, view4, transitionValues, transitionValues2);
            if (onDisappear2 != null) {
                DisappearListener disappearListener = new DisappearListener(view4, i2, true);
                onDisappear2.addListener(disappearListener);
                AnimatorUtils.addPauseListener(onDisappear2, disappearListener);
                addListener(disappearListener);
            } else {
                ViewUtils.setTransitionVisibility(view4, visibility);
            }
            return onDisappear2;
        }
    }
}
