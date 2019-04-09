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
    private ViewGroup QU;
    private int QV;
    private boolean QW;
    private boolean QX;
    private boolean QY;
    private boolean QZ;
    private boolean Ra;
    private int Rb;
    private int Rc;
    private Rect Rd;
    private int Re;
    private float Rf;
    private boolean Rg;
    private boolean Rh;
    private b Ri;
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
        this.QW = false;
        this.QX = false;
        this.QY = true;
        this.QZ = false;
        this.Ra = false;
        this.Rc = 0;
        this.Rd = new Rect();
        this.Rg = false;
        this.Rh = true;
        init(context);
    }

    public SwipeBackLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mActivePointerId = -1;
        this.QW = false;
        this.QX = false;
        this.QY = true;
        this.QZ = false;
        this.Ra = false;
        this.Rc = 0;
        this.Rd = new Rect();
        this.Rg = false;
        this.Rh = true;
        init(context);
    }

    public SwipeBackLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mActivePointerId = -1;
        this.QW = false;
        this.QX = false;
        this.QY = true;
        this.QZ = false;
        this.Ra = false;
        this.Rc = 0;
        this.Rd = new Rect();
        this.Rg = false;
        this.Rh = true;
        init(context);
    }

    private void init(Context context) {
        this.Rb = (int) TypedValue.applyDimension(1, 24.0f, getResources().getDisplayMetrics());
        this.mScroller = new Scroller(context, new a(1.5f));
        this.mTouchSlop = ViewConfiguration.get(context.getApplicationContext()).getScaledTouchSlop() * 2;
        this.mMaximumVelocity = ViewConfiguration.getMaximumFlingVelocity();
        this.mMinimumVelocity = ViewConfiguration.getMinimumFlingVelocity();
        this.Re = (int) (context.getResources().getDisplayMetrics().density * 24.0f);
        this.mFlingDistance = l.aO(context) / 4;
    }

    public void t(Activity activity) {
        try {
            this.mActivity = activity;
            Window window = activity.getWindow();
            window.setBackgroundDrawable(new ColorDrawable(0));
            ViewGroup viewGroup = (ViewGroup) window.getDecorView();
            this.QU = (ViewGroup) viewGroup.getChildAt(0);
            viewGroup.removeView(this.QU);
            this.QU.setClickable(true);
            addView(this.QU);
            this.mContentView = (View) this.QU.getParent();
            viewGroup.addView(this);
        } catch (Exception e) {
            this.QY = false;
            BdLog.e(e);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.QY) {
            if (this.Rh && i == 1) {
                this.QU.setBackgroundResource(R.color.swipe_layout_night_bg);
            } else {
                this.QU.setBackgroundResource(R.color.swipe_layout_normal_bg);
            }
        }
    }

    public void ba(int i) {
        if (this.Rh && i == 1) {
            this.QU.setBackgroundResource(R.color.swipe_layout_night_bg);
        } else {
            this.QU.setBackgroundResource(R.color.swipe_layout_normal_bg);
        }
    }

    public void setIsSupportNight(boolean z) {
        if (!z) {
            this.QU.setBackgroundResource(R.color.swipe_layout_normal_bg);
        }
        this.Rh = z;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.mContentView != null) {
            int i = this.QV;
            int bottom = this.mContentView.getBottom();
            this.Rd.top = 0;
            this.Rd.bottom = bottom;
            this.Rd.left = 0;
            this.Rd.right = i;
            canvas.clipRect(this.Rd);
            if (this.mViewWidth != 0) {
                this.Rc = 100 - ((int) (((-this.QV) / this.mViewWidth) * 120.0f));
            }
            if (this.Rc > 100) {
                this.Rc = 100;
            }
            if (this.QX) {
                this.Rc = 0;
            }
            if (this.Rc < 0) {
                this.Rc = 0;
            }
            canvas.drawARGB(this.Rc, 0, 0, 0);
        }
    }

    private boolean n(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if ((action == 1 || action == 3) && this.Rg) {
            this.Rg = false;
            this.QY = true;
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
        if (!this.QY) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (this.QX || this.QZ) {
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
        return this.QW;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.QX || this.QZ) {
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
                this.Rf = velocityTracker.getXVelocity();
                int p = p(motionEvent);
                endDrag();
                if (Math.abs(this.Rf) > this.mMinimumVelocity && p > this.mFlingDistance) {
                    if (this.Rf > 0.0f) {
                        this.QX = true;
                        pk();
                    } else {
                        pl();
                        this.QX = false;
                    }
                    if (this.Ri != null) {
                        this.Ri.az(this.QX);
                        return true;
                    }
                    return true;
                }
                if (this.mContentView.getScrollX() <= (-this.mViewWidth) / 2) {
                    this.QX = true;
                    pk();
                } else {
                    pl();
                    this.QX = false;
                }
                if (this.Ri != null) {
                    this.Ri.az(this.QX);
                    break;
                }
                break;
            case 2:
                if (!this.QW) {
                    o(motionEvent);
                }
                if (this.QW) {
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
                        this.QV = (int) f;
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
            if (f > 0.0f && abs > this.Re && abs > abs2) {
                this.QW = true;
                if (this.Ri != null) {
                    this.Ri.pn();
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
        this.QW = false;
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
        this.QZ = true;
        this.mScroller.startScroll(this.mContentView.getScrollX(), 0, (-(this.mViewWidth + this.mContentView.getScrollX())) + 1, 0);
        postInvalidate();
    }

    private void pl() {
        this.QZ = true;
        this.mScroller.startScroll(this.mContentView.getScrollX(), 0, -this.mContentView.getScrollX(), 0);
        postInvalidate();
    }

    private void pm() {
        if (this.QZ) {
            this.mScroller.abortAnimation();
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            int currX = this.mScroller.getCurrX();
            int currY = this.mScroller.getCurrY();
            if (scrollX != currX || scrollY != currY) {
                this.mContentView.scrollTo(currX, currY);
            }
        }
        this.QZ = false;
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
        if (this.mScroller.isFinished() && this.QX) {
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
        this.Rg = true;
        this.QY = false;
    }

    public boolean isSwipeBackEnabled() {
        return this.QY;
    }

    public void setSwipeBackEnabled(boolean z) {
        this.QY = z;
    }

    public void setBgTransparent() {
        if (this.QU != null) {
            this.QU.setBackgroundResource(R.color.transparent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a implements Interpolator {
        private final float Rj;

        public a(float f) {
            this.Rj = f;
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            float f2 = this.Rj * f;
            if (f2 > 0.9d) {
                return 1.0f;
            }
            return f2;
        }
    }

    public void setOnSlidingStateChangeListener(b bVar) {
        this.Ri = bVar;
    }
}
