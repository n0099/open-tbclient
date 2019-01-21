package com.baidu.tbadk.core.view.viewpager;

import android.content.Context;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.Scroller;
import com.baidu.searchbox.ng.ai.apps.core.slave.AiAppsSlavePool;
import java.lang.reflect.Field;
/* loaded from: classes.dex */
public class BdBaseViewPager extends ViewPager {
    private boolean aMe;
    private boolean aMf;
    private int mActivePointerId;
    private int mDuration;
    private float mInitialMotionX;
    private float mInitialMotionY;
    private float mLastMotionX;
    private float mLastMotionY;
    private int mTouchSlop;

    public BdBaseViewPager(Context context) {
        super(context);
        this.aMe = false;
        this.aMf = false;
        this.mActivePointerId = -1;
        this.mDuration = AiAppsSlavePool.PRELOAD_NEXT_DELAY_MS;
        initViewPager();
    }

    public BdBaseViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aMe = false;
        this.aMf = false;
        this.mActivePointerId = -1;
        this.mDuration = AiAppsSlavePool.PRELOAD_NEXT_DELAY_MS;
        initViewPager();
    }

    private void initViewPager() {
        this.mTouchSlop = ViewConfiguration.get(getContext()).getScaledPagingTouchSlop();
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        this.aMe = z;
        super.requestDisallowInterceptTouchEvent(z);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (r(motionEvent)) {
            return true;
        }
        if (motionEvent.getPointerCount() > 1 && this.aMe) {
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
        if (this.aMf) {
            return false;
        }
        if (r(motionEvent)) {
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
                    bN(true);
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
                        bN(false);
                        return false;
                    } else if (abs > 0.0f && abs > abs2 && getCurrentItem() != 0) {
                        bN(true);
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
        if (this.aMf) {
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
                    bN(true);
                    break;
                }
                break;
            case 1:
            case 3:
                bN(false);
                break;
            case 2:
                int i = this.mActivePointerId;
                if (i != -1 && (findPointerIndex = motionEvent.findPointerIndex(i)) != -1 && findPointerIndex < motionEvent.getPointerCount()) {
                    float x2 = motionEvent.getX(findPointerIndex) - this.mLastMotionX;
                    float abs = Math.abs(x2);
                    float abs2 = Math.abs(motionEvent.getY(findPointerIndex) - this.mInitialMotionY);
                    if (x2 > 0.0f && abs > abs2 && getCurrentItem() == 0 && getScrollState() == 0) {
                        bN(false);
                        return false;
                    } else if (abs > 0.0f && abs > abs2 && getCurrentItem() != 0) {
                        bN(true);
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
        if (r(motionEvent)) {
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

    private boolean r(MotionEvent motionEvent) {
        int action = (motionEvent.getAction() & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
        return motionEvent.getPointerId(action) == -1 || action == -1 || action >= motionEvent.getPointerCount();
    }

    public void bN(boolean z) {
        if (getParent() != null) {
            getParent().requestDisallowInterceptTouchEvent(z);
        }
    }

    public void setmDisallowSlip(boolean z) {
        this.aMf = z;
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
        private int aMg;

        public a(Context context) {
            super(context);
            this.aMg = 1000;
        }

        @Override // android.widget.Scroller
        public void startScroll(int i, int i2, int i3, int i4, int i5) {
            super.startScroll(i, i2, i3, i4, this.aMg);
        }

        @Override // android.widget.Scroller
        public void startScroll(int i, int i2, int i3, int i4) {
            super.startScroll(i, i2, i3, i4, this.aMg);
        }

        public void b(ViewPager viewPager) {
            try {
                Field declaredField = ViewPager.class.getDeclaredField("mScroller");
                declaredField.setAccessible(true);
                declaredField.set(viewPager, this);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public void eH(int i) {
            this.aMg = i;
        }
    }
}
