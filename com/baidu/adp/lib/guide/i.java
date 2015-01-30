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
    private final RectF jF;
    private final RectF jG;
    private final RectF jH;
    private final Paint jI;
    private final Path jJ;
    private boolean jK;
    private final Paint jL;
    private final Paint mPaint;

    public i(Context context) {
        this(context, null, 0);
    }

    public i(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jF = new RectF();
        this.jG = new RectF();
        this.jH = new RectF();
        this.jI = new Paint();
        this.jJ = new Path();
        this.jL = new Paint();
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.jL.setColor(SupportMenu.CATEGORY_MASK);
        this.jL.setStrokeWidth(10.0f);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        setFocusable(true);
        setFocusableInTouchMode(true);
        requestFocus();
        this.jJ.setFillType(Path.FillType.EVEN_ODD);
        dz();
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
        if (!this.jK) {
            this.jG.set(0.0f, 0.0f, i3, i4);
            dz();
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
                switch (jVar.jM) {
                    case 1:
                        this.jH.right = this.jF.left;
                        this.jH.left = this.jH.right - childAt.getMeasuredWidth();
                        b(childAt, this.jH, jVar.jN);
                        break;
                    case 2:
                        this.jH.bottom = this.jF.top;
                        this.jH.top = this.jH.bottom - childAt.getMeasuredHeight();
                        a(childAt, this.jH, jVar.jN);
                        break;
                    case 3:
                        this.jH.left = this.jF.right;
                        this.jH.right = this.jH.left + childAt.getMeasuredWidth();
                        b(childAt, this.jH, jVar.jN);
                        break;
                    case 4:
                        this.jH.top = this.jF.bottom;
                        this.jH.bottom = this.jH.top + childAt.getMeasuredHeight();
                        a(childAt, this.jH, jVar.jN);
                        break;
                    case 5:
                        this.jH.left = (((int) this.jF.width()) - childAt.getMeasuredWidth()) >> 1;
                        this.jH.top = (((int) this.jF.height()) - childAt.getMeasuredHeight()) >> 1;
                        this.jH.right = (((int) this.jF.width()) + childAt.getMeasuredWidth()) >> 1;
                        this.jH.bottom = (((int) this.jF.height()) + childAt.getMeasuredHeight()) >> 1;
                        this.jH.offset(this.jF.left, this.jF.top);
                        break;
                }
                this.jH.offset((int) ((jVar.jO * f) + 0.5f), (int) ((jVar.jP * f) + 0.5f));
                childAt.layout((int) this.jH.left, (int) this.jH.top, (int) this.jH.right, (int) this.jH.bottom);
            }
        }
    }

    private void a(View view, RectF rectF, int i) {
        switch (i) {
            case 16:
                rectF.left = this.jF.left;
                rectF.right = rectF.left + view.getMeasuredWidth();
                return;
            case 32:
                rectF.left = (this.jF.width() - view.getMeasuredWidth()) / 2.0f;
                rectF.right = (this.jF.width() + view.getMeasuredWidth()) / 2.0f;
                rectF.offset(this.jF.left, 0.0f);
                return;
            case 48:
                rectF.right = this.jF.right;
                rectF.left = rectF.right - view.getMeasuredWidth();
                return;
            default:
                return;
        }
    }

    private void b(View view, RectF rectF, int i) {
        switch (i) {
            case 16:
                rectF.top = this.jF.top;
                rectF.bottom = rectF.top + view.getMeasuredHeight();
                return;
            case 32:
                rectF.top = (this.jF.width() - view.getMeasuredHeight()) / 2.0f;
                rectF.bottom = (this.jF.width() + view.getMeasuredHeight()) / 2.0f;
                rectF.offset(0.0f, this.jF.top);
                return;
            case 48:
                rectF.bottom = this.jF.bottom;
                rectF.top = this.jF.bottom - view.getMeasuredHeight();
                return;
            default:
                return;
        }
    }

    private void dz() {
        this.jJ.reset();
        this.jJ.addRect(this.jF, Path.Direction.CW);
        this.jJ.addRect(this.jG, Path.Direction.CW);
    }

    public void a(Rect rect) {
        this.jF.set(rect);
        dz();
        invalidate();
    }

    public void b(Rect rect) {
        this.jG.set(rect);
        dz();
        this.jK = true;
        invalidate();
    }

    public void P(int i) {
        this.jI.setAlpha(i);
        invalidate();
    }

    public void Q(int i) {
        this.jI.setColor(i);
        invalidate();
    }

    public void x(boolean z) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* renamed from: dA */
    public j generateDefaultLayoutParams() {
        return new j(-2, -2);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        long drawingTime = getDrawingTime();
        canvas.save();
        canvas.drawRect(this.jG, this.jI);
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
