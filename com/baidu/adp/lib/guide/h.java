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
    private final RectF uF;
    private final RectF uG;
    private final RectF uH;
    private final Paint uI;
    private final Path uJ;
    private boolean uK;
    private final Paint uL;

    public h(Context context) {
        this(context, null, 0);
    }

    public h(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.uF = new RectF();
        this.uG = new RectF();
        this.uH = new RectF();
        this.uI = new Paint();
        this.uJ = new Path();
        this.uL = new Paint();
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.uL.setColor(SupportMenu.CATEGORY_MASK);
        this.uL.setStrokeWidth(10.0f);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        setFocusable(true);
        setFocusableInTouchMode(true);
        requestFocus();
        this.uJ.setFillType(Path.FillType.EVEN_ODD);
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
        if (!this.uK) {
            this.uG.set(0.0f, 0.0f, i3, i4);
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
                switch (aVar.uM) {
                    case 1:
                        this.uH.right = this.uF.left;
                        this.uH.left = this.uH.right - childAt.getMeasuredWidth();
                        b(childAt, this.uH, aVar.uN);
                        break;
                    case 2:
                        this.uH.bottom = this.uF.top;
                        this.uH.top = this.uH.bottom - childAt.getMeasuredHeight();
                        a(childAt, this.uH, aVar.uN);
                        break;
                    case 3:
                        this.uH.left = this.uF.right;
                        this.uH.right = this.uH.left + childAt.getMeasuredWidth();
                        b(childAt, this.uH, aVar.uN);
                        break;
                    case 4:
                        this.uH.top = this.uF.bottom;
                        this.uH.bottom = this.uH.top + childAt.getMeasuredHeight();
                        a(childAt, this.uH, aVar.uN);
                        break;
                    case 5:
                        this.uH.left = (((int) this.uF.width()) - childAt.getMeasuredWidth()) >> 1;
                        this.uH.top = (((int) this.uF.height()) - childAt.getMeasuredHeight()) >> 1;
                        this.uH.right = (((int) this.uF.width()) + childAt.getMeasuredWidth()) >> 1;
                        this.uH.bottom = (((int) this.uF.height()) + childAt.getMeasuredHeight()) >> 1;
                        this.uH.offset(this.uF.left, this.uF.top);
                        break;
                }
                this.uH.offset((int) ((aVar.uO * f) + 0.5f), (int) ((aVar.uP * f) + 0.5f));
                childAt.layout((int) this.uH.left, (int) this.uH.top, (int) this.uH.right, (int) this.uH.bottom);
            }
        }
    }

    private void a(View view, RectF rectF, int i) {
        switch (i) {
            case 16:
                rectF.left = this.uF.left;
                rectF.right = rectF.left + view.getMeasuredWidth();
                return;
            case 32:
                rectF.left = (this.uF.width() - view.getMeasuredWidth()) / 2.0f;
                rectF.right = (this.uF.width() + view.getMeasuredWidth()) / 2.0f;
                rectF.offset(this.uF.left, 0.0f);
                return;
            case 48:
                rectF.right = this.uF.right;
                rectF.left = rectF.right - view.getMeasuredWidth();
                return;
            default:
                return;
        }
    }

    private void b(View view, RectF rectF, int i) {
        switch (i) {
            case 16:
                rectF.top = this.uF.top;
                rectF.bottom = rectF.top + view.getMeasuredHeight();
                return;
            case 32:
                rectF.top = (this.uF.width() - view.getMeasuredHeight()) / 2.0f;
                rectF.bottom = (this.uF.width() + view.getMeasuredHeight()) / 2.0f;
                rectF.offset(0.0f, this.uF.top);
                return;
            case 48:
                rectF.bottom = this.uF.bottom;
                rectF.top = this.uF.bottom - view.getMeasuredHeight();
                return;
            default:
                return;
        }
    }

    private void gJ() {
        this.uJ.reset();
        this.uJ.addRect(this.uF, Path.Direction.CW);
        this.uJ.addRect(this.uG, Path.Direction.CW);
    }

    public void a(Rect rect) {
        this.uF.set(rect);
        gJ();
        invalidate();
    }

    public void b(Rect rect) {
        this.uG.set(rect);
        gJ();
        this.uK = true;
        invalidate();
    }

    public void ab(int i) {
        this.uI.setAlpha(i);
        invalidate();
    }

    public void ac(int i) {
        this.uI.setColor(i);
        invalidate();
    }

    public void w(boolean z) {
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
        canvas.drawRect(this.uG, this.uI);
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
        public int uM;
        public int uN;
        public int uO;
        public int uP;

        public a(int i, int i2) {
            super(i, i2);
            this.uM = 4;
            this.uN = 32;
            this.uO = 0;
            this.uP = 0;
        }
    }
}
