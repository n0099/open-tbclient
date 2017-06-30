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
    private float FG;
    private int IA;
    private Rect IB;
    private int IC;
    private float IE;
    private boolean IF;
    private b IG;
    private ViewGroup It;
    private int Iu;
    private boolean Iv;
    private boolean Iw;
    private boolean Ix;
    private boolean Iy;
    private int Iz;
    private int mActivePointerId;
    private Activity mActivity;
    private View mContentView;
    private int mFlingDistance;
    private boolean mIsScrolling;
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
        void W(boolean z);

        void lq();
    }

    /* loaded from: classes.dex */
    public interface c {
        void lr();

        void ls();
    }

    public f(Context context) {
        super(context);
        this.mActivePointerId = -1;
        this.Iv = false;
        this.Iw = false;
        this.Ix = true;
        this.mIsScrolling = false;
        this.Iy = false;
        this.IA = 0;
        this.IB = new Rect();
        this.IF = true;
        init(context);
    }

    private void init(Context context) {
        this.Iz = (int) TypedValue.applyDimension(1, 24.0f, getResources().getDisplayMetrics());
        this.mScroller = new Scroller(context, new a(1.5f));
        this.mTouchSlop = ViewConfiguration.get(context.getApplicationContext()).getScaledTouchSlop() * 2;
        this.mMaximumVelocity = ViewConfiguration.getMaximumFlingVelocity();
        this.mMinimumVelocity = ViewConfiguration.getMinimumFlingVelocity();
        this.IC = (int) (context.getResources().getDisplayMetrics().density * 24.0f);
        this.mFlingDistance = k.af(context) / 4;
    }

    public void p(Activity activity) {
        try {
            this.mActivity = activity;
            Window window = activity.getWindow();
            window.setBackgroundDrawable(new ColorDrawable(0));
            ViewGroup viewGroup = (ViewGroup) window.getDecorView();
            this.It = (ViewGroup) viewGroup.getChildAt(0);
            viewGroup.removeView(this.It);
            this.It.setClickable(true);
            addView(this.It);
            this.mContentView = (View) this.It.getParent();
            viewGroup.addView(this);
        } catch (Exception e) {
            this.Ix = false;
            BdLog.e(e);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.Ix) {
            if (this.IF && i == 1) {
                this.It.setBackgroundResource(R.color.swipe_layout_night_bg);
            } else {
                this.It.setBackgroundResource(R.color.swipe_layout_normal_bg);
            }
        }
    }

    public void aK(int i) {
        if (this.IF && i == 1) {
            this.It.setBackgroundResource(R.color.swipe_layout_night_bg);
        } else {
            this.It.setBackgroundResource(R.color.swipe_layout_normal_bg);
        }
    }

    public void setIsSupportNight(boolean z) {
        if (!z) {
            this.It.setBackgroundResource(R.color.swipe_layout_normal_bg);
        }
        this.IF = z;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.mContentView != null) {
            int i = this.Iu;
            int bottom = this.mContentView.getBottom();
            this.IB.top = 0;
            this.IB.bottom = bottom;
            this.IB.left = 0;
            this.IB.right = i;
            canvas.clipRect(this.IB);
            if (this.mViewWidth != 0) {
                this.IA = 100 - ((int) (((-this.Iu) / this.mViewWidth) * 120.0f));
            }
            if (this.IA > 100) {
                this.IA = 100;
            }
            if (this.Iw) {
                this.IA = 0;
            }
            if (this.IA < 0) {
                this.IA = 0;
            }
            canvas.drawARGB(this.IA, 0, 0, 0);
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (!this.Ix) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (this.Iw || this.mIsScrolling) {
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
                    this.FG = MotionEventCompat.getX(motionEvent, actionIndex);
                    break;
                }
                break;
            case 2:
                g(motionEvent);
                break;
        }
        return this.Iv;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.Iw || this.mIsScrolling) {
            return super.onTouchEvent(motionEvent);
        }
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        this.mVelocityTracker.addMovement(motionEvent);
        switch (motionEvent.getAction() & MotionEventCompat.ACTION_MASK) {
            case 0:
                ln();
                int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
                this.mActivePointerId = MotionEventCompat.getPointerId(motionEvent, actionIndex);
                this.mLastMotionX = motionEvent.getX();
                this.FG = MotionEventCompat.getX(motionEvent, actionIndex);
                break;
            case 1:
                VelocityTracker velocityTracker = this.mVelocityTracker;
                velocityTracker.computeCurrentVelocity(1000, this.mMaximumVelocity);
                this.IE = velocityTracker.getXVelocity();
                int h = h(motionEvent);
                endDrag();
                if (Math.abs(this.IE) > this.mMinimumVelocity && h > this.mFlingDistance) {
                    if (this.IE > 0.0f) {
                        this.Iw = true;
                        ll();
                    } else {
                        lm();
                        this.Iw = false;
                    }
                    if (this.IG != null) {
                        this.IG.W(this.Iw);
                        return true;
                    }
                    return true;
                }
                if (this.mContentView.getScrollX() <= (-this.mViewWidth) / 2) {
                    this.Iw = true;
                    ll();
                } else {
                    lm();
                    this.Iw = false;
                }
                if (this.IG != null) {
                    this.IG.W(this.Iw);
                    break;
                }
                break;
            case 2:
                if (!this.Iv) {
                    g(motionEvent);
                }
                if (this.Iv) {
                    int b2 = b(motionEvent, this.mActivePointerId);
                    if (!a(motionEvent, b2, this.mActivePointerId)) {
                        float x = MotionEventCompat.getX(motionEvent, b2);
                        this.mLastMotionX = x;
                        float scrollX = (this.mLastMotionX - x) + getScrollX();
                        float f = -this.mViewWidth;
                        if (scrollX >= f) {
                            f = scrollX > 0.0f ? 0.0f : scrollX;
                        }
                        this.mLastMotionX += f - ((int) f);
                        this.Iu = (int) f;
                        this.mContentView.scrollTo((int) f, getScrollY());
                        break;
                    }
                }
                break;
            case 3:
                lo();
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    private void g(MotionEvent motionEvent) {
        int i = this.mActivePointerId;
        int b2 = b(motionEvent, i);
        if (!a(motionEvent, b2, i)) {
            float x = MotionEventCompat.getX(motionEvent, b2);
            float f = x - this.mLastMotionX;
            float abs = Math.abs(f);
            float y = MotionEventCompat.getY(motionEvent, b2);
            float abs2 = Math.abs(y - this.mLastMotionY);
            if (f > 0.0f && abs > this.IC && abs > abs2) {
                this.Iv = true;
                if (this.IG != null) {
                    this.IG.lq();
                }
                this.mLastMotionX = x;
                this.mLastMotionY = y;
            }
        }
    }

    private int h(MotionEvent motionEvent) {
        int i = this.mActivePointerId;
        int b2 = b(motionEvent, i);
        if (a(motionEvent, b2, i)) {
            return 0;
        }
        return (int) Math.abs(MotionEventCompat.getX(motionEvent, b2) - this.FG);
    }

    private void endDrag() {
        this.Iv = false;
        this.mActivePointerId = -1;
        lo();
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

    private int b(MotionEvent motionEvent, int i) {
        int findPointerIndex = MotionEventCompat.findPointerIndex(motionEvent, i);
        if (findPointerIndex == -1) {
            this.mActivePointerId = -1;
        }
        return findPointerIndex;
    }

    private void ll() {
        this.mIsScrolling = true;
        this.mScroller.startScroll(this.mContentView.getScrollX(), 0, (-(this.mViewWidth + this.mContentView.getScrollX())) + 1, 0);
        postInvalidate();
    }

    private void lm() {
        this.mIsScrolling = true;
        this.mScroller.startScroll(this.mContentView.getScrollX(), 0, -this.mContentView.getScrollX(), 0);
        postInvalidate();
    }

    private void ln() {
        if (this.mIsScrolling) {
            this.mScroller.abortAnimation();
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            int currX = this.mScroller.getCurrX();
            int currY = this.mScroller.getCurrY();
            if (scrollX != currX || scrollY != currY) {
                this.mContentView.scrollTo(currX, currY);
            }
        }
        this.mIsScrolling = false;
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
        if (this.mScroller.isFinished() && this.Iw) {
            this.mActivity.finish();
            this.mActivity.overridePendingTransition(0, 0);
        }
        if (this.mScroller.isFinished()) {
            ln();
        }
    }

    private void lo() {
        if (this.mVelocityTracker != null) {
            this.mVelocityTracker.clear();
            this.mVelocityTracker.recycle();
            this.mVelocityTracker = null;
        }
    }

    public boolean isSwipeBackEnabled() {
        return this.Ix;
    }

    public void setSwipeBackEnabled(boolean z) {
        this.Ix = z;
    }

    public void lp() {
        if (this.It != null) {
            this.It.setBackgroundResource(R.color.transparent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a implements Interpolator {
        private final float IH;

        public a(float f) {
            this.IH = f;
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            float f2 = this.IH * f;
            if (f2 > 0.9d) {
                return 1.0f;
            }
            return f2;
        }
    }

    public void setOnSlidingStateChangeListener(b bVar) {
        this.IG = bVar;
    }
}
