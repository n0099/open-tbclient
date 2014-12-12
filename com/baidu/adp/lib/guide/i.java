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
    private final RectF jD;
    private final RectF jE;
    private final RectF jF;
    private final Paint jG;
    private final Path jH;
    private boolean jI;
    private final Paint jJ;
    private final Paint mPaint;

    public i(Context context) {
        this(context, null, 0);
    }

    public i(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jD = new RectF();
        this.jE = new RectF();
        this.jF = new RectF();
        this.jG = new Paint();
        this.jH = new Path();
        this.jJ = new Paint();
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.jJ.setColor(SupportMenu.CATEGORY_MASK);
        this.jJ.setStrokeWidth(10.0f);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        setFocusable(true);
        setFocusableInTouchMode(true);
        requestFocus();
        this.jH.setFillType(Path.FillType.EVEN_ODD);
        dB();
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
        if (!this.jI) {
            this.jE.set(0.0f, 0.0f, i3, i4);
            dB();
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
                switch (jVar.jK) {
                    case 1:
                        this.jF.right = this.jD.left;
                        this.jF.left = this.jF.right - childAt.getMeasuredWidth();
                        b(childAt, this.jF, jVar.jL);
                        break;
                    case 2:
                        this.jF.bottom = this.jD.top;
                        this.jF.top = this.jF.bottom - childAt.getMeasuredHeight();
                        a(childAt, this.jF, jVar.jL);
                        break;
                    case 3:
                        this.jF.left = this.jD.right;
                        this.jF.right = this.jF.left + childAt.getMeasuredWidth();
                        b(childAt, this.jF, jVar.jL);
                        break;
                    case 4:
                        this.jF.top = this.jD.bottom;
                        this.jF.bottom = this.jF.top + childAt.getMeasuredHeight();
                        a(childAt, this.jF, jVar.jL);
                        break;
                    case 5:
                        this.jF.left = (((int) this.jD.width()) - childAt.getMeasuredWidth()) >> 1;
                        this.jF.top = (((int) this.jD.height()) - childAt.getMeasuredHeight()) >> 1;
                        this.jF.right = (((int) this.jD.width()) + childAt.getMeasuredWidth()) >> 1;
                        this.jF.bottom = (((int) this.jD.height()) + childAt.getMeasuredHeight()) >> 1;
                        this.jF.offset(this.jD.left, this.jD.top);
                        break;
                }
                this.jF.offset((int) ((jVar.jM * f) + 0.5f), (int) ((jVar.jN * f) + 0.5f));
                childAt.layout((int) this.jF.left, (int) this.jF.top, (int) this.jF.right, (int) this.jF.bottom);
            }
        }
    }

    private void a(View view, RectF rectF, int i) {
        switch (i) {
            case 16:
                rectF.left = this.jD.left;
                rectF.right = rectF.left + view.getMeasuredWidth();
                return;
            case 32:
                rectF.left = (this.jD.width() - view.getMeasuredWidth()) / 2.0f;
                rectF.right = (this.jD.width() + view.getMeasuredWidth()) / 2.0f;
                rectF.offset(this.jD.left, 0.0f);
                return;
            case 48:
                rectF.right = this.jD.right;
                rectF.left = rectF.right - view.getMeasuredWidth();
                return;
            default:
                return;
        }
    }

    private void b(View view, RectF rectF, int i) {
        switch (i) {
            case 16:
                rectF.top = this.jD.top;
                rectF.bottom = rectF.top + view.getMeasuredHeight();
                return;
            case 32:
                rectF.top = (this.jD.width() - view.getMeasuredHeight()) / 2.0f;
                rectF.bottom = (this.jD.width() + view.getMeasuredHeight()) / 2.0f;
                rectF.offset(0.0f, this.jD.top);
                return;
            case 48:
                rectF.bottom = this.jD.bottom;
                rectF.top = this.jD.bottom - view.getMeasuredHeight();
                return;
            default:
                return;
        }
    }

    private void dB() {
        this.jH.reset();
        this.jH.addRect(this.jD, Path.Direction.CW);
        this.jH.addRect(this.jE, Path.Direction.CW);
    }

    public void a(Rect rect) {
        this.jD.set(rect);
        dB();
        invalidate();
    }

    public void b(Rect rect) {
        this.jE.set(rect);
        dB();
        this.jI = true;
        invalidate();
    }

    public void K(int i) {
        this.jG.setAlpha(i);
        invalidate();
    }

    public void L(int i) {
        this.jG.setColor(i);
        invalidate();
    }

    public void x(boolean z) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* renamed from: dC */
    public j generateDefaultLayoutParams() {
        return new j(-2, -2);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        long drawingTime = getDrawingTime();
        canvas.save();
        canvas.drawRect(this.jE, this.jG);
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
