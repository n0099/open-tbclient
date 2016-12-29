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
    private ViewGroup Dn;
    private int Do;
    private boolean Dp;
    private boolean Dq;
    private boolean Dr;
    private boolean Ds;
    private int Dt;
    private int Du;
    private Rect Dv;
    private int Dw;
    private float Dx;
    private boolean Dy;
    private b Dz;
    private int mActivePointerId;
    private Activity mActivity;
    private View mContentView;
    private int mFlingDistance;
    private boolean mIsScrolling;
    private float mLastMotionX;
    private float mLastMotionY;
    private int mMaximumVelocity;
    private int mMinimumVelocity;
    private Scroller mScroller;
    private int mTouchSlop;
    private VelocityTracker mVelocityTracker;
    private int mViewWidth;
    private float yY;

    /* loaded from: classes.dex */
    public interface b {
        void lb();

        void lc();
    }

    /* loaded from: classes.dex */
    public interface c {
        void ld();

        void le();
    }

    public f(Context context) {
        super(context);
        this.mActivePointerId = -1;
        this.Dp = false;
        this.Dq = false;
        this.Dr = true;
        this.mIsScrolling = false;
        this.Ds = false;
        this.Du = 0;
        this.Dv = new Rect();
        this.Dy = true;
        init(context);
    }

    private void init(Context context) {
        this.Dt = (int) TypedValue.applyDimension(1, 24.0f, getResources().getDisplayMetrics());
        this.mScroller = new Scroller(context, new a(1.5f));
        this.mTouchSlop = ViewConfiguration.get(context.getApplicationContext()).getScaledTouchSlop() * 2;
        this.mMaximumVelocity = ViewConfiguration.getMaximumFlingVelocity();
        this.mMinimumVelocity = ViewConfiguration.getMinimumFlingVelocity();
        this.Dw = (int) (context.getResources().getDisplayMetrics().density * 24.0f);
        this.mFlingDistance = k.I(context) / 4;
    }

    public void o(Activity activity) {
        try {
            this.mActivity = activity;
            Window window = activity.getWindow();
            window.setBackgroundDrawable(new ColorDrawable(0));
            ViewGroup viewGroup = (ViewGroup) window.getDecorView();
            this.Dn = (ViewGroup) viewGroup.getChildAt(0);
            viewGroup.removeView(this.Dn);
            this.Dn.setClickable(true);
            addView(this.Dn);
            this.mContentView = (View) this.Dn.getParent();
            viewGroup.addView(this);
        } catch (Exception e) {
            this.Dr = false;
            BdLog.e(e);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.Dr) {
            if (this.Dy && i == 1) {
                this.Dn.setBackgroundResource(R.color.swipe_layout_night_bg);
            } else {
                this.Dn.setBackgroundResource(R.color.swipe_layout_normal_bg);
            }
        }
    }

    public void aO(int i) {
        if (this.Dy && i == 1) {
            this.Dn.setBackgroundResource(R.color.swipe_layout_night_bg);
        } else {
            this.Dn.setBackgroundResource(R.color.swipe_layout_normal_bg);
        }
    }

    public void setIsSupportNight(boolean z) {
        if (!z) {
            this.Dn.setBackgroundResource(R.color.swipe_layout_normal_bg);
        }
        this.Dy = z;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.mContentView != null) {
            int i = this.Do;
            int bottom = this.mContentView.getBottom();
            this.Dv.top = 0;
            this.Dv.bottom = bottom;
            this.Dv.left = 0;
            this.Dv.right = i;
            canvas.clipRect(this.Dv);
            if (this.mViewWidth != 0) {
                this.Du = 100 - ((int) (((-this.Do) / this.mViewWidth) * 120.0f));
            }
            if (this.Du > 100) {
                this.Du = 100;
            }
            if (this.Dq) {
                this.Du = 0;
            }
            if (this.Du < 0) {
                this.Du = 0;
            }
            canvas.drawARGB(this.Du, 0, 0, 0);
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (!this.Dr) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (this.Dq || this.mIsScrolling) {
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
                    this.yY = MotionEventCompat.getX(motionEvent, actionIndex);
                    break;
                }
                break;
            case 2:
                c(motionEvent);
                break;
        }
        return this.Dp;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.Dq || this.mIsScrolling) {
            return super.onTouchEvent(motionEvent);
        }
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        this.mVelocityTracker.addMovement(motionEvent);
        switch (motionEvent.getAction() & MotionEventCompat.ACTION_MASK) {
            case 0:
                kY();
                int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
                this.mActivePointerId = MotionEventCompat.getPointerId(motionEvent, actionIndex);
                this.mLastMotionX = motionEvent.getX();
                this.yY = MotionEventCompat.getX(motionEvent, actionIndex);
                break;
            case 1:
                VelocityTracker velocityTracker = this.mVelocityTracker;
                velocityTracker.computeCurrentVelocity(1000, this.mMaximumVelocity);
                this.Dx = velocityTracker.getXVelocity();
                int d = d(motionEvent);
                endDrag();
                if (Math.abs(this.Dx) > this.mMinimumVelocity && d > this.mFlingDistance) {
                    if (this.Dx > 0.0f) {
                        this.Dq = true;
                        kW();
                        return true;
                    }
                    kX();
                    this.Dq = false;
                    return true;
                } else if (this.mContentView.getScrollX() <= (-this.mViewWidth) / 2) {
                    this.Dq = true;
                    kW();
                    break;
                } else {
                    kX();
                    this.Dq = false;
                    break;
                }
                break;
            case 2:
                if (!this.Dp) {
                    c(motionEvent);
                }
                if (this.Dp) {
                    int c2 = c(motionEvent, this.mActivePointerId);
                    if (!a(motionEvent, c2, this.mActivePointerId)) {
                        float x = MotionEventCompat.getX(motionEvent, c2);
                        this.mLastMotionX = x;
                        float scrollX = (this.mLastMotionX - x) + getScrollX();
                        float f = -this.mViewWidth;
                        if (scrollX >= f) {
                            f = scrollX > 0.0f ? 0.0f : scrollX;
                        }
                        this.mLastMotionX += f - ((int) f);
                        this.Do = (int) f;
                        this.mContentView.scrollTo((int) f, getScrollY());
                        break;
                    }
                }
                break;
            case 3:
                kZ();
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    private void c(MotionEvent motionEvent) {
        int i = this.mActivePointerId;
        int c2 = c(motionEvent, i);
        if (!a(motionEvent, c2, i)) {
            float x = MotionEventCompat.getX(motionEvent, c2);
            float f = x - this.mLastMotionX;
            float abs = Math.abs(f);
            float y = MotionEventCompat.getY(motionEvent, c2);
            float abs2 = Math.abs(y - this.mLastMotionY);
            if (f > 0.0f && abs > this.Dw && abs > abs2) {
                this.Dp = true;
                if (this.Dz != null) {
                    this.Dz.lb();
                }
                this.mLastMotionX = x;
                this.mLastMotionY = y;
            }
        }
    }

    private int d(MotionEvent motionEvent) {
        int i = this.mActivePointerId;
        int c2 = c(motionEvent, i);
        if (a(motionEvent, c2, i)) {
            return 0;
        }
        return (int) Math.abs(MotionEventCompat.getX(motionEvent, c2) - this.yY);
    }

    private void endDrag() {
        this.Dp = false;
        if (this.Dz != null) {
            this.Dz.lc();
        }
        this.mActivePointerId = -1;
        kZ();
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

    private int c(MotionEvent motionEvent, int i) {
        int findPointerIndex = MotionEventCompat.findPointerIndex(motionEvent, i);
        if (findPointerIndex == -1) {
            this.mActivePointerId = -1;
        }
        return findPointerIndex;
    }

    private void kW() {
        this.mIsScrolling = true;
        this.mScroller.startScroll(this.mContentView.getScrollX(), 0, (-(this.mViewWidth + this.mContentView.getScrollX())) + 1, 0);
        postInvalidate();
    }

    private void kX() {
        this.mIsScrolling = true;
        this.mScroller.startScroll(this.mContentView.getScrollX(), 0, -this.mContentView.getScrollX(), 0);
        postInvalidate();
    }

    private void kY() {
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
        if (this.mScroller.isFinished() && this.Dq) {
            this.mActivity.finish();
            this.mActivity.overridePendingTransition(0, 0);
        }
        if (this.mScroller.isFinished()) {
            kY();
        }
    }

    private void kZ() {
        if (this.mVelocityTracker != null) {
            this.mVelocityTracker.clear();
            this.mVelocityTracker.recycle();
            this.mVelocityTracker = null;
        }
    }

    public boolean isSwipeBackEnabled() {
        return this.Dr;
    }

    public void setSwipeBackEnabled(boolean z) {
        this.Dr = z;
    }

    public void la() {
        if (this.Dn != null) {
            this.Dn.setBackgroundResource(R.color.transparent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a implements Interpolator {
        private final float DA;

        public a(float f) {
            this.DA = f;
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            float f2 = this.DA * f;
            if (f2 > 0.9d) {
                return 1.0f;
            }
            return f2;
        }
    }

    public void setOnSlidingStateChangeListener(b bVar) {
        this.Dz = bVar;
    }
}
