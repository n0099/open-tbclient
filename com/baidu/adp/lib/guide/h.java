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
    private final RectF uE;
    private final RectF uF;
    private final RectF uG;
    private final Paint uH;
    private final Path uI;
    private boolean uJ;
    private final Paint uK;

    public h(Context context) {
        this(context, null, 0);
    }

    public h(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.uE = new RectF();
        this.uF = new RectF();
        this.uG = new RectF();
        this.uH = new Paint();
        this.uI = new Path();
        this.uK = new Paint();
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.uK.setColor(SupportMenu.CATEGORY_MASK);
        this.uK.setStrokeWidth(10.0f);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        setFocusable(true);
        setFocusableInTouchMode(true);
        requestFocus();
        this.uI.setFillType(Path.FillType.EVEN_ODD);
        fd();
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
        if (!this.uJ) {
            this.uF.set(0.0f, 0.0f, i3, i4);
            fd();
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
                switch (aVar.uL) {
                    case 1:
                        this.uG.right = this.uE.left;
                        this.uG.left = this.uG.right - childAt.getMeasuredWidth();
                        b(childAt, this.uG, aVar.uM);
                        break;
                    case 2:
                        this.uG.bottom = this.uE.top;
                        this.uG.top = this.uG.bottom - childAt.getMeasuredHeight();
                        a(childAt, this.uG, aVar.uM);
                        break;
                    case 3:
                        this.uG.left = this.uE.right;
                        this.uG.right = this.uG.left + childAt.getMeasuredWidth();
                        b(childAt, this.uG, aVar.uM);
                        break;
                    case 4:
                        this.uG.top = this.uE.bottom;
                        this.uG.bottom = this.uG.top + childAt.getMeasuredHeight();
                        a(childAt, this.uG, aVar.uM);
                        break;
                    case 5:
                        this.uG.left = (((int) this.uE.width()) - childAt.getMeasuredWidth()) >> 1;
                        this.uG.top = (((int) this.uE.height()) - childAt.getMeasuredHeight()) >> 1;
                        this.uG.right = (((int) this.uE.width()) + childAt.getMeasuredWidth()) >> 1;
                        this.uG.bottom = (((int) this.uE.height()) + childAt.getMeasuredHeight()) >> 1;
                        this.uG.offset(this.uE.left, this.uE.top);
                        break;
                }
                this.uG.offset((int) ((aVar.uN * f) + 0.5f), (int) ((aVar.uO * f) + 0.5f));
                childAt.layout((int) this.uG.left, (int) this.uG.top, (int) this.uG.right, (int) this.uG.bottom);
            }
        }
    }

    private void a(View view, RectF rectF, int i) {
        switch (i) {
            case 16:
                rectF.left = this.uE.left;
                rectF.right = rectF.left + view.getMeasuredWidth();
                return;
            case 32:
                rectF.left = (this.uE.width() - view.getMeasuredWidth()) / 2.0f;
                rectF.right = (this.uE.width() + view.getMeasuredWidth()) / 2.0f;
                rectF.offset(this.uE.left, 0.0f);
                return;
            case 48:
                rectF.right = this.uE.right;
                rectF.left = rectF.right - view.getMeasuredWidth();
                return;
            default:
                return;
        }
    }

    private void b(View view, RectF rectF, int i) {
        switch (i) {
            case 16:
                rectF.top = this.uE.top;
                rectF.bottom = rectF.top + view.getMeasuredHeight();
                return;
            case 32:
                rectF.top = (this.uE.width() - view.getMeasuredHeight()) / 2.0f;
                rectF.bottom = (this.uE.width() + view.getMeasuredHeight()) / 2.0f;
                rectF.offset(0.0f, this.uE.top);
                return;
            case 48:
                rectF.bottom = this.uE.bottom;
                rectF.top = this.uE.bottom - view.getMeasuredHeight();
                return;
            default:
                return;
        }
    }

    private void fd() {
        this.uI.reset();
        this.uI.addRect(this.uE, Path.Direction.CW);
        this.uI.addRect(this.uF, Path.Direction.CW);
    }

    public void a(Rect rect) {
        this.uE.set(rect);
        fd();
        invalidate();
    }

    public void b(Rect rect) {
        this.uF.set(rect);
        fd();
        this.uJ = true;
        invalidate();
    }

    public void af(int i) {
        this.uH.setAlpha(i);
        invalidate();
    }

    public void ag(int i) {
        this.uH.setColor(i);
        invalidate();
    }

    public void B(boolean z) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* renamed from: fe */
    public a generateDefaultLayoutParams() {
        return new a(-2, -2);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        long drawingTime = getDrawingTime();
        canvas.save();
        canvas.drawRect(this.uF, this.uH);
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
        public int uL;
        public int uM;
        public int uN;
        public int uO;

        public a(int i, int i2) {
            super(i, i2);
            this.uL = 4;
            this.uM = 32;
            this.uN = 0;
            this.uO = 0;
        }
    }
}
