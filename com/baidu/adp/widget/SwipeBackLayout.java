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
    private ViewGroup MI;
    private int MJ;
    private int MK;
    private boolean MM;
    private boolean MN;
    private boolean MO;
    private boolean MP;
    private boolean MQ;
    private int MR;
    private int MS;
    private Rect MT;
    private int MU;
    private float MV;
    private boolean MW;
    private boolean MX;
    private b MY;
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
        void ab(boolean z);

        void nH();
    }

    /* loaded from: classes.dex */
    public interface c {
        void nI();

        void nJ();
    }

    public SwipeBackLayout(Context context) {
        super(context);
        this.mActivePointerId = -1;
        this.MM = false;
        this.MN = false;
        this.MO = true;
        this.MP = false;
        this.MQ = false;
        this.MS = 0;
        this.MT = new Rect();
        this.MW = false;
        this.MX = true;
        init(context);
    }

    public SwipeBackLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mActivePointerId = -1;
        this.MM = false;
        this.MN = false;
        this.MO = true;
        this.MP = false;
        this.MQ = false;
        this.MS = 0;
        this.MT = new Rect();
        this.MW = false;
        this.MX = true;
        init(context);
    }

    public SwipeBackLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mActivePointerId = -1;
        this.MM = false;
        this.MN = false;
        this.MO = true;
        this.MP = false;
        this.MQ = false;
        this.MS = 0;
        this.MT = new Rect();
        this.MW = false;
        this.MX = true;
        init(context);
    }

    private void init(Context context) {
        this.MR = (int) TypedValue.applyDimension(1, 24.0f, getResources().getDisplayMetrics());
        this.mScroller = new Scroller(context, new a(1.5f));
        this.mTouchSlop = ViewConfiguration.get(context.getApplicationContext()).getScaledTouchSlop() * 2;
        this.mMaximumVelocity = ViewConfiguration.getMaximumFlingVelocity();
        this.mMinimumVelocity = ViewConfiguration.getMinimumFlingVelocity();
        this.MU = (int) (context.getResources().getDisplayMetrics().density * 24.0f);
        this.mFlingDistance = l.ah(context) / 4;
    }

    public void q(Activity activity) {
        try {
            this.mActivity = activity;
            Window window = activity.getWindow();
            window.setBackgroundDrawable(new ColorDrawable(0));
            ViewGroup viewGroup = (ViewGroup) window.getDecorView();
            this.MI = (ViewGroup) viewGroup.getChildAt(0);
            viewGroup.removeView(this.MI);
            this.MI.setClickable(true);
            addView(this.MI);
            this.mContentView = (View) this.MI.getParent();
            viewGroup.addView(this);
        } catch (Exception e) {
            this.MO = false;
            BdLog.e(e);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.MO) {
            if (this.MX && i == 1) {
                this.MI.setBackgroundResource(R.color.swipe_layout_night_bg);
            } else {
                this.MI.setBackgroundResource(R.color.swipe_layout_normal_bg);
            }
        }
    }

    public void aP(int i) {
        if (this.MX && i == 1) {
            this.MI.setBackgroundResource(R.color.swipe_layout_night_bg);
        } else {
            this.MI.setBackgroundResource(R.color.swipe_layout_normal_bg);
        }
    }

    public void setIsSupportNight(boolean z) {
        if (!z) {
            this.MI.setBackgroundResource(R.color.swipe_layout_normal_bg);
        }
        this.MX = z;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.mContentView != null) {
            int i = this.MK;
            int bottom = this.mContentView.getBottom();
            this.MT.top = 0;
            this.MT.bottom = bottom;
            this.MT.left = 0;
            this.MT.right = i;
            canvas.clipRect(this.MT);
            if (this.MJ != 0) {
                this.MS = 100 - ((int) (((-this.MK) / this.MJ) * 120.0f));
            }
            if (this.MS > 100) {
                this.MS = 100;
            }
            if (this.MN) {
                this.MS = 0;
            }
            if (this.MS < 0) {
                this.MS = 0;
            }
            canvas.drawARGB(this.MS, 0, 0, 0);
        }
    }

    private boolean n(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if ((action == 1 || action == 3) && this.MW) {
            this.MW = false;
            this.MO = true;
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
        if (!this.MO) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (this.MN || this.MP) {
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
        return this.MM;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.MN || this.MP) {
            return super.onTouchEvent(motionEvent);
        }
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        this.mVelocityTracker.addMovement(motionEvent);
        switch (motionEvent.getAction() & 255) {
            case 0:
                nG();
                int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
                this.mActivePointerId = MotionEventCompat.getPointerId(motionEvent, actionIndex);
                this.mLastMotionX = motionEvent.getX();
                this.mDownX = MotionEventCompat.getX(motionEvent, actionIndex);
                break;
            case 1:
                VelocityTracker velocityTracker = this.mVelocityTracker;
                velocityTracker.computeCurrentVelocity(1000, this.mMaximumVelocity);
                this.MV = velocityTracker.getXVelocity();
                int p = p(motionEvent);
                endDrag();
                if (Math.abs(this.MV) > this.mMinimumVelocity && p > this.mFlingDistance) {
                    if (this.MV > 0.0f) {
                        this.MN = true;
                        nE();
                    } else {
                        nF();
                        this.MN = false;
                    }
                    if (this.MY != null) {
                        this.MY.ab(this.MN);
                        return true;
                    }
                    return true;
                }
                if (this.mContentView.getScrollX() <= (-this.MJ) / 2) {
                    this.MN = true;
                    nE();
                } else {
                    nF();
                    this.MN = false;
                }
                if (this.MY != null) {
                    this.MY.ab(this.MN);
                    break;
                }
                break;
            case 2:
                if (!this.MM) {
                    o(motionEvent);
                }
                if (this.MM) {
                    int pointerIndex = getPointerIndex(motionEvent, this.mActivePointerId);
                    if (!a(motionEvent, pointerIndex, this.mActivePointerId)) {
                        float x = MotionEventCompat.getX(motionEvent, pointerIndex);
                        this.mLastMotionX = x;
                        float scrollX = (this.mLastMotionX - x) + getScrollX();
                        float f = -this.MJ;
                        if (scrollX >= f) {
                            f = scrollX > 0.0f ? 0.0f : scrollX;
                        }
                        this.mLastMotionX += f - ((int) f);
                        this.MK = (int) f;
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
            if (f > 0.0f && abs > this.MU && abs > abs2) {
                this.MM = true;
                if (this.MY != null) {
                    this.MY.nH();
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
        this.MM = false;
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
            this.MJ = getWidth();
        }
    }

    private int getPointerIndex(MotionEvent motionEvent, int i) {
        int findPointerIndex = MotionEventCompat.findPointerIndex(motionEvent, i);
        if (findPointerIndex == -1) {
            this.mActivePointerId = -1;
        }
        return findPointerIndex;
    }

    private void nE() {
        this.MP = true;
        this.mScroller.startScroll(this.mContentView.getScrollX(), 0, (-(this.MJ + this.mContentView.getScrollX())) + 1, 0);
        postInvalidate();
    }

    private void nF() {
        this.MP = true;
        this.mScroller.startScroll(this.mContentView.getScrollX(), 0, -this.mContentView.getScrollX(), 0);
        postInvalidate();
    }

    private void nG() {
        if (this.MP) {
            this.mScroller.abortAnimation();
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            int currX = this.mScroller.getCurrX();
            int currY = this.mScroller.getCurrY();
            if (scrollX != currX || scrollY != currY) {
                this.mContentView.scrollTo(currX, currY);
            }
        }
        this.MP = false;
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
        if (this.mScroller.isFinished() && this.MN) {
            this.mActivity.finish();
            this.mActivity.overridePendingTransition(0, 0);
        }
        if (this.mScroller.isFinished()) {
            nG();
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
        this.MW = true;
        this.MO = false;
    }

    public boolean isSwipeBackEnabled() {
        return this.MO;
    }

    public void setSwipeBackEnabled(boolean z) {
        this.MO = z;
    }

    public void setBgTransparent() {
        if (this.MI != null) {
            this.MI.setBackgroundResource(R.color.transparent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a implements Interpolator {
        private final float MZ;

        public a(float f) {
            this.MZ = f;
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            float f2 = this.MZ * f;
            if (f2 > 0.9d) {
                return 1.0f;
            }
            return f2;
        }
    }

    public void setOnSlidingStateChangeListener(b bVar) {
        this.MY = bVar;
    }
}
