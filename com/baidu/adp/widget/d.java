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
    private ViewGroup avO;
    private int avP;
    private boolean avQ;
    private boolean avR;
    private boolean avS;
    private boolean avT;
    private boolean avU;
    private int avV;
    private int avW;
    private Rect avX;
    private int avY;
    private float avZ;
    private boolean awa;
    private b awb;
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
        this.avQ = false;
        this.avR = false;
        this.avS = true;
        this.avT = false;
        this.avU = false;
        this.avW = 0;
        this.avX = new Rect();
        this.awa = true;
        init(context);
    }

    private void init(Context context) {
        this.avV = (int) TypedValue.applyDimension(1, 24.0f, getResources().getDisplayMetrics());
        this.mScroller = new Scroller(context, new a(1.5f));
        this.mTouchSlop = ViewConfiguration.get(context.getApplicationContext()).getScaledTouchSlop() * 2;
        this.mMaximumVelocity = ViewConfiguration.getMaximumFlingVelocity();
        this.mMinimumVelocity = ViewConfiguration.getMinimumFlingVelocity();
        this.avY = (int) (context.getResources().getDisplayMetrics().density * 24.0f);
        this.mFlingDistance = l.ao(context) / 4;
    }

    public void r(Activity activity) {
        try {
            this.mActivity = activity;
            Window window = activity.getWindow();
            window.setBackgroundDrawable(new ColorDrawable(0));
            ViewGroup viewGroup = (ViewGroup) window.getDecorView();
            this.avO = (ViewGroup) viewGroup.getChildAt(0);
            viewGroup.removeView(this.avO);
            this.avO.setClickable(true);
            addView(this.avO);
            this.mContentView = (View) this.avO.getParent();
            viewGroup.addView(this);
        } catch (Exception e) {
            this.avS = false;
            BdLog.e(e);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.avS) {
            if (this.awa && i == 1) {
                this.avO.setBackgroundResource(R.color.swipe_layout_night_bg);
            } else {
                this.avO.setBackgroundResource(R.color.swipe_layout_normal_bg);
            }
        }
    }

    public void dK(int i) {
        if (this.awa && i == 1) {
            this.avO.setBackgroundResource(R.color.swipe_layout_night_bg);
        } else {
            this.avO.setBackgroundResource(R.color.swipe_layout_normal_bg);
        }
    }

    public void setIsSupportNight(boolean z) {
        if (!z) {
            this.avO.setBackgroundResource(R.color.swipe_layout_normal_bg);
        }
        this.awa = z;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.mContentView != null) {
            int i = this.avP;
            int bottom = this.mContentView.getBottom();
            this.avX.top = 0;
            this.avX.bottom = bottom;
            this.avX.left = 0;
            this.avX.right = i;
            canvas.clipRect(this.avX);
            if (this.mViewWidth != 0) {
                this.avW = 100 - ((int) (((-this.avP) / this.mViewWidth) * 120.0f));
            }
            if (this.avW > 100) {
                this.avW = 100;
            }
            if (this.avR) {
                this.avW = 0;
            }
            if (this.avW < 0) {
                this.avW = 0;
            }
            canvas.drawARGB(this.avW, 0, 0, 0);
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (!this.avS) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (this.avR || this.avT) {
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
        return this.avQ;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.avR || this.avT) {
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
                this.avZ = velocityTracker.getXVelocity();
                int v = v(motionEvent);
                endDrag();
                if (Math.abs(this.avZ) > this.mMinimumVelocity && v > this.mFlingDistance) {
                    if (this.avZ > 0.0f) {
                        this.avR = true;
                        sE();
                    } else {
                        sF();
                        this.avR = false;
                    }
                    if (this.awb != null) {
                        this.awb.aH(this.avR);
                        return true;
                    }
                    return true;
                }
                if (this.mContentView.getScrollX() <= (-this.mViewWidth) / 2) {
                    this.avR = true;
                    sE();
                } else {
                    sF();
                    this.avR = false;
                }
                if (this.awb != null) {
                    this.awb.aH(this.avR);
                    break;
                }
                break;
            case 2:
                if (!this.avQ) {
                    u(motionEvent);
                }
                if (this.avQ) {
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
                        this.avP = (int) f;
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
            if (f > 0.0f && abs > this.avY && abs > abs2) {
                this.avQ = true;
                if (this.awb != null) {
                    this.awb.sI();
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
        this.avQ = false;
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
        this.avT = true;
        this.mScroller.startScroll(this.mContentView.getScrollX(), 0, (-(this.mViewWidth + this.mContentView.getScrollX())) + 1, 0);
        postInvalidate();
    }

    private void sF() {
        this.avT = true;
        this.mScroller.startScroll(this.mContentView.getScrollX(), 0, -this.mContentView.getScrollX(), 0);
        postInvalidate();
    }

    private void sG() {
        if (this.avT) {
            this.mScroller.abortAnimation();
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            int currX = this.mScroller.getCurrX();
            int currY = this.mScroller.getCurrY();
            if (scrollX != currX || scrollY != currY) {
                this.mContentView.scrollTo(currX, currY);
            }
        }
        this.avT = false;
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
        if (this.mScroller.isFinished() && this.avR) {
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
        return this.avS;
    }

    public void setSwipeBackEnabled(boolean z) {
        this.avS = z;
    }

    public void sH() {
        if (this.avO != null) {
            this.avO.setBackgroundResource(R.color.transparent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a implements Interpolator {
        private final float awc;

        public a(float f) {
            this.awc = f;
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            float f2 = this.awc * f;
            if (f2 > 0.9d) {
                return 1.0f;
            }
            return f2;
        }
    }

    public void setOnSlidingStateChangeListener(b bVar) {
        this.awb = bVar;
    }
}
