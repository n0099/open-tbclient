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
    private final RectF ait;
    private final RectF aiu;
    private final RectF aiv;
    private final Paint aiw;
    private final Path aix;
    private boolean aiy;
    private final Paint aiz;
    private final Paint mPaint;

    public e(Context context) {
        this(context, null, 0);
    }

    public e(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ait = new RectF();
        this.aiu = new RectF();
        this.aiv = new RectF();
        this.aiw = new Paint();
        this.aix = new Path();
        this.aiz = new Paint();
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.aiz.setColor(SupportMenu.CATEGORY_MASK);
        this.aiz.setStrokeWidth(10.0f);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        setFocusable(true);
        setFocusableInTouchMode(true);
        requestFocus();
        this.aix.setFillType(Path.FillType.EVEN_ODD);
        mD();
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
        if (!this.aiy) {
            this.aiu.set(0.0f, 0.0f, i3, i4);
            mD();
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
                switch (aVar.aiA) {
                    case 1:
                        this.aiv.right = this.ait.left;
                        this.aiv.left = this.aiv.right - childAt.getMeasuredWidth();
                        b(childAt, this.aiv, aVar.aiB);
                        break;
                    case 2:
                        this.aiv.bottom = this.ait.top;
                        this.aiv.top = this.aiv.bottom - childAt.getMeasuredHeight();
                        a(childAt, this.aiv, aVar.aiB);
                        break;
                    case 3:
                        this.aiv.left = this.ait.right;
                        this.aiv.right = this.aiv.left + childAt.getMeasuredWidth();
                        b(childAt, this.aiv, aVar.aiB);
                        break;
                    case 4:
                        this.aiv.top = this.ait.bottom;
                        this.aiv.bottom = this.aiv.top + childAt.getMeasuredHeight();
                        a(childAt, this.aiv, aVar.aiB);
                        break;
                    case 5:
                        this.aiv.left = (((int) this.ait.width()) - childAt.getMeasuredWidth()) >> 1;
                        this.aiv.top = (((int) this.ait.height()) - childAt.getMeasuredHeight()) >> 1;
                        this.aiv.right = (((int) this.ait.width()) + childAt.getMeasuredWidth()) >> 1;
                        this.aiv.bottom = (((int) this.ait.height()) + childAt.getMeasuredHeight()) >> 1;
                        this.aiv.offset(this.ait.left, this.ait.top);
                        break;
                }
                this.aiv.offset((int) ((aVar.aiC * f) + 0.5f), (int) ((aVar.aiD * f) + 0.5f));
                childAt.layout((int) this.aiv.left, (int) this.aiv.top, (int) this.aiv.right, (int) this.aiv.bottom);
            }
        }
    }

    private void a(View view, RectF rectF, int i) {
        switch (i) {
            case 16:
                rectF.left = this.ait.left;
                rectF.right = rectF.left + view.getMeasuredWidth();
                return;
            case 32:
                rectF.left = (this.ait.width() - view.getMeasuredWidth()) / 2.0f;
                rectF.right = (this.ait.width() + view.getMeasuredWidth()) / 2.0f;
                rectF.offset(this.ait.left, 0.0f);
                return;
            case 48:
                rectF.right = this.ait.right;
                rectF.left = rectF.right - view.getMeasuredWidth();
                return;
            default:
                return;
        }
    }

    private void b(View view, RectF rectF, int i) {
        switch (i) {
            case 16:
                rectF.top = this.ait.top;
                rectF.bottom = rectF.top + view.getMeasuredHeight();
                return;
            case 32:
                rectF.top = (this.ait.width() - view.getMeasuredHeight()) / 2.0f;
                rectF.bottom = (this.ait.width() + view.getMeasuredHeight()) / 2.0f;
                rectF.offset(0.0f, this.ait.top);
                return;
            case 48:
                rectF.bottom = this.ait.bottom;
                rectF.top = this.ait.bottom - view.getMeasuredHeight();
                return;
            default:
                return;
        }
    }

    private void mD() {
        this.aix.reset();
        this.aix.addRect(this.ait, Path.Direction.CW);
        this.aix.addRect(this.aiu, Path.Direction.CW);
    }

    public void e(Rect rect) {
        this.ait.set(rect);
        mD();
        invalidate();
    }

    public void f(Rect rect) {
        this.aiu.set(rect);
        mD();
        this.aiy = true;
        invalidate();
    }

    public void cY(int i) {
        this.aiw.setAlpha(i);
        invalidate();
    }

    public void cZ(int i) {
        this.aiw.setColor(i);
        invalidate();
    }

    public void ai(boolean z) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* renamed from: mE */
    public a generateDefaultLayoutParams() {
        return new a(-2, -2);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        long drawingTime = getDrawingTime();
        canvas.save();
        canvas.drawRect(this.aiu, this.aiw);
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
        public int aiA;
        public int aiB;
        public int aiC;
        public int aiD;

        public a(int i, int i2) {
            super(i, i2);
            this.aiA = 4;
            this.aiB = 32;
            this.aiC = 0;
            this.aiD = 0;
        }
    }
}
