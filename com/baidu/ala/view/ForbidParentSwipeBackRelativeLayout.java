package com.baidu.ala.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.RelativeLayout;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.ViewConfigurationCompat;
import com.baidu.adp.widget.SwipeBackLayout;
/* loaded from: classes.dex */
public class ForbidParentSwipeBackRelativeLayout extends RelativeLayout {
    public static final int INVALID_POINTER = -1;
    public boolean isIntercept;
    public int mActivePointerId;
    public float mInitialMotionX;
    public float mInitialMotionY;
    public SwipeBackLayout.c mSwipeControlInterface;
    public int mTouchSlop;

    public ForbidParentSwipeBackRelativeLayout(Context context) {
        super(context);
        this.mActivePointerId = -1;
        this.isIntercept = false;
        init();
    }

    private void determinIntercept(MotionEvent motionEvent) {
        int i2 = this.mActivePointerId;
        int pointerIndex = getPointerIndex(motionEvent, i2);
        if (i2 == -1) {
            return;
        }
        try {
            float x = MotionEventCompat.getX(motionEvent, pointerIndex);
            float y = MotionEventCompat.getY(motionEvent, pointerIndex);
            float abs = Math.abs(x - this.mInitialMotionX);
            float abs2 = Math.abs(y - this.mInitialMotionY);
            if (abs <= this.mTouchSlop || abs <= abs2) {
                return;
            }
            this.isIntercept = true;
        } catch (IllegalArgumentException e2) {
            e2.printStackTrace();
        }
    }

    private int getPointerIndex(MotionEvent motionEvent, int i2) {
        int findPointerIndex = MotionEventCompat.findPointerIndex(motionEvent, i2);
        if (findPointerIndex == -1) {
            this.mActivePointerId = -1;
        }
        return findPointerIndex;
    }

    private void init() {
        this.mTouchSlop = ViewConfigurationCompat.getScaledPagingTouchSlop(ViewConfiguration.get(getContext()));
    }

    @Override // android.view.View
    public boolean onFilterTouchEventForSecurity(MotionEvent motionEvent) {
        if (this.isIntercept) {
            return true;
        }
        int action = motionEvent.getAction() & 255;
        if (action != 3 && action != 1) {
            if (action == 0) {
                int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
                int pointerId = MotionEventCompat.getPointerId(motionEvent, actionIndex);
                this.mActivePointerId = pointerId;
                if (pointerId != -1) {
                    this.mInitialMotionX = MotionEventCompat.getX(motionEvent, actionIndex);
                    this.mInitialMotionY = MotionEventCompat.getY(motionEvent, actionIndex);
                    SwipeBackLayout.c cVar = this.mSwipeControlInterface;
                    if (cVar != null) {
                        cVar.disableSwipeBack();
                    }
                }
            } else if (action != 2) {
                SwipeBackLayout.c cVar2 = this.mSwipeControlInterface;
                if (cVar2 != null) {
                    cVar2.enableSwipeBack();
                }
            } else {
                SwipeBackLayout.c cVar3 = this.mSwipeControlInterface;
                if (cVar3 != null) {
                    cVar3.disableSwipeBack();
                }
                determinIntercept(motionEvent);
                if (this.isIntercept) {
                    return true;
                }
            }
            return super.onFilterTouchEventForSecurity(motionEvent);
        }
        this.isIntercept = false;
        SwipeBackLayout.c cVar4 = this.mSwipeControlInterface;
        if (cVar4 != null) {
            cVar4.enableSwipeBack();
        }
        return super.onFilterTouchEventForSecurity(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.mActivePointerId = MotionEventCompat.getPointerId(motionEvent, MotionEventCompat.getActionIndex(motionEvent));
            SwipeBackLayout.c cVar = this.mSwipeControlInterface;
            if (cVar != null) {
                cVar.disableSwipeBack();
            }
        } else if (action == 1) {
            this.isIntercept = false;
            SwipeBackLayout.c cVar2 = this.mSwipeControlInterface;
            if (cVar2 != null) {
                cVar2.enableSwipeBack();
            }
        } else if (action != 2) {
            SwipeBackLayout.c cVar3 = this.mSwipeControlInterface;
            if (cVar3 != null) {
                cVar3.enableSwipeBack();
            }
        } else {
            SwipeBackLayout.c cVar4 = this.mSwipeControlInterface;
            if (cVar4 != null) {
                cVar4.disableSwipeBack();
            }
            if (!this.isIntercept) {
                determinIntercept(motionEvent);
            }
            if (this.isIntercept && getParent() != null) {
                getParent().requestDisallowInterceptTouchEvent(true);
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setSwipeControlInterface(SwipeBackLayout.c cVar) {
        this.mSwipeControlInterface = cVar;
    }

    public ForbidParentSwipeBackRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mActivePointerId = -1;
        this.isIntercept = false;
        init();
    }

    public ForbidParentSwipeBackRelativeLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.mActivePointerId = -1;
        this.isIntercept = false;
        init();
    }
}
