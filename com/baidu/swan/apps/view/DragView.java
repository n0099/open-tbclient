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
    public ViewDragHelper f11326e;

    /* renamed from: f  reason: collision with root package name */
    public View f11327f;

    /* renamed from: g  reason: collision with root package name */
    public int f11328g;

    /* renamed from: h  reason: collision with root package name */
    public int f11329h;

    /* renamed from: i  reason: collision with root package name */
    public int f11330i;
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
        public int clampViewPositionVertical(View view, int i2, int i3) {
            return i2 < DragView.this.o ? DragView.this.o : i2;
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int getViewVerticalDragRange(View view) {
            return DragView.this.getMeasuredWidth();
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewPositionChanged(View view, int i2, int i3, int i4, int i5) {
            super.onViewPositionChanged(view, i2, i3, i4, i5);
            if (DragView.this.k != null) {
                DragView.this.k.onClosing(i3 - DragView.this.f11329h);
            }
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewReleased(View view, float f2, float f3) {
            if (DragView.this.f11327f == null) {
                return;
            }
            int top = DragView.this.f11327f.getTop() - DragView.this.f11329h;
            if (Math.abs(top) <= DragView.this.l) {
                DragView.this.f11326e.smoothSlideViewTo(DragView.this.getChildAt(0), DragView.this.f11328g, DragView.this.f11329h);
            } else if (top < 0) {
                DragView.this.f11326e.smoothSlideViewTo(DragView.this.getChildAt(0), 0, -DragView.this.f11327f.getMeasuredHeight());
            } else {
                DragView.this.f11326e.smoothSlideViewTo(DragView.this.getChildAt(0), 0, DragView.this.f11327f.getMeasuredHeight());
            }
            DragView.this.postInvalidate();
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public boolean tryCaptureView(View view, int i2) {
            return DragView.this.n;
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void onClose();

        void onClosing(int i2);

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
        this.f11327f = view;
    }

    @Override // android.view.View
    public void computeScroll() {
        b bVar;
        if (this.f11326e.continueSettling(true)) {
            ViewCompat.postInvalidateOnAnimation(this);
            return;
        }
        View view = this.f11327f;
        if (view == null || Math.abs(view.getTop() - this.f11329h) < this.l || (bVar = this.k) == null) {
            return;
        }
        bVar.onClose();
    }

    public final void i() {
        this.f11326e = ViewDragHelper.create(this, this.m, new a());
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        this.f11327f = getChildAt(0);
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
            if (action == 2 && Math.abs(y - this.j) <= Math.abs(x - this.f11330i)) {
                return false;
            }
        } else {
            this.f11330i = x;
            this.j = y;
        }
        try {
            return this.f11326e.shouldInterceptTouchEvent(motionEvent);
        } catch (ArrayIndexOutOfBoundsException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        this.f11328g = getLeft();
        this.f11329h = getTop();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.n) {
            this.f11326e.processTouchEvent(motionEvent);
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

    public void setTopMinValue(int i2) {
        this.o = i2;
    }

    public DragView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.l = 300;
        this.m = 0.5f;
        this.n = true;
        this.o = Integer.MIN_VALUE;
        i();
    }

    public DragView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.l = 300;
        this.m = 0.5f;
        this.n = true;
        this.o = Integer.MIN_VALUE;
        i();
    }
}
