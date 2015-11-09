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
    private float ET;
    private ViewGroup Jf;
    private int Jg;
    private boolean Jh;
    private boolean Ji;
    private boolean Jj;
    private boolean Jk;
    private boolean Jl;
    private int Jm;
    private Rect Jn;
    private int Jo;
    private float Jp;
    private boolean Jq;
    private int mActivePointerId;
    private Activity mActivity;
    private View mContentView;
    private int mFlingDistance;
    private float mLastMotionX;
    private float mLastMotionY;
    private int mMarginThreshold;
    private int mMaximumVelocity;
    private int mMinimumVelocity;
    private Scroller mScroller;
    private int mTouchSlop;
    private VelocityTracker mVelocityTracker;
    private int mViewWidth;

    /* loaded from: classes.dex */
    public interface b {
        void oc();

        void od();
    }

    public f(Context context) {
        super(context);
        this.mActivePointerId = -1;
        this.Jh = false;
        this.Ji = false;
        this.Jj = true;
        this.Jk = false;
        this.Jl = false;
        this.Jm = 0;
        this.Jn = new Rect();
        this.Jq = true;
        init(context);
    }

    private void init(Context context) {
        this.mMarginThreshold = (int) TypedValue.applyDimension(1, 24.0f, getResources().getDisplayMetrics());
        this.mScroller = new Scroller(context, new a(1.5f));
        this.mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop() * 2;
        this.mMaximumVelocity = ViewConfiguration.getMaximumFlingVelocity();
        this.mMinimumVelocity = ViewConfiguration.getMinimumFlingVelocity();
        this.Jo = (int) (context.getResources().getDisplayMetrics().density * 24.0f);
        this.mFlingDistance = k.K(context) / 4;
    }

    public void n(Activity activity) {
        try {
            this.mActivity = activity;
            Window window = activity.getWindow();
            window.setBackgroundDrawable(new ColorDrawable(0));
            ViewGroup viewGroup = (ViewGroup) window.getDecorView();
            this.Jf = (ViewGroup) viewGroup.getChildAt(0);
            viewGroup.removeView(this.Jf);
            this.Jf.setClickable(true);
            addView(this.Jf);
            this.mContentView = (View) this.Jf.getParent();
            viewGroup.addView(this);
        } catch (Exception e) {
            this.Jj = false;
            BdLog.e(e);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.Jj) {
            if (this.Jq && i == 1) {
                this.Jf.setBackgroundResource(R.color.swipe_layout_night_bg);
            } else {
                this.Jf.setBackgroundResource(R.color.swipe_layout_normal_bg);
            }
        }
    }

    public void aD(int i) {
        if (this.Jq && i == 1) {
            this.Jf.setBackgroundResource(R.color.swipe_layout_night_bg);
        } else {
            this.Jf.setBackgroundResource(R.color.swipe_layout_normal_bg);
        }
    }

    public void setIsSupportNight(boolean z) {
        if (!z) {
            this.Jf.setBackgroundResource(R.color.swipe_layout_normal_bg);
        }
        this.Jq = z;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.mContentView != null) {
            int i = this.Jg;
            int bottom = this.mContentView.getBottom();
            this.Jn.top = 0;
            this.Jn.bottom = bottom;
            this.Jn.left = 0;
            this.Jn.right = i;
            canvas.clipRect(this.Jn);
            if (this.mViewWidth != 0) {
                this.Jm = 100 - ((int) (((-this.Jg) / this.mViewWidth) * 120.0f));
            }
            if (this.Jm > 100) {
                this.Jm = 100;
            }
            if (this.Ji) {
                this.Jm = 0;
            }
            if (this.Jm < 0) {
                this.Jm = 0;
            }
            canvas.drawARGB(this.Jm, 0, 0, 0);
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (!this.Jj) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (this.Ji || this.Jk) {
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
                    this.ET = MotionEventCompat.getX(motionEvent, actionIndex);
                    break;
                }
                break;
            case 2:
                determineDrag(motionEvent);
                break;
        }
        return this.Jh;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.Ji || this.Jk) {
            return super.onTouchEvent(motionEvent);
        }
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        this.mVelocityTracker.addMovement(motionEvent);
        switch (motionEvent.getAction() & MotionEventCompat.ACTION_MASK) {
            case 0:
                completeScroll();
                int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
                this.mActivePointerId = MotionEventCompat.getPointerId(motionEvent, actionIndex);
                this.mLastMotionX = motionEvent.getX();
                this.ET = MotionEventCompat.getX(motionEvent, actionIndex);
                break;
            case 1:
                VelocityTracker velocityTracker = this.mVelocityTracker;
                velocityTracker.computeCurrentVelocity(1000, this.mMaximumVelocity);
                this.Jp = velocityTracker.getXVelocity();
                int f = f(motionEvent);
                endDrag();
                if (Math.abs(this.Jp) > this.mMinimumVelocity && f > this.mFlingDistance) {
                    if (this.Jp > 0.0f) {
                        this.Ji = true;
                        nY();
                        return true;
                    }
                    nZ();
                    this.Ji = false;
                    return true;
                } else if (this.mContentView.getScrollX() <= (-this.mViewWidth) / 2) {
                    this.Ji = true;
                    nY();
                    break;
                } else {
                    nZ();
                    this.Ji = false;
                    break;
                }
                break;
            case 2:
                if (!this.Jh) {
                    determineDrag(motionEvent);
                }
                if (this.Jh) {
                    int pointerIndex = getPointerIndex(motionEvent, this.mActivePointerId);
                    if (!a(motionEvent, pointerIndex, this.mActivePointerId)) {
                        float x = MotionEventCompat.getX(motionEvent, pointerIndex);
                        this.mLastMotionX = x;
                        float scrollX = (this.mLastMotionX - x) + getScrollX();
                        float f2 = -this.mViewWidth;
                        if (scrollX >= f2) {
                            f2 = scrollX > 0.0f ? 0.0f : scrollX;
                        }
                        this.mLastMotionX += f2 - ((int) f2);
                        this.Jg = (int) f2;
                        this.mContentView.scrollTo((int) f2, getScrollY());
                        break;
                    }
                }
                break;
            case 3:
                oa();
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    private void determineDrag(MotionEvent motionEvent) {
        int i = this.mActivePointerId;
        int pointerIndex = getPointerIndex(motionEvent, i);
        if (!a(motionEvent, pointerIndex, i)) {
            float x = MotionEventCompat.getX(motionEvent, pointerIndex);
            float f = x - this.mLastMotionX;
            float abs = Math.abs(f);
            float y = MotionEventCompat.getY(motionEvent, pointerIndex);
            float abs2 = Math.abs(y - this.mLastMotionY);
            if (f > 0.0f && abs > this.Jo && abs > abs2) {
                this.Jh = true;
                this.mLastMotionX = x;
                this.mLastMotionY = y;
            }
        }
    }

    private int f(MotionEvent motionEvent) {
        int i = this.mActivePointerId;
        int pointerIndex = getPointerIndex(motionEvent, i);
        if (a(motionEvent, pointerIndex, i)) {
            return 0;
        }
        return (int) Math.abs(MotionEventCompat.getX(motionEvent, pointerIndex) - this.ET);
    }

    private void endDrag() {
        this.Jh = false;
        this.mActivePointerId = -1;
        oa();
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

    private void nY() {
        this.Jk = true;
        this.mScroller.startScroll(this.mContentView.getScrollX(), 0, (-(this.mViewWidth + this.mContentView.getScrollX())) + 1, 0);
        postInvalidate();
    }

    private void nZ() {
        this.Jk = true;
        this.mScroller.startScroll(this.mContentView.getScrollX(), 0, -this.mContentView.getScrollX(), 0);
        postInvalidate();
    }

    private void completeScroll() {
        if (this.Jk) {
            this.mScroller.abortAnimation();
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            int currX = this.mScroller.getCurrX();
            int currY = this.mScroller.getCurrY();
            if (scrollX != currX || scrollY != currY) {
                this.mContentView.scrollTo(currX, currY);
            }
        }
        this.Jk = false;
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
        if (this.mScroller.isFinished() && this.Ji) {
            this.mActivity.finish();
            this.mActivity.overridePendingTransition(0, 0);
        }
        if (this.mScroller.isFinished()) {
            completeScroll();
        }
    }

    private void oa() {
        if (this.mVelocityTracker != null) {
            this.mVelocityTracker.clear();
            this.mVelocityTracker.recycle();
            this.mVelocityTracker = null;
        }
    }

    public boolean isSwipeBackEnabled() {
        return this.Jj;
    }

    public void setSwipeBackEnabled(boolean z) {
        this.Jj = z;
    }

    public void ob() {
        if (this.Jf != null) {
            this.Jf.setBackgroundResource(R.color.transparent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a implements Interpolator {
        private final float Jr;

        public a(float f) {
            this.Jr = f;
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            float f2 = this.Jr * f;
            if (f2 > 0.9d) {
                return 1.0f;
            }
            return f2;
        }
    }
}
