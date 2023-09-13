package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.res.TypedArrayUtils;
import androidx.core.view.ViewCompat;
import com.baidu.searchbox.crius.constants.CriusAttrConstants;
import java.util.Map;
/* loaded from: classes.dex */
public class ChangeBounds extends Transition {
    public boolean mReparent;
    public boolean mResizeClip;
    public int[] mTempLocation;
    public static final String PROPNAME_BOUNDS = "android:changeBounds:bounds";
    public static final String PROPNAME_CLIP = "android:changeBounds:clip";
    public static final String PROPNAME_PARENT = "android:changeBounds:parent";
    public static final String PROPNAME_WINDOW_X = "android:changeBounds:windowX";
    public static final String PROPNAME_WINDOW_Y = "android:changeBounds:windowY";
    public static final String[] sTransitionProperties = {PROPNAME_BOUNDS, PROPNAME_CLIP, PROPNAME_PARENT, PROPNAME_WINDOW_X, PROPNAME_WINDOW_Y};
    public static final Property<Drawable, PointF> DRAWABLE_ORIGIN_PROPERTY = new Property<Drawable, PointF>(PointF.class, "boundsOrigin") { // from class: androidx.transition.ChangeBounds.1
        public Rect mBounds = new Rect();

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.util.Property
        public void set(Drawable drawable, PointF pointF) {
            drawable.copyBounds(this.mBounds);
            this.mBounds.offsetTo(Math.round(pointF.x), Math.round(pointF.y));
            drawable.setBounds(this.mBounds);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.util.Property
        public PointF get(Drawable drawable) {
            drawable.copyBounds(this.mBounds);
            Rect rect = this.mBounds;
            return new PointF(rect.left, rect.top);
        }
    };
    public static final Property<ViewBounds, PointF> TOP_LEFT_PROPERTY = new Property<ViewBounds, PointF>(PointF.class, "topLeft") { // from class: androidx.transition.ChangeBounds.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.util.Property
        public PointF get(ViewBounds viewBounds) {
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.util.Property
        public void set(ViewBounds viewBounds, PointF pointF) {
            viewBounds.setTopLeft(pointF);
        }
    };
    public static final Property<ViewBounds, PointF> BOTTOM_RIGHT_PROPERTY = new Property<ViewBounds, PointF>(PointF.class, "bottomRight") { // from class: androidx.transition.ChangeBounds.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.util.Property
        public PointF get(ViewBounds viewBounds) {
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.util.Property
        public void set(ViewBounds viewBounds, PointF pointF) {
            viewBounds.setBottomRight(pointF);
        }
    };
    public static final Property<View, PointF> BOTTOM_RIGHT_ONLY_PROPERTY = new Property<View, PointF>(PointF.class, "bottomRight") { // from class: androidx.transition.ChangeBounds.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.util.Property
        public PointF get(View view2) {
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.util.Property
        public void set(View view2, PointF pointF) {
            ViewUtils.setLeftTopRightBottom(view2, view2.getLeft(), view2.getTop(), Math.round(pointF.x), Math.round(pointF.y));
        }
    };
    public static final Property<View, PointF> TOP_LEFT_ONLY_PROPERTY = new Property<View, PointF>(PointF.class, "topLeft") { // from class: androidx.transition.ChangeBounds.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.util.Property
        public PointF get(View view2) {
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.util.Property
        public void set(View view2, PointF pointF) {
            ViewUtils.setLeftTopRightBottom(view2, Math.round(pointF.x), Math.round(pointF.y), view2.getRight(), view2.getBottom());
        }
    };
    public static final Property<View, PointF> POSITION_PROPERTY = new Property<View, PointF>(PointF.class, CriusAttrConstants.POSITION) { // from class: androidx.transition.ChangeBounds.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.util.Property
        public PointF get(View view2) {
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.util.Property
        public void set(View view2, PointF pointF) {
            int round = Math.round(pointF.x);
            int round2 = Math.round(pointF.y);
            ViewUtils.setLeftTopRightBottom(view2, round, round2, view2.getWidth() + round, view2.getHeight() + round2);
        }
    };
    public static RectEvaluator sRectEvaluator = new RectEvaluator();

    /* loaded from: classes.dex */
    public static class ViewBounds {
        public int mBottom;
        public int mBottomRightCalls;
        public int mLeft;
        public int mRight;
        public int mTop;
        public int mTopLeftCalls;
        public View mView;

        public ViewBounds(View view2) {
            this.mView = view2;
        }

        public void setBottomRight(PointF pointF) {
            this.mRight = Math.round(pointF.x);
            this.mBottom = Math.round(pointF.y);
            int i = this.mBottomRightCalls + 1;
            this.mBottomRightCalls = i;
            if (this.mTopLeftCalls == i) {
                setLeftTopRightBottom();
            }
        }

        public void setTopLeft(PointF pointF) {
            this.mLeft = Math.round(pointF.x);
            this.mTop = Math.round(pointF.y);
            int i = this.mTopLeftCalls + 1;
            this.mTopLeftCalls = i;
            if (i == this.mBottomRightCalls) {
                setLeftTopRightBottom();
            }
        }

        private void setLeftTopRightBottom() {
            ViewUtils.setLeftTopRightBottom(this.mView, this.mLeft, this.mTop, this.mRight, this.mBottom);
            this.mTopLeftCalls = 0;
            this.mBottomRightCalls = 0;
        }
    }

    public ChangeBounds() {
        this.mTempLocation = new int[2];
        this.mResizeClip = false;
        this.mReparent = false;
    }

    public boolean getResizeClip() {
        return this.mResizeClip;
    }

    @Override // androidx.transition.Transition
    @Nullable
    public String[] getTransitionProperties() {
        return sTransitionProperties;
    }

    @SuppressLint({"RestrictedApi"})
    public ChangeBounds(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mTempLocation = new int[2];
        this.mResizeClip = false;
        this.mReparent = false;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, Styleable.CHANGE_BOUNDS);
        boolean namedBoolean = TypedArrayUtils.getNamedBoolean(obtainStyledAttributes, (XmlResourceParser) attributeSet, "resizeClip", 0, false);
        obtainStyledAttributes.recycle();
        setResizeClip(namedBoolean);
    }

    private boolean parentMatches(View view2, View view3) {
        if (!this.mReparent) {
            return true;
        }
        TransitionValues matchedTransitionValues = getMatchedTransitionValues(view2, true);
        if (matchedTransitionValues == null) {
            if (view2 == view3) {
                return true;
            }
        } else if (view3 == matchedTransitionValues.f1028view) {
            return true;
        }
        return false;
    }

    private void captureValues(TransitionValues transitionValues) {
        View view2 = transitionValues.f1028view;
        if (ViewCompat.isLaidOut(view2) || view2.getWidth() != 0 || view2.getHeight() != 0) {
            transitionValues.values.put(PROPNAME_BOUNDS, new Rect(view2.getLeft(), view2.getTop(), view2.getRight(), view2.getBottom()));
            transitionValues.values.put(PROPNAME_PARENT, transitionValues.f1028view.getParent());
            if (this.mReparent) {
                transitionValues.f1028view.getLocationInWindow(this.mTempLocation);
                transitionValues.values.put(PROPNAME_WINDOW_X, Integer.valueOf(this.mTempLocation[0]));
                transitionValues.values.put(PROPNAME_WINDOW_Y, Integer.valueOf(this.mTempLocation[1]));
            }
            if (this.mResizeClip) {
                transitionValues.values.put(PROPNAME_CLIP, ViewCompat.getClipBounds(view2));
            }
        }
    }

    @Override // androidx.transition.Transition
    public void captureEndValues(@NonNull TransitionValues transitionValues) {
        captureValues(transitionValues);
    }

    @Override // androidx.transition.Transition
    public void captureStartValues(@NonNull TransitionValues transitionValues) {
        captureValues(transitionValues);
    }

    public void setResizeClip(boolean z) {
        this.mResizeClip = z;
    }

    @Override // androidx.transition.Transition
    @Nullable
    public Animator createAnimator(@NonNull final ViewGroup viewGroup, @Nullable TransitionValues transitionValues, @Nullable TransitionValues transitionValues2) {
        int i;
        final View view2;
        ObjectAnimator ofPointF;
        int i2;
        Rect rect;
        Rect rect2;
        ObjectAnimator objectAnimator;
        Animator mergeAnimators;
        if (transitionValues != null && transitionValues2 != null) {
            Map<String, Object> map = transitionValues.values;
            Map<String, Object> map2 = transitionValues2.values;
            ViewGroup viewGroup2 = (ViewGroup) map.get(PROPNAME_PARENT);
            ViewGroup viewGroup3 = (ViewGroup) map2.get(PROPNAME_PARENT);
            if (viewGroup2 != null && viewGroup3 != null) {
                final View view3 = transitionValues2.f1028view;
                if (parentMatches(viewGroup2, viewGroup3)) {
                    Rect rect3 = (Rect) transitionValues.values.get(PROPNAME_BOUNDS);
                    Rect rect4 = (Rect) transitionValues2.values.get(PROPNAME_BOUNDS);
                    int i3 = rect3.left;
                    final int i4 = rect4.left;
                    int i5 = rect3.top;
                    final int i6 = rect4.top;
                    int i7 = rect3.right;
                    final int i8 = rect4.right;
                    int i9 = rect3.bottom;
                    final int i10 = rect4.bottom;
                    int i11 = i7 - i3;
                    int i12 = i9 - i5;
                    int i13 = i8 - i4;
                    int i14 = i10 - i6;
                    Rect rect5 = (Rect) transitionValues.values.get(PROPNAME_CLIP);
                    final Rect rect6 = (Rect) transitionValues2.values.get(PROPNAME_CLIP);
                    if ((i11 != 0 && i12 != 0) || (i13 != 0 && i14 != 0)) {
                        if (i3 == i4 && i5 == i6) {
                            i = 0;
                        } else {
                            i = 1;
                        }
                        if (i7 != i8 || i9 != i10) {
                            i++;
                        }
                    } else {
                        i = 0;
                    }
                    if ((rect5 != null && !rect5.equals(rect6)) || (rect5 == null && rect6 != null)) {
                        i++;
                    }
                    if (i > 0) {
                        if (!this.mResizeClip) {
                            view2 = view3;
                            ViewUtils.setLeftTopRightBottom(view2, i3, i5, i7, i9);
                            if (i == 2) {
                                if (i11 == i13 && i12 == i14) {
                                    mergeAnimators = ObjectAnimatorUtils.ofPointF(view2, POSITION_PROPERTY, getPathMotion().getPath(i3, i5, i4, i6));
                                } else {
                                    final ViewBounds viewBounds = new ViewBounds(view2);
                                    ObjectAnimator ofPointF2 = ObjectAnimatorUtils.ofPointF(viewBounds, TOP_LEFT_PROPERTY, getPathMotion().getPath(i3, i5, i4, i6));
                                    ObjectAnimator ofPointF3 = ObjectAnimatorUtils.ofPointF(viewBounds, BOTTOM_RIGHT_PROPERTY, getPathMotion().getPath(i7, i9, i8, i10));
                                    AnimatorSet animatorSet = new AnimatorSet();
                                    animatorSet.playTogether(ofPointF2, ofPointF3);
                                    animatorSet.addListener(new AnimatorListenerAdapter() { // from class: androidx.transition.ChangeBounds.7
                                        public ViewBounds mViewBounds;

                                        {
                                            this.mViewBounds = viewBounds;
                                        }
                                    });
                                    mergeAnimators = animatorSet;
                                }
                            } else if (i3 == i4 && i5 == i6) {
                                mergeAnimators = ObjectAnimatorUtils.ofPointF(view2, BOTTOM_RIGHT_ONLY_PROPERTY, getPathMotion().getPath(i7, i9, i8, i10));
                            } else {
                                mergeAnimators = ObjectAnimatorUtils.ofPointF(view2, TOP_LEFT_ONLY_PROPERTY, getPathMotion().getPath(i3, i5, i4, i6));
                            }
                        } else {
                            view2 = view3;
                            ViewUtils.setLeftTopRightBottom(view2, i3, i5, Math.max(i11, i13) + i3, Math.max(i12, i14) + i5);
                            if (i3 == i4 && i5 == i6) {
                                ofPointF = null;
                            } else {
                                ofPointF = ObjectAnimatorUtils.ofPointF(view2, POSITION_PROPERTY, getPathMotion().getPath(i3, i5, i4, i6));
                            }
                            if (rect5 == null) {
                                i2 = 0;
                                rect = new Rect(0, 0, i11, i12);
                            } else {
                                i2 = 0;
                                rect = rect5;
                            }
                            if (rect6 == null) {
                                rect2 = new Rect(i2, i2, i13, i14);
                            } else {
                                rect2 = rect6;
                            }
                            if (!rect.equals(rect2)) {
                                ViewCompat.setClipBounds(view2, rect);
                                RectEvaluator rectEvaluator = sRectEvaluator;
                                Object[] objArr = new Object[2];
                                objArr[i2] = rect;
                                objArr[1] = rect2;
                                ObjectAnimator ofObject = ObjectAnimator.ofObject(view2, "clipBounds", rectEvaluator, objArr);
                                ofObject.addListener(new AnimatorListenerAdapter() { // from class: androidx.transition.ChangeBounds.8
                                    public boolean mIsCanceled;

                                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                                    public void onAnimationCancel(Animator animator) {
                                        this.mIsCanceled = true;
                                    }

                                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                                    public void onAnimationEnd(Animator animator) {
                                        if (!this.mIsCanceled) {
                                            ViewCompat.setClipBounds(view2, rect6);
                                            ViewUtils.setLeftTopRightBottom(view2, i4, i6, i8, i10);
                                        }
                                    }
                                });
                                objectAnimator = ofObject;
                            } else {
                                objectAnimator = null;
                            }
                            mergeAnimators = TransitionUtils.mergeAnimators(ofPointF, objectAnimator);
                        }
                        if (view2.getParent() instanceof ViewGroup) {
                            final ViewGroup viewGroup4 = (ViewGroup) view2.getParent();
                            ViewGroupUtils.suppressLayout(viewGroup4, true);
                            addListener(new TransitionListenerAdapter() { // from class: androidx.transition.ChangeBounds.9
                                public boolean mCanceled = false;

                                @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
                                public void onTransitionCancel(@NonNull Transition transition) {
                                    ViewGroupUtils.suppressLayout(viewGroup4, false);
                                    this.mCanceled = true;
                                }

                                @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
                                public void onTransitionEnd(@NonNull Transition transition) {
                                    if (!this.mCanceled) {
                                        ViewGroupUtils.suppressLayout(viewGroup4, false);
                                    }
                                    transition.removeListener(this);
                                }

                                @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
                                public void onTransitionPause(@NonNull Transition transition) {
                                    ViewGroupUtils.suppressLayout(viewGroup4, false);
                                }

                                @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
                                public void onTransitionResume(@NonNull Transition transition) {
                                    ViewGroupUtils.suppressLayout(viewGroup4, true);
                                }
                            });
                        }
                        return mergeAnimators;
                    }
                    return null;
                }
                int intValue = ((Integer) transitionValues.values.get(PROPNAME_WINDOW_X)).intValue();
                int intValue2 = ((Integer) transitionValues.values.get(PROPNAME_WINDOW_Y)).intValue();
                int intValue3 = ((Integer) transitionValues2.values.get(PROPNAME_WINDOW_X)).intValue();
                int intValue4 = ((Integer) transitionValues2.values.get(PROPNAME_WINDOW_Y)).intValue();
                if (intValue == intValue3 && intValue2 == intValue4) {
                    return null;
                }
                viewGroup.getLocationInWindow(this.mTempLocation);
                Bitmap createBitmap = Bitmap.createBitmap(view3.getWidth(), view3.getHeight(), Bitmap.Config.ARGB_8888);
                view3.draw(new Canvas(createBitmap));
                final BitmapDrawable bitmapDrawable = new BitmapDrawable(createBitmap);
                final float transitionAlpha = ViewUtils.getTransitionAlpha(view3);
                ViewUtils.setTransitionAlpha(view3, 0.0f);
                ViewUtils.getOverlay(viewGroup).add(bitmapDrawable);
                PathMotion pathMotion = getPathMotion();
                int[] iArr = this.mTempLocation;
                ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(bitmapDrawable, PropertyValuesHolderUtils.ofPointF(DRAWABLE_ORIGIN_PROPERTY, pathMotion.getPath(intValue - iArr[0], intValue2 - iArr[1], intValue3 - iArr[0], intValue4 - iArr[1])));
                ofPropertyValuesHolder.addListener(new AnimatorListenerAdapter() { // from class: androidx.transition.ChangeBounds.10
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        ViewUtils.getOverlay(viewGroup).remove(bitmapDrawable);
                        ViewUtils.setTransitionAlpha(view3, transitionAlpha);
                    }
                });
                return ofPropertyValuesHolder;
            }
            return null;
        }
        return null;
    }
}
