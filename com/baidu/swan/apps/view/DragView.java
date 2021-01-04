package com.baidu.swan.apps.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import androidx.core.view.ViewCompat;
import androidx.customview.widget.ViewDragHelper;
/* loaded from: classes9.dex */
public class DragView extends FrameLayout {
    private int bnS;
    private ViewDragHelper dTp;
    private int dTq;
    private int dTr;
    private a dTs;
    private int dTt;
    private boolean dTu;
    private int dTv;
    private View mChildView;
    private int mLastMotionY;
    private float mSensitivity;

    /* loaded from: classes9.dex */
    public interface a {
        void jA(int i);

        void onClose();

        void z(MotionEvent motionEvent);
    }

    public DragView(Context context) {
        super(context);
        this.dTt = 300;
        this.mSensitivity = 0.5f;
        this.dTu = true;
        this.dTv = Integer.MIN_VALUE;
        init();
    }

    public DragView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dTt = 300;
        this.mSensitivity = 0.5f;
        this.dTu = true;
        this.dTv = Integer.MIN_VALUE;
        init();
    }

    public DragView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dTt = 300;
        this.mSensitivity = 0.5f;
        this.dTu = true;
        this.dTv = Integer.MIN_VALUE;
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
        this.dTp = ViewDragHelper.create(this, this.mSensitivity, new ViewDragHelper.Callback() { // from class: com.baidu.swan.apps.view.DragView.1
            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public void onViewReleased(View view, float f, float f2) {
                if (DragView.this.mChildView != null) {
                    int top = DragView.this.mChildView.getTop() - DragView.this.dTr;
                    if (Math.abs(top) <= DragView.this.dTt) {
                        DragView.this.dTp.smoothSlideViewTo(DragView.this.getChildAt(0), DragView.this.dTq, DragView.this.dTr);
                    } else if (top < 0) {
                        DragView.this.dTp.smoothSlideViewTo(DragView.this.getChildAt(0), 0, -DragView.this.mChildView.getMeasuredHeight());
                    } else {
                        DragView.this.dTp.smoothSlideViewTo(DragView.this.getChildAt(0), 0, DragView.this.mChildView.getMeasuredHeight());
                    }
                    DragView.this.postInvalidate();
                }
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public void onViewPositionChanged(View view, int i, int i2, int i3, int i4) {
                super.onViewPositionChanged(view, i, i2, i3, i4);
                if (DragView.this.dTs != null) {
                    DragView.this.dTs.jA(i2 - DragView.this.dTr);
                }
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public boolean tryCaptureView(View view, int i) {
                return DragView.this.dTu;
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public int getViewVerticalDragRange(View view) {
                return DragView.this.getMeasuredWidth();
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public int clampViewPositionVertical(View view, int i, int i2) {
                if (i < DragView.this.dTv) {
                    return DragView.this.dTv;
                }
                return i;
            }
        });
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.dTu) {
            this.dTp.processTouchEvent(motionEvent);
            if (this.dTs != null) {
                this.dTs.z(motionEvent);
            }
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (!this.dTu) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction();
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        if (motionEvent.getPointerCount() < 2) {
            switch (action) {
                case 0:
                    this.bnS = x;
                    this.mLastMotionY = y;
                    break;
                case 2:
                    if (Math.abs(y - this.mLastMotionY) <= Math.abs(x - this.bnS)) {
                        return false;
                    }
                    break;
            }
            try {
                return this.dTp.shouldInterceptTouchEvent(motionEvent);
            } catch (ArrayIndexOutOfBoundsException e) {
                e.printStackTrace();
                return false;
            }
        }
        return false;
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.dTp.continueSettling(true)) {
            ViewCompat.postInvalidateOnAnimation(this);
        } else if (this.mChildView != null && Math.abs(this.mChildView.getTop() - this.dTr) >= this.dTt && this.dTs != null) {
            this.dTs.onClose();
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.dTq = getLeft();
        this.dTr = getTop();
    }

    public void setOnCloseListener(a aVar) {
        this.dTs = aVar;
    }

    public void setTopMinValue(int i) {
        this.dTv = i;
    }
}
