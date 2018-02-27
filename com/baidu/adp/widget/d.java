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
import com.baidu.adp.lib.util.l;
/* loaded from: classes.dex */
public class d extends FrameLayout {
    private ViewGroup avF;
    private int avG;
    private boolean avH;
    private boolean avI;
    private boolean avJ;
    private boolean avK;
    private boolean avL;
    private int avM;
    private int avN;
    private Rect avO;
    private int avP;
    private float avQ;
    private boolean avR;
    private b avS;
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
        void aH(boolean z);

        void sI();
    }

    /* loaded from: classes.dex */
    public interface c {
        void sJ();

        void sK();
    }

    public d(Context context) {
        super(context);
        this.mActivePointerId = -1;
        this.avH = false;
        this.avI = false;
        this.avJ = true;
        this.avK = false;
        this.avL = false;
        this.avN = 0;
        this.avO = new Rect();
        this.avR = true;
        init(context);
    }

    private void init(Context context) {
        this.avM = (int) TypedValue.applyDimension(1, 24.0f, getResources().getDisplayMetrics());
        this.mScroller = new Scroller(context, new a(1.5f));
        this.mTouchSlop = ViewConfiguration.get(context.getApplicationContext()).getScaledTouchSlop() * 2;
        this.mMaximumVelocity = ViewConfiguration.getMaximumFlingVelocity();
        this.mMinimumVelocity = ViewConfiguration.getMinimumFlingVelocity();
        this.avP = (int) (context.getResources().getDisplayMetrics().density * 24.0f);
        this.mFlingDistance = l.ao(context) / 4;
    }

    public void r(Activity activity) {
        try {
            this.mActivity = activity;
            Window window = activity.getWindow();
            window.setBackgroundDrawable(new ColorDrawable(0));
            ViewGroup viewGroup = (ViewGroup) window.getDecorView();
            this.avF = (ViewGroup) viewGroup.getChildAt(0);
            viewGroup.removeView(this.avF);
            this.avF.setClickable(true);
            addView(this.avF);
            this.mContentView = (View) this.avF.getParent();
            viewGroup.addView(this);
        } catch (Exception e) {
            this.avJ = false;
            BdLog.e(e);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.avJ) {
            if (this.avR && i == 1) {
                this.avF.setBackgroundResource(R.color.swipe_layout_night_bg);
            } else {
                this.avF.setBackgroundResource(R.color.swipe_layout_normal_bg);
            }
        }
    }

    public void dK(int i) {
        if (this.avR && i == 1) {
            this.avF.setBackgroundResource(R.color.swipe_layout_night_bg);
        } else {
            this.avF.setBackgroundResource(R.color.swipe_layout_normal_bg);
        }
    }

    public void setIsSupportNight(boolean z) {
        if (!z) {
            this.avF.setBackgroundResource(R.color.swipe_layout_normal_bg);
        }
        this.avR = z;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.mContentView != null) {
            int i = this.avG;
            int bottom = this.mContentView.getBottom();
            this.avO.top = 0;
            this.avO.bottom = bottom;
            this.avO.left = 0;
            this.avO.right = i;
            canvas.clipRect(this.avO);
            if (this.mViewWidth != 0) {
                this.avN = 100 - ((int) (((-this.avG) / this.mViewWidth) * 120.0f));
            }
            if (this.avN > 100) {
                this.avN = 100;
            }
            if (this.avI) {
                this.avN = 0;
            }
            if (this.avN < 0) {
                this.avN = 0;
            }
            canvas.drawARGB(this.avN, 0, 0, 0);
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (!this.avJ) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (this.avI || this.avK) {
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
                if (!b(motionEvent, actionIndex, this.mActivePointerId)) {
                    this.mLastMotionX = MotionEventCompat.getX(motionEvent, actionIndex);
                    this.mLastMotionY = MotionEventCompat.getY(motionEvent, actionIndex);
                    this.mDownX = MotionEventCompat.getX(motionEvent, actionIndex);
                    break;
                }
                break;
            case 2:
                u(motionEvent);
                break;
        }
        return this.avH;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.avI || this.avK) {
            return super.onTouchEvent(motionEvent);
        }
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        this.mVelocityTracker.addMovement(motionEvent);
        switch (motionEvent.getAction() & 255) {
            case 0:
                sG();
                int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
                this.mActivePointerId = MotionEventCompat.getPointerId(motionEvent, actionIndex);
                this.mLastMotionX = motionEvent.getX();
                this.mDownX = MotionEventCompat.getX(motionEvent, actionIndex);
                break;
            case 1:
                VelocityTracker velocityTracker = this.mVelocityTracker;
                velocityTracker.computeCurrentVelocity(1000, this.mMaximumVelocity);
                this.avQ = velocityTracker.getXVelocity();
                int v = v(motionEvent);
                endDrag();
                if (Math.abs(this.avQ) > this.mMinimumVelocity && v > this.mFlingDistance) {
                    if (this.avQ > 0.0f) {
                        this.avI = true;
                        sE();
                    } else {
                        sF();
                        this.avI = false;
                    }
                    if (this.avS != null) {
                        this.avS.aH(this.avI);
                        return true;
                    }
                    return true;
                }
                if (this.mContentView.getScrollX() <= (-this.mViewWidth) / 2) {
                    this.avI = true;
                    sE();
                } else {
                    sF();
                    this.avI = false;
                }
                if (this.avS != null) {
                    this.avS.aH(this.avI);
                    break;
                }
                break;
            case 2:
                if (!this.avH) {
                    u(motionEvent);
                }
                if (this.avH) {
                    int pointerIndex = getPointerIndex(motionEvent, this.mActivePointerId);
                    if (!b(motionEvent, pointerIndex, this.mActivePointerId)) {
                        float x = MotionEventCompat.getX(motionEvent, pointerIndex);
                        this.mLastMotionX = x;
                        float scrollX = (this.mLastMotionX - x) + getScrollX();
                        float f = -this.mViewWidth;
                        if (scrollX >= f) {
                            f = scrollX > 0.0f ? 0.0f : scrollX;
                        }
                        this.mLastMotionX += f - ((int) f);
                        this.avG = (int) f;
                        this.mContentView.scrollTo((int) f, getScrollY());
                        break;
                    }
                }
                break;
            case 3:
                iJ();
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    private void u(MotionEvent motionEvent) {
        int i = this.mActivePointerId;
        int pointerIndex = getPointerIndex(motionEvent, i);
        if (!b(motionEvent, pointerIndex, i)) {
            float x = MotionEventCompat.getX(motionEvent, pointerIndex);
            float f = x - this.mLastMotionX;
            float abs = Math.abs(f);
            float y = MotionEventCompat.getY(motionEvent, pointerIndex);
            float abs2 = Math.abs(y - this.mLastMotionY);
            if (f > 0.0f && abs > this.avP && abs > abs2) {
                this.avH = true;
                if (this.avS != null) {
                    this.avS.sI();
                }
                this.mLastMotionX = x;
                this.mLastMotionY = y;
            }
        }
    }

    private int v(MotionEvent motionEvent) {
        int i = this.mActivePointerId;
        int pointerIndex = getPointerIndex(motionEvent, i);
        if (b(motionEvent, pointerIndex, i)) {
            return 0;
        }
        return (int) Math.abs(MotionEventCompat.getX(motionEvent, pointerIndex) - this.mDownX);
    }

    private void endDrag() {
        this.avH = false;
        this.mActivePointerId = -1;
        iJ();
    }

    private boolean b(MotionEvent motionEvent, int i, int i2) {
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

    private void sE() {
        this.avK = true;
        this.mScroller.startScroll(this.mContentView.getScrollX(), 0, (-(this.mViewWidth + this.mContentView.getScrollX())) + 1, 0);
        postInvalidate();
    }

    private void sF() {
        this.avK = true;
        this.mScroller.startScroll(this.mContentView.getScrollX(), 0, -this.mContentView.getScrollX(), 0);
        postInvalidate();
    }

    private void sG() {
        if (this.avK) {
            this.mScroller.abortAnimation();
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            int currX = this.mScroller.getCurrX();
            int currY = this.mScroller.getCurrY();
            if (scrollX != currX || scrollY != currY) {
                this.mContentView.scrollTo(currX, currY);
            }
        }
        this.avK = false;
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
        if (this.mScroller.isFinished() && this.avI) {
            this.mActivity.finish();
            this.mActivity.overridePendingTransition(0, 0);
        }
        if (this.mScroller.isFinished()) {
            sG();
        }
    }

    private void iJ() {
        if (this.mVelocityTracker != null) {
            this.mVelocityTracker.clear();
            this.mVelocityTracker.recycle();
            this.mVelocityTracker = null;
        }
    }

    public boolean isSwipeBackEnabled() {
        return this.avJ;
    }

    public void setSwipeBackEnabled(boolean z) {
        this.avJ = z;
    }

    public void sH() {
        if (this.avF != null) {
            this.avF.setBackgroundResource(R.color.transparent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a implements Interpolator {
        private final float avT;

        public a(float f) {
            this.avT = f;
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            float f2 = this.avT * f;
            if (f2 > 0.9d) {
                return 1.0f;
            }
            return f2;
        }
    }

    public void setOnSlidingStateChangeListener(b bVar) {
        this.avS = bVar;
    }
}
