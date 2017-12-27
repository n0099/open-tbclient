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
    private ViewGroup avR;
    private int avS;
    private boolean avT;
    private boolean avU;
    private boolean avV;
    private boolean avW;
    private boolean avX;
    private int avY;
    private int avZ;
    private Rect awa;
    private int awb;
    private float awc;
    private boolean awd;
    private b awe;
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
        void aD(boolean z);

        void sJ();
    }

    /* loaded from: classes.dex */
    public interface c {
        void sK();

        void sL();
    }

    public d(Context context) {
        super(context);
        this.mActivePointerId = -1;
        this.avT = false;
        this.avU = false;
        this.avV = true;
        this.avW = false;
        this.avX = false;
        this.avZ = 0;
        this.awa = new Rect();
        this.awd = true;
        init(context);
    }

    private void init(Context context) {
        this.avY = (int) TypedValue.applyDimension(1, 24.0f, getResources().getDisplayMetrics());
        this.mScroller = new Scroller(context, new a(1.5f));
        this.mTouchSlop = ViewConfiguration.get(context.getApplicationContext()).getScaledTouchSlop() * 2;
        this.mMaximumVelocity = ViewConfiguration.getMaximumFlingVelocity();
        this.mMinimumVelocity = ViewConfiguration.getMinimumFlingVelocity();
        this.awb = (int) (context.getResources().getDisplayMetrics().density * 24.0f);
        this.mFlingDistance = l.ao(context) / 4;
    }

    public void p(Activity activity) {
        try {
            this.mActivity = activity;
            Window window = activity.getWindow();
            window.setBackgroundDrawable(new ColorDrawable(0));
            ViewGroup viewGroup = (ViewGroup) window.getDecorView();
            this.avR = (ViewGroup) viewGroup.getChildAt(0);
            viewGroup.removeView(this.avR);
            this.avR.setClickable(true);
            addView(this.avR);
            this.mContentView = (View) this.avR.getParent();
            viewGroup.addView(this);
        } catch (Exception e) {
            this.avV = false;
            BdLog.e(e);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.avV) {
            if (this.awd && i == 1) {
                this.avR.setBackgroundResource(R.color.swipe_layout_night_bg);
            } else {
                this.avR.setBackgroundResource(R.color.swipe_layout_normal_bg);
            }
        }
    }

    public void dK(int i) {
        if (this.awd && i == 1) {
            this.avR.setBackgroundResource(R.color.swipe_layout_night_bg);
        } else {
            this.avR.setBackgroundResource(R.color.swipe_layout_normal_bg);
        }
    }

    public void setIsSupportNight(boolean z) {
        if (!z) {
            this.avR.setBackgroundResource(R.color.swipe_layout_normal_bg);
        }
        this.awd = z;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.mContentView != null) {
            int i = this.avS;
            int bottom = this.mContentView.getBottom();
            this.awa.top = 0;
            this.awa.bottom = bottom;
            this.awa.left = 0;
            this.awa.right = i;
            canvas.clipRect(this.awa);
            if (this.mViewWidth != 0) {
                this.avZ = 100 - ((int) (((-this.avS) / this.mViewWidth) * 120.0f));
            }
            if (this.avZ > 100) {
                this.avZ = 100;
            }
            if (this.avU) {
                this.avZ = 0;
            }
            if (this.avZ < 0) {
                this.avZ = 0;
            }
            canvas.drawARGB(this.avZ, 0, 0, 0);
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (!this.avV) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (this.avU || this.avW) {
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
                q(motionEvent);
                break;
        }
        return this.avT;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.avU || this.avW) {
            return super.onTouchEvent(motionEvent);
        }
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        this.mVelocityTracker.addMovement(motionEvent);
        switch (motionEvent.getAction() & 255) {
            case 0:
                sH();
                int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
                this.mActivePointerId = MotionEventCompat.getPointerId(motionEvent, actionIndex);
                this.mLastMotionX = motionEvent.getX();
                this.mDownX = MotionEventCompat.getX(motionEvent, actionIndex);
                break;
            case 1:
                VelocityTracker velocityTracker = this.mVelocityTracker;
                velocityTracker.computeCurrentVelocity(1000, this.mMaximumVelocity);
                this.awc = velocityTracker.getXVelocity();
                int r = r(motionEvent);
                endDrag();
                if (Math.abs(this.awc) > this.mMinimumVelocity && r > this.mFlingDistance) {
                    if (this.awc > 0.0f) {
                        this.avU = true;
                        sF();
                    } else {
                        sG();
                        this.avU = false;
                    }
                    if (this.awe != null) {
                        this.awe.aD(this.avU);
                        return true;
                    }
                    return true;
                }
                if (this.mContentView.getScrollX() <= (-this.mViewWidth) / 2) {
                    this.avU = true;
                    sF();
                } else {
                    sG();
                    this.avU = false;
                }
                if (this.awe != null) {
                    this.awe.aD(this.avU);
                    break;
                }
                break;
            case 2:
                if (!this.avT) {
                    q(motionEvent);
                }
                if (this.avT) {
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
                        this.avS = (int) f;
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

    private void q(MotionEvent motionEvent) {
        int i = this.mActivePointerId;
        int pointerIndex = getPointerIndex(motionEvent, i);
        if (!b(motionEvent, pointerIndex, i)) {
            float x = MotionEventCompat.getX(motionEvent, pointerIndex);
            float f = x - this.mLastMotionX;
            float abs = Math.abs(f);
            float y = MotionEventCompat.getY(motionEvent, pointerIndex);
            float abs2 = Math.abs(y - this.mLastMotionY);
            if (f > 0.0f && abs > this.awb && abs > abs2) {
                this.avT = true;
                if (this.awe != null) {
                    this.awe.sJ();
                }
                this.mLastMotionX = x;
                this.mLastMotionY = y;
            }
        }
    }

    private int r(MotionEvent motionEvent) {
        int i = this.mActivePointerId;
        int pointerIndex = getPointerIndex(motionEvent, i);
        if (b(motionEvent, pointerIndex, i)) {
            return 0;
        }
        return (int) Math.abs(MotionEventCompat.getX(motionEvent, pointerIndex) - this.mDownX);
    }

    private void endDrag() {
        this.avT = false;
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

    private void sF() {
        this.avW = true;
        this.mScroller.startScroll(this.mContentView.getScrollX(), 0, (-(this.mViewWidth + this.mContentView.getScrollX())) + 1, 0);
        postInvalidate();
    }

    private void sG() {
        this.avW = true;
        this.mScroller.startScroll(this.mContentView.getScrollX(), 0, -this.mContentView.getScrollX(), 0);
        postInvalidate();
    }

    private void sH() {
        if (this.avW) {
            this.mScroller.abortAnimation();
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            int currX = this.mScroller.getCurrX();
            int currY = this.mScroller.getCurrY();
            if (scrollX != currX || scrollY != currY) {
                this.mContentView.scrollTo(currX, currY);
            }
        }
        this.avW = false;
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
        if (this.mScroller.isFinished() && this.avU) {
            this.mActivity.finish();
            this.mActivity.overridePendingTransition(0, 0);
        }
        if (this.mScroller.isFinished()) {
            sH();
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
        return this.avV;
    }

    public void setSwipeBackEnabled(boolean z) {
        this.avV = z;
    }

    public void sI() {
        if (this.avR != null) {
            this.avR.setBackgroundResource(R.color.transparent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a implements Interpolator {
        private final float awf;

        public a(float f) {
            this.awf = f;
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            float f2 = this.awf * f;
            if (f2 > 0.9d) {
                return 1.0f;
            }
            return f2;
        }
    }

    public void setOnSlidingStateChangeListener(b bVar) {
        this.awe = bVar;
    }
}
