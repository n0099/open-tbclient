package android.support.v4.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.ColorInt;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.AbsSavedState;
import android.support.v4.view.AccessibilityDelegateCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.widget.ViewDragHelper;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
/* loaded from: classes8.dex */
public class SlidingPaneLayout extends ViewGroup {
    private static final int DEFAULT_FADE_COLOR = -858993460;
    private static final int DEFAULT_OVERHANG_SIZE = 32;
    static final SlidingPanelLayoutImpl IMPL;
    private static final int MIN_FLING_VELOCITY = 400;
    private static final String TAG = "SlidingPaneLayout";
    private boolean mCanSlide;
    private int mCoveredFadeColor;
    final ViewDragHelper mDragHelper;
    private boolean mFirstLayout;
    private float mInitialMotionX;
    private float mInitialMotionY;
    boolean mIsUnableToDrag;
    private final int mOverhangSize;
    private PanelSlideListener mPanelSlideListener;
    private int mParallaxBy;
    private float mParallaxOffset;
    final ArrayList<DisableLayerRunnable> mPostedRunnables;
    boolean mPreservedOpenState;
    private Drawable mShadowDrawableLeft;
    private Drawable mShadowDrawableRight;
    float mSlideOffset;
    int mSlideRange;
    View mSlideableView;
    private int mSliderFadeColor;
    private final Rect mTmpRect;

    /* loaded from: classes8.dex */
    public interface PanelSlideListener {
        void onPanelClosed(@NonNull View view);

        void onPanelOpened(@NonNull View view);

        void onPanelSlide(@NonNull View view, float f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes8.dex */
    public interface SlidingPanelLayoutImpl {
        void invalidateChildRegion(SlidingPaneLayout slidingPaneLayout, View view);
    }

    static {
        if (Build.VERSION.SDK_INT >= 17) {
            IMPL = new SlidingPanelLayoutImplJBMR1();
        } else if (Build.VERSION.SDK_INT >= 16) {
            IMPL = new SlidingPanelLayoutImplJB();
        } else {
            IMPL = new SlidingPanelLayoutImplBase();
        }
    }

    /* loaded from: classes8.dex */
    public static class SimplePanelSlideListener implements PanelSlideListener {
        @Override // android.support.v4.widget.SlidingPaneLayout.PanelSlideListener
        public void onPanelSlide(View view, float f) {
        }

        @Override // android.support.v4.widget.SlidingPaneLayout.PanelSlideListener
        public void onPanelOpened(View view) {
        }

        @Override // android.support.v4.widget.SlidingPaneLayout.PanelSlideListener
        public void onPanelClosed(View view) {
        }
    }

    public SlidingPaneLayout(@NonNull Context context) {
        this(context, null);
    }

    public SlidingPaneLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SlidingPaneLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSliderFadeColor = DEFAULT_FADE_COLOR;
        this.mFirstLayout = true;
        this.mTmpRect = new Rect();
        this.mPostedRunnables = new ArrayList<>();
        float f = context.getResources().getDisplayMetrics().density;
        this.mOverhangSize = (int) ((32.0f * f) + 0.5f);
        setWillNotDraw(false);
        ViewCompat.setAccessibilityDelegate(this, new AccessibilityDelegate());
        ViewCompat.setImportantForAccessibility(this, 1);
        this.mDragHelper = ViewDragHelper.create(this, 0.5f, new DragHelperCallback());
        this.mDragHelper.setMinVelocity(f * 400.0f);
    }

    public void setParallaxDistance(int i) {
        this.mParallaxBy = i;
        requestLayout();
    }

    public int getParallaxDistance() {
        return this.mParallaxBy;
    }

    public void setSliderFadeColor(@ColorInt int i) {
        this.mSliderFadeColor = i;
    }

    @ColorInt
    public int getSliderFadeColor() {
        return this.mSliderFadeColor;
    }

    public void setCoveredFadeColor(@ColorInt int i) {
        this.mCoveredFadeColor = i;
    }

    @ColorInt
    public int getCoveredFadeColor() {
        return this.mCoveredFadeColor;
    }

    public void setPanelSlideListener(@Nullable PanelSlideListener panelSlideListener) {
        this.mPanelSlideListener = panelSlideListener;
    }

    void dispatchOnPanelSlide(View view) {
        if (this.mPanelSlideListener != null) {
            this.mPanelSlideListener.onPanelSlide(view, this.mSlideOffset);
        }
    }

    void dispatchOnPanelOpened(View view) {
        if (this.mPanelSlideListener != null) {
            this.mPanelSlideListener.onPanelOpened(view);
        }
        sendAccessibilityEvent(32);
    }

    void dispatchOnPanelClosed(View view) {
        if (this.mPanelSlideListener != null) {
            this.mPanelSlideListener.onPanelClosed(view);
        }
        sendAccessibilityEvent(32);
    }

    void updateObscuredViewsVisibility(View view) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        boolean isLayoutRtlSupport = isLayoutRtlSupport();
        int width = isLayoutRtlSupport ? getWidth() - getPaddingRight() : getPaddingLeft();
        int paddingLeft = isLayoutRtlSupport ? getPaddingLeft() : getWidth() - getPaddingRight();
        int paddingTop = getPaddingTop();
        int height = getHeight() - getPaddingBottom();
        if (view != null && viewIsOpaque(view)) {
            i4 = view.getLeft();
            i3 = view.getRight();
            i2 = view.getTop();
            i = view.getBottom();
        } else {
            i = 0;
            i2 = 0;
            i3 = 0;
            i4 = 0;
        }
        int childCount = getChildCount();
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            if (childAt != view) {
                if (childAt.getVisibility() != 8) {
                    int max = Math.max(isLayoutRtlSupport ? paddingLeft : width, childAt.getLeft());
                    int max2 = Math.max(paddingTop, childAt.getTop());
                    int min = Math.min(isLayoutRtlSupport ? width : paddingLeft, childAt.getRight());
                    int min2 = Math.min(height, childAt.getBottom());
                    if (max >= i4 && max2 >= i2 && min <= i3 && min2 <= i) {
                        i5 = 4;
                    } else {
                        i5 = 0;
                    }
                    childAt.setVisibility(i5);
                }
            } else {
                return;
            }
        }
    }

    void setAllChildrenVisible() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 4) {
                childAt.setVisibility(0);
            }
        }
    }

    private static boolean viewIsOpaque(View view) {
        Drawable background;
        if (view.isOpaque()) {
            return true;
        }
        return Build.VERSION.SDK_INT < 18 && (background = view.getBackground()) != null && background.getOpacity() == -1;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mFirstLayout = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mFirstLayout = true;
        int size = this.mPostedRunnables.size();
        for (int i = 0; i < size; i++) {
            this.mPostedRunnables.get(i).run();
        }
        this.mPostedRunnables.clear();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int i3;
        int i4;
        int i5;
        int i6;
        int paddingTop;
        int makeMeasureSpec;
        int makeMeasureSpec2;
        int makeMeasureSpec3;
        int makeMeasureSpec4;
        int i7;
        int i8;
        boolean z;
        float f;
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i2);
        if (mode != 1073741824) {
            if (isInEditMode()) {
                if (mode == Integer.MIN_VALUE) {
                    i3 = mode2;
                    i4 = size;
                    i5 = size2;
                } else {
                    if (mode == 0) {
                        i3 = mode2;
                        i4 = 300;
                        i5 = size2;
                    }
                    i3 = mode2;
                    i4 = size;
                    i5 = size2;
                }
            } else {
                throw new IllegalStateException("Width must have an exact value or MATCH_PARENT");
            }
        } else {
            if (mode2 == 0) {
                if (isInEditMode()) {
                    if (mode2 == 0) {
                        i3 = Integer.MIN_VALUE;
                        i4 = size;
                        i5 = 300;
                    }
                } else {
                    throw new IllegalStateException("Height must not be UNSPECIFIED");
                }
            }
            i3 = mode2;
            i4 = size;
            i5 = size2;
        }
        switch (i3) {
            case Integer.MIN_VALUE:
                i6 = 0;
                paddingTop = (i5 - getPaddingTop()) - getPaddingBottom();
                break;
            case 1073741824:
                i6 = (i5 - getPaddingTop()) - getPaddingBottom();
                paddingTop = i6;
                break;
            default:
                i6 = 0;
                paddingTop = 0;
                break;
        }
        boolean z2 = false;
        int paddingLeft = (i4 - getPaddingLeft()) - getPaddingRight();
        int childCount = getChildCount();
        if (childCount > 2) {
            Log.e(TAG, "onMeasure: More than two child views are not supported.");
        }
        this.mSlideableView = null;
        int i9 = 0;
        int i10 = paddingLeft;
        int i11 = i6;
        float f2 = 0.0f;
        while (i9 < childCount) {
            View childAt = getChildAt(i9);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            if (childAt.getVisibility() == 8) {
                layoutParams.dimWhenOffset = false;
                i7 = i10;
                f = f2;
                i8 = i11;
                z = z2;
            } else {
                if (layoutParams.weight > 0.0f) {
                    f2 += layoutParams.weight;
                    if (layoutParams.width == 0) {
                        i7 = i10;
                        f = f2;
                        i8 = i11;
                        z = z2;
                    }
                }
                int i12 = layoutParams.leftMargin + layoutParams.rightMargin;
                if (layoutParams.width == -2) {
                    makeMeasureSpec3 = View.MeasureSpec.makeMeasureSpec(paddingLeft - i12, Integer.MIN_VALUE);
                } else if (layoutParams.width == -1) {
                    makeMeasureSpec3 = View.MeasureSpec.makeMeasureSpec(paddingLeft - i12, 1073741824);
                } else {
                    makeMeasureSpec3 = View.MeasureSpec.makeMeasureSpec(layoutParams.width, 1073741824);
                }
                if (layoutParams.height == -2) {
                    makeMeasureSpec4 = View.MeasureSpec.makeMeasureSpec(paddingTop, Integer.MIN_VALUE);
                } else if (layoutParams.height == -1) {
                    makeMeasureSpec4 = View.MeasureSpec.makeMeasureSpec(paddingTop, 1073741824);
                } else {
                    makeMeasureSpec4 = View.MeasureSpec.makeMeasureSpec(layoutParams.height, 1073741824);
                }
                childAt.measure(makeMeasureSpec3, makeMeasureSpec4);
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                if (i3 == Integer.MIN_VALUE && measuredHeight > i11) {
                    i11 = Math.min(measuredHeight, paddingTop);
                }
                int i13 = i10 - measuredWidth;
                boolean z3 = i13 < 0;
                layoutParams.slideable = z3;
                boolean z4 = z3 | z2;
                if (layoutParams.slideable) {
                    this.mSlideableView = childAt;
                }
                i7 = i13;
                i8 = i11;
                float f3 = f2;
                z = z4;
                f = f3;
            }
            i9++;
            z2 = z;
            i11 = i8;
            f2 = f;
            i10 = i7;
        }
        if (z2 || f2 > 0.0f) {
            int i14 = paddingLeft - this.mOverhangSize;
            for (int i15 = 0; i15 < childCount; i15++) {
                View childAt2 = getChildAt(i15);
                if (childAt2.getVisibility() != 8) {
                    LayoutParams layoutParams2 = (LayoutParams) childAt2.getLayoutParams();
                    if (childAt2.getVisibility() != 8) {
                        boolean z5 = layoutParams2.width == 0 && layoutParams2.weight > 0.0f;
                        int measuredWidth2 = z5 ? 0 : childAt2.getMeasuredWidth();
                        if (z2 && childAt2 != this.mSlideableView) {
                            if (layoutParams2.width < 0 && (measuredWidth2 > i14 || layoutParams2.weight > 0.0f)) {
                                if (z5) {
                                    if (layoutParams2.height == -2) {
                                        makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(paddingTop, Integer.MIN_VALUE);
                                    } else if (layoutParams2.height == -1) {
                                        makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(paddingTop, 1073741824);
                                    } else {
                                        makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(layoutParams2.height, 1073741824);
                                    }
                                } else {
                                    makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(childAt2.getMeasuredHeight(), 1073741824);
                                }
                                childAt2.measure(View.MeasureSpec.makeMeasureSpec(i14, 1073741824), makeMeasureSpec2);
                            }
                        } else if (layoutParams2.weight > 0.0f) {
                            if (layoutParams2.width == 0) {
                                if (layoutParams2.height == -2) {
                                    makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(paddingTop, Integer.MIN_VALUE);
                                } else if (layoutParams2.height == -1) {
                                    makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(paddingTop, 1073741824);
                                } else {
                                    makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(layoutParams2.height, 1073741824);
                                }
                            } else {
                                makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(childAt2.getMeasuredHeight(), 1073741824);
                            }
                            if (z2) {
                                int i16 = paddingLeft - (layoutParams2.rightMargin + layoutParams2.leftMargin);
                                int makeMeasureSpec5 = View.MeasureSpec.makeMeasureSpec(i16, 1073741824);
                                if (measuredWidth2 != i16) {
                                    childAt2.measure(makeMeasureSpec5, makeMeasureSpec);
                                }
                            } else {
                                childAt2.measure(View.MeasureSpec.makeMeasureSpec(((int) ((layoutParams2.weight * Math.max(0, i10)) / f2)) + measuredWidth2, 1073741824), makeMeasureSpec);
                            }
                        }
                    }
                }
            }
        }
        setMeasuredDimension(i4, getPaddingTop() + i11 + getPaddingBottom());
        this.mCanSlide = z2;
        if (this.mDragHelper.getViewDragState() != 0 && !z2) {
            this.mDragHelper.abort();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int i7;
        int i8;
        int width;
        int i9;
        boolean isLayoutRtlSupport = isLayoutRtlSupport();
        if (isLayoutRtlSupport) {
            this.mDragHelper.setEdgeTrackingEnabled(2);
        } else {
            this.mDragHelper.setEdgeTrackingEnabled(1);
        }
        int i10 = i3 - i;
        int paddingRight = isLayoutRtlSupport ? getPaddingRight() : getPaddingLeft();
        int paddingLeft = isLayoutRtlSupport ? getPaddingLeft() : getPaddingRight();
        int paddingTop = getPaddingTop();
        int childCount = getChildCount();
        if (this.mFirstLayout) {
            this.mSlideOffset = (this.mCanSlide && this.mPreservedOpenState) ? 1.0f : 0.0f;
        }
        int i11 = 0;
        int i12 = paddingRight;
        while (i11 < childCount) {
            View childAt = getChildAt(i11);
            if (childAt.getVisibility() == 8) {
                width = paddingRight;
                i9 = i12;
            } else {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                int measuredWidth = childAt.getMeasuredWidth();
                if (layoutParams.slideable) {
                    int min = (Math.min(paddingRight, (i10 - paddingLeft) - this.mOverhangSize) - i12) - (layoutParams.leftMargin + layoutParams.rightMargin);
                    this.mSlideRange = min;
                    int i13 = isLayoutRtlSupport ? layoutParams.rightMargin : layoutParams.leftMargin;
                    layoutParams.dimWhenOffset = ((i12 + i13) + min) + (measuredWidth / 2) > i10 - paddingLeft;
                    int i14 = (int) (min * this.mSlideOffset);
                    i6 = i12 + i13 + i14;
                    this.mSlideOffset = i14 / this.mSlideRange;
                    i5 = 0;
                } else if (!this.mCanSlide || this.mParallaxBy == 0) {
                    i5 = 0;
                    i6 = paddingRight;
                } else {
                    i5 = (int) ((1.0f - this.mSlideOffset) * this.mParallaxBy);
                    i6 = paddingRight;
                }
                if (isLayoutRtlSupport) {
                    i8 = (i10 - i6) + i5;
                    i7 = i8 - measuredWidth;
                } else {
                    i7 = i6 - i5;
                    i8 = i7 + measuredWidth;
                }
                childAt.layout(i7, paddingTop, i8, childAt.getMeasuredHeight() + paddingTop);
                width = childAt.getWidth() + paddingRight;
                i9 = i6;
            }
            i11++;
            paddingRight = width;
            i12 = i9;
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
                for (int i15 = 0; i15 < childCount; i15++) {
                    dimChildView(getChildAt(i15), 0.0f, this.mSliderFadeColor);
                }
            }
            updateObscuredViewsVisibility(this.mSlideableView);
        }
        this.mFirstLayout = false;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i != i3) {
            this.mFirstLayout = true;
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestChildFocus(View view, View view2) {
        super.requestChildFocus(view, view2);
        if (!isInTouchMode() && !this.mCanSlide) {
            this.mPreservedOpenState = view == this.mSlideableView;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z;
        View childAt;
        int actionMasked = motionEvent.getActionMasked();
        if (!this.mCanSlide && actionMasked == 0 && getChildCount() > 1 && (childAt = getChildAt(1)) != null) {
            this.mPreservedOpenState = !this.mDragHelper.isViewUnder(childAt, (int) motionEvent.getX(), (int) motionEvent.getY());
        }
        if (!this.mCanSlide || (this.mIsUnableToDrag && actionMasked != 0)) {
            this.mDragHelper.cancel();
            return super.onInterceptTouchEvent(motionEvent);
        } else if (actionMasked == 3 || actionMasked == 1) {
            this.mDragHelper.cancel();
            return false;
        } else {
            switch (actionMasked) {
                case 0:
                    this.mIsUnableToDrag = false;
                    float x = motionEvent.getX();
                    float y = motionEvent.getY();
                    this.mInitialMotionX = x;
                    this.mInitialMotionY = y;
                    if (this.mDragHelper.isViewUnder(this.mSlideableView, (int) x, (int) y) && isDimmed(this.mSlideableView)) {
                        z = true;
                        break;
                    }
                    z = false;
                    break;
                case 1:
                default:
                    z = false;
                    break;
                case 2:
                    float x2 = motionEvent.getX();
                    float y2 = motionEvent.getY();
                    float abs = Math.abs(x2 - this.mInitialMotionX);
                    float abs2 = Math.abs(y2 - this.mInitialMotionY);
                    if (abs > this.mDragHelper.getTouchSlop() && abs2 > abs) {
                        this.mDragHelper.cancel();
                        this.mIsUnableToDrag = true;
                        return false;
                    }
                    z = false;
                    break;
            }
            return this.mDragHelper.shouldInterceptTouchEvent(motionEvent) || z;
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.mCanSlide) {
            return super.onTouchEvent(motionEvent);
        }
        this.mDragHelper.processTouchEvent(motionEvent);
        switch (motionEvent.getActionMasked()) {
            case 0:
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                this.mInitialMotionX = x;
                this.mInitialMotionY = y;
                return true;
            case 1:
                if (!isDimmed(this.mSlideableView)) {
                    return true;
                }
                float x2 = motionEvent.getX();
                float y2 = motionEvent.getY();
                float f = x2 - this.mInitialMotionX;
                float f2 = y2 - this.mInitialMotionY;
                int touchSlop = this.mDragHelper.getTouchSlop();
                if ((f * f) + (f2 * f2) >= touchSlop * touchSlop || !this.mDragHelper.isViewUnder(this.mSlideableView, (int) x2, (int) y2)) {
                    return true;
                }
                closePane(this.mSlideableView, 0);
                return true;
            default:
                return true;
        }
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

    @Deprecated
    public void smoothSlideOpen() {
        openPane();
    }

    public boolean openPane() {
        return openPane(this.mSlideableView, 0);
    }

    @Deprecated
    public void smoothSlideClosed() {
        closePane();
    }

    public boolean closePane() {
        return closePane(this.mSlideableView, 0);
    }

    public boolean isOpen() {
        return !this.mCanSlide || this.mSlideOffset == 1.0f;
    }

    @Deprecated
    public boolean canSlide() {
        return this.mCanSlide;
    }

    public boolean isSlideable() {
        return this.mCanSlide;
    }

    void onPanelDragged(int i) {
        if (this.mSlideableView == null) {
            this.mSlideOffset = 0.0f;
            return;
        }
        boolean isLayoutRtlSupport = isLayoutRtlSupport();
        LayoutParams layoutParams = (LayoutParams) this.mSlideableView.getLayoutParams();
        int width = this.mSlideableView.getWidth();
        if (isLayoutRtlSupport) {
            i = (getWidth() - i) - width;
        }
        this.mSlideOffset = (i - ((isLayoutRtlSupport ? layoutParams.rightMargin : layoutParams.leftMargin) + (isLayoutRtlSupport ? getPaddingRight() : getPaddingLeft()))) / this.mSlideRange;
        if (this.mParallaxBy != 0) {
            parallaxOtherViews(this.mSlideOffset);
        }
        if (layoutParams.dimWhenOffset) {
            dimChildView(this.mSlideableView, this.mSlideOffset, this.mSliderFadeColor);
        }
        dispatchOnPanelSlide(this.mSlideableView);
    }

    private void dimChildView(View view, float f, int i) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (f > 0.0f && i != 0) {
            int i2 = (((int) ((((-16777216) & i) >>> 24) * f)) << 24) | (16777215 & i);
            if (layoutParams.dimPaint == null) {
                layoutParams.dimPaint = new Paint();
            }
            layoutParams.dimPaint.setColorFilter(new PorterDuffColorFilter(i2, PorterDuff.Mode.SRC_OVER));
            if (view.getLayerType() != 2) {
                view.setLayerType(2, layoutParams.dimPaint);
            }
            invalidateChildRegion(view);
        } else if (view.getLayerType() != 0) {
            if (layoutParams.dimPaint != null) {
                layoutParams.dimPaint.setColorFilter(null);
            }
            DisableLayerRunnable disableLayerRunnable = new DisableLayerRunnable(view);
            this.mPostedRunnables.add(disableLayerRunnable);
            ViewCompat.postOnAnimation(this, disableLayerRunnable);
        }
    }

    @Override // android.view.ViewGroup
    protected boolean drawChild(Canvas canvas, View view, long j) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int save = canvas.save();
        if (this.mCanSlide && !layoutParams.slideable && this.mSlideableView != null) {
            canvas.getClipBounds(this.mTmpRect);
            if (isLayoutRtlSupport()) {
                this.mTmpRect.left = Math.max(this.mTmpRect.left, this.mSlideableView.getRight());
            } else {
                this.mTmpRect.right = Math.min(this.mTmpRect.right, this.mSlideableView.getLeft());
            }
            canvas.clipRect(this.mTmpRect);
        }
        boolean drawChild = super.drawChild(canvas, view, j);
        canvas.restoreToCount(save);
        return drawChild;
    }

    void invalidateChildRegion(View view) {
        IMPL.invalidateChildRegion(this, view);
    }

    boolean smoothSlideTo(float f, int i) {
        int paddingLeft;
        if (this.mCanSlide) {
            boolean isLayoutRtlSupport = isLayoutRtlSupport();
            LayoutParams layoutParams = (LayoutParams) this.mSlideableView.getLayoutParams();
            if (isLayoutRtlSupport) {
                paddingLeft = (int) (getWidth() - (((layoutParams.rightMargin + getPaddingRight()) + (this.mSlideRange * f)) + this.mSlideableView.getWidth()));
            } else {
                paddingLeft = (int) (layoutParams.leftMargin + getPaddingLeft() + (this.mSlideRange * f));
            }
            if (this.mDragHelper.smoothSlideViewTo(this.mSlideableView, paddingLeft, this.mSlideableView.getTop())) {
                setAllChildrenVisible();
                ViewCompat.postInvalidateOnAnimation(this);
                return true;
            }
            return false;
        }
        return false;
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

    @Deprecated
    public void setShadowDrawable(Drawable drawable) {
        setShadowDrawableLeft(drawable);
    }

    public void setShadowDrawableLeft(@Nullable Drawable drawable) {
        this.mShadowDrawableLeft = drawable;
    }

    public void setShadowDrawableRight(@Nullable Drawable drawable) {
        this.mShadowDrawableRight = drawable;
    }

    @Deprecated
    public void setShadowResource(@DrawableRes int i) {
        setShadowDrawable(getResources().getDrawable(i));
    }

    public void setShadowResourceLeft(int i) {
        setShadowDrawableLeft(ContextCompat.getDrawable(getContext(), i));
    }

    public void setShadowResourceRight(int i) {
        setShadowDrawableRight(ContextCompat.getDrawable(getContext(), i));
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        Drawable drawable;
        int left;
        int i;
        super.draw(canvas);
        if (isLayoutRtlSupport()) {
            drawable = this.mShadowDrawableRight;
        } else {
            drawable = this.mShadowDrawableLeft;
        }
        View childAt = getChildCount() > 1 ? getChildAt(1) : null;
        if (childAt != null && drawable != null) {
            int top = childAt.getTop();
            int bottom = childAt.getBottom();
            int intrinsicWidth = drawable.getIntrinsicWidth();
            if (isLayoutRtlSupport()) {
                i = childAt.getRight();
                left = i + intrinsicWidth;
            } else {
                left = childAt.getLeft();
                i = left - intrinsicWidth;
            }
            drawable.setBounds(i, top, left, bottom);
            drawable.draw(canvas);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void parallaxOtherViews(float f) {
        boolean z;
        int childCount;
        int i;
        boolean isLayoutRtlSupport = isLayoutRtlSupport();
        LayoutParams layoutParams = (LayoutParams) this.mSlideableView.getLayoutParams();
        if (layoutParams.dimWhenOffset) {
            if ((isLayoutRtlSupport ? layoutParams.rightMargin : layoutParams.leftMargin) <= 0) {
                z = true;
                childCount = getChildCount();
                for (i = 0; i < childCount; i++) {
                    View childAt = getChildAt(i);
                    if (childAt != this.mSlideableView) {
                        this.mParallaxOffset = f;
                        int i2 = ((int) ((1.0f - this.mParallaxOffset) * this.mParallaxBy)) - ((int) ((1.0f - f) * this.mParallaxBy));
                        if (isLayoutRtlSupport) {
                            i2 = -i2;
                        }
                        childAt.offsetLeftAndRight(i2);
                        if (z) {
                            dimChildView(childAt, isLayoutRtlSupport ? this.mParallaxOffset - 1.0f : 1.0f - this.mParallaxOffset, this.mCoveredFadeColor);
                        }
                    }
                }
            }
        }
        z = false;
        childCount = getChildCount();
        while (i < childCount) {
        }
    }

    protected boolean canScroll(View view, boolean z, int i, int i2, int i3) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int scrollX = view.getScrollX();
            int scrollY = view.getScrollY();
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                if (i2 + scrollX >= childAt.getLeft() && i2 + scrollX < childAt.getRight() && i3 + scrollY >= childAt.getTop() && i3 + scrollY < childAt.getBottom() && canScroll(childAt, true, i, (i2 + scrollX) - childAt.getLeft(), (i3 + scrollY) - childAt.getTop())) {
                    return true;
                }
            }
        }
        if (z) {
            if (!isLayoutRtlSupport()) {
                i = -i;
            }
            if (view.canScrollHorizontally(i)) {
                return true;
            }
        }
        return false;
    }

    boolean isDimmed(View view) {
        if (view == null) {
            return false;
        }
        return this.mCanSlide && ((LayoutParams) view.getLayoutParams()).dimWhenOffset && this.mSlideOffset > 0.0f;
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams) : new LayoutParams(layoutParams);
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof LayoutParams) && super.checkLayoutParams(layoutParams);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.isOpen = isSlideable() ? isOpen() : this.mPreservedOpenState;
        return savedState;
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (savedState.isOpen) {
            openPane();
        } else {
            closePane();
        }
        this.mPreservedOpenState = savedState.isOpen;
    }

    /* loaded from: classes8.dex */
    private class DragHelperCallback extends ViewDragHelper.Callback {
        DragHelperCallback() {
        }

        @Override // android.support.v4.widget.ViewDragHelper.Callback
        public boolean tryCaptureView(View view, int i) {
            if (SlidingPaneLayout.this.mIsUnableToDrag) {
                return false;
            }
            return ((LayoutParams) view.getLayoutParams()).slideable;
        }

        @Override // android.support.v4.widget.ViewDragHelper.Callback
        public void onViewDragStateChanged(int i) {
            if (SlidingPaneLayout.this.mDragHelper.getViewDragState() == 0) {
                if (SlidingPaneLayout.this.mSlideOffset == 0.0f) {
                    SlidingPaneLayout.this.updateObscuredViewsVisibility(SlidingPaneLayout.this.mSlideableView);
                    SlidingPaneLayout.this.dispatchOnPanelClosed(SlidingPaneLayout.this.mSlideableView);
                    SlidingPaneLayout.this.mPreservedOpenState = false;
                    return;
                }
                SlidingPaneLayout.this.dispatchOnPanelOpened(SlidingPaneLayout.this.mSlideableView);
                SlidingPaneLayout.this.mPreservedOpenState = true;
            }
        }

        @Override // android.support.v4.widget.ViewDragHelper.Callback
        public void onViewCaptured(View view, int i) {
            SlidingPaneLayout.this.setAllChildrenVisible();
        }

        @Override // android.support.v4.widget.ViewDragHelper.Callback
        public void onViewPositionChanged(View view, int i, int i2, int i3, int i4) {
            SlidingPaneLayout.this.onPanelDragged(i);
            SlidingPaneLayout.this.invalidate();
        }

        @Override // android.support.v4.widget.ViewDragHelper.Callback
        public void onViewReleased(View view, float f, float f2) {
            int paddingLeft;
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            if (SlidingPaneLayout.this.isLayoutRtlSupport()) {
                int paddingRight = layoutParams.rightMargin + SlidingPaneLayout.this.getPaddingRight();
                if (f < 0.0f || (f == 0.0f && SlidingPaneLayout.this.mSlideOffset > 0.5f)) {
                    paddingRight += SlidingPaneLayout.this.mSlideRange;
                }
                paddingLeft = (SlidingPaneLayout.this.getWidth() - paddingRight) - SlidingPaneLayout.this.mSlideableView.getWidth();
            } else {
                paddingLeft = layoutParams.leftMargin + SlidingPaneLayout.this.getPaddingLeft();
                if (f > 0.0f || (f == 0.0f && SlidingPaneLayout.this.mSlideOffset > 0.5f)) {
                    paddingLeft += SlidingPaneLayout.this.mSlideRange;
                }
            }
            SlidingPaneLayout.this.mDragHelper.settleCapturedViewAt(paddingLeft, view.getTop());
            SlidingPaneLayout.this.invalidate();
        }

        @Override // android.support.v4.widget.ViewDragHelper.Callback
        public int getViewHorizontalDragRange(View view) {
            return SlidingPaneLayout.this.mSlideRange;
        }

        @Override // android.support.v4.widget.ViewDragHelper.Callback
        public int clampViewPositionHorizontal(View view, int i, int i2) {
            LayoutParams layoutParams = (LayoutParams) SlidingPaneLayout.this.mSlideableView.getLayoutParams();
            if (SlidingPaneLayout.this.isLayoutRtlSupport()) {
                int width = SlidingPaneLayout.this.getWidth() - ((layoutParams.rightMargin + SlidingPaneLayout.this.getPaddingRight()) + SlidingPaneLayout.this.mSlideableView.getWidth());
                return Math.max(Math.min(i, width), width - SlidingPaneLayout.this.mSlideRange);
            }
            int paddingLeft = layoutParams.leftMargin + SlidingPaneLayout.this.getPaddingLeft();
            return Math.min(Math.max(i, paddingLeft), SlidingPaneLayout.this.mSlideRange + paddingLeft);
        }

        @Override // android.support.v4.widget.ViewDragHelper.Callback
        public int clampViewPositionVertical(View view, int i, int i2) {
            return view.getTop();
        }

        @Override // android.support.v4.widget.ViewDragHelper.Callback
        public void onEdgeDragStarted(int i, int i2) {
            SlidingPaneLayout.this.mDragHelper.captureChildView(SlidingPaneLayout.this.mSlideableView, i2);
        }
    }

    /* loaded from: classes8.dex */
    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        private static final int[] ATTRS = {16843137};
        Paint dimPaint;
        boolean dimWhenOffset;
        boolean slideable;
        public float weight;

        public LayoutParams() {
            super(-1, -1);
            this.weight = 0.0f;
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
            this.weight = 0.0f;
        }

        public LayoutParams(@NonNull ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.weight = 0.0f;
        }

        public LayoutParams(@NonNull ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.weight = 0.0f;
        }

        public LayoutParams(@NonNull LayoutParams layoutParams) {
            super((ViewGroup.MarginLayoutParams) layoutParams);
            this.weight = 0.0f;
            this.weight = layoutParams.weight;
        }

        public LayoutParams(@NonNull Context context, @Nullable AttributeSet attributeSet) {
            super(context, attributeSet);
            this.weight = 0.0f;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ATTRS);
            this.weight = obtainStyledAttributes.getFloat(0, 0.0f);
            obtainStyledAttributes.recycle();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes8.dex */
    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() { // from class: android.support.v4.widget.SlidingPaneLayout.SavedState.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.ClassLoaderCreator
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, null);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        boolean isOpen;

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.isOpen = parcel.readInt() != 0;
        }

        @Override // android.support.v4.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.isOpen ? 1 : 0);
        }
    }

    /* loaded from: classes8.dex */
    static class SlidingPanelLayoutImplBase implements SlidingPanelLayoutImpl {
        SlidingPanelLayoutImplBase() {
        }

        @Override // android.support.v4.widget.SlidingPaneLayout.SlidingPanelLayoutImpl
        public void invalidateChildRegion(SlidingPaneLayout slidingPaneLayout, View view) {
            ViewCompat.postInvalidateOnAnimation(slidingPaneLayout, view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        }
    }

    @RequiresApi(16)
    /* loaded from: classes8.dex */
    static class SlidingPanelLayoutImplJB extends SlidingPanelLayoutImplBase {
        private Method mGetDisplayList;
        private Field mRecreateDisplayList;

        SlidingPanelLayoutImplJB() {
            try {
                this.mGetDisplayList = View.class.getDeclaredMethod("getDisplayList", null);
            } catch (NoSuchMethodException e) {
                Log.e(SlidingPaneLayout.TAG, "Couldn't fetch getDisplayList method; dimming won't work right.", e);
            }
            try {
                this.mRecreateDisplayList = View.class.getDeclaredField("mRecreateDisplayList");
                this.mRecreateDisplayList.setAccessible(true);
            } catch (NoSuchFieldException e2) {
                Log.e(SlidingPaneLayout.TAG, "Couldn't fetch mRecreateDisplayList field; dimming will be slow.", e2);
            }
        }

        @Override // android.support.v4.widget.SlidingPaneLayout.SlidingPanelLayoutImplBase, android.support.v4.widget.SlidingPaneLayout.SlidingPanelLayoutImpl
        public void invalidateChildRegion(SlidingPaneLayout slidingPaneLayout, View view) {
            if (this.mGetDisplayList != null && this.mRecreateDisplayList != null) {
                try {
                    this.mRecreateDisplayList.setBoolean(view, true);
                    this.mGetDisplayList.invoke(view, null);
                } catch (Exception e) {
                    Log.e(SlidingPaneLayout.TAG, "Error refreshing display list state", e);
                }
                super.invalidateChildRegion(slidingPaneLayout, view);
                return;
            }
            view.invalidate();
        }
    }

    @RequiresApi(17)
    /* loaded from: classes8.dex */
    static class SlidingPanelLayoutImplJBMR1 extends SlidingPanelLayoutImplBase {
        SlidingPanelLayoutImplJBMR1() {
        }

        @Override // android.support.v4.widget.SlidingPaneLayout.SlidingPanelLayoutImplBase, android.support.v4.widget.SlidingPaneLayout.SlidingPanelLayoutImpl
        public void invalidateChildRegion(SlidingPaneLayout slidingPaneLayout, View view) {
            ViewCompat.setLayerPaint(view, ((LayoutParams) view.getLayoutParams()).dimPaint);
        }
    }

    /* loaded from: classes8.dex */
    class AccessibilityDelegate extends AccessibilityDelegateCompat {
        private final Rect mTmpRect = new Rect();

        AccessibilityDelegate() {
        }

        @Override // android.support.v4.view.AccessibilityDelegateCompat
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

        @Override // android.support.v4.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            accessibilityEvent.setClassName(SlidingPaneLayout.class.getName());
        }

        @Override // android.support.v4.view.AccessibilityDelegateCompat
        public boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            if (filter(view)) {
                return false;
            }
            return super.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
        }

        public boolean filter(View view) {
            return SlidingPaneLayout.this.isDimmed(view);
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
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class DisableLayerRunnable implements Runnable {
        final View mChildView;

        DisableLayerRunnable(View view) {
            this.mChildView = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.mChildView.getParent() == SlidingPaneLayout.this) {
                this.mChildView.setLayerType(0, null);
                SlidingPaneLayout.this.invalidateChildRegion(this.mChildView);
            }
            SlidingPaneLayout.this.mPostedRunnables.remove(this);
        }
    }

    boolean isLayoutRtlSupport() {
        return ViewCompat.getLayoutDirection(this) == 1;
    }
}
