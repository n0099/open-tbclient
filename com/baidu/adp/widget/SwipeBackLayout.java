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
    private ViewGroup PN;
    private int PO;
    private int PP;
    private boolean PQ;
    private boolean PR;
    private boolean PT;
    private boolean PU;
    private boolean PV;
    private int PW;
    private int PY;
    private Rect PZ;
    private int Qa;
    private float Qb;
    private boolean Qc;
    private boolean Qd;
    private b Qe;
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

    /* loaded from: classes.dex */
    public interface b {
        void ay(boolean z);

        void oU();
    }

    /* loaded from: classes.dex */
    public interface c {
        void oV();

        void oW();
    }

    public SwipeBackLayout(Context context) {
        super(context);
        this.mActivePointerId = -1;
        this.PQ = false;
        this.PR = false;
        this.PT = true;
        this.PU = false;
        this.PV = false;
        this.PY = 0;
        this.PZ = new Rect();
        this.Qc = false;
        this.Qd = true;
        init(context);
    }

    public SwipeBackLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mActivePointerId = -1;
        this.PQ = false;
        this.PR = false;
        this.PT = true;
        this.PU = false;
        this.PV = false;
        this.PY = 0;
        this.PZ = new Rect();
        this.Qc = false;
        this.Qd = true;
        init(context);
    }

    public SwipeBackLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mActivePointerId = -1;
        this.PQ = false;
        this.PR = false;
        this.PT = true;
        this.PU = false;
        this.PV = false;
        this.PY = 0;
        this.PZ = new Rect();
        this.Qc = false;
        this.Qd = true;
        init(context);
    }

    private void init(Context context) {
        this.PW = (int) TypedValue.applyDimension(1, 24.0f, getResources().getDisplayMetrics());
        this.mScroller = new Scroller(context, new a(1.5f));
        this.mTouchSlop = ViewConfiguration.get(context.getApplicationContext()).getScaledTouchSlop() * 2;
        this.mMaximumVelocity = ViewConfiguration.getMaximumFlingVelocity();
        this.mMinimumVelocity = ViewConfiguration.getMinimumFlingVelocity();
        this.Qa = (int) (context.getResources().getDisplayMetrics().density * 24.0f);
        this.mFlingDistance = l.aO(context) / 4;
    }

    public void t(Activity activity) {
        try {
            this.mActivity = activity;
            Window window = activity.getWindow();
            window.setBackgroundDrawable(new ColorDrawable(0));
            ViewGroup viewGroup = (ViewGroup) window.getDecorView();
            this.PN = (ViewGroup) viewGroup.getChildAt(0);
            viewGroup.removeView(this.PN);
            this.PN.setClickable(true);
            addView(this.PN);
            this.mContentView = (View) this.PN.getParent();
            viewGroup.addView(this);
        } catch (Exception e) {
            this.PT = false;
            BdLog.e(e);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.PT) {
            if (this.Qd && i == 1) {
                this.PN.setBackgroundResource(R.color.swipe_layout_night_bg);
            } else {
                this.PN.setBackgroundResource(R.color.swipe_layout_normal_bg);
            }
        }
    }

    public void bo(int i) {
        if (this.Qd && i == 1) {
            this.PN.setBackgroundResource(R.color.swipe_layout_night_bg);
        } else {
            this.PN.setBackgroundResource(R.color.swipe_layout_normal_bg);
        }
    }

    public void setIsSupportNight(boolean z) {
        if (!z) {
            this.PN.setBackgroundResource(R.color.swipe_layout_normal_bg);
        }
        this.Qd = z;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.mContentView != null) {
            int i = this.PP;
            int bottom = this.mContentView.getBottom();
            this.PZ.top = 0;
            this.PZ.bottom = bottom;
            this.PZ.left = 0;
            this.PZ.right = i;
            canvas.clipRect(this.PZ);
            if (this.PO != 0) {
                this.PY = 100 - ((int) (((-this.PP) / this.PO) * 120.0f));
            }
            if (this.PY > 100) {
                this.PY = 100;
            }
            if (this.PR) {
                this.PY = 0;
            }
            if (this.PY < 0) {
                this.PY = 0;
            }
            canvas.drawARGB(this.PY, 0, 0, 0);
        }
    }

    private boolean n(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if ((action == 1 || action == 3) && this.Qc) {
            this.Qc = false;
            this.PT = true;
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
        if (!this.PT) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (this.PR || this.PU) {
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
        return this.PQ;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.PR || this.PU) {
            return super.onTouchEvent(motionEvent);
        }
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        this.mVelocityTracker.addMovement(motionEvent);
        switch (motionEvent.getAction() & 255) {
            case 0:
                oT();
                int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
                this.mActivePointerId = MotionEventCompat.getPointerId(motionEvent, actionIndex);
                this.mLastMotionX = motionEvent.getX();
                this.mDownX = MotionEventCompat.getX(motionEvent, actionIndex);
                break;
            case 1:
                VelocityTracker velocityTracker = this.mVelocityTracker;
                velocityTracker.computeCurrentVelocity(1000, this.mMaximumVelocity);
                this.Qb = velocityTracker.getXVelocity();
                int p = p(motionEvent);
                endDrag();
                if (Math.abs(this.Qb) > this.mMinimumVelocity && p > this.mFlingDistance) {
                    if (this.Qb > 0.0f) {
                        this.PR = true;
                        oR();
                    } else {
                        oS();
                        this.PR = false;
                    }
                    if (this.Qe != null) {
                        this.Qe.ay(this.PR);
                        return true;
                    }
                    return true;
                }
                if (this.mContentView.getScrollX() <= (-this.PO) / 2) {
                    this.PR = true;
                    oR();
                } else {
                    oS();
                    this.PR = false;
                }
                if (this.Qe != null) {
                    this.Qe.ay(this.PR);
                    break;
                }
                break;
            case 2:
                if (!this.PQ) {
                    o(motionEvent);
                }
                if (this.PQ) {
                    int pointerIndex = getPointerIndex(motionEvent, this.mActivePointerId);
                    if (!a(motionEvent, pointerIndex, this.mActivePointerId)) {
                        float x = MotionEventCompat.getX(motionEvent, pointerIndex);
                        this.mLastMotionX = x;
                        float scrollX = (this.mLastMotionX - x) + getScrollX();
                        float f = -this.PO;
                        if (scrollX >= f) {
                            f = scrollX > 0.0f ? 0.0f : scrollX;
                        }
                        this.mLastMotionX += f - ((int) f);
                        this.PP = (int) f;
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
            if (f > 0.0f && abs > this.Qa && abs > abs2) {
                this.PQ = true;
                if (this.Qe != null) {
                    this.Qe.oU();
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
        this.PQ = false;
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
            this.PO = getWidth();
        }
    }

    private int getPointerIndex(MotionEvent motionEvent, int i) {
        int findPointerIndex = MotionEventCompat.findPointerIndex(motionEvent, i);
        if (findPointerIndex == -1) {
            this.mActivePointerId = -1;
        }
        return findPointerIndex;
    }

    private void oR() {
        this.PU = true;
        this.mScroller.startScroll(this.mContentView.getScrollX(), 0, (-(this.PO + this.mContentView.getScrollX())) + 1, 0);
        postInvalidate();
    }

    private void oS() {
        this.PU = true;
        this.mScroller.startScroll(this.mContentView.getScrollX(), 0, -this.mContentView.getScrollX(), 0);
        postInvalidate();
    }

    private void oT() {
        if (this.PU) {
            this.mScroller.abortAnimation();
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            int currX = this.mScroller.getCurrX();
            int currY = this.mScroller.getCurrY();
            if (scrollX != currX || scrollY != currY) {
                this.mContentView.scrollTo(currX, currY);
            }
        }
        this.PU = false;
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
        if (this.mScroller.isFinished() && this.PR) {
            this.mActivity.finish();
            this.mActivity.overridePendingTransition(0, 0);
        }
        if (this.mScroller.isFinished()) {
            oT();
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
        this.Qc = true;
        this.PT = false;
    }

    public boolean isSwipeBackEnabled() {
        return this.PT;
    }

    public void setSwipeBackEnabled(boolean z) {
        this.PT = z;
    }

    public void setBgTransparent() {
        if (this.PN != null) {
            this.PN.setBackgroundResource(R.color.transparent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a implements Interpolator {
        private final float Qf;

        public a(float f) {
            this.Qf = f;
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            float f2 = this.Qf * f;
            if (f2 > 0.9d) {
                return 1.0f;
            }
            return f2;
        }
    }

    public void setOnSlidingStateChangeListener(b bVar) {
        this.Qe = bVar;
    }
}
