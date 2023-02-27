package com.baidu.swan.apps.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import androidx.core.view.ViewCompat;
import androidx.customview.widget.ViewDragHelper;
/* loaded from: classes3.dex */
public class DragView extends FrameLayout {
    public ViewDragHelper a;
    public View b;
    public int c;
    public int d;
    public int e;
    public int f;
    public b g;
    public int h;
    public float i;
    public boolean j;
    public int k;

    /* loaded from: classes3.dex */
    public interface b {
        void a(int i);

        void f(MotionEvent motionEvent);

        void onClose();
    }

    /* loaded from: classes3.dex */
    public class a extends ViewDragHelper.Callback {
        public a() {
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int getViewVerticalDragRange(View view2) {
            return DragView.this.getMeasuredWidth();
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int clampViewPositionVertical(View view2, int i, int i2) {
            if (i < DragView.this.k) {
                return DragView.this.k;
            }
            return i;
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewPositionChanged(View view2, int i, int i2, int i3, int i4) {
            super.onViewPositionChanged(view2, i, i2, i3, i4);
            if (DragView.this.g != null) {
                DragView.this.g.a(i2 - DragView.this.d);
            }
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewReleased(View view2, float f, float f2) {
            if (DragView.this.b == null) {
                return;
            }
            int top = DragView.this.b.getTop() - DragView.this.d;
            if (Math.abs(top) > DragView.this.h) {
                if (top < 0) {
                    DragView.this.a.smoothSlideViewTo(DragView.this.getChildAt(0), 0, -DragView.this.b.getMeasuredHeight());
                } else {
                    DragView.this.a.smoothSlideViewTo(DragView.this.getChildAt(0), 0, DragView.this.b.getMeasuredHeight());
                }
            } else {
                DragView.this.a.smoothSlideViewTo(DragView.this.getChildAt(0), DragView.this.c, DragView.this.d);
            }
            DragView.this.postInvalidate();
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public boolean tryCaptureView(View view2, int i) {
            return DragView.this.j;
        }
    }

    public DragView(Context context) {
        super(context);
        this.h = 300;
        this.i = 0.5f;
        this.j = true;
        this.k = Integer.MIN_VALUE;
        i();
    }

    @Override // android.view.ViewGroup
    public void addView(View view2) {
        super.addView(view2);
        this.b = view2;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.j) {
            this.a.processTouchEvent(motionEvent);
            b bVar = this.g;
            if (bVar != null) {
                bVar.f(motionEvent);
                return true;
            }
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setOnCloseListener(b bVar) {
        this.g = bVar;
    }

    public void setTopMinValue(int i) {
        this.k = i;
    }

    public DragView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.h = 300;
        this.i = 0.5f;
        this.j = true;
        this.k = Integer.MIN_VALUE;
        i();
    }

    public DragView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.h = 300;
        this.i = 0.5f;
        this.j = true;
        this.k = Integer.MIN_VALUE;
        i();
    }

    @Override // android.view.View
    public void computeScroll() {
        b bVar;
        if (this.a.continueSettling(true)) {
            ViewCompat.postInvalidateOnAnimation(this);
            return;
        }
        View view2 = this.b;
        if (view2 != null && Math.abs(view2.getTop() - this.d) >= this.h && (bVar = this.g) != null) {
            bVar.onClose();
        }
    }

    public final void i() {
        this.a = ViewDragHelper.create(this, this.i, new a());
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        this.b = getChildAt(0);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (!this.j) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction();
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        if (motionEvent.getPointerCount() >= 2) {
            return false;
        }
        if (action != 0) {
            if (action == 2 && Math.abs(y - this.f) <= Math.abs(x - this.e)) {
                return false;
            }
        } else {
            this.e = x;
            this.f = y;
        }
        try {
            return this.a.shouldInterceptTouchEvent(motionEvent);
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.c = getLeft();
        this.d = getTop();
    }
}
