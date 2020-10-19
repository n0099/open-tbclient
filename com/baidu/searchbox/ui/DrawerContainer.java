package com.baidu.searchbox.ui;

import android.content.Context;
import android.support.v4.view.NestedScrollingChild;
import android.support.v4.view.NestedScrollingChildHelper;
import android.support.v4.view.NestedScrollingParent;
import android.support.v4.view.NestedScrollingParentHelper;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.ActivityChooserView;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import android.widget.Scroller;
/* loaded from: classes10.dex */
public class DrawerContainer extends FrameLayout implements NestedScrollingChild, NestedScrollingParent {
    public static final int DRAW_BACK_DURATION = 800;
    public static final int DRAW_BACK_MIN_DURATION = 500;
    private static final float NANOTIME_DIV = 1.0E9f;
    private static final float SMOOTHING_CONSTANT = (float) (0.016d / Math.log(0.75d));
    private static final float SMOOTHING_SPEED = 0.75f;
    public static final int TOUCH_STATE_DELEGATE_SCROLLING = 3;
    public static final int TOUCH_STATE_FLING = 2;
    public static final int TOUCH_STATE_REST = 0;
    public static final int TOUCH_STATE_SCROLLING = 1;
    private NestedScrollingChildHelper mChildHelper;
    private float mDeltaDumpY;
    protected Drawer mDrawer;
    private DrawerListener mDrawerListener;
    private HeaderStartSpringBackListener mHeaderStartSpringBackListener;
    private float mLastMotionY;
    private NestedScrollingParentHelper mParentHelper;
    private boolean mRefreshBingo;
    private Scroller mScroller;
    private int mSecondSpringBackGap;
    private int mSecondSpringBackTop;
    private float mSmoothingTime;
    private int mTopDrawerLength;
    private int mTouchSlop;
    private int mTouchState;
    private float mTouchY;

    /* loaded from: classes10.dex */
    public interface DrawerListener {
        void onDrawed(int i);

        void onFlingFinish();

        void onSpringBack(int i, int i2);
    }

    /* loaded from: classes10.dex */
    public interface HeaderStartSpringBackListener {
        void startSpringBack(int i);
    }

    public DrawerContainer(Context context) {
        super(context);
        this.mTouchState = 0;
        this.mSecondSpringBackTop = 0;
        this.mSecondSpringBackGap = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        this.mDeltaDumpY = 0.0f;
        this.mRefreshBingo = false;
        init(context);
    }

    public DrawerContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mTouchState = 0;
        this.mSecondSpringBackTop = 0;
        this.mSecondSpringBackGap = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        this.mDeltaDumpY = 0.0f;
        this.mRefreshBingo = false;
        init(context);
    }

    public DrawerContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mTouchState = 0;
        this.mSecondSpringBackTop = 0;
        this.mSecondSpringBackGap = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
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

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
    }

    @Override // android.view.View
    public void scrollTo(int i, int i2) {
        super.scrollTo(i, i2);
    }

    public boolean setTopDrawerLength(int i) {
        if (i == this.mTopDrawerLength) {
            return false;
        }
        this.mTopDrawerLength = i;
        return true;
    }

    public void setSecondSpringBackBound(int i, int i2) {
        if (i <= i2) {
            this.mSecondSpringBackTop = i;
            this.mSecondSpringBackGap = i2;
        }
    }

    public int getSecondSpringBackGap() {
        return this.mSecondSpringBackGap;
    }

    public int getTopDrawerLength() {
        return this.mTopDrawerLength;
    }

    public void setDrawer(Drawer drawer) {
        this.mDrawer = drawer;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return false;
    }

    public int drawByImmediate(float f) {
        float dampDelta = dampDelta(f);
        this.mDeltaDumpY = dampDelta;
        if (dampDelta < 0.0f) {
            if (this.mTouchY > 0.0f) {
                this.mTouchY = Math.max(-this.mTouchY, dampDelta) + this.mTouchY;
                this.mSmoothingTime = ((float) System.nanoTime()) / NANOTIME_DIV;
                return scrollDrawer();
            }
        } else if (dampDelta > 0.0f) {
            float f2 = this.mTopDrawerLength - this.mTouchY;
            if (f2 > 0.0f) {
                this.mTouchY = Math.min(f2, dampDelta) + this.mTouchY;
                this.mSmoothingTime = ((float) System.nanoTime()) / NANOTIME_DIV;
                return scrollDrawer();
            }
        }
        return 0;
    }

    public int scrollDrawer() {
        float nanoTime = ((float) System.nanoTime()) / NANOTIME_DIV;
        int exp = (int) (((float) Math.exp((nanoTime - this.mSmoothingTime) / SMOOTHING_CONSTANT)) * (this.mTouchY - getScrollY()));
        scrollTo(getScrollX(), getScrollY() + exp);
        this.mSmoothingTime = nanoTime;
        return exp;
    }

    public void drawBy(float f) {
        float dampDelta = dampDelta(f);
        this.mDeltaDumpY = dampDelta;
        if (dampDelta < 0.0f) {
            if (this.mTouchY > 0.0f) {
                this.mTouchY = Math.max(-this.mTouchY, dampDelta) + this.mTouchY;
                this.mSmoothingTime = ((float) System.nanoTime()) / NANOTIME_DIV;
                invalidate();
            }
        } else if (dampDelta > 0.0f) {
            float f2 = this.mTopDrawerLength - this.mTouchY;
            if (f2 > 0.0f) {
                this.mTouchY = Math.min(f2, dampDelta) + this.mTouchY;
                this.mSmoothingTime = ((float) System.nanoTime()) / NANOTIME_DIV;
                invalidate();
            }
        }
    }

    protected float dampDelta(float f) {
        return f;
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00c6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void handleTouchEvent(MotionEvent motionEvent) {
        int i;
        int i2;
        if (this.mDrawer != null) {
            int action = motionEvent.getAction();
            switch (action & 255) {
                case 0:
                    this.mTouchState = this.mScroller.isFinished() ? 0 : 1;
                    this.mTouchY = getScrollY();
                    this.mRefreshBingo = false;
                    this.mLastMotionY = motionEvent.getY();
                    if (!this.mScroller.isFinished()) {
                        this.mScroller.abortAnimation();
                        return;
                    }
                    return;
                case 1:
                case 3:
                    if (!this.mScroller.isFinished()) {
                        this.mScroller.abortAnimation();
                    }
                    int scrollY = this.mTopDrawerLength - getScrollY();
                    if ((action & 255) != 3) {
                        if (this.mSecondSpringBackGap == Integer.MAX_VALUE) {
                            this.mRefreshBingo = true;
                            i = scrollY;
                        } else if (scrollY > this.mSecondSpringBackGap) {
                            this.mRefreshBingo = true;
                            i = scrollY - this.mSecondSpringBackTop;
                        }
                        i2 = (int) ((i * 800) / this.mTopDrawerLength);
                        if (i2 < 0) {
                            i2 = -i2;
                        }
                        if (this.mRefreshBingo && this.mDrawerListener != null) {
                            this.mDrawerListener.onSpringBack(i, i2);
                        }
                        if (i == 0) {
                            this.mScroller.startScroll(0, getScrollY(), 0, i, i2);
                            this.mTouchState = 2;
                        } else {
                            this.mTouchState = 0;
                        }
                        if (this.mHeaderStartSpringBackListener != null) {
                            this.mHeaderStartSpringBackListener.startSpringBack(scrollY);
                        }
                        invalidate();
                        return;
                    }
                    i = scrollY;
                    i2 = (int) ((i * 800) / this.mTopDrawerLength);
                    if (i2 < 0) {
                    }
                    if (this.mRefreshBingo) {
                        this.mDrawerListener.onSpringBack(i, i2);
                    }
                    if (i == 0) {
                    }
                    if (this.mHeaderStartSpringBackListener != null) {
                    }
                    invalidate();
                    return;
                case 2:
                    float f = this.mLastMotionY;
                    this.mRefreshBingo = false;
                    this.mLastMotionY = motionEvent.getY();
                    float f2 = this.mLastMotionY - f;
                    if (getScrollY() < this.mTopDrawerLength || (f2 > 0.0f && this.mDrawer.isTop())) {
                        drawBy(-f2);
                        this.mTouchState = 1;
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public void setHeaderStartSpringBackListener(HeaderStartSpringBackListener headerStartSpringBackListener) {
        this.mHeaderStartSpringBackListener = headerStartSpringBackListener;
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.mScroller.computeScrollOffset()) {
            scrollTo(0, this.mScroller.getCurrY());
            postInvalidate();
        } else if (this.mTouchState == 1 || this.mTouchState == 3) {
            float nanoTime = ((float) System.nanoTime()) / NANOTIME_DIV;
            float exp = (float) Math.exp((nanoTime - this.mSmoothingTime) / SMOOTHING_CONSTANT);
            float scrollY = this.mTouchY - getScrollY();
            scrollTo(getScrollX(), ((int) (exp * scrollY)) + getScrollY());
            this.mSmoothingTime = nanoTime;
            if (scrollY > 1.0f || scrollY < -1.0f) {
                postInvalidate();
            }
        } else {
            this.mTouchState = 0;
            if (this.mDrawerListener != null) {
                this.mDrawerListener.onFlingFinish();
            }
        }
    }

    public int smoothScrollTo(int i, boolean z) {
        int scrollY = i - getScrollY();
        this.mRefreshBingo = z;
        if (scrollY != 0) {
            int i2 = (int) ((scrollY * 800) / this.mTopDrawerLength);
            if (i2 < 0) {
                i2 = -i2;
            }
            if (this.mRefreshBingo && this.mDrawerListener != null) {
                this.mDrawerListener.onSpringBack(scrollY, i2);
            }
            this.mScroller.startScroll(0, getScrollY(), 0, scrollY, i2);
            this.mTouchState = 2;
            invalidate();
            return i2;
        }
        if (!this.mScroller.isFinished()) {
            this.mScroller.forceFinished(true);
        }
        return 0;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        if (getParent() != null) {
            getParent().requestDisallowInterceptTouchEvent(z);
        }
    }

    public void superRequestDisallowInterceptTouchEvent(boolean z) {
        super.requestDisallowInterceptTouchEvent(z);
    }

    public void onScrollViewScrolled(int i, int i2) {
    }

    @Override // android.view.View
    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        if (this.mDrawerListener != null && i2 < this.mTopDrawerLength && this.mTouchState == 1) {
            this.mDrawerListener.onDrawed(this.mTopDrawerLength - i2);
        }
    }

    public void invokeScrollChanged() {
        onScrollChanged(getScrollX(), getScrollY(), getScrollX(), getScrollY());
    }

    public void setDrawerListener(DrawerListener drawerListener) {
        this.mDrawerListener = drawerListener;
    }

    public int getTouchSlop() {
        return this.mTouchSlop;
    }

    public int getTouchState() {
        return this.mTouchState;
    }

    protected float getCurrentDampY() {
        return this.mDeltaDumpY;
    }

    public boolean isRefreshBingo() {
        return this.mRefreshBingo;
    }

    @Override // android.view.View, android.support.v4.view.NestedScrollingChild
    public void setNestedScrollingEnabled(boolean z) {
        this.mChildHelper.setNestedScrollingEnabled(z);
    }

    @Override // android.view.View, android.support.v4.view.NestedScrollingChild
    public boolean isNestedScrollingEnabled() {
        return this.mChildHelper.isNestedScrollingEnabled();
    }

    @Override // android.view.View, android.support.v4.view.NestedScrollingChild
    public boolean startNestedScroll(int i) {
        return this.mChildHelper.startNestedScroll(i);
    }

    @Override // android.view.View, android.support.v4.view.NestedScrollingChild
    public void stopNestedScroll() {
        this.mChildHelper.stopNestedScroll();
    }

    @Override // android.view.View, android.support.v4.view.NestedScrollingChild
    public boolean hasNestedScrollingParent() {
        return this.mChildHelper.hasNestedScrollingParent();
    }

    @Override // android.view.View, android.support.v4.view.NestedScrollingChild
    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr) {
        return this.mChildHelper.dispatchNestedScroll(i, i2, i3, i4, iArr);
    }

    @Override // android.view.View, android.support.v4.view.NestedScrollingChild
    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2) {
        return this.mChildHelper.dispatchNestedPreScroll(i, i2, iArr, iArr2);
    }

    @Override // android.view.View, android.support.v4.view.NestedScrollingChild
    public boolean dispatchNestedFling(float f, float f2, boolean z) {
        return this.mChildHelper.dispatchNestedFling(f, f2, z);
    }

    @Override // android.view.View, android.support.v4.view.NestedScrollingChild
    public boolean dispatchNestedPreFling(float f, float f2) {
        return this.mChildHelper.dispatchNestedPreFling(f, f2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, android.support.v4.view.NestedScrollingParent
    public boolean onStartNestedScroll(View view, View view2, int i) {
        this.mTouchY = getScrollY();
        if (!this.mScroller.isFinished()) {
            this.mScroller.abortAnimation();
            if (Math.abs(getScrollY() - this.mTopDrawerLength) < this.mTouchSlop) {
                scrollTo(0, this.mTopDrawerLength);
            }
        }
        return isNestedScrollingEnabled() && (i & 2) != 0;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, android.support.v4.view.NestedScrollingParent
    public void onNestedScrollAccepted(View view, View view2, int i) {
        this.mParentHelper.onNestedScrollAccepted(view, view2, i);
        startNestedScroll(2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, android.support.v4.view.NestedScrollingParent
    public void onStopNestedScroll(View view) {
        stopNestedScroll();
        onRelease();
    }

    private void onRelease() {
        if (!this.mScroller.isFinished()) {
            this.mScroller.abortAnimation();
        }
        int scrollY = this.mTopDrawerLength - getScrollY();
        int i = (int) ((scrollY * 800) / this.mTopDrawerLength);
        if (i < 0) {
            i = -i;
        }
        int i2 = i >= 500 ? i : 500;
        if (scrollY != 0) {
            this.mScroller.startScroll(0, getScrollY(), 0, scrollY, i2);
            this.mTouchState = 2;
        } else {
            this.mTouchState = 0;
        }
        if (this.mHeaderStartSpringBackListener != null) {
            this.mHeaderStartSpringBackListener.startSpringBack(scrollY);
        }
        invalidate();
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, android.support.v4.view.NestedScrollingParent
    public void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        dispatchNestedScroll(0, i2, 0, i4, null);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, android.support.v4.view.NestedScrollingParent
    public void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
        if (i2 != 0) {
            if (getScrollY() < this.mTopDrawerLength || (i2 < 0 && !ViewCompat.canScrollVertically(view, -1))) {
                int abs = Math.abs(i2) < 3 ? i2 / Math.abs(i2) : i2 / 3;
                int drawByImmediate = drawByImmediate(abs);
                if (Math.abs(abs) != 1) {
                    abs = drawByImmediate;
                }
                iArr[1] = abs;
                this.mTouchState = 3;
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, android.support.v4.view.NestedScrollingParent
    public boolean onNestedFling(View view, float f, float f2, boolean z) {
        if (!dispatchNestedPreFling(0.0f, f2)) {
            dispatchNestedFling(0.0f, f2, z);
            return false;
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, android.support.v4.view.NestedScrollingParent
    public boolean onNestedPreFling(View view, float f, float f2) {
        return this.mTouchState != 0;
    }

    @Override // android.view.ViewGroup, android.support.v4.view.NestedScrollingParent
    public int getNestedScrollAxes() {
        return this.mParentHelper.getNestedScrollAxes();
    }
}
