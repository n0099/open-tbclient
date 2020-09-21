package com.baidu.adp.widget;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.view.MotionEventCompat;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import android.widget.Scroller;
import com.baidu.adp.R;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.l;
/* loaded from: classes.dex */
public class SwipeBackLayout extends FrameLayout {
    private boolean Xg;
    private boolean Xh;
    private boolean Xi;
    private boolean Xj;
    private b Xk;
    private int mActivePointerId;
    private Activity mActivity;
    private int mAlphaBgColor;
    private Rect mColorRect;
    private View mContentView;
    private int mCurMotionX;
    private float mDownX;
    private int mFlingDistance;
    private boolean mIsFinish;
    private boolean mIsScrolling;
    private boolean mIsSilding;
    private boolean mIsSupportNight;
    private boolean mIsSwipeBackEnabled;
    private boolean mIsTouchModeMargin;
    private float mLastMotionX;
    private float mLastMotionY;
    private int mMarginThreshold;
    private int mMaximumVelocity;
    private int mMinimumVelocity;
    private int mMoveDistance;
    private ViewGroup mRealContentView;
    private Scroller mScroller;
    private int mTouchSlop;
    private VelocityTracker mVelocityTracker;
    private int mViewWidth;
    private float mXVelocity;

    /* loaded from: classes.dex */
    public interface b {
        void onSlidingEnd(boolean z);

        void onSlidingStart();
    }

    /* loaded from: classes.dex */
    public interface c {
        void disableSwipeBack();

        void enableSwipeBack();
    }

    public SwipeBackLayout(Context context) {
        super(context);
        this.mActivePointerId = -1;
        this.mIsSilding = false;
        this.mIsFinish = false;
        this.mIsSwipeBackEnabled = true;
        this.mIsScrolling = false;
        this.mIsTouchModeMargin = false;
        this.mAlphaBgColor = 0;
        this.mColorRect = new Rect();
        this.Xg = false;
        this.Xh = false;
        this.Xi = false;
        this.Xj = false;
        this.mIsSupportNight = true;
        init(context);
    }

    public SwipeBackLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mActivePointerId = -1;
        this.mIsSilding = false;
        this.mIsFinish = false;
        this.mIsSwipeBackEnabled = true;
        this.mIsScrolling = false;
        this.mIsTouchModeMargin = false;
        this.mAlphaBgColor = 0;
        this.mColorRect = new Rect();
        this.Xg = false;
        this.Xh = false;
        this.Xi = false;
        this.Xj = false;
        this.mIsSupportNight = true;
        init(context);
    }

    public SwipeBackLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mActivePointerId = -1;
        this.mIsSilding = false;
        this.mIsFinish = false;
        this.mIsSwipeBackEnabled = true;
        this.mIsScrolling = false;
        this.mIsTouchModeMargin = false;
        this.mAlphaBgColor = 0;
        this.mColorRect = new Rect();
        this.Xg = false;
        this.Xh = false;
        this.Xi = false;
        this.Xj = false;
        this.mIsSupportNight = true;
        init(context);
    }

    private void init(Context context) {
        this.mMarginThreshold = (int) TypedValue.applyDimension(1, 24.0f, getResources().getDisplayMetrics());
        this.mScroller = new Scroller(context, new a(1.5f));
        this.mTouchSlop = ViewConfiguration.get(context.getApplicationContext()).getScaledTouchSlop() * 2;
        this.mMaximumVelocity = ViewConfiguration.getMaximumFlingVelocity();
        this.mMinimumVelocity = ViewConfiguration.getMinimumFlingVelocity();
        this.mMoveDistance = (int) (context.getResources().getDisplayMetrics().density * 24.0f);
        this.mFlingDistance = l.getEquipmentWidth(context) / 4;
    }

    public void attachToActivity(Activity activity) {
        try {
            this.mActivity = activity;
            Window window = activity.getWindow();
            window.setBackgroundDrawable(new ColorDrawable(0));
            ViewGroup viewGroup = (ViewGroup) window.getDecorView();
            this.mRealContentView = (ViewGroup) viewGroup.getChildAt(0);
            viewGroup.removeView(this.mRealContentView);
            this.mRealContentView.setClickable(true);
            addView(this.mRealContentView);
            this.mContentView = (View) this.mRealContentView.getParent();
            viewGroup.addView(this);
        } catch (Exception e) {
            this.mIsSwipeBackEnabled = false;
            BdLog.e(e);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mIsSwipeBackEnabled) {
            if (this.Xh) {
                this.mRealContentView.setBackgroundResource(R.color.transparent);
            } else if (this.mIsSupportNight) {
                if (i == 1) {
                    this.mRealContentView.setBackgroundResource(R.color.swipe_layout_night_bg);
                } else if (i == 4) {
                    this.mRealContentView.setBackgroundResource(R.color.swipe_layout_dark_bg);
                } else {
                    this.mRealContentView.setBackgroundResource(R.color.swipe_layout_normal_bg);
                }
            } else {
                this.mRealContentView.setBackgroundResource(R.color.swipe_layout_normal_bg);
            }
        }
    }

    public void forceChangeSkinType(int i) {
        if (this.Xh) {
            this.mRealContentView.setBackgroundResource(R.color.transparent);
        } else if (this.mIsSupportNight) {
            if (i == 1) {
                this.mRealContentView.setBackgroundResource(R.color.swipe_layout_night_bg);
            } else if (i == 4) {
                this.mRealContentView.setBackgroundResource(R.color.swipe_layout_dark_bg);
            } else {
                this.mRealContentView.setBackgroundResource(R.color.swipe_layout_normal_bg);
            }
        } else {
            this.mRealContentView.setBackgroundResource(R.color.swipe_layout_normal_bg);
        }
    }

    public void setIsSupportNight(boolean z) {
        if (!z) {
            if (this.Xh) {
                this.mRealContentView.setBackgroundResource(R.color.transparent);
            } else {
                this.mRealContentView.setBackgroundResource(R.color.swipe_layout_normal_bg);
            }
        }
        this.mIsSupportNight = z;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.mContentView != null) {
            int i = this.mCurMotionX;
            int bottom = this.mContentView.getBottom();
            this.mColorRect.top = 0;
            this.mColorRect.bottom = bottom;
            this.mColorRect.left = 0;
            this.mColorRect.right = i;
            canvas.clipRect(this.mColorRect);
            if (this.mViewWidth != 0) {
                this.mAlphaBgColor = 100 - ((int) (((-this.mCurMotionX) / this.mViewWidth) * 120.0f));
            }
            if (this.mAlphaBgColor > 100) {
                this.mAlphaBgColor = 100;
            }
            if (this.mIsFinish) {
                this.mAlphaBgColor = 0;
            }
            if (this.mAlphaBgColor < 0) {
                this.mAlphaBgColor = 0;
            }
            canvas.drawARGB(this.mAlphaBgColor, 0, 0, 0);
        }
    }

    private boolean y(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (action == 1 || action == 3) {
            if (this.Xg) {
                this.Xg = false;
                this.mIsSwipeBackEnabled = true;
                return true;
            } else if (this.Xi) {
                this.Xi = false;
                this.mIsSwipeBackEnabled = false;
                return true;
            }
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        y(motionEvent);
        return dispatchTouchEvent;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (!this.mIsSwipeBackEnabled) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (this.mIsFinish || this.mIsScrolling) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction() & 255;
        if (action == 3 || action == 1) {
            endDrag();
            return super.onInterceptTouchEvent(motionEvent);
        }
        switch (action) {
            case 0:
                int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
                this.mActivePointerId = MotionEventCompat.getPointerId(motionEvent, actionIndex);
                if (!isInvalidEvent(motionEvent, actionIndex, this.mActivePointerId)) {
                    this.mLastMotionX = MotionEventCompat.getX(motionEvent, actionIndex);
                    this.mLastMotionY = MotionEventCompat.getY(motionEvent, actionIndex);
                    this.mDownX = MotionEventCompat.getX(motionEvent, actionIndex);
                    break;
                }
                break;
            case 2:
                determineDrag(motionEvent);
                break;
        }
        return this.mIsSilding;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.mIsFinish || this.mIsScrolling) {
            return super.onTouchEvent(motionEvent);
        }
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        this.mVelocityTracker.addMovement(motionEvent);
        switch (motionEvent.getAction() & 255) {
            case 0:
                completeScroll();
                int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
                this.mActivePointerId = MotionEventCompat.getPointerId(motionEvent, actionIndex);
                this.mLastMotionX = motionEvent.getX();
                this.mDownX = MotionEventCompat.getX(motionEvent, actionIndex);
                break;
            case 1:
                VelocityTracker velocityTracker = this.mVelocityTracker;
                velocityTracker.computeCurrentVelocity(1000, this.mMaximumVelocity);
                this.mXVelocity = velocityTracker.getXVelocity();
                int diffX = getDiffX(motionEvent);
                endDrag();
                if (Math.abs(this.mXVelocity) > this.mMinimumVelocity && diffX > this.mFlingDistance) {
                    if (this.mXVelocity > 0.0f) {
                        this.mIsFinish = true;
                        scrollRight();
                    } else {
                        scrollOrigin();
                        this.mIsFinish = false;
                    }
                    if (this.Xk != null) {
                        this.Xk.onSlidingEnd(this.mIsFinish);
                        return true;
                    }
                    return true;
                }
                if (this.mContentView.getScrollX() <= (-this.mViewWidth) / 2) {
                    this.mIsFinish = true;
                    scrollRight();
                } else {
                    scrollOrigin();
                    this.mIsFinish = false;
                }
                if (this.Xk != null) {
                    this.Xk.onSlidingEnd(this.mIsFinish);
                    break;
                }
                break;
            case 2:
                if (this.Xj) {
                    completeScroll();
                    int actionIndex2 = motionEvent.getActionIndex();
                    this.mActivePointerId = motionEvent.getPointerId(actionIndex2);
                    this.mLastMotionX = (motionEvent.getX(actionIndex2) - 1.0f) - this.mMoveDistance;
                    this.mLastMotionY = motionEvent.getY(actionIndex2);
                    this.mDownX = motionEvent.getX(actionIndex2);
                    this.mIsSilding = false;
                    this.Xj = false;
                }
                if (!this.mIsSilding) {
                    determineDrag(motionEvent);
                }
                if (this.mIsSilding) {
                    int pointerIndex = getPointerIndex(motionEvent, this.mActivePointerId);
                    if (!isInvalidEvent(motionEvent, pointerIndex, this.mActivePointerId)) {
                        float x = MotionEventCompat.getX(motionEvent, pointerIndex);
                        this.mLastMotionX = x;
                        float scrollX = (this.mLastMotionX - x) + getScrollX();
                        float f = -this.mViewWidth;
                        if (scrollX >= f) {
                            f = scrollX > 0.0f ? 0.0f : scrollX;
                        }
                        this.mLastMotionX += f - ((int) f);
                        this.mCurMotionX = (int) f;
                        this.mContentView.scrollTo((int) f, getScrollY());
                        break;
                    }
                }
                break;
            case 3:
                releaseVelocityTracker();
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    private void determineDrag(MotionEvent motionEvent) {
        int i = this.mActivePointerId;
        int pointerIndex = getPointerIndex(motionEvent, i);
        if (!isInvalidEvent(motionEvent, pointerIndex, i)) {
            float x = MotionEventCompat.getX(motionEvent, pointerIndex);
            float f = x - this.mLastMotionX;
            float abs = Math.abs(f);
            float y = MotionEventCompat.getY(motionEvent, pointerIndex);
            float abs2 = Math.abs(y - this.mLastMotionY);
            if (f > 0.0f && abs > this.mMoveDistance && abs > abs2) {
                this.mIsSilding = true;
                if (this.Xk != null) {
                    this.Xk.onSlidingStart();
                }
                this.mLastMotionX = x;
                this.mLastMotionY = y;
            }
        }
    }

    private int getDiffX(MotionEvent motionEvent) {
        int i = this.mActivePointerId;
        int pointerIndex = getPointerIndex(motionEvent, i);
        if (isInvalidEvent(motionEvent, pointerIndex, i)) {
            return 0;
        }
        return (int) Math.abs(MotionEventCompat.getX(motionEvent, pointerIndex) - this.mDownX);
    }

    private void endDrag() {
        this.mIsSilding = false;
        this.mActivePointerId = -1;
        releaseVelocityTracker();
    }

    private boolean isInvalidEvent(MotionEvent motionEvent, int i, int i2) {
        return motionEvent == null || i2 == -1 || i == -1 || i >= motionEvent.getPointerCount();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        try {
            super.onLayout(z, i, i2, i3, i4);
        } catch (Throwable th) {
        }
        if (z) {
            this.mViewWidth = getWidth();
        }
    }

    private int getPointerIndex(MotionEvent motionEvent, int i) {
        int findPointerIndex = MotionEventCompat.findPointerIndex(motionEvent, i);
        if (findPointerIndex == -1) {
            this.mActivePointerId = -1;
        }
        return findPointerIndex;
    }

    private void scrollRight() {
        this.mIsScrolling = true;
        this.mScroller.startScroll(this.mContentView.getScrollX(), 0, (-(this.mViewWidth + this.mContentView.getScrollX())) + 1, 0);
        postInvalidate();
    }

    private void scrollOrigin() {
        this.mIsScrolling = true;
        this.mScroller.startScroll(this.mContentView.getScrollX(), 0, -this.mContentView.getScrollX(), 0);
        postInvalidate();
    }

    private void completeScroll() {
        if (this.mIsScrolling) {
            this.mScroller.abortAnimation();
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            int currX = this.mScroller.getCurrX();
            int currY = this.mScroller.getCurrY();
            if (scrollX != currX || scrollY != currY) {
                this.mContentView.scrollTo(currX, currY);
            }
        }
        this.mIsScrolling = false;
    }

    @Override // android.view.View
    public void computeScroll() {
        if (!this.mScroller.isFinished() && this.mScroller.computeScrollOffset()) {
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            int currX = this.mScroller.getCurrX();
            int currY = this.mScroller.getCurrY();
            if (scrollX != currX || scrollY != currY) {
                this.mContentView.scrollTo(currX, currY);
            }
            invalidate();
        }
        if (this.mScroller.isFinished() && this.mIsFinish) {
            this.mActivity.finish();
            this.mActivity.overridePendingTransition(0, 0);
        }
        if (this.mScroller.isFinished()) {
            completeScroll();
        }
    }

    private void releaseVelocityTracker() {
        if (this.mVelocityTracker != null) {
            this.mVelocityTracker.clear();
            this.mVelocityTracker.recycle();
            this.mVelocityTracker = null;
        }
    }

    public void disableSwipeJustOnce() {
        this.Xg = true;
        this.mIsSwipeBackEnabled = false;
    }

    public boolean isSwipeBackEnabled() {
        return this.mIsSwipeBackEnabled;
    }

    public void setSwipeBackEnabled(boolean z) {
        this.mIsSwipeBackEnabled = z;
    }

    public void swipeBackControl(double d) {
        if (d == 1.0d) {
            if (!this.mIsSwipeBackEnabled) {
                this.Xi = true;
            }
            this.Xj = true;
            this.mIsSwipeBackEnabled = true;
            this.mIsSilding = true;
        } else if (d == 2.0d) {
            this.mIsFinish = true;
            scrollRight();
        }
    }

    public void setBgTransparent() {
        this.Xh = true;
        if (this.mRealContentView != null) {
            this.mRealContentView.setBackgroundResource(R.color.transparent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a implements Interpolator {
        private final float mFactor;

        public a(float f) {
            this.mFactor = f;
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            float f2 = this.mFactor * f;
            if (f2 > 0.9d) {
                return 1.0f;
            }
            return f2;
        }
    }

    public void setOnSlidingStateChangeListener(b bVar) {
        this.Xk = bVar;
    }
}
