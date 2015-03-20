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
public class i extends ViewGroup {
    private final Paint mPaint;
    private final RectF uW;
    private final RectF uX;
    private final RectF uY;
    private final Paint uZ;
    private final Path va;
    private boolean vb;
    private final Paint vc;

    public i(Context context) {
        this(context, null, 0);
    }

    public i(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.uW = new RectF();
        this.uX = new RectF();
        this.uY = new RectF();
        this.uZ = new Paint();
        this.va = new Path();
        this.vc = new Paint();
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.vc.setColor(SupportMenu.CATEGORY_MASK);
        this.vc.setStrokeWidth(10.0f);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        setFocusable(true);
        setFocusableInTouchMode(true);
        requestFocus();
        this.va.setFillType(Path.FillType.EVEN_ODD);
        gX();
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
        if (!this.vb) {
            this.uX.set(0.0f, 0.0f, i3, i4);
            gX();
        }
        int childCount = getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (childAt != null) {
                j jVar = (j) childAt.getLayoutParams();
                if (jVar == null) {
                    childAt.setLayoutParams(jVar);
                }
                measureChild(childAt, i3 + ExploreByTouchHelper.INVALID_ID, i4 + ExploreByTouchHelper.INVALID_ID);
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
                switch (jVar.vd) {
                    case 1:
                        this.uY.right = this.uW.left;
                        this.uY.left = this.uY.right - childAt.getMeasuredWidth();
                        b(childAt, this.uY, jVar.ve);
                        break;
                    case 2:
                        this.uY.bottom = this.uW.top;
                        this.uY.top = this.uY.bottom - childAt.getMeasuredHeight();
                        a(childAt, this.uY, jVar.ve);
                        break;
                    case 3:
                        this.uY.left = this.uW.right;
                        this.uY.right = this.uY.left + childAt.getMeasuredWidth();
                        b(childAt, this.uY, jVar.ve);
                        break;
                    case 4:
                        this.uY.top = this.uW.bottom;
                        this.uY.bottom = this.uY.top + childAt.getMeasuredHeight();
                        a(childAt, this.uY, jVar.ve);
                        break;
                    case 5:
                        this.uY.left = (((int) this.uW.width()) - childAt.getMeasuredWidth()) >> 1;
                        this.uY.top = (((int) this.uW.height()) - childAt.getMeasuredHeight()) >> 1;
                        this.uY.right = (((int) this.uW.width()) + childAt.getMeasuredWidth()) >> 1;
                        this.uY.bottom = (((int) this.uW.height()) + childAt.getMeasuredHeight()) >> 1;
                        this.uY.offset(this.uW.left, this.uW.top);
                        break;
                }
                this.uY.offset((int) ((jVar.vf * f) + 0.5f), (int) ((jVar.vg * f) + 0.5f));
                childAt.layout((int) this.uY.left, (int) this.uY.top, (int) this.uY.right, (int) this.uY.bottom);
            }
        }
    }

    private void a(View view, RectF rectF, int i) {
        switch (i) {
            case 16:
                rectF.left = this.uW.left;
                rectF.right = rectF.left + view.getMeasuredWidth();
                return;
            case 32:
                rectF.left = (this.uW.width() - view.getMeasuredWidth()) / 2.0f;
                rectF.right = (this.uW.width() + view.getMeasuredWidth()) / 2.0f;
                rectF.offset(this.uW.left, 0.0f);
                return;
            case 48:
                rectF.right = this.uW.right;
                rectF.left = rectF.right - view.getMeasuredWidth();
                return;
            default:
                return;
        }
    }

    private void b(View view, RectF rectF, int i) {
        switch (i) {
            case 16:
                rectF.top = this.uW.top;
                rectF.bottom = rectF.top + view.getMeasuredHeight();
                return;
            case 32:
                rectF.top = (this.uW.width() - view.getMeasuredHeight()) / 2.0f;
                rectF.bottom = (this.uW.width() + view.getMeasuredHeight()) / 2.0f;
                rectF.offset(0.0f, this.uW.top);
                return;
            case 48:
                rectF.bottom = this.uW.bottom;
                rectF.top = this.uW.bottom - view.getMeasuredHeight();
                return;
            default:
                return;
        }
    }

    private void gX() {
        this.va.reset();
        this.va.addRect(this.uW, Path.Direction.CW);
        this.va.addRect(this.uX, Path.Direction.CW);
    }

    public void a(Rect rect) {
        this.uW.set(rect);
        gX();
        invalidate();
    }

    public void b(Rect rect) {
        this.uX.set(rect);
        gX();
        this.vb = true;
        invalidate();
    }

    public void Q(int i) {
        this.uZ.setAlpha(i);
        invalidate();
    }

    public void R(int i) {
        this.uZ.setColor(i);
        invalidate();
    }

    public void x(boolean z) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* renamed from: gY */
    public j generateDefaultLayoutParams() {
        return new j(-2, -2);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        long drawingTime = getDrawingTime();
        canvas.save();
        canvas.drawRect(this.uX, this.uZ);
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
