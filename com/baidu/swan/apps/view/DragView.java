package com.baidu.swan.apps.view;

import android.content.Context;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.ViewDragHelper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
/* loaded from: classes11.dex */
public class DragView extends FrameLayout {
    private a bZt;
    private int mAutoCloseDistance;
    private View mChildView;
    private boolean mDragEnabled;
    private int mInitX;
    private int mInitY;
    private int mLastMotionX;
    private int mLastMotionY;
    private float mSensitivity;
    private int mTopMinValue;
    private ViewDragHelper mViewDragHelper;

    /* loaded from: classes11.dex */
    public interface a {
        void onClose();

        void onClosing(int i);

        void onDragViewTouchEvent(MotionEvent motionEvent);
    }

    public DragView(Context context) {
        super(context);
        this.mAutoCloseDistance = 300;
        this.mSensitivity = 0.5f;
        this.mDragEnabled = true;
        this.mTopMinValue = Integer.MIN_VALUE;
        init();
    }

    public DragView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mAutoCloseDistance = 300;
        this.mSensitivity = 0.5f;
        this.mDragEnabled = true;
        this.mTopMinValue = Integer.MIN_VALUE;
        init();
    }

    public DragView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mAutoCloseDistance = 300;
        this.mSensitivity = 0.5f;
        this.mDragEnabled = true;
        this.mTopMinValue = Integer.MIN_VALUE;
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
                    int top2 = DragView.this.mChildView.getTop() - DragView.this.mInitY;
                    if (Math.abs(top2) <= DragView.this.mAutoCloseDistance) {
                        DragView.this.mViewDragHelper.smoothSlideViewTo(DragView.this.getChildAt(0), DragView.this.mInitX, DragView.this.mInitY);
                    } else if (top2 < 0) {
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
                if (DragView.this.bZt != null) {
                    DragView.this.bZt.onClosing(i2 - DragView.this.mInitY);
                }
            }

            @Override // android.support.v4.widget.ViewDragHelper.Callback
            public boolean tryCaptureView(View view, int i) {
                return DragView.this.mDragEnabled;
            }

            @Override // android.support.v4.widget.ViewDragHelper.Callback
            public int getViewVerticalDragRange(View view) {
                return DragView.this.getMeasuredWidth();
            }

            @Override // android.support.v4.widget.ViewDragHelper.Callback
            public int clampViewPositionVertical(View view, int i, int i2) {
                if (i < DragView.this.mTopMinValue) {
                    return DragView.this.mTopMinValue;
                }
                return i;
            }
        });
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.mDragEnabled) {
            this.mViewDragHelper.processTouchEvent(motionEvent);
            if (this.bZt != null) {
                this.bZt.onDragViewTouchEvent(motionEvent);
            }
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (!this.mDragEnabled) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction();
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        if (motionEvent.getPointerCount() < 2) {
            switch (action) {
                case 0:
                    this.mLastMotionX = x;
                    this.mLastMotionY = y;
                    break;
                case 2:
                    if (Math.abs(y - this.mLastMotionY) <= Math.abs(x - this.mLastMotionX)) {
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
        } else if (this.mChildView != null && Math.abs(this.mChildView.getTop() - this.mInitY) >= this.mAutoCloseDistance && this.bZt != null) {
            this.bZt.onClose();
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.mInitX = getLeft();
        this.mInitY = getTop();
    }

    public void setOnCloseListener(a aVar) {
        this.bZt = aVar;
    }

    public void setTopMinValue(int i) {
        this.mTopMinValue = i;
    }
}
