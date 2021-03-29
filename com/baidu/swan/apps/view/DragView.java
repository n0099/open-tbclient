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

    /* renamed from: e  reason: collision with root package name */
    public ViewDragHelper f12676e;

    /* renamed from: f  reason: collision with root package name */
    public View f12677f;

    /* renamed from: g  reason: collision with root package name */
    public int f12678g;

    /* renamed from: h  reason: collision with root package name */
    public int f12679h;
    public int i;
    public int j;
    public b k;
    public int l;
    public float m;
    public boolean n;
    public int o;

    /* loaded from: classes3.dex */
    public class a extends ViewDragHelper.Callback {
        public a() {
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int clampViewPositionVertical(View view, int i, int i2) {
            return i < DragView.this.o ? DragView.this.o : i;
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int getViewVerticalDragRange(View view) {
            return DragView.this.getMeasuredWidth();
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewPositionChanged(View view, int i, int i2, int i3, int i4) {
            super.onViewPositionChanged(view, i, i2, i3, i4);
            if (DragView.this.k != null) {
                DragView.this.k.onClosing(i2 - DragView.this.f12679h);
            }
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewReleased(View view, float f2, float f3) {
            if (DragView.this.f12677f == null) {
                return;
            }
            int top = DragView.this.f12677f.getTop() - DragView.this.f12679h;
            if (Math.abs(top) <= DragView.this.l) {
                DragView.this.f12676e.smoothSlideViewTo(DragView.this.getChildAt(0), DragView.this.f12678g, DragView.this.f12679h);
            } else if (top < 0) {
                DragView.this.f12676e.smoothSlideViewTo(DragView.this.getChildAt(0), 0, -DragView.this.f12677f.getMeasuredHeight());
            } else {
                DragView.this.f12676e.smoothSlideViewTo(DragView.this.getChildAt(0), 0, DragView.this.f12677f.getMeasuredHeight());
            }
            DragView.this.postInvalidate();
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public boolean tryCaptureView(View view, int i) {
            return DragView.this.n;
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void onClose();

        void onClosing(int i);

        void onDragViewTouchEvent(MotionEvent motionEvent);
    }

    public DragView(Context context) {
        super(context);
        this.l = 300;
        this.m = 0.5f;
        this.n = true;
        this.o = Integer.MIN_VALUE;
        i();
    }

    @Override // android.view.ViewGroup
    public void addView(View view) {
        super.addView(view);
        this.f12677f = view;
    }

    @Override // android.view.View
    public void computeScroll() {
        b bVar;
        if (this.f12676e.continueSettling(true)) {
            ViewCompat.postInvalidateOnAnimation(this);
            return;
        }
        View view = this.f12677f;
        if (view == null || Math.abs(view.getTop() - this.f12679h) < this.l || (bVar = this.k) == null) {
            return;
        }
        bVar.onClose();
    }

    public final void i() {
        this.f12676e = ViewDragHelper.create(this, this.m, new a());
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        this.f12677f = getChildAt(0);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (!this.n) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction();
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        if (motionEvent.getPointerCount() >= 2) {
            return false;
        }
        if (action != 0) {
            if (action == 2 && Math.abs(y - this.j) <= Math.abs(x - this.i)) {
                return false;
            }
        } else {
            this.i = x;
            this.j = y;
        }
        try {
            return this.f12676e.shouldInterceptTouchEvent(motionEvent);
        } catch (ArrayIndexOutOfBoundsException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.f12678g = getLeft();
        this.f12679h = getTop();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.n) {
            this.f12676e.processTouchEvent(motionEvent);
            b bVar = this.k;
            if (bVar != null) {
                bVar.onDragViewTouchEvent(motionEvent);
                return true;
            }
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setOnCloseListener(b bVar) {
        this.k = bVar;
    }

    public void setTopMinValue(int i) {
        this.o = i;
    }

    public DragView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.l = 300;
        this.m = 0.5f;
        this.n = true;
        this.o = Integer.MIN_VALUE;
        i();
    }

    public DragView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.l = 300;
        this.m = 0.5f;
        this.n = true;
        this.o = Integer.MIN_VALUE;
        i();
    }
}
