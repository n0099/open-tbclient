package com.baidu.adp.lib.guide;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
/* loaded from: classes.dex */
public class MaskView extends ViewGroup {

    /* renamed from: e  reason: collision with root package name */
    public final RectF f2162e;

    /* renamed from: f  reason: collision with root package name */
    public final RectF f2163f;

    /* renamed from: g  reason: collision with root package name */
    public final RectF f2164g;

    /* renamed from: h  reason: collision with root package name */
    public final Paint f2165h;
    public final Path i;
    public boolean j;
    public boolean k;
    public final Paint l;
    public final Paint m;

    public MaskView(Context context) {
        this(context, null, 0);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.view.ViewGroup
    /* renamed from: a */
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    public final void b(View view, RectF rectF, int i) {
        if (i == 16) {
            float f2 = this.f2162e.left;
            rectF.left = f2;
            rectF.right = f2 + view.getMeasuredWidth();
        } else if (i == 32) {
            rectF.left = (this.f2162e.width() - view.getMeasuredWidth()) / 2.0f;
            rectF.right = (this.f2162e.width() + view.getMeasuredWidth()) / 2.0f;
            rectF.offset(this.f2162e.left, 0.0f);
        } else if (i != 48) {
        } else {
            float f3 = this.f2162e.right;
            rectF.right = f3;
            rectF.left = f3 - view.getMeasuredWidth();
        }
    }

    public final void c() {
        this.i.reset();
        this.i.addRect(this.f2162e, Path.Direction.CW);
        this.i.addRect(this.f2163f, Path.Direction.CW);
    }

    public void d(int i) {
        this.f2165h.setAlpha(i);
        invalidate();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        long drawingTime = getDrawingTime();
        canvas.save();
        canvas.drawRect(this.f2163f, this.f2165h);
        canvas.restore();
        for (int i = 0; i < getChildCount(); i++) {
            try {
                drawChild(canvas, getChildAt(i), drawingTime);
            } catch (NullPointerException unused) {
                return;
            }
        }
    }

    public void e(int i) {
        this.f2165h.setColor(i);
        invalidate();
    }

    public void f(Rect rect) {
        this.f2163f.set(rect);
        c();
        this.j = true;
        invalidate();
    }

    public void g(boolean z) {
    }

    public void h(Rect rect) {
        this.f2162e.set(rect);
        c();
        invalidate();
    }

    public void i(boolean z) {
        this.k = z;
    }

    public final void j(View view, RectF rectF, int i) {
        if (i == 16) {
            float f2 = this.f2162e.top;
            rectF.top = f2;
            rectF.bottom = f2 + view.getMeasuredHeight();
        } else if (i == 32) {
            rectF.top = (this.f2162e.width() - view.getMeasuredHeight()) / 2.0f;
            rectF.bottom = (this.f2162e.width() + view.getMeasuredHeight()) / 2.0f;
            rectF.offset(0.0f, this.f2162e.top);
        } else if (i != 48) {
        } else {
            RectF rectF2 = this.f2162e;
            rectF.bottom = rectF2.bottom;
            rectF.top = rectF2.bottom - view.getMeasuredHeight();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        try {
            clearFocus();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        LayoutParams layoutParams;
        int childCount = getChildCount();
        float f2 = getResources().getDisplayMetrics().density;
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (childAt != null && (layoutParams = (LayoutParams) childAt.getLayoutParams()) != null) {
                int i6 = layoutParams.f2166a;
                if (i6 == 1) {
                    RectF rectF = this.f2164g;
                    float f3 = this.f2162e.left;
                    rectF.right = f3;
                    rectF.left = f3 - childAt.getMeasuredWidth();
                    j(childAt, this.f2164g, layoutParams.f2167b);
                } else if (i6 == 2) {
                    RectF rectF2 = this.f2164g;
                    float f4 = this.f2162e.top;
                    rectF2.bottom = f4;
                    rectF2.top = f4 - childAt.getMeasuredHeight();
                    b(childAt, this.f2164g, layoutParams.f2167b);
                } else if (i6 == 3) {
                    RectF rectF3 = this.f2164g;
                    float f5 = this.f2162e.right;
                    rectF3.left = f5;
                    rectF3.right = f5 + childAt.getMeasuredWidth();
                    j(childAt, this.f2164g, layoutParams.f2167b);
                } else if (i6 == 4) {
                    RectF rectF4 = this.f2164g;
                    float f6 = this.f2162e.bottom;
                    rectF4.top = f6;
                    rectF4.bottom = f6 + childAt.getMeasuredHeight();
                    b(childAt, this.f2164g, layoutParams.f2167b);
                } else if (i6 == 5) {
                    this.f2164g.left = (((int) this.f2162e.width()) - childAt.getMeasuredWidth()) >> 1;
                    this.f2164g.top = (((int) this.f2162e.height()) - childAt.getMeasuredHeight()) >> 1;
                    this.f2164g.right = (((int) this.f2162e.width()) + childAt.getMeasuredWidth()) >> 1;
                    this.f2164g.bottom = (((int) this.f2162e.height()) + childAt.getMeasuredHeight()) >> 1;
                    RectF rectF5 = this.f2164g;
                    RectF rectF6 = this.f2162e;
                    rectF5.offset(rectF6.left, rectF6.top);
                }
                if (this.k) {
                    this.f2164g.offset(layoutParams.f2168c, layoutParams.f2169d);
                } else {
                    this.f2164g.offset((int) ((layoutParams.f2168c * f2) + 0.5f), (int) ((layoutParams.f2169d * f2) + 0.5f));
                }
                RectF rectF7 = this.f2164g;
                childAt.layout((int) rectF7.left, (int) rectF7.top, (int) rectF7.right, (int) rectF7.bottom);
            }
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        int i3 = i & 1073741823;
        int i4 = i2 & 1073741823;
        setMeasuredDimension(i3, i4);
        if (!this.j) {
            this.f2163f.set(0.0f, 0.0f, i3, i4);
            c();
        }
        int childCount = getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (childAt != null) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams == null) {
                    childAt.setLayoutParams(layoutParams);
                }
                measureChild(childAt, i3 - 2147483648, Integer.MIN_VALUE + i4);
            }
        }
    }

    public MaskView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MaskView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f2162e = new RectF();
        this.f2163f = new RectF();
        this.f2164g = new RectF();
        this.f2165h = new Paint();
        this.i = new Path();
        this.k = false;
        this.l = new Paint();
        Paint paint = new Paint();
        this.m = paint;
        paint.setAntiAlias(true);
        this.l.setColor(-65536);
        this.l.setStrokeWidth(10.0f);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        setFocusable(true);
        setFocusableInTouchMode(true);
        requestFocus();
        this.i.setFillType(Path.FillType.EVEN_ODD);
        c();
    }

    /* loaded from: classes.dex */
    public static class LayoutParams extends ViewGroup.LayoutParams {

        /* renamed from: a  reason: collision with root package name */
        public int f2166a;

        /* renamed from: b  reason: collision with root package name */
        public int f2167b;

        /* renamed from: c  reason: collision with root package name */
        public int f2168c;

        /* renamed from: d  reason: collision with root package name */
        public int f2169d;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f2166a = 4;
            this.f2167b = 32;
            this.f2168c = 0;
            this.f2169d = 0;
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
            this.f2166a = 4;
            this.f2167b = 32;
            this.f2168c = 0;
            this.f2169d = 0;
        }
    }
}
