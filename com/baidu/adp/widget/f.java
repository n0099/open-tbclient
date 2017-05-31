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
    private int IA;
    private int IB;
    private Rect IC;
    private int IE;
    private float IF;
    private boolean IG;
    private b IH;
    private ViewGroup Iu;
    private int Iv;
    private boolean Iw;
    private boolean Ix;
    private boolean Iy;
    private boolean Iz;
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
        void W(boolean z);

        void ls();
    }

    /* loaded from: classes.dex */
    public interface c {
        void lt();

        void lu();
    }

    public f(Context context) {
        super(context);
        this.mActivePointerId = -1;
        this.Iw = false;
        this.Ix = false;
        this.Iy = true;
        this.mIsScrolling = false;
        this.Iz = false;
        this.IB = 0;
        this.IC = new Rect();
        this.IG = true;
        init(context);
    }

    private void init(Context context) {
        this.IA = (int) TypedValue.applyDimension(1, 24.0f, getResources().getDisplayMetrics());
        this.mScroller = new Scroller(context, new a(1.5f));
        this.mTouchSlop = ViewConfiguration.get(context.getApplicationContext()).getScaledTouchSlop() * 2;
        this.mMaximumVelocity = ViewConfiguration.getMaximumFlingVelocity();
        this.mMinimumVelocity = ViewConfiguration.getMinimumFlingVelocity();
        this.IE = (int) (context.getResources().getDisplayMetrics().density * 24.0f);
        this.mFlingDistance = k.af(context) / 4;
    }

    public void p(Activity activity) {
        try {
            this.mActivity = activity;
            Window window = activity.getWindow();
            window.setBackgroundDrawable(new ColorDrawable(0));
            ViewGroup viewGroup = (ViewGroup) window.getDecorView();
            this.Iu = (ViewGroup) viewGroup.getChildAt(0);
            viewGroup.removeView(this.Iu);
            this.Iu.setClickable(true);
            addView(this.Iu);
            this.mContentView = (View) this.Iu.getParent();
            viewGroup.addView(this);
        } catch (Exception e) {
            this.Iy = false;
            BdLog.e(e);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.Iy) {
            if (this.IG && i == 1) {
                this.Iu.setBackgroundResource(R.color.swipe_layout_night_bg);
            } else {
                this.Iu.setBackgroundResource(R.color.swipe_layout_normal_bg);
            }
        }
    }

    public void aK(int i) {
        if (this.IG && i == 1) {
            this.Iu.setBackgroundResource(R.color.swipe_layout_night_bg);
        } else {
            this.Iu.setBackgroundResource(R.color.swipe_layout_normal_bg);
        }
    }

    public void setIsSupportNight(boolean z) {
        if (!z) {
            this.Iu.setBackgroundResource(R.color.swipe_layout_normal_bg);
        }
        this.IG = z;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.mContentView != null) {
            int i = this.Iv;
            int bottom = this.mContentView.getBottom();
            this.IC.top = 0;
            this.IC.bottom = bottom;
            this.IC.left = 0;
            this.IC.right = i;
            canvas.clipRect(this.IC);
            if (this.mViewWidth != 0) {
                this.IB = 100 - ((int) (((-this.Iv) / this.mViewWidth) * 120.0f));
            }
            if (this.IB > 100) {
                this.IB = 100;
            }
            if (this.Ix) {
                this.IB = 0;
            }
            if (this.IB < 0) {
                this.IB = 0;
            }
            canvas.drawARGB(this.IB, 0, 0, 0);
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (!this.Iy) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (this.Ix || this.mIsScrolling) {
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
        return this.Iw;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.Ix || this.mIsScrolling) {
            return super.onTouchEvent(motionEvent);
        }
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        this.mVelocityTracker.addMovement(motionEvent);
        switch (motionEvent.getAction() & MotionEventCompat.ACTION_MASK) {
            case 0:
                lp();
                int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
                this.mActivePointerId = MotionEventCompat.getPointerId(motionEvent, actionIndex);
                this.mLastMotionX = motionEvent.getX();
                this.FG = MotionEventCompat.getX(motionEvent, actionIndex);
                break;
            case 1:
                VelocityTracker velocityTracker = this.mVelocityTracker;
                velocityTracker.computeCurrentVelocity(1000, this.mMaximumVelocity);
                this.IF = velocityTracker.getXVelocity();
                int h = h(motionEvent);
                endDrag();
                if (Math.abs(this.IF) > this.mMinimumVelocity && h > this.mFlingDistance) {
                    if (this.IF > 0.0f) {
                        this.Ix = true;
                        ln();
                    } else {
                        lo();
                        this.Ix = false;
                    }
                    if (this.IH != null) {
                        this.IH.W(this.Ix);
                        return true;
                    }
                    return true;
                }
                if (this.mContentView.getScrollX() <= (-this.mViewWidth) / 2) {
                    this.Ix = true;
                    ln();
                } else {
                    lo();
                    this.Ix = false;
                }
                if (this.IH != null) {
                    this.IH.W(this.Ix);
                    break;
                }
                break;
            case 2:
                if (!this.Iw) {
                    g(motionEvent);
                }
                if (this.Iw) {
                    int b2 = b(motionEvent, this.mActivePointerId);
                    if (!a(motionEvent, b2, this.mActivePointerId)) {
                        float x = MotionEventCompat.getX(motionEvent, b2);
                        this.mLastMotionX = x;
                        float scrollX = (this.mLastMotionX - x) + getScrollX();
                        float f = -this.mViewWidth;
                        if (scrollX >= f) {
                            f = scrollX > 0.0f ? 0.0f : scrollX;
                        }
                        this.mLastMotionX += f - ((int) f);
                        this.Iv = (int) f;
                        this.mContentView.scrollTo((int) f, getScrollY());
                        break;
                    }
                }
                break;
            case 3:
                lq();
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    private void g(MotionEvent motionEvent) {
        int i = this.mActivePointerId;
        int b2 = b(motionEvent, i);
        if (!a(motionEvent, b2, i)) {
            float x = MotionEventCompat.getX(motionEvent, b2);
            float f = x - this.mLastMotionX;
            float abs = Math.abs(f);
            float y = MotionEventCompat.getY(motionEvent, b2);
            float abs2 = Math.abs(y - this.mLastMotionY);
            if (f > 0.0f && abs > this.IE && abs > abs2) {
                this.Iw = true;
                if (this.IH != null) {
                    this.IH.ls();
                }
                this.mLastMotionX = x;
                this.mLastMotionY = y;
            }
        }
    }

    private int h(MotionEvent motionEvent) {
        int i = this.mActivePointerId;
        int b2 = b(motionEvent, i);
        if (a(motionEvent, b2, i)) {
            return 0;
        }
        return (int) Math.abs(MotionEventCompat.getX(motionEvent, b2) - this.FG);
    }

    private void endDrag() {
        this.Iw = false;
        this.mActivePointerId = -1;
        lq();
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

    private int b(MotionEvent motionEvent, int i) {
        int findPointerIndex = MotionEventCompat.findPointerIndex(motionEvent, i);
        if (findPointerIndex == -1) {
            this.mActivePointerId = -1;
        }
        return findPointerIndex;
    }

    private void ln() {
        this.mIsScrolling = true;
        this.mScroller.startScroll(this.mContentView.getScrollX(), 0, (-(this.mViewWidth + this.mContentView.getScrollX())) + 1, 0);
        postInvalidate();
    }

    private void lo() {
        this.mIsScrolling = true;
        this.mScroller.startScroll(this.mContentView.getScrollX(), 0, -this.mContentView.getScrollX(), 0);
        postInvalidate();
    }

    private void lp() {
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
        if (this.mScroller.isFinished() && this.Ix) {
            this.mActivity.finish();
            this.mActivity.overridePendingTransition(0, 0);
        }
        if (this.mScroller.isFinished()) {
            lp();
        }
    }

    private void lq() {
        if (this.mVelocityTracker != null) {
            this.mVelocityTracker.clear();
            this.mVelocityTracker.recycle();
            this.mVelocityTracker = null;
        }
    }

    public boolean isSwipeBackEnabled() {
        return this.Iy;
    }

    public void setSwipeBackEnabled(boolean z) {
        this.Iy = z;
    }

    public void lr() {
        if (this.Iu != null) {
            this.Iu.setBackgroundResource(R.color.transparent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a implements Interpolator {
        private final float II;

        public a(float f) {
            this.II = f;
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            float f2 = this.II * f;
            if (f2 > 0.9d) {
                return 1.0f;
            }
            return f2;
        }
    }

    public void setOnSlidingStateChangeListener(b bVar) {
        this.IH = bVar;
    }
}
