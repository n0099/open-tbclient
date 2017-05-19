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
    private float FG;
    private ViewGroup IH;
    private int II;
    private boolean IJ;
    private boolean IK;
    private boolean IL;
    private boolean IM;
    private int IN;
    private int IO;
    private Rect IP;
    private int IQ;
    private float IR;
    private boolean IS;
    private b IT;
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
        void lA();

        void lz();
    }

    /* loaded from: classes.dex */
    public interface c {
        void lB();

        void lC();
    }

    public f(Context context) {
        super(context);
        this.mActivePointerId = -1;
        this.IJ = false;
        this.IK = false;
        this.IL = true;
        this.mIsScrolling = false;
        this.IM = false;
        this.IO = 0;
        this.IP = new Rect();
        this.IS = true;
        init(context);
    }

    private void init(Context context) {
        this.IN = (int) TypedValue.applyDimension(1, 24.0f, getResources().getDisplayMetrics());
        this.mScroller = new Scroller(context, new a(1.5f));
        this.mTouchSlop = ViewConfiguration.get(context.getApplicationContext()).getScaledTouchSlop() * 2;
        this.mMaximumVelocity = ViewConfiguration.getMaximumFlingVelocity();
        this.mMinimumVelocity = ViewConfiguration.getMinimumFlingVelocity();
        this.IQ = (int) (context.getResources().getDisplayMetrics().density * 24.0f);
        this.mFlingDistance = k.af(context) / 4;
    }

    public void o(Activity activity) {
        try {
            this.mActivity = activity;
            Window window = activity.getWindow();
            window.setBackgroundDrawable(new ColorDrawable(0));
            ViewGroup viewGroup = (ViewGroup) window.getDecorView();
            this.IH = (ViewGroup) viewGroup.getChildAt(0);
            viewGroup.removeView(this.IH);
            this.IH.setClickable(true);
            addView(this.IH);
            this.mContentView = (View) this.IH.getParent();
            viewGroup.addView(this);
        } catch (Exception e) {
            this.IL = false;
            BdLog.e(e);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.IL) {
            if (this.IS && i == 1) {
                this.IH.setBackgroundResource(R.color.swipe_layout_night_bg);
            } else {
                this.IH.setBackgroundResource(R.color.swipe_layout_normal_bg);
            }
        }
    }

    public void aJ(int i) {
        if (this.IS && i == 1) {
            this.IH.setBackgroundResource(R.color.swipe_layout_night_bg);
        } else {
            this.IH.setBackgroundResource(R.color.swipe_layout_normal_bg);
        }
    }

    public void setIsSupportNight(boolean z) {
        if (!z) {
            this.IH.setBackgroundResource(R.color.swipe_layout_normal_bg);
        }
        this.IS = z;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.mContentView != null) {
            int i = this.II;
            int bottom = this.mContentView.getBottom();
            this.IP.top = 0;
            this.IP.bottom = bottom;
            this.IP.left = 0;
            this.IP.right = i;
            canvas.clipRect(this.IP);
            if (this.mViewWidth != 0) {
                this.IO = 100 - ((int) (((-this.II) / this.mViewWidth) * 120.0f));
            }
            if (this.IO > 100) {
                this.IO = 100;
            }
            if (this.IK) {
                this.IO = 0;
            }
            if (this.IO < 0) {
                this.IO = 0;
            }
            canvas.drawARGB(this.IO, 0, 0, 0);
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (!this.IL) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (this.IK || this.mIsScrolling) {
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
                    this.FG = MotionEventCompat.getX(motionEvent, actionIndex);
                    break;
                }
                break;
            case 2:
                g(motionEvent);
                break;
        }
        return this.IJ;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.IK || this.mIsScrolling) {
            return super.onTouchEvent(motionEvent);
        }
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        this.mVelocityTracker.addMovement(motionEvent);
        switch (motionEvent.getAction() & MotionEventCompat.ACTION_MASK) {
            case 0:
                lw();
                int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
                this.mActivePointerId = MotionEventCompat.getPointerId(motionEvent, actionIndex);
                this.mLastMotionX = motionEvent.getX();
                this.FG = MotionEventCompat.getX(motionEvent, actionIndex);
                break;
            case 1:
                VelocityTracker velocityTracker = this.mVelocityTracker;
                velocityTracker.computeCurrentVelocity(1000, this.mMaximumVelocity);
                this.IR = velocityTracker.getXVelocity();
                int h = h(motionEvent);
                endDrag();
                if (Math.abs(this.IR) > this.mMinimumVelocity && h > this.mFlingDistance) {
                    if (this.IR > 0.0f) {
                        this.IK = true;
                        lu();
                        return true;
                    }
                    lv();
                    this.IK = false;
                    return true;
                } else if (this.mContentView.getScrollX() <= (-this.mViewWidth) / 2) {
                    this.IK = true;
                    lu();
                    break;
                } else {
                    lv();
                    this.IK = false;
                    break;
                }
                break;
            case 2:
                if (!this.IJ) {
                    g(motionEvent);
                }
                if (this.IJ) {
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
                        this.II = (int) f;
                        this.mContentView.scrollTo((int) f, getScrollY());
                        break;
                    }
                }
                break;
            case 3:
                lx();
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
            if (f > 0.0f && abs > this.IQ && abs > abs2) {
                this.IJ = true;
                if (this.IT != null) {
                    this.IT.lz();
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
        return (int) Math.abs(MotionEventCompat.getX(motionEvent, d) - this.FG);
    }

    private void endDrag() {
        this.IJ = false;
        if (this.IT != null) {
            this.IT.lA();
        }
        this.mActivePointerId = -1;
        lx();
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

    private void lu() {
        this.mIsScrolling = true;
        this.mScroller.startScroll(this.mContentView.getScrollX(), 0, (-(this.mViewWidth + this.mContentView.getScrollX())) + 1, 0);
        postInvalidate();
    }

    private void lv() {
        this.mIsScrolling = true;
        this.mScroller.startScroll(this.mContentView.getScrollX(), 0, -this.mContentView.getScrollX(), 0);
        postInvalidate();
    }

    private void lw() {
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
        if (this.mScroller.isFinished() && this.IK) {
            this.mActivity.finish();
            this.mActivity.overridePendingTransition(0, 0);
        }
        if (this.mScroller.isFinished()) {
            lw();
        }
    }

    private void lx() {
        if (this.mVelocityTracker != null) {
            this.mVelocityTracker.clear();
            this.mVelocityTracker.recycle();
            this.mVelocityTracker = null;
        }
    }

    public boolean isSwipeBackEnabled() {
        return this.IL;
    }

    public void setSwipeBackEnabled(boolean z) {
        this.IL = z;
    }

    public void ly() {
        if (this.IH != null) {
            this.IH.setBackgroundResource(R.color.transparent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a implements Interpolator {
        private final float IU;

        public a(float f) {
            this.IU = f;
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            float f2 = this.IU * f;
            if (f2 > 0.9d) {
                return 1.0f;
            }
            return f2;
        }
    }

    public void setOnSlidingStateChangeListener(b bVar) {
        this.IT = bVar;
    }
}
