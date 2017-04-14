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
    private float FD;
    private b JA;
    private ViewGroup Jo;
    private int Jp;
    private boolean Jq;
    private boolean Jr;
    private boolean Js;
    private boolean Jt;
    private int Ju;
    private int Jv;
    private Rect Jw;
    private int Jx;
    private float Jy;
    private boolean Jz;
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

    /* loaded from: classes.dex */
    public interface b {
        void lR();

        void lS();
    }

    /* loaded from: classes.dex */
    public interface c {
        void lT();

        void lU();
    }

    public f(Context context) {
        super(context);
        this.mActivePointerId = -1;
        this.Jq = false;
        this.Jr = false;
        this.Js = true;
        this.mIsScrolling = false;
        this.Jt = false;
        this.Jv = 0;
        this.Jw = new Rect();
        this.Jz = true;
        init(context);
    }

    private void init(Context context) {
        this.Ju = (int) TypedValue.applyDimension(1, 24.0f, getResources().getDisplayMetrics());
        this.mScroller = new Scroller(context, new a(1.5f));
        this.mTouchSlop = ViewConfiguration.get(context.getApplicationContext()).getScaledTouchSlop() * 2;
        this.mMaximumVelocity = ViewConfiguration.getMaximumFlingVelocity();
        this.mMinimumVelocity = ViewConfiguration.getMinimumFlingVelocity();
        this.Jx = (int) (context.getResources().getDisplayMetrics().density * 24.0f);
        this.mFlingDistance = k.af(context) / 4;
    }

    public void o(Activity activity) {
        try {
            this.mActivity = activity;
            Window window = activity.getWindow();
            window.setBackgroundDrawable(new ColorDrawable(0));
            ViewGroup viewGroup = (ViewGroup) window.getDecorView();
            this.Jo = (ViewGroup) viewGroup.getChildAt(0);
            viewGroup.removeView(this.Jo);
            this.Jo.setClickable(true);
            addView(this.Jo);
            this.mContentView = (View) this.Jo.getParent();
            viewGroup.addView(this);
        } catch (Exception e) {
            this.Js = false;
            BdLog.e(e);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.Js) {
            if (this.Jz && i == 1) {
                this.Jo.setBackgroundResource(R.color.swipe_layout_night_bg);
            } else {
                this.Jo.setBackgroundResource(R.color.swipe_layout_normal_bg);
            }
        }
    }

    public void aM(int i) {
        if (this.Jz && i == 1) {
            this.Jo.setBackgroundResource(R.color.swipe_layout_night_bg);
        } else {
            this.Jo.setBackgroundResource(R.color.swipe_layout_normal_bg);
        }
    }

    public void setIsSupportNight(boolean z) {
        if (!z) {
            this.Jo.setBackgroundResource(R.color.swipe_layout_normal_bg);
        }
        this.Jz = z;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.mContentView != null) {
            int i = this.Jp;
            int bottom = this.mContentView.getBottom();
            this.Jw.top = 0;
            this.Jw.bottom = bottom;
            this.Jw.left = 0;
            this.Jw.right = i;
            canvas.clipRect(this.Jw);
            if (this.mViewWidth != 0) {
                this.Jv = 100 - ((int) (((-this.Jp) / this.mViewWidth) * 120.0f));
            }
            if (this.Jv > 100) {
                this.Jv = 100;
            }
            if (this.Jr) {
                this.Jv = 0;
            }
            if (this.Jv < 0) {
                this.Jv = 0;
            }
            canvas.drawARGB(this.Jv, 0, 0, 0);
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (!this.Js) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (this.Jr || this.mIsScrolling) {
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
                    this.FD = MotionEventCompat.getX(motionEvent, actionIndex);
                    break;
                }
                break;
            case 2:
                g(motionEvent);
                break;
        }
        return this.Jq;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.Jr || this.mIsScrolling) {
            return super.onTouchEvent(motionEvent);
        }
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        this.mVelocityTracker.addMovement(motionEvent);
        switch (motionEvent.getAction() & MotionEventCompat.ACTION_MASK) {
            case 0:
                lO();
                int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
                this.mActivePointerId = MotionEventCompat.getPointerId(motionEvent, actionIndex);
                this.mLastMotionX = motionEvent.getX();
                this.FD = MotionEventCompat.getX(motionEvent, actionIndex);
                break;
            case 1:
                VelocityTracker velocityTracker = this.mVelocityTracker;
                velocityTracker.computeCurrentVelocity(1000, this.mMaximumVelocity);
                this.Jy = velocityTracker.getXVelocity();
                int h = h(motionEvent);
                endDrag();
                if (Math.abs(this.Jy) > this.mMinimumVelocity && h > this.mFlingDistance) {
                    if (this.Jy > 0.0f) {
                        this.Jr = true;
                        lM();
                        return true;
                    }
                    lN();
                    this.Jr = false;
                    return true;
                } else if (this.mContentView.getScrollX() <= (-this.mViewWidth) / 2) {
                    this.Jr = true;
                    lM();
                    break;
                } else {
                    lN();
                    this.Jr = false;
                    break;
                }
                break;
            case 2:
                if (!this.Jq) {
                    g(motionEvent);
                }
                if (this.Jq) {
                    int d = d(motionEvent, this.mActivePointerId);
                    if (!a(motionEvent, d, this.mActivePointerId)) {
                        float x = MotionEventCompat.getX(motionEvent, d);
                        this.mLastMotionX = x;
                        float scrollX = (this.mLastMotionX - x) + getScrollX();
                        float f = -this.mViewWidth;
                        if (scrollX >= f) {
                            f = scrollX > 0.0f ? 0.0f : scrollX;
                        }
                        this.mLastMotionX += f - ((int) f);
                        this.Jp = (int) f;
                        this.mContentView.scrollTo((int) f, getScrollY());
                        break;
                    }
                }
                break;
            case 3:
                lP();
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    private void g(MotionEvent motionEvent) {
        int i = this.mActivePointerId;
        int d = d(motionEvent, i);
        if (!a(motionEvent, d, i)) {
            float x = MotionEventCompat.getX(motionEvent, d);
            float f = x - this.mLastMotionX;
            float abs = Math.abs(f);
            float y = MotionEventCompat.getY(motionEvent, d);
            float abs2 = Math.abs(y - this.mLastMotionY);
            if (f > 0.0f && abs > this.Jx && abs > abs2) {
                this.Jq = true;
                if (this.JA != null) {
                    this.JA.lR();
                }
                this.mLastMotionX = x;
                this.mLastMotionY = y;
            }
        }
    }

    private int h(MotionEvent motionEvent) {
        int i = this.mActivePointerId;
        int d = d(motionEvent, i);
        if (a(motionEvent, d, i)) {
            return 0;
        }
        return (int) Math.abs(MotionEventCompat.getX(motionEvent, d) - this.FD);
    }

    private void endDrag() {
        this.Jq = false;
        if (this.JA != null) {
            this.JA.lS();
        }
        this.mActivePointerId = -1;
        lP();
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

    private int d(MotionEvent motionEvent, int i) {
        int findPointerIndex = MotionEventCompat.findPointerIndex(motionEvent, i);
        if (findPointerIndex == -1) {
            this.mActivePointerId = -1;
        }
        return findPointerIndex;
    }

    private void lM() {
        this.mIsScrolling = true;
        this.mScroller.startScroll(this.mContentView.getScrollX(), 0, (-(this.mViewWidth + this.mContentView.getScrollX())) + 1, 0);
        postInvalidate();
    }

    private void lN() {
        this.mIsScrolling = true;
        this.mScroller.startScroll(this.mContentView.getScrollX(), 0, -this.mContentView.getScrollX(), 0);
        postInvalidate();
    }

    private void lO() {
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
        if (this.mScroller.isFinished() && this.Jr) {
            this.mActivity.finish();
            this.mActivity.overridePendingTransition(0, 0);
        }
        if (this.mScroller.isFinished()) {
            lO();
        }
    }

    private void lP() {
        if (this.mVelocityTracker != null) {
            this.mVelocityTracker.clear();
            this.mVelocityTracker.recycle();
            this.mVelocityTracker = null;
        }
    }

    public boolean isSwipeBackEnabled() {
        return this.Js;
    }

    public void setSwipeBackEnabled(boolean z) {
        this.Js = z;
    }

    public void lQ() {
        if (this.Jo != null) {
            this.Jo.setBackgroundResource(R.color.transparent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a implements Interpolator {
        private final float JB;

        public a(float f) {
            this.JB = f;
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            float f2 = this.JB * f;
            if (f2 > 0.9d) {
                return 1.0f;
            }
            return f2;
        }
    }

    public void setOnSlidingStateChangeListener(b bVar) {
        this.JA = bVar;
    }
}
