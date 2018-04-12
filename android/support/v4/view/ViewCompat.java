package android.support.v4.view;

import android.content.res.ColorStateList;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.FloatRange;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;
import android.support.v4.os.BuildCompat;
import android.support.v4.view.ViewCompatLollipop;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.view.accessibility.AccessibilityNodeProviderCompat;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.WeakHashMap;
/* loaded from: classes2.dex */
public class ViewCompat {
    public static final int ACCESSIBILITY_LIVE_REGION_ASSERTIVE = 2;
    public static final int ACCESSIBILITY_LIVE_REGION_NONE = 0;
    public static final int ACCESSIBILITY_LIVE_REGION_POLITE = 1;
    private static final long FAKE_FRAME_TIME = 10;
    static final ViewCompatImpl IMPL;
    public static final int IMPORTANT_FOR_ACCESSIBILITY_AUTO = 0;
    public static final int IMPORTANT_FOR_ACCESSIBILITY_NO = 2;
    public static final int IMPORTANT_FOR_ACCESSIBILITY_NO_HIDE_DESCENDANTS = 4;
    public static final int IMPORTANT_FOR_ACCESSIBILITY_YES = 1;
    public static final int LAYER_TYPE_HARDWARE = 2;
    public static final int LAYER_TYPE_NONE = 0;
    public static final int LAYER_TYPE_SOFTWARE = 1;
    public static final int LAYOUT_DIRECTION_INHERIT = 2;
    public static final int LAYOUT_DIRECTION_LOCALE = 3;
    public static final int LAYOUT_DIRECTION_LTR = 0;
    public static final int LAYOUT_DIRECTION_RTL = 1;
    public static final int MEASURED_HEIGHT_STATE_SHIFT = 16;
    public static final int MEASURED_SIZE_MASK = 16777215;
    public static final int MEASURED_STATE_MASK = -16777216;
    public static final int MEASURED_STATE_TOO_SMALL = 16777216;
    @Deprecated
    public static final int OVER_SCROLL_ALWAYS = 0;
    @Deprecated
    public static final int OVER_SCROLL_IF_CONTENT_SCROLLS = 1;
    @Deprecated
    public static final int OVER_SCROLL_NEVER = 2;
    public static final int SCROLL_AXIS_HORIZONTAL = 1;
    public static final int SCROLL_AXIS_NONE = 0;
    public static final int SCROLL_AXIS_VERTICAL = 2;
    public static final int SCROLL_INDICATOR_BOTTOM = 2;
    public static final int SCROLL_INDICATOR_END = 32;
    public static final int SCROLL_INDICATOR_LEFT = 4;
    public static final int SCROLL_INDICATOR_RIGHT = 8;
    public static final int SCROLL_INDICATOR_START = 16;
    public static final int SCROLL_INDICATOR_TOP = 1;
    private static final String TAG = "ViewCompat";

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.GROUP_ID})
    /* loaded from: classes2.dex */
    public @interface FocusDirection {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.GROUP_ID})
    /* loaded from: classes2.dex */
    public @interface FocusRealDirection {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.GROUP_ID})
    /* loaded from: classes2.dex */
    public @interface FocusRelativeDirection {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes2.dex */
    public @interface ScrollIndicators {
    }

    /* loaded from: classes2.dex */
    interface ViewCompatImpl {
        ViewPropertyAnimatorCompat animate(View view2);

        boolean canScrollHorizontally(View view2, int i);

        boolean canScrollVertically(View view2, int i);

        int combineMeasuredStates(int i, int i2);

        WindowInsetsCompat dispatchApplyWindowInsets(View view2, WindowInsetsCompat windowInsetsCompat);

        void dispatchFinishTemporaryDetach(View view2);

        boolean dispatchNestedFling(View view2, float f, float f2, boolean z);

        boolean dispatchNestedPreFling(View view2, float f, float f2);

        boolean dispatchNestedPreScroll(View view2, int i, int i2, int[] iArr, int[] iArr2);

        boolean dispatchNestedScroll(View view2, int i, int i2, int i3, int i4, int[] iArr);

        void dispatchStartTemporaryDetach(View view2);

        int getAccessibilityLiveRegion(View view2);

        AccessibilityNodeProviderCompat getAccessibilityNodeProvider(View view2);

        float getAlpha(View view2);

        ColorStateList getBackgroundTintList(View view2);

        PorterDuff.Mode getBackgroundTintMode(View view2);

        Rect getClipBounds(View view2);

        Display getDisplay(View view2);

        float getElevation(View view2);

        boolean getFitsSystemWindows(View view2);

        int getImportantForAccessibility(View view2);

        int getLabelFor(View view2);

        int getLayerType(View view2);

        int getLayoutDirection(View view2);

        @Nullable
        Matrix getMatrix(View view2);

        int getMeasuredHeightAndState(View view2);

        int getMeasuredState(View view2);

        int getMeasuredWidthAndState(View view2);

        int getMinimumHeight(View view2);

        int getMinimumWidth(View view2);

        int getPaddingEnd(View view2);

        int getPaddingStart(View view2);

        ViewParent getParentForAccessibility(View view2);

        float getPivotX(View view2);

        float getPivotY(View view2);

        float getRotation(View view2);

        float getRotationX(View view2);

        float getRotationY(View view2);

        float getScaleX(View view2);

        float getScaleY(View view2);

        int getScrollIndicators(View view2);

        String getTransitionName(View view2);

        float getTranslationX(View view2);

        float getTranslationY(View view2);

        float getTranslationZ(View view2);

        int getWindowSystemUiVisibility(View view2);

        float getX(View view2);

        float getY(View view2);

        float getZ(View view2);

        boolean hasAccessibilityDelegate(View view2);

        boolean hasNestedScrollingParent(View view2);

        boolean hasOnClickListeners(View view2);

        boolean hasOverlappingRendering(View view2);

        boolean hasTransientState(View view2);

        boolean isAttachedToWindow(View view2);

        boolean isImportantForAccessibility(View view2);

        boolean isInLayout(View view2);

        boolean isLaidOut(View view2);

        boolean isLayoutDirectionResolved(View view2);

        boolean isNestedScrollingEnabled(View view2);

        boolean isPaddingRelative(View view2);

        void jumpDrawablesToCurrentState(View view2);

        void offsetLeftAndRight(View view2, int i);

        void offsetTopAndBottom(View view2, int i);

        WindowInsetsCompat onApplyWindowInsets(View view2, WindowInsetsCompat windowInsetsCompat);

        void onInitializeAccessibilityEvent(View view2, AccessibilityEvent accessibilityEvent);

        void onInitializeAccessibilityNodeInfo(View view2, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat);

        void onPopulateAccessibilityEvent(View view2, AccessibilityEvent accessibilityEvent);

        boolean performAccessibilityAction(View view2, int i, Bundle bundle);

        void postInvalidateOnAnimation(View view2);

        void postInvalidateOnAnimation(View view2, int i, int i2, int i3, int i4);

        void postOnAnimation(View view2, Runnable runnable);

        void postOnAnimationDelayed(View view2, Runnable runnable, long j);

        void requestApplyInsets(View view2);

        int resolveSizeAndState(int i, int i2, int i3);

        void setAccessibilityDelegate(View view2, @Nullable AccessibilityDelegateCompat accessibilityDelegateCompat);

        void setAccessibilityLiveRegion(View view2, int i);

        void setActivated(View view2, boolean z);

        void setAlpha(View view2, float f);

        void setBackground(View view2, Drawable drawable);

        void setBackgroundTintList(View view2, ColorStateList colorStateList);

        void setBackgroundTintMode(View view2, PorterDuff.Mode mode);

        void setChildrenDrawingOrderEnabled(ViewGroup viewGroup, boolean z);

        void setClipBounds(View view2, Rect rect);

        void setElevation(View view2, float f);

        void setFitsSystemWindows(View view2, boolean z);

        void setHasTransientState(View view2, boolean z);

        void setImportantForAccessibility(View view2, int i);

        void setLabelFor(View view2, int i);

        void setLayerPaint(View view2, Paint paint);

        void setLayerType(View view2, int i, Paint paint);

        void setLayoutDirection(View view2, int i);

        void setNestedScrollingEnabled(View view2, boolean z);

        void setOnApplyWindowInsetsListener(View view2, OnApplyWindowInsetsListener onApplyWindowInsetsListener);

        void setPaddingRelative(View view2, int i, int i2, int i3, int i4);

        void setPivotX(View view2, float f);

        void setPivotY(View view2, float f);

        void setPointerIcon(View view2, PointerIconCompat pointerIconCompat);

        void setRotation(View view2, float f);

        void setRotationX(View view2, float f);

        void setRotationY(View view2, float f);

        void setSaveFromParentEnabled(View view2, boolean z);

        void setScaleX(View view2, float f);

        void setScaleY(View view2, float f);

        void setScrollIndicators(View view2, int i);

        void setScrollIndicators(View view2, int i, int i2);

        void setTransitionName(View view2, String str);

        void setTranslationX(View view2, float f);

        void setTranslationY(View view2, float f);

        void setTranslationZ(View view2, float f);

        void setX(View view2, float f);

        void setY(View view2, float f);

        void setZ(View view2, float f);

        boolean startNestedScroll(View view2, int i);

        void stopNestedScroll(View view2);
    }

    /* loaded from: classes2.dex */
    static class BaseViewCompatImpl implements ViewCompatImpl {
        private static Method sChildrenDrawingOrderMethod;
        private Method mDispatchFinishTemporaryDetach;
        private Method mDispatchStartTemporaryDetach;
        private boolean mTempDetachBound;
        WeakHashMap<View, ViewPropertyAnimatorCompat> mViewPropertyAnimatorCompatMap = null;

        BaseViewCompatImpl() {
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatImpl
        public boolean canScrollHorizontally(View view2, int i) {
            return (view2 instanceof ScrollingView) && canScrollingViewScrollHorizontally((ScrollingView) view2, i);
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatImpl
        public boolean canScrollVertically(View view2, int i) {
            return (view2 instanceof ScrollingView) && canScrollingViewScrollVertically((ScrollingView) view2, i);
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatImpl
        public void setAccessibilityDelegate(View view2, AccessibilityDelegateCompat accessibilityDelegateCompat) {
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatImpl
        public boolean hasAccessibilityDelegate(View view2) {
            return false;
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatImpl
        public void onPopulateAccessibilityEvent(View view2, AccessibilityEvent accessibilityEvent) {
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatImpl
        public void onInitializeAccessibilityEvent(View view2, AccessibilityEvent accessibilityEvent) {
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatImpl
        public void onInitializeAccessibilityNodeInfo(View view2, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatImpl
        public boolean hasTransientState(View view2) {
            return false;
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatImpl
        public void setHasTransientState(View view2, boolean z) {
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatImpl
        public void postInvalidateOnAnimation(View view2) {
            view2.invalidate();
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatImpl
        public void postInvalidateOnAnimation(View view2, int i, int i2, int i3, int i4) {
            view2.invalidate(i, i2, i3, i4);
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatImpl
        public void postOnAnimation(View view2, Runnable runnable) {
            view2.postDelayed(runnable, getFrameTime());
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatImpl
        public void postOnAnimationDelayed(View view2, Runnable runnable, long j) {
            view2.postDelayed(runnable, getFrameTime() + j);
        }

        long getFrameTime() {
            return ViewCompat.FAKE_FRAME_TIME;
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatImpl
        public int getImportantForAccessibility(View view2) {
            return 0;
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatImpl
        public void setImportantForAccessibility(View view2, int i) {
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatImpl
        public boolean isImportantForAccessibility(View view2) {
            return true;
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatImpl
        public boolean performAccessibilityAction(View view2, int i, Bundle bundle) {
            return false;
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatImpl
        public AccessibilityNodeProviderCompat getAccessibilityNodeProvider(View view2) {
            return null;
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatImpl
        public float getAlpha(View view2) {
            return 1.0f;
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatImpl
        public void setLayerType(View view2, int i, Paint paint) {
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatImpl
        public int getLayerType(View view2) {
            return 0;
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatImpl
        public int getLabelFor(View view2) {
            return 0;
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatImpl
        public void setLabelFor(View view2, int i) {
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatImpl
        public void setLayerPaint(View view2, Paint paint) {
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatImpl
        public int getLayoutDirection(View view2) {
            return 0;
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatImpl
        public void setLayoutDirection(View view2, int i) {
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatImpl
        public ViewParent getParentForAccessibility(View view2) {
            return view2.getParent();
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatImpl
        public int resolveSizeAndState(int i, int i2, int i3) {
            return View.resolveSize(i, i2);
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatImpl
        public int getMeasuredWidthAndState(View view2) {
            return view2.getMeasuredWidth();
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatImpl
        public int getMeasuredHeightAndState(View view2) {
            return view2.getMeasuredHeight();
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatImpl
        public int getMeasuredState(View view2) {
            return 0;
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatImpl
        public int getAccessibilityLiveRegion(View view2) {
            return 0;
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatImpl
        public void setAccessibilityLiveRegion(View view2, int i) {
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatImpl
        public int getPaddingStart(View view2) {
            return view2.getPaddingLeft();
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatImpl
        public int getPaddingEnd(View view2) {
            return view2.getPaddingRight();
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatImpl
        public void setPaddingRelative(View view2, int i, int i2, int i3, int i4) {
            view2.setPadding(i, i2, i3, i4);
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatImpl
        public void dispatchStartTemporaryDetach(View view2) {
            if (!this.mTempDetachBound) {
                bindTempDetach();
            }
            if (this.mDispatchStartTemporaryDetach != null) {
                try {
                    this.mDispatchStartTemporaryDetach.invoke(view2, new Object[0]);
                    return;
                } catch (Exception e) {
                    Log.d(ViewCompat.TAG, "Error calling dispatchStartTemporaryDetach", e);
                    return;
                }
            }
            view2.onStartTemporaryDetach();
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatImpl
        public void dispatchFinishTemporaryDetach(View view2) {
            if (!this.mTempDetachBound) {
                bindTempDetach();
            }
            if (this.mDispatchFinishTemporaryDetach != null) {
                try {
                    this.mDispatchFinishTemporaryDetach.invoke(view2, new Object[0]);
                    return;
                } catch (Exception e) {
                    Log.d(ViewCompat.TAG, "Error calling dispatchFinishTemporaryDetach", e);
                    return;
                }
            }
            view2.onFinishTemporaryDetach();
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatImpl
        public boolean hasOverlappingRendering(View view2) {
            return true;
        }

        private void bindTempDetach() {
            try {
                this.mDispatchStartTemporaryDetach = View.class.getDeclaredMethod("dispatchStartTemporaryDetach", new Class[0]);
                this.mDispatchFinishTemporaryDetach = View.class.getDeclaredMethod("dispatchFinishTemporaryDetach", new Class[0]);
            } catch (NoSuchMethodException e) {
                Log.e(ViewCompat.TAG, "Couldn't find method", e);
            }
            this.mTempDetachBound = true;
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatImpl
        public float getTranslationX(View view2) {
            return 0.0f;
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatImpl
        public float getTranslationY(View view2) {
            return 0.0f;
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatImpl
        public float getX(View view2) {
            return view2.getLeft();
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatImpl
        public float getY(View view2) {
            return view2.getTop();
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatImpl
        public float getRotation(View view2) {
            return 0.0f;
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatImpl
        public float getRotationX(View view2) {
            return 0.0f;
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatImpl
        public float getRotationY(View view2) {
            return 0.0f;
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatImpl
        public float getScaleX(View view2) {
            return 0.0f;
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatImpl
        public float getScaleY(View view2) {
            return 0.0f;
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatImpl
        public Matrix getMatrix(View view2) {
            return null;
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatImpl
        public int getMinimumWidth(View view2) {
            return ViewCompatBase.getMinimumWidth(view2);
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatImpl
        public int getMinimumHeight(View view2) {
            return ViewCompatBase.getMinimumHeight(view2);
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatImpl
        public ViewPropertyAnimatorCompat animate(View view2) {
            return new ViewPropertyAnimatorCompat(view2);
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatImpl
        public void setRotation(View view2, float f) {
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatImpl
        public void setTranslationX(View view2, float f) {
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatImpl
        public void setTranslationY(View view2, float f) {
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatImpl
        public void setAlpha(View view2, float f) {
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatImpl
        public void setRotationX(View view2, float f) {
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatImpl
        public void setRotationY(View view2, float f) {
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatImpl
        public void setScaleX(View view2, float f) {
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatImpl
        public void setScaleY(View view2, float f) {
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatImpl
        public void setX(View view2, float f) {
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatImpl
        public void setY(View view2, float f) {
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatImpl
        public void setPivotX(View view2, float f) {
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatImpl
        public void setPivotY(View view2, float f) {
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatImpl
        public float getPivotX(View view2) {
            return 0.0f;
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatImpl
        public float getPivotY(View view2) {
            return 0.0f;
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatImpl
        public void setTransitionName(View view2, String str) {
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatImpl
        public String getTransitionName(View view2) {
            return null;
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatImpl
        public int getWindowSystemUiVisibility(View view2) {
            return 0;
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatImpl
        public void requestApplyInsets(View view2) {
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatImpl
        public void setElevation(View view2, float f) {
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatImpl
        public float getElevation(View view2) {
            return 0.0f;
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatImpl
        public void setTranslationZ(View view2, float f) {
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatImpl
        public float getTranslationZ(View view2) {
            return 0.0f;
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatImpl
        public void setClipBounds(View view2, Rect rect) {
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatImpl
        public Rect getClipBounds(View view2) {
            return null;
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatImpl
        public void setChildrenDrawingOrderEnabled(ViewGroup viewGroup, boolean z) {
            if (sChildrenDrawingOrderMethod == null) {
                try {
                    sChildrenDrawingOrderMethod = ViewGroup.class.getDeclaredMethod("setChildrenDrawingOrderEnabled", Boolean.TYPE);
                } catch (NoSuchMethodException e) {
                    Log.e(ViewCompat.TAG, "Unable to find childrenDrawingOrderEnabled", e);
                }
                sChildrenDrawingOrderMethod.setAccessible(true);
            }
            try {
                sChildrenDrawingOrderMethod.invoke(viewGroup, Boolean.valueOf(z));
            } catch (IllegalAccessException e2) {
                Log.e(ViewCompat.TAG, "Unable to invoke childrenDrawingOrderEnabled", e2);
            } catch (IllegalArgumentException e3) {
                Log.e(ViewCompat.TAG, "Unable to invoke childrenDrawingOrderEnabled", e3);
            } catch (InvocationTargetException e4) {
                Log.e(ViewCompat.TAG, "Unable to invoke childrenDrawingOrderEnabled", e4);
            }
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatImpl
        public boolean getFitsSystemWindows(View view2) {
            return false;
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatImpl
        public void setFitsSystemWindows(View view2, boolean z) {
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatImpl
        public void jumpDrawablesToCurrentState(View view2) {
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatImpl
        public void setOnApplyWindowInsetsListener(View view2, OnApplyWindowInsetsListener onApplyWindowInsetsListener) {
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatImpl
        public WindowInsetsCompat onApplyWindowInsets(View view2, WindowInsetsCompat windowInsetsCompat) {
            return windowInsetsCompat;
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatImpl
        public WindowInsetsCompat dispatchApplyWindowInsets(View view2, WindowInsetsCompat windowInsetsCompat) {
            return windowInsetsCompat;
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatImpl
        public void setSaveFromParentEnabled(View view2, boolean z) {
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatImpl
        public void setActivated(View view2, boolean z) {
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatImpl
        public boolean isPaddingRelative(View view2) {
            return false;
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatImpl
        public void setNestedScrollingEnabled(View view2, boolean z) {
            if (view2 instanceof NestedScrollingChild) {
                ((NestedScrollingChild) view2).setNestedScrollingEnabled(z);
            }
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatImpl
        public boolean isNestedScrollingEnabled(View view2) {
            if (view2 instanceof NestedScrollingChild) {
                return ((NestedScrollingChild) view2).isNestedScrollingEnabled();
            }
            return false;
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatImpl
        public void setBackground(View view2, Drawable drawable) {
            view2.setBackgroundDrawable(drawable);
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatImpl
        public ColorStateList getBackgroundTintList(View view2) {
            return ViewCompatBase.getBackgroundTintList(view2);
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatImpl
        public void setBackgroundTintList(View view2, ColorStateList colorStateList) {
            ViewCompatBase.setBackgroundTintList(view2, colorStateList);
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatImpl
        public void setBackgroundTintMode(View view2, PorterDuff.Mode mode) {
            ViewCompatBase.setBackgroundTintMode(view2, mode);
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatImpl
        public PorterDuff.Mode getBackgroundTintMode(View view2) {
            return ViewCompatBase.getBackgroundTintMode(view2);
        }

        private boolean canScrollingViewScrollHorizontally(ScrollingView scrollingView, int i) {
            int computeHorizontalScrollOffset = scrollingView.computeHorizontalScrollOffset();
            int computeHorizontalScrollRange = scrollingView.computeHorizontalScrollRange() - scrollingView.computeHorizontalScrollExtent();
            if (computeHorizontalScrollRange == 0) {
                return false;
            }
            return i < 0 ? computeHorizontalScrollOffset > 0 : computeHorizontalScrollOffset < computeHorizontalScrollRange + (-1);
        }

        private boolean canScrollingViewScrollVertically(ScrollingView scrollingView, int i) {
            int computeVerticalScrollOffset = scrollingView.computeVerticalScrollOffset();
            int computeVerticalScrollRange = scrollingView.computeVerticalScrollRange() - scrollingView.computeVerticalScrollExtent();
            if (computeVerticalScrollRange == 0) {
                return false;
            }
            return i < 0 ? computeVerticalScrollOffset > 0 : computeVerticalScrollOffset < computeVerticalScrollRange + (-1);
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatImpl
        public boolean startNestedScroll(View view2, int i) {
            if (view2 instanceof NestedScrollingChild) {
                return ((NestedScrollingChild) view2).startNestedScroll(i);
            }
            return false;
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatImpl
        public void stopNestedScroll(View view2) {
            if (view2 instanceof NestedScrollingChild) {
                ((NestedScrollingChild) view2).stopNestedScroll();
            }
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatImpl
        public boolean hasNestedScrollingParent(View view2) {
            if (view2 instanceof NestedScrollingChild) {
                return ((NestedScrollingChild) view2).hasNestedScrollingParent();
            }
            return false;
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatImpl
        public boolean dispatchNestedScroll(View view2, int i, int i2, int i3, int i4, int[] iArr) {
            if (view2 instanceof NestedScrollingChild) {
                return ((NestedScrollingChild) view2).dispatchNestedScroll(i, i2, i3, i4, iArr);
            }
            return false;
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatImpl
        public boolean dispatchNestedPreScroll(View view2, int i, int i2, int[] iArr, int[] iArr2) {
            if (view2 instanceof NestedScrollingChild) {
                return ((NestedScrollingChild) view2).dispatchNestedPreScroll(i, i2, iArr, iArr2);
            }
            return false;
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatImpl
        public boolean dispatchNestedFling(View view2, float f, float f2, boolean z) {
            if (view2 instanceof NestedScrollingChild) {
                return ((NestedScrollingChild) view2).dispatchNestedFling(f, f2, z);
            }
            return false;
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatImpl
        public boolean dispatchNestedPreFling(View view2, float f, float f2) {
            if (view2 instanceof NestedScrollingChild) {
                return ((NestedScrollingChild) view2).dispatchNestedPreFling(f, f2);
            }
            return false;
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatImpl
        public boolean isInLayout(View view2) {
            return false;
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatImpl
        public boolean isLaidOut(View view2) {
            return ViewCompatBase.isLaidOut(view2);
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatImpl
        public boolean isLayoutDirectionResolved(View view2) {
            return false;
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatImpl
        public int combineMeasuredStates(int i, int i2) {
            return i | i2;
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatImpl
        public float getZ(View view2) {
            return getTranslationZ(view2) + getElevation(view2);
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatImpl
        public void setZ(View view2, float f) {
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatImpl
        public boolean isAttachedToWindow(View view2) {
            return ViewCompatBase.isAttachedToWindow(view2);
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatImpl
        public boolean hasOnClickListeners(View view2) {
            return false;
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatImpl
        public int getScrollIndicators(View view2) {
            return 0;
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatImpl
        public void setScrollIndicators(View view2, int i) {
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatImpl
        public void setScrollIndicators(View view2, int i, int i2) {
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatImpl
        public void offsetLeftAndRight(View view2, int i) {
            ViewCompatBase.offsetLeftAndRight(view2, i);
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatImpl
        public void offsetTopAndBottom(View view2, int i) {
            ViewCompatBase.offsetTopAndBottom(view2, i);
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatImpl
        public void setPointerIcon(View view2, PointerIconCompat pointerIconCompat) {
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatImpl
        public Display getDisplay(View view2) {
            return ViewCompatBase.getDisplay(view2);
        }
    }

    /* loaded from: classes2.dex */
    static class HCViewCompatImpl extends BaseViewCompatImpl {
        HCViewCompatImpl() {
        }

        @Override // android.support.v4.view.ViewCompat.BaseViewCompatImpl
        long getFrameTime() {
            return ViewCompatHC.getFrameTime();
        }

        @Override // android.support.v4.view.ViewCompat.BaseViewCompatImpl, android.support.v4.view.ViewCompat.ViewCompatImpl
        public float getAlpha(View view2) {
            return ViewCompatHC.getAlpha(view2);
        }

        @Override // android.support.v4.view.ViewCompat.BaseViewCompatImpl, android.support.v4.view.ViewCompat.ViewCompatImpl
        public void setLayerType(View view2, int i, Paint paint) {
            ViewCompatHC.setLayerType(view2, i, paint);
        }

        @Override // android.support.v4.view.ViewCompat.BaseViewCompatImpl, android.support.v4.view.ViewCompat.ViewCompatImpl
        public int getLayerType(View view2) {
            return ViewCompatHC.getLayerType(view2);
        }

        @Override // android.support.v4.view.ViewCompat.BaseViewCompatImpl, android.support.v4.view.ViewCompat.ViewCompatImpl
        public void setLayerPaint(View view2, Paint paint) {
            setLayerType(view2, getLayerType(view2), paint);
            view2.invalidate();
        }

        @Override // android.support.v4.view.ViewCompat.BaseViewCompatImpl, android.support.v4.view.ViewCompat.ViewCompatImpl
        public int resolveSizeAndState(int i, int i2, int i3) {
            return ViewCompatHC.resolveSizeAndState(i, i2, i3);
        }

        @Override // android.support.v4.view.ViewCompat.BaseViewCompatImpl, android.support.v4.view.ViewCompat.ViewCompatImpl
        public int getMeasuredWidthAndState(View view2) {
            return ViewCompatHC.getMeasuredWidthAndState(view2);
        }

        @Override // android.support.v4.view.ViewCompat.BaseViewCompatImpl, android.support.v4.view.ViewCompat.ViewCompatImpl
        public int getMeasuredHeightAndState(View view2) {
            return ViewCompatHC.getMeasuredHeightAndState(view2);
        }

        @Override // android.support.v4.view.ViewCompat.BaseViewCompatImpl, android.support.v4.view.ViewCompat.ViewCompatImpl
        public int getMeasuredState(View view2) {
            return ViewCompatHC.getMeasuredState(view2);
        }

        @Override // android.support.v4.view.ViewCompat.BaseViewCompatImpl, android.support.v4.view.ViewCompat.ViewCompatImpl
        public float getTranslationX(View view2) {
            return ViewCompatHC.getTranslationX(view2);
        }

        @Override // android.support.v4.view.ViewCompat.BaseViewCompatImpl, android.support.v4.view.ViewCompat.ViewCompatImpl
        public float getTranslationY(View view2) {
            return ViewCompatHC.getTranslationY(view2);
        }

        @Override // android.support.v4.view.ViewCompat.BaseViewCompatImpl, android.support.v4.view.ViewCompat.ViewCompatImpl
        public Matrix getMatrix(View view2) {
            return ViewCompatHC.getMatrix(view2);
        }

        @Override // android.support.v4.view.ViewCompat.BaseViewCompatImpl, android.support.v4.view.ViewCompat.ViewCompatImpl
        public void setTranslationX(View view2, float f) {
            ViewCompatHC.setTranslationX(view2, f);
        }

        @Override // android.support.v4.view.ViewCompat.BaseViewCompatImpl, android.support.v4.view.ViewCompat.ViewCompatImpl
        public void setTranslationY(View view2, float f) {
            ViewCompatHC.setTranslationY(view2, f);
        }

        @Override // android.support.v4.view.ViewCompat.BaseViewCompatImpl, android.support.v4.view.ViewCompat.ViewCompatImpl
        public void setAlpha(View view2, float f) {
            ViewCompatHC.setAlpha(view2, f);
        }

        @Override // android.support.v4.view.ViewCompat.BaseViewCompatImpl, android.support.v4.view.ViewCompat.ViewCompatImpl
        public void setX(View view2, float f) {
            ViewCompatHC.setX(view2, f);
        }

        @Override // android.support.v4.view.ViewCompat.BaseViewCompatImpl, android.support.v4.view.ViewCompat.ViewCompatImpl
        public void setY(View view2, float f) {
            ViewCompatHC.setY(view2, f);
        }

        @Override // android.support.v4.view.ViewCompat.BaseViewCompatImpl, android.support.v4.view.ViewCompat.ViewCompatImpl
        public void setRotation(View view2, float f) {
            ViewCompatHC.setRotation(view2, f);
        }

        @Override // android.support.v4.view.ViewCompat.BaseViewCompatImpl, android.support.v4.view.ViewCompat.ViewCompatImpl
        public void setRotationX(View view2, float f) {
            ViewCompatHC.setRotationX(view2, f);
        }

        @Override // android.support.v4.view.ViewCompat.BaseViewCompatImpl, android.support.v4.view.ViewCompat.ViewCompatImpl
        public void setRotationY(View view2, float f) {
            ViewCompatHC.setRotationY(view2, f);
        }

        @Override // android.support.v4.view.ViewCompat.BaseViewCompatImpl, android.support.v4.view.ViewCompat.ViewCompatImpl
        public void setScaleX(View view2, float f) {
            ViewCompatHC.setScaleX(view2, f);
        }

        @Override // android.support.v4.view.ViewCompat.BaseViewCompatImpl, android.support.v4.view.ViewCompat.ViewCompatImpl
        public void setScaleY(View view2, float f) {
            ViewCompatHC.setScaleY(view2, f);
        }

        @Override // android.support.v4.view.ViewCompat.BaseViewCompatImpl, android.support.v4.view.ViewCompat.ViewCompatImpl
        public void setPivotX(View view2, float f) {
            ViewCompatHC.setPivotX(view2, f);
        }

        @Override // android.support.v4.view.ViewCompat.BaseViewCompatImpl, android.support.v4.view.ViewCompat.ViewCompatImpl
        public void setPivotY(View view2, float f) {
            ViewCompatHC.setPivotY(view2, f);
        }

        @Override // android.support.v4.view.ViewCompat.BaseViewCompatImpl, android.support.v4.view.ViewCompat.ViewCompatImpl
        public float getX(View view2) {
            return ViewCompatHC.getX(view2);
        }

        @Override // android.support.v4.view.ViewCompat.BaseViewCompatImpl, android.support.v4.view.ViewCompat.ViewCompatImpl
        public float getY(View view2) {
            return ViewCompatHC.getY(view2);
        }

        @Override // android.support.v4.view.ViewCompat.BaseViewCompatImpl, android.support.v4.view.ViewCompat.ViewCompatImpl
        public float getRotation(View view2) {
            return ViewCompatHC.getRotation(view2);
        }

        @Override // android.support.v4.view.ViewCompat.BaseViewCompatImpl, android.support.v4.view.ViewCompat.ViewCompatImpl
        public float getRotationX(View view2) {
            return ViewCompatHC.getRotationX(view2);
        }

        @Override // android.support.v4.view.ViewCompat.BaseViewCompatImpl, android.support.v4.view.ViewCompat.ViewCompatImpl
        public float getRotationY(View view2) {
            return ViewCompatHC.getRotationY(view2);
        }

        @Override // android.support.v4.view.ViewCompat.BaseViewCompatImpl, android.support.v4.view.ViewCompat.ViewCompatImpl
        public float getScaleX(View view2) {
            return ViewCompatHC.getScaleX(view2);
        }

        @Override // android.support.v4.view.ViewCompat.BaseViewCompatImpl, android.support.v4.view.ViewCompat.ViewCompatImpl
        public float getScaleY(View view2) {
            return ViewCompatHC.getScaleY(view2);
        }

        @Override // android.support.v4.view.ViewCompat.BaseViewCompatImpl, android.support.v4.view.ViewCompat.ViewCompatImpl
        public float getPivotX(View view2) {
            return ViewCompatHC.getPivotX(view2);
        }

        @Override // android.support.v4.view.ViewCompat.BaseViewCompatImpl, android.support.v4.view.ViewCompat.ViewCompatImpl
        public float getPivotY(View view2) {
            return ViewCompatHC.getPivotY(view2);
        }

        @Override // android.support.v4.view.ViewCompat.BaseViewCompatImpl, android.support.v4.view.ViewCompat.ViewCompatImpl
        public void jumpDrawablesToCurrentState(View view2) {
            ViewCompatHC.jumpDrawablesToCurrentState(view2);
        }

        @Override // android.support.v4.view.ViewCompat.BaseViewCompatImpl, android.support.v4.view.ViewCompat.ViewCompatImpl
        public void setSaveFromParentEnabled(View view2, boolean z) {
            ViewCompatHC.setSaveFromParentEnabled(view2, z);
        }

        @Override // android.support.v4.view.ViewCompat.BaseViewCompatImpl, android.support.v4.view.ViewCompat.ViewCompatImpl
        public void setActivated(View view2, boolean z) {
            ViewCompatHC.setActivated(view2, z);
        }

        @Override // android.support.v4.view.ViewCompat.BaseViewCompatImpl, android.support.v4.view.ViewCompat.ViewCompatImpl
        public int combineMeasuredStates(int i, int i2) {
            return ViewCompatHC.combineMeasuredStates(i, i2);
        }

        @Override // android.support.v4.view.ViewCompat.BaseViewCompatImpl, android.support.v4.view.ViewCompat.ViewCompatImpl
        public void offsetLeftAndRight(View view2, int i) {
            ViewCompatHC.offsetLeftAndRight(view2, i);
        }

        @Override // android.support.v4.view.ViewCompat.BaseViewCompatImpl, android.support.v4.view.ViewCompat.ViewCompatImpl
        public void offsetTopAndBottom(View view2, int i) {
            ViewCompatHC.offsetTopAndBottom(view2, i);
        }
    }

    /* loaded from: classes2.dex */
    static class ICSViewCompatImpl extends HCViewCompatImpl {
        static boolean accessibilityDelegateCheckFailed = false;
        static Field mAccessibilityDelegateField;

        ICSViewCompatImpl() {
        }

        @Override // android.support.v4.view.ViewCompat.BaseViewCompatImpl, android.support.v4.view.ViewCompat.ViewCompatImpl
        public boolean canScrollHorizontally(View view2, int i) {
            return ViewCompatICS.canScrollHorizontally(view2, i);
        }

        @Override // android.support.v4.view.ViewCompat.BaseViewCompatImpl, android.support.v4.view.ViewCompat.ViewCompatImpl
        public boolean canScrollVertically(View view2, int i) {
            return ViewCompatICS.canScrollVertically(view2, i);
        }

        @Override // android.support.v4.view.ViewCompat.BaseViewCompatImpl, android.support.v4.view.ViewCompat.ViewCompatImpl
        public void onPopulateAccessibilityEvent(View view2, AccessibilityEvent accessibilityEvent) {
            ViewCompatICS.onPopulateAccessibilityEvent(view2, accessibilityEvent);
        }

        @Override // android.support.v4.view.ViewCompat.BaseViewCompatImpl, android.support.v4.view.ViewCompat.ViewCompatImpl
        public void onInitializeAccessibilityEvent(View view2, AccessibilityEvent accessibilityEvent) {
            ViewCompatICS.onInitializeAccessibilityEvent(view2, accessibilityEvent);
        }

        @Override // android.support.v4.view.ViewCompat.BaseViewCompatImpl, android.support.v4.view.ViewCompat.ViewCompatImpl
        public void onInitializeAccessibilityNodeInfo(View view2, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            ViewCompatICS.onInitializeAccessibilityNodeInfo(view2, accessibilityNodeInfoCompat.getInfo());
        }

        @Override // android.support.v4.view.ViewCompat.BaseViewCompatImpl, android.support.v4.view.ViewCompat.ViewCompatImpl
        public void setAccessibilityDelegate(View view2, @Nullable AccessibilityDelegateCompat accessibilityDelegateCompat) {
            ViewCompatICS.setAccessibilityDelegate(view2, accessibilityDelegateCompat == null ? null : accessibilityDelegateCompat.getBridge());
        }

        @Override // android.support.v4.view.ViewCompat.BaseViewCompatImpl, android.support.v4.view.ViewCompat.ViewCompatImpl
        public boolean hasAccessibilityDelegate(View view2) {
            if (accessibilityDelegateCheckFailed) {
                return false;
            }
            if (mAccessibilityDelegateField == null) {
                try {
                    mAccessibilityDelegateField = View.class.getDeclaredField("mAccessibilityDelegate");
                    mAccessibilityDelegateField.setAccessible(true);
                } catch (Throwable th) {
                    accessibilityDelegateCheckFailed = true;
                    return false;
                }
            }
            try {
                return mAccessibilityDelegateField.get(view2) != null;
            } catch (Throwable th2) {
                accessibilityDelegateCheckFailed = true;
                return false;
            }
        }

        @Override // android.support.v4.view.ViewCompat.BaseViewCompatImpl, android.support.v4.view.ViewCompat.ViewCompatImpl
        public ViewPropertyAnimatorCompat animate(View view2) {
            if (this.mViewPropertyAnimatorCompatMap == null) {
                this.mViewPropertyAnimatorCompatMap = new WeakHashMap<>();
            }
            ViewPropertyAnimatorCompat viewPropertyAnimatorCompat = this.mViewPropertyAnimatorCompatMap.get(view2);
            if (viewPropertyAnimatorCompat == null) {
                ViewPropertyAnimatorCompat viewPropertyAnimatorCompat2 = new ViewPropertyAnimatorCompat(view2);
                this.mViewPropertyAnimatorCompatMap.put(view2, viewPropertyAnimatorCompat2);
                return viewPropertyAnimatorCompat2;
            }
            return viewPropertyAnimatorCompat;
        }

        @Override // android.support.v4.view.ViewCompat.BaseViewCompatImpl, android.support.v4.view.ViewCompat.ViewCompatImpl
        public void setFitsSystemWindows(View view2, boolean z) {
            ViewCompatICS.setFitsSystemWindows(view2, z);
        }
    }

    /* loaded from: classes2.dex */
    static class ICSMr1ViewCompatImpl extends ICSViewCompatImpl {
        ICSMr1ViewCompatImpl() {
        }

        @Override // android.support.v4.view.ViewCompat.BaseViewCompatImpl, android.support.v4.view.ViewCompat.ViewCompatImpl
        public boolean hasOnClickListeners(View view2) {
            return ViewCompatICSMr1.hasOnClickListeners(view2);
        }
    }

    /* loaded from: classes2.dex */
    static class JBViewCompatImpl extends ICSMr1ViewCompatImpl {
        JBViewCompatImpl() {
        }

        @Override // android.support.v4.view.ViewCompat.BaseViewCompatImpl, android.support.v4.view.ViewCompat.ViewCompatImpl
        public boolean hasTransientState(View view2) {
            return ViewCompatJB.hasTransientState(view2);
        }

        @Override // android.support.v4.view.ViewCompat.BaseViewCompatImpl, android.support.v4.view.ViewCompat.ViewCompatImpl
        public void setHasTransientState(View view2, boolean z) {
            ViewCompatJB.setHasTransientState(view2, z);
        }

        @Override // android.support.v4.view.ViewCompat.BaseViewCompatImpl, android.support.v4.view.ViewCompat.ViewCompatImpl
        public void postInvalidateOnAnimation(View view2) {
            ViewCompatJB.postInvalidateOnAnimation(view2);
        }

        @Override // android.support.v4.view.ViewCompat.BaseViewCompatImpl, android.support.v4.view.ViewCompat.ViewCompatImpl
        public void postInvalidateOnAnimation(View view2, int i, int i2, int i3, int i4) {
            ViewCompatJB.postInvalidateOnAnimation(view2, i, i2, i3, i4);
        }

        @Override // android.support.v4.view.ViewCompat.BaseViewCompatImpl, android.support.v4.view.ViewCompat.ViewCompatImpl
        public void postOnAnimation(View view2, Runnable runnable) {
            ViewCompatJB.postOnAnimation(view2, runnable);
        }

        @Override // android.support.v4.view.ViewCompat.BaseViewCompatImpl, android.support.v4.view.ViewCompat.ViewCompatImpl
        public void postOnAnimationDelayed(View view2, Runnable runnable, long j) {
            ViewCompatJB.postOnAnimationDelayed(view2, runnable, j);
        }

        @Override // android.support.v4.view.ViewCompat.BaseViewCompatImpl, android.support.v4.view.ViewCompat.ViewCompatImpl
        public int getImportantForAccessibility(View view2) {
            return ViewCompatJB.getImportantForAccessibility(view2);
        }

        @Override // android.support.v4.view.ViewCompat.BaseViewCompatImpl, android.support.v4.view.ViewCompat.ViewCompatImpl
        public void setImportantForAccessibility(View view2, int i) {
            if (i == 4) {
                i = 2;
            }
            ViewCompatJB.setImportantForAccessibility(view2, i);
        }

        @Override // android.support.v4.view.ViewCompat.BaseViewCompatImpl, android.support.v4.view.ViewCompat.ViewCompatImpl
        public boolean performAccessibilityAction(View view2, int i, Bundle bundle) {
            return ViewCompatJB.performAccessibilityAction(view2, i, bundle);
        }

        @Override // android.support.v4.view.ViewCompat.BaseViewCompatImpl, android.support.v4.view.ViewCompat.ViewCompatImpl
        public AccessibilityNodeProviderCompat getAccessibilityNodeProvider(View view2) {
            Object accessibilityNodeProvider = ViewCompatJB.getAccessibilityNodeProvider(view2);
            if (accessibilityNodeProvider != null) {
                return new AccessibilityNodeProviderCompat(accessibilityNodeProvider);
            }
            return null;
        }

        @Override // android.support.v4.view.ViewCompat.BaseViewCompatImpl, android.support.v4.view.ViewCompat.ViewCompatImpl
        public ViewParent getParentForAccessibility(View view2) {
            return ViewCompatJB.getParentForAccessibility(view2);
        }

        @Override // android.support.v4.view.ViewCompat.BaseViewCompatImpl, android.support.v4.view.ViewCompat.ViewCompatImpl
        public int getMinimumWidth(View view2) {
            return ViewCompatJB.getMinimumWidth(view2);
        }

        @Override // android.support.v4.view.ViewCompat.BaseViewCompatImpl, android.support.v4.view.ViewCompat.ViewCompatImpl
        public int getMinimumHeight(View view2) {
            return ViewCompatJB.getMinimumHeight(view2);
        }

        @Override // android.support.v4.view.ViewCompat.BaseViewCompatImpl, android.support.v4.view.ViewCompat.ViewCompatImpl
        public void requestApplyInsets(View view2) {
            ViewCompatJB.requestApplyInsets(view2);
        }

        @Override // android.support.v4.view.ViewCompat.BaseViewCompatImpl, android.support.v4.view.ViewCompat.ViewCompatImpl
        public boolean getFitsSystemWindows(View view2) {
            return ViewCompatJB.getFitsSystemWindows(view2);
        }

        @Override // android.support.v4.view.ViewCompat.BaseViewCompatImpl, android.support.v4.view.ViewCompat.ViewCompatImpl
        public boolean hasOverlappingRendering(View view2) {
            return ViewCompatJB.hasOverlappingRendering(view2);
        }

        @Override // android.support.v4.view.ViewCompat.BaseViewCompatImpl, android.support.v4.view.ViewCompat.ViewCompatImpl
        public void setBackground(View view2, Drawable drawable) {
            ViewCompatJB.setBackground(view2, drawable);
        }
    }

    /* loaded from: classes2.dex */
    static class JbMr1ViewCompatImpl extends JBViewCompatImpl {
        JbMr1ViewCompatImpl() {
        }

        @Override // android.support.v4.view.ViewCompat.BaseViewCompatImpl, android.support.v4.view.ViewCompat.ViewCompatImpl
        public int getLabelFor(View view2) {
            return ViewCompatJellybeanMr1.getLabelFor(view2);
        }

        @Override // android.support.v4.view.ViewCompat.BaseViewCompatImpl, android.support.v4.view.ViewCompat.ViewCompatImpl
        public void setLabelFor(View view2, int i) {
            ViewCompatJellybeanMr1.setLabelFor(view2, i);
        }

        @Override // android.support.v4.view.ViewCompat.HCViewCompatImpl, android.support.v4.view.ViewCompat.BaseViewCompatImpl, android.support.v4.view.ViewCompat.ViewCompatImpl
        public void setLayerPaint(View view2, Paint paint) {
            ViewCompatJellybeanMr1.setLayerPaint(view2, paint);
        }

        @Override // android.support.v4.view.ViewCompat.BaseViewCompatImpl, android.support.v4.view.ViewCompat.ViewCompatImpl
        public int getLayoutDirection(View view2) {
            return ViewCompatJellybeanMr1.getLayoutDirection(view2);
        }

        @Override // android.support.v4.view.ViewCompat.BaseViewCompatImpl, android.support.v4.view.ViewCompat.ViewCompatImpl
        public void setLayoutDirection(View view2, int i) {
            ViewCompatJellybeanMr1.setLayoutDirection(view2, i);
        }

        @Override // android.support.v4.view.ViewCompat.BaseViewCompatImpl, android.support.v4.view.ViewCompat.ViewCompatImpl
        public int getPaddingStart(View view2) {
            return ViewCompatJellybeanMr1.getPaddingStart(view2);
        }

        @Override // android.support.v4.view.ViewCompat.BaseViewCompatImpl, android.support.v4.view.ViewCompat.ViewCompatImpl
        public int getPaddingEnd(View view2) {
            return ViewCompatJellybeanMr1.getPaddingEnd(view2);
        }

        @Override // android.support.v4.view.ViewCompat.BaseViewCompatImpl, android.support.v4.view.ViewCompat.ViewCompatImpl
        public void setPaddingRelative(View view2, int i, int i2, int i3, int i4) {
            ViewCompatJellybeanMr1.setPaddingRelative(view2, i, i2, i3, i4);
        }

        @Override // android.support.v4.view.ViewCompat.BaseViewCompatImpl, android.support.v4.view.ViewCompat.ViewCompatImpl
        public int getWindowSystemUiVisibility(View view2) {
            return ViewCompatJellybeanMr1.getWindowSystemUiVisibility(view2);
        }

        @Override // android.support.v4.view.ViewCompat.BaseViewCompatImpl, android.support.v4.view.ViewCompat.ViewCompatImpl
        public boolean isPaddingRelative(View view2) {
            return ViewCompatJellybeanMr1.isPaddingRelative(view2);
        }

        @Override // android.support.v4.view.ViewCompat.BaseViewCompatImpl, android.support.v4.view.ViewCompat.ViewCompatImpl
        public Display getDisplay(View view2) {
            return ViewCompatJellybeanMr1.getDisplay(view2);
        }
    }

    /* loaded from: classes2.dex */
    static class JbMr2ViewCompatImpl extends JbMr1ViewCompatImpl {
        JbMr2ViewCompatImpl() {
        }

        @Override // android.support.v4.view.ViewCompat.BaseViewCompatImpl, android.support.v4.view.ViewCompat.ViewCompatImpl
        public void setClipBounds(View view2, Rect rect) {
            ViewCompatJellybeanMr2.setClipBounds(view2, rect);
        }

        @Override // android.support.v4.view.ViewCompat.BaseViewCompatImpl, android.support.v4.view.ViewCompat.ViewCompatImpl
        public Rect getClipBounds(View view2) {
            return ViewCompatJellybeanMr2.getClipBounds(view2);
        }

        @Override // android.support.v4.view.ViewCompat.BaseViewCompatImpl, android.support.v4.view.ViewCompat.ViewCompatImpl
        public boolean isInLayout(View view2) {
            return ViewCompatJellybeanMr2.isInLayout(view2);
        }
    }

    /* loaded from: classes2.dex */
    static class KitKatViewCompatImpl extends JbMr2ViewCompatImpl {
        KitKatViewCompatImpl() {
        }

        @Override // android.support.v4.view.ViewCompat.BaseViewCompatImpl, android.support.v4.view.ViewCompat.ViewCompatImpl
        public int getAccessibilityLiveRegion(View view2) {
            return ViewCompatKitKat.getAccessibilityLiveRegion(view2);
        }

        @Override // android.support.v4.view.ViewCompat.BaseViewCompatImpl, android.support.v4.view.ViewCompat.ViewCompatImpl
        public void setAccessibilityLiveRegion(View view2, int i) {
            ViewCompatKitKat.setAccessibilityLiveRegion(view2, i);
        }

        @Override // android.support.v4.view.ViewCompat.JBViewCompatImpl, android.support.v4.view.ViewCompat.BaseViewCompatImpl, android.support.v4.view.ViewCompat.ViewCompatImpl
        public void setImportantForAccessibility(View view2, int i) {
            ViewCompatJB.setImportantForAccessibility(view2, i);
        }

        @Override // android.support.v4.view.ViewCompat.BaseViewCompatImpl, android.support.v4.view.ViewCompat.ViewCompatImpl
        public boolean isLaidOut(View view2) {
            return ViewCompatKitKat.isLaidOut(view2);
        }

        @Override // android.support.v4.view.ViewCompat.BaseViewCompatImpl, android.support.v4.view.ViewCompat.ViewCompatImpl
        public boolean isLayoutDirectionResolved(View view2) {
            return ViewCompatKitKat.isLayoutDirectionResolved(view2);
        }

        @Override // android.support.v4.view.ViewCompat.BaseViewCompatImpl, android.support.v4.view.ViewCompat.ViewCompatImpl
        public boolean isAttachedToWindow(View view2) {
            return ViewCompatKitKat.isAttachedToWindow(view2);
        }
    }

    /* loaded from: classes2.dex */
    static class LollipopViewCompatImpl extends KitKatViewCompatImpl {
        LollipopViewCompatImpl() {
        }

        @Override // android.support.v4.view.ViewCompat.BaseViewCompatImpl, android.support.v4.view.ViewCompat.ViewCompatImpl
        public void setTransitionName(View view2, String str) {
            ViewCompatLollipop.setTransitionName(view2, str);
        }

        @Override // android.support.v4.view.ViewCompat.BaseViewCompatImpl, android.support.v4.view.ViewCompat.ViewCompatImpl
        public String getTransitionName(View view2) {
            return ViewCompatLollipop.getTransitionName(view2);
        }

        @Override // android.support.v4.view.ViewCompat.JBViewCompatImpl, android.support.v4.view.ViewCompat.BaseViewCompatImpl, android.support.v4.view.ViewCompat.ViewCompatImpl
        public void requestApplyInsets(View view2) {
            ViewCompatLollipop.requestApplyInsets(view2);
        }

        @Override // android.support.v4.view.ViewCompat.BaseViewCompatImpl, android.support.v4.view.ViewCompat.ViewCompatImpl
        public void setElevation(View view2, float f) {
            ViewCompatLollipop.setElevation(view2, f);
        }

        @Override // android.support.v4.view.ViewCompat.BaseViewCompatImpl, android.support.v4.view.ViewCompat.ViewCompatImpl
        public float getElevation(View view2) {
            return ViewCompatLollipop.getElevation(view2);
        }

        @Override // android.support.v4.view.ViewCompat.BaseViewCompatImpl, android.support.v4.view.ViewCompat.ViewCompatImpl
        public void setTranslationZ(View view2, float f) {
            ViewCompatLollipop.setTranslationZ(view2, f);
        }

        @Override // android.support.v4.view.ViewCompat.BaseViewCompatImpl, android.support.v4.view.ViewCompat.ViewCompatImpl
        public float getTranslationZ(View view2) {
            return ViewCompatLollipop.getTranslationZ(view2);
        }

        @Override // android.support.v4.view.ViewCompat.BaseViewCompatImpl, android.support.v4.view.ViewCompat.ViewCompatImpl
        public void setOnApplyWindowInsetsListener(View view2, final OnApplyWindowInsetsListener onApplyWindowInsetsListener) {
            if (onApplyWindowInsetsListener == null) {
                ViewCompatLollipop.setOnApplyWindowInsetsListener(view2, null);
            } else {
                ViewCompatLollipop.setOnApplyWindowInsetsListener(view2, new ViewCompatLollipop.OnApplyWindowInsetsListenerBridge() { // from class: android.support.v4.view.ViewCompat.LollipopViewCompatImpl.1
                    @Override // android.support.v4.view.ViewCompatLollipop.OnApplyWindowInsetsListenerBridge
                    public Object onApplyWindowInsets(View view3, Object obj) {
                        return WindowInsetsCompat.unwrap(onApplyWindowInsetsListener.onApplyWindowInsets(view3, WindowInsetsCompat.wrap(obj)));
                    }
                });
            }
        }

        @Override // android.support.v4.view.ViewCompat.BaseViewCompatImpl, android.support.v4.view.ViewCompat.ViewCompatImpl
        public void setNestedScrollingEnabled(View view2, boolean z) {
            ViewCompatLollipop.setNestedScrollingEnabled(view2, z);
        }

        @Override // android.support.v4.view.ViewCompat.BaseViewCompatImpl, android.support.v4.view.ViewCompat.ViewCompatImpl
        public boolean isNestedScrollingEnabled(View view2) {
            return ViewCompatLollipop.isNestedScrollingEnabled(view2);
        }

        @Override // android.support.v4.view.ViewCompat.BaseViewCompatImpl, android.support.v4.view.ViewCompat.ViewCompatImpl
        public boolean startNestedScroll(View view2, int i) {
            return ViewCompatLollipop.startNestedScroll(view2, i);
        }

        @Override // android.support.v4.view.ViewCompat.BaseViewCompatImpl, android.support.v4.view.ViewCompat.ViewCompatImpl
        public void stopNestedScroll(View view2) {
            ViewCompatLollipop.stopNestedScroll(view2);
        }

        @Override // android.support.v4.view.ViewCompat.BaseViewCompatImpl, android.support.v4.view.ViewCompat.ViewCompatImpl
        public boolean hasNestedScrollingParent(View view2) {
            return ViewCompatLollipop.hasNestedScrollingParent(view2);
        }

        @Override // android.support.v4.view.ViewCompat.BaseViewCompatImpl, android.support.v4.view.ViewCompat.ViewCompatImpl
        public boolean dispatchNestedScroll(View view2, int i, int i2, int i3, int i4, int[] iArr) {
            return ViewCompatLollipop.dispatchNestedScroll(view2, i, i2, i3, i4, iArr);
        }

        @Override // android.support.v4.view.ViewCompat.BaseViewCompatImpl, android.support.v4.view.ViewCompat.ViewCompatImpl
        public boolean dispatchNestedPreScroll(View view2, int i, int i2, int[] iArr, int[] iArr2) {
            return ViewCompatLollipop.dispatchNestedPreScroll(view2, i, i2, iArr, iArr2);
        }

        @Override // android.support.v4.view.ViewCompat.BaseViewCompatImpl, android.support.v4.view.ViewCompat.ViewCompatImpl
        public boolean dispatchNestedFling(View view2, float f, float f2, boolean z) {
            return ViewCompatLollipop.dispatchNestedFling(view2, f, f2, z);
        }

        @Override // android.support.v4.view.ViewCompat.BaseViewCompatImpl, android.support.v4.view.ViewCompat.ViewCompatImpl
        public boolean dispatchNestedPreFling(View view2, float f, float f2) {
            return ViewCompatLollipop.dispatchNestedPreFling(view2, f, f2);
        }

        @Override // android.support.v4.view.ViewCompat.BaseViewCompatImpl, android.support.v4.view.ViewCompat.ViewCompatImpl
        public boolean isImportantForAccessibility(View view2) {
            return ViewCompatLollipop.isImportantForAccessibility(view2);
        }

        @Override // android.support.v4.view.ViewCompat.BaseViewCompatImpl, android.support.v4.view.ViewCompat.ViewCompatImpl
        public ColorStateList getBackgroundTintList(View view2) {
            return ViewCompatLollipop.getBackgroundTintList(view2);
        }

        @Override // android.support.v4.view.ViewCompat.BaseViewCompatImpl, android.support.v4.view.ViewCompat.ViewCompatImpl
        public void setBackgroundTintList(View view2, ColorStateList colorStateList) {
            ViewCompatLollipop.setBackgroundTintList(view2, colorStateList);
        }

        @Override // android.support.v4.view.ViewCompat.BaseViewCompatImpl, android.support.v4.view.ViewCompat.ViewCompatImpl
        public void setBackgroundTintMode(View view2, PorterDuff.Mode mode) {
            ViewCompatLollipop.setBackgroundTintMode(view2, mode);
        }

        @Override // android.support.v4.view.ViewCompat.BaseViewCompatImpl, android.support.v4.view.ViewCompat.ViewCompatImpl
        public PorterDuff.Mode getBackgroundTintMode(View view2) {
            return ViewCompatLollipop.getBackgroundTintMode(view2);
        }

        @Override // android.support.v4.view.ViewCompat.BaseViewCompatImpl, android.support.v4.view.ViewCompat.ViewCompatImpl
        public WindowInsetsCompat onApplyWindowInsets(View view2, WindowInsetsCompat windowInsetsCompat) {
            return WindowInsetsCompat.wrap(ViewCompatLollipop.onApplyWindowInsets(view2, WindowInsetsCompat.unwrap(windowInsetsCompat)));
        }

        @Override // android.support.v4.view.ViewCompat.BaseViewCompatImpl, android.support.v4.view.ViewCompat.ViewCompatImpl
        public WindowInsetsCompat dispatchApplyWindowInsets(View view2, WindowInsetsCompat windowInsetsCompat) {
            return WindowInsetsCompat.wrap(ViewCompatLollipop.dispatchApplyWindowInsets(view2, WindowInsetsCompat.unwrap(windowInsetsCompat)));
        }

        @Override // android.support.v4.view.ViewCompat.BaseViewCompatImpl, android.support.v4.view.ViewCompat.ViewCompatImpl
        public float getZ(View view2) {
            return ViewCompatLollipop.getZ(view2);
        }

        @Override // android.support.v4.view.ViewCompat.BaseViewCompatImpl, android.support.v4.view.ViewCompat.ViewCompatImpl
        public void setZ(View view2, float f) {
            ViewCompatLollipop.setZ(view2, f);
        }

        @Override // android.support.v4.view.ViewCompat.HCViewCompatImpl, android.support.v4.view.ViewCompat.BaseViewCompatImpl, android.support.v4.view.ViewCompat.ViewCompatImpl
        public void offsetLeftAndRight(View view2, int i) {
            ViewCompatLollipop.offsetLeftAndRight(view2, i);
        }

        @Override // android.support.v4.view.ViewCompat.HCViewCompatImpl, android.support.v4.view.ViewCompat.BaseViewCompatImpl, android.support.v4.view.ViewCompat.ViewCompatImpl
        public void offsetTopAndBottom(View view2, int i) {
            ViewCompatLollipop.offsetTopAndBottom(view2, i);
        }
    }

    /* loaded from: classes2.dex */
    static class MarshmallowViewCompatImpl extends LollipopViewCompatImpl {
        MarshmallowViewCompatImpl() {
        }

        @Override // android.support.v4.view.ViewCompat.BaseViewCompatImpl, android.support.v4.view.ViewCompat.ViewCompatImpl
        public void setScrollIndicators(View view2, int i) {
            ViewCompatMarshmallow.setScrollIndicators(view2, i);
        }

        @Override // android.support.v4.view.ViewCompat.BaseViewCompatImpl, android.support.v4.view.ViewCompat.ViewCompatImpl
        public void setScrollIndicators(View view2, int i, int i2) {
            ViewCompatMarshmallow.setScrollIndicators(view2, i, i2);
        }

        @Override // android.support.v4.view.ViewCompat.BaseViewCompatImpl, android.support.v4.view.ViewCompat.ViewCompatImpl
        public int getScrollIndicators(View view2) {
            return ViewCompatMarshmallow.getScrollIndicators(view2);
        }

        @Override // android.support.v4.view.ViewCompat.LollipopViewCompatImpl, android.support.v4.view.ViewCompat.HCViewCompatImpl, android.support.v4.view.ViewCompat.BaseViewCompatImpl, android.support.v4.view.ViewCompat.ViewCompatImpl
        public void offsetLeftAndRight(View view2, int i) {
            ViewCompatMarshmallow.offsetLeftAndRight(view2, i);
        }

        @Override // android.support.v4.view.ViewCompat.LollipopViewCompatImpl, android.support.v4.view.ViewCompat.HCViewCompatImpl, android.support.v4.view.ViewCompat.BaseViewCompatImpl, android.support.v4.view.ViewCompat.ViewCompatImpl
        public void offsetTopAndBottom(View view2, int i) {
            ViewCompatMarshmallow.offsetTopAndBottom(view2, i);
        }
    }

    /* loaded from: classes2.dex */
    static class Api24ViewCompatImpl extends MarshmallowViewCompatImpl {
        Api24ViewCompatImpl() {
        }

        @Override // android.support.v4.view.ViewCompat.BaseViewCompatImpl, android.support.v4.view.ViewCompat.ViewCompatImpl
        public void setPointerIcon(View view2, PointerIconCompat pointerIconCompat) {
            ViewCompatApi24.setPointerIcon(view2, pointerIconCompat.getPointerIcon());
        }
    }

    static {
        int i = Build.VERSION.SDK_INT;
        if (BuildCompat.isAtLeastN()) {
            IMPL = new Api24ViewCompatImpl();
        } else if (i >= 23) {
            IMPL = new MarshmallowViewCompatImpl();
        } else if (i >= 21) {
            IMPL = new LollipopViewCompatImpl();
        } else if (i >= 19) {
            IMPL = new KitKatViewCompatImpl();
        } else if (i >= 18) {
            IMPL = new JbMr2ViewCompatImpl();
        } else if (i >= 17) {
            IMPL = new JbMr1ViewCompatImpl();
        } else if (i >= 16) {
            IMPL = new JBViewCompatImpl();
        } else if (i >= 15) {
            IMPL = new ICSMr1ViewCompatImpl();
        } else if (i >= 14) {
            IMPL = new ICSViewCompatImpl();
        } else if (i >= 11) {
            IMPL = new HCViewCompatImpl();
        } else {
            IMPL = new BaseViewCompatImpl();
        }
    }

    public static boolean canScrollHorizontally(View view2, int i) {
        return IMPL.canScrollHorizontally(view2, i);
    }

    public static boolean canScrollVertically(View view2, int i) {
        return IMPL.canScrollVertically(view2, i);
    }

    @Deprecated
    public static int getOverScrollMode(View view2) {
        return view2.getOverScrollMode();
    }

    @Deprecated
    public static void setOverScrollMode(View view2, int i) {
        view2.setOverScrollMode(i);
    }

    public static void onPopulateAccessibilityEvent(View view2, AccessibilityEvent accessibilityEvent) {
        IMPL.onPopulateAccessibilityEvent(view2, accessibilityEvent);
    }

    public static void onInitializeAccessibilityEvent(View view2, AccessibilityEvent accessibilityEvent) {
        IMPL.onInitializeAccessibilityEvent(view2, accessibilityEvent);
    }

    public static void onInitializeAccessibilityNodeInfo(View view2, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        IMPL.onInitializeAccessibilityNodeInfo(view2, accessibilityNodeInfoCompat);
    }

    public static void setAccessibilityDelegate(View view2, AccessibilityDelegateCompat accessibilityDelegateCompat) {
        IMPL.setAccessibilityDelegate(view2, accessibilityDelegateCompat);
    }

    public static boolean hasAccessibilityDelegate(View view2) {
        return IMPL.hasAccessibilityDelegate(view2);
    }

    public static boolean hasTransientState(View view2) {
        return IMPL.hasTransientState(view2);
    }

    public static void setHasTransientState(View view2, boolean z) {
        IMPL.setHasTransientState(view2, z);
    }

    public static void postInvalidateOnAnimation(View view2) {
        IMPL.postInvalidateOnAnimation(view2);
    }

    public static void postInvalidateOnAnimation(View view2, int i, int i2, int i3, int i4) {
        IMPL.postInvalidateOnAnimation(view2, i, i2, i3, i4);
    }

    public static void postOnAnimation(View view2, Runnable runnable) {
        IMPL.postOnAnimation(view2, runnable);
    }

    public static void postOnAnimationDelayed(View view2, Runnable runnable, long j) {
        IMPL.postOnAnimationDelayed(view2, runnable, j);
    }

    public static int getImportantForAccessibility(View view2) {
        return IMPL.getImportantForAccessibility(view2);
    }

    public static void setImportantForAccessibility(View view2, int i) {
        IMPL.setImportantForAccessibility(view2, i);
    }

    public static boolean isImportantForAccessibility(View view2) {
        return IMPL.isImportantForAccessibility(view2);
    }

    public static boolean performAccessibilityAction(View view2, int i, Bundle bundle) {
        return IMPL.performAccessibilityAction(view2, i, bundle);
    }

    public static AccessibilityNodeProviderCompat getAccessibilityNodeProvider(View view2) {
        return IMPL.getAccessibilityNodeProvider(view2);
    }

    public static float getAlpha(View view2) {
        return IMPL.getAlpha(view2);
    }

    public static void setLayerType(View view2, int i, Paint paint) {
        IMPL.setLayerType(view2, i, paint);
    }

    public static int getLayerType(View view2) {
        return IMPL.getLayerType(view2);
    }

    public static int getLabelFor(View view2) {
        return IMPL.getLabelFor(view2);
    }

    public static void setLabelFor(View view2, @IdRes int i) {
        IMPL.setLabelFor(view2, i);
    }

    public static void setLayerPaint(View view2, Paint paint) {
        IMPL.setLayerPaint(view2, paint);
    }

    public static int getLayoutDirection(View view2) {
        return IMPL.getLayoutDirection(view2);
    }

    public static void setLayoutDirection(View view2, int i) {
        IMPL.setLayoutDirection(view2, i);
    }

    public static ViewParent getParentForAccessibility(View view2) {
        return IMPL.getParentForAccessibility(view2);
    }

    @Deprecated
    public static boolean isOpaque(View view2) {
        return view2.isOpaque();
    }

    public static int resolveSizeAndState(int i, int i2, int i3) {
        return IMPL.resolveSizeAndState(i, i2, i3);
    }

    public static int getMeasuredWidthAndState(View view2) {
        return IMPL.getMeasuredWidthAndState(view2);
    }

    public static int getMeasuredHeightAndState(View view2) {
        return IMPL.getMeasuredHeightAndState(view2);
    }

    public static int getMeasuredState(View view2) {
        return IMPL.getMeasuredState(view2);
    }

    public static int combineMeasuredStates(int i, int i2) {
        return IMPL.combineMeasuredStates(i, i2);
    }

    public static int getAccessibilityLiveRegion(View view2) {
        return IMPL.getAccessibilityLiveRegion(view2);
    }

    public static void setAccessibilityLiveRegion(View view2, int i) {
        IMPL.setAccessibilityLiveRegion(view2, i);
    }

    public static int getPaddingStart(View view2) {
        return IMPL.getPaddingStart(view2);
    }

    public static int getPaddingEnd(View view2) {
        return IMPL.getPaddingEnd(view2);
    }

    public static void setPaddingRelative(View view2, int i, int i2, int i3, int i4) {
        IMPL.setPaddingRelative(view2, i, i2, i3, i4);
    }

    public static void dispatchStartTemporaryDetach(View view2) {
        IMPL.dispatchStartTemporaryDetach(view2);
    }

    public static void dispatchFinishTemporaryDetach(View view2) {
        IMPL.dispatchFinishTemporaryDetach(view2);
    }

    public static float getTranslationX(View view2) {
        return IMPL.getTranslationX(view2);
    }

    public static float getTranslationY(View view2) {
        return IMPL.getTranslationY(view2);
    }

    @Nullable
    public static Matrix getMatrix(View view2) {
        return IMPL.getMatrix(view2);
    }

    public static int getMinimumWidth(View view2) {
        return IMPL.getMinimumWidth(view2);
    }

    public static int getMinimumHeight(View view2) {
        return IMPL.getMinimumHeight(view2);
    }

    public static ViewPropertyAnimatorCompat animate(View view2) {
        return IMPL.animate(view2);
    }

    public static void setTranslationX(View view2, float f) {
        IMPL.setTranslationX(view2, f);
    }

    public static void setTranslationY(View view2, float f) {
        IMPL.setTranslationY(view2, f);
    }

    public static void setAlpha(View view2, @FloatRange(from = 0.0d, to = 1.0d) float f) {
        IMPL.setAlpha(view2, f);
    }

    public static void setX(View view2, float f) {
        IMPL.setX(view2, f);
    }

    public static void setY(View view2, float f) {
        IMPL.setY(view2, f);
    }

    public static void setRotation(View view2, float f) {
        IMPL.setRotation(view2, f);
    }

    public static void setRotationX(View view2, float f) {
        IMPL.setRotationX(view2, f);
    }

    public static void setRotationY(View view2, float f) {
        IMPL.setRotationY(view2, f);
    }

    public static void setScaleX(View view2, float f) {
        IMPL.setScaleX(view2, f);
    }

    public static void setScaleY(View view2, float f) {
        IMPL.setScaleY(view2, f);
    }

    public static float getPivotX(View view2) {
        return IMPL.getPivotX(view2);
    }

    public static void setPivotX(View view2, float f) {
        IMPL.setPivotX(view2, f);
    }

    public static float getPivotY(View view2) {
        return IMPL.getPivotY(view2);
    }

    public static void setPivotY(View view2, float f) {
        IMPL.setPivotY(view2, f);
    }

    public static float getRotation(View view2) {
        return IMPL.getRotation(view2);
    }

    public static float getRotationX(View view2) {
        return IMPL.getRotationX(view2);
    }

    public static float getRotationY(View view2) {
        return IMPL.getRotationY(view2);
    }

    public static float getScaleX(View view2) {
        return IMPL.getScaleX(view2);
    }

    public static float getScaleY(View view2) {
        return IMPL.getScaleY(view2);
    }

    public static float getX(View view2) {
        return IMPL.getX(view2);
    }

    public static float getY(View view2) {
        return IMPL.getY(view2);
    }

    public static void setElevation(View view2, float f) {
        IMPL.setElevation(view2, f);
    }

    public static float getElevation(View view2) {
        return IMPL.getElevation(view2);
    }

    public static void setTranslationZ(View view2, float f) {
        IMPL.setTranslationZ(view2, f);
    }

    public static float getTranslationZ(View view2) {
        return IMPL.getTranslationZ(view2);
    }

    public static void setTransitionName(View view2, String str) {
        IMPL.setTransitionName(view2, str);
    }

    public static String getTransitionName(View view2) {
        return IMPL.getTransitionName(view2);
    }

    public static int getWindowSystemUiVisibility(View view2) {
        return IMPL.getWindowSystemUiVisibility(view2);
    }

    public static void requestApplyInsets(View view2) {
        IMPL.requestApplyInsets(view2);
    }

    public static void setChildrenDrawingOrderEnabled(ViewGroup viewGroup, boolean z) {
        IMPL.setChildrenDrawingOrderEnabled(viewGroup, z);
    }

    public static boolean getFitsSystemWindows(View view2) {
        return IMPL.getFitsSystemWindows(view2);
    }

    public static void setFitsSystemWindows(View view2, boolean z) {
        IMPL.setFitsSystemWindows(view2, z);
    }

    public static void jumpDrawablesToCurrentState(View view2) {
        IMPL.jumpDrawablesToCurrentState(view2);
    }

    public static void setOnApplyWindowInsetsListener(View view2, OnApplyWindowInsetsListener onApplyWindowInsetsListener) {
        IMPL.setOnApplyWindowInsetsListener(view2, onApplyWindowInsetsListener);
    }

    public static WindowInsetsCompat onApplyWindowInsets(View view2, WindowInsetsCompat windowInsetsCompat) {
        return IMPL.onApplyWindowInsets(view2, windowInsetsCompat);
    }

    public static WindowInsetsCompat dispatchApplyWindowInsets(View view2, WindowInsetsCompat windowInsetsCompat) {
        return IMPL.dispatchApplyWindowInsets(view2, windowInsetsCompat);
    }

    public static void setSaveFromParentEnabled(View view2, boolean z) {
        IMPL.setSaveFromParentEnabled(view2, z);
    }

    public static void setActivated(View view2, boolean z) {
        IMPL.setActivated(view2, z);
    }

    public static boolean hasOverlappingRendering(View view2) {
        return IMPL.hasOverlappingRendering(view2);
    }

    public static boolean isPaddingRelative(View view2) {
        return IMPL.isPaddingRelative(view2);
    }

    public static void setBackground(View view2, Drawable drawable) {
        IMPL.setBackground(view2, drawable);
    }

    public static ColorStateList getBackgroundTintList(View view2) {
        return IMPL.getBackgroundTintList(view2);
    }

    public static void setBackgroundTintList(View view2, ColorStateList colorStateList) {
        IMPL.setBackgroundTintList(view2, colorStateList);
    }

    public static PorterDuff.Mode getBackgroundTintMode(View view2) {
        return IMPL.getBackgroundTintMode(view2);
    }

    public static void setBackgroundTintMode(View view2, PorterDuff.Mode mode) {
        IMPL.setBackgroundTintMode(view2, mode);
    }

    public static void setNestedScrollingEnabled(View view2, boolean z) {
        IMPL.setNestedScrollingEnabled(view2, z);
    }

    public static boolean isNestedScrollingEnabled(View view2) {
        return IMPL.isNestedScrollingEnabled(view2);
    }

    public static boolean startNestedScroll(View view2, int i) {
        return IMPL.startNestedScroll(view2, i);
    }

    public static void stopNestedScroll(View view2) {
        IMPL.stopNestedScroll(view2);
    }

    public static boolean hasNestedScrollingParent(View view2) {
        return IMPL.hasNestedScrollingParent(view2);
    }

    public static boolean dispatchNestedScroll(View view2, int i, int i2, int i3, int i4, int[] iArr) {
        return IMPL.dispatchNestedScroll(view2, i, i2, i3, i4, iArr);
    }

    public static boolean dispatchNestedPreScroll(View view2, int i, int i2, int[] iArr, int[] iArr2) {
        return IMPL.dispatchNestedPreScroll(view2, i, i2, iArr, iArr2);
    }

    public static boolean dispatchNestedFling(View view2, float f, float f2, boolean z) {
        return IMPL.dispatchNestedFling(view2, f, f2, z);
    }

    public static boolean dispatchNestedPreFling(View view2, float f, float f2) {
        return IMPL.dispatchNestedPreFling(view2, f, f2);
    }

    public static boolean isInLayout(View view2) {
        return IMPL.isInLayout(view2);
    }

    public static boolean isLaidOut(View view2) {
        return IMPL.isLaidOut(view2);
    }

    public static boolean isLayoutDirectionResolved(View view2) {
        return IMPL.isLayoutDirectionResolved(view2);
    }

    public static float getZ(View view2) {
        return IMPL.getZ(view2);
    }

    public static void setZ(View view2, float f) {
        IMPL.setZ(view2, f);
    }

    public static void offsetTopAndBottom(View view2, int i) {
        IMPL.offsetTopAndBottom(view2, i);
    }

    public static void offsetLeftAndRight(View view2, int i) {
        IMPL.offsetLeftAndRight(view2, i);
    }

    public static void setClipBounds(View view2, Rect rect) {
        IMPL.setClipBounds(view2, rect);
    }

    public static Rect getClipBounds(View view2) {
        return IMPL.getClipBounds(view2);
    }

    public static boolean isAttachedToWindow(View view2) {
        return IMPL.isAttachedToWindow(view2);
    }

    public static boolean hasOnClickListeners(View view2) {
        return IMPL.hasOnClickListeners(view2);
    }

    public static void setScrollIndicators(@NonNull View view2, int i) {
        IMPL.setScrollIndicators(view2, i);
    }

    public static void setScrollIndicators(@NonNull View view2, int i, int i2) {
        IMPL.setScrollIndicators(view2, i, i2);
    }

    public static int getScrollIndicators(@NonNull View view2) {
        return IMPL.getScrollIndicators(view2);
    }

    public static void setPointerIcon(@NonNull View view2, PointerIconCompat pointerIconCompat) {
        IMPL.setPointerIcon(view2, pointerIconCompat);
    }

    public static Display getDisplay(@NonNull View view2) {
        return IMPL.getDisplay(view2);
    }

    protected ViewCompat() {
    }
}
