package com.baidu.live.view;

import android.content.Context;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.ViewConfigurationCompat;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.RelativeLayout;
import com.baidu.live.adp.widget.SwipeBackLayout;
/* loaded from: classes7.dex */
public class ForbidParentSwipeBackRelativeLayout extends RelativeLayout {
    private SwipeBackLayout.SwipeControlInterface btA;
    private boolean isIntercept;
    private int mActivePointerId;
    private float mInitialMotionX;
    private float mInitialMotionY;
    private int mTouchSlop;

    public ForbidParentSwipeBackRelativeLayout(Context context) {
        super(context);
        this.mActivePointerId = -1;
        this.isIntercept = false;
        init();
    }

    public ForbidParentSwipeBackRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mActivePointerId = -1;
        this.isIntercept = false;
        init();
    }

    public ForbidParentSwipeBackRelativeLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mActivePointerId = -1;
        this.isIntercept = false;
        init();
    }

    private void init() {
        this.mTouchSlop = ViewConfigurationCompat.getScaledPagingTouchSlop(ViewConfiguration.get(getContext()));
    }

    public void setSwipeControlInterface(SwipeBackLayout.SwipeControlInterface swipeControlInterface) {
        this.btA = swipeControlInterface;
    }

    @Override // android.view.View
    public boolean onFilterTouchEventForSecurity(MotionEvent motionEvent) {
        if (this.isIntercept) {
            return true;
        }
        int action = motionEvent.getAction() & 255;
        if (action == 3 || action == 1) {
            this.isIntercept = false;
            if (this.btA != null) {
                this.btA.enableSwipeBack();
            }
            return super.onFilterTouchEventForSecurity(motionEvent);
        }
        switch (action) {
            case 0:
                int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
                this.mActivePointerId = MotionEventCompat.getPointerId(motionEvent, actionIndex);
                if (this.mActivePointerId != -1) {
                    this.mInitialMotionX = MotionEventCompat.getX(motionEvent, actionIndex);
                    this.mInitialMotionY = MotionEventCompat.getY(motionEvent, actionIndex);
                    if (this.btA != null) {
                        this.btA.disableSwipeBack();
                        break;
                    }
                }
                break;
            case 1:
            default:
                if (this.btA != null) {
                    this.btA.enableSwipeBack();
                    break;
                }
                break;
            case 2:
                if (this.btA != null) {
                    this.btA.disableSwipeBack();
                }
                determinIntercept(motionEvent);
                if (this.isIntercept) {
                    return true;
                }
                break;
        }
        return super.onFilterTouchEventForSecurity(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.mActivePointerId = MotionEventCompat.getPointerId(motionEvent, MotionEventCompat.getActionIndex(motionEvent));
                if (this.btA != null) {
                    this.btA.disableSwipeBack();
                    break;
                }
                break;
            case 1:
                this.isIntercept = false;
                if (this.btA != null) {
                    this.btA.enableSwipeBack();
                    break;
                }
                break;
            case 2:
                if (this.btA != null) {
                    this.btA.disableSwipeBack();
                }
                if (!this.isIntercept) {
                    determinIntercept(motionEvent);
                }
                if (this.isIntercept && getParent() != null) {
                    getParent().requestDisallowInterceptTouchEvent(true);
                    break;
                }
                break;
            default:
                if (this.btA != null) {
                    this.btA.enableSwipeBack();
                    break;
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    private void determinIntercept(MotionEvent motionEvent) {
        int i = this.mActivePointerId;
        int pointerIndex = getPointerIndex(motionEvent, i);
        if (i != -1) {
            try {
                float x = MotionEventCompat.getX(motionEvent, pointerIndex);
                float y = MotionEventCompat.getY(motionEvent, pointerIndex);
                float abs = Math.abs(x - this.mInitialMotionX);
                float abs2 = Math.abs(y - this.mInitialMotionY);
                if (abs > this.mTouchSlop && abs > abs2) {
                    this.isIntercept = true;
                }
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            }
        }
    }

    private int getPointerIndex(MotionEvent motionEvent, int i) {
        int findPointerIndex = MotionEventCompat.findPointerIndex(motionEvent, i);
        if (findPointerIndex == -1) {
            this.mActivePointerId = -1;
        }
        return findPointerIndex;
    }
}
