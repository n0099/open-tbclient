package com.baidu.searchbox.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import android.widget.Scroller;
import androidx.core.view.NestedScrollingChild;
import androidx.core.view.NestedScrollingChildHelper;
import androidx.core.view.NestedScrollingParent;
import androidx.core.view.NestedScrollingParentHelper;
import androidx.core.view.ViewCompat;
/* loaded from: classes4.dex */
public class DrawerContainer extends FrameLayout implements NestedScrollingParent, NestedScrollingChild {
    public static final int DRAW_BACK_DURATION = 800;
    public static final int DRAW_BACK_MIN_DURATION = 500;
    public static final float NANOTIME_DIV = 1.0E9f;
    public static final float SMOOTHING_CONSTANT = (float) (0.016d / Math.log(0.75d));
    public static final float SMOOTHING_SPEED = 0.75f;
    public static final int TOUCH_STATE_DELEGATE_SCROLLING = 3;
    public static final int TOUCH_STATE_FLING = 2;
    public static final int TOUCH_STATE_REST = 0;
    public static final int TOUCH_STATE_SCROLLING = 1;
    public NestedScrollingChildHelper mChildHelper;
    public float mDeltaDumpY;
    public Drawer mDrawer;
    public DrawerListener mDrawerListener;
    public HeaderStartSpringBackListener mHeaderStartSpringBackListener;
    public float mLastMotionY;
    public NestedScrollingParentHelper mParentHelper;
    public boolean mRefreshBingo;
    public Scroller mScroller;
    public int mSecondSpringBackGap;
    public int mSecondSpringBackTop;
    public float mSmoothingTime;
    public int mTopDrawerLength;
    public int mTouchSlop;
    public int mTouchState;
    public float mTouchY;

    /* loaded from: classes4.dex */
    public interface DrawerListener {
        void onDrawed(int i);

        void onFlingFinish();

        void onSpringBack(int i, int i2);
    }

    /* loaded from: classes4.dex */
    public interface HeaderStartSpringBackListener {
        void startSpringBack(int i);
    }

    public float dampDelta(float f) {
        return f;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return false;
    }

    public void onScrollViewScrolled(int i, int i2) {
    }

    public float getCurrentDampY() {
        return this.mDeltaDumpY;
    }

    @Override // android.view.ViewGroup, androidx.core.view.NestedScrollingParent
    public int getNestedScrollAxes() {
        return this.mParentHelper.getNestedScrollAxes();
    }

    public int getSecondSpringBackGap() {
        return this.mSecondSpringBackGap;
    }

    public int getTopDrawerLength() {
        return this.mTopDrawerLength;
    }

    public int getTouchSlop() {
        return this.mTouchSlop;
    }

    public int getTouchState() {
        return this.mTouchState;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean hasNestedScrollingParent() {
        return this.mChildHelper.hasNestedScrollingParent();
    }

    public void invokeScrollChanged() {
        onScrollChanged(getScrollX(), getScrollY(), getScrollX(), getScrollY());
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean isNestedScrollingEnabled() {
        return this.mChildHelper.isNestedScrollingEnabled();
    }

    public boolean isRefreshBingo() {
        return this.mRefreshBingo;
    }

    public int scrollDrawer() {
        float nanoTime = ((float) System.nanoTime()) / 1.0E9f;
        int scrollY = (int) ((this.mTouchY - getScrollY()) * ((float) Math.exp((nanoTime - this.mSmoothingTime) / SMOOTHING_CONSTANT)));
        scrollTo(getScrollX(), getScrollY() + scrollY);
        this.mSmoothingTime = nanoTime;
        return scrollY;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void stopNestedScroll() {
        this.mChildHelper.stopNestedScroll();
    }

    public DrawerContainer(Context context) {
        super(context);
        this.mTouchState = 0;
        this.mSecondSpringBackTop = 0;
        this.mSecondSpringBackGap = Integer.MAX_VALUE;
        this.mDeltaDumpY = 0.0f;
        this.mRefreshBingo = false;
        init(context);
    }

    private void init(Context context) {
        this.mScroller = new Scroller(getContext());
        this.mTouchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.mParentHelper = new NestedScrollingParentHelper(this);
        this.mChildHelper = new NestedScrollingChildHelper(this);
        setNestedScrollingEnabled(true);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onStopNestedScroll(View view2) {
        stopNestedScroll();
        onRelease();
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        if (getParent() != null) {
            getParent().requestDisallowInterceptTouchEvent(z);
        }
    }

    public void setDrawer(Drawer drawer) {
        this.mDrawer = drawer;
    }

    public void setDrawerListener(DrawerListener drawerListener) {
        this.mDrawerListener = drawerListener;
    }

    public void setHeaderStartSpringBackListener(HeaderStartSpringBackListener headerStartSpringBackListener) {
        this.mHeaderStartSpringBackListener = headerStartSpringBackListener;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void setNestedScrollingEnabled(boolean z) {
        this.mChildHelper.setNestedScrollingEnabled(z);
    }

    public boolean setTopDrawerLength(int i) {
        if (i != this.mTopDrawerLength) {
            this.mTopDrawerLength = i;
            return true;
        }
        return false;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean startNestedScroll(int i) {
        return this.mChildHelper.startNestedScroll(i);
    }

    public void superRequestDisallowInterceptTouchEvent(boolean z) {
        super.requestDisallowInterceptTouchEvent(z);
    }

    public DrawerContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mTouchState = 0;
        this.mSecondSpringBackTop = 0;
        this.mSecondSpringBackGap = Integer.MAX_VALUE;
        this.mDeltaDumpY = 0.0f;
        this.mRefreshBingo = false;
        init(context);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreFling(float f, float f2) {
        return this.mChildHelper.dispatchNestedPreFling(f, f2);
    }

    @Override // android.view.View
    public void scrollTo(int i, int i2) {
        super.scrollTo(i, i2);
    }

    public void setSecondSpringBackBound(int i, int i2) {
        if (i > i2) {
            return;
        }
        this.mSecondSpringBackTop = i;
        this.mSecondSpringBackGap = i2;
    }

    public DrawerContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mTouchState = 0;
        this.mSecondSpringBackTop = 0;
        this.mSecondSpringBackGap = Integer.MAX_VALUE;
        this.mDeltaDumpY = 0.0f;
        this.mRefreshBingo = false;
        init(context);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedFling(float f, float f2, boolean z) {
        return this.mChildHelper.dispatchNestedFling(f, f2, z);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedPreFling(View view2, float f, float f2) {
        if (this.mTouchState != 0) {
            return true;
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedScrollAccepted(View view2, View view3, int i) {
        this.mParentHelper.onNestedScrollAccepted(view2, view3, i);
        startNestedScroll(2);
    }

    private void onRelease() {
        int i;
        if (!this.mScroller.isFinished()) {
            this.mScroller.abortAnimation();
        }
        int scrollY = this.mTopDrawerLength - getScrollY();
        int i2 = (int) ((scrollY * 800) / this.mTopDrawerLength);
        if (i2 < 0) {
            i2 = -i2;
        }
        if (i2 < 500) {
            i = 500;
        } else {
            i = i2;
        }
        if (scrollY != 0) {
            this.mScroller.startScroll(0, getScrollY(), 0, scrollY, i);
            this.mTouchState = 2;
        } else {
            this.mTouchState = 0;
        }
        HeaderStartSpringBackListener headerStartSpringBackListener = this.mHeaderStartSpringBackListener;
        if (headerStartSpringBackListener != null) {
            headerStartSpringBackListener.startSpringBack(scrollY);
        }
        invalidate();
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.mScroller.computeScrollOffset()) {
            scrollTo(0, this.mScroller.getCurrY());
            postInvalidate();
            return;
        }
        int i = this.mTouchState;
        if (i != 1 && i != 3) {
            this.mTouchState = 0;
            DrawerListener drawerListener = this.mDrawerListener;
            if (drawerListener != null) {
                drawerListener.onFlingFinish();
                return;
            }
            return;
        }
        float nanoTime = ((float) System.nanoTime()) / 1.0E9f;
        float scrollY = this.mTouchY - getScrollY();
        scrollTo(getScrollX(), getScrollY() + ((int) (((float) Math.exp((nanoTime - this.mSmoothingTime) / SMOOTHING_CONSTANT)) * scrollY)));
        this.mSmoothingTime = nanoTime;
        if (scrollY > 1.0f || scrollY < -1.0f) {
            postInvalidate();
        }
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2) {
        return this.mChildHelper.dispatchNestedPreScroll(i, i2, iArr, iArr2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedFling(View view2, float f, float f2, boolean z) {
        if (!dispatchNestedPreFling(0.0f, f2)) {
            dispatchNestedFling(0.0f, f2, z);
            return false;
        }
        return false;
    }

    @Override // android.view.View
    public void onScrollChanged(int i, int i2, int i3, int i4) {
        int i5;
        super.onScrollChanged(i, i2, i3, i4);
        DrawerListener drawerListener = this.mDrawerListener;
        if (drawerListener != null && i2 < (i5 = this.mTopDrawerLength) && this.mTouchState == 1) {
            drawerListener.onDrawed(i5 - i2);
        }
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr) {
        return this.mChildHelper.dispatchNestedScroll(i, i2, i3, i4, iArr);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedScroll(View view2, int i, int i2, int i3, int i4) {
        dispatchNestedScroll(0, i2, 0, i4, null);
    }

    public void drawBy(float f) {
        float dampDelta = dampDelta(f);
        this.mDeltaDumpY = dampDelta;
        if (dampDelta < 0.0f) {
            float f2 = this.mTouchY;
            if (f2 > 0.0f) {
                this.mTouchY = f2 + Math.max(-f2, dampDelta);
                this.mSmoothingTime = ((float) System.nanoTime()) / 1.0E9f;
                invalidate();
            }
        } else if (dampDelta > 0.0f) {
            float f3 = this.mTouchY;
            float f4 = this.mTopDrawerLength - f3;
            if (f4 > 0.0f) {
                this.mTouchY = f3 + Math.min(f4, dampDelta);
                this.mSmoothingTime = ((float) System.nanoTime()) / 1.0E9f;
                invalidate();
            }
        }
    }

    public int drawByImmediate(float f) {
        float dampDelta = dampDelta(f);
        this.mDeltaDumpY = dampDelta;
        if (dampDelta < 0.0f) {
            float f2 = this.mTouchY;
            if (f2 > 0.0f) {
                this.mTouchY = f2 + Math.max(-f2, dampDelta);
                this.mSmoothingTime = ((float) System.nanoTime()) / 1.0E9f;
                return scrollDrawer();
            }
            return 0;
        } else if (dampDelta > 0.0f) {
            float f3 = this.mTouchY;
            float f4 = this.mTopDrawerLength - f3;
            if (f4 > 0.0f) {
                this.mTouchY = f3 + Math.min(f4, dampDelta);
                this.mSmoothingTime = ((float) System.nanoTime()) / 1.0E9f;
                return scrollDrawer();
            }
            return 0;
        } else {
            return 0;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0099  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void handleTouchEvent(MotionEvent motionEvent) {
        int i;
        int i2;
        int i3;
        HeaderStartSpringBackListener headerStartSpringBackListener;
        DrawerListener drawerListener;
        if (this.mDrawer == null) {
            return;
        }
        int action = motionEvent.getAction() & 255;
        if (action != 0) {
            if (action != 1) {
                if (action != 2) {
                    if (action != 3) {
                        return;
                    }
                } else {
                    float f = this.mLastMotionY;
                    this.mRefreshBingo = false;
                    float y = motionEvent.getY();
                    this.mLastMotionY = y;
                    float f2 = y - f;
                    if (getScrollY() < this.mTopDrawerLength || (f2 > 0.0f && this.mDrawer.isTop())) {
                        drawBy(-f2);
                        this.mTouchState = 1;
                        return;
                    }
                    return;
                }
            }
            if (!this.mScroller.isFinished()) {
                this.mScroller.abortAnimation();
            }
            int scrollY = this.mTopDrawerLength - getScrollY();
            if (action != 3) {
                int i4 = this.mSecondSpringBackGap;
                if (i4 == Integer.MAX_VALUE) {
                    this.mRefreshBingo = true;
                } else if (scrollY > i4) {
                    this.mRefreshBingo = true;
                    i = scrollY - this.mSecondSpringBackTop;
                    i2 = (int) ((i * 800) / this.mTopDrawerLength);
                    if (i2 < 0) {
                        i2 = -i2;
                    }
                    i3 = i2;
                    if (this.mRefreshBingo && (drawerListener = this.mDrawerListener) != null) {
                        drawerListener.onSpringBack(i, i3);
                    }
                    if (i == 0) {
                        this.mScroller.startScroll(0, getScrollY(), 0, i, i3);
                        this.mTouchState = 2;
                    } else {
                        this.mTouchState = 0;
                    }
                    headerStartSpringBackListener = this.mHeaderStartSpringBackListener;
                    if (headerStartSpringBackListener != null) {
                        headerStartSpringBackListener.startSpringBack(scrollY);
                    }
                    invalidate();
                    return;
                }
            }
            i = scrollY;
            i2 = (int) ((i * 800) / this.mTopDrawerLength);
            if (i2 < 0) {
            }
            i3 = i2;
            if (this.mRefreshBingo) {
                drawerListener.onSpringBack(i, i3);
            }
            if (i == 0) {
            }
            headerStartSpringBackListener = this.mHeaderStartSpringBackListener;
            if (headerStartSpringBackListener != null) {
            }
            invalidate();
            return;
        }
        this.mTouchState = !this.mScroller.isFinished();
        this.mTouchY = getScrollY();
        this.mRefreshBingo = false;
        this.mLastMotionY = motionEvent.getY();
        if (!this.mScroller.isFinished()) {
            this.mScroller.abortAnimation();
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedPreScroll(View view2, int i, int i2, int[] iArr) {
        int i3;
        if (i2 != 0) {
            if (getScrollY() < this.mTopDrawerLength || (i2 < 0 && !ViewCompat.canScrollVertically(view2, -1))) {
                if (Math.abs(i2) < 3) {
                    i3 = i2 / Math.abs(i2);
                } else {
                    i3 = i2 / 3;
                }
                int drawByImmediate = drawByImmediate(i3);
                if (Math.abs(i3) != 1) {
                    i3 = drawByImmediate;
                }
                iArr[1] = i3;
                this.mTouchState = 3;
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onStartNestedScroll(View view2, View view3, int i) {
        this.mTouchY = getScrollY();
        if (!this.mScroller.isFinished()) {
            this.mScroller.abortAnimation();
            if (Math.abs(getScrollY() - this.mTopDrawerLength) < this.mTouchSlop) {
                scrollTo(0, this.mTopDrawerLength);
            }
        }
        if (!isNestedScrollingEnabled() || (i & 2) == 0) {
            return false;
        }
        return true;
    }

    public int smoothScrollTo(int i, boolean z) {
        DrawerListener drawerListener;
        int scrollY = i - getScrollY();
        this.mRefreshBingo = z;
        if (scrollY != 0) {
            int i2 = (int) ((scrollY * 800) / this.mTopDrawerLength);
            if (i2 < 0) {
                i2 = -i2;
            }
            if (this.mRefreshBingo && (drawerListener = this.mDrawerListener) != null) {
                drawerListener.onSpringBack(scrollY, i2);
            }
            this.mScroller.startScroll(0, getScrollY(), 0, scrollY, i2);
            this.mTouchState = 2;
            invalidate();
            return i2;
        } else if (!this.mScroller.isFinished()) {
            this.mScroller.forceFinished(true);
            return 0;
        } else {
            return 0;
        }
    }
}
