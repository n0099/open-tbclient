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
    private final Path aiA;
    private boolean aiB;
    private final Paint aiC;
    private final RectF aiw;
    private final RectF aix;
    private final RectF aiy;
    private final Paint aiz;
    private final Paint mPaint;

    public e(Context context) {
        this(context, null, 0);
    }

    public e(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aiw = new RectF();
        this.aix = new RectF();
        this.aiy = new RectF();
        this.aiz = new Paint();
        this.aiA = new Path();
        this.aiC = new Paint();
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.aiC.setColor(SupportMenu.CATEGORY_MASK);
        this.aiC.setStrokeWidth(10.0f);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        setFocusable(true);
        setFocusableInTouchMode(true);
        requestFocus();
        this.aiA.setFillType(Path.FillType.EVEN_ODD);
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
        if (!this.aiB) {
            this.aix.set(0.0f, 0.0f, i3, i4);
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
                switch (aVar.aiD) {
                    case 1:
                        this.aiy.right = this.aiw.left;
                        this.aiy.left = this.aiy.right - childAt.getMeasuredWidth();
                        b(childAt, this.aiy, aVar.aiE);
                        break;
                    case 2:
                        this.aiy.bottom = this.aiw.top;
                        this.aiy.top = this.aiy.bottom - childAt.getMeasuredHeight();
                        a(childAt, this.aiy, aVar.aiE);
                        break;
                    case 3:
                        this.aiy.left = this.aiw.right;
                        this.aiy.right = this.aiy.left + childAt.getMeasuredWidth();
                        b(childAt, this.aiy, aVar.aiE);
                        break;
                    case 4:
                        this.aiy.top = this.aiw.bottom;
                        this.aiy.bottom = this.aiy.top + childAt.getMeasuredHeight();
                        a(childAt, this.aiy, aVar.aiE);
                        break;
                    case 5:
                        this.aiy.left = (((int) this.aiw.width()) - childAt.getMeasuredWidth()) >> 1;
                        this.aiy.top = (((int) this.aiw.height()) - childAt.getMeasuredHeight()) >> 1;
                        this.aiy.right = (((int) this.aiw.width()) + childAt.getMeasuredWidth()) >> 1;
                        this.aiy.bottom = (((int) this.aiw.height()) + childAt.getMeasuredHeight()) >> 1;
                        this.aiy.offset(this.aiw.left, this.aiw.top);
                        break;
                }
                this.aiy.offset((int) ((aVar.aiF * f) + 0.5f), (int) ((aVar.aiG * f) + 0.5f));
                childAt.layout((int) this.aiy.left, (int) this.aiy.top, (int) this.aiy.right, (int) this.aiy.bottom);
            }
        }
    }

    private void a(View view, RectF rectF, int i) {
        switch (i) {
            case 16:
                rectF.left = this.aiw.left;
                rectF.right = rectF.left + view.getMeasuredWidth();
                return;
            case 32:
                rectF.left = (this.aiw.width() - view.getMeasuredWidth()) / 2.0f;
                rectF.right = (this.aiw.width() + view.getMeasuredWidth()) / 2.0f;
                rectF.offset(this.aiw.left, 0.0f);
                return;
            case 48:
                rectF.right = this.aiw.right;
                rectF.left = rectF.right - view.getMeasuredWidth();
                return;
            default:
                return;
        }
    }

    private void b(View view, RectF rectF, int i) {
        switch (i) {
            case 16:
                rectF.top = this.aiw.top;
                rectF.bottom = rectF.top + view.getMeasuredHeight();
                return;
            case 32:
                rectF.top = (this.aiw.width() - view.getMeasuredHeight()) / 2.0f;
                rectF.bottom = (this.aiw.width() + view.getMeasuredHeight()) / 2.0f;
                rectF.offset(0.0f, this.aiw.top);
                return;
            case 48:
                rectF.bottom = this.aiw.bottom;
                rectF.top = this.aiw.bottom - view.getMeasuredHeight();
                return;
            default:
                return;
        }
    }

    private void mE() {
        this.aiA.reset();
        this.aiA.addRect(this.aiw, Path.Direction.CW);
        this.aiA.addRect(this.aix, Path.Direction.CW);
    }

    public void e(Rect rect) {
        this.aiw.set(rect);
        mE();
        invalidate();
    }

    public void f(Rect rect) {
        this.aix.set(rect);
        mE();
        this.aiB = true;
        invalidate();
    }

    public void cY(int i) {
        this.aiz.setAlpha(i);
        invalidate();
    }

    public void cZ(int i) {
        this.aiz.setColor(i);
        invalidate();
    }

    public void aj(boolean z) {
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
        canvas.drawRect(this.aix, this.aiz);
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
        public int aiD;
        public int aiE;
        public int aiF;
        public int aiG;

        public a(int i, int i2) {
            super(i, i2);
            this.aiD = 4;
            this.aiE = 32;
            this.aiF = 0;
            this.aiG = 0;
        }
    }
}
