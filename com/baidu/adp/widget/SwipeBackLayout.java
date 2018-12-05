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
    private ViewGroup PD;
    private int PE;
    private int PF;
    private boolean PG;
    private boolean PH;
    private boolean PI;
    private boolean PJ;
    private boolean PK;
    private int PM;
    private int PN;
    private Rect PO;
    private int PP;
    private float PQ;
    private boolean PR;
    private boolean PT;
    private b PU;
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

        void oQ();
    }

    /* loaded from: classes.dex */
    public interface c {
        void oR();

        void oS();
    }

    public SwipeBackLayout(Context context) {
        super(context);
        this.mActivePointerId = -1;
        this.PG = false;
        this.PH = false;
        this.PI = true;
        this.PJ = false;
        this.PK = false;
        this.PN = 0;
        this.PO = new Rect();
        this.PR = false;
        this.PT = true;
        init(context);
    }

    public SwipeBackLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mActivePointerId = -1;
        this.PG = false;
        this.PH = false;
        this.PI = true;
        this.PJ = false;
        this.PK = false;
        this.PN = 0;
        this.PO = new Rect();
        this.PR = false;
        this.PT = true;
        init(context);
    }

    public SwipeBackLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mActivePointerId = -1;
        this.PG = false;
        this.PH = false;
        this.PI = true;
        this.PJ = false;
        this.PK = false;
        this.PN = 0;
        this.PO = new Rect();
        this.PR = false;
        this.PT = true;
        init(context);
    }

    private void init(Context context) {
        this.PM = (int) TypedValue.applyDimension(1, 24.0f, getResources().getDisplayMetrics());
        this.mScroller = new Scroller(context, new a(1.5f));
        this.mTouchSlop = ViewConfiguration.get(context.getApplicationContext()).getScaledTouchSlop() * 2;
        this.mMaximumVelocity = ViewConfiguration.getMaximumFlingVelocity();
        this.mMinimumVelocity = ViewConfiguration.getMinimumFlingVelocity();
        this.PP = (int) (context.getResources().getDisplayMetrics().density * 24.0f);
        this.mFlingDistance = l.aO(context) / 4;
    }

    public void t(Activity activity) {
        try {
            this.mActivity = activity;
            Window window = activity.getWindow();
            window.setBackgroundDrawable(new ColorDrawable(0));
            ViewGroup viewGroup = (ViewGroup) window.getDecorView();
            this.PD = (ViewGroup) viewGroup.getChildAt(0);
            viewGroup.removeView(this.PD);
            this.PD.setClickable(true);
            addView(this.PD);
            this.mContentView = (View) this.PD.getParent();
            viewGroup.addView(this);
        } catch (Exception e) {
            this.PI = false;
            BdLog.e(e);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.PI) {
            if (this.PT && i == 1) {
                this.PD.setBackgroundResource(R.color.swipe_layout_night_bg);
            } else {
                this.PD.setBackgroundResource(R.color.swipe_layout_normal_bg);
            }
        }
    }

    public void bo(int i) {
        if (this.PT && i == 1) {
            this.PD.setBackgroundResource(R.color.swipe_layout_night_bg);
        } else {
            this.PD.setBackgroundResource(R.color.swipe_layout_normal_bg);
        }
    }

    public void setIsSupportNight(boolean z) {
        if (!z) {
            this.PD.setBackgroundResource(R.color.swipe_layout_normal_bg);
        }
        this.PT = z;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.mContentView != null) {
            int i = this.PF;
            int bottom = this.mContentView.getBottom();
            this.PO.top = 0;
            this.PO.bottom = bottom;
            this.PO.left = 0;
            this.PO.right = i;
            canvas.clipRect(this.PO);
            if (this.PE != 0) {
                this.PN = 100 - ((int) (((-this.PF) / this.PE) * 120.0f));
            }
            if (this.PN > 100) {
                this.PN = 100;
            }
            if (this.PH) {
                this.PN = 0;
            }
            if (this.PN < 0) {
                this.PN = 0;
            }
            canvas.drawARGB(this.PN, 0, 0, 0);
        }
    }

    private boolean n(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if ((action == 1 || action == 3) && this.PR) {
            this.PR = false;
            this.PI = true;
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
        if (!this.PI) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (this.PH || this.PJ) {
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
        return this.PG;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.PH || this.PJ) {
            return super.onTouchEvent(motionEvent);
        }
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        this.mVelocityTracker.addMovement(motionEvent);
        switch (motionEvent.getAction() & 255) {
            case 0:
                oP();
                int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
                this.mActivePointerId = MotionEventCompat.getPointerId(motionEvent, actionIndex);
                this.mLastMotionX = motionEvent.getX();
                this.mDownX = MotionEventCompat.getX(motionEvent, actionIndex);
                break;
            case 1:
                VelocityTracker velocityTracker = this.mVelocityTracker;
                velocityTracker.computeCurrentVelocity(1000, this.mMaximumVelocity);
                this.PQ = velocityTracker.getXVelocity();
                int p = p(motionEvent);
                endDrag();
                if (Math.abs(this.PQ) > this.mMinimumVelocity && p > this.mFlingDistance) {
                    if (this.PQ > 0.0f) {
                        this.PH = true;
                        oN();
                    } else {
                        oO();
                        this.PH = false;
                    }
                    if (this.PU != null) {
                        this.PU.ay(this.PH);
                        return true;
                    }
                    return true;
                }
                if (this.mContentView.getScrollX() <= (-this.PE) / 2) {
                    this.PH = true;
                    oN();
                } else {
                    oO();
                    this.PH = false;
                }
                if (this.PU != null) {
                    this.PU.ay(this.PH);
                    break;
                }
                break;
            case 2:
                if (!this.PG) {
                    o(motionEvent);
                }
                if (this.PG) {
                    int pointerIndex = getPointerIndex(motionEvent, this.mActivePointerId);
                    if (!a(motionEvent, pointerIndex, this.mActivePointerId)) {
                        float x = MotionEventCompat.getX(motionEvent, pointerIndex);
                        this.mLastMotionX = x;
                        float scrollX = (this.mLastMotionX - x) + getScrollX();
                        float f = -this.PE;
                        if (scrollX >= f) {
                            f = scrollX > 0.0f ? 0.0f : scrollX;
                        }
                        this.mLastMotionX += f - ((int) f);
                        this.PF = (int) f;
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
            if (f > 0.0f && abs > this.PP && abs > abs2) {
                this.PG = true;
                if (this.PU != null) {
                    this.PU.oQ();
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
        this.PG = false;
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
            this.PE = getWidth();
        }
    }

    private int getPointerIndex(MotionEvent motionEvent, int i) {
        int findPointerIndex = MotionEventCompat.findPointerIndex(motionEvent, i);
        if (findPointerIndex == -1) {
            this.mActivePointerId = -1;
        }
        return findPointerIndex;
    }

    private void oN() {
        this.PJ = true;
        this.mScroller.startScroll(this.mContentView.getScrollX(), 0, (-(this.PE + this.mContentView.getScrollX())) + 1, 0);
        postInvalidate();
    }

    private void oO() {
        this.PJ = true;
        this.mScroller.startScroll(this.mContentView.getScrollX(), 0, -this.mContentView.getScrollX(), 0);
        postInvalidate();
    }

    private void oP() {
        if (this.PJ) {
            this.mScroller.abortAnimation();
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            int currX = this.mScroller.getCurrX();
            int currY = this.mScroller.getCurrY();
            if (scrollX != currX || scrollY != currY) {
                this.mContentView.scrollTo(currX, currY);
            }
        }
        this.PJ = false;
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
        if (this.mScroller.isFinished() && this.PH) {
            this.mActivity.finish();
            this.mActivity.overridePendingTransition(0, 0);
        }
        if (this.mScroller.isFinished()) {
            oP();
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
        this.PR = true;
        this.PI = false;
    }

    public boolean isSwipeBackEnabled() {
        return this.PI;
    }

    public void setSwipeBackEnabled(boolean z) {
        this.PI = z;
    }

    public void setBgTransparent() {
        if (this.PD != null) {
            this.PD.setBackgroundResource(R.color.transparent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a implements Interpolator {
        private final float PV;

        public a(float f) {
            this.PV = f;
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            float f2 = this.PV * f;
            if (f2 > 0.9d) {
                return 1.0f;
            }
            return f2;
        }
    }

    public void setOnSlidingStateChangeListener(b bVar) {
        this.PU = bVar;
    }
}
