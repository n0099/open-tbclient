package android.support.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.support.transition.TransitionPort;
import android.support.v4.view.ViewCompat;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
/* loaded from: classes2.dex */
class FadePort extends VisibilityPort {
    private static boolean DBG = false;
    public static final int IN = 1;
    private static final String LOG_TAG = "Fade";
    public static final int OUT = 2;
    private static final String PROPNAME_SCREEN_X = "android:fade:screenX";
    private static final String PROPNAME_SCREEN_Y = "android:fade:screenY";
    private int mFadingMode;

    public FadePort() {
        this(3);
    }

    public FadePort(int i) {
        this.mFadingMode = i;
    }

    private Animator createAnimation(View view2, float f, float f2, AnimatorListenerAdapter animatorListenerAdapter) {
        ObjectAnimator objectAnimator = null;
        if (f == f2) {
            if (animatorListenerAdapter != null) {
                animatorListenerAdapter.onAnimationEnd(null);
            }
        } else {
            objectAnimator = ObjectAnimator.ofFloat(view2, "alpha", f, f2);
            if (DBG) {
                Log.d(LOG_TAG, "Created animator " + objectAnimator);
            }
            if (animatorListenerAdapter != null) {
                objectAnimator.addListener(animatorListenerAdapter);
            }
        }
        return objectAnimator;
    }

    private void captureValues(TransitionValues transitionValues) {
        int[] iArr = new int[2];
        transitionValues.f2view.getLocationOnScreen(iArr);
        transitionValues.values.put(PROPNAME_SCREEN_X, Integer.valueOf(iArr[0]));
        transitionValues.values.put(PROPNAME_SCREEN_Y, Integer.valueOf(iArr[1]));
    }

    @Override // android.support.transition.VisibilityPort, android.support.transition.TransitionPort
    public void captureStartValues(TransitionValues transitionValues) {
        super.captureStartValues(transitionValues);
        captureValues(transitionValues);
    }

    @Override // android.support.transition.VisibilityPort
    public Animator onAppear(ViewGroup viewGroup, TransitionValues transitionValues, int i, TransitionValues transitionValues2, int i2) {
        if ((this.mFadingMode & 1) != 1 || transitionValues2 == null) {
            return null;
        }
        final View view2 = transitionValues2.f2view;
        if (DBG) {
            Log.d(LOG_TAG, "Fade.onAppear: startView, startVis, endView, endVis = " + (transitionValues != null ? transitionValues.f2view : null) + ", " + i + ", " + view2 + ", " + i2);
        }
        view2.setAlpha(0.0f);
        addListener(new TransitionPort.TransitionListenerAdapter() { // from class: android.support.transition.FadePort.1
            boolean mCanceled = false;
            float mPausedAlpha;

            @Override // android.support.transition.TransitionPort.TransitionListenerAdapter, android.support.transition.TransitionPort.TransitionListener
            public void onTransitionCancel(TransitionPort transitionPort) {
                view2.setAlpha(1.0f);
                this.mCanceled = true;
            }

            @Override // android.support.transition.TransitionPort.TransitionListenerAdapter, android.support.transition.TransitionPort.TransitionListener
            public void onTransitionEnd(TransitionPort transitionPort) {
                if (!this.mCanceled) {
                    view2.setAlpha(1.0f);
                }
            }

            @Override // android.support.transition.TransitionPort.TransitionListenerAdapter, android.support.transition.TransitionPort.TransitionListener
            public void onTransitionPause(TransitionPort transitionPort) {
                this.mPausedAlpha = view2.getAlpha();
                view2.setAlpha(1.0f);
            }

            @Override // android.support.transition.TransitionPort.TransitionListenerAdapter, android.support.transition.TransitionPort.TransitionListener
            public void onTransitionResume(TransitionPort transitionPort) {
                view2.setAlpha(this.mPausedAlpha);
            }
        });
        return createAnimation(view2, 0.0f, 1.0f, null);
    }

    @Override // android.support.transition.VisibilityPort
    public Animator onDisappear(final ViewGroup viewGroup, TransitionValues transitionValues, int i, TransitionValues transitionValues2, final int i2) {
        final View view2;
        final View view3;
        View view4;
        if ((this.mFadingMode & 2) != 2) {
            return null;
        }
        final View view5 = transitionValues != null ? transitionValues.f2view : null;
        View view6 = transitionValues2 != null ? transitionValues2.f2view : null;
        if (DBG) {
            Log.d(LOG_TAG, "Fade.onDisappear: startView, startVis, endView, endVis = " + view5 + ", " + i + ", " + view6 + ", " + i2);
        }
        if (view6 == null || view6.getParent() == null) {
            if (view6 != null) {
                view2 = null;
                view3 = view6;
                view5 = view6;
            } else {
                if (view5 != null) {
                    if (view5.getParent() == null) {
                        view2 = null;
                        view3 = view5;
                    } else if ((view5.getParent() instanceof View) && view5.getParent().getParent() == null) {
                        int id = ((View) view5.getParent()).getId();
                        if (id == -1 || viewGroup.findViewById(id) == null || !this.mCanRemoveViews) {
                            view4 = null;
                            view5 = null;
                        } else {
                            view4 = view5;
                        }
                        view2 = null;
                        view3 = view4;
                    }
                }
                view2 = null;
                view3 = null;
                view5 = null;
            }
        } else if (i2 == 4) {
            view2 = view6;
            view3 = null;
            view5 = view6;
        } else if (view5 == view6) {
            view2 = view6;
            view3 = null;
            view5 = view6;
        } else {
            view2 = null;
            view3 = view5;
        }
        if (view3 != null) {
            int intValue = ((Integer) transitionValues.values.get(PROPNAME_SCREEN_X)).intValue();
            int intValue2 = ((Integer) transitionValues.values.get(PROPNAME_SCREEN_Y)).intValue();
            int[] iArr = new int[2];
            viewGroup.getLocationOnScreen(iArr);
            ViewCompat.offsetLeftAndRight(view3, (intValue - iArr[0]) - view3.getLeft());
            ViewCompat.offsetTopAndBottom(view3, (intValue2 - iArr[1]) - view3.getTop());
            ViewGroupOverlay.createFrom(viewGroup).add(view3);
            return createAnimation(view5, 1.0f, 0.0f, new AnimatorListenerAdapter() { // from class: android.support.transition.FadePort.2
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    view5.setAlpha(1.0f);
                    if (view2 != null) {
                        view2.setVisibility(i2);
                    }
                    if (view3 != null) {
                        ViewGroupOverlay.createFrom(viewGroup).remove(view3);
                    }
                }
            });
        } else if (view2 != null) {
            view2.setVisibility(0);
            return createAnimation(view5, 1.0f, 0.0f, new AnimatorListenerAdapter() { // from class: android.support.transition.FadePort.3
                boolean mCanceled = false;
                float mPausedAlpha = -1.0f;

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    this.mCanceled = true;
                    if (this.mPausedAlpha >= 0.0f) {
                        view5.setAlpha(this.mPausedAlpha);
                    }
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.mCanceled) {
                        view5.setAlpha(1.0f);
                    }
                    if (view2 != null && !this.mCanceled) {
                        view2.setVisibility(i2);
                    }
                    if (view3 != null) {
                        ViewGroupOverlay.createFrom(viewGroup).add(view3);
                    }
                }
            });
        } else {
            return null;
        }
    }
}
