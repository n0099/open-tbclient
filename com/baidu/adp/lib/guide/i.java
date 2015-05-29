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
    private final RectF uh;
    private final RectF ui;
    private final RectF uj;
    private final Paint uk;
    private final Path ul;
    private boolean um;
    private final Paint uo;

    public i(Context context) {
        this(context, null, 0);
    }

    public i(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.uh = new RectF();
        this.ui = new RectF();
        this.uj = new RectF();
        this.uk = new Paint();
        this.ul = new Path();
        this.uo = new Paint();
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.uo.setColor(SupportMenu.CATEGORY_MASK);
        this.uo.setStrokeWidth(10.0f);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        setFocusable(true);
        setFocusableInTouchMode(true);
        requestFocus();
        this.ul.setFillType(Path.FillType.EVEN_ODD);
        gI();
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
        if (!this.um) {
            this.ui.set(0.0f, 0.0f, i3, i4);
            gI();
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
                switch (jVar.up) {
                    case 1:
                        this.uj.right = this.uh.left;
                        this.uj.left = this.uj.right - childAt.getMeasuredWidth();
                        b(childAt, this.uj, jVar.uq);
                        break;
                    case 2:
                        this.uj.bottom = this.uh.top;
                        this.uj.top = this.uj.bottom - childAt.getMeasuredHeight();
                        a(childAt, this.uj, jVar.uq);
                        break;
                    case 3:
                        this.uj.left = this.uh.right;
                        this.uj.right = this.uj.left + childAt.getMeasuredWidth();
                        b(childAt, this.uj, jVar.uq);
                        break;
                    case 4:
                        this.uj.top = this.uh.bottom;
                        this.uj.bottom = this.uj.top + childAt.getMeasuredHeight();
                        a(childAt, this.uj, jVar.uq);
                        break;
                    case 5:
                        this.uj.left = (((int) this.uh.width()) - childAt.getMeasuredWidth()) >> 1;
                        this.uj.top = (((int) this.uh.height()) - childAt.getMeasuredHeight()) >> 1;
                        this.uj.right = (((int) this.uh.width()) + childAt.getMeasuredWidth()) >> 1;
                        this.uj.bottom = (((int) this.uh.height()) + childAt.getMeasuredHeight()) >> 1;
                        this.uj.offset(this.uh.left, this.uh.top);
                        break;
                }
                this.uj.offset((int) ((jVar.ur * f) + 0.5f), (int) ((jVar.us * f) + 0.5f));
                childAt.layout((int) this.uj.left, (int) this.uj.top, (int) this.uj.right, (int) this.uj.bottom);
            }
        }
    }

    private void a(View view, RectF rectF, int i) {
        switch (i) {
            case 16:
                rectF.left = this.uh.left;
                rectF.right = rectF.left + view.getMeasuredWidth();
                return;
            case 32:
                rectF.left = (this.uh.width() - view.getMeasuredWidth()) / 2.0f;
                rectF.right = (this.uh.width() + view.getMeasuredWidth()) / 2.0f;
                rectF.offset(this.uh.left, 0.0f);
                return;
            case 48:
                rectF.right = this.uh.right;
                rectF.left = rectF.right - view.getMeasuredWidth();
                return;
            default:
                return;
        }
    }

    private void b(View view, RectF rectF, int i) {
        switch (i) {
            case 16:
                rectF.top = this.uh.top;
                rectF.bottom = rectF.top + view.getMeasuredHeight();
                return;
            case 32:
                rectF.top = (this.uh.width() - view.getMeasuredHeight()) / 2.0f;
                rectF.bottom = (this.uh.width() + view.getMeasuredHeight()) / 2.0f;
                rectF.offset(0.0f, this.uh.top);
                return;
            case 48:
                rectF.bottom = this.uh.bottom;
                rectF.top = this.uh.bottom - view.getMeasuredHeight();
                return;
            default:
                return;
        }
    }

    private void gI() {
        this.ul.reset();
        this.ul.addRect(this.uh, Path.Direction.CW);
        this.ul.addRect(this.ui, Path.Direction.CW);
    }

    public void a(Rect rect) {
        this.uh.set(rect);
        gI();
        invalidate();
    }

    public void b(Rect rect) {
        this.ui.set(rect);
        gI();
        this.um = true;
        invalidate();
    }

    public void O(int i) {
        this.uk.setAlpha(i);
        invalidate();
    }

    public void P(int i) {
        this.uk.setColor(i);
        invalidate();
    }

    public void x(boolean z) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* renamed from: gJ */
    public j generateDefaultLayoutParams() {
        return new j(-2, -2);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        long drawingTime = getDrawingTime();
        canvas.save();
        canvas.drawRect(this.ui, this.uk);
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
