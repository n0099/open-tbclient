package com.baidu.adp.widget;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.view.MotionEventCompat;
import android.util.AttributeSet;
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
import com.baidu.adp.lib.util.l;
/* loaded from: classes.dex */
public class SwipeBackLayout extends FrameLayout {
    private ViewGroup QT;
    private int QU;
    private boolean QV;
    private boolean QW;
    private boolean QX;
    private boolean QY;
    private boolean QZ;
    private int Ra;
    private int Rb;
    private Rect Rc;
    private int Rd;
    private float Re;
    private boolean Rf;
    private boolean Rg;
    private b Rh;
    private int mActivePointerId;
    private Activity mActivity;
    private View mContentView;
    private float mDownX;
    private int mFlingDistance;
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
        void az(boolean z);

        void pn();
    }

    /* loaded from: classes.dex */
    public interface c {
        void po();

        void pp();
    }

    public SwipeBackLayout(Context context) {
        super(context);
        this.mActivePointerId = -1;
        this.QV = false;
        this.QW = false;
        this.QX = true;
        this.QY = false;
        this.QZ = false;
        this.Rb = 0;
        this.Rc = new Rect();
        this.Rf = false;
        this.Rg = true;
        init(context);
    }

    public SwipeBackLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mActivePointerId = -1;
        this.QV = false;
        this.QW = false;
        this.QX = true;
        this.QY = false;
        this.QZ = false;
        this.Rb = 0;
        this.Rc = new Rect();
        this.Rf = false;
        this.Rg = true;
        init(context);
    }

    public SwipeBackLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mActivePointerId = -1;
        this.QV = false;
        this.QW = false;
        this.QX = true;
        this.QY = false;
        this.QZ = false;
        this.Rb = 0;
        this.Rc = new Rect();
        this.Rf = false;
        this.Rg = true;
        init(context);
    }

    private void init(Context context) {
        this.Ra = (int) TypedValue.applyDimension(1, 24.0f, getResources().getDisplayMetrics());
        this.mScroller = new Scroller(context, new a(1.5f));
        this.mTouchSlop = ViewConfiguration.get(context.getApplicationContext()).getScaledTouchSlop() * 2;
        this.mMaximumVelocity = ViewConfiguration.getMaximumFlingVelocity();
        this.mMinimumVelocity = ViewConfiguration.getMinimumFlingVelocity();
        this.Rd = (int) (context.getResources().getDisplayMetrics().density * 24.0f);
        this.mFlingDistance = l.aO(context) / 4;
    }

    public void t(Activity activity) {
        try {
            this.mActivity = activity;
            Window window = activity.getWindow();
            window.setBackgroundDrawable(new ColorDrawable(0));
            ViewGroup viewGroup = (ViewGroup) window.getDecorView();
            this.QT = (ViewGroup) viewGroup.getChildAt(0);
            viewGroup.removeView(this.QT);
            this.QT.setClickable(true);
            addView(this.QT);
            this.mContentView = (View) this.QT.getParent();
            viewGroup.addView(this);
        } catch (Exception e) {
            this.QX = false;
            BdLog.e(e);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.QX) {
            if (this.Rg && i == 1) {
                this.QT.setBackgroundResource(R.color.swipe_layout_night_bg);
            } else {
                this.QT.setBackgroundResource(R.color.swipe_layout_normal_bg);
            }
        }
    }

    public void bb(int i) {
        if (this.Rg && i == 1) {
            this.QT.setBackgroundResource(R.color.swipe_layout_night_bg);
        } else {
            this.QT.setBackgroundResource(R.color.swipe_layout_normal_bg);
        }
    }

    public void setIsSupportNight(boolean z) {
        if (!z) {
            this.QT.setBackgroundResource(R.color.swipe_layout_normal_bg);
        }
        this.Rg = z;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.mContentView != null) {
            int i = this.QU;
            int bottom = this.mContentView.getBottom();
            this.Rc.top = 0;
            this.Rc.bottom = bottom;
            this.Rc.left = 0;
            this.Rc.right = i;
            canvas.clipRect(this.Rc);
            if (this.mViewWidth != 0) {
                this.Rb = 100 - ((int) (((-this.QU) / this.mViewWidth) * 120.0f));
            }
            if (this.Rb > 100) {
                this.Rb = 100;
            }
            if (this.QW) {
                this.Rb = 0;
            }
            if (this.Rb < 0) {
                this.Rb = 0;
            }
            canvas.drawARGB(this.Rb, 0, 0, 0);
        }
    }

    private boolean n(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if ((action == 1 || action == 3) && this.Rf) {
            this.Rf = false;
            this.QX = true;
            return true;
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        n(motionEvent);
        return dispatchTouchEvent;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (!this.QX) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (this.QW || this.QY) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction() & 255;
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
                    this.mDownX = MotionEventCompat.getX(motionEvent, actionIndex);
                    break;
                }
                break;
            case 2:
                o(motionEvent);
                break;
        }
        return this.QV;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.QW || this.QY) {
            return super.onTouchEvent(motionEvent);
        }
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        this.mVelocityTracker.addMovement(motionEvent);
        switch (motionEvent.getAction() & 255) {
            case 0:
                pm();
                int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
                this.mActivePointerId = MotionEventCompat.getPointerId(motionEvent, actionIndex);
                this.mLastMotionX = motionEvent.getX();
                this.mDownX = MotionEventCompat.getX(motionEvent, actionIndex);
                break;
            case 1:
                VelocityTracker velocityTracker = this.mVelocityTracker;
                velocityTracker.computeCurrentVelocity(1000, this.mMaximumVelocity);
                this.Re = velocityTracker.getXVelocity();
                int p = p(motionEvent);
                endDrag();
                if (Math.abs(this.Re) > this.mMinimumVelocity && p > this.mFlingDistance) {
                    if (this.Re > 0.0f) {
                        this.QW = true;
                        pk();
                    } else {
                        pl();
                        this.QW = false;
                    }
                    if (this.Rh != null) {
                        this.Rh.az(this.QW);
                        return true;
                    }
                    return true;
                }
                if (this.mContentView.getScrollX() <= (-this.mViewWidth) / 2) {
                    this.QW = true;
                    pk();
                } else {
                    pl();
                    this.QW = false;
                }
                if (this.Rh != null) {
                    this.Rh.az(this.QW);
                    break;
                }
                break;
            case 2:
                if (!this.QV) {
                    o(motionEvent);
                }
                if (this.QV) {
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
                        this.QU = (int) f;
                        this.mContentView.scrollTo((int) f, getScrollY());
                        break;
                    }
                }
                break;
            case 3:
                releaseVelocityTracker();
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    private void o(MotionEvent motionEvent) {
        int i = this.mActivePointerId;
        int pointerIndex = getPointerIndex(motionEvent, i);
        if (!a(motionEvent, pointerIndex, i)) {
            float x = MotionEventCompat.getX(motionEvent, pointerIndex);
            float f = x - this.mLastMotionX;
            float abs = Math.abs(f);
            float y = MotionEventCompat.getY(motionEvent, pointerIndex);
            float abs2 = Math.abs(y - this.mLastMotionY);
            if (f > 0.0f && abs > this.Rd && abs > abs2) {
                this.QV = true;
                if (this.Rh != null) {
                    this.Rh.pn();
                }
                this.mLastMotionX = x;
                this.mLastMotionY = y;
            }
        }
    }

    private int p(MotionEvent motionEvent) {
        int i = this.mActivePointerId;
        int pointerIndex = getPointerIndex(motionEvent, i);
        if (a(motionEvent, pointerIndex, i)) {
            return 0;
        }
        return (int) Math.abs(MotionEventCompat.getX(motionEvent, pointerIndex) - this.mDownX);
    }

    private void endDrag() {
        this.QV = false;
        this.mActivePointerId = -1;
        releaseVelocityTracker();
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

    private void pk() {
        this.QY = true;
        this.mScroller.startScroll(this.mContentView.getScrollX(), 0, (-(this.mViewWidth + this.mContentView.getScrollX())) + 1, 0);
        postInvalidate();
    }

    private void pl() {
        this.QY = true;
        this.mScroller.startScroll(this.mContentView.getScrollX(), 0, -this.mContentView.getScrollX(), 0);
        postInvalidate();
    }

    private void pm() {
        if (this.QY) {
            this.mScroller.abortAnimation();
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            int currX = this.mScroller.getCurrX();
            int currY = this.mScroller.getCurrY();
            if (scrollX != currX || scrollY != currY) {
                this.mContentView.scrollTo(currX, currY);
            }
        }
        this.QY = false;
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
        if (this.mScroller.isFinished() && this.QW) {
            this.mActivity.finish();
            this.mActivity.overridePendingTransition(0, 0);
        }
        if (this.mScroller.isFinished()) {
            pm();
        }
    }

    private void releaseVelocityTracker() {
        if (this.mVelocityTracker != null) {
            this.mVelocityTracker.clear();
            this.mVelocityTracker.recycle();
            this.mVelocityTracker = null;
        }
    }

    public void disableSwipeJustOnce() {
        this.Rf = true;
        this.QX = false;
    }

    public boolean isSwipeBackEnabled() {
        return this.QX;
    }

    public void setSwipeBackEnabled(boolean z) {
        this.QX = z;
    }

    public void setBgTransparent() {
        if (this.QT != null) {
            this.QT.setBackgroundResource(R.color.transparent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a implements Interpolator {
        private final float Ri;

        public a(float f) {
            this.Ri = f;
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            float f2 = this.Ri * f;
            if (f2 > 0.9d) {
                return 1.0f;
            }
            return f2;
        }
    }

    public void setOnSlidingStateChangeListener(b bVar) {
        this.Rh = bVar;
    }
}
