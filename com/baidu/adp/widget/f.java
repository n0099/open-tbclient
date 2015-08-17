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
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import android.widget.Scroller;
import com.baidu.adp.R;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.k;
/* loaded from: classes.dex */
public class f extends FrameLayout {
    private float ER;
    private ViewGroup Jd;
    private int Je;
    private boolean Jf;
    private boolean Jg;
    private boolean Jh;
    private boolean Ji;
    private boolean Jj;
    private int Jk;
    private Rect Jl;
    private int Jm;
    private float Jn;
    private boolean Jo;
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

    /* loaded from: classes.dex */
    public interface b {
        void od();

        void oe();
    }

    public f(Context context) {
        super(context);
        this.mActivePointerId = -1;
        this.Jf = false;
        this.Jg = false;
        this.Jh = true;
        this.Ji = false;
        this.Jj = false;
        this.Jk = 0;
        this.Jl = new Rect();
        this.Jo = true;
        init(context);
    }

    private void init(Context context) {
        this.mMarginThreshold = (int) TypedValue.applyDimension(1, 24.0f, getResources().getDisplayMetrics());
        this.mScroller = new Scroller(context, new a(1.5f));
        this.mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop() * 2;
        this.mMaximumVelocity = ViewConfiguration.getMaximumFlingVelocity();
        this.mMinimumVelocity = ViewConfiguration.getMinimumFlingVelocity();
        this.Jm = (int) (context.getResources().getDisplayMetrics().density * 24.0f);
        this.mFlingDistance = k.K(context) / 4;
    }

    public void n(Activity activity) {
        try {
            this.mActivity = activity;
            Window window = activity.getWindow();
            window.setBackgroundDrawable(new ColorDrawable(0));
            ViewGroup viewGroup = (ViewGroup) window.getDecorView();
            this.Jd = (ViewGroup) viewGroup.getChildAt(0);
            viewGroup.removeView(this.Jd);
            this.Jd.setClickable(true);
            addView(this.Jd);
            this.mContentView = (View) this.Jd.getParent();
            viewGroup.addView(this);
        } catch (Exception e) {
            this.Jh = false;
            BdLog.e(e);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.Jh) {
            if (i == 0) {
                this.Jd.setBackgroundResource(R.color.swipe_layout_normal_bg);
            } else if (this.Jo) {
                this.Jd.setBackgroundResource(R.color.swipe_layout_night_bg);
            }
        }
    }

    public void aD(int i) {
        if (i == 0) {
            this.Jd.setBackgroundResource(R.color.swipe_layout_normal_bg);
        } else if (this.Jo) {
            this.Jd.setBackgroundResource(R.color.swipe_layout_night_bg);
        }
    }

    public void setIsSupportNight(boolean z) {
        if (!z) {
            this.Jd.setBackgroundResource(R.color.swipe_layout_normal_bg);
        }
        this.Jo = z;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.mContentView != null) {
            int i = this.Je;
            int bottom = this.mContentView.getBottom();
            this.Jl.top = 0;
            this.Jl.bottom = bottom;
            this.Jl.left = 0;
            this.Jl.right = i;
            canvas.clipRect(this.Jl);
            if (this.mViewWidth != 0) {
                this.Jk = 100 - ((int) (((-this.Je) / this.mViewWidth) * 120.0f));
            }
            if (this.Jk > 100) {
                this.Jk = 100;
            }
            if (this.Jg) {
                this.Jk = 0;
            }
            if (this.Jk < 0) {
                this.Jk = 0;
            }
            canvas.drawARGB(this.Jk, 0, 0, 0);
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (!this.Jh) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (this.Jg || this.Ji) {
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
                    this.ER = MotionEventCompat.getX(motionEvent, actionIndex);
                    break;
                }
                break;
            case 2:
                determineDrag(motionEvent);
                break;
        }
        return this.Jf;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.Jg || this.Ji) {
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
                this.ER = MotionEventCompat.getX(motionEvent, actionIndex);
                break;
            case 1:
                VelocityTracker velocityTracker = this.mVelocityTracker;
                velocityTracker.computeCurrentVelocity(1000, this.mMaximumVelocity);
                this.Jn = velocityTracker.getXVelocity();
                int f = f(motionEvent);
                endDrag();
                if (Math.abs(this.Jn) > this.mMinimumVelocity && f > this.mFlingDistance) {
                    if (this.Jn > 0.0f) {
                        this.Jg = true;
                        nZ();
                        return true;
                    }
                    oa();
                    this.Jg = false;
                    return true;
                } else if (this.mContentView.getScrollX() <= (-this.mViewWidth) / 2) {
                    this.Jg = true;
                    nZ();
                    break;
                } else {
                    oa();
                    this.Jg = false;
                    break;
                }
                break;
            case 2:
                if (!this.Jf) {
                    determineDrag(motionEvent);
                }
                if (this.Jf) {
                    int pointerIndex = getPointerIndex(motionEvent, this.mActivePointerId);
                    if (!a(motionEvent, pointerIndex, this.mActivePointerId)) {
                        float x = MotionEventCompat.getX(motionEvent, pointerIndex);
                        this.mLastMotionX = x;
                        float scrollX = (this.mLastMotionX - x) + getScrollX();
                        float f2 = -this.mViewWidth;
                        if (scrollX >= f2) {
                            f2 = scrollX > 0.0f ? 0.0f : scrollX;
                        }
                        this.mLastMotionX += f2 - ((int) f2);
                        this.Je = (int) f2;
                        this.mContentView.scrollTo((int) f2, getScrollY());
                        break;
                    }
                }
                break;
            case 3:
                ob();
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
            if (f > 0.0f && abs > this.Jm && abs > abs2) {
                this.Jf = true;
                this.mLastMotionX = x;
                this.mLastMotionY = y;
            }
        }
    }

    private int f(MotionEvent motionEvent) {
        int i = this.mActivePointerId;
        int pointerIndex = getPointerIndex(motionEvent, i);
        if (a(motionEvent, pointerIndex, i)) {
            return 0;
        }
        return (int) Math.abs(MotionEventCompat.getX(motionEvent, pointerIndex) - this.ER);
    }

    private void endDrag() {
        this.Jf = false;
        this.mActivePointerId = -1;
        ob();
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

    private void nZ() {
        this.Ji = true;
        this.mScroller.startScroll(this.mContentView.getScrollX(), 0, (-(this.mViewWidth + this.mContentView.getScrollX())) + 1, 0);
        postInvalidate();
    }

    private void oa() {
        this.Ji = true;
        this.mScroller.startScroll(this.mContentView.getScrollX(), 0, -this.mContentView.getScrollX(), 0);
        postInvalidate();
    }

    private void completeScroll() {
        if (this.Ji) {
            this.mScroller.abortAnimation();
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            int currX = this.mScroller.getCurrX();
            int currY = this.mScroller.getCurrY();
            if (scrollX != currX || scrollY != currY) {
                this.mContentView.scrollTo(currX, currY);
            }
        }
        this.Ji = false;
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
        if (this.mScroller.isFinished() && this.Jg) {
            this.mActivity.finish();
            this.mActivity.overridePendingTransition(0, 0);
        }
        if (this.mScroller.isFinished()) {
            completeScroll();
        }
    }

    private void ob() {
        if (this.mVelocityTracker != null) {
            this.mVelocityTracker.clear();
            this.mVelocityTracker.recycle();
            this.mVelocityTracker = null;
        }
    }

    public boolean isSwipeBackEnabled() {
        return this.Jh;
    }

    public void setSwipeBackEnabled(boolean z) {
        this.Jh = z;
    }

    public void oc() {
        if (this.Jd != null) {
            this.Jd.setBackgroundResource(R.color.transparent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a implements Interpolator {
        private final float Jp;

        public a(float f) {
            this.Jp = f;
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            float f2 = this.Jp * f;
            if (f2 > 0.9d) {
                return 1.0f;
            }
            return f2;
        }
    }
}
