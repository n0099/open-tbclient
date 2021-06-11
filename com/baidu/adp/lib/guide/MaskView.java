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
import androidx.core.internal.view.SupportMenu;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;
/* loaded from: classes.dex */
public class MaskView extends ViewGroup {

    /* renamed from: e  reason: collision with root package name */
    public final RectF f2181e;

    /* renamed from: f  reason: collision with root package name */
    public final RectF f2182f;

    /* renamed from: g  reason: collision with root package name */
    public final RectF f2183g;

    /* renamed from: h  reason: collision with root package name */
    public final Paint f2184h;

    /* renamed from: i  reason: collision with root package name */
    public final Path f2185i;
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

    public final void b(View view, RectF rectF, int i2) {
        if (i2 == 16) {
            float f2 = this.f2181e.left;
            rectF.left = f2;
            rectF.right = f2 + view.getMeasuredWidth();
        } else if (i2 == 32) {
            rectF.left = (this.f2181e.width() - view.getMeasuredWidth()) / 2.0f;
            rectF.right = (this.f2181e.width() + view.getMeasuredWidth()) / 2.0f;
            rectF.offset(this.f2181e.left, 0.0f);
        } else if (i2 != 48) {
        } else {
            float f3 = this.f2181e.right;
            rectF.right = f3;
            rectF.left = f3 - view.getMeasuredWidth();
        }
    }

    public final void c() {
        this.f2185i.reset();
        this.f2185i.addRect(this.f2181e, Path.Direction.CW);
        this.f2185i.addRect(this.f2182f, Path.Direction.CW);
    }

    public void d(int i2) {
        this.f2184h.setAlpha(i2);
        invalidate();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        long drawingTime = getDrawingTime();
        canvas.save();
        canvas.drawRect(this.f2182f, this.f2184h);
        canvas.restore();
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            try {
                drawChild(canvas, getChildAt(i2), drawingTime);
            } catch (NullPointerException unused) {
                return;
            }
        }
    }

    public void e(int i2) {
        this.f2184h.setColor(i2);
        invalidate();
    }

    public void f(Rect rect) {
        this.f2182f.set(rect);
        c();
        this.j = true;
        invalidate();
    }

    public void g(boolean z) {
    }

    public void h(Rect rect) {
        this.f2181e.set(rect);
        c();
        invalidate();
    }

    public void i(boolean z) {
        this.k = z;
    }

    public final void j(View view, RectF rectF, int i2) {
        if (i2 == 16) {
            float f2 = this.f2181e.top;
            rectF.top = f2;
            rectF.bottom = f2 + view.getMeasuredHeight();
        } else if (i2 == 32) {
            rectF.top = (this.f2181e.width() - view.getMeasuredHeight()) / 2.0f;
            rectF.bottom = (this.f2181e.width() + view.getMeasuredHeight()) / 2.0f;
            rectF.offset(0.0f, this.f2181e.top);
        } else if (i2 != 48) {
        } else {
            RectF rectF2 = this.f2181e;
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
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        LayoutParams layoutParams;
        int childCount = getChildCount();
        float f2 = getResources().getDisplayMetrics().density;
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            if (childAt != null && (layoutParams = (LayoutParams) childAt.getLayoutParams()) != null) {
                int i7 = layoutParams.f2186a;
                if (i7 == 1) {
                    RectF rectF = this.f2183g;
                    float f3 = this.f2181e.left;
                    rectF.right = f3;
                    rectF.left = f3 - childAt.getMeasuredWidth();
                    j(childAt, this.f2183g, layoutParams.f2187b);
                } else if (i7 == 2) {
                    RectF rectF2 = this.f2183g;
                    float f4 = this.f2181e.top;
                    rectF2.bottom = f4;
                    rectF2.top = f4 - childAt.getMeasuredHeight();
                    b(childAt, this.f2183g, layoutParams.f2187b);
                } else if (i7 == 3) {
                    RectF rectF3 = this.f2183g;
                    float f5 = this.f2181e.right;
                    rectF3.left = f5;
                    rectF3.right = f5 + childAt.getMeasuredWidth();
                    j(childAt, this.f2183g, layoutParams.f2187b);
                } else if (i7 == 4) {
                    RectF rectF4 = this.f2183g;
                    float f6 = this.f2181e.bottom;
                    rectF4.top = f6;
                    rectF4.bottom = f6 + childAt.getMeasuredHeight();
                    b(childAt, this.f2183g, layoutParams.f2187b);
                } else if (i7 == 5) {
                    this.f2183g.left = (((int) this.f2181e.width()) - childAt.getMeasuredWidth()) >> 1;
                    this.f2183g.top = (((int) this.f2181e.height()) - childAt.getMeasuredHeight()) >> 1;
                    this.f2183g.right = (((int) this.f2181e.width()) + childAt.getMeasuredWidth()) >> 1;
                    this.f2183g.bottom = (((int) this.f2181e.height()) + childAt.getMeasuredHeight()) >> 1;
                    RectF rectF5 = this.f2183g;
                    RectF rectF6 = this.f2181e;
                    rectF5.offset(rectF6.left, rectF6.top);
                }
                if (this.k) {
                    this.f2183g.offset(layoutParams.f2188c, layoutParams.f2189d);
                } else {
                    this.f2183g.offset((int) ((layoutParams.f2188c * f2) + 0.5f), (int) ((layoutParams.f2189d * f2) + 0.5f));
                }
                RectF rectF7 = this.f2183g;
                childAt.layout((int) rectF7.left, (int) rectF7.top, (int) rectF7.right, (int) rectF7.bottom);
            }
        }
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        int i4 = i2 & LockFreeTaskQueueCore.MAX_CAPACITY_MASK;
        int i5 = i3 & LockFreeTaskQueueCore.MAX_CAPACITY_MASK;
        setMeasuredDimension(i4, i5);
        if (!this.j) {
            this.f2182f.set(0.0f, 0.0f, i4, i5);
            c();
        }
        int childCount = getChildCount();
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            if (childAt != null) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams == null) {
                    childAt.setLayoutParams(layoutParams);
                }
                measureChild(childAt, i4 - 2147483648, Integer.MIN_VALUE + i5);
            }
        }
    }

    public MaskView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MaskView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f2181e = new RectF();
        this.f2182f = new RectF();
        this.f2183g = new RectF();
        this.f2184h = new Paint();
        this.f2185i = new Path();
        this.k = false;
        this.l = new Paint();
        Paint paint = new Paint();
        this.m = paint;
        paint.setAntiAlias(true);
        this.l.setColor(SupportMenu.CATEGORY_MASK);
        this.l.setStrokeWidth(10.0f);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        setFocusable(true);
        setFocusableInTouchMode(true);
        requestFocus();
        this.f2185i.setFillType(Path.FillType.EVEN_ODD);
        c();
    }

    /* loaded from: classes.dex */
    public static class LayoutParams extends ViewGroup.LayoutParams {

        /* renamed from: a  reason: collision with root package name */
        public int f2186a;

        /* renamed from: b  reason: collision with root package name */
        public int f2187b;

        /* renamed from: c  reason: collision with root package name */
        public int f2188c;

        /* renamed from: d  reason: collision with root package name */
        public int f2189d;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f2186a = 4;
            this.f2187b = 32;
            this.f2188c = 0;
            this.f2189d = 0;
        }

        public LayoutParams(int i2, int i3) {
            super(i2, i3);
            this.f2186a = 4;
            this.f2187b = 32;
            this.f2188c = 0;
            this.f2189d = 0;
        }
    }
}
