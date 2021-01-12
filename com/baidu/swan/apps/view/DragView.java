package com.baidu.swan.apps.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import androidx.core.view.ViewCompat;
import androidx.customview.widget.ViewDragHelper;
/* loaded from: classes8.dex */
public class DragView extends FrameLayout {
    private int bjf;
    private ViewDragHelper dOD;
    private int dOE;
    private int dOF;
    private a dOG;
    private int dOH;
    private boolean dOI;
    private int dOJ;
    private View mChildView;
    private int mLastMotionY;
    private float mSensitivity;

    /* loaded from: classes8.dex */
    public interface a {
        void hU(int i);

        void onClose();

        void z(MotionEvent motionEvent);
    }

    public DragView(Context context) {
        super(context);
        this.dOH = 300;
        this.mSensitivity = 0.5f;
        this.dOI = true;
        this.dOJ = Integer.MIN_VALUE;
        init();
    }

    public DragView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dOH = 300;
        this.mSensitivity = 0.5f;
        this.dOI = true;
        this.dOJ = Integer.MIN_VALUE;
        init();
    }

    public DragView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dOH = 300;
        this.mSensitivity = 0.5f;
        this.dOI = true;
        this.dOJ = Integer.MIN_VALUE;
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
        this.dOD = ViewDragHelper.create(this, this.mSensitivity, new ViewDragHelper.Callback() { // from class: com.baidu.swan.apps.view.DragView.1
            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public void onViewReleased(View view, float f, float f2) {
                if (DragView.this.mChildView != null) {
                    int top = DragView.this.mChildView.getTop() - DragView.this.dOF;
                    if (Math.abs(top) <= DragView.this.dOH) {
                        DragView.this.dOD.smoothSlideViewTo(DragView.this.getChildAt(0), DragView.this.dOE, DragView.this.dOF);
                    } else if (top < 0) {
                        DragView.this.dOD.smoothSlideViewTo(DragView.this.getChildAt(0), 0, -DragView.this.mChildView.getMeasuredHeight());
                    } else {
                        DragView.this.dOD.smoothSlideViewTo(DragView.this.getChildAt(0), 0, DragView.this.mChildView.getMeasuredHeight());
                    }
                    DragView.this.postInvalidate();
                }
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public void onViewPositionChanged(View view, int i, int i2, int i3, int i4) {
                super.onViewPositionChanged(view, i, i2, i3, i4);
                if (DragView.this.dOG != null) {
                    DragView.this.dOG.hU(i2 - DragView.this.dOF);
                }
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public boolean tryCaptureView(View view, int i) {
                return DragView.this.dOI;
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public int getViewVerticalDragRange(View view) {
                return DragView.this.getMeasuredWidth();
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public int clampViewPositionVertical(View view, int i, int i2) {
                if (i < DragView.this.dOJ) {
                    return DragView.this.dOJ;
                }
                return i;
            }
        });
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.dOI) {
            this.dOD.processTouchEvent(motionEvent);
            if (this.dOG != null) {
                this.dOG.z(motionEvent);
            }
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (!this.dOI) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction();
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        if (motionEvent.getPointerCount() < 2) {
            switch (action) {
                case 0:
                    this.bjf = x;
                    this.mLastMotionY = y;
                    break;
                case 2:
                    if (Math.abs(y - this.mLastMotionY) <= Math.abs(x - this.bjf)) {
                        return false;
                    }
                    break;
            }
            try {
                return this.dOD.shouldInterceptTouchEvent(motionEvent);
            } catch (ArrayIndexOutOfBoundsException e) {
                e.printStackTrace();
                return false;
            }
        }
        return false;
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.dOD.continueSettling(true)) {
            ViewCompat.postInvalidateOnAnimation(this);
        } else if (this.mChildView != null && Math.abs(this.mChildView.getTop() - this.dOF) >= this.dOH && this.dOG != null) {
            this.dOG.onClose();
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.dOE = getLeft();
        this.dOF = getTop();
    }

    public void setOnCloseListener(a aVar) {
        this.dOG = aVar;
    }

    public void setTopMinValue(int i) {
        this.dOJ = i;
    }
}
