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
    private ViewGroup MM;
    private int MN;
    private boolean MO;
    private boolean MP;
    private boolean MQ;
    private boolean MR;
    private boolean MS;
    private int MT;
    private int MU;
    private Rect MV;
    private int MW;
    private float MX;
    private boolean MY;
    private b MZ;
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
        void ac(boolean z);

        void nF();
    }

    /* loaded from: classes.dex */
    public interface c {
        void nG();

        void nH();
    }

    public SwipeBackLayout(Context context) {
        super(context);
        this.mActivePointerId = -1;
        this.MO = false;
        this.MP = false;
        this.MQ = true;
        this.MR = false;
        this.MS = false;
        this.MU = 0;
        this.MV = new Rect();
        this.MY = true;
        init(context);
    }

    public SwipeBackLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mActivePointerId = -1;
        this.MO = false;
        this.MP = false;
        this.MQ = true;
        this.MR = false;
        this.MS = false;
        this.MU = 0;
        this.MV = new Rect();
        this.MY = true;
        init(context);
    }

    public SwipeBackLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mActivePointerId = -1;
        this.MO = false;
        this.MP = false;
        this.MQ = true;
        this.MR = false;
        this.MS = false;
        this.MU = 0;
        this.MV = new Rect();
        this.MY = true;
        init(context);
    }

    private void init(Context context) {
        this.MT = (int) TypedValue.applyDimension(1, 24.0f, getResources().getDisplayMetrics());
        this.mScroller = new Scroller(context, new a(1.5f));
        this.mTouchSlop = ViewConfiguration.get(context.getApplicationContext()).getScaledTouchSlop() * 2;
        this.mMaximumVelocity = ViewConfiguration.getMaximumFlingVelocity();
        this.mMinimumVelocity = ViewConfiguration.getMinimumFlingVelocity();
        this.MW = (int) (context.getResources().getDisplayMetrics().density * 24.0f);
        this.mFlingDistance = l.ah(context) / 4;
    }

    public void q(Activity activity) {
        try {
            this.mActivity = activity;
            Window window = activity.getWindow();
            window.setBackgroundDrawable(new ColorDrawable(0));
            ViewGroup viewGroup = (ViewGroup) window.getDecorView();
            this.MM = (ViewGroup) viewGroup.getChildAt(0);
            viewGroup.removeView(this.MM);
            this.MM.setClickable(true);
            addView(this.MM);
            this.mContentView = (View) this.MM.getParent();
            viewGroup.addView(this);
        } catch (Exception e) {
            this.MQ = false;
            BdLog.e(e);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.MQ) {
            if (this.MY && i == 1) {
                this.MM.setBackgroundResource(R.color.swipe_layout_night_bg);
            } else {
                this.MM.setBackgroundResource(R.color.swipe_layout_normal_bg);
            }
        }
    }

    public void aO(int i) {
        if (this.MY && i == 1) {
            this.MM.setBackgroundResource(R.color.swipe_layout_night_bg);
        } else {
            this.MM.setBackgroundResource(R.color.swipe_layout_normal_bg);
        }
    }

    public void setIsSupportNight(boolean z) {
        if (!z) {
            this.MM.setBackgroundResource(R.color.swipe_layout_normal_bg);
        }
        this.MY = z;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.mContentView != null) {
            int i = this.MN;
            int bottom = this.mContentView.getBottom();
            this.MV.top = 0;
            this.MV.bottom = bottom;
            this.MV.left = 0;
            this.MV.right = i;
            canvas.clipRect(this.MV);
            if (this.mViewWidth != 0) {
                this.MU = 100 - ((int) (((-this.MN) / this.mViewWidth) * 120.0f));
            }
            if (this.MU > 100) {
                this.MU = 100;
            }
            if (this.MP) {
                this.MU = 0;
            }
            if (this.MU < 0) {
                this.MU = 0;
            }
            canvas.drawARGB(this.MU, 0, 0, 0);
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (!this.MQ) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (this.MP || this.MR) {
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
                n(motionEvent);
                break;
        }
        return this.MO;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.MP || this.MR) {
            return super.onTouchEvent(motionEvent);
        }
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        this.mVelocityTracker.addMovement(motionEvent);
        switch (motionEvent.getAction() & 255) {
            case 0:
                nE();
                int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
                this.mActivePointerId = MotionEventCompat.getPointerId(motionEvent, actionIndex);
                this.mLastMotionX = motionEvent.getX();
                this.mDownX = MotionEventCompat.getX(motionEvent, actionIndex);
                break;
            case 1:
                VelocityTracker velocityTracker = this.mVelocityTracker;
                velocityTracker.computeCurrentVelocity(1000, this.mMaximumVelocity);
                this.MX = velocityTracker.getXVelocity();
                int o = o(motionEvent);
                endDrag();
                if (Math.abs(this.MX) > this.mMinimumVelocity && o > this.mFlingDistance) {
                    if (this.MX > 0.0f) {
                        this.MP = true;
                        nC();
                    } else {
                        nD();
                        this.MP = false;
                    }
                    if (this.MZ != null) {
                        this.MZ.ac(this.MP);
                        return true;
                    }
                    return true;
                }
                if (this.mContentView.getScrollX() <= (-this.mViewWidth) / 2) {
                    this.MP = true;
                    nC();
                } else {
                    nD();
                    this.MP = false;
                }
                if (this.MZ != null) {
                    this.MZ.ac(this.MP);
                    break;
                }
                break;
            case 2:
                if (!this.MO) {
                    n(motionEvent);
                }
                if (this.MO) {
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
                        this.MN = (int) f;
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

    private void n(MotionEvent motionEvent) {
        int i = this.mActivePointerId;
        int pointerIndex = getPointerIndex(motionEvent, i);
        if (!a(motionEvent, pointerIndex, i)) {
            float x = MotionEventCompat.getX(motionEvent, pointerIndex);
            float f = x - this.mLastMotionX;
            float abs = Math.abs(f);
            float y = MotionEventCompat.getY(motionEvent, pointerIndex);
            float abs2 = Math.abs(y - this.mLastMotionY);
            if (f > 0.0f && abs > this.MW && abs > abs2) {
                this.MO = true;
                if (this.MZ != null) {
                    this.MZ.nF();
                }
                this.mLastMotionX = x;
                this.mLastMotionY = y;
            }
        }
    }

    private int o(MotionEvent motionEvent) {
        int i = this.mActivePointerId;
        int pointerIndex = getPointerIndex(motionEvent, i);
        if (a(motionEvent, pointerIndex, i)) {
            return 0;
        }
        return (int) Math.abs(MotionEventCompat.getX(motionEvent, pointerIndex) - this.mDownX);
    }

    private void endDrag() {
        this.MO = false;
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

    private void nC() {
        this.MR = true;
        this.mScroller.startScroll(this.mContentView.getScrollX(), 0, (-(this.mViewWidth + this.mContentView.getScrollX())) + 1, 0);
        postInvalidate();
    }

    private void nD() {
        this.MR = true;
        this.mScroller.startScroll(this.mContentView.getScrollX(), 0, -this.mContentView.getScrollX(), 0);
        postInvalidate();
    }

    private void nE() {
        if (this.MR) {
            this.mScroller.abortAnimation();
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            int currX = this.mScroller.getCurrX();
            int currY = this.mScroller.getCurrY();
            if (scrollX != currX || scrollY != currY) {
                this.mContentView.scrollTo(currX, currY);
            }
        }
        this.MR = false;
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
        if (this.mScroller.isFinished() && this.MP) {
            this.mActivity.finish();
            this.mActivity.overridePendingTransition(0, 0);
        }
        if (this.mScroller.isFinished()) {
            nE();
        }
    }

    private void releaseVelocityTracker() {
        if (this.mVelocityTracker != null) {
            this.mVelocityTracker.clear();
            this.mVelocityTracker.recycle();
            this.mVelocityTracker = null;
        }
    }

    public boolean isSwipeBackEnabled() {
        return this.MQ;
    }

    public void setSwipeBackEnabled(boolean z) {
        this.MQ = z;
    }

    public void setBgTransparent() {
        if (this.MM != null) {
            this.MM.setBackgroundResource(R.color.transparent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a implements Interpolator {
        private final float Na;

        public a(float f) {
            this.Na = f;
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            float f2 = this.Na * f;
            if (f2 > 0.9d) {
                return 1.0f;
            }
            return f2;
        }
    }

    public void setOnSlidingStateChangeListener(b bVar) {
        this.MZ = bVar;
    }
}
