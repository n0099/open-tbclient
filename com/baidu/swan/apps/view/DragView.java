package com.baidu.swan.apps.view;

import android.content.Context;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.ViewDragHelper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
/* loaded from: classes3.dex */
public class DragView extends FrameLayout {
    private int bdp;
    private int deQ;
    private int deR;
    private a deS;
    private int deT;
    private boolean deU;
    private int deV;
    private View mChildView;
    private int mLastMotionY;
    private float mSensitivity;
    private ViewDragHelper mViewDragHelper;

    /* loaded from: classes3.dex */
    public interface a {
        void it(int i);

        void onClose();

        void z(MotionEvent motionEvent);
    }

    public DragView(Context context) {
        super(context);
        this.deT = 300;
        this.mSensitivity = 0.5f;
        this.deU = true;
        this.deV = Integer.MIN_VALUE;
        init();
    }

    public DragView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.deT = 300;
        this.mSensitivity = 0.5f;
        this.deU = true;
        this.deV = Integer.MIN_VALUE;
        init();
    }

    public DragView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.deT = 300;
        this.mSensitivity = 0.5f;
        this.deU = true;
        this.deV = Integer.MIN_VALUE;
        init();
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        this.mChildView = getChildAt(0);
    }

    @Override // android.view.ViewGroup
    public void addView(View view) {
        super.addView(view);
        this.mChildView = view;
    }

    private void init() {
        this.mViewDragHelper = ViewDragHelper.create(this, this.mSensitivity, new ViewDragHelper.Callback() { // from class: com.baidu.swan.apps.view.DragView.1
            @Override // android.support.v4.widget.ViewDragHelper.Callback
            public void onViewReleased(View view, float f, float f2) {
                if (DragView.this.mChildView != null) {
                    int top = DragView.this.mChildView.getTop() - DragView.this.deR;
                    if (Math.abs(top) <= DragView.this.deT) {
                        DragView.this.mViewDragHelper.smoothSlideViewTo(DragView.this.getChildAt(0), DragView.this.deQ, DragView.this.deR);
                    } else if (top < 0) {
                        DragView.this.mViewDragHelper.smoothSlideViewTo(DragView.this.getChildAt(0), 0, -DragView.this.mChildView.getMeasuredHeight());
                    } else {
                        DragView.this.mViewDragHelper.smoothSlideViewTo(DragView.this.getChildAt(0), 0, DragView.this.mChildView.getMeasuredHeight());
                    }
                    DragView.this.postInvalidate();
                }
            }

            @Override // android.support.v4.widget.ViewDragHelper.Callback
            public void onViewPositionChanged(View view, int i, int i2, int i3, int i4) {
                super.onViewPositionChanged(view, i, i2, i3, i4);
                if (DragView.this.deS != null) {
                    DragView.this.deS.it(i2 - DragView.this.deR);
                }
            }

            @Override // android.support.v4.widget.ViewDragHelper.Callback
            public boolean tryCaptureView(View view, int i) {
                return DragView.this.deU;
            }

            @Override // android.support.v4.widget.ViewDragHelper.Callback
            public int getViewVerticalDragRange(View view) {
                return DragView.this.getMeasuredWidth();
            }

            @Override // android.support.v4.widget.ViewDragHelper.Callback
            public int clampViewPositionVertical(View view, int i, int i2) {
                if (i < DragView.this.deV) {
                    return DragView.this.deV;
                }
                return i;
            }
        });
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.deU) {
            this.mViewDragHelper.processTouchEvent(motionEvent);
            if (this.deS != null) {
                this.deS.z(motionEvent);
            }
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (!this.deU) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction();
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        if (motionEvent.getPointerCount() < 2) {
            switch (action) {
                case 0:
                    this.bdp = x;
                    this.mLastMotionY = y;
                    break;
                case 2:
                    if (Math.abs(y - this.mLastMotionY) <= Math.abs(x - this.bdp)) {
                        return false;
                    }
                    break;
            }
            try {
                return this.mViewDragHelper.shouldInterceptTouchEvent(motionEvent);
            } catch (ArrayIndexOutOfBoundsException e) {
                e.printStackTrace();
                return false;
            }
        }
        return false;
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.mViewDragHelper.continueSettling(true)) {
            ViewCompat.postInvalidateOnAnimation(this);
        } else if (this.mChildView != null && Math.abs(this.mChildView.getTop() - this.deR) >= this.deT && this.deS != null) {
            this.deS.onClose();
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.deQ = getLeft();
        this.deR = getTop();
    }

    public void setOnCloseListener(a aVar) {
        this.deS = aVar;
    }

    public void setTopMinValue(int i) {
        this.deV = i;
    }
}
