package com.baidu.adp.widget;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.view.MotionEventCompat;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.Scroller;
import com.baidu.adp.R;
import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public class r extends FrameLayout {
    private float EZ;
    private ViewGroup Jh;
    private int Ji;
    private boolean Jj;
    private boolean Jk;
    private boolean Jl;
    private boolean Jm;
    private boolean Jn;
    private int Jo;
    private Rect Jp;
    private int Jq;
    private float Jr;
    private boolean Js;
    private int mActivePointerId;
    private Activity mActivity;
    private View mContentView;
    private int mFlingDistance;
    private float mLastMotionX;
    private float mLastMotionY;
    private int mMarginThreshold;
    private int mMaximumVelocity;
    private int mMinimumVelocity;
    private Scroller mScroller;
    private int mTouchSlop;
    private VelocityTracker mVelocityTracker;
    private int mViewWidth;

    public r(Context context) {
        super(context);
        this.mActivePointerId = -1;
        this.Jj = false;
        this.Jk = false;
        this.Jl = true;
        this.Jm = false;
        this.Jn = false;
        this.Jo = 0;
        this.Jp = new Rect();
        this.Js = true;
        init(context);
    }

    private void init(Context context) {
        this.mMarginThreshold = (int) TypedValue.applyDimension(1, 24.0f, getResources().getDisplayMetrics());
        this.mScroller = new Scroller(context, new s(1.5f));
        this.mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop() * 2;
        this.mMaximumVelocity = ViewConfiguration.getMaximumFlingVelocity();
        this.mMinimumVelocity = ViewConfiguration.getMinimumFlingVelocity();
        this.Jq = (int) (context.getResources().getDisplayMetrics().density * 24.0f);
        this.mFlingDistance = com.baidu.adp.lib.util.n.M(context) / 4;
    }

    public void n(Activity activity) {
        try {
            this.mActivity = activity;
            Window window = activity.getWindow();
            window.setBackgroundDrawable(new ColorDrawable(0));
            ViewGroup viewGroup = (ViewGroup) window.getDecorView();
            this.Jh = (ViewGroup) viewGroup.getChildAt(0);
            viewGroup.removeView(this.Jh);
            this.Jh.setClickable(true);
            addView(this.Jh);
            this.mContentView = (View) this.Jh.getParent();
            viewGroup.addView(this);
        } catch (Exception e) {
            this.Jl = false;
            BdLog.e(e);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.Jl) {
            if (i == 0) {
                this.Jh.setBackgroundResource(R.color.swipe_layout_normal_bg);
            } else if (this.Js) {
                this.Jh.setBackgroundResource(R.color.swipe_layout_night_bg);
            }
        }
    }

    public void aD(int i) {
        if (i == 0) {
            this.Jh.setBackgroundResource(R.color.swipe_layout_normal_bg);
        } else if (this.Js) {
            this.Jh.setBackgroundResource(R.color.swipe_layout_night_bg);
        }
    }

    public void setIsSupportNight(boolean z) {
        if (!z) {
            this.Jh.setBackgroundResource(R.color.swipe_layout_normal_bg);
        }
        this.Js = z;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        try {
            super.dispatchDraw(canvas);
        } catch (Throwable th) {
        }
        if (this.mContentView != null) {
            int i = this.Ji;
            int bottom = this.mContentView.getBottom();
            this.Jp.top = 0;
            this.Jp.bottom = bottom;
            this.Jp.left = 0;
            this.Jp.right = i;
            canvas.clipRect(this.Jp);
            if (this.mViewWidth != 0) {
                this.Jo = 100 - ((int) (((-this.Ji) / this.mViewWidth) * 120.0f));
            }
            if (this.Jo > 100) {
                this.Jo = 100;
            }
            if (this.Jk) {
                this.Jo = 0;
            }
            if (this.Jo < 0) {
                this.Jo = 0;
            }
            canvas.drawARGB(this.Jo, 0, 0, 0);
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (!this.Jl) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (this.Jk || this.Jm) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction() & MotionEventCompat.ACTION_MASK;
        if (action == 3 || action == 1) {
            endDrag();
            return super.onInterceptTouchEvent(motionEvent);
        }
        switch (action) {
            case 0:
                int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
                this.mActivePointerId = MotionEventCompat.getPointerId(motionEvent, actionIndex);
                if (this.mActivePointerId != -1) {
                    this.mLastMotionX = c(motionEvent, actionIndex);
                    this.mLastMotionY = d(motionEvent, actionIndex);
                    this.EZ = c(motionEvent, actionIndex);
                    break;
                }
                break;
            case 2:
                determineDrag(motionEvent);
                break;
        }
        return this.Jj;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.Jk || this.Jm) {
            return super.onTouchEvent(motionEvent);
        }
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        this.mVelocityTracker.addMovement(motionEvent);
        switch (motionEvent.getAction() & MotionEventCompat.ACTION_MASK) {
            case 0:
                completeScroll();
                int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
                this.mActivePointerId = MotionEventCompat.getPointerId(motionEvent, actionIndex);
                this.mLastMotionX = motionEvent.getX();
                this.EZ = c(motionEvent, actionIndex);
                break;
            case 1:
                VelocityTracker velocityTracker = this.mVelocityTracker;
                velocityTracker.computeCurrentVelocity(1000, this.mMaximumVelocity);
                this.Jr = velocityTracker.getXVelocity();
                int g = g(motionEvent);
                endDrag();
                if (Math.abs(this.Jr) > this.mMinimumVelocity && g > this.mFlingDistance) {
                    if (this.Jr > 0.0f) {
                        this.Jk = true;
                        nz();
                        return true;
                    }
                    nA();
                    this.Jk = false;
                    return true;
                } else if (this.mContentView.getScrollX() <= (-this.mViewWidth) / 2) {
                    this.Jk = true;
                    nz();
                    break;
                } else {
                    nA();
                    this.Jk = false;
                    break;
                }
                break;
            case 2:
                if (!this.Jj) {
                    determineDrag(motionEvent);
                }
                if (this.Jj) {
                    int pointerIndex = getPointerIndex(motionEvent, this.mActivePointerId);
                    if (this.mActivePointerId != -1) {
                        float c = c(motionEvent, pointerIndex);
                        this.mLastMotionX = c;
                        float scrollX = (this.mLastMotionX - c) + getScrollX();
                        float f = -this.mViewWidth;
                        if (scrollX >= f) {
                            f = scrollX > 0.0f ? 0.0f : scrollX;
                        }
                        this.mLastMotionX += f - ((int) f);
                        this.Ji = (int) f;
                        this.mContentView.scrollTo((int) f, getScrollY());
                        break;
                    }
                }
                break;
            case 3:
                nB();
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    private void determineDrag(MotionEvent motionEvent) {
        int i = this.mActivePointerId;
        int pointerIndex = getPointerIndex(motionEvent, i);
        if (i != -1) {
            float c = c(motionEvent, pointerIndex);
            float f = c - this.mLastMotionX;
            float abs = Math.abs(f);
            float d = d(motionEvent, pointerIndex);
            float abs2 = Math.abs(d - this.mLastMotionY);
            if (f > 0.0f && abs > this.Jq && abs > abs2) {
                this.Jj = true;
                this.mLastMotionX = c;
                this.mLastMotionY = d;
            }
        }
    }

    private int g(MotionEvent motionEvent) {
        int i = this.mActivePointerId;
        int pointerIndex = getPointerIndex(motionEvent, i);
        if (i == -1) {
            return 0;
        }
        return (int) Math.abs(c(motionEvent, pointerIndex) - this.EZ);
    }

    private void endDrag() {
        this.Jj = false;
        this.mActivePointerId = -1;
        nB();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
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

    private void nz() {
        this.Jm = true;
        this.mScroller.startScroll(this.mContentView.getScrollX(), 0, (-(this.mViewWidth + this.mContentView.getScrollX())) + 1, 0);
        postInvalidate();
    }

    private void nA() {
        this.Jm = true;
        this.mScroller.startScroll(this.mContentView.getScrollX(), 0, -this.mContentView.getScrollX(), 0);
        postInvalidate();
    }

    private void completeScroll() {
        if (this.Jm) {
            this.mScroller.abortAnimation();
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            int currX = this.mScroller.getCurrX();
            int currY = this.mScroller.getCurrY();
            if (scrollX != currX || scrollY != currY) {
                this.mContentView.scrollTo(currX, currY);
            }
        }
        this.Jm = false;
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
        if (this.mScroller.isFinished() && this.Jk) {
            this.mActivity.finish();
            this.mActivity.overridePendingTransition(0, 0);
        }
        if (this.mScroller.isFinished()) {
            completeScroll();
        }
    }

    private void nB() {
        if (this.mVelocityTracker != null) {
            this.mVelocityTracker.clear();
            this.mVelocityTracker.recycle();
            this.mVelocityTracker = null;
        }
    }

    private float c(MotionEvent motionEvent, int i) {
        try {
            return MotionEventCompat.getX(motionEvent, i);
        } catch (IllegalArgumentException e) {
            return 0.0f;
        }
    }

    private float d(MotionEvent motionEvent, int i) {
        try {
            return MotionEventCompat.getY(motionEvent, i);
        } catch (IllegalArgumentException e) {
            return 0.0f;
        }
    }

    public boolean isSwipeBackEnabled() {
        return this.Jl;
    }

    public void setSwipeBackEnabled(boolean z) {
        this.Jl = z;
    }

    public void nC() {
        if (this.Jh != null) {
            this.Jh.setBackgroundResource(R.color.transparent);
        }
    }
}
