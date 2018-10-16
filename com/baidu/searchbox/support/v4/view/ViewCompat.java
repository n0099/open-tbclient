package com.baidu.searchbox.support.v4.view;

import android.content.res.ColorStateList;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.FloatRange;
import android.support.annotation.IdRes;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
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
    public static final int OVER_SCROLL_ALWAYS = 0;
    public static final int OVER_SCROLL_IF_CONTENT_SCROLLS = 1;
    public static final int OVER_SCROLL_NEVER = 2;
    public static final int SCROLL_AXIS_HORIZONTAL = 1;
    public static final int SCROLL_AXIS_NONE = 0;
    public static final int SCROLL_AXIS_VERTICAL = 2;
    private static final String TAG = "ViewCompat";

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public interface ViewCompatImpl {
        boolean canScrollHorizontally(View view, int i);

        boolean canScrollVertically(View view, int i);

        int combineMeasuredStates(int i, int i2);

        void dispatchFinishTemporaryDetach(View view);

        boolean dispatchNestedFling(View view, float f, float f2, boolean z);

        boolean dispatchNestedPreFling(View view, float f, float f2);

        boolean dispatchNestedPreScroll(View view, int i, int i2, int[] iArr, int[] iArr2);

        boolean dispatchNestedScroll(View view, int i, int i2, int i3, int i4, int[] iArr);

        void dispatchStartTemporaryDetach(View view);

        int getAccessibilityLiveRegion(View view);

        float getAlpha(View view);

        ColorStateList getBackgroundTintList(View view);

        PorterDuff.Mode getBackgroundTintMode(View view);

        Rect getClipBounds(View view);

        float getElevation(View view);

        boolean getFitsSystemWindows(View view);

        int getImportantForAccessibility(View view);

        int getLabelFor(View view);

        int getLayerType(View view);

        int getLayoutDirection(View view);

        int getMeasuredHeightAndState(View view);

        int getMeasuredState(View view);

        int getMeasuredWidthAndState(View view);

        int getMinimumHeight(View view);

        int getMinimumWidth(View view);

        int getOverScrollMode(View view);

        int getPaddingEnd(View view);

        int getPaddingStart(View view);

        ViewParent getParentForAccessibility(View view);

        float getPivotX(View view);

        float getPivotY(View view);

        float getRotation(View view);

        float getRotationX(View view);

        float getRotationY(View view);

        float getScaleX(View view);

        float getScaleY(View view);

        String getTransitionName(View view);

        float getTranslationX(View view);

        float getTranslationY(View view);

        float getTranslationZ(View view);

        int getWindowSystemUiVisibility(View view);

        float getX(View view);

        float getY(View view);

        float getZ(View view);

        boolean hasAccessibilityDelegate(View view);

        boolean hasNestedScrollingParent(View view);

        boolean hasOverlappingRendering(View view);

        boolean hasTransientState(View view);

        boolean isAttachedToWindow(View view);

        boolean isImportantForAccessibility(View view);

        boolean isLaidOut(View view);

        boolean isNestedScrollingEnabled(View view);

        boolean isOpaque(View view);

        boolean isPaddingRelative(View view);

        void jumpDrawablesToCurrentState(View view);

        void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent);

        void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent);

        boolean performAccessibilityAction(View view, int i, Bundle bundle);

        void postInvalidateOnAnimation(View view);

        void postInvalidateOnAnimation(View view, int i, int i2, int i3, int i4);

        void postOnAnimation(View view, Runnable runnable);

        void postOnAnimationDelayed(View view, Runnable runnable, long j);

        void requestApplyInsets(View view);

        int resolveSizeAndState(int i, int i2, int i3);

        void setAccessibilityLiveRegion(View view, int i);

        void setActivated(View view, boolean z);

        void setAlpha(View view, float f);

        void setBackgroundTintList(View view, ColorStateList colorStateList);

        void setBackgroundTintMode(View view, PorterDuff.Mode mode);

        void setChildrenDrawingOrderEnabled(ViewGroup viewGroup, boolean z);

        void setClipBounds(View view, Rect rect);

        void setElevation(View view, float f);

        void setFitsSystemWindows(View view, boolean z);

        void setHasTransientState(View view, boolean z);

        void setImportantForAccessibility(View view, int i);

        void setLabelFor(View view, int i);

        void setLayerPaint(View view, Paint paint);

        void setLayerType(View view, int i, Paint paint);

        void setLayoutDirection(View view, int i);

        void setNestedScrollingEnabled(View view, boolean z);

        void setOverScrollMode(View view, int i);

        void setPaddingRelative(View view, int i, int i2, int i3, int i4);

        void setPivotX(View view, float f);

        void setPivotY(View view, float f);

        void setRotation(View view, float f);

        void setRotationX(View view, float f);

        void setRotationY(View view, float f);

        void setSaveFromParentEnabled(View view, boolean z);

        void setScaleX(View view, float f);

        void setScaleY(View view, float f);

        void setTransitionName(View view, String str);

        void setTranslationX(View view, float f);

        void setTranslationY(View view, float f);

        void setTranslationZ(View view, float f);

        void setX(View view, float f);

        void setY(View view, float f);

        boolean startNestedScroll(View view, int i);

        void stopNestedScroll(View view);
    }

    /* loaded from: classes2.dex */
    static class BaseViewCompatImpl implements ViewCompatImpl {
        private Method mDispatchFinishTemporaryDetach;
        private Method mDispatchStartTemporaryDetach;
        private boolean mTempDetachBound;

        BaseViewCompatImpl() {
        }

        @Override // com.baidu.searchbox.support.v4.view.ViewCompat.ViewCompatImpl
        public boolean canScrollHorizontally(View view, int i) {
            return false;
        }

        @Override // com.baidu.searchbox.support.v4.view.ViewCompat.ViewCompatImpl
        public boolean canScrollVertically(View view, int i) {
            return false;
        }

        @Override // com.baidu.searchbox.support.v4.view.ViewCompat.ViewCompatImpl
        public int getOverScrollMode(View view) {
            return 2;
        }

        @Override // com.baidu.searchbox.support.v4.view.ViewCompat.ViewCompatImpl
        public void setOverScrollMode(View view, int i) {
        }

        @Override // com.baidu.searchbox.support.v4.view.ViewCompat.ViewCompatImpl
        public boolean hasAccessibilityDelegate(View view) {
            return false;
        }

        @Override // com.baidu.searchbox.support.v4.view.ViewCompat.ViewCompatImpl
        public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        }

        @Override // com.baidu.searchbox.support.v4.view.ViewCompat.ViewCompatImpl
        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        }

        @Override // com.baidu.searchbox.support.v4.view.ViewCompat.ViewCompatImpl
        public boolean hasTransientState(View view) {
            return false;
        }

        @Override // com.baidu.searchbox.support.v4.view.ViewCompat.ViewCompatImpl
        public void setHasTransientState(View view, boolean z) {
        }

        @Override // com.baidu.searchbox.support.v4.view.ViewCompat.ViewCompatImpl
        public void postInvalidateOnAnimation(View view) {
            view.invalidate();
        }

        @Override // com.baidu.searchbox.support.v4.view.ViewCompat.ViewCompatImpl
        public void postInvalidateOnAnimation(View view, int i, int i2, int i3, int i4) {
            view.invalidate(i, i2, i3, i4);
        }

        @Override // com.baidu.searchbox.support.v4.view.ViewCompat.ViewCompatImpl
        public void postOnAnimation(View view, Runnable runnable) {
            view.postDelayed(runnable, getFrameTime());
        }

        @Override // com.baidu.searchbox.support.v4.view.ViewCompat.ViewCompatImpl
        public void postOnAnimationDelayed(View view, Runnable runnable, long j) {
            view.postDelayed(runnable, getFrameTime() + j);
        }

        long getFrameTime() {
            return ViewCompat.FAKE_FRAME_TIME;
        }

        @Override // com.baidu.searchbox.support.v4.view.ViewCompat.ViewCompatImpl
        public int getImportantForAccessibility(View view) {
            return 0;
        }

        @Override // com.baidu.searchbox.support.v4.view.ViewCompat.ViewCompatImpl
        public void setImportantForAccessibility(View view, int i) {
        }

        @Override // com.baidu.searchbox.support.v4.view.ViewCompat.ViewCompatImpl
        public boolean isImportantForAccessibility(View view) {
            return true;
        }

        @Override // com.baidu.searchbox.support.v4.view.ViewCompat.ViewCompatImpl
        public boolean performAccessibilityAction(View view, int i, Bundle bundle) {
            return false;
        }

        @Override // com.baidu.searchbox.support.v4.view.ViewCompat.ViewCompatImpl
        public float getAlpha(View view) {
            return 1.0f;
        }

        @Override // com.baidu.searchbox.support.v4.view.ViewCompat.ViewCompatImpl
        public void setLayerType(View view, int i, Paint paint) {
        }

        @Override // com.baidu.searchbox.support.v4.view.ViewCompat.ViewCompatImpl
        public int getLayerType(View view) {
            return 0;
        }

        @Override // com.baidu.searchbox.support.v4.view.ViewCompat.ViewCompatImpl
        public int getLabelFor(View view) {
            return 0;
        }

        @Override // com.baidu.searchbox.support.v4.view.ViewCompat.ViewCompatImpl
        public void setLabelFor(View view, int i) {
        }

        @Override // com.baidu.searchbox.support.v4.view.ViewCompat.ViewCompatImpl
        public void setLayerPaint(View view, Paint paint) {
        }

        @Override // com.baidu.searchbox.support.v4.view.ViewCompat.ViewCompatImpl
        public int getLayoutDirection(View view) {
            return 0;
        }

        @Override // com.baidu.searchbox.support.v4.view.ViewCompat.ViewCompatImpl
        public void setLayoutDirection(View view, int i) {
        }

        @Override // com.baidu.searchbox.support.v4.view.ViewCompat.ViewCompatImpl
        public ViewParent getParentForAccessibility(View view) {
            return view.getParent();
        }

        @Override // com.baidu.searchbox.support.v4.view.ViewCompat.ViewCompatImpl
        public boolean isOpaque(View view) {
            Drawable background = view.getBackground();
            return background != null && background.getOpacity() == -1;
        }

        @Override // com.baidu.searchbox.support.v4.view.ViewCompat.ViewCompatImpl
        public int resolveSizeAndState(int i, int i2, int i3) {
            return View.resolveSize(i, i2);
        }

        @Override // com.baidu.searchbox.support.v4.view.ViewCompat.ViewCompatImpl
        public int getMeasuredWidthAndState(View view) {
            return view.getMeasuredWidth();
        }

        @Override // com.baidu.searchbox.support.v4.view.ViewCompat.ViewCompatImpl
        public int getMeasuredHeightAndState(View view) {
            return view.getMeasuredHeight();
        }

        @Override // com.baidu.searchbox.support.v4.view.ViewCompat.ViewCompatImpl
        public int getMeasuredState(View view) {
            return 0;
        }

        @Override // com.baidu.searchbox.support.v4.view.ViewCompat.ViewCompatImpl
        public int getAccessibilityLiveRegion(View view) {
            return 0;
        }

        @Override // com.baidu.searchbox.support.v4.view.ViewCompat.ViewCompatImpl
        public void setAccessibilityLiveRegion(View view, int i) {
        }

        @Override // com.baidu.searchbox.support.v4.view.ViewCompat.ViewCompatImpl
        public int getPaddingStart(View view) {
            return view.getPaddingLeft();
        }

        @Override // com.baidu.searchbox.support.v4.view.ViewCompat.ViewCompatImpl
        public int getPaddingEnd(View view) {
            return view.getPaddingRight();
        }

        @Override // com.baidu.searchbox.support.v4.view.ViewCompat.ViewCompatImpl
        public void setPaddingRelative(View view, int i, int i2, int i3, int i4) {
            view.setPadding(i, i2, i3, i4);
        }

        @Override // com.baidu.searchbox.support.v4.view.ViewCompat.ViewCompatImpl
        public void dispatchStartTemporaryDetach(View view) {
            if (!this.mTempDetachBound) {
                bindTempDetach();
            }
            if (this.mDispatchStartTemporaryDetach != null) {
                try {
                    this.mDispatchStartTemporaryDetach.invoke(view, new Object[0]);
                    return;
                } catch (Exception e) {
                    Log.d("ViewCompat", "Error calling dispatchStartTemporaryDetach", e);
                    return;
                }
            }
            view.onStartTemporaryDetach();
        }

        @Override // com.baidu.searchbox.support.v4.view.ViewCompat.ViewCompatImpl
        public void dispatchFinishTemporaryDetach(View view) {
            if (!this.mTempDetachBound) {
                bindTempDetach();
            }
            if (this.mDispatchFinishTemporaryDetach != null) {
                try {
                    this.mDispatchFinishTemporaryDetach.invoke(view, new Object[0]);
                    return;
                } catch (Exception e) {
                    Log.d("ViewCompat", "Error calling dispatchFinishTemporaryDetach", e);
                    return;
                }
            }
            view.onFinishTemporaryDetach();
        }

        @Override // com.baidu.searchbox.support.v4.view.ViewCompat.ViewCompatImpl
        public boolean hasOverlappingRendering(View view) {
            return true;
        }

        private void bindTempDetach() {
            try {
                this.mDispatchStartTemporaryDetach = View.class.getDeclaredMethod("dispatchStartTemporaryDetach", new Class[0]);
                this.mDispatchFinishTemporaryDetach = View.class.getDeclaredMethod("dispatchFinishTemporaryDetach", new Class[0]);
            } catch (NoSuchMethodException e) {
                Log.e("ViewCompat", "Couldn't find method", e);
            }
            this.mTempDetachBound = true;
        }

        @Override // com.baidu.searchbox.support.v4.view.ViewCompat.ViewCompatImpl
        public float getTranslationX(View view) {
            return 0.0f;
        }

        @Override // com.baidu.searchbox.support.v4.view.ViewCompat.ViewCompatImpl
        public float getTranslationY(View view) {
            return 0.0f;
        }

        @Override // com.baidu.searchbox.support.v4.view.ViewCompat.ViewCompatImpl
        public float getX(View view) {
            return 0.0f;
        }

        @Override // com.baidu.searchbox.support.v4.view.ViewCompat.ViewCompatImpl
        public float getY(View view) {
            return 0.0f;
        }

        @Override // com.baidu.searchbox.support.v4.view.ViewCompat.ViewCompatImpl
        public float getRotation(View view) {
            return 0.0f;
        }

        @Override // com.baidu.searchbox.support.v4.view.ViewCompat.ViewCompatImpl
        public float getRotationX(View view) {
            return 0.0f;
        }

        @Override // com.baidu.searchbox.support.v4.view.ViewCompat.ViewCompatImpl
        public float getRotationY(View view) {
            return 0.0f;
        }

        @Override // com.baidu.searchbox.support.v4.view.ViewCompat.ViewCompatImpl
        public float getScaleX(View view) {
            return 0.0f;
        }

        @Override // com.baidu.searchbox.support.v4.view.ViewCompat.ViewCompatImpl
        public float getScaleY(View view) {
            return 0.0f;
        }

        @Override // com.baidu.searchbox.support.v4.view.ViewCompat.ViewCompatImpl
        public int getMinimumWidth(View view) {
            return ViewCompatBase.getMinimumWidth(view);
        }

        @Override // com.baidu.searchbox.support.v4.view.ViewCompat.ViewCompatImpl
        public int getMinimumHeight(View view) {
            return ViewCompatBase.getMinimumHeight(view);
        }

        @Override // com.baidu.searchbox.support.v4.view.ViewCompat.ViewCompatImpl
        public void setRotation(View view, float f) {
        }

        @Override // com.baidu.searchbox.support.v4.view.ViewCompat.ViewCompatImpl
        public void setTranslationX(View view, float f) {
        }

        @Override // com.baidu.searchbox.support.v4.view.ViewCompat.ViewCompatImpl
        public void setTranslationY(View view, float f) {
        }

        @Override // com.baidu.searchbox.support.v4.view.ViewCompat.ViewCompatImpl
        public void setAlpha(View view, float f) {
        }

        @Override // com.baidu.searchbox.support.v4.view.ViewCompat.ViewCompatImpl
        public void setRotationX(View view, float f) {
        }

        @Override // com.baidu.searchbox.support.v4.view.ViewCompat.ViewCompatImpl
        public void setRotationY(View view, float f) {
        }

        @Override // com.baidu.searchbox.support.v4.view.ViewCompat.ViewCompatImpl
        public void setScaleX(View view, float f) {
        }

        @Override // com.baidu.searchbox.support.v4.view.ViewCompat.ViewCompatImpl
        public void setScaleY(View view, float f) {
        }

        @Override // com.baidu.searchbox.support.v4.view.ViewCompat.ViewCompatImpl
        public void setX(View view, float f) {
        }

        @Override // com.baidu.searchbox.support.v4.view.ViewCompat.ViewCompatImpl
        public void setY(View view, float f) {
        }

        @Override // com.baidu.searchbox.support.v4.view.ViewCompat.ViewCompatImpl
        public void setPivotX(View view, float f) {
        }

        @Override // com.baidu.searchbox.support.v4.view.ViewCompat.ViewCompatImpl
        public void setPivotY(View view, float f) {
        }

        @Override // com.baidu.searchbox.support.v4.view.ViewCompat.ViewCompatImpl
        public float getPivotX(View view) {
            return 0.0f;
        }

        @Override // com.baidu.searchbox.support.v4.view.ViewCompat.ViewCompatImpl
        public float getPivotY(View view) {
            return 0.0f;
        }

        @Override // com.baidu.searchbox.support.v4.view.ViewCompat.ViewCompatImpl
        public void setTransitionName(View view, String str) {
        }

        @Override // com.baidu.searchbox.support.v4.view.ViewCompat.ViewCompatImpl
        public String getTransitionName(View view) {
            return null;
        }

        @Override // com.baidu.searchbox.support.v4.view.ViewCompat.ViewCompatImpl
        public int getWindowSystemUiVisibility(View view) {
            return 0;
        }

        @Override // com.baidu.searchbox.support.v4.view.ViewCompat.ViewCompatImpl
        public void requestApplyInsets(View view) {
        }

        @Override // com.baidu.searchbox.support.v4.view.ViewCompat.ViewCompatImpl
        public void setElevation(View view, float f) {
        }

        @Override // com.baidu.searchbox.support.v4.view.ViewCompat.ViewCompatImpl
        public float getElevation(View view) {
            return 0.0f;
        }

        @Override // com.baidu.searchbox.support.v4.view.ViewCompat.ViewCompatImpl
        public void setTranslationZ(View view, float f) {
        }

        @Override // com.baidu.searchbox.support.v4.view.ViewCompat.ViewCompatImpl
        public float getTranslationZ(View view) {
            return 0.0f;
        }

        @Override // com.baidu.searchbox.support.v4.view.ViewCompat.ViewCompatImpl
        public void setClipBounds(View view, Rect rect) {
        }

        @Override // com.baidu.searchbox.support.v4.view.ViewCompat.ViewCompatImpl
        public Rect getClipBounds(View view) {
            return null;
        }

        @Override // com.baidu.searchbox.support.v4.view.ViewCompat.ViewCompatImpl
        public void setChildrenDrawingOrderEnabled(ViewGroup viewGroup, boolean z) {
        }

        @Override // com.baidu.searchbox.support.v4.view.ViewCompat.ViewCompatImpl
        public boolean getFitsSystemWindows(View view) {
            return false;
        }

        @Override // com.baidu.searchbox.support.v4.view.ViewCompat.ViewCompatImpl
        public void setFitsSystemWindows(View view, boolean z) {
        }

        @Override // com.baidu.searchbox.support.v4.view.ViewCompat.ViewCompatImpl
        public void jumpDrawablesToCurrentState(View view) {
        }

        @Override // com.baidu.searchbox.support.v4.view.ViewCompat.ViewCompatImpl
        public void setSaveFromParentEnabled(View view, boolean z) {
        }

        @Override // com.baidu.searchbox.support.v4.view.ViewCompat.ViewCompatImpl
        public void setActivated(View view, boolean z) {
        }

        @Override // com.baidu.searchbox.support.v4.view.ViewCompat.ViewCompatImpl
        public boolean isPaddingRelative(View view) {
            return false;
        }

        @Override // com.baidu.searchbox.support.v4.view.ViewCompat.ViewCompatImpl
        public void setNestedScrollingEnabled(View view, boolean z) {
        }

        @Override // com.baidu.searchbox.support.v4.view.ViewCompat.ViewCompatImpl
        public boolean isNestedScrollingEnabled(View view) {
            return false;
        }

        @Override // com.baidu.searchbox.support.v4.view.ViewCompat.ViewCompatImpl
        public ColorStateList getBackgroundTintList(View view) {
            return ViewCompatBase.getBackgroundTintList(view);
        }

        @Override // com.baidu.searchbox.support.v4.view.ViewCompat.ViewCompatImpl
        public void setBackgroundTintList(View view, ColorStateList colorStateList) {
            ViewCompatBase.setBackgroundTintList(view, colorStateList);
        }

        @Override // com.baidu.searchbox.support.v4.view.ViewCompat.ViewCompatImpl
        public void setBackgroundTintMode(View view, PorterDuff.Mode mode) {
            ViewCompatBase.setBackgroundTintMode(view, mode);
        }

        @Override // com.baidu.searchbox.support.v4.view.ViewCompat.ViewCompatImpl
        public PorterDuff.Mode getBackgroundTintMode(View view) {
            return ViewCompatBase.getBackgroundTintMode(view);
        }

        @Override // com.baidu.searchbox.support.v4.view.ViewCompat.ViewCompatImpl
        public boolean startNestedScroll(View view, int i) {
            return false;
        }

        @Override // com.baidu.searchbox.support.v4.view.ViewCompat.ViewCompatImpl
        public void stopNestedScroll(View view) {
        }

        @Override // com.baidu.searchbox.support.v4.view.ViewCompat.ViewCompatImpl
        public boolean hasNestedScrollingParent(View view) {
            return false;
        }

        @Override // com.baidu.searchbox.support.v4.view.ViewCompat.ViewCompatImpl
        public boolean dispatchNestedScroll(View view, int i, int i2, int i3, int i4, int[] iArr) {
            return false;
        }

        @Override // com.baidu.searchbox.support.v4.view.ViewCompat.ViewCompatImpl
        public boolean dispatchNestedPreScroll(View view, int i, int i2, int[] iArr, int[] iArr2) {
            return false;
        }

        @Override // com.baidu.searchbox.support.v4.view.ViewCompat.ViewCompatImpl
        public boolean dispatchNestedFling(View view, float f, float f2, boolean z) {
            return false;
        }

        @Override // com.baidu.searchbox.support.v4.view.ViewCompat.ViewCompatImpl
        public boolean dispatchNestedPreFling(View view, float f, float f2) {
            return false;
        }

        @Override // com.baidu.searchbox.support.v4.view.ViewCompat.ViewCompatImpl
        public boolean isLaidOut(View view) {
            return ViewCompatBase.isLaidOut(view);
        }

        @Override // com.baidu.searchbox.support.v4.view.ViewCompat.ViewCompatImpl
        public int combineMeasuredStates(int i, int i2) {
            return i | i2;
        }

        @Override // com.baidu.searchbox.support.v4.view.ViewCompat.ViewCompatImpl
        public float getZ(View view) {
            return getTranslationZ(view) + getElevation(view);
        }

        @Override // com.baidu.searchbox.support.v4.view.ViewCompat.ViewCompatImpl
        public boolean isAttachedToWindow(View view) {
            return ViewCompatBase.isAttachedToWindow(view);
        }
    }

    /* loaded from: classes2.dex */
    static class EclairMr1ViewCompatImpl extends BaseViewCompatImpl {
        EclairMr1ViewCompatImpl() {
        }

        @Override // com.baidu.searchbox.support.v4.view.ViewCompat.BaseViewCompatImpl, com.baidu.searchbox.support.v4.view.ViewCompat.ViewCompatImpl
        public boolean isOpaque(View view) {
            return ViewCompatEclairMr1.isOpaque(view);
        }

        @Override // com.baidu.searchbox.support.v4.view.ViewCompat.BaseViewCompatImpl, com.baidu.searchbox.support.v4.view.ViewCompat.ViewCompatImpl
        public void setChildrenDrawingOrderEnabled(ViewGroup viewGroup, boolean z) {
            ViewCompatEclairMr1.setChildrenDrawingOrderEnabled(viewGroup, z);
        }
    }

    /* loaded from: classes2.dex */
    static class GBViewCompatImpl extends EclairMr1ViewCompatImpl {
        GBViewCompatImpl() {
        }

        @Override // com.baidu.searchbox.support.v4.view.ViewCompat.BaseViewCompatImpl, com.baidu.searchbox.support.v4.view.ViewCompat.ViewCompatImpl
        public int getOverScrollMode(View view) {
            return ViewCompatGingerbread.getOverScrollMode(view);
        }

        @Override // com.baidu.searchbox.support.v4.view.ViewCompat.BaseViewCompatImpl, com.baidu.searchbox.support.v4.view.ViewCompat.ViewCompatImpl
        public void setOverScrollMode(View view, int i) {
            ViewCompatGingerbread.setOverScrollMode(view, i);
        }
    }

    /* loaded from: classes2.dex */
    static class HCViewCompatImpl extends GBViewCompatImpl {
        HCViewCompatImpl() {
        }

        @Override // com.baidu.searchbox.support.v4.view.ViewCompat.BaseViewCompatImpl
        long getFrameTime() {
            return ViewCompatHC.getFrameTime();
        }

        @Override // com.baidu.searchbox.support.v4.view.ViewCompat.BaseViewCompatImpl, com.baidu.searchbox.support.v4.view.ViewCompat.ViewCompatImpl
        public float getAlpha(View view) {
            return ViewCompatHC.getAlpha(view);
        }

        @Override // com.baidu.searchbox.support.v4.view.ViewCompat.BaseViewCompatImpl, com.baidu.searchbox.support.v4.view.ViewCompat.ViewCompatImpl
        public void setLayerType(View view, int i, Paint paint) {
            ViewCompatHC.setLayerType(view, i, paint);
        }

        @Override // com.baidu.searchbox.support.v4.view.ViewCompat.BaseViewCompatImpl, com.baidu.searchbox.support.v4.view.ViewCompat.ViewCompatImpl
        public int getLayerType(View view) {
            return ViewCompatHC.getLayerType(view);
        }

        @Override // com.baidu.searchbox.support.v4.view.ViewCompat.BaseViewCompatImpl, com.baidu.searchbox.support.v4.view.ViewCompat.ViewCompatImpl
        public void setLayerPaint(View view, Paint paint) {
            setLayerType(view, getLayerType(view), paint);
            view.invalidate();
        }

        @Override // com.baidu.searchbox.support.v4.view.ViewCompat.BaseViewCompatImpl, com.baidu.searchbox.support.v4.view.ViewCompat.ViewCompatImpl
        public int resolveSizeAndState(int i, int i2, int i3) {
            return ViewCompatHC.resolveSizeAndState(i, i2, i3);
        }

        @Override // com.baidu.searchbox.support.v4.view.ViewCompat.BaseViewCompatImpl, com.baidu.searchbox.support.v4.view.ViewCompat.ViewCompatImpl
        public int getMeasuredWidthAndState(View view) {
            return ViewCompatHC.getMeasuredWidthAndState(view);
        }

        @Override // com.baidu.searchbox.support.v4.view.ViewCompat.BaseViewCompatImpl, com.baidu.searchbox.support.v4.view.ViewCompat.ViewCompatImpl
        public int getMeasuredHeightAndState(View view) {
            return ViewCompatHC.getMeasuredHeightAndState(view);
        }

        @Override // com.baidu.searchbox.support.v4.view.ViewCompat.BaseViewCompatImpl, com.baidu.searchbox.support.v4.view.ViewCompat.ViewCompatImpl
        public int getMeasuredState(View view) {
            return ViewCompatHC.getMeasuredState(view);
        }

        @Override // com.baidu.searchbox.support.v4.view.ViewCompat.BaseViewCompatImpl, com.baidu.searchbox.support.v4.view.ViewCompat.ViewCompatImpl
        public float getTranslationX(View view) {
            return ViewCompatHC.getTranslationX(view);
        }

        @Override // com.baidu.searchbox.support.v4.view.ViewCompat.BaseViewCompatImpl, com.baidu.searchbox.support.v4.view.ViewCompat.ViewCompatImpl
        public float getTranslationY(View view) {
            return ViewCompatHC.getTranslationY(view);
        }

        @Override // com.baidu.searchbox.support.v4.view.ViewCompat.BaseViewCompatImpl, com.baidu.searchbox.support.v4.view.ViewCompat.ViewCompatImpl
        public void setTranslationX(View view, float f) {
            ViewCompatHC.setTranslationX(view, f);
        }

        @Override // com.baidu.searchbox.support.v4.view.ViewCompat.BaseViewCompatImpl, com.baidu.searchbox.support.v4.view.ViewCompat.ViewCompatImpl
        public void setTranslationY(View view, float f) {
            ViewCompatHC.setTranslationY(view, f);
        }

        @Override // com.baidu.searchbox.support.v4.view.ViewCompat.BaseViewCompatImpl, com.baidu.searchbox.support.v4.view.ViewCompat.ViewCompatImpl
        public void setAlpha(View view, float f) {
            ViewCompatHC.setAlpha(view, f);
        }

        @Override // com.baidu.searchbox.support.v4.view.ViewCompat.BaseViewCompatImpl, com.baidu.searchbox.support.v4.view.ViewCompat.ViewCompatImpl
        public void setX(View view, float f) {
            ViewCompatHC.setX(view, f);
        }

        @Override // com.baidu.searchbox.support.v4.view.ViewCompat.BaseViewCompatImpl, com.baidu.searchbox.support.v4.view.ViewCompat.ViewCompatImpl
        public void setY(View view, float f) {
            ViewCompatHC.setY(view, f);
        }

        @Override // com.baidu.searchbox.support.v4.view.ViewCompat.BaseViewCompatImpl, com.baidu.searchbox.support.v4.view.ViewCompat.ViewCompatImpl
        public void setRotation(View view, float f) {
            ViewCompatHC.setRotation(view, f);
        }

        @Override // com.baidu.searchbox.support.v4.view.ViewCompat.BaseViewCompatImpl, com.baidu.searchbox.support.v4.view.ViewCompat.ViewCompatImpl
        public void setRotationX(View view, float f) {
            ViewCompatHC.setRotationX(view, f);
        }

        @Override // com.baidu.searchbox.support.v4.view.ViewCompat.BaseViewCompatImpl, com.baidu.searchbox.support.v4.view.ViewCompat.ViewCompatImpl
        public void setRotationY(View view, float f) {
            ViewCompatHC.setRotationY(view, f);
        }

        @Override // com.baidu.searchbox.support.v4.view.ViewCompat.BaseViewCompatImpl, com.baidu.searchbox.support.v4.view.ViewCompat.ViewCompatImpl
        public void setScaleX(View view, float f) {
            ViewCompatHC.setScaleX(view, f);
        }

        @Override // com.baidu.searchbox.support.v4.view.ViewCompat.BaseViewCompatImpl, com.baidu.searchbox.support.v4.view.ViewCompat.ViewCompatImpl
        public void setScaleY(View view, float f) {
            ViewCompatHC.setScaleY(view, f);
        }

        @Override // com.baidu.searchbox.support.v4.view.ViewCompat.BaseViewCompatImpl, com.baidu.searchbox.support.v4.view.ViewCompat.ViewCompatImpl
        public void setPivotX(View view, float f) {
            ViewCompatHC.setPivotX(view, f);
        }

        @Override // com.baidu.searchbox.support.v4.view.ViewCompat.BaseViewCompatImpl, com.baidu.searchbox.support.v4.view.ViewCompat.ViewCompatImpl
        public void setPivotY(View view, float f) {
            ViewCompatHC.setPivotY(view, f);
        }

        @Override // com.baidu.searchbox.support.v4.view.ViewCompat.BaseViewCompatImpl, com.baidu.searchbox.support.v4.view.ViewCompat.ViewCompatImpl
        public float getX(View view) {
            return ViewCompatHC.getX(view);
        }

        @Override // com.baidu.searchbox.support.v4.view.ViewCompat.BaseViewCompatImpl, com.baidu.searchbox.support.v4.view.ViewCompat.ViewCompatImpl
        public float getY(View view) {
            return ViewCompatHC.getY(view);
        }

        @Override // com.baidu.searchbox.support.v4.view.ViewCompat.BaseViewCompatImpl, com.baidu.searchbox.support.v4.view.ViewCompat.ViewCompatImpl
        public float getRotation(View view) {
            return ViewCompatHC.getRotation(view);
        }

        @Override // com.baidu.searchbox.support.v4.view.ViewCompat.BaseViewCompatImpl, com.baidu.searchbox.support.v4.view.ViewCompat.ViewCompatImpl
        public float getRotationX(View view) {
            return ViewCompatHC.getRotationX(view);
        }

        @Override // com.baidu.searchbox.support.v4.view.ViewCompat.BaseViewCompatImpl, com.baidu.searchbox.support.v4.view.ViewCompat.ViewCompatImpl
        public float getRotationY(View view) {
            return ViewCompatHC.getRotationY(view);
        }

        @Override // com.baidu.searchbox.support.v4.view.ViewCompat.BaseViewCompatImpl, com.baidu.searchbox.support.v4.view.ViewCompat.ViewCompatImpl
        public float getScaleX(View view) {
            return ViewCompatHC.getScaleX(view);
        }

        @Override // com.baidu.searchbox.support.v4.view.ViewCompat.BaseViewCompatImpl, com.baidu.searchbox.support.v4.view.ViewCompat.ViewCompatImpl
        public float getScaleY(View view) {
            return ViewCompatHC.getScaleY(view);
        }

        @Override // com.baidu.searchbox.support.v4.view.ViewCompat.BaseViewCompatImpl, com.baidu.searchbox.support.v4.view.ViewCompat.ViewCompatImpl
        public float getPivotX(View view) {
            return ViewCompatHC.getPivotX(view);
        }

        @Override // com.baidu.searchbox.support.v4.view.ViewCompat.BaseViewCompatImpl, com.baidu.searchbox.support.v4.view.ViewCompat.ViewCompatImpl
        public float getPivotY(View view) {
            return ViewCompatHC.getPivotY(view);
        }

        @Override // com.baidu.searchbox.support.v4.view.ViewCompat.BaseViewCompatImpl, com.baidu.searchbox.support.v4.view.ViewCompat.ViewCompatImpl
        public void jumpDrawablesToCurrentState(View view) {
            ViewCompatHC.jumpDrawablesToCurrentState(view);
        }

        @Override // com.baidu.searchbox.support.v4.view.ViewCompat.BaseViewCompatImpl, com.baidu.searchbox.support.v4.view.ViewCompat.ViewCompatImpl
        public void setSaveFromParentEnabled(View view, boolean z) {
            ViewCompatHC.setSaveFromParentEnabled(view, z);
        }

        @Override // com.baidu.searchbox.support.v4.view.ViewCompat.BaseViewCompatImpl, com.baidu.searchbox.support.v4.view.ViewCompat.ViewCompatImpl
        public void setActivated(View view, boolean z) {
            ViewCompatHC.setActivated(view, z);
        }

        @Override // com.baidu.searchbox.support.v4.view.ViewCompat.BaseViewCompatImpl, com.baidu.searchbox.support.v4.view.ViewCompat.ViewCompatImpl
        public int combineMeasuredStates(int i, int i2) {
            return ViewCompatHC.combineMeasuredStates(i, i2);
        }
    }

    /* loaded from: classes2.dex */
    static class ICSViewCompatImpl extends HCViewCompatImpl {
        static boolean accessibilityDelegateCheckFailed = false;
        static Field mAccessibilityDelegateField;

        ICSViewCompatImpl() {
        }

        @Override // com.baidu.searchbox.support.v4.view.ViewCompat.BaseViewCompatImpl, com.baidu.searchbox.support.v4.view.ViewCompat.ViewCompatImpl
        public boolean canScrollHorizontally(View view, int i) {
            return ViewCompatICS.canScrollHorizontally(view, i);
        }

        @Override // com.baidu.searchbox.support.v4.view.ViewCompat.BaseViewCompatImpl, com.baidu.searchbox.support.v4.view.ViewCompat.ViewCompatImpl
        public boolean canScrollVertically(View view, int i) {
            return ViewCompatICS.canScrollVertically(view, i);
        }

        @Override // com.baidu.searchbox.support.v4.view.ViewCompat.BaseViewCompatImpl, com.baidu.searchbox.support.v4.view.ViewCompat.ViewCompatImpl
        public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            ViewCompatICS.onPopulateAccessibilityEvent(view, accessibilityEvent);
        }

        @Override // com.baidu.searchbox.support.v4.view.ViewCompat.BaseViewCompatImpl, com.baidu.searchbox.support.v4.view.ViewCompat.ViewCompatImpl
        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            ViewCompatICS.onInitializeAccessibilityEvent(view, accessibilityEvent);
        }

        @Override // com.baidu.searchbox.support.v4.view.ViewCompat.BaseViewCompatImpl, com.baidu.searchbox.support.v4.view.ViewCompat.ViewCompatImpl
        public boolean hasAccessibilityDelegate(View view) {
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
                return mAccessibilityDelegateField.get(view) != null;
            } catch (Throwable th2) {
                accessibilityDelegateCheckFailed = true;
                return false;
            }
        }

        @Override // com.baidu.searchbox.support.v4.view.ViewCompat.BaseViewCompatImpl, com.baidu.searchbox.support.v4.view.ViewCompat.ViewCompatImpl
        public void setFitsSystemWindows(View view, boolean z) {
            ViewCompatICS.setFitsSystemWindows(view, z);
        }
    }

    /* loaded from: classes2.dex */
    static class JBViewCompatImpl extends ICSViewCompatImpl {
        JBViewCompatImpl() {
        }

        @Override // com.baidu.searchbox.support.v4.view.ViewCompat.BaseViewCompatImpl, com.baidu.searchbox.support.v4.view.ViewCompat.ViewCompatImpl
        public boolean hasTransientState(View view) {
            return ViewCompatJB.hasTransientState(view);
        }

        @Override // com.baidu.searchbox.support.v4.view.ViewCompat.BaseViewCompatImpl, com.baidu.searchbox.support.v4.view.ViewCompat.ViewCompatImpl
        public void setHasTransientState(View view, boolean z) {
            ViewCompatJB.setHasTransientState(view, z);
        }

        @Override // com.baidu.searchbox.support.v4.view.ViewCompat.BaseViewCompatImpl, com.baidu.searchbox.support.v4.view.ViewCompat.ViewCompatImpl
        public void postInvalidateOnAnimation(View view) {
            ViewCompatJB.postInvalidateOnAnimation(view);
        }

        @Override // com.baidu.searchbox.support.v4.view.ViewCompat.BaseViewCompatImpl, com.baidu.searchbox.support.v4.view.ViewCompat.ViewCompatImpl
        public void postInvalidateOnAnimation(View view, int i, int i2, int i3, int i4) {
            ViewCompatJB.postInvalidateOnAnimation(view, i, i2, i3, i4);
        }

        @Override // com.baidu.searchbox.support.v4.view.ViewCompat.BaseViewCompatImpl, com.baidu.searchbox.support.v4.view.ViewCompat.ViewCompatImpl
        public void postOnAnimation(View view, Runnable runnable) {
            ViewCompatJB.postOnAnimation(view, runnable);
        }

        @Override // com.baidu.searchbox.support.v4.view.ViewCompat.BaseViewCompatImpl, com.baidu.searchbox.support.v4.view.ViewCompat.ViewCompatImpl
        public void postOnAnimationDelayed(View view, Runnable runnable, long j) {
            ViewCompatJB.postOnAnimationDelayed(view, runnable, j);
        }

        @Override // com.baidu.searchbox.support.v4.view.ViewCompat.BaseViewCompatImpl, com.baidu.searchbox.support.v4.view.ViewCompat.ViewCompatImpl
        public int getImportantForAccessibility(View view) {
            return ViewCompatJB.getImportantForAccessibility(view);
        }

        @Override // com.baidu.searchbox.support.v4.view.ViewCompat.BaseViewCompatImpl, com.baidu.searchbox.support.v4.view.ViewCompat.ViewCompatImpl
        public void setImportantForAccessibility(View view, int i) {
            if (i == 4) {
                i = 2;
            }
            ViewCompatJB.setImportantForAccessibility(view, i);
        }

        @Override // com.baidu.searchbox.support.v4.view.ViewCompat.BaseViewCompatImpl, com.baidu.searchbox.support.v4.view.ViewCompat.ViewCompatImpl
        public boolean performAccessibilityAction(View view, int i, Bundle bundle) {
            return ViewCompatJB.performAccessibilityAction(view, i, bundle);
        }

        @Override // com.baidu.searchbox.support.v4.view.ViewCompat.BaseViewCompatImpl, com.baidu.searchbox.support.v4.view.ViewCompat.ViewCompatImpl
        public ViewParent getParentForAccessibility(View view) {
            return ViewCompatJB.getParentForAccessibility(view);
        }

        @Override // com.baidu.searchbox.support.v4.view.ViewCompat.BaseViewCompatImpl, com.baidu.searchbox.support.v4.view.ViewCompat.ViewCompatImpl
        public int getMinimumWidth(View view) {
            return ViewCompatJB.getMinimumWidth(view);
        }

        @Override // com.baidu.searchbox.support.v4.view.ViewCompat.BaseViewCompatImpl, com.baidu.searchbox.support.v4.view.ViewCompat.ViewCompatImpl
        public int getMinimumHeight(View view) {
            return ViewCompatJB.getMinimumHeight(view);
        }

        @Override // com.baidu.searchbox.support.v4.view.ViewCompat.BaseViewCompatImpl, com.baidu.searchbox.support.v4.view.ViewCompat.ViewCompatImpl
        public void requestApplyInsets(View view) {
            ViewCompatJB.requestApplyInsets(view);
        }

        @Override // com.baidu.searchbox.support.v4.view.ViewCompat.BaseViewCompatImpl, com.baidu.searchbox.support.v4.view.ViewCompat.ViewCompatImpl
        public boolean getFitsSystemWindows(View view) {
            return ViewCompatJB.getFitsSystemWindows(view);
        }

        @Override // com.baidu.searchbox.support.v4.view.ViewCompat.BaseViewCompatImpl, com.baidu.searchbox.support.v4.view.ViewCompat.ViewCompatImpl
        public boolean hasOverlappingRendering(View view) {
            return ViewCompatJB.hasOverlappingRendering(view);
        }
    }

    /* loaded from: classes2.dex */
    static class JbMr1ViewCompatImpl extends JBViewCompatImpl {
        JbMr1ViewCompatImpl() {
        }

        @Override // com.baidu.searchbox.support.v4.view.ViewCompat.BaseViewCompatImpl, com.baidu.searchbox.support.v4.view.ViewCompat.ViewCompatImpl
        public int getLabelFor(View view) {
            return ViewCompatJellybeanMr1.getLabelFor(view);
        }

        @Override // com.baidu.searchbox.support.v4.view.ViewCompat.BaseViewCompatImpl, com.baidu.searchbox.support.v4.view.ViewCompat.ViewCompatImpl
        public void setLabelFor(View view, int i) {
            ViewCompatJellybeanMr1.setLabelFor(view, i);
        }

        @Override // com.baidu.searchbox.support.v4.view.ViewCompat.HCViewCompatImpl, com.baidu.searchbox.support.v4.view.ViewCompat.BaseViewCompatImpl, com.baidu.searchbox.support.v4.view.ViewCompat.ViewCompatImpl
        public void setLayerPaint(View view, Paint paint) {
            ViewCompatJellybeanMr1.setLayerPaint(view, paint);
        }

        @Override // com.baidu.searchbox.support.v4.view.ViewCompat.BaseViewCompatImpl, com.baidu.searchbox.support.v4.view.ViewCompat.ViewCompatImpl
        public int getLayoutDirection(View view) {
            return ViewCompatJellybeanMr1.getLayoutDirection(view);
        }

        @Override // com.baidu.searchbox.support.v4.view.ViewCompat.BaseViewCompatImpl, com.baidu.searchbox.support.v4.view.ViewCompat.ViewCompatImpl
        public void setLayoutDirection(View view, int i) {
            ViewCompatJellybeanMr1.setLayoutDirection(view, i);
        }

        @Override // com.baidu.searchbox.support.v4.view.ViewCompat.BaseViewCompatImpl, com.baidu.searchbox.support.v4.view.ViewCompat.ViewCompatImpl
        public int getPaddingStart(View view) {
            return ViewCompatJellybeanMr1.getPaddingStart(view);
        }

        @Override // com.baidu.searchbox.support.v4.view.ViewCompat.BaseViewCompatImpl, com.baidu.searchbox.support.v4.view.ViewCompat.ViewCompatImpl
        public int getPaddingEnd(View view) {
            return ViewCompatJellybeanMr1.getPaddingEnd(view);
        }

        @Override // com.baidu.searchbox.support.v4.view.ViewCompat.BaseViewCompatImpl, com.baidu.searchbox.support.v4.view.ViewCompat.ViewCompatImpl
        public void setPaddingRelative(View view, int i, int i2, int i3, int i4) {
            ViewCompatJellybeanMr1.setPaddingRelative(view, i, i2, i3, i4);
        }

        @Override // com.baidu.searchbox.support.v4.view.ViewCompat.BaseViewCompatImpl, com.baidu.searchbox.support.v4.view.ViewCompat.ViewCompatImpl
        public int getWindowSystemUiVisibility(View view) {
            return ViewCompatJellybeanMr1.getWindowSystemUiVisibility(view);
        }

        @Override // com.baidu.searchbox.support.v4.view.ViewCompat.BaseViewCompatImpl, com.baidu.searchbox.support.v4.view.ViewCompat.ViewCompatImpl
        public boolean isPaddingRelative(View view) {
            return ViewCompatJellybeanMr1.isPaddingRelative(view);
        }
    }

    /* loaded from: classes2.dex */
    static class JbMr2ViewCompatImpl extends JbMr1ViewCompatImpl {
        JbMr2ViewCompatImpl() {
        }

        @Override // com.baidu.searchbox.support.v4.view.ViewCompat.BaseViewCompatImpl, com.baidu.searchbox.support.v4.view.ViewCompat.ViewCompatImpl
        public void setClipBounds(View view, Rect rect) {
            ViewCompatJellybeanMr2.setClipBounds(view, rect);
        }

        @Override // com.baidu.searchbox.support.v4.view.ViewCompat.BaseViewCompatImpl, com.baidu.searchbox.support.v4.view.ViewCompat.ViewCompatImpl
        public Rect getClipBounds(View view) {
            return ViewCompatJellybeanMr2.getClipBounds(view);
        }
    }

    /* loaded from: classes2.dex */
    static class KitKatViewCompatImpl extends JbMr2ViewCompatImpl {
        KitKatViewCompatImpl() {
        }

        @Override // com.baidu.searchbox.support.v4.view.ViewCompat.BaseViewCompatImpl, com.baidu.searchbox.support.v4.view.ViewCompat.ViewCompatImpl
        public int getAccessibilityLiveRegion(View view) {
            return ViewCompatKitKat.getAccessibilityLiveRegion(view);
        }

        @Override // com.baidu.searchbox.support.v4.view.ViewCompat.BaseViewCompatImpl, com.baidu.searchbox.support.v4.view.ViewCompat.ViewCompatImpl
        public void setAccessibilityLiveRegion(View view, int i) {
            ViewCompatKitKat.setAccessibilityLiveRegion(view, i);
        }

        @Override // com.baidu.searchbox.support.v4.view.ViewCompat.JBViewCompatImpl, com.baidu.searchbox.support.v4.view.ViewCompat.BaseViewCompatImpl, com.baidu.searchbox.support.v4.view.ViewCompat.ViewCompatImpl
        public void setImportantForAccessibility(View view, int i) {
            ViewCompatJB.setImportantForAccessibility(view, i);
        }

        @Override // com.baidu.searchbox.support.v4.view.ViewCompat.BaseViewCompatImpl, com.baidu.searchbox.support.v4.view.ViewCompat.ViewCompatImpl
        public boolean isLaidOut(View view) {
            return ViewCompatKitKat.isLaidOut(view);
        }

        @Override // com.baidu.searchbox.support.v4.view.ViewCompat.BaseViewCompatImpl, com.baidu.searchbox.support.v4.view.ViewCompat.ViewCompatImpl
        public boolean isAttachedToWindow(View view) {
            return ViewCompatKitKat.isAttachedToWindow(view);
        }
    }

    /* loaded from: classes2.dex */
    static class LollipopViewCompatImpl extends KitKatViewCompatImpl {
        LollipopViewCompatImpl() {
        }

        @Override // com.baidu.searchbox.support.v4.view.ViewCompat.BaseViewCompatImpl, com.baidu.searchbox.support.v4.view.ViewCompat.ViewCompatImpl
        public void setTransitionName(View view, String str) {
            ViewCompatLollipop.setTransitionName(view, str);
        }

        @Override // com.baidu.searchbox.support.v4.view.ViewCompat.BaseViewCompatImpl, com.baidu.searchbox.support.v4.view.ViewCompat.ViewCompatImpl
        public String getTransitionName(View view) {
            return ViewCompatLollipop.getTransitionName(view);
        }

        @Override // com.baidu.searchbox.support.v4.view.ViewCompat.JBViewCompatImpl, com.baidu.searchbox.support.v4.view.ViewCompat.BaseViewCompatImpl, com.baidu.searchbox.support.v4.view.ViewCompat.ViewCompatImpl
        public void requestApplyInsets(View view) {
            ViewCompatLollipop.requestApplyInsets(view);
        }

        @Override // com.baidu.searchbox.support.v4.view.ViewCompat.BaseViewCompatImpl, com.baidu.searchbox.support.v4.view.ViewCompat.ViewCompatImpl
        public void setElevation(View view, float f) {
            ViewCompatLollipop.setElevation(view, f);
        }

        @Override // com.baidu.searchbox.support.v4.view.ViewCompat.BaseViewCompatImpl, com.baidu.searchbox.support.v4.view.ViewCompat.ViewCompatImpl
        public float getElevation(View view) {
            return ViewCompatLollipop.getElevation(view);
        }

        @Override // com.baidu.searchbox.support.v4.view.ViewCompat.BaseViewCompatImpl, com.baidu.searchbox.support.v4.view.ViewCompat.ViewCompatImpl
        public void setTranslationZ(View view, float f) {
            ViewCompatLollipop.setTranslationZ(view, f);
        }

        @Override // com.baidu.searchbox.support.v4.view.ViewCompat.BaseViewCompatImpl, com.baidu.searchbox.support.v4.view.ViewCompat.ViewCompatImpl
        public float getTranslationZ(View view) {
            return ViewCompatLollipop.getTranslationZ(view);
        }

        @Override // com.baidu.searchbox.support.v4.view.ViewCompat.BaseViewCompatImpl, com.baidu.searchbox.support.v4.view.ViewCompat.ViewCompatImpl
        public void setNestedScrollingEnabled(View view, boolean z) {
            ViewCompatLollipop.setNestedScrollingEnabled(view, z);
        }

        @Override // com.baidu.searchbox.support.v4.view.ViewCompat.BaseViewCompatImpl, com.baidu.searchbox.support.v4.view.ViewCompat.ViewCompatImpl
        public boolean isNestedScrollingEnabled(View view) {
            return ViewCompatLollipop.isNestedScrollingEnabled(view);
        }

        @Override // com.baidu.searchbox.support.v4.view.ViewCompat.BaseViewCompatImpl, com.baidu.searchbox.support.v4.view.ViewCompat.ViewCompatImpl
        public boolean startNestedScroll(View view, int i) {
            return ViewCompatLollipop.startNestedScroll(view, i);
        }

        @Override // com.baidu.searchbox.support.v4.view.ViewCompat.BaseViewCompatImpl, com.baidu.searchbox.support.v4.view.ViewCompat.ViewCompatImpl
        public void stopNestedScroll(View view) {
            ViewCompatLollipop.stopNestedScroll(view);
        }

        @Override // com.baidu.searchbox.support.v4.view.ViewCompat.BaseViewCompatImpl, com.baidu.searchbox.support.v4.view.ViewCompat.ViewCompatImpl
        public boolean hasNestedScrollingParent(View view) {
            return ViewCompatLollipop.hasNestedScrollingParent(view);
        }

        @Override // com.baidu.searchbox.support.v4.view.ViewCompat.BaseViewCompatImpl, com.baidu.searchbox.support.v4.view.ViewCompat.ViewCompatImpl
        public boolean dispatchNestedScroll(View view, int i, int i2, int i3, int i4, int[] iArr) {
            return ViewCompatLollipop.dispatchNestedScroll(view, i, i2, i3, i4, iArr);
        }

        @Override // com.baidu.searchbox.support.v4.view.ViewCompat.BaseViewCompatImpl, com.baidu.searchbox.support.v4.view.ViewCompat.ViewCompatImpl
        public boolean dispatchNestedPreScroll(View view, int i, int i2, int[] iArr, int[] iArr2) {
            return ViewCompatLollipop.dispatchNestedPreScroll(view, i, i2, iArr, iArr2);
        }

        @Override // com.baidu.searchbox.support.v4.view.ViewCompat.BaseViewCompatImpl, com.baidu.searchbox.support.v4.view.ViewCompat.ViewCompatImpl
        public boolean dispatchNestedFling(View view, float f, float f2, boolean z) {
            return ViewCompatLollipop.dispatchNestedFling(view, f, f2, z);
        }

        @Override // com.baidu.searchbox.support.v4.view.ViewCompat.BaseViewCompatImpl, com.baidu.searchbox.support.v4.view.ViewCompat.ViewCompatImpl
        public boolean dispatchNestedPreFling(View view, float f, float f2) {
            return ViewCompatLollipop.dispatchNestedPreFling(view, f, f2);
        }

        @Override // com.baidu.searchbox.support.v4.view.ViewCompat.BaseViewCompatImpl, com.baidu.searchbox.support.v4.view.ViewCompat.ViewCompatImpl
        public boolean isImportantForAccessibility(View view) {
            return ViewCompatLollipop.isImportantForAccessibility(view);
        }

        @Override // com.baidu.searchbox.support.v4.view.ViewCompat.BaseViewCompatImpl, com.baidu.searchbox.support.v4.view.ViewCompat.ViewCompatImpl
        public ColorStateList getBackgroundTintList(View view) {
            return ViewCompatLollipop.getBackgroundTintList(view);
        }

        @Override // com.baidu.searchbox.support.v4.view.ViewCompat.BaseViewCompatImpl, com.baidu.searchbox.support.v4.view.ViewCompat.ViewCompatImpl
        public void setBackgroundTintList(View view, ColorStateList colorStateList) {
            ViewCompatLollipop.setBackgroundTintList(view, colorStateList);
        }

        @Override // com.baidu.searchbox.support.v4.view.ViewCompat.BaseViewCompatImpl, com.baidu.searchbox.support.v4.view.ViewCompat.ViewCompatImpl
        public void setBackgroundTintMode(View view, PorterDuff.Mode mode) {
            ViewCompatLollipop.setBackgroundTintMode(view, mode);
        }

        @Override // com.baidu.searchbox.support.v4.view.ViewCompat.BaseViewCompatImpl, com.baidu.searchbox.support.v4.view.ViewCompat.ViewCompatImpl
        public PorterDuff.Mode getBackgroundTintMode(View view) {
            return ViewCompatLollipop.getBackgroundTintMode(view);
        }

        @Override // com.baidu.searchbox.support.v4.view.ViewCompat.BaseViewCompatImpl, com.baidu.searchbox.support.v4.view.ViewCompat.ViewCompatImpl
        public float getZ(View view) {
            return ViewCompatLollipop.getZ(view);
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 21) {
            IMPL = new LollipopViewCompatImpl();
        } else {
            IMPL = new KitKatViewCompatImpl();
        }
    }

    public static boolean canScrollHorizontally(View view, int i) {
        return IMPL.canScrollHorizontally(view, i);
    }

    public static boolean canScrollVertically(View view, int i) {
        return IMPL.canScrollVertically(view, i);
    }

    public static int getOverScrollMode(View view) {
        return IMPL.getOverScrollMode(view);
    }

    public static void setOverScrollMode(View view, int i) {
        IMPL.setOverScrollMode(view, i);
    }

    public static void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        IMPL.onPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    public static void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        IMPL.onInitializeAccessibilityEvent(view, accessibilityEvent);
    }

    public static boolean hasAccessibilityDelegate(View view) {
        return IMPL.hasAccessibilityDelegate(view);
    }

    public static boolean hasTransientState(View view) {
        return IMPL.hasTransientState(view);
    }

    public static void setHasTransientState(View view, boolean z) {
        IMPL.setHasTransientState(view, z);
    }

    public static void postInvalidateOnAnimation(View view) {
        IMPL.postInvalidateOnAnimation(view);
    }

    public static void postInvalidateOnAnimation(View view, int i, int i2, int i3, int i4) {
        IMPL.postInvalidateOnAnimation(view, i, i2, i3, i4);
    }

    public static void postOnAnimation(View view, Runnable runnable) {
        IMPL.postOnAnimation(view, runnable);
    }

    public static void postOnAnimationDelayed(View view, Runnable runnable, long j) {
        IMPL.postOnAnimationDelayed(view, runnable, j);
    }

    public static int getImportantForAccessibility(View view) {
        return IMPL.getImportantForAccessibility(view);
    }

    public static void setImportantForAccessibility(View view, int i) {
        IMPL.setImportantForAccessibility(view, i);
    }

    public static boolean performAccessibilityAction(View view, int i, Bundle bundle) {
        return IMPL.performAccessibilityAction(view, i, bundle);
    }

    public static float getAlpha(View view) {
        return IMPL.getAlpha(view);
    }

    public static void setLayerType(View view, int i, Paint paint) {
        IMPL.setLayerType(view, i, paint);
    }

    public static int getLayerType(View view) {
        return IMPL.getLayerType(view);
    }

    public static int getLabelFor(View view) {
        return IMPL.getLabelFor(view);
    }

    public static void setLabelFor(View view, @IdRes int i) {
        IMPL.setLabelFor(view, i);
    }

    public static void setLayerPaint(View view, Paint paint) {
        IMPL.setLayerPaint(view, paint);
    }

    public static int getLayoutDirection(View view) {
        return IMPL.getLayoutDirection(view);
    }

    public static void setLayoutDirection(View view, int i) {
        IMPL.setLayoutDirection(view, i);
    }

    public static ViewParent getParentForAccessibility(View view) {
        return IMPL.getParentForAccessibility(view);
    }

    public static boolean isOpaque(View view) {
        return IMPL.isOpaque(view);
    }

    public static int resolveSizeAndState(int i, int i2, int i3) {
        return IMPL.resolveSizeAndState(i, i2, i3);
    }

    public static int getMeasuredWidthAndState(View view) {
        return IMPL.getMeasuredWidthAndState(view);
    }

    public static int getMeasuredHeightAndState(View view) {
        return IMPL.getMeasuredHeightAndState(view);
    }

    public static int getMeasuredState(View view) {
        return IMPL.getMeasuredState(view);
    }

    public static int combineMeasuredStates(int i, int i2) {
        return IMPL.combineMeasuredStates(i, i2);
    }

    public static int getAccessibilityLiveRegion(View view) {
        return IMPL.getAccessibilityLiveRegion(view);
    }

    public static void setAccessibilityLiveRegion(View view, int i) {
        IMPL.setAccessibilityLiveRegion(view, i);
    }

    public static int getPaddingStart(View view) {
        return IMPL.getPaddingStart(view);
    }

    public static int getPaddingEnd(View view) {
        return IMPL.getPaddingEnd(view);
    }

    public static void setPaddingRelative(View view, int i, int i2, int i3, int i4) {
        IMPL.setPaddingRelative(view, i, i2, i3, i4);
    }

    public static void dispatchStartTemporaryDetach(View view) {
        IMPL.dispatchStartTemporaryDetach(view);
    }

    public static void dispatchFinishTemporaryDetach(View view) {
        IMPL.dispatchFinishTemporaryDetach(view);
    }

    public static float getTranslationX(View view) {
        return IMPL.getTranslationX(view);
    }

    public static float getTranslationY(View view) {
        return IMPL.getTranslationY(view);
    }

    public static int getMinimumWidth(View view) {
        return IMPL.getMinimumWidth(view);
    }

    public static int getMinimumHeight(View view) {
        return IMPL.getMinimumHeight(view);
    }

    public static void setTranslationX(View view, float f) {
        IMPL.setTranslationX(view, f);
    }

    public static void setTranslationY(View view, float f) {
        IMPL.setTranslationY(view, f);
    }

    public static void setAlpha(View view, @FloatRange(from = 0.0d, to = 1.0d) float f) {
        IMPL.setAlpha(view, f);
    }

    public static void setX(View view, float f) {
        IMPL.setX(view, f);
    }

    public static void setY(View view, float f) {
        IMPL.setY(view, f);
    }

    public static void setRotation(View view, float f) {
        IMPL.setRotation(view, f);
    }

    public static void setRotationX(View view, float f) {
        IMPL.setRotationX(view, f);
    }

    public static void setRotationY(View view, float f) {
        IMPL.setRotationY(view, f);
    }

    public static void setScaleX(View view, float f) {
        IMPL.setScaleX(view, f);
    }

    public static void setScaleY(View view, float f) {
        IMPL.setScaleY(view, f);
    }

    public static float getPivotX(View view) {
        return IMPL.getPivotX(view);
    }

    public static void setPivotX(View view, float f) {
        IMPL.setPivotX(view, f);
    }

    public static float getPivotY(View view) {
        return IMPL.getPivotY(view);
    }

    public static void setPivotY(View view, float f) {
        IMPL.setPivotX(view, f);
    }

    public static float getRotation(View view) {
        return IMPL.getRotation(view);
    }

    public static float getRotationX(View view) {
        return IMPL.getRotationX(view);
    }

    public static float getRotationY(View view) {
        return IMPL.getRotationY(view);
    }

    public static float getScaleX(View view) {
        return IMPL.getScaleX(view);
    }

    public static float getScaleY(View view) {
        return IMPL.getScaleY(view);
    }

    public static float getX(View view) {
        return IMPL.getX(view);
    }

    public static float getY(View view) {
        return IMPL.getY(view);
    }

    public static void setElevation(View view, float f) {
        IMPL.setElevation(view, f);
    }

    public static float getElevation(View view) {
        return IMPL.getElevation(view);
    }

    public static void setTranslationZ(View view, float f) {
        IMPL.setTranslationZ(view, f);
    }

    public static float getTranslationZ(View view) {
        return IMPL.getTranslationZ(view);
    }

    public static void setTransitionName(View view, String str) {
        IMPL.setTransitionName(view, str);
    }

    public static String getTransitionName(View view) {
        return IMPL.getTransitionName(view);
    }

    public static int getWindowSystemUiVisibility(View view) {
        return IMPL.getWindowSystemUiVisibility(view);
    }

    public static void requestApplyInsets(View view) {
        IMPL.requestApplyInsets(view);
    }

    public static void setChildrenDrawingOrderEnabled(ViewGroup viewGroup, boolean z) {
        IMPL.setChildrenDrawingOrderEnabled(viewGroup, z);
    }

    public static boolean getFitsSystemWindows(View view) {
        return IMPL.getFitsSystemWindows(view);
    }

    public static void setFitsSystemWindows(View view, boolean z) {
        IMPL.setFitsSystemWindows(view, z);
    }

    public static void jumpDrawablesToCurrentState(View view) {
        IMPL.jumpDrawablesToCurrentState(view);
    }

    public static void setSaveFromParentEnabled(View view, boolean z) {
        IMPL.setSaveFromParentEnabled(view, z);
    }

    public static void setActivated(View view, boolean z) {
        IMPL.setActivated(view, z);
    }

    public static boolean hasOverlappingRendering(View view) {
        return IMPL.hasOverlappingRendering(view);
    }

    public static boolean isPaddingRelative(View view) {
        return IMPL.isPaddingRelative(view);
    }

    public static ColorStateList getBackgroundTintList(View view) {
        return IMPL.getBackgroundTintList(view);
    }

    public static void setBackgroundTintList(View view, ColorStateList colorStateList) {
        IMPL.setBackgroundTintList(view, colorStateList);
    }

    public static PorterDuff.Mode getBackgroundTintMode(View view) {
        return IMPL.getBackgroundTintMode(view);
    }

    public static void setBackgroundTintMode(View view, PorterDuff.Mode mode) {
        IMPL.setBackgroundTintMode(view, mode);
    }

    public static void setNestedScrollingEnabled(View view, boolean z) {
        IMPL.setNestedScrollingEnabled(view, z);
    }

    public static boolean isNestedScrollingEnabled(View view) {
        return IMPL.isNestedScrollingEnabled(view);
    }

    public static boolean startNestedScroll(View view, int i) {
        return IMPL.startNestedScroll(view, i);
    }

    public static void stopNestedScroll(View view) {
        IMPL.stopNestedScroll(view);
    }

    public static boolean hasNestedScrollingParent(View view) {
        return IMPL.hasNestedScrollingParent(view);
    }

    public static boolean dispatchNestedScroll(View view, int i, int i2, int i3, int i4, int[] iArr) {
        return IMPL.dispatchNestedScroll(view, i, i2, i3, i4, iArr);
    }

    public static boolean dispatchNestedPreScroll(View view, int i, int i2, int[] iArr, int[] iArr2) {
        return IMPL.dispatchNestedPreScroll(view, i, i2, iArr, iArr2);
    }

    public static boolean dispatchNestedFling(View view, float f, float f2, boolean z) {
        return IMPL.dispatchNestedFling(view, f, f2, z);
    }

    public static boolean dispatchNestedPreFling(View view, float f, float f2) {
        return IMPL.dispatchNestedPreFling(view, f, f2);
    }

    public static boolean isLaidOut(View view) {
        return IMPL.isLaidOut(view);
    }

    public static float getZ(View view) {
        return IMPL.getZ(view);
    }

    public static void offsetTopAndBottom(View view, int i) {
        view.offsetTopAndBottom(i);
        if (i != 0 && Build.VERSION.SDK_INT < 11) {
            view.invalidate();
        }
    }

    public static void offsetLeftAndRight(View view, int i) {
        view.offsetLeftAndRight(i);
        if (i != 0 && Build.VERSION.SDK_INT < 11) {
            view.invalidate();
        }
    }

    public static void setClipBounds(View view, Rect rect) {
        IMPL.setClipBounds(view, rect);
    }

    public static Rect getClipBounds(View view) {
        return IMPL.getClipBounds(view);
    }

    public static boolean isAttachedToWindow(View view) {
        return IMPL.isAttachedToWindow(view);
    }
}
