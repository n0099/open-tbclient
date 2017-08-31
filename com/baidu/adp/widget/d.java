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
    private float Fb;
    private ViewGroup HO;
    private int HP;
    private boolean HQ;
    private boolean HR;
    private boolean HS;
    private boolean HT;
    private boolean HU;
    private int HV;
    private int HW;
    private Rect HX;
    private int HY;
    private float HZ;
    private boolean Ia;
    private b Ib;
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
        void X(boolean z);

        void lp();
    }

    /* loaded from: classes.dex */
    public interface c {
        void lq();

        void lr();
    }

    public d(Context context) {
        super(context);
        this.mActivePointerId = -1;
        this.HQ = false;
        this.HR = false;
        this.HS = true;
        this.HT = false;
        this.HU = false;
        this.HW = 0;
        this.HX = new Rect();
        this.Ia = true;
        init(context);
    }

    private void init(Context context) {
        this.HV = (int) TypedValue.applyDimension(1, 24.0f, getResources().getDisplayMetrics());
        this.mScroller = new Scroller(context, new a(1.5f));
        this.mTouchSlop = ViewConfiguration.get(context.getApplicationContext()).getScaledTouchSlop() * 2;
        this.mMaximumVelocity = ViewConfiguration.getMaximumFlingVelocity();
        this.mMinimumVelocity = ViewConfiguration.getMinimumFlingVelocity();
        this.HY = (int) (context.getResources().getDisplayMetrics().density * 24.0f);
        this.mFlingDistance = k.ad(context) / 4;
    }

    public void p(Activity activity) {
        try {
            this.mActivity = activity;
            Window window = activity.getWindow();
            window.setBackgroundDrawable(new ColorDrawable(0));
            ViewGroup viewGroup = (ViewGroup) window.getDecorView();
            this.HO = (ViewGroup) viewGroup.getChildAt(0);
            viewGroup.removeView(this.HO);
            this.HO.setClickable(true);
            addView(this.HO);
            this.mContentView = (View) this.HO.getParent();
            viewGroup.addView(this);
        } catch (Exception e) {
            this.HS = false;
            BdLog.e(e);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.HS) {
            if (this.Ia && i == 1) {
                this.HO.setBackgroundResource(R.color.swipe_layout_night_bg);
            } else {
                this.HO.setBackgroundResource(R.color.swipe_layout_normal_bg);
            }
        }
    }

    public void aK(int i) {
        if (this.Ia && i == 1) {
            this.HO.setBackgroundResource(R.color.swipe_layout_night_bg);
        } else {
            this.HO.setBackgroundResource(R.color.swipe_layout_normal_bg);
        }
    }

    public void setIsSupportNight(boolean z) {
        if (!z) {
            this.HO.setBackgroundResource(R.color.swipe_layout_normal_bg);
        }
        this.Ia = z;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.mContentView != null) {
            int i = this.HP;
            int bottom = this.mContentView.getBottom();
            this.HX.top = 0;
            this.HX.bottom = bottom;
            this.HX.left = 0;
            this.HX.right = i;
            canvas.clipRect(this.HX);
            if (this.mViewWidth != 0) {
                this.HW = 100 - ((int) (((-this.HP) / this.mViewWidth) * 120.0f));
            }
            if (this.HW > 100) {
                this.HW = 100;
            }
            if (this.HR) {
                this.HW = 0;
            }
            if (this.HW < 0) {
                this.HW = 0;
            }
            canvas.drawARGB(this.HW, 0, 0, 0);
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (!this.HS) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (this.HR || this.HT) {
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
                    this.Fb = MotionEventCompat.getX(motionEvent, actionIndex);
                    break;
                }
                break;
            case 2:
                g(motionEvent);
                break;
        }
        return this.HQ;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.HR || this.HT) {
            return super.onTouchEvent(motionEvent);
        }
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        this.mVelocityTracker.addMovement(motionEvent);
        switch (motionEvent.getAction() & MotionEventCompat.ACTION_MASK) {
            case 0:
                lm();
                int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
                this.mActivePointerId = MotionEventCompat.getPointerId(motionEvent, actionIndex);
                this.mLastMotionX = motionEvent.getX();
                this.Fb = MotionEventCompat.getX(motionEvent, actionIndex);
                break;
            case 1:
                VelocityTracker velocityTracker = this.mVelocityTracker;
                velocityTracker.computeCurrentVelocity(1000, this.mMaximumVelocity);
                this.HZ = velocityTracker.getXVelocity();
                int h = h(motionEvent);
                endDrag();
                if (Math.abs(this.HZ) > this.mMinimumVelocity && h > this.mFlingDistance) {
                    if (this.HZ > 0.0f) {
                        this.HR = true;
                        lk();
                    } else {
                        ll();
                        this.HR = false;
                    }
                    if (this.Ib != null) {
                        this.Ib.X(this.HR);
                        return true;
                    }
                    return true;
                }
                if (this.mContentView.getScrollX() <= (-this.mViewWidth) / 2) {
                    this.HR = true;
                    lk();
                } else {
                    ll();
                    this.HR = false;
                }
                if (this.Ib != null) {
                    this.Ib.X(this.HR);
                    break;
                }
                break;
            case 2:
                if (!this.HQ) {
                    g(motionEvent);
                }
                if (this.HQ) {
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
                        this.HP = (int) f;
                        this.mContentView.scrollTo((int) f, getScrollY());
                        break;
                    }
                }
                break;
            case 3:
                ln();
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
            if (f > 0.0f && abs > this.HY && abs > abs2) {
                this.HQ = true;
                if (this.Ib != null) {
                    this.Ib.lp();
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
        return (int) Math.abs(MotionEventCompat.getX(motionEvent, b2) - this.Fb);
    }

    private void endDrag() {
        this.HQ = false;
        this.mActivePointerId = -1;
        ln();
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

    private void lk() {
        this.HT = true;
        this.mScroller.startScroll(this.mContentView.getScrollX(), 0, (-(this.mViewWidth + this.mContentView.getScrollX())) + 1, 0);
        postInvalidate();
    }

    private void ll() {
        this.HT = true;
        this.mScroller.startScroll(this.mContentView.getScrollX(), 0, -this.mContentView.getScrollX(), 0);
        postInvalidate();
    }

    private void lm() {
        if (this.HT) {
            this.mScroller.abortAnimation();
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            int currX = this.mScroller.getCurrX();
            int currY = this.mScroller.getCurrY();
            if (scrollX != currX || scrollY != currY) {
                this.mContentView.scrollTo(currX, currY);
            }
        }
        this.HT = false;
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
        if (this.mScroller.isFinished() && this.HR) {
            this.mActivity.finish();
            this.mActivity.overridePendingTransition(0, 0);
        }
        if (this.mScroller.isFinished()) {
            lm();
        }
    }

    private void ln() {
        if (this.mVelocityTracker != null) {
            this.mVelocityTracker.clear();
            this.mVelocityTracker.recycle();
            this.mVelocityTracker = null;
        }
    }

    public boolean isSwipeBackEnabled() {
        return this.HS;
    }

    public void setSwipeBackEnabled(boolean z) {
        this.HS = z;
    }

    public void lo() {
        if (this.HO != null) {
            this.HO.setBackgroundResource(R.color.transparent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a implements Interpolator {
        private final float Ic;

        public a(float f) {
            this.Ic = f;
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            float f2 = this.Ic * f;
            if (f2 > 0.9d) {
                return 1.0f;
            }
            return f2;
        }
    }

    public void setOnSlidingStateChangeListener(b bVar) {
        this.Ib = bVar;
    }
}
