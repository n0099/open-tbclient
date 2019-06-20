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
    private int OA;
    private boolean OB;
    private boolean OC;
    private boolean OD;
    private boolean OE;
    private boolean OF;
    private int OG;
    private int OH;
    private Rect OI;
    private int OJ;
    private float OL;
    private boolean OM;
    private boolean OO;
    private b OP;
    private ViewGroup Oz;
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
        void ar(boolean z);

        void oi();
    }

    /* loaded from: classes.dex */
    public interface c {
        void oj();

        void ok();
    }

    public SwipeBackLayout(Context context) {
        super(context);
        this.mActivePointerId = -1;
        this.OB = false;
        this.OC = false;
        this.OD = true;
        this.OE = false;
        this.OF = false;
        this.OH = 0;
        this.OI = new Rect();
        this.OM = false;
        this.OO = true;
        init(context);
    }

    public SwipeBackLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mActivePointerId = -1;
        this.OB = false;
        this.OC = false;
        this.OD = true;
        this.OE = false;
        this.OF = false;
        this.OH = 0;
        this.OI = new Rect();
        this.OM = false;
        this.OO = true;
        init(context);
    }

    public SwipeBackLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mActivePointerId = -1;
        this.OB = false;
        this.OC = false;
        this.OD = true;
        this.OE = false;
        this.OF = false;
        this.OH = 0;
        this.OI = new Rect();
        this.OM = false;
        this.OO = true;
        init(context);
    }

    private void init(Context context) {
        this.OG = (int) TypedValue.applyDimension(1, 24.0f, getResources().getDisplayMetrics());
        this.mScroller = new Scroller(context, new a(1.5f));
        this.mTouchSlop = ViewConfiguration.get(context.getApplicationContext()).getScaledTouchSlop() * 2;
        this.mMaximumVelocity = ViewConfiguration.getMaximumFlingVelocity();
        this.mMinimumVelocity = ViewConfiguration.getMinimumFlingVelocity();
        this.OJ = (int) (context.getResources().getDisplayMetrics().density * 24.0f);
        this.mFlingDistance = l.af(context) / 4;
    }

    public void t(Activity activity) {
        try {
            this.mActivity = activity;
            Window window = activity.getWindow();
            window.setBackgroundDrawable(new ColorDrawable(0));
            ViewGroup viewGroup = (ViewGroup) window.getDecorView();
            this.Oz = (ViewGroup) viewGroup.getChildAt(0);
            viewGroup.removeView(this.Oz);
            this.Oz.setClickable(true);
            addView(this.Oz);
            this.mContentView = (View) this.Oz.getParent();
            viewGroup.addView(this);
        } catch (Exception e) {
            this.OD = false;
            BdLog.e(e);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.OD) {
            if (this.OO && i == 1) {
                this.Oz.setBackgroundResource(R.color.swipe_layout_night_bg);
            } else {
                this.Oz.setBackgroundResource(R.color.swipe_layout_normal_bg);
            }
        }
    }

    public void aT(int i) {
        if (this.OO && i == 1) {
            this.Oz.setBackgroundResource(R.color.swipe_layout_night_bg);
        } else {
            this.Oz.setBackgroundResource(R.color.swipe_layout_normal_bg);
        }
    }

    public void setIsSupportNight(boolean z) {
        if (!z) {
            this.Oz.setBackgroundResource(R.color.swipe_layout_normal_bg);
        }
        this.OO = z;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.mContentView != null) {
            int i = this.OA;
            int bottom = this.mContentView.getBottom();
            this.OI.top = 0;
            this.OI.bottom = bottom;
            this.OI.left = 0;
            this.OI.right = i;
            canvas.clipRect(this.OI);
            if (this.mViewWidth != 0) {
                this.OH = 100 - ((int) (((-this.OA) / this.mViewWidth) * 120.0f));
            }
            if (this.OH > 100) {
                this.OH = 100;
            }
            if (this.OC) {
                this.OH = 0;
            }
            if (this.OH < 0) {
                this.OH = 0;
            }
            canvas.drawARGB(this.OH, 0, 0, 0);
        }
    }

    private boolean n(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if ((action == 1 || action == 3) && this.OM) {
            this.OM = false;
            this.OD = true;
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
        if (!this.OD) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (this.OC || this.OE) {
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
        return this.OB;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.OC || this.OE) {
            return super.onTouchEvent(motionEvent);
        }
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        this.mVelocityTracker.addMovement(motionEvent);
        switch (motionEvent.getAction() & 255) {
            case 0:
                oh();
                int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
                this.mActivePointerId = MotionEventCompat.getPointerId(motionEvent, actionIndex);
                this.mLastMotionX = motionEvent.getX();
                this.mDownX = MotionEventCompat.getX(motionEvent, actionIndex);
                break;
            case 1:
                VelocityTracker velocityTracker = this.mVelocityTracker;
                velocityTracker.computeCurrentVelocity(1000, this.mMaximumVelocity);
                this.OL = velocityTracker.getXVelocity();
                int p = p(motionEvent);
                endDrag();
                if (Math.abs(this.OL) > this.mMinimumVelocity && p > this.mFlingDistance) {
                    if (this.OL > 0.0f) {
                        this.OC = true;
                        oe();
                    } else {
                        og();
                        this.OC = false;
                    }
                    if (this.OP != null) {
                        this.OP.ar(this.OC);
                        return true;
                    }
                    return true;
                }
                if (this.mContentView.getScrollX() <= (-this.mViewWidth) / 2) {
                    this.OC = true;
                    oe();
                } else {
                    og();
                    this.OC = false;
                }
                if (this.OP != null) {
                    this.OP.ar(this.OC);
                    break;
                }
                break;
            case 2:
                if (!this.OB) {
                    o(motionEvent);
                }
                if (this.OB) {
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
                        this.OA = (int) f;
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
            if (f > 0.0f && abs > this.OJ && abs > abs2) {
                this.OB = true;
                if (this.OP != null) {
                    this.OP.oi();
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
        this.OB = false;
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

    private void oe() {
        this.OE = true;
        this.mScroller.startScroll(this.mContentView.getScrollX(), 0, (-(this.mViewWidth + this.mContentView.getScrollX())) + 1, 0);
        postInvalidate();
    }

    private void og() {
        this.OE = true;
        this.mScroller.startScroll(this.mContentView.getScrollX(), 0, -this.mContentView.getScrollX(), 0);
        postInvalidate();
    }

    private void oh() {
        if (this.OE) {
            this.mScroller.abortAnimation();
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            int currX = this.mScroller.getCurrX();
            int currY = this.mScroller.getCurrY();
            if (scrollX != currX || scrollY != currY) {
                this.mContentView.scrollTo(currX, currY);
            }
        }
        this.OE = false;
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
        if (this.mScroller.isFinished() && this.OC) {
            this.mActivity.finish();
            this.mActivity.overridePendingTransition(0, 0);
        }
        if (this.mScroller.isFinished()) {
            oh();
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
        this.OM = true;
        this.OD = false;
    }

    public boolean isSwipeBackEnabled() {
        return this.OD;
    }

    public void setSwipeBackEnabled(boolean z) {
        this.OD = z;
    }

    public void setBgTransparent() {
        if (this.Oz != null) {
            this.Oz.setBackgroundResource(R.color.transparent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a implements Interpolator {
        private final float OQ;

        public a(float f) {
            this.OQ = f;
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            float f2 = this.OQ * f;
            if (f2 > 0.9d) {
                return 1.0f;
            }
            return f2;
        }
    }

    public void setOnSlidingStateChangeListener(b bVar) {
        this.OP = bVar;
    }
}
