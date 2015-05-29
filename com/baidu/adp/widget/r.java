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
    private float EQ;
    private ViewGroup Ja;
    private int Jb;
    private boolean Jc;
    private boolean Jd;
    private boolean Je;
    private boolean Jf;
    private boolean Jg;
    private int Jh;
    private Rect Ji;
    private int Jj;
    private float Jk;
    private boolean Jl;
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
        this.Jc = false;
        this.Jd = false;
        this.Je = true;
        this.Jf = false;
        this.Jg = false;
        this.Jh = 0;
        this.Ji = new Rect();
        this.Jl = true;
        init(context);
    }

    private void init(Context context) {
        this.mMarginThreshold = (int) TypedValue.applyDimension(1, 24.0f, getResources().getDisplayMetrics());
        this.mScroller = new Scroller(context, new s(1.5f));
        this.mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop() * 2;
        this.mMaximumVelocity = ViewConfiguration.getMaximumFlingVelocity();
        this.mMinimumVelocity = ViewConfiguration.getMinimumFlingVelocity();
        this.Jj = (int) (context.getResources().getDisplayMetrics().density * 24.0f);
        this.mFlingDistance = com.baidu.adp.lib.util.n.M(context) / 4;
    }

    public void n(Activity activity) {
        try {
            this.mActivity = activity;
            Window window = activity.getWindow();
            window.setBackgroundDrawable(new ColorDrawable(0));
            ViewGroup viewGroup = (ViewGroup) window.getDecorView();
            this.Ja = (ViewGroup) viewGroup.getChildAt(0);
            viewGroup.removeView(this.Ja);
            this.Ja.setClickable(true);
            addView(this.Ja);
            this.mContentView = (View) this.Ja.getParent();
            viewGroup.addView(this);
        } catch (Exception e) {
            this.Je = false;
            BdLog.e(e);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.Je) {
            if (i == 0) {
                this.Ja.setBackgroundResource(R.color.swipe_layout_normal_bg);
            } else if (this.Jl) {
                this.Ja.setBackgroundResource(R.color.swipe_layout_night_bg);
            }
        }
    }

    public void aB(int i) {
        if (i == 0) {
            this.Ja.setBackgroundResource(R.color.swipe_layout_normal_bg);
        } else if (this.Jl) {
            this.Ja.setBackgroundResource(R.color.swipe_layout_night_bg);
        }
    }

    public void setIsSupportNight(boolean z) {
        if (!z) {
            this.Ja.setBackgroundResource(R.color.swipe_layout_normal_bg);
        }
        this.Jl = z;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.mContentView != null) {
            int i = this.Jb;
            int bottom = this.mContentView.getBottom();
            this.Ji.top = 0;
            this.Ji.bottom = bottom;
            this.Ji.left = 0;
            this.Ji.right = i;
            canvas.clipRect(this.Ji);
            if (this.mViewWidth != 0) {
                this.Jh = 100 - ((int) (((-this.Jb) / this.mViewWidth) * 120.0f));
            }
            if (this.Jh > 100) {
                this.Jh = 100;
            }
            if (this.Jd) {
                this.Jh = 0;
            }
            if (this.Jh < 0) {
                this.Jh = 0;
            }
            canvas.drawARGB(this.Jh, 0, 0, 0);
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (!this.Je) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (this.Jd || this.Jf) {
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
                if (!a(motionEvent, actionIndex, this.mActivePointerId)) {
                    this.mLastMotionX = MotionEventCompat.getX(motionEvent, actionIndex);
                    this.mLastMotionY = MotionEventCompat.getY(motionEvent, actionIndex);
                    this.EQ = MotionEventCompat.getX(motionEvent, actionIndex);
                    break;
                }
                break;
            case 2:
                determineDrag(motionEvent);
                break;
        }
        return this.Jc;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.Jd || this.Jf) {
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
                this.EQ = MotionEventCompat.getX(motionEvent, actionIndex);
                break;
            case 1:
                VelocityTracker velocityTracker = this.mVelocityTracker;
                velocityTracker.computeCurrentVelocity(1000, this.mMaximumVelocity);
                this.Jk = velocityTracker.getXVelocity();
                int g = g(motionEvent);
                endDrag();
                if (Math.abs(this.Jk) > this.mMinimumVelocity && g > this.mFlingDistance) {
                    if (this.Jk > 0.0f) {
                        this.Jd = true;
                        nQ();
                        return true;
                    }
                    nR();
                    this.Jd = false;
                    return true;
                } else if (this.mContentView.getScrollX() <= (-this.mViewWidth) / 2) {
                    this.Jd = true;
                    nQ();
                    break;
                } else {
                    nR();
                    this.Jd = false;
                    break;
                }
                break;
            case 2:
                if (!this.Jc) {
                    determineDrag(motionEvent);
                }
                if (this.Jc) {
                    int pointerIndex = getPointerIndex(motionEvent, this.mActivePointerId);
                    if (!a(motionEvent, pointerIndex, this.mActivePointerId)) {
                        float x = MotionEventCompat.getX(motionEvent, pointerIndex);
                        this.mLastMotionX = x;
                        float scrollX = (this.mLastMotionX - x) + getScrollX();
                        float f = -this.mViewWidth;
                        if (scrollX >= f) {
                            f = scrollX > 0.0f ? 0.0f : scrollX;
                        }
                        this.mLastMotionX += f - ((int) f);
                        this.Jb = (int) f;
                        this.mContentView.scrollTo((int) f, getScrollY());
                        break;
                    }
                }
                break;
            case 3:
                nS();
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    private void determineDrag(MotionEvent motionEvent) {
        int i = this.mActivePointerId;
        int pointerIndex = getPointerIndex(motionEvent, i);
        if (!a(motionEvent, pointerIndex, i)) {
            float x = MotionEventCompat.getX(motionEvent, pointerIndex);
            float f = x - this.mLastMotionX;
            float abs = Math.abs(f);
            float y = MotionEventCompat.getY(motionEvent, pointerIndex);
            float abs2 = Math.abs(y - this.mLastMotionY);
            if (f > 0.0f && abs > this.Jj && abs > abs2) {
                this.Jc = true;
                this.mLastMotionX = x;
                this.mLastMotionY = y;
            }
        }
    }

    private int g(MotionEvent motionEvent) {
        int i = this.mActivePointerId;
        int pointerIndex = getPointerIndex(motionEvent, i);
        if (a(motionEvent, pointerIndex, i)) {
            return 0;
        }
        return (int) Math.abs(MotionEventCompat.getX(motionEvent, pointerIndex) - this.EQ);
    }

    private void endDrag() {
        this.Jc = false;
        this.mActivePointerId = -1;
        nS();
    }

    private boolean a(MotionEvent motionEvent, int i, int i2) {
        return motionEvent == null || i2 == -1 || i == -1 || i >= motionEvent.getPointerCount();
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

    private void nQ() {
        this.Jf = true;
        this.mScroller.startScroll(this.mContentView.getScrollX(), 0, (-(this.mViewWidth + this.mContentView.getScrollX())) + 1, 0);
        postInvalidate();
    }

    private void nR() {
        this.Jf = true;
        this.mScroller.startScroll(this.mContentView.getScrollX(), 0, -this.mContentView.getScrollX(), 0);
        postInvalidate();
    }

    private void completeScroll() {
        if (this.Jf) {
            this.mScroller.abortAnimation();
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            int currX = this.mScroller.getCurrX();
            int currY = this.mScroller.getCurrY();
            if (scrollX != currX || scrollY != currY) {
                this.mContentView.scrollTo(currX, currY);
            }
        }
        this.Jf = false;
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
        if (this.mScroller.isFinished() && this.Jd) {
            this.mActivity.finish();
            this.mActivity.overridePendingTransition(0, 0);
        }
        if (this.mScroller.isFinished()) {
            completeScroll();
        }
    }

    private void nS() {
        if (this.mVelocityTracker != null) {
            this.mVelocityTracker.clear();
            this.mVelocityTracker.recycle();
            this.mVelocityTracker = null;
        }
    }

    public boolean isSwipeBackEnabled() {
        return this.Je;
    }

    public void setSwipeBackEnabled(boolean z) {
        this.Je = z;
    }

    public void nT() {
        if (this.Ja != null) {
            this.Ja.setBackgroundResource(R.color.transparent);
        }
    }
}
