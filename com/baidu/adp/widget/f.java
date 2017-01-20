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
    private boolean CA;
    private boolean CB;
    private boolean CC;
    private boolean CD;
    private int CE;
    private int CF;
    private Rect CG;
    private int CH;
    private float CI;
    private boolean CJ;
    private b CK;
    private ViewGroup Cy;
    private int Cz;
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
    private float yO;

    /* loaded from: classes.dex */
    public interface b {
        void kT();

        void kU();
    }

    /* loaded from: classes.dex */
    public interface c {
        void kV();

        void kW();
    }

    public f(Context context) {
        super(context);
        this.mActivePointerId = -1;
        this.CA = false;
        this.CB = false;
        this.CC = true;
        this.mIsScrolling = false;
        this.CD = false;
        this.CF = 0;
        this.CG = new Rect();
        this.CJ = true;
        init(context);
    }

    private void init(Context context) {
        this.CE = (int) TypedValue.applyDimension(1, 24.0f, getResources().getDisplayMetrics());
        this.mScroller = new Scroller(context, new a(1.5f));
        this.mTouchSlop = ViewConfiguration.get(context.getApplicationContext()).getScaledTouchSlop() * 2;
        this.mMaximumVelocity = ViewConfiguration.getMaximumFlingVelocity();
        this.mMinimumVelocity = ViewConfiguration.getMinimumFlingVelocity();
        this.CH = (int) (context.getResources().getDisplayMetrics().density * 24.0f);
        this.mFlingDistance = k.I(context) / 4;
    }

    public void o(Activity activity) {
        try {
            this.mActivity = activity;
            Window window = activity.getWindow();
            window.setBackgroundDrawable(new ColorDrawable(0));
            ViewGroup viewGroup = (ViewGroup) window.getDecorView();
            this.Cy = (ViewGroup) viewGroup.getChildAt(0);
            viewGroup.removeView(this.Cy);
            this.Cy.setClickable(true);
            addView(this.Cy);
            this.mContentView = (View) this.Cy.getParent();
            viewGroup.addView(this);
        } catch (Exception e) {
            this.CC = false;
            BdLog.e(e);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.CC) {
            if (this.CJ && i == 1) {
                this.Cy.setBackgroundResource(R.color.swipe_layout_night_bg);
            } else {
                this.Cy.setBackgroundResource(R.color.swipe_layout_normal_bg);
            }
        }
    }

    public void aN(int i) {
        if (this.CJ && i == 1) {
            this.Cy.setBackgroundResource(R.color.swipe_layout_night_bg);
        } else {
            this.Cy.setBackgroundResource(R.color.swipe_layout_normal_bg);
        }
    }

    public void setIsSupportNight(boolean z) {
        if (!z) {
            this.Cy.setBackgroundResource(R.color.swipe_layout_normal_bg);
        }
        this.CJ = z;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.mContentView != null) {
            int i = this.Cz;
            int bottom = this.mContentView.getBottom();
            this.CG.top = 0;
            this.CG.bottom = bottom;
            this.CG.left = 0;
            this.CG.right = i;
            canvas.clipRect(this.CG);
            if (this.mViewWidth != 0) {
                this.CF = 100 - ((int) (((-this.Cz) / this.mViewWidth) * 120.0f));
            }
            if (this.CF > 100) {
                this.CF = 100;
            }
            if (this.CB) {
                this.CF = 0;
            }
            if (this.CF < 0) {
                this.CF = 0;
            }
            canvas.drawARGB(this.CF, 0, 0, 0);
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (!this.CC) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (this.CB || this.mIsScrolling) {
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
                    this.yO = MotionEventCompat.getX(motionEvent, actionIndex);
                    break;
                }
                break;
            case 2:
                c(motionEvent);
                break;
        }
        return this.CA;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.CB || this.mIsScrolling) {
            return super.onTouchEvent(motionEvent);
        }
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        this.mVelocityTracker.addMovement(motionEvent);
        switch (motionEvent.getAction() & MotionEventCompat.ACTION_MASK) {
            case 0:
                kQ();
                int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
                this.mActivePointerId = MotionEventCompat.getPointerId(motionEvent, actionIndex);
                this.mLastMotionX = motionEvent.getX();
                this.yO = MotionEventCompat.getX(motionEvent, actionIndex);
                break;
            case 1:
                VelocityTracker velocityTracker = this.mVelocityTracker;
                velocityTracker.computeCurrentVelocity(1000, this.mMaximumVelocity);
                this.CI = velocityTracker.getXVelocity();
                int d = d(motionEvent);
                endDrag();
                if (Math.abs(this.CI) > this.mMinimumVelocity && d > this.mFlingDistance) {
                    if (this.CI > 0.0f) {
                        this.CB = true;
                        kO();
                        return true;
                    }
                    kP();
                    this.CB = false;
                    return true;
                } else if (this.mContentView.getScrollX() <= (-this.mViewWidth) / 2) {
                    this.CB = true;
                    kO();
                    break;
                } else {
                    kP();
                    this.CB = false;
                    break;
                }
                break;
            case 2:
                if (!this.CA) {
                    c(motionEvent);
                }
                if (this.CA) {
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
                        this.Cz = (int) f;
                        this.mContentView.scrollTo((int) f, getScrollY());
                        break;
                    }
                }
                break;
            case 3:
                kR();
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
            if (f > 0.0f && abs > this.CH && abs > abs2) {
                this.CA = true;
                if (this.CK != null) {
                    this.CK.kT();
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
        return (int) Math.abs(MotionEventCompat.getX(motionEvent, c2) - this.yO);
    }

    private void endDrag() {
        this.CA = false;
        if (this.CK != null) {
            this.CK.kU();
        }
        this.mActivePointerId = -1;
        kR();
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

    private void kO() {
        this.mIsScrolling = true;
        this.mScroller.startScroll(this.mContentView.getScrollX(), 0, (-(this.mViewWidth + this.mContentView.getScrollX())) + 1, 0);
        postInvalidate();
    }

    private void kP() {
        this.mIsScrolling = true;
        this.mScroller.startScroll(this.mContentView.getScrollX(), 0, -this.mContentView.getScrollX(), 0);
        postInvalidate();
    }

    private void kQ() {
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
        if (this.mScroller.isFinished() && this.CB) {
            this.mActivity.finish();
            this.mActivity.overridePendingTransition(0, 0);
        }
        if (this.mScroller.isFinished()) {
            kQ();
        }
    }

    private void kR() {
        if (this.mVelocityTracker != null) {
            this.mVelocityTracker.clear();
            this.mVelocityTracker.recycle();
            this.mVelocityTracker = null;
        }
    }

    public boolean isSwipeBackEnabled() {
        return this.CC;
    }

    public void setSwipeBackEnabled(boolean z) {
        this.CC = z;
    }

    public void kS() {
        if (this.Cy != null) {
            this.Cy.setBackgroundResource(R.color.transparent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a implements Interpolator {
        private final float CL;

        public a(float f) {
            this.CL = f;
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            float f2 = this.CL * f;
            if (f2 > 0.9d) {
                return 1.0f;
            }
            return f2;
        }
    }

    public void setOnSlidingStateChangeListener(b bVar) {
        this.CK = bVar;
    }
}
