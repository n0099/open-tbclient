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
import protobuf.Im;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i extends ViewGroup {
    private final RectF a;
    private final RectF b;
    private final RectF c;
    private final Paint d;
    private Path e;
    private boolean f;
    private boolean g;
    private Paint h;
    private Paint i;

    public i(Context context) {
        this(context, null, 0);
    }

    public i(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = new RectF();
        this.b = new RectF();
        this.c = new RectF();
        this.d = new Paint();
        this.e = new Path();
        this.h = new Paint();
        this.i = new Paint();
        this.i.setAntiAlias(true);
        this.h.setColor(-65536);
        this.h.setStrokeWidth(10.0f);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        setFocusable(true);
        setFocusableInTouchMode(true);
        requestFocus();
        this.e.setFillType(Path.FillType.EVEN_ODD);
        b();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        clearFocus();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int i3 = i & 1073741823;
        int i4 = i2 & 1073741823;
        setMeasuredDimension(i3, i4);
        if (!this.f) {
            this.b.set(0.0f, 0.0f, i3, i4);
            b();
        }
        int childCount = getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (childAt != null) {
                j jVar = (j) childAt.getLayoutParams();
                if (jVar == null) {
                    childAt.setLayoutParams(jVar);
                }
                measureChild(childAt, i3 - 2147483648, i4 - 2147483648);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        j jVar;
        int childCount = getChildCount();
        float f = getResources().getDisplayMetrics().density;
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (childAt != null && (jVar = (j) childAt.getLayoutParams()) != null) {
                switch (jVar.a) {
                    case 1:
                        this.c.right = this.a.left;
                        this.c.left = this.c.right - childAt.getMeasuredWidth();
                        b(childAt, this.c, jVar.b);
                        break;
                    case 2:
                        this.c.bottom = this.a.top;
                        this.c.top = this.c.bottom - childAt.getMeasuredHeight();
                        a(childAt, this.c, jVar.b);
                        break;
                    case 3:
                        this.c.left = this.a.right;
                        this.c.right = this.c.left + childAt.getMeasuredWidth();
                        b(childAt, this.c, jVar.b);
                        break;
                    case 4:
                        this.c.top = this.a.bottom;
                        this.c.bottom = this.c.top + childAt.getMeasuredHeight();
                        a(childAt, this.c, jVar.b);
                        break;
                    case 5:
                        this.c.left = (((int) this.a.width()) - childAt.getMeasuredWidth()) >> 1;
                        this.c.top = (((int) this.a.height()) - childAt.getMeasuredHeight()) >> 1;
                        this.c.right = (((int) this.a.width()) + childAt.getMeasuredWidth()) >> 1;
                        this.c.bottom = (((int) this.a.height()) + childAt.getMeasuredHeight()) >> 1;
                        this.c.offset(this.a.left, this.a.top);
                        break;
                }
                this.c.offset((int) ((jVar.c * f) + 0.5f), (int) ((jVar.d * f) + 0.5f));
                com.baidu.adp.lib.g.e.e("MaskView", "onLayout", "child layout to: " + this.c);
                childAt.layout((int) this.c.left, (int) this.c.top, (int) this.c.right, (int) this.c.bottom);
            }
        }
    }

    private void a(View view, RectF rectF, int i) {
        switch (i) {
            case 16:
                rectF.left = this.a.left;
                rectF.right = rectF.left + view.getMeasuredWidth();
                return;
            case Im.GroupInfo.ISNEWLYCREATE_FIELD_NUMBER /* 32 */:
                rectF.left = (this.a.width() - view.getMeasuredWidth()) / 2.0f;
                rectF.right = (this.a.width() + view.getMeasuredWidth()) / 2.0f;
                rectF.offset(this.a.left, 0.0f);
                return;
            case 48:
                rectF.right = this.a.right;
                rectF.left = rectF.right - view.getMeasuredWidth();
                return;
            default:
                return;
        }
    }

    private void b(View view, RectF rectF, int i) {
        switch (i) {
            case 16:
                rectF.top = this.a.top;
                rectF.bottom = rectF.top + view.getMeasuredHeight();
                return;
            case Im.GroupInfo.ISNEWLYCREATE_FIELD_NUMBER /* 32 */:
                rectF.top = (this.a.width() - view.getMeasuredHeight()) / 2.0f;
                rectF.bottom = (this.a.width() + view.getMeasuredHeight()) / 2.0f;
                rectF.offset(0.0f, this.a.top);
                return;
            case 48:
                rectF.bottom = this.a.bottom;
                rectF.top = this.a.bottom - view.getMeasuredHeight();
                return;
            default:
                return;
        }
    }

    private void b() {
        this.e.reset();
        this.e.addRect(this.a, Path.Direction.CW);
        com.baidu.adp.lib.g.e.e("MaskView", "resetOutPath", "target rect = " + this.a);
        this.e.addRect(this.b, Path.Direction.CW);
        com.baidu.adp.lib.g.e.e("MaskView", "resetOutPath", "fulling rect = " + this.b);
    }

    public void a(Rect rect) {
        this.a.set(rect);
        b();
        com.baidu.adp.lib.g.e.e("MaskView", "settargetRect", "target rect = " + this.a);
        invalidate();
    }

    public void b(Rect rect) {
        this.b.set(rect);
        b();
        com.baidu.adp.lib.g.e.e("MaskView", "setFullingRect", "fulling rect = " + this.b);
        this.f = true;
        invalidate();
    }

    public void a(int i) {
        this.d.setAlpha(i);
        invalidate();
    }

    public void b(int i) {
        this.d.setColor(i);
        invalidate();
    }

    public void a(boolean z) {
        this.g = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* renamed from: a */
    public j generateDefaultLayoutParams() {
        return new j(-2, -2);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        long drawingTime = getDrawingTime();
        canvas.save();
        canvas.drawRect(this.b, this.d);
        canvas.restore();
        for (int i = 0; i < getChildCount(); i++) {
            try {
                drawChild(canvas, getChildAt(i), drawingTime);
            } catch (NullPointerException e) {
                return;
            }
        }
    }
}
