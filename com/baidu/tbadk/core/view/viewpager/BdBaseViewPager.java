package com.baidu.tbadk.core.view.viewpager;

import android.content.Context;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.Scroller;
import java.lang.reflect.Field;
/* loaded from: classes.dex */
public class BdBaseViewPager extends ViewPager {
    private boolean eMw;
    private int mActivePointerId;
    private int mDuration;
    private float mInitialMotionX;
    private float mInitialMotionY;
    private boolean mIsDisallowIntercept;
    private float mLastMotionX;
    private float mLastMotionY;
    private int mTouchSlop;

    public BdBaseViewPager(Context context) {
        super(context);
        this.mIsDisallowIntercept = false;
        this.eMw = false;
        this.mActivePointerId = -1;
        this.mDuration = 600;
        initViewPager();
    }

    public BdBaseViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mIsDisallowIntercept = false;
        this.eMw = false;
        this.mActivePointerId = -1;
        this.mDuration = 600;
        initViewPager();
    }

    private void initViewPager() {
        this.mTouchSlop = ViewConfiguration.get(getContext()).getScaledPagingTouchSlop();
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        this.mIsDisallowIntercept = z;
        super.requestDisallowInterceptTouchEvent(z);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (isInvalidPointer(motionEvent)) {
            return true;
        }
        if (motionEvent.getPointerCount() > 1 && this.mIsDisallowIntercept) {
            requestDisallowInterceptTouchEvent(false);
            boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
            requestDisallowInterceptTouchEvent(true);
            return dispatchTouchEvent;
        }
        try {
            return super.dispatchTouchEvent(motionEvent);
        } catch (Exception e) {
            return false;
        }
    }

    @Override // android.support.v4.view.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int findPointerIndex;
        if (this.eMw) {
            return false;
        }
        if (isInvalidPointer(motionEvent)) {
            return true;
        }
        switch (motionEvent.getAction() & 255) {
            case 0:
                float x = motionEvent.getX();
                this.mInitialMotionX = x;
                this.mLastMotionX = x;
                float y = motionEvent.getY();
                this.mInitialMotionY = y;
                this.mLastMotionY = y;
                this.mActivePointerId = motionEvent.getPointerId(0);
                if (getCurrentItem() != 0) {
                    requestParentInterceptTouchEvent(true);
                    break;
                }
                break;
            case 2:
                int i = this.mActivePointerId;
                if (i != -1 && (findPointerIndex = motionEvent.findPointerIndex(i)) != -1 && findPointerIndex < motionEvent.getPointerCount()) {
                    float x2 = motionEvent.getX(findPointerIndex) - this.mLastMotionX;
                    float abs = Math.abs(x2);
                    float abs2 = Math.abs(motionEvent.getY(findPointerIndex) - this.mInitialMotionY);
                    if (x2 > 0.0f && abs > abs2 && getCurrentItem() == 0 && getScrollState() == 0) {
                        requestParentInterceptTouchEvent(false);
                        return false;
                    } else if (abs > 0.0f && abs > abs2 && getCurrentItem() != 0) {
                        requestParentInterceptTouchEvent(true);
                        break;
                    }
                }
                break;
            case 6:
                onSecondaryPointerUp(motionEvent);
                break;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.support.v4.view.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int findPointerIndex;
        if (this.eMw) {
            return false;
        }
        switch (motionEvent.getAction() & 255) {
            case 0:
                float x = motionEvent.getX();
                this.mInitialMotionX = x;
                this.mLastMotionX = x;
                float y = motionEvent.getY();
                this.mInitialMotionY = y;
                this.mLastMotionY = y;
                this.mActivePointerId = motionEvent.getPointerId(0);
                if (getCurrentItem() != 0) {
                    requestParentInterceptTouchEvent(true);
                    break;
                }
                break;
            case 1:
            case 3:
                requestParentInterceptTouchEvent(false);
                break;
            case 2:
                int i = this.mActivePointerId;
                if (i != -1 && (findPointerIndex = motionEvent.findPointerIndex(i)) != -1 && findPointerIndex < motionEvent.getPointerCount()) {
                    float x2 = motionEvent.getX(findPointerIndex) - this.mLastMotionX;
                    float abs = Math.abs(x2);
                    float abs2 = Math.abs(motionEvent.getY(findPointerIndex) - this.mInitialMotionY);
                    if (x2 > 0.0f && abs > abs2 && getCurrentItem() == 0 && getScrollState() == 0) {
                        requestParentInterceptTouchEvent(false);
                        return false;
                    } else if (abs > 0.0f && abs > abs2 && getCurrentItem() != 0) {
                        requestParentInterceptTouchEvent(true);
                        break;
                    }
                }
                break;
            case 5:
                int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
                this.mLastMotionX = motionEvent.getX(actionIndex);
                this.mActivePointerId = motionEvent.getPointerId(actionIndex);
                break;
            case 6:
                onSecondaryPointerUp(motionEvent);
                this.mLastMotionX = motionEvent.getX(motionEvent.findPointerIndex(this.mActivePointerId));
                break;
        }
        if (isInvalidPointer(motionEvent)) {
            return true;
        }
        try {
            return super.onTouchEvent(motionEvent);
        } catch (IllegalArgumentException e) {
            return true;
        }
    }

    private void onSecondaryPointerUp(MotionEvent motionEvent) {
        int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
        if (motionEvent.getPointerId(actionIndex) == this.mActivePointerId) {
            int i = actionIndex == 0 ? 1 : 0;
            this.mLastMotionX = motionEvent.getX(i);
            this.mActivePointerId = motionEvent.getPointerId(i);
        }
    }

    private boolean isInvalidPointer(MotionEvent motionEvent) {
        int action = (motionEvent.getAction() & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
        return motionEvent.getPointerId(action) == -1 || action == -1 || action >= motionEvent.getPointerCount();
    }

    public void requestParentInterceptTouchEvent(boolean z) {
        if (getParent() != null) {
            getParent().requestDisallowInterceptTouchEvent(z);
        }
    }

    public void setmDisallowSlip(boolean z) {
        this.eMw = z;
    }

    public int getScrollState() {
        try {
            Field declaredField = ViewPager.class.getDeclaredField("mScrollState");
            declaredField.setAccessible(true);
            return ((Integer) declaredField.get(this)).intValue();
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    /* loaded from: classes.dex */
    public class a extends Scroller {
        private int bsd;

        public a(Context context) {
            super(context);
            this.bsd = 1000;
        }

        @Override // android.widget.Scroller
        public void startScroll(int i, int i2, int i3, int i4, int i5) {
            super.startScroll(i, i2, i3, i4, this.bsd);
        }

        @Override // android.widget.Scroller
        public void startScroll(int i, int i2, int i3, int i4) {
            super.startScroll(i, i2, i3, i4, this.bsd);
        }

        public void initViewPagerScroll(ViewPager viewPager) {
            try {
                Field declaredField = ViewPager.class.getDeclaredField("mScroller");
                declaredField.setAccessible(true);
                declaredField.set(viewPager, this);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public void pY(int i) {
            this.bsd = i;
        }
    }
}
