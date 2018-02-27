package com.baidu.adp.lib.guide;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.v4.internal.view.SupportMenu;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends ViewGroup {
    private boolean aij;
    private final RectF aip;
    private final RectF aiq;
    private final RectF air;
    private final Paint ais;
    private final Path ait;
    private boolean aiu;
    private final Paint aiv;
    private final Paint mPaint;

    public e(Context context) {
        this(context, null, 0);
    }

    public e(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aip = new RectF();
        this.aiq = new RectF();
        this.air = new RectF();
        this.ais = new Paint();
        this.ait = new Path();
        this.aij = false;
        this.aiv = new Paint();
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.aiv.setColor(SupportMenu.CATEGORY_MASK);
        this.aiv.setStrokeWidth(10.0f);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        setFocusable(true);
        setFocusableInTouchMode(true);
        requestFocus();
        this.ait.setFillType(Path.FillType.EVEN_ODD);
        mE();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        try {
            clearFocus();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int i3 = i & 1073741823;
        int i4 = i2 & 1073741823;
        setMeasuredDimension(i3, i4);
        if (!this.aiu) {
            this.aiq.set(0.0f, 0.0f, i3, i4);
            mE();
        }
        int childCount = getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (childAt != null) {
                a aVar = (a) childAt.getLayoutParams();
                if (aVar == null) {
                    childAt.setLayoutParams(aVar);
                }
                measureChild(childAt, i3 - 2147483648, i4 - 2147483648);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        a aVar;
        int childCount = getChildCount();
        float f = getResources().getDisplayMetrics().density;
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (childAt != null && (aVar = (a) childAt.getLayoutParams()) != null) {
                switch (aVar.aiw) {
                    case 1:
                        this.air.right = this.aip.left;
                        this.air.left = this.air.right - childAt.getMeasuredWidth();
                        b(childAt, this.air, aVar.aix);
                        break;
                    case 2:
                        this.air.bottom = this.aip.top;
                        this.air.top = this.air.bottom - childAt.getMeasuredHeight();
                        a(childAt, this.air, aVar.aix);
                        break;
                    case 3:
                        this.air.left = this.aip.right;
                        this.air.right = this.air.left + childAt.getMeasuredWidth();
                        b(childAt, this.air, aVar.aix);
                        break;
                    case 4:
                        this.air.top = this.aip.bottom;
                        this.air.bottom = this.air.top + childAt.getMeasuredHeight();
                        a(childAt, this.air, aVar.aix);
                        break;
                    case 5:
                        this.air.left = (((int) this.aip.width()) - childAt.getMeasuredWidth()) >> 1;
                        this.air.top = (((int) this.aip.height()) - childAt.getMeasuredHeight()) >> 1;
                        this.air.right = (((int) this.aip.width()) + childAt.getMeasuredWidth()) >> 1;
                        this.air.bottom = (((int) this.aip.height()) + childAt.getMeasuredHeight()) >> 1;
                        this.air.offset(this.aip.left, this.aip.top);
                        break;
                }
                if (this.aij) {
                    this.air.offset(aVar.aiy, aVar.aiz);
                } else {
                    this.air.offset((int) ((aVar.aiy * f) + 0.5f), (int) ((aVar.aiz * f) + 0.5f));
                }
                childAt.layout((int) this.air.left, (int) this.air.top, (int) this.air.right, (int) this.air.bottom);
            }
        }
    }

    public void ai(boolean z) {
        this.aij = z;
    }

    private void a(View view, RectF rectF, int i) {
        switch (i) {
            case 16:
                rectF.left = this.aip.left;
                rectF.right = rectF.left + view.getMeasuredWidth();
                return;
            case 32:
                rectF.left = (this.aip.width() - view.getMeasuredWidth()) / 2.0f;
                rectF.right = (this.aip.width() + view.getMeasuredWidth()) / 2.0f;
                rectF.offset(this.aip.left, 0.0f);
                return;
            case 48:
                rectF.right = this.aip.right;
                rectF.left = rectF.right - view.getMeasuredWidth();
                return;
            default:
                return;
        }
    }

    private void b(View view, RectF rectF, int i) {
        switch (i) {
            case 16:
                rectF.top = this.aip.top;
                rectF.bottom = rectF.top + view.getMeasuredHeight();
                return;
            case 32:
                rectF.top = (this.aip.width() - view.getMeasuredHeight()) / 2.0f;
                rectF.bottom = (this.aip.width() + view.getMeasuredHeight()) / 2.0f;
                rectF.offset(0.0f, this.aip.top);
                return;
            case 48:
                rectF.bottom = this.aip.bottom;
                rectF.top = this.aip.bottom - view.getMeasuredHeight();
                return;
            default:
                return;
        }
    }

    private void mE() {
        this.ait.reset();
        this.ait.addRect(this.aip, Path.Direction.CW);
        this.ait.addRect(this.aiq, Path.Direction.CW);
    }

    public void f(Rect rect) {
        this.aip.set(rect);
        mE();
        invalidate();
    }

    public void g(Rect rect) {
        this.aiq.set(rect);
        mE();
        this.aiu = true;
        invalidate();
    }

    public void cY(int i) {
        this.ais.setAlpha(i);
        invalidate();
    }

    public void cZ(int i) {
        this.ais.setColor(i);
        invalidate();
    }

    public void am(boolean z) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* renamed from: mF */
    public a generateDefaultLayoutParams() {
        return new a(-2, -2);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        long drawingTime = getDrawingTime();
        canvas.save();
        canvas.drawRect(this.aiq, this.ais);
        canvas.restore();
        for (int i = 0; i < getChildCount(); i++) {
            try {
                drawChild(canvas, getChildAt(i), drawingTime);
            } catch (NullPointerException e) {
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a extends ViewGroup.LayoutParams {
        public int aiw;
        public int aix;
        public int aiy;
        public int aiz;

        public a(int i, int i2) {
            super(i, i2);
            this.aiw = 4;
            this.aix = 32;
            this.aiy = 0;
            this.aiz = 0;
        }
    }
}
