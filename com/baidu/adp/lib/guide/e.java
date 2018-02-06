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
    private boolean aiA;
    private final Paint aiB;
    private boolean aip;
    private final RectF aiv;
    private final RectF aiw;
    private final RectF aix;
    private final Paint aiy;
    private final Path aiz;
    private final Paint mPaint;

    public e(Context context) {
        this(context, null, 0);
    }

    public e(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aiv = new RectF();
        this.aiw = new RectF();
        this.aix = new RectF();
        this.aiy = new Paint();
        this.aiz = new Path();
        this.aip = false;
        this.aiB = new Paint();
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.aiB.setColor(SupportMenu.CATEGORY_MASK);
        this.aiB.setStrokeWidth(10.0f);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        setFocusable(true);
        setFocusableInTouchMode(true);
        requestFocus();
        this.aiz.setFillType(Path.FillType.EVEN_ODD);
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
        if (!this.aiA) {
            this.aiw.set(0.0f, 0.0f, i3, i4);
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
                switch (aVar.aiC) {
                    case 1:
                        this.aix.right = this.aiv.left;
                        this.aix.left = this.aix.right - childAt.getMeasuredWidth();
                        b(childAt, this.aix, aVar.aiD);
                        break;
                    case 2:
                        this.aix.bottom = this.aiv.top;
                        this.aix.top = this.aix.bottom - childAt.getMeasuredHeight();
                        a(childAt, this.aix, aVar.aiD);
                        break;
                    case 3:
                        this.aix.left = this.aiv.right;
                        this.aix.right = this.aix.left + childAt.getMeasuredWidth();
                        b(childAt, this.aix, aVar.aiD);
                        break;
                    case 4:
                        this.aix.top = this.aiv.bottom;
                        this.aix.bottom = this.aix.top + childAt.getMeasuredHeight();
                        a(childAt, this.aix, aVar.aiD);
                        break;
                    case 5:
                        this.aix.left = (((int) this.aiv.width()) - childAt.getMeasuredWidth()) >> 1;
                        this.aix.top = (((int) this.aiv.height()) - childAt.getMeasuredHeight()) >> 1;
                        this.aix.right = (((int) this.aiv.width()) + childAt.getMeasuredWidth()) >> 1;
                        this.aix.bottom = (((int) this.aiv.height()) + childAt.getMeasuredHeight()) >> 1;
                        this.aix.offset(this.aiv.left, this.aiv.top);
                        break;
                }
                if (this.aip) {
                    this.aix.offset(aVar.aiE, aVar.aiF);
                } else {
                    this.aix.offset((int) ((aVar.aiE * f) + 0.5f), (int) ((aVar.aiF * f) + 0.5f));
                }
                childAt.layout((int) this.aix.left, (int) this.aix.top, (int) this.aix.right, (int) this.aix.bottom);
            }
        }
    }

    public void ai(boolean z) {
        this.aip = z;
    }

    private void a(View view, RectF rectF, int i) {
        switch (i) {
            case 16:
                rectF.left = this.aiv.left;
                rectF.right = rectF.left + view.getMeasuredWidth();
                return;
            case 32:
                rectF.left = (this.aiv.width() - view.getMeasuredWidth()) / 2.0f;
                rectF.right = (this.aiv.width() + view.getMeasuredWidth()) / 2.0f;
                rectF.offset(this.aiv.left, 0.0f);
                return;
            case 48:
                rectF.right = this.aiv.right;
                rectF.left = rectF.right - view.getMeasuredWidth();
                return;
            default:
                return;
        }
    }

    private void b(View view, RectF rectF, int i) {
        switch (i) {
            case 16:
                rectF.top = this.aiv.top;
                rectF.bottom = rectF.top + view.getMeasuredHeight();
                return;
            case 32:
                rectF.top = (this.aiv.width() - view.getMeasuredHeight()) / 2.0f;
                rectF.bottom = (this.aiv.width() + view.getMeasuredHeight()) / 2.0f;
                rectF.offset(0.0f, this.aiv.top);
                return;
            case 48:
                rectF.bottom = this.aiv.bottom;
                rectF.top = this.aiv.bottom - view.getMeasuredHeight();
                return;
            default:
                return;
        }
    }

    private void mE() {
        this.aiz.reset();
        this.aiz.addRect(this.aiv, Path.Direction.CW);
        this.aiz.addRect(this.aiw, Path.Direction.CW);
    }

    public void f(Rect rect) {
        this.aiv.set(rect);
        mE();
        invalidate();
    }

    public void g(Rect rect) {
        this.aiw.set(rect);
        mE();
        this.aiA = true;
        invalidate();
    }

    public void cY(int i) {
        this.aiy.setAlpha(i);
        invalidate();
    }

    public void cZ(int i) {
        this.aiy.setColor(i);
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
        canvas.drawRect(this.aiw, this.aiy);
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
        public int aiC;
        public int aiD;
        public int aiE;
        public int aiF;

        public a(int i, int i2) {
            super(i, i2);
            this.aiC = 4;
            this.aiD = 32;
            this.aiE = 0;
            this.aiF = 0;
        }
    }
}
