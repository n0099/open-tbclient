package com.baidu.tbadk.core.view.viewpager;

import android.content.Context;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
/* loaded from: classes.dex */
public class BdBaseViewPager extends ViewPager {
    private boolean ayT;
    private boolean ayU;
    private int mActivePointerId;
    private float mInitialMotionX;
    private float mInitialMotionY;
    private float mLastMotionX;
    private float mLastMotionY;
    private int mTouchSlop;

    public BdBaseViewPager(Context context) {
        super(context);
        this.ayT = false;
        this.ayU = false;
        this.mActivePointerId = -1;
        initViewPager();
    }

    public BdBaseViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ayT = false;
        this.ayU = false;
        this.mActivePointerId = -1;
        initViewPager();
    }

    private void initViewPager() {
        this.mTouchSlop = ViewConfiguration.get(getContext()).getScaledPagingTouchSlop();
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        this.ayT = z;
        super.requestDisallowInterceptTouchEvent(z);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (q(motionEvent)) {
            return true;
        }
        if (motionEvent.getPointerCount() > 1 && this.ayT) {
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
        if (this.ayU) {
            return false;
        }
        if (q(motionEvent)) {
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
                    aW(true);
                    break;
                }
                break;
            case 2:
                int i = this.mActivePointerId;
                if (i != -1 && (findPointerIndex = motionEvent.findPointerIndex(i)) != -1 && findPointerIndex < motionEvent.getPointerCount()) {
                    float x2 = motionEvent.getX(findPointerIndex) - this.mLastMotionX;
                    float abs = Math.abs(x2);
                    float abs2 = Math.abs(motionEvent.getY(findPointerIndex) - this.mInitialMotionY);
                    if (x2 > 0.0f && abs > abs2 && getCurrentItem() == 0) {
                        aW(false);
                        return false;
                    } else if (abs > 0.0f && abs > abs2 && getCurrentItem() != 0) {
                        aW(true);
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
        if (this.ayU) {
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
                    aW(true);
                    break;
                }
                break;
            case 1:
            case 3:
                aW(false);
                break;
            case 2:
                int i = this.mActivePointerId;
                if (i != -1 && (findPointerIndex = motionEvent.findPointerIndex(i)) != -1 && findPointerIndex < motionEvent.getPointerCount()) {
                    float x2 = motionEvent.getX(findPointerIndex) - this.mLastMotionX;
                    float abs = Math.abs(x2);
                    float abs2 = Math.abs(motionEvent.getY(findPointerIndex) - this.mInitialMotionY);
                    if (x2 > 0.0f && abs > abs2 && getCurrentItem() == 0) {
                        aW(false);
                        return false;
                    } else if (abs > 0.0f && abs > abs2 && getCurrentItem() != 0) {
                        aW(true);
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
        if (q(motionEvent)) {
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

    private boolean q(MotionEvent motionEvent) {
        int action = (motionEvent.getAction() & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
        return motionEvent.getPointerId(action) == -1 || action == -1 || action >= motionEvent.getPointerCount();
    }

    private void aW(boolean z) {
        if (getParent() != null) {
            getParent().requestDisallowInterceptTouchEvent(z);
        }
    }

    public void setmDisallowSlip(boolean z) {
        this.ayU = z;
    }
}
