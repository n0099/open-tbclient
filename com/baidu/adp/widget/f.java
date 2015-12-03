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
    private float Fi;
    private boolean JA;
    private boolean JB;
    private boolean JC;
    private int JD;
    private Rect JE;
    private int JF;
    private float JG;
    private boolean JH;
    private ViewGroup Jw;
    private int Jx;
    private boolean Jy;
    private boolean Jz;
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
        void oi();

        void oj();
    }

    public f(Context context) {
        super(context);
        this.mActivePointerId = -1;
        this.Jy = false;
        this.Jz = false;
        this.JA = true;
        this.JB = false;
        this.JC = false;
        this.JD = 0;
        this.JE = new Rect();
        this.JH = true;
        init(context);
    }

    private void init(Context context) {
        this.mMarginThreshold = (int) TypedValue.applyDimension(1, 24.0f, getResources().getDisplayMetrics());
        this.mScroller = new Scroller(context, new a(1.5f));
        this.mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop() * 2;
        this.mMaximumVelocity = ViewConfiguration.getMaximumFlingVelocity();
        this.mMinimumVelocity = ViewConfiguration.getMinimumFlingVelocity();
        this.JF = (int) (context.getResources().getDisplayMetrics().density * 24.0f);
        this.mFlingDistance = k.K(context) / 4;
    }

    public void n(Activity activity) {
        try {
            this.mActivity = activity;
            Window window = activity.getWindow();
            window.setBackgroundDrawable(new ColorDrawable(0));
            ViewGroup viewGroup = (ViewGroup) window.getDecorView();
            this.Jw = (ViewGroup) viewGroup.getChildAt(0);
            viewGroup.removeView(this.Jw);
            this.Jw.setClickable(true);
            addView(this.Jw);
            this.mContentView = (View) this.Jw.getParent();
            viewGroup.addView(this);
        } catch (Exception e) {
            this.JA = false;
            BdLog.e(e);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.JA) {
            if (this.JH && i == 1) {
                this.Jw.setBackgroundResource(R.color.swipe_layout_night_bg);
            } else {
                this.Jw.setBackgroundResource(R.color.swipe_layout_normal_bg);
            }
        }
    }

    public void aE(int i) {
        if (this.JH && i == 1) {
            this.Jw.setBackgroundResource(R.color.swipe_layout_night_bg);
        } else {
            this.Jw.setBackgroundResource(R.color.swipe_layout_normal_bg);
        }
    }

    public void setIsSupportNight(boolean z) {
        if (!z) {
            this.Jw.setBackgroundResource(R.color.swipe_layout_normal_bg);
        }
        this.JH = z;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.mContentView != null) {
            int i = this.Jx;
            int bottom = this.mContentView.getBottom();
            this.JE.top = 0;
            this.JE.bottom = bottom;
            this.JE.left = 0;
            this.JE.right = i;
            canvas.clipRect(this.JE);
            if (this.mViewWidth != 0) {
                this.JD = 100 - ((int) (((-this.Jx) / this.mViewWidth) * 120.0f));
            }
            if (this.JD > 100) {
                this.JD = 100;
            }
            if (this.Jz) {
                this.JD = 0;
            }
            if (this.JD < 0) {
                this.JD = 0;
            }
            canvas.drawARGB(this.JD, 0, 0, 0);
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (!this.JA) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (this.Jz || this.JB) {
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
                    this.Fi = MotionEventCompat.getX(motionEvent, actionIndex);
                    break;
                }
                break;
            case 2:
                determineDrag(motionEvent);
                break;
        }
        return this.Jy;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.Jz || this.JB) {
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
                this.Fi = MotionEventCompat.getX(motionEvent, actionIndex);
                break;
            case 1:
                VelocityTracker velocityTracker = this.mVelocityTracker;
                velocityTracker.computeCurrentVelocity(1000, this.mMaximumVelocity);
                this.JG = velocityTracker.getXVelocity();
                int f = f(motionEvent);
                endDrag();
                if (Math.abs(this.JG) > this.mMinimumVelocity && f > this.mFlingDistance) {
                    if (this.JG > 0.0f) {
                        this.Jz = true;
                        oe();
                        return true;
                    }
                    of();
                    this.Jz = false;
                    return true;
                } else if (this.mContentView.getScrollX() <= (-this.mViewWidth) / 2) {
                    this.Jz = true;
                    oe();
                    break;
                } else {
                    of();
                    this.Jz = false;
                    break;
                }
                break;
            case 2:
                if (!this.Jy) {
                    determineDrag(motionEvent);
                }
                if (this.Jy) {
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
                        this.Jx = (int) f2;
                        this.mContentView.scrollTo((int) f2, getScrollY());
                        break;
                    }
                }
                break;
            case 3:
                og();
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
            if (f > 0.0f && abs > this.JF && abs > abs2) {
                this.Jy = true;
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
        return (int) Math.abs(MotionEventCompat.getX(motionEvent, pointerIndex) - this.Fi);
    }

    private void endDrag() {
        this.Jy = false;
        this.mActivePointerId = -1;
        og();
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

    private void oe() {
        this.JB = true;
        this.mScroller.startScroll(this.mContentView.getScrollX(), 0, (-(this.mViewWidth + this.mContentView.getScrollX())) + 1, 0);
        postInvalidate();
    }

    private void of() {
        this.JB = true;
        this.mScroller.startScroll(this.mContentView.getScrollX(), 0, -this.mContentView.getScrollX(), 0);
        postInvalidate();
    }

    private void completeScroll() {
        if (this.JB) {
            this.mScroller.abortAnimation();
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            int currX = this.mScroller.getCurrX();
            int currY = this.mScroller.getCurrY();
            if (scrollX != currX || scrollY != currY) {
                this.mContentView.scrollTo(currX, currY);
            }
        }
        this.JB = false;
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
        if (this.mScroller.isFinished() && this.Jz) {
            this.mActivity.finish();
            this.mActivity.overridePendingTransition(0, 0);
        }
        if (this.mScroller.isFinished()) {
            completeScroll();
        }
    }

    private void og() {
        if (this.mVelocityTracker != null) {
            this.mVelocityTracker.clear();
            this.mVelocityTracker.recycle();
            this.mVelocityTracker = null;
        }
    }

    public boolean isSwipeBackEnabled() {
        return this.JA;
    }

    public void setSwipeBackEnabled(boolean z) {
        this.JA = z;
    }

    public void oh() {
        if (this.Jw != null) {
            this.Jw.setBackgroundResource(R.color.transparent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a implements Interpolator {
        private final float JI;

        public a(float f) {
            this.JI = f;
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            float f2 = this.JI * f;
            if (f2 > 0.9d) {
                return 1.0f;
            }
            return f2;
        }
    }
}
