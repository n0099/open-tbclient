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
    private float Fe;
    private ViewGroup Ig;
    private int Ih;
    private boolean Ii;
    private boolean Ij;
    private boolean Ik;
    private boolean Il;
    private boolean Im;
    private int In;
    private int Io;
    private Rect Ip;
    private int Iq;
    private float Ir;
    private boolean Is;
    private b It;
    private int mActivePointerId;
    private Activity mActivity;
    private View mContentView;
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
        void Y(boolean z);

        void lr();
    }

    /* loaded from: classes.dex */
    public interface c {
        void ls();

        void lt();
    }

    public d(Context context) {
        super(context);
        this.mActivePointerId = -1;
        this.Ii = false;
        this.Ij = false;
        this.Ik = true;
        this.Il = false;
        this.Im = false;
        this.Io = 0;
        this.Ip = new Rect();
        this.Is = true;
        init(context);
    }

    private void init(Context context) {
        this.In = (int) TypedValue.applyDimension(1, 24.0f, getResources().getDisplayMetrics());
        this.mScroller = new Scroller(context, new a(1.5f));
        this.mTouchSlop = ViewConfiguration.get(context.getApplicationContext()).getScaledTouchSlop() * 2;
        this.mMaximumVelocity = ViewConfiguration.getMaximumFlingVelocity();
        this.mMinimumVelocity = ViewConfiguration.getMinimumFlingVelocity();
        this.Iq = (int) (context.getResources().getDisplayMetrics().density * 24.0f);
        this.mFlingDistance = l.ad(context) / 4;
    }

    public void p(Activity activity) {
        try {
            this.mActivity = activity;
            Window window = activity.getWindow();
            window.setBackgroundDrawable(new ColorDrawable(0));
            ViewGroup viewGroup = (ViewGroup) window.getDecorView();
            this.Ig = (ViewGroup) viewGroup.getChildAt(0);
            viewGroup.removeView(this.Ig);
            this.Ig.setClickable(true);
            addView(this.Ig);
            this.mContentView = (View) this.Ig.getParent();
            viewGroup.addView(this);
        } catch (Exception e) {
            this.Ik = false;
            BdLog.e(e);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.Ik) {
            if (this.Is && i == 1) {
                this.Ig.setBackgroundResource(R.color.swipe_layout_night_bg);
            } else {
                this.Ig.setBackgroundResource(R.color.swipe_layout_normal_bg);
            }
        }
    }

    public void aO(int i) {
        if (this.Is && i == 1) {
            this.Ig.setBackgroundResource(R.color.swipe_layout_night_bg);
        } else {
            this.Ig.setBackgroundResource(R.color.swipe_layout_normal_bg);
        }
    }

    public void setIsSupportNight(boolean z) {
        if (!z) {
            this.Ig.setBackgroundResource(R.color.swipe_layout_normal_bg);
        }
        this.Is = z;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.mContentView != null) {
            int i = this.Ih;
            int bottom = this.mContentView.getBottom();
            this.Ip.top = 0;
            this.Ip.bottom = bottom;
            this.Ip.left = 0;
            this.Ip.right = i;
            canvas.clipRect(this.Ip);
            if (this.mViewWidth != 0) {
                this.Io = 100 - ((int) (((-this.Ih) / this.mViewWidth) * 120.0f));
            }
            if (this.Io > 100) {
                this.Io = 100;
            }
            if (this.Ij) {
                this.Io = 0;
            }
            if (this.Io < 0) {
                this.Io = 0;
            }
            canvas.drawARGB(this.Io, 0, 0, 0);
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (!this.Ik) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (this.Ij || this.Il) {
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
                    this.Fe = MotionEventCompat.getX(motionEvent, actionIndex);
                    break;
                }
                break;
            case 2:
                g(motionEvent);
                break;
        }
        return this.Ii;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.Ij || this.Il) {
            return super.onTouchEvent(motionEvent);
        }
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        this.mVelocityTracker.addMovement(motionEvent);
        switch (motionEvent.getAction() & MotionEventCompat.ACTION_MASK) {
            case 0:
                lo();
                int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
                this.mActivePointerId = MotionEventCompat.getPointerId(motionEvent, actionIndex);
                this.mLastMotionX = motionEvent.getX();
                this.Fe = MotionEventCompat.getX(motionEvent, actionIndex);
                break;
            case 1:
                VelocityTracker velocityTracker = this.mVelocityTracker;
                velocityTracker.computeCurrentVelocity(1000, this.mMaximumVelocity);
                this.Ir = velocityTracker.getXVelocity();
                int h = h(motionEvent);
                endDrag();
                if (Math.abs(this.Ir) > this.mMinimumVelocity && h > this.mFlingDistance) {
                    if (this.Ir > 0.0f) {
                        this.Ij = true;
                        lm();
                    } else {
                        ln();
                        this.Ij = false;
                    }
                    if (this.It != null) {
                        this.It.Y(this.Ij);
                        return true;
                    }
                    return true;
                }
                if (this.mContentView.getScrollX() <= (-this.mViewWidth) / 2) {
                    this.Ij = true;
                    lm();
                } else {
                    ln();
                    this.Ij = false;
                }
                if (this.It != null) {
                    this.It.Y(this.Ij);
                    break;
                }
                break;
            case 2:
                if (!this.Ii) {
                    g(motionEvent);
                }
                if (this.Ii) {
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
                        this.Ih = (int) f;
                        this.mContentView.scrollTo((int) f, getScrollY());
                        break;
                    }
                }
                break;
            case 3:
                lp();
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
            if (f > 0.0f && abs > this.Iq && abs > abs2) {
                this.Ii = true;
                if (this.It != null) {
                    this.It.lr();
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
        return (int) Math.abs(MotionEventCompat.getX(motionEvent, b2) - this.Fe);
    }

    private void endDrag() {
        this.Ii = false;
        this.mActivePointerId = -1;
        lp();
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

    private void lm() {
        this.Il = true;
        this.mScroller.startScroll(this.mContentView.getScrollX(), 0, (-(this.mViewWidth + this.mContentView.getScrollX())) + 1, 0);
        postInvalidate();
    }

    private void ln() {
        this.Il = true;
        this.mScroller.startScroll(this.mContentView.getScrollX(), 0, -this.mContentView.getScrollX(), 0);
        postInvalidate();
    }

    private void lo() {
        if (this.Il) {
            this.mScroller.abortAnimation();
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            int currX = this.mScroller.getCurrX();
            int currY = this.mScroller.getCurrY();
            if (scrollX != currX || scrollY != currY) {
                this.mContentView.scrollTo(currX, currY);
            }
        }
        this.Il = false;
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
        if (this.mScroller.isFinished() && this.Ij) {
            this.mActivity.finish();
            this.mActivity.overridePendingTransition(0, 0);
        }
        if (this.mScroller.isFinished()) {
            lo();
        }
    }

    private void lp() {
        if (this.mVelocityTracker != null) {
            this.mVelocityTracker.clear();
            this.mVelocityTracker.recycle();
            this.mVelocityTracker = null;
        }
    }

    public boolean isSwipeBackEnabled() {
        return this.Ik;
    }

    public void setSwipeBackEnabled(boolean z) {
        this.Ik = z;
    }

    public void lq() {
        if (this.Ig != null) {
            this.Ig.setBackgroundResource(R.color.transparent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a implements Interpolator {
        private final float Iu;

        public a(float f) {
            this.Iu = f;
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            float f2 = this.Iu * f;
            if (f2 > 0.9d) {
                return 1.0f;
            }
            return f2;
        }
    }

    public void setOnSlidingStateChangeListener(b bVar) {
        this.It = bVar;
    }
}
