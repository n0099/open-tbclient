package com.baidu.adp.lib.guide;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.v4.internal.view.SupportMenu;
import android.support.v4.widget.ExploreByTouchHelper;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h extends ViewGroup {
    private final Paint mPaint;
    private final Path uA;
    private boolean uB;
    private final Paint uC;
    private final RectF uw;
    private final RectF ux;
    private final RectF uy;
    private final Paint uz;

    public h(Context context) {
        this(context, null, 0);
    }

    public h(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.uw = new RectF();
        this.ux = new RectF();
        this.uy = new RectF();
        this.uz = new Paint();
        this.uA = new Path();
        this.uC = new Paint();
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.uC.setColor(SupportMenu.CATEGORY_MASK);
        this.uC.setStrokeWidth(10.0f);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        setFocusable(true);
        setFocusableInTouchMode(true);
        requestFocus();
        this.uA.setFillType(Path.FillType.EVEN_ODD);
        gJ();
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
        if (!this.uB) {
            this.ux.set(0.0f, 0.0f, i3, i4);
            gJ();
        }
        int childCount = getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (childAt != null) {
                a aVar = (a) childAt.getLayoutParams();
                if (aVar == null) {
                    childAt.setLayoutParams(aVar);
                }
                measureChild(childAt, i3 + ExploreByTouchHelper.INVALID_ID, i4 + ExploreByTouchHelper.INVALID_ID);
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
                switch (aVar.uD) {
                    case 1:
                        this.uy.right = this.uw.left;
                        this.uy.left = this.uy.right - childAt.getMeasuredWidth();
                        b(childAt, this.uy, aVar.uE);
                        break;
                    case 2:
                        this.uy.bottom = this.uw.top;
                        this.uy.top = this.uy.bottom - childAt.getMeasuredHeight();
                        a(childAt, this.uy, aVar.uE);
                        break;
                    case 3:
                        this.uy.left = this.uw.right;
                        this.uy.right = this.uy.left + childAt.getMeasuredWidth();
                        b(childAt, this.uy, aVar.uE);
                        break;
                    case 4:
                        this.uy.top = this.uw.bottom;
                        this.uy.bottom = this.uy.top + childAt.getMeasuredHeight();
                        a(childAt, this.uy, aVar.uE);
                        break;
                    case 5:
                        this.uy.left = (((int) this.uw.width()) - childAt.getMeasuredWidth()) >> 1;
                        this.uy.top = (((int) this.uw.height()) - childAt.getMeasuredHeight()) >> 1;
                        this.uy.right = (((int) this.uw.width()) + childAt.getMeasuredWidth()) >> 1;
                        this.uy.bottom = (((int) this.uw.height()) + childAt.getMeasuredHeight()) >> 1;
                        this.uy.offset(this.uw.left, this.uw.top);
                        break;
                }
                this.uy.offset((int) ((aVar.uF * f) + 0.5f), (int) ((aVar.uG * f) + 0.5f));
                childAt.layout((int) this.uy.left, (int) this.uy.top, (int) this.uy.right, (int) this.uy.bottom);
            }
        }
    }

    private void a(View view, RectF rectF, int i) {
        switch (i) {
            case 16:
                rectF.left = this.uw.left;
                rectF.right = rectF.left + view.getMeasuredWidth();
                return;
            case 32:
                rectF.left = (this.uw.width() - view.getMeasuredWidth()) / 2.0f;
                rectF.right = (this.uw.width() + view.getMeasuredWidth()) / 2.0f;
                rectF.offset(this.uw.left, 0.0f);
                return;
            case 48:
                rectF.right = this.uw.right;
                rectF.left = rectF.right - view.getMeasuredWidth();
                return;
            default:
                return;
        }
    }

    private void b(View view, RectF rectF, int i) {
        switch (i) {
            case 16:
                rectF.top = this.uw.top;
                rectF.bottom = rectF.top + view.getMeasuredHeight();
                return;
            case 32:
                rectF.top = (this.uw.width() - view.getMeasuredHeight()) / 2.0f;
                rectF.bottom = (this.uw.width() + view.getMeasuredHeight()) / 2.0f;
                rectF.offset(0.0f, this.uw.top);
                return;
            case 48:
                rectF.bottom = this.uw.bottom;
                rectF.top = this.uw.bottom - view.getMeasuredHeight();
                return;
            default:
                return;
        }
    }

    private void gJ() {
        this.uA.reset();
        this.uA.addRect(this.uw, Path.Direction.CW);
        this.uA.addRect(this.ux, Path.Direction.CW);
    }

    public void a(Rect rect) {
        this.uw.set(rect);
        gJ();
        invalidate();
    }

    public void b(Rect rect) {
        this.ux.set(rect);
        gJ();
        this.uB = true;
        invalidate();
    }

    public void ac(int i) {
        this.uz.setAlpha(i);
        invalidate();
    }

    public void ad(int i) {
        this.uz.setColor(i);
        invalidate();
    }

    public void x(boolean z) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* renamed from: gK */
    public a generateDefaultLayoutParams() {
        return new a(-2, -2);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        long drawingTime = getDrawingTime();
        canvas.save();
        canvas.drawRect(this.ux, this.uz);
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
        public int uD;
        public int uE;
        public int uF;
        public int uG;

        public a(int i, int i2) {
            super(i, i2);
            this.uD = 4;
            this.uE = 32;
            this.uF = 0;
            this.uG = 0;
        }
    }
}
