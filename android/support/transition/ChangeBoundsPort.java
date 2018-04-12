package android.support.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.support.transition.TransitionPort;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tieba.pb.interactionpopupwindow.CustomDialogData;
import java.util.Map;
/* loaded from: classes2.dex */
class ChangeBoundsPort extends TransitionPort {
    private static final String LOG_TAG = "ChangeBounds";
    private static final String PROPNAME_BOUNDS = "android:changeBounds:bounds";
    private static final String PROPNAME_PARENT = "android:changeBounds:parent";
    private static final String PROPNAME_WINDOW_X = "android:changeBounds:windowX";
    private static final String PROPNAME_WINDOW_Y = "android:changeBounds:windowY";
    private static final String[] sTransitionProperties = {PROPNAME_BOUNDS, PROPNAME_PARENT, PROPNAME_WINDOW_X, PROPNAME_WINDOW_Y};
    private static RectEvaluator sRectEvaluator = new RectEvaluator();
    int[] tempLocation = new int[2];
    boolean mResizeClip = false;
    boolean mReparent = false;

    @Override // android.support.transition.TransitionPort
    public String[] getTransitionProperties() {
        return sTransitionProperties;
    }

    public void setResizeClip(boolean z) {
        this.mResizeClip = z;
    }

    public void setReparent(boolean z) {
        this.mReparent = z;
    }

    private void captureValues(TransitionValues transitionValues) {
        View view2 = transitionValues.f2view;
        transitionValues.values.put(PROPNAME_BOUNDS, new Rect(view2.getLeft(), view2.getTop(), view2.getRight(), view2.getBottom()));
        transitionValues.values.put(PROPNAME_PARENT, transitionValues.f2view.getParent());
        transitionValues.f2view.getLocationInWindow(this.tempLocation);
        transitionValues.values.put(PROPNAME_WINDOW_X, Integer.valueOf(this.tempLocation[0]));
        transitionValues.values.put(PROPNAME_WINDOW_Y, Integer.valueOf(this.tempLocation[1]));
    }

    @Override // android.support.transition.TransitionPort
    public void captureStartValues(TransitionValues transitionValues) {
        captureValues(transitionValues);
    }

    @Override // android.support.transition.TransitionPort
    public void captureEndValues(TransitionValues transitionValues) {
        captureValues(transitionValues);
    }

    @Override // android.support.transition.TransitionPort
    public Animator createAnimator(final ViewGroup viewGroup, TransitionValues transitionValues, TransitionValues transitionValues2) {
        int i;
        int i2;
        int i3;
        int i4;
        if (transitionValues == null || transitionValues2 == null) {
            return null;
        }
        Map<String, Object> map = transitionValues.values;
        Map<String, Object> map2 = transitionValues2.values;
        ViewGroup viewGroup2 = (ViewGroup) map.get(PROPNAME_PARENT);
        ViewGroup viewGroup3 = (ViewGroup) map2.get(PROPNAME_PARENT);
        if (viewGroup2 == null || viewGroup3 == null) {
            return null;
        }
        final View view2 = transitionValues2.f2view;
        boolean z = viewGroup2 == viewGroup3 || viewGroup2.getId() == viewGroup3.getId();
        if (!this.mReparent || z) {
            Rect rect = (Rect) transitionValues.values.get(PROPNAME_BOUNDS);
            Rect rect2 = (Rect) transitionValues2.values.get(PROPNAME_BOUNDS);
            int i5 = rect.left;
            int i6 = rect2.left;
            int i7 = rect.top;
            int i8 = rect2.top;
            int i9 = rect.right;
            int i10 = rect2.right;
            int i11 = rect.bottom;
            int i12 = rect2.bottom;
            int i13 = i9 - i5;
            int i14 = i11 - i7;
            int i15 = i10 - i6;
            int i16 = i12 - i8;
            int i17 = 0;
            if (i13 != 0 && i14 != 0 && i15 != 0 && i16 != 0) {
                if (i5 != i6) {
                    i17 = 1;
                }
                if (i7 != i8) {
                    i17++;
                }
                if (i9 != i10) {
                    i17++;
                }
                if (i11 != i12) {
                    i17++;
                }
            }
            if (i17 > 0) {
                if (!this.mResizeClip) {
                    PropertyValuesHolder[] propertyValuesHolderArr = new PropertyValuesHolder[i17];
                    if (i5 != i6) {
                        view2.setLeft(i5);
                    }
                    if (i7 != i8) {
                        view2.setTop(i7);
                    }
                    if (i9 != i10) {
                        view2.setRight(i9);
                    }
                    if (i11 != i12) {
                        view2.setBottom(i11);
                    }
                    if (i5 == i6) {
                        i2 = 0;
                    } else {
                        i2 = 1;
                        propertyValuesHolderArr[0] = PropertyValuesHolder.ofInt(CustomDialogData.POS_LEFT, i5, i6);
                    }
                    if (i7 != i8) {
                        i3 = i2 + 1;
                        propertyValuesHolderArr[i2] = PropertyValuesHolder.ofInt("top", i7, i8);
                    } else {
                        i3 = i2;
                    }
                    if (i9 != i10) {
                        i4 = i3 + 1;
                        propertyValuesHolderArr[i3] = PropertyValuesHolder.ofInt("right", i9, i10);
                    } else {
                        i4 = i3;
                    }
                    if (i11 != i12) {
                        int i18 = i4 + 1;
                        propertyValuesHolderArr[i4] = PropertyValuesHolder.ofInt("bottom", i11, i12);
                    }
                    ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(view2, propertyValuesHolderArr);
                    if (view2.getParent() instanceof ViewGroup) {
                        ViewGroup viewGroup4 = (ViewGroup) view2.getParent();
                        addListener(new TransitionPort.TransitionListenerAdapter() { // from class: android.support.transition.ChangeBoundsPort.1
                            boolean mCanceled = false;

                            @Override // android.support.transition.TransitionPort.TransitionListenerAdapter, android.support.transition.TransitionPort.TransitionListener
                            public void onTransitionCancel(TransitionPort transitionPort) {
                                this.mCanceled = true;
                            }

                            @Override // android.support.transition.TransitionPort.TransitionListenerAdapter, android.support.transition.TransitionPort.TransitionListener
                            public void onTransitionEnd(TransitionPort transitionPort) {
                                if (!this.mCanceled) {
                                }
                            }

                            @Override // android.support.transition.TransitionPort.TransitionListenerAdapter, android.support.transition.TransitionPort.TransitionListener
                            public void onTransitionPause(TransitionPort transitionPort) {
                            }

                            @Override // android.support.transition.TransitionPort.TransitionListenerAdapter, android.support.transition.TransitionPort.TransitionListener
                            public void onTransitionResume(TransitionPort transitionPort) {
                            }
                        });
                    }
                    return ofPropertyValuesHolder;
                }
                if (i13 != i15) {
                    view2.setRight(Math.max(i13, i15) + i6);
                }
                if (i14 != i16) {
                    view2.setBottom(Math.max(i14, i16) + i8);
                }
                if (i5 != i6) {
                    view2.setTranslationX(i5 - i6);
                }
                if (i7 != i8) {
                    view2.setTranslationY(i7 - i8);
                }
                float f = i6 - i5;
                float f2 = i8 - i7;
                int i19 = i15 - i13;
                int i20 = i16 - i14;
                int i21 = 0;
                if (f != 0.0f) {
                    i21 = 1;
                }
                if (f2 != 0.0f) {
                    i21++;
                }
                if (i19 != 0 || i20 != 0) {
                    i21++;
                }
                PropertyValuesHolder[] propertyValuesHolderArr2 = new PropertyValuesHolder[i21];
                if (f == 0.0f) {
                    i = 0;
                } else {
                    i = 1;
                    propertyValuesHolderArr2[0] = PropertyValuesHolder.ofFloat("translationX", view2.getTranslationX(), 0.0f);
                }
                if (f2 != 0.0f) {
                    int i22 = i + 1;
                    propertyValuesHolderArr2[i] = PropertyValuesHolder.ofFloat("translationY", view2.getTranslationY(), 0.0f);
                }
                if (i19 != 0 || i20 != 0) {
                    new Rect(0, 0, i13, i14);
                    new Rect(0, 0, i15, i16);
                }
                ObjectAnimator ofPropertyValuesHolder2 = ObjectAnimator.ofPropertyValuesHolder(view2, propertyValuesHolderArr2);
                if (view2.getParent() instanceof ViewGroup) {
                    ViewGroup viewGroup5 = (ViewGroup) view2.getParent();
                    addListener(new TransitionPort.TransitionListenerAdapter() { // from class: android.support.transition.ChangeBoundsPort.2
                        boolean mCanceled = false;

                        @Override // android.support.transition.TransitionPort.TransitionListenerAdapter, android.support.transition.TransitionPort.TransitionListener
                        public void onTransitionCancel(TransitionPort transitionPort) {
                            this.mCanceled = true;
                        }

                        @Override // android.support.transition.TransitionPort.TransitionListenerAdapter, android.support.transition.TransitionPort.TransitionListener
                        public void onTransitionEnd(TransitionPort transitionPort) {
                            if (!this.mCanceled) {
                            }
                        }

                        @Override // android.support.transition.TransitionPort.TransitionListenerAdapter, android.support.transition.TransitionPort.TransitionListener
                        public void onTransitionPause(TransitionPort transitionPort) {
                        }

                        @Override // android.support.transition.TransitionPort.TransitionListenerAdapter, android.support.transition.TransitionPort.TransitionListener
                        public void onTransitionResume(TransitionPort transitionPort) {
                        }
                    });
                }
                ofPropertyValuesHolder2.addListener(new AnimatorListenerAdapter() { // from class: android.support.transition.ChangeBoundsPort.3
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                    }
                });
                return ofPropertyValuesHolder2;
            }
        } else {
            int intValue = ((Integer) transitionValues.values.get(PROPNAME_WINDOW_X)).intValue();
            int intValue2 = ((Integer) transitionValues.values.get(PROPNAME_WINDOW_Y)).intValue();
            int intValue3 = ((Integer) transitionValues2.values.get(PROPNAME_WINDOW_X)).intValue();
            int intValue4 = ((Integer) transitionValues2.values.get(PROPNAME_WINDOW_Y)).intValue();
            if (intValue != intValue3 || intValue2 != intValue4) {
                viewGroup.getLocationInWindow(this.tempLocation);
                Bitmap createBitmap = Bitmap.createBitmap(view2.getWidth(), view2.getHeight(), Bitmap.Config.ARGB_8888);
                view2.draw(new Canvas(createBitmap));
                final BitmapDrawable bitmapDrawable = new BitmapDrawable(createBitmap);
                view2.setVisibility(4);
                ViewOverlay.createFrom(viewGroup).add(bitmapDrawable);
                ObjectAnimator ofObject = ObjectAnimator.ofObject(bitmapDrawable, "bounds", sRectEvaluator, new Rect(intValue - this.tempLocation[0], intValue2 - this.tempLocation[1], (intValue - this.tempLocation[0]) + view2.getWidth(), (intValue2 - this.tempLocation[1]) + view2.getHeight()), new Rect(intValue3 - this.tempLocation[0], intValue4 - this.tempLocation[1], (intValue3 - this.tempLocation[0]) + view2.getWidth(), (intValue4 - this.tempLocation[1]) + view2.getHeight()));
                ofObject.addListener(new AnimatorListenerAdapter() { // from class: android.support.transition.ChangeBoundsPort.4
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        ViewOverlay.createFrom(viewGroup).remove(bitmapDrawable);
                        view2.setVisibility(0);
                    }
                });
                return ofObject;
            }
        }
        return null;
    }
}
