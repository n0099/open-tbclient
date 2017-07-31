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
public class d extends FrameLayout {
    private float Hf;
    private ViewGroup JT;
    private int JU;
    private boolean JV;
    private boolean JW;
    private boolean JX;
    private boolean JY;
    private int JZ;
    private int Ka;
    private Rect Kb;
    private int Kc;
    private float Kd;
    private boolean Ke;
    private b Kf;
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

        void ly();
    }

    /* loaded from: classes.dex */
    public interface c {
        void lA();

        void lz();
    }

    public d(Context context) {
        super(context);
        this.mActivePointerId = -1;
        this.JV = false;
        this.JW = false;
        this.JX = true;
        this.mIsScrolling = false;
        this.JY = false;
        this.Ka = 0;
        this.Kb = new Rect();
        this.Ke = true;
        init(context);
    }

    private void init(Context context) {
        this.JZ = (int) TypedValue.applyDimension(1, 24.0f, getResources().getDisplayMetrics());
        this.mScroller = new Scroller(context, new a(1.5f));
        this.mTouchSlop = ViewConfiguration.get(context.getApplicationContext()).getScaledTouchSlop() * 2;
        this.mMaximumVelocity = ViewConfiguration.getMaximumFlingVelocity();
        this.mMinimumVelocity = ViewConfiguration.getMinimumFlingVelocity();
        this.Kc = (int) (context.getResources().getDisplayMetrics().density * 24.0f);
        this.mFlingDistance = k.ag(context) / 4;
    }

    public void p(Activity activity) {
        try {
            this.mActivity = activity;
            Window window = activity.getWindow();
            window.setBackgroundDrawable(new ColorDrawable(0));
            ViewGroup viewGroup = (ViewGroup) window.getDecorView();
            this.JT = (ViewGroup) viewGroup.getChildAt(0);
            viewGroup.removeView(this.JT);
            this.JT.setClickable(true);
            addView(this.JT);
            this.mContentView = (View) this.JT.getParent();
            viewGroup.addView(this);
        } catch (Exception e) {
            this.JX = false;
            BdLog.e(e);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.JX) {
            if (this.Ke && i == 1) {
                this.JT.setBackgroundResource(R.color.swipe_layout_night_bg);
            } else {
                this.JT.setBackgroundResource(R.color.swipe_layout_normal_bg);
            }
        }
    }

    public void aM(int i) {
        if (this.Ke && i == 1) {
            this.JT.setBackgroundResource(R.color.swipe_layout_night_bg);
        } else {
            this.JT.setBackgroundResource(R.color.swipe_layout_normal_bg);
        }
    }

    public void setIsSupportNight(boolean z) {
        if (!z) {
            this.JT.setBackgroundResource(R.color.swipe_layout_normal_bg);
        }
        this.Ke = z;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.mContentView != null) {
            int i = this.JU;
            int bottom = this.mContentView.getBottom();
            this.Kb.top = 0;
            this.Kb.bottom = bottom;
            this.Kb.left = 0;
            this.Kb.right = i;
            canvas.clipRect(this.Kb);
            if (this.mViewWidth != 0) {
                this.Ka = 100 - ((int) (((-this.JU) / this.mViewWidth) * 120.0f));
            }
            if (this.Ka > 100) {
                this.Ka = 100;
            }
            if (this.JW) {
                this.Ka = 0;
            }
            if (this.Ka < 0) {
                this.Ka = 0;
            }
            canvas.drawARGB(this.Ka, 0, 0, 0);
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (!this.JX) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (this.JW || this.mIsScrolling) {
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
                    this.Hf = MotionEventCompat.getX(motionEvent, actionIndex);
                    break;
                }
                break;
            case 2:
                g(motionEvent);
                break;
        }
        return this.JV;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.JW || this.mIsScrolling) {
            return super.onTouchEvent(motionEvent);
        }
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        this.mVelocityTracker.addMovement(motionEvent);
        switch (motionEvent.getAction() & MotionEventCompat.ACTION_MASK) {
            case 0:
                lv();
                int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
                this.mActivePointerId = MotionEventCompat.getPointerId(motionEvent, actionIndex);
                this.mLastMotionX = motionEvent.getX();
                this.Hf = MotionEventCompat.getX(motionEvent, actionIndex);
                break;
            case 1:
                VelocityTracker velocityTracker = this.mVelocityTracker;
                velocityTracker.computeCurrentVelocity(1000, this.mMaximumVelocity);
                this.Kd = velocityTracker.getXVelocity();
                int h = h(motionEvent);
                endDrag();
                if (Math.abs(this.Kd) > this.mMinimumVelocity && h > this.mFlingDistance) {
                    if (this.Kd > 0.0f) {
                        this.JW = true;
                        lt();
                    } else {
                        lu();
                        this.JW = false;
                    }
                    if (this.Kf != null) {
                        this.Kf.W(this.JW);
                        return true;
                    }
                    return true;
                }
                if (this.mContentView.getScrollX() <= (-this.mViewWidth) / 2) {
                    this.JW = true;
                    lt();
                } else {
                    lu();
                    this.JW = false;
                }
                if (this.Kf != null) {
                    this.Kf.W(this.JW);
                    break;
                }
                break;
            case 2:
                if (!this.JV) {
                    g(motionEvent);
                }
                if (this.JV) {
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
                        this.JU = (int) f;
                        this.mContentView.scrollTo((int) f, getScrollY());
                        break;
                    }
                }
                break;
            case 3:
                lw();
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
            if (f > 0.0f && abs > this.Kc && abs > abs2) {
                this.JV = true;
                if (this.Kf != null) {
                    this.Kf.ly();
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
        return (int) Math.abs(MotionEventCompat.getX(motionEvent, b2) - this.Hf);
    }

    private void endDrag() {
        this.JV = false;
        this.mActivePointerId = -1;
        lw();
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

    private void lt() {
        this.mIsScrolling = true;
        this.mScroller.startScroll(this.mContentView.getScrollX(), 0, (-(this.mViewWidth + this.mContentView.getScrollX())) + 1, 0);
        postInvalidate();
    }

    private void lu() {
        this.mIsScrolling = true;
        this.mScroller.startScroll(this.mContentView.getScrollX(), 0, -this.mContentView.getScrollX(), 0);
        postInvalidate();
    }

    private void lv() {
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
        if (this.mScroller.isFinished() && this.JW) {
            this.mActivity.finish();
            this.mActivity.overridePendingTransition(0, 0);
        }
        if (this.mScroller.isFinished()) {
            lv();
        }
    }

    private void lw() {
        if (this.mVelocityTracker != null) {
            this.mVelocityTracker.clear();
            this.mVelocityTracker.recycle();
            this.mVelocityTracker = null;
        }
    }

    public boolean isSwipeBackEnabled() {
        return this.JX;
    }

    public void setSwipeBackEnabled(boolean z) {
        this.JX = z;
    }

    public void lx() {
        if (this.JT != null) {
            this.JT.setBackgroundResource(R.color.transparent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a implements Interpolator {
        private final float Kg;

        public a(float f) {
            this.Kg = f;
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            float f2 = this.Kg * f;
            if (f2 > 0.9d) {
                return 1.0f;
            }
            return f2;
        }
    }

    public void setOnSlidingStateChangeListener(b bVar) {
        this.Kf = bVar;
    }
}
