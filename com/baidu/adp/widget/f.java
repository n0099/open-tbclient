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
    private float FR;
    private ViewGroup Kh;
    private int Ki;
    private boolean Kj;
    private boolean Kk;
    private boolean Kl;
    private boolean Km;
    private boolean Kn;
    private int Ko;
    private Rect Kp;
    private int Kq;
    private float Kr;
    private boolean Ks;
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
        void nT();

        void nU();
    }

    public f(Context context) {
        super(context);
        this.mActivePointerId = -1;
        this.Kj = false;
        this.Kk = false;
        this.Kl = true;
        this.Km = false;
        this.Kn = false;
        this.Ko = 0;
        this.Kp = new Rect();
        this.Ks = true;
        init(context);
    }

    private void init(Context context) {
        this.mMarginThreshold = (int) TypedValue.applyDimension(1, 24.0f, getResources().getDisplayMetrics());
        this.mScroller = new Scroller(context, new a(1.5f));
        this.mTouchSlop = ViewConfiguration.get(context.getApplicationContext()).getScaledTouchSlop() * 2;
        this.mMaximumVelocity = ViewConfiguration.getMaximumFlingVelocity();
        this.mMinimumVelocity = ViewConfiguration.getMinimumFlingVelocity();
        this.Kq = (int) (context.getResources().getDisplayMetrics().density * 24.0f);
        this.mFlingDistance = k.B(context) / 4;
    }

    public void i(Activity activity) {
        try {
            this.mActivity = activity;
            Window window = activity.getWindow();
            window.setBackgroundDrawable(new ColorDrawable(0));
            ViewGroup viewGroup = (ViewGroup) window.getDecorView();
            this.Kh = (ViewGroup) viewGroup.getChildAt(0);
            viewGroup.removeView(this.Kh);
            this.Kh.setClickable(true);
            addView(this.Kh);
            this.mContentView = (View) this.Kh.getParent();
            viewGroup.addView(this);
        } catch (Exception e) {
            this.Kl = false;
            BdLog.e(e);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.Kl) {
            if (this.Ks && i == 1) {
                this.Kh.setBackgroundResource(R.color.swipe_layout_night_bg);
            } else {
                this.Kh.setBackgroundResource(R.color.swipe_layout_normal_bg);
            }
        }
    }

    public void aJ(int i) {
        if (this.Ks && i == 1) {
            this.Kh.setBackgroundResource(R.color.swipe_layout_night_bg);
        } else {
            this.Kh.setBackgroundResource(R.color.swipe_layout_normal_bg);
        }
    }

    public void setIsSupportNight(boolean z) {
        if (!z) {
            this.Kh.setBackgroundResource(R.color.swipe_layout_normal_bg);
        }
        this.Ks = z;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.mContentView != null) {
            int i = this.Ki;
            int bottom = this.mContentView.getBottom();
            this.Kp.top = 0;
            this.Kp.bottom = bottom;
            this.Kp.left = 0;
            this.Kp.right = i;
            canvas.clipRect(this.Kp);
            if (this.mViewWidth != 0) {
                this.Ko = 100 - ((int) (((-this.Ki) / this.mViewWidth) * 120.0f));
            }
            if (this.Ko > 100) {
                this.Ko = 100;
            }
            if (this.Kk) {
                this.Ko = 0;
            }
            if (this.Ko < 0) {
                this.Ko = 0;
            }
            canvas.drawARGB(this.Ko, 0, 0, 0);
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (!this.Kl) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (this.Kk || this.Km) {
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
                    this.FR = MotionEventCompat.getX(motionEvent, actionIndex);
                    break;
                }
                break;
            case 2:
                determineDrag(motionEvent);
                break;
        }
        return this.Kj;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.Kk || this.Km) {
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
                this.FR = MotionEventCompat.getX(motionEvent, actionIndex);
                break;
            case 1:
                VelocityTracker velocityTracker = this.mVelocityTracker;
                velocityTracker.computeCurrentVelocity(1000, this.mMaximumVelocity);
                this.Kr = velocityTracker.getXVelocity();
                int b2 = b(motionEvent);
                endDrag();
                if (Math.abs(this.Kr) > this.mMinimumVelocity && b2 > this.mFlingDistance) {
                    if (this.Kr > 0.0f) {
                        this.Kk = true;
                        nP();
                        return true;
                    }
                    nQ();
                    this.Kk = false;
                    return true;
                } else if (this.mContentView.getScrollX() <= (-this.mViewWidth) / 2) {
                    this.Kk = true;
                    nP();
                    break;
                } else {
                    nQ();
                    this.Kk = false;
                    break;
                }
                break;
            case 2:
                if (!this.Kj) {
                    determineDrag(motionEvent);
                }
                if (this.Kj) {
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
                        this.Ki = (int) f;
                        this.mContentView.scrollTo((int) f, getScrollY());
                        break;
                    }
                }
                break;
            case 3:
                nR();
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
            if (f > 0.0f && abs > this.Kq && abs > abs2) {
                this.Kj = true;
                this.mLastMotionX = x;
                this.mLastMotionY = y;
            }
        }
    }

    private int b(MotionEvent motionEvent) {
        int i = this.mActivePointerId;
        int pointerIndex = getPointerIndex(motionEvent, i);
        if (a(motionEvent, pointerIndex, i)) {
            return 0;
        }
        return (int) Math.abs(MotionEventCompat.getX(motionEvent, pointerIndex) - this.FR);
    }

    private void endDrag() {
        this.Kj = false;
        this.mActivePointerId = -1;
        nR();
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

    private void nP() {
        this.Km = true;
        this.mScroller.startScroll(this.mContentView.getScrollX(), 0, (-(this.mViewWidth + this.mContentView.getScrollX())) + 1, 0);
        postInvalidate();
    }

    private void nQ() {
        this.Km = true;
        this.mScroller.startScroll(this.mContentView.getScrollX(), 0, -this.mContentView.getScrollX(), 0);
        postInvalidate();
    }

    private void completeScroll() {
        if (this.Km) {
            this.mScroller.abortAnimation();
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            int currX = this.mScroller.getCurrX();
            int currY = this.mScroller.getCurrY();
            if (scrollX != currX || scrollY != currY) {
                this.mContentView.scrollTo(currX, currY);
            }
        }
        this.Km = false;
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
        if (this.mScroller.isFinished() && this.Kk) {
            this.mActivity.finish();
            this.mActivity.overridePendingTransition(0, 0);
        }
        if (this.mScroller.isFinished()) {
            completeScroll();
        }
    }

    private void nR() {
        if (this.mVelocityTracker != null) {
            this.mVelocityTracker.clear();
            this.mVelocityTracker.recycle();
            this.mVelocityTracker = null;
        }
    }

    public boolean isSwipeBackEnabled() {
        return this.Kl;
    }

    public void setSwipeBackEnabled(boolean z) {
        this.Kl = z;
    }

    public void nS() {
        if (this.Kh != null) {
            this.Kh.setBackgroundResource(R.color.transparent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a implements Interpolator {
        private final float Kt;

        public a(float f) {
            this.Kt = f;
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            float f2 = this.Kt * f;
            if (f2 > 0.9d) {
                return 1.0f;
            }
            return f2;
        }
    }
}
