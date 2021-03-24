package com.baidu.searchbox.widget;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.baidu.searchbox.widget.ViewDragHelper;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public abstract class SlidingPaneLayout extends ViewGroup {
    public static final int DEFAULT_FADE_COLOR = -858993460;
    public static final SlidingPanelLayoutImpl IMPL;
    public static final int MIN_FLING_VELOCITY = 400;
    public static final String TAG = "SlidingPaneLayout";
    public boolean mAutoSlide;
    public boolean mCanSlide;
    public int mCoveredFadeColor;
    public final ViewDragHelper mDragHelper;
    public boolean mEnableReleaseWhenNoTranslucent;
    public boolean mFirstLayout;
    public float mInitialMotionX;
    public float mInitialMotionY;
    public boolean mIsActivityTranslucent;
    public boolean mIsUnableToDrag;
    public final int mOverhangSize;
    public PanelSlideListener mPanelSlideListener;
    public int mParallaxBy;
    public float mParallaxOffset;
    public final ArrayList<DisableLayerRunnable> mPostedRunnables;
    public boolean mPreservedOpenState;
    public int mScreenWidth;
    public Drawable mShadowDrawable;
    public float mSlideOffset;
    public int mSlideRange;
    public View mSlideableView;
    public int mSliderFadeColor;
    public final Rect mTmpRect;
    public boolean showShadow;
    public double slideEdgeFactor;
    public double slideWidthFactor;

    /* loaded from: classes3.dex */
    public class AccessibilityDelegate extends AccessibilityDelegateCompat {
        public final Rect mTmpRect = new Rect();

        public AccessibilityDelegate() {
        }

        private void copyNodeInfoNoChildren(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat2) {
            Rect rect = this.mTmpRect;
            accessibilityNodeInfoCompat2.getBoundsInParent(rect);
            accessibilityNodeInfoCompat.setBoundsInParent(rect);
            accessibilityNodeInfoCompat2.getBoundsInScreen(rect);
            accessibilityNodeInfoCompat.setBoundsInScreen(rect);
            accessibilityNodeInfoCompat.setVisibleToUser(accessibilityNodeInfoCompat2.isVisibleToUser());
            accessibilityNodeInfoCompat.setPackageName(accessibilityNodeInfoCompat2.getPackageName());
            accessibilityNodeInfoCompat.setClassName(accessibilityNodeInfoCompat2.getClassName());
            accessibilityNodeInfoCompat.setContentDescription(accessibilityNodeInfoCompat2.getContentDescription());
            accessibilityNodeInfoCompat.setEnabled(accessibilityNodeInfoCompat2.isEnabled());
            accessibilityNodeInfoCompat.setClickable(accessibilityNodeInfoCompat2.isClickable());
            accessibilityNodeInfoCompat.setFocusable(accessibilityNodeInfoCompat2.isFocusable());
            accessibilityNodeInfoCompat.setFocused(accessibilityNodeInfoCompat2.isFocused());
            accessibilityNodeInfoCompat.setAccessibilityFocused(accessibilityNodeInfoCompat2.isAccessibilityFocused());
            accessibilityNodeInfoCompat.setSelected(accessibilityNodeInfoCompat2.isSelected());
            accessibilityNodeInfoCompat.setLongClickable(accessibilityNodeInfoCompat2.isLongClickable());
            accessibilityNodeInfoCompat.addAction(accessibilityNodeInfoCompat2.getActions());
            accessibilityNodeInfoCompat.setMovementGranularities(accessibilityNodeInfoCompat2.getMovementGranularities());
        }

        public boolean filter(View view) {
            return SlidingPaneLayout.this.isDimmed(view);
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            accessibilityEvent.setClassName(SlidingPaneLayout.class.getName());
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            AccessibilityNodeInfoCompat obtain = AccessibilityNodeInfoCompat.obtain(accessibilityNodeInfoCompat);
            super.onInitializeAccessibilityNodeInfo(view, obtain);
            copyNodeInfoNoChildren(accessibilityNodeInfoCompat, obtain);
            obtain.recycle();
            accessibilityNodeInfoCompat.setClassName(SlidingPaneLayout.class.getName());
            accessibilityNodeInfoCompat.setSource(view);
            ViewParent parentForAccessibility = ViewCompat.getParentForAccessibility(view);
            if (parentForAccessibility instanceof View) {
                accessibilityNodeInfoCompat.setParent((View) parentForAccessibility);
            }
            int childCount = SlidingPaneLayout.this.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = SlidingPaneLayout.this.getChildAt(i);
                if (!filter(childAt) && childAt.getVisibility() == 0) {
                    ViewCompat.setImportantForAccessibility(childAt, 1);
                    accessibilityNodeInfoCompat.addChild(childAt);
                }
            }
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            if (filter(view)) {
                return false;
            }
            return super.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
        }
    }

    /* loaded from: classes3.dex */
    public class DisableLayerRunnable implements Runnable {
        public final View mChildView;

        public DisableLayerRunnable(View view) {
            this.mChildView = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.mChildView.getParent() == SlidingPaneLayout.this) {
                ViewCompat.setLayerType(this.mChildView, 0, null);
                SlidingPaneLayout.this.invalidateChildRegion(this.mChildView);
            }
            SlidingPaneLayout.this.mPostedRunnables.remove(this);
        }
    }

    /* loaded from: classes3.dex */
    public class DragHelperCallback extends ViewDragHelper.Callback {
        public final int OFFSET_X;
        public int currX;

        public DragHelperCallback() {
            this.OFFSET_X = 10;
        }

        @Override // com.baidu.searchbox.widget.ViewDragHelper.Callback
        public int clampViewPositionHorizontal(View view, int i, int i2) {
            int paddingLeft = SlidingPaneLayout.this.getPaddingLeft() + ((ViewGroup.MarginLayoutParams) ((LayoutParams) SlidingPaneLayout.this.mSlideableView.getLayoutParams())).leftMargin;
            return Math.min(Math.max(i, paddingLeft), SlidingPaneLayout.this.mSlideRange + paddingLeft);
        }

        @Override // com.baidu.searchbox.widget.ViewDragHelper.Callback
        public int getViewHorizontalDragRange(View view) {
            return SlidingPaneLayout.this.mSlideRange;
        }

        @Override // com.baidu.searchbox.widget.ViewDragHelper.Callback
        public boolean isPageTranslucent() {
            return SlidingPaneLayout.this.mIsActivityTranslucent;
        }

        @Override // com.baidu.searchbox.widget.ViewDragHelper.Callback
        public void onEdgeDragStarted(int i, int i2) {
            if (!SlidingPaneLayout.this.mIsActivityTranslucent) {
                SlidingPaneLayout.this.convertActivityToTranslucent();
            }
            SlidingPaneLayout.this.mDragHelper.captureChildView(SlidingPaneLayout.this.mSlideableView, i2);
        }

        @Override // com.baidu.searchbox.widget.ViewDragHelper.Callback
        public void onViewCaptured(View view, int i) {
            SlidingPaneLayout.this.setAllChildrenVisible();
        }

        @Override // com.baidu.searchbox.widget.ViewDragHelper.Callback
        public void onViewDragStateChanged(int i) {
            if (SlidingPaneLayout.this.mDragHelper.getViewDragState() == 0) {
                if (SlidingPaneLayout.this.mSlideOffset == 0.0f) {
                    SlidingPaneLayout slidingPaneLayout = SlidingPaneLayout.this;
                    slidingPaneLayout.updateObscuredViewsVisibility(slidingPaneLayout.mSlideableView);
                    SlidingPaneLayout slidingPaneLayout2 = SlidingPaneLayout.this;
                    slidingPaneLayout2.dispatchOnPanelClosed(slidingPaneLayout2.mSlideableView);
                    SlidingPaneLayout.this.mPreservedOpenState = false;
                    return;
                }
                SlidingPaneLayout slidingPaneLayout3 = SlidingPaneLayout.this;
                slidingPaneLayout3.dispatchOnPanelOpened(slidingPaneLayout3.mSlideableView);
                SlidingPaneLayout.this.mPreservedOpenState = true;
            }
        }

        @Override // com.baidu.searchbox.widget.ViewDragHelper.Callback
        public void onViewPositionChanged(View view, int i, int i2, int i3, int i4) {
            this.currX = i;
            SlidingPaneLayout.this.onPanelDragged(i);
            SlidingPaneLayout.this.invalidate();
        }

        @Override // com.baidu.searchbox.widget.ViewDragHelper.Callback
        public void onViewReleased(View view, float f2, float f3) {
            int i;
            int paddingLeft = SlidingPaneLayout.this.getPaddingLeft() + ((ViewGroup.MarginLayoutParams) ((LayoutParams) view.getLayoutParams())).leftMargin;
            if (SlidingPaneLayout.this.mEnableReleaseWhenNoTranslucent || SlidingPaneLayout.this.mIsActivityTranslucent) {
                if (f2 != 0.0f || SlidingPaneLayout.this.mSlideOffset <= 0.25f) {
                    if (f2 > 0.0f) {
                        paddingLeft += SlidingPaneLayout.this.mSlideRange;
                    }
                    SlidingPaneLayout.this.mDragHelper.settleCapturedViewAt(paddingLeft, view.getTop());
                    SlidingPaneLayout.this.invalidate();
                    return;
                }
                if (SlidingPaneLayout.this.mAutoSlide) {
                    i = SlidingPaneLayout.this.mSlideRange;
                } else {
                    i = this.currX + 10;
                }
                SlidingPaneLayout.this.mDragHelper.settleCapturedViewAt(paddingLeft + i, view.getTop());
                SlidingPaneLayout.this.invalidate();
            }
        }

        @Override // com.baidu.searchbox.widget.ViewDragHelper.Callback
        public boolean tryCaptureView(View view, int i) {
            if (SlidingPaneLayout.this.mIsUnableToDrag) {
                return false;
            }
            if (!SlidingPaneLayout.this.mIsActivityTranslucent) {
                SlidingPaneLayout.this.convertActivityToTranslucent();
            }
            return ((LayoutParams) view.getLayoutParams()).slideable;
        }
    }

    /* loaded from: classes3.dex */
    public interface PanelSlideListener {
        void onPanelClosed(View view);

        void onPanelOpened(View view);

        void onPanelSlide(View view, float f2);
    }

    /* loaded from: classes3.dex */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: com.baidu.searchbox.widget.SlidingPaneLayout.SavedState.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        public boolean isOpen;

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.isOpen ? 1 : 0);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public SavedState(Parcel parcel) {
            super(parcel);
            this.isOpen = parcel.readInt() != 0;
        }
    }

    /* loaded from: classes3.dex */
    public static class SimplePanelSlideListener implements PanelSlideListener {
        @Override // com.baidu.searchbox.widget.SlidingPaneLayout.PanelSlideListener
        public void onPanelClosed(View view) {
        }

        @Override // com.baidu.searchbox.widget.SlidingPaneLayout.PanelSlideListener
        public void onPanelOpened(View view) {
        }

        @Override // com.baidu.searchbox.widget.SlidingPaneLayout.PanelSlideListener
        public void onPanelSlide(View view, float f2) {
        }
    }

    /* loaded from: classes3.dex */
    public interface SlidingPanelLayoutImpl {
        void invalidateChildRegion(SlidingPaneLayout slidingPaneLayout, View view);
    }

    /* loaded from: classes3.dex */
    public static class SlidingPanelLayoutImplBase implements SlidingPanelLayoutImpl {
        @Override // com.baidu.searchbox.widget.SlidingPaneLayout.SlidingPanelLayoutImpl
        public void invalidateChildRegion(SlidingPaneLayout slidingPaneLayout, View view) {
            ViewCompat.postInvalidateOnAnimation(slidingPaneLayout, view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        }
    }

    /* loaded from: classes3.dex */
    public static class SlidingPanelLayoutImplJB extends SlidingPanelLayoutImplBase {
        public Method mGetDisplayList;
        public Field mRecreateDisplayList;

        public SlidingPanelLayoutImplJB() {
            try {
                this.mGetDisplayList = View.class.getDeclaredMethod("getDisplayList", null);
            } catch (NoSuchMethodException e2) {
                Log.e("SlidingPaneLayout", "Couldn't fetch getDisplayList method; dimming won't work right.", e2);
            }
            try {
                Field declaredField = View.class.getDeclaredField("mRecreateDisplayList");
                this.mRecreateDisplayList = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e3) {
                Log.e("SlidingPaneLayout", "Couldn't fetch mRecreateDisplayList field; dimming will be slow.", e3);
            }
        }

        @Override // com.baidu.searchbox.widget.SlidingPaneLayout.SlidingPanelLayoutImplBase, com.baidu.searchbox.widget.SlidingPaneLayout.SlidingPanelLayoutImpl
        public void invalidateChildRegion(SlidingPaneLayout slidingPaneLayout, View view) {
            Field field;
            if (this.mGetDisplayList != null && (field = this.mRecreateDisplayList) != null) {
                try {
                    field.setBoolean(view, true);
                    this.mGetDisplayList.invoke(view, null);
                } catch (Exception e2) {
                    Log.e("SlidingPaneLayout", "Error refreshing display list state", e2);
                }
                super.invalidateChildRegion(slidingPaneLayout, view);
                return;
            }
            view.invalidate();
        }
    }

    /* loaded from: classes3.dex */
    public static class SlidingPanelLayoutImplJBMR1 extends SlidingPanelLayoutImplBase {
        @Override // com.baidu.searchbox.widget.SlidingPaneLayout.SlidingPanelLayoutImplBase, com.baidu.searchbox.widget.SlidingPaneLayout.SlidingPanelLayoutImpl
        public void invalidateChildRegion(SlidingPaneLayout slidingPaneLayout, View view) {
            ViewCompat.setLayerPaint(view, ((LayoutParams) view.getLayoutParams()).dimPaint);
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 17) {
            IMPL = new SlidingPanelLayoutImplJBMR1();
        } else {
            IMPL = new SlidingPanelLayoutImplBase();
        }
    }

    public SlidingPaneLayout(Context context) {
        this(context, null);
    }

    private void dimChildView(View view, float f2, int i) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (f2 > 0.0f && i != 0) {
            int i2 = (((int) ((((-16777216) & i) >>> 24) * f2)) << 24) | (i & ViewCompat.MEASURED_SIZE_MASK);
            if (layoutParams.dimPaint == null) {
                layoutParams.dimPaint = new Paint();
            }
            layoutParams.dimPaint.setColorFilter(new PorterDuffColorFilter(i2, PorterDuff.Mode.SRC_OVER));
            if (ViewCompat.getLayerType(view) != 2) {
                ViewCompat.setLayerType(view, 2, layoutParams.dimPaint);
            }
            invalidateChildRegion(view);
        } else if (ViewCompat.getLayerType(view) != 0) {
            Paint paint = layoutParams.dimPaint;
            if (paint != null) {
                paint.setColorFilter(null);
            }
            DisableLayerRunnable disableLayerRunnable = new DisableLayerRunnable(view);
            this.mPostedRunnables.add(disableLayerRunnable);
            ViewCompat.postOnAnimation(this, disableLayerRunnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void invalidateChildRegion(View view) {
        IMPL.invalidateChildRegion(this, view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onPanelDragged(int i) {
        View view;
        if (this.mCanSlide && (view = this.mSlideableView) != null) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            float paddingLeft = (i - (getPaddingLeft() + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin)) / this.mSlideRange;
            this.mSlideOffset = paddingLeft;
            if (this.mParallaxBy != 0) {
                parallaxOtherViews(paddingLeft);
            }
            if (layoutParams.dimWhenOffset) {
                dimChildView(this.mSlideableView, this.mSlideOffset, this.mSliderFadeColor);
            }
            dispatchOnPanelSlide(this.mSlideableView);
        }
    }

    private void parallaxOtherViews(float f2) {
        LayoutParams layoutParams = (LayoutParams) this.mSlideableView.getLayoutParams();
        boolean z = layoutParams.dimWhenOffset && ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin <= 0;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt != this.mSlideableView) {
                int i2 = this.mParallaxBy;
                this.mParallaxOffset = f2;
                childAt.offsetLeftAndRight(((int) ((1.0f - this.mParallaxOffset) * i2)) - ((int) ((1.0f - f2) * i2)));
                if (z) {
                    dimChildView(childAt, 1.0f - this.mParallaxOffset, this.mCoveredFadeColor);
                }
            }
        }
    }

    public static boolean viewIsOpaque(View view) {
        Drawable background;
        return Build.VERSION.SDK_INT < 18 && (background = view.getBackground()) != null && background.getOpacity() == -1;
    }

    public abstract void attachActivity(Activity activity);

    public boolean canScroll(View view, boolean z, int i, int i2, int i3) {
        int i4;
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int scrollX = view.getScrollX();
            int scrollY = view.getScrollY();
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                int i5 = i2 + scrollX;
                if (i5 >= childAt.getLeft() && i5 < childAt.getRight() && (i4 = i3 + scrollY) >= childAt.getTop() && i4 < childAt.getBottom() && canScroll(childAt, true, i, i5 - childAt.getLeft(), i4 - childAt.getTop())) {
                    return true;
                }
            }
        }
        return z && ViewCompat.canScrollHorizontally(view, -i);
    }

    @Deprecated
    public boolean canSlide() {
        return this.mCanSlide;
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof LayoutParams) && super.checkLayoutParams(layoutParams);
    }

    public boolean closePane() {
        return closePane(this.mSlideableView, 0);
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.mDragHelper.continueSettling(true)) {
            if (!this.mCanSlide) {
                this.mDragHelper.abort();
            } else {
                ViewCompat.postInvalidateOnAnimation(this);
            }
        }
    }

    public abstract void convertActivityFromTranslucent();

    public abstract void convertActivityToTranslucent();

    public void dispatchOnPanelClosed(View view) {
        PanelSlideListener panelSlideListener = this.mPanelSlideListener;
        if (panelSlideListener != null) {
            panelSlideListener.onPanelClosed(view);
        }
        sendAccessibilityEvent(32);
    }

    public void dispatchOnPanelOpened(View view) {
        PanelSlideListener panelSlideListener = this.mPanelSlideListener;
        if (panelSlideListener != null) {
            panelSlideListener.onPanelOpened(view);
        }
        sendAccessibilityEvent(32);
    }

    public void dispatchOnPanelSlide(View view) {
        PanelSlideListener panelSlideListener = this.mPanelSlideListener;
        if (panelSlideListener != null) {
            panelSlideListener.onPanelSlide(view, this.mSlideOffset);
        }
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        try {
            super.draw(canvas);
            View childAt = getChildCount() > 1 ? getChildAt(1) : null;
            if (this.showShadow && childAt != null && this.mShadowDrawable != null) {
                int intrinsicWidth = this.mShadowDrawable.getIntrinsicWidth();
                int left = childAt.getLeft();
                this.mShadowDrawable.setBounds(left - intrinsicWidth, childAt.getTop(), left, childAt.getBottom());
                this.mShadowDrawable.draw(canvas);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // android.view.ViewGroup
    public boolean drawChild(Canvas canvas, View view, long j) {
        boolean drawChild;
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int save = canvas.save();
        if (this.mCanSlide && !layoutParams.slideable && this.mSlideableView != null && this.mAutoSlide) {
            canvas.getClipBounds(this.mTmpRect);
            Rect rect = this.mTmpRect;
            rect.right = Math.min(rect.right, this.mSlideableView.getLeft());
            canvas.clipRect(this.mTmpRect);
        }
        if (Build.VERSION.SDK_INT >= 11) {
            drawChild = super.drawChild(canvas, view, j);
        } else if (layoutParams.dimWhenOffset && this.mSlideOffset > 0.0f) {
            if (!view.isDrawingCacheEnabled()) {
                view.setDrawingCacheEnabled(true);
            }
            Bitmap drawingCache = view.getDrawingCache();
            if (drawingCache != null) {
                canvas.drawBitmap(drawingCache, view.getLeft(), view.getTop(), layoutParams.dimPaint);
                drawChild = false;
            } else {
                Log.e("SlidingPaneLayout", "drawChild: child view " + view + " returned null drawing cache");
                drawChild = super.drawChild(canvas, view, j);
            }
        } else {
            if (view.isDrawingCacheEnabled()) {
                view.setDrawingCacheEnabled(false);
            }
            drawChild = super.drawChild(canvas, view, j);
        }
        canvas.restoreToCount(save);
        return drawChild;
    }

    public abstract void forceActivityTransparent(boolean z);

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams) : new LayoutParams(layoutParams);
    }

    public int getCoveredFadeColor() {
        return this.mCoveredFadeColor;
    }

    public int getParallaxDistance() {
        return this.mParallaxBy;
    }

    public int getSliderFadeColor() {
        return this.mSliderFadeColor;
    }

    public boolean isDimmed(View view) {
        if (view == null) {
            return false;
        }
        return this.mCanSlide && ((LayoutParams) view.getLayoutParams()).dimWhenOffset && this.mSlideOffset > 0.0f;
    }

    public boolean isOpen() {
        return !this.mCanSlide || this.mSlideOffset == 1.0f;
    }

    public void isShowShadow(boolean z) {
        this.showShadow = z;
    }

    public boolean isSlideable() {
        return this.mCanSlide;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mFirstLayout = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mFirstLayout = true;
        int size = this.mPostedRunnables.size();
        for (int i = 0; i < size; i++) {
            this.mPostedRunnables.get(i).run();
        }
        this.mPostedRunnables.clear();
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x009b, code lost:
        if (r0 < (r9 * r11)) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00e8, code lost:
        if (isDimmed(r13.mSlideableView) != false) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00ea, code lost:
        r0 = true;
     */
    @Override // android.view.ViewGroup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z;
        boolean z2;
        View childAt;
        int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
        if (!this.mCanSlide && actionMasked == 0 && getChildCount() > 1 && (childAt = getChildAt(1)) != null) {
            this.mPreservedOpenState = !this.mDragHelper.isViewUnder(childAt, (int) motionEvent.getX(), (int) motionEvent.getY());
        }
        float x = motionEvent.getX();
        double d2 = this.mScreenWidth;
        double d3 = this.slideWidthFactor;
        Double.isNaN(d2);
        if (x >= ((int) (d2 * d3))) {
            this.mDragHelper.cancel();
            return super.onInterceptTouchEvent(motionEvent);
        } else if (!this.mCanSlide || (this.mIsUnableToDrag && actionMasked != 0)) {
            this.mDragHelper.cancel();
            return super.onInterceptTouchEvent(motionEvent);
        } else if (actionMasked != 3 && actionMasked != 1) {
            if (actionMasked != 0) {
                if (actionMasked == 2) {
                    float x2 = motionEvent.getX();
                    float y = motionEvent.getY();
                    float abs = Math.abs(x2 - this.mInitialMotionX);
                    float abs2 = Math.abs(y - this.mInitialMotionY);
                    int touchSlop = this.mDragHelper.getTouchSlop();
                    if (abs > 0.0f && abs > abs2 && this.mCanSlide) {
                        double d4 = this.mScreenWidth;
                        double d5 = this.slideEdgeFactor;
                        Double.isNaN(d4);
                    }
                    if ((abs > touchSlop && abs2 > abs) || canScroll(this, false, Math.round(x2 - this.mInitialMotionX), Math.round(x2), Math.round(y))) {
                        this.mDragHelper.cancel();
                        this.mIsUnableToDrag = true;
                        return false;
                    }
                }
                z = false;
            } else {
                this.mIsUnableToDrag = false;
                float x3 = motionEvent.getX();
                float y2 = motionEvent.getY();
                this.mInitialMotionX = x3;
                this.mInitialMotionY = y2;
                if (this.mDragHelper.isViewUnder(this.mSlideableView, (int) x3, (int) y2)) {
                }
                z = false;
            }
            try {
                z2 = this.mDragHelper.shouldInterceptTouchEvent(motionEvent);
            } catch (Exception e2) {
                e2.printStackTrace();
                z2 = false;
            }
            return z2 || z;
        } else {
            this.mDragHelper.cancel();
            return false;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int i7 = i3 - i;
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int childCount = getChildCount();
        if (this.mFirstLayout) {
            this.mSlideOffset = (this.mCanSlide && this.mPreservedOpenState) ? 1.0f : 0.0f;
        }
        int i8 = paddingLeft;
        for (int i9 = 0; i9 < childCount; i9++) {
            View childAt = getChildAt(i9);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                int measuredWidth = childAt.getMeasuredWidth();
                if (layoutParams.slideable) {
                    int i10 = i7 - paddingRight;
                    int min = (Math.min(paddingLeft, i10 - this.mOverhangSize) - i8) - (((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin);
                    this.mSlideRange = min;
                    layoutParams.dimWhenOffset = ((((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + i8) + min) + (measuredWidth / 2) > i10;
                    i8 += ((int) (min * this.mSlideOffset)) + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin;
                } else if (!this.mCanSlide || (i5 = this.mParallaxBy) == 0) {
                    i8 = paddingLeft;
                } else {
                    i6 = (int) ((1.0f - this.mSlideOffset) * i5);
                    i8 = paddingLeft;
                    int i11 = i8 - i6;
                    childAt.layout(i11, paddingTop, measuredWidth + i11, childAt.getMeasuredHeight() + paddingTop);
                    paddingLeft += childAt.getWidth();
                }
                i6 = 0;
                int i112 = i8 - i6;
                childAt.layout(i112, paddingTop, measuredWidth + i112, childAt.getMeasuredHeight() + paddingTop);
                paddingLeft += childAt.getWidth();
            }
        }
        if (this.mFirstLayout) {
            if (this.mCanSlide) {
                if (this.mParallaxBy != 0) {
                    parallaxOtherViews(this.mSlideOffset);
                }
                if (((LayoutParams) this.mSlideableView.getLayoutParams()).dimWhenOffset) {
                    dimChildView(this.mSlideableView, this.mSlideOffset, this.mSliderFadeColor);
                }
            } else {
                for (int i12 = 0; i12 < childCount; i12++) {
                    dimChildView(getChildAt(i12), 0.0f, this.mSliderFadeColor);
                }
            }
            updateObscuredViewsVisibility(this.mSlideableView);
        }
        this.mFirstLayout = false;
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        int paddingTop;
        int i3;
        int i4;
        int i5;
        int makeMeasureSpec;
        int i6;
        int makeMeasureSpec2;
        int i7;
        int makeMeasureSpec3;
        int i8;
        int makeMeasureSpec4;
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i2);
        if (mode != 1073741824) {
            if (!isInEditMode()) {
                throw new IllegalStateException("Width must have an exact value or MATCH_PARENT");
            }
            if (mode != Integer.MIN_VALUE && mode == 0) {
                size = 300;
            }
        } else if (mode2 == 0) {
            if (!isInEditMode()) {
                throw new IllegalStateException("Height must not be UNSPECIFIED");
            }
            if (mode2 == 0) {
                mode2 = Integer.MIN_VALUE;
                size2 = 300;
            }
        }
        boolean z = false;
        if (mode2 == Integer.MIN_VALUE) {
            paddingTop = (size2 - getPaddingTop()) - getPaddingBottom();
            i3 = 0;
        } else if (mode2 != 1073741824) {
            i3 = 0;
            paddingTop = -1;
        } else {
            i3 = (size2 - getPaddingTop()) - getPaddingBottom();
            paddingTop = i3;
        }
        int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
        int childCount = getChildCount();
        if (childCount > 2) {
            Log.e("SlidingPaneLayout", "onMeasure: More than two child views are not supported.");
        }
        this.mSlideableView = null;
        float f2 = 0.0f;
        int i9 = 0;
        boolean z2 = false;
        float f3 = 0.0f;
        while (true) {
            i4 = 8;
            if (i9 >= childCount) {
                break;
            }
            View childAt = getChildAt(i9);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            if (childAt.getVisibility() == 8) {
                layoutParams.dimWhenOffset = z;
            } else {
                float f4 = layoutParams.weight;
                if (f4 > f2) {
                    f3 += f4;
                    if (((ViewGroup.MarginLayoutParams) layoutParams).width == 0) {
                    }
                }
                int i10 = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
                int i11 = ((ViewGroup.MarginLayoutParams) layoutParams).width;
                if (i11 == -2) {
                    makeMeasureSpec3 = View.MeasureSpec.makeMeasureSpec(size - i10, Integer.MIN_VALUE);
                    i7 = -1;
                } else {
                    i7 = -1;
                    if (i11 == -1) {
                        makeMeasureSpec3 = View.MeasureSpec.makeMeasureSpec(size - i10, 1073741824);
                    } else {
                        makeMeasureSpec3 = View.MeasureSpec.makeMeasureSpec(i11, 1073741824);
                    }
                }
                int i12 = ((ViewGroup.MarginLayoutParams) layoutParams).height;
                if (i12 == -2) {
                    i8 = Integer.MIN_VALUE;
                    makeMeasureSpec4 = View.MeasureSpec.makeMeasureSpec(paddingTop, Integer.MIN_VALUE);
                } else {
                    i8 = Integer.MIN_VALUE;
                    if (i12 == i7) {
                        makeMeasureSpec4 = View.MeasureSpec.makeMeasureSpec(paddingTop, 1073741824);
                    } else {
                        makeMeasureSpec4 = View.MeasureSpec.makeMeasureSpec(i12, 1073741824);
                    }
                }
                childAt.measure(makeMeasureSpec3, makeMeasureSpec4);
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                if (mode2 == i8 && measuredHeight > i3) {
                    i3 = Math.min(measuredHeight, paddingTop);
                }
                paddingLeft -= measuredWidth;
                boolean z3 = paddingLeft < 0;
                layoutParams.slideable = z3;
                z2 |= z3;
                if (z3) {
                    this.mSlideableView = childAt;
                }
            }
            i9++;
            z = false;
            f2 = 0.0f;
        }
        if (z2 || f3 > 0.0f) {
            int i13 = size - this.mOverhangSize;
            int i14 = 0;
            while (i14 < childCount) {
                View childAt2 = getChildAt(i14);
                if (childAt2.getVisibility() != i4) {
                    LayoutParams layoutParams2 = (LayoutParams) childAt2.getLayoutParams();
                    if (childAt2.getVisibility() != i4) {
                        boolean z4 = ((ViewGroup.MarginLayoutParams) layoutParams2).width == 0 && layoutParams2.weight > 0.0f;
                        int measuredWidth2 = z4 ? 0 : childAt2.getMeasuredWidth();
                        if (z2 && childAt2 != this.mSlideableView) {
                            if (((ViewGroup.MarginLayoutParams) layoutParams2).width < 0 && (measuredWidth2 > i13 || layoutParams2.weight > 0.0f)) {
                                if (z4) {
                                    int i15 = ((ViewGroup.MarginLayoutParams) layoutParams2).height;
                                    if (i15 == -2) {
                                        makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(paddingTop, Integer.MIN_VALUE);
                                        i6 = 1073741824;
                                    } else if (i15 == -1) {
                                        i6 = 1073741824;
                                        makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(paddingTop, 1073741824);
                                    } else {
                                        i6 = 1073741824;
                                        makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i15, 1073741824);
                                    }
                                } else {
                                    i6 = 1073741824;
                                    makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(childAt2.getMeasuredHeight(), 1073741824);
                                }
                                childAt2.measure(View.MeasureSpec.makeMeasureSpec(this.mAutoSlide ? i13 : size, i6), makeMeasureSpec2);
                            }
                        } else if (layoutParams2.weight > 0.0f) {
                            if (((ViewGroup.MarginLayoutParams) layoutParams2).width == 0) {
                                int i16 = ((ViewGroup.MarginLayoutParams) layoutParams2).height;
                                if (i16 == -2) {
                                    makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(paddingTop, Integer.MIN_VALUE);
                                    i5 = 1073741824;
                                } else if (i16 == -1) {
                                    i5 = 1073741824;
                                    makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(paddingTop, 1073741824);
                                } else {
                                    i5 = 1073741824;
                                    makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i16, 1073741824);
                                }
                            } else {
                                i5 = 1073741824;
                                makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(childAt2.getMeasuredHeight(), 1073741824);
                            }
                            if (z2) {
                                int i17 = size - (((ViewGroup.MarginLayoutParams) layoutParams2).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams2).rightMargin);
                                int makeMeasureSpec5 = View.MeasureSpec.makeMeasureSpec(i17, i5);
                                if (measuredWidth2 != i17) {
                                    childAt2.measure(makeMeasureSpec5, makeMeasureSpec);
                                }
                            } else {
                                childAt2.measure(View.MeasureSpec.makeMeasureSpec(measuredWidth2 + ((int) ((layoutParams2.weight * Math.max(0, paddingLeft)) / f3)), 1073741824), makeMeasureSpec);
                                i14++;
                                i4 = 8;
                            }
                        }
                    }
                }
                i14++;
                i4 = 8;
            }
        }
        setMeasuredDimension(size, i3);
        this.mCanSlide = z2;
        if (this.mDragHelper.getViewDragState() == 0 || z2) {
            return;
        }
        this.mDragHelper.abort();
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (savedState.isOpen) {
            openPane();
        } else {
            closePane();
        }
        this.mPreservedOpenState = savedState.isOpen;
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.isOpen = isSlideable() ? isOpen() : this.mPreservedOpenState;
        return savedState;
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i != i3) {
            this.mFirstLayout = true;
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.mCanSlide) {
            return super.onTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            this.mInitialMotionX = x;
            this.mInitialMotionY = y;
        } else if (action != 1) {
            if (action == 2) {
                float x2 = motionEvent.getX();
                if (Math.abs(motionEvent.getY() - this.mInitialMotionY) > Math.abs(x2 - this.mInitialMotionX)) {
                    return true;
                }
            }
        } else if (isDimmed(this.mSlideableView)) {
            float x3 = motionEvent.getX();
            float y2 = motionEvent.getY();
            float f2 = x3 - this.mInitialMotionX;
            float f3 = y2 - this.mInitialMotionY;
            int touchSlop = this.mDragHelper.getTouchSlop();
            if ((f2 * f2) + (f3 * f3) < touchSlop * touchSlop && this.mDragHelper.isViewUnder(this.mSlideableView, (int) x3, (int) y2)) {
                closePane(this.mSlideableView, 0);
            }
        }
        try {
            this.mDragHelper.processTouchEvent(motionEvent);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return true;
    }

    public boolean openPane() {
        return openPane(this.mSlideableView, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestChildFocus(View view, View view2) {
        super.requestChildFocus(view, view2);
        if (isInTouchMode() || this.mCanSlide) {
            return;
        }
        this.mPreservedOpenState = view == this.mSlideableView;
    }

    public void setActivityIsTranslucent(boolean z) {
        this.mIsActivityTranslucent = z;
    }

    public void setAllChildrenVisible() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 4) {
                childAt.setVisibility(0);
            }
        }
    }

    public void setAutoSlideToRight(boolean z) {
        this.mAutoSlide = z;
    }

    public void setCanSlideRegionFactor(double d2) {
        this.slideWidthFactor = d2;
    }

    public void setCoveredFadeColor(int i) {
        this.mCoveredFadeColor = i;
    }

    public void setEnableReleaseWhenNoTranslucent(boolean z) {
        this.mEnableReleaseWhenNoTranslucent = z;
    }

    public void setPanelSlideListener(PanelSlideListener panelSlideListener) {
        this.mPanelSlideListener = panelSlideListener;
    }

    public void setParallaxDistance(int i) {
        this.mParallaxBy = i;
        requestLayout();
    }

    public void setShadowDrawable(Drawable drawable) {
        this.mShadowDrawable = drawable;
    }

    public void setShadowResource(int i) {
        setShadowDrawable(getResources().getDrawable(i));
    }

    public void setSliderFadeColor(int i) {
        this.mSliderFadeColor = i;
    }

    @Deprecated
    public void smoothSlideClosed() {
        closePane();
    }

    @Deprecated
    public void smoothSlideOpen() {
        openPane();
    }

    public boolean smoothSlideTo(float f2, int i) {
        if (this.mCanSlide) {
            int paddingLeft = (int) (getPaddingLeft() + ((ViewGroup.MarginLayoutParams) ((LayoutParams) this.mSlideableView.getLayoutParams())).leftMargin + (f2 * this.mSlideRange));
            ViewDragHelper viewDragHelper = this.mDragHelper;
            View view = this.mSlideableView;
            if (viewDragHelper.smoothSlideViewTo(view, paddingLeft, view.getTop())) {
                setAllChildrenVisible();
                ViewCompat.postInvalidateOnAnimation(this);
                return true;
            }
            return false;
        }
        return false;
    }

    public void updateObscuredViewsVisibility(View view) {
        int i;
        int i2;
        int i3;
        int i4;
        View childAt;
        View view2 = view;
        int paddingLeft = getPaddingLeft();
        int width = getWidth() - getPaddingRight();
        int paddingTop = getPaddingTop();
        int height = getHeight() - getPaddingBottom();
        if (view2 == null || !viewIsOpaque(view)) {
            i = 0;
            i2 = 0;
            i3 = 0;
            i4 = 0;
        } else {
            i = view.getLeft();
            i2 = view.getRight();
            i3 = view.getTop();
            i4 = view.getBottom();
        }
        int childCount = getChildCount();
        int i5 = 0;
        while (i5 < childCount && (childAt = getChildAt(i5)) != view2) {
            childAt.setVisibility((Math.max(paddingLeft, childAt.getLeft()) < i || Math.max(paddingTop, childAt.getTop()) < i3 || Math.min(width, childAt.getRight()) > i2 || Math.min(height, childAt.getBottom()) > i4) ? 0 : 4);
            i5++;
            view2 = view;
        }
    }

    /* loaded from: classes3.dex */
    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        public static final int[] ATTRS = {16843137};
        public Paint dimPaint;
        public boolean dimWhenOffset;
        public boolean slideable;
        public float weight;

        public LayoutParams() {
            super(-1, -1);
            this.weight = 0.0f;
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
            this.weight = 0.0f;
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.weight = 0.0f;
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.weight = 0.0f;
        }

        public LayoutParams(LayoutParams layoutParams) {
            super((ViewGroup.MarginLayoutParams) layoutParams);
            this.weight = 0.0f;
            this.weight = layoutParams.weight;
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.weight = 0.0f;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ATTRS);
            this.weight = obtainStyledAttributes.getFloat(0, 0.0f);
            obtainStyledAttributes.recycle();
        }
    }

    public SlidingPaneLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private boolean closePane(View view, int i) {
        if (this.mFirstLayout || smoothSlideTo(0.0f, i)) {
            this.mPreservedOpenState = false;
            return true;
        }
        return false;
    }

    private boolean openPane(View view, int i) {
        if (this.mFirstLayout || smoothSlideTo(1.0f, i)) {
            this.mPreservedOpenState = true;
            return true;
        }
        return false;
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    public SlidingPaneLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSliderFadeColor = -858993460;
        this.mEnableReleaseWhenNoTranslucent = true;
        this.slideWidthFactor = 0.25d;
        this.slideEdgeFactor = 0.15d;
        this.showShadow = true;
        this.mFirstLayout = true;
        this.mTmpRect = new Rect();
        this.mPostedRunnables = new ArrayList<>();
        this.mAutoSlide = true;
        float f2 = context.getResources().getDisplayMetrics().density;
        this.mOverhangSize = 5;
        this.mScreenWidth = context.getResources().getDisplayMetrics().widthPixels;
        setWillNotDraw(false);
        ViewCompat.setAccessibilityDelegate(this, new AccessibilityDelegate());
        ViewCompat.setImportantForAccessibility(this, 1);
        ViewDragHelper create = ViewDragHelper.create(this, 0.5f, new DragHelperCallback());
        this.mDragHelper = create;
        create.setEdgeTrackingEnabled(1);
        this.mDragHelper.setMinVelocity(f2 * 400.0f);
    }
}
