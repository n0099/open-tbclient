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
    private float Gc;
    private ViewGroup JN;
    private int JO;
    private boolean JP;
    private boolean JQ;
    private boolean JR;
    private boolean JS;
    private int JT;
    private int JU;
    private Rect JV;
    private int JW;
    private float JX;
    private boolean JY;
    private b JZ;
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
        void lN();

        void lO();
    }

    /* loaded from: classes.dex */
    public interface c {
        void lP();

        void lQ();
    }

    public f(Context context) {
        super(context);
        this.mActivePointerId = -1;
        this.JP = false;
        this.JQ = false;
        this.JR = true;
        this.mIsScrolling = false;
        this.JS = false;
        this.JU = 0;
        this.JV = new Rect();
        this.JY = true;
        init(context);
    }

    private void init(Context context) {
        this.JT = (int) TypedValue.applyDimension(1, 24.0f, getResources().getDisplayMetrics());
        this.mScroller = new Scroller(context, new a(1.5f));
        this.mTouchSlop = ViewConfiguration.get(context.getApplicationContext()).getScaledTouchSlop() * 2;
        this.mMaximumVelocity = ViewConfiguration.getMaximumFlingVelocity();
        this.mMinimumVelocity = ViewConfiguration.getMinimumFlingVelocity();
        this.JW = (int) (context.getResources().getDisplayMetrics().density * 24.0f);
        this.mFlingDistance = k.ag(context) / 4;
    }

    public void o(Activity activity) {
        try {
            this.mActivity = activity;
            Window window = activity.getWindow();
            window.setBackgroundDrawable(new ColorDrawable(0));
            ViewGroup viewGroup = (ViewGroup) window.getDecorView();
            this.JN = (ViewGroup) viewGroup.getChildAt(0);
            viewGroup.removeView(this.JN);
            this.JN.setClickable(true);
            addView(this.JN);
            this.mContentView = (View) this.JN.getParent();
            viewGroup.addView(this);
        } catch (Exception e) {
            this.JR = false;
            BdLog.e(e);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.JR) {
            if (this.JY && i == 1) {
                this.JN.setBackgroundResource(R.color.swipe_layout_night_bg);
            } else {
                this.JN.setBackgroundResource(R.color.swipe_layout_normal_bg);
            }
        }
    }

    public void aN(int i) {
        if (this.JY && i == 1) {
            this.JN.setBackgroundResource(R.color.swipe_layout_night_bg);
        } else {
            this.JN.setBackgroundResource(R.color.swipe_layout_normal_bg);
        }
    }

    public void setIsSupportNight(boolean z) {
        if (!z) {
            this.JN.setBackgroundResource(R.color.swipe_layout_normal_bg);
        }
        this.JY = z;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.mContentView != null) {
            int i = this.JO;
            int bottom = this.mContentView.getBottom();
            this.JV.top = 0;
            this.JV.bottom = bottom;
            this.JV.left = 0;
            this.JV.right = i;
            canvas.clipRect(this.JV);
            if (this.mViewWidth != 0) {
                this.JU = 100 - ((int) (((-this.JO) / this.mViewWidth) * 120.0f));
            }
            if (this.JU > 100) {
                this.JU = 100;
            }
            if (this.JQ) {
                this.JU = 0;
            }
            if (this.JU < 0) {
                this.JU = 0;
            }
            canvas.drawARGB(this.JU, 0, 0, 0);
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (!this.JR) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (this.JQ || this.mIsScrolling) {
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
                    this.Gc = MotionEventCompat.getX(motionEvent, actionIndex);
                    break;
                }
                break;
            case 2:
                c(motionEvent);
                break;
        }
        return this.JP;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.JQ || this.mIsScrolling) {
            return super.onTouchEvent(motionEvent);
        }
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        this.mVelocityTracker.addMovement(motionEvent);
        switch (motionEvent.getAction() & MotionEventCompat.ACTION_MASK) {
            case 0:
                lK();
                int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
                this.mActivePointerId = MotionEventCompat.getPointerId(motionEvent, actionIndex);
                this.mLastMotionX = motionEvent.getX();
                this.Gc = MotionEventCompat.getX(motionEvent, actionIndex);
                break;
            case 1:
                VelocityTracker velocityTracker = this.mVelocityTracker;
                velocityTracker.computeCurrentVelocity(1000, this.mMaximumVelocity);
                this.JX = velocityTracker.getXVelocity();
                int d = d(motionEvent);
                endDrag();
                if (Math.abs(this.JX) > this.mMinimumVelocity && d > this.mFlingDistance) {
                    if (this.JX > 0.0f) {
                        this.JQ = true;
                        lI();
                        return true;
                    }
                    lJ();
                    this.JQ = false;
                    return true;
                } else if (this.mContentView.getScrollX() <= (-this.mViewWidth) / 2) {
                    this.JQ = true;
                    lI();
                    break;
                } else {
                    lJ();
                    this.JQ = false;
                    break;
                }
                break;
            case 2:
                if (!this.JP) {
                    c(motionEvent);
                }
                if (this.JP) {
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
                        this.JO = (int) f;
                        this.mContentView.scrollTo((int) f, getScrollY());
                        break;
                    }
                }
                break;
            case 3:
                lL();
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
            if (f > 0.0f && abs > this.JW && abs > abs2) {
                this.JP = true;
                if (this.JZ != null) {
                    this.JZ.lN();
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
        return (int) Math.abs(MotionEventCompat.getX(motionEvent, c2) - this.Gc);
    }

    private void endDrag() {
        this.JP = false;
        if (this.JZ != null) {
            this.JZ.lO();
        }
        this.mActivePointerId = -1;
        lL();
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

    private void lI() {
        this.mIsScrolling = true;
        this.mScroller.startScroll(this.mContentView.getScrollX(), 0, (-(this.mViewWidth + this.mContentView.getScrollX())) + 1, 0);
        postInvalidate();
    }

    private void lJ() {
        this.mIsScrolling = true;
        this.mScroller.startScroll(this.mContentView.getScrollX(), 0, -this.mContentView.getScrollX(), 0);
        postInvalidate();
    }

    private void lK() {
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
        if (this.mScroller.isFinished() && this.JQ) {
            this.mActivity.finish();
            this.mActivity.overridePendingTransition(0, 0);
        }
        if (this.mScroller.isFinished()) {
            lK();
        }
    }

    private void lL() {
        if (this.mVelocityTracker != null) {
            this.mVelocityTracker.clear();
            this.mVelocityTracker.recycle();
            this.mVelocityTracker = null;
        }
    }

    public boolean isSwipeBackEnabled() {
        return this.JR;
    }

    public void setSwipeBackEnabled(boolean z) {
        this.JR = z;
    }

    public void lM() {
        if (this.JN != null) {
            this.JN.setBackgroundResource(R.color.transparent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a implements Interpolator {
        private final float Ka;

        public a(float f) {
            this.Ka = f;
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            float f2 = this.Ka * f;
            if (f2 > 0.9d) {
                return 1.0f;
            }
            return f2;
        }
    }

    public void setOnSlidingStateChangeListener(b bVar) {
        this.JZ = bVar;
    }
}
