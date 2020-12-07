package com.baidu.swan.apps.view;

import android.content.Context;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.ViewDragHelper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
/* loaded from: classes25.dex */
public class DragView extends FrameLayout {
    private int bmn;
    private int dKF;
    private int dKG;
    private a dKH;
    private int dKI;
    private boolean dKJ;
    private int dKK;
    private View mChildView;
    private int mLastMotionY;
    private float mSensitivity;
    private ViewDragHelper mViewDragHelper;

    /* loaded from: classes25.dex */
    public interface a {
        void jF(int i);

        void onClose();

        void z(MotionEvent motionEvent);
    }

    public DragView(Context context) {
        super(context);
        this.dKI = 300;
        this.mSensitivity = 0.5f;
        this.dKJ = true;
        this.dKK = Integer.MIN_VALUE;
        init();
    }

    public DragView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dKI = 300;
        this.mSensitivity = 0.5f;
        this.dKJ = true;
        this.dKK = Integer.MIN_VALUE;
        init();
    }

    public DragView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dKI = 300;
        this.mSensitivity = 0.5f;
        this.dKJ = true;
        this.dKK = Integer.MIN_VALUE;
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
                    int top = DragView.this.mChildView.getTop() - DragView.this.dKG;
                    if (Math.abs(top) <= DragView.this.dKI) {
                        DragView.this.mViewDragHelper.smoothSlideViewTo(DragView.this.getChildAt(0), DragView.this.dKF, DragView.this.dKG);
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
                if (DragView.this.dKH != null) {
                    DragView.this.dKH.jF(i2 - DragView.this.dKG);
                }
            }

            @Override // android.support.v4.widget.ViewDragHelper.Callback
            public boolean tryCaptureView(View view, int i) {
                return DragView.this.dKJ;
            }

            @Override // android.support.v4.widget.ViewDragHelper.Callback
            public int getViewVerticalDragRange(View view) {
                return DragView.this.getMeasuredWidth();
            }

            @Override // android.support.v4.widget.ViewDragHelper.Callback
            public int clampViewPositionVertical(View view, int i, int i2) {
                if (i < DragView.this.dKK) {
                    return DragView.this.dKK;
                }
                return i;
            }
        });
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.dKJ) {
            this.mViewDragHelper.processTouchEvent(motionEvent);
            if (this.dKH != null) {
                this.dKH.z(motionEvent);
            }
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (!this.dKJ) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction();
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        if (motionEvent.getPointerCount() < 2) {
            switch (action) {
                case 0:
                    this.bmn = x;
                    this.mLastMotionY = y;
                    break;
                case 2:
                    if (Math.abs(y - this.mLastMotionY) <= Math.abs(x - this.bmn)) {
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
        } else if (this.mChildView != null && Math.abs(this.mChildView.getTop() - this.dKG) >= this.dKI && this.dKH != null) {
            this.dKH.onClose();
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.dKF = getLeft();
        this.dKG = getTop();
    }

    public void setOnCloseListener(a aVar) {
        this.dKH = aVar;
    }

    public void setTopMinValue(int i) {
        this.dKK = i;
    }
}
