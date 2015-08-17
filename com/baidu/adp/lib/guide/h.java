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
    private final RectF ug;
    private final RectF uh;
    private final RectF ui;
    private final Paint uj;
    private final Path uk;
    private boolean ul;
    private final Paint um;

    public h(Context context) {
        this(context, null, 0);
    }

    public h(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ug = new RectF();
        this.uh = new RectF();
        this.ui = new RectF();
        this.uj = new Paint();
        this.uk = new Path();
        this.um = new Paint();
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.um.setColor(SupportMenu.CATEGORY_MASK);
        this.um.setStrokeWidth(10.0f);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        setFocusable(true);
        setFocusableInTouchMode(true);
        requestFocus();
        this.uk.setFillType(Path.FillType.EVEN_ODD);
        gD();
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
        if (!this.ul) {
            this.uh.set(0.0f, 0.0f, i3, i4);
            gD();
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
                switch (aVar.uo) {
                    case 1:
                        this.ui.right = this.ug.left;
                        this.ui.left = this.ui.right - childAt.getMeasuredWidth();
                        b(childAt, this.ui, aVar.up);
                        break;
                    case 2:
                        this.ui.bottom = this.ug.top;
                        this.ui.top = this.ui.bottom - childAt.getMeasuredHeight();
                        a(childAt, this.ui, aVar.up);
                        break;
                    case 3:
                        this.ui.left = this.ug.right;
                        this.ui.right = this.ui.left + childAt.getMeasuredWidth();
                        b(childAt, this.ui, aVar.up);
                        break;
                    case 4:
                        this.ui.top = this.ug.bottom;
                        this.ui.bottom = this.ui.top + childAt.getMeasuredHeight();
                        a(childAt, this.ui, aVar.up);
                        break;
                    case 5:
                        this.ui.left = (((int) this.ug.width()) - childAt.getMeasuredWidth()) >> 1;
                        this.ui.top = (((int) this.ug.height()) - childAt.getMeasuredHeight()) >> 1;
                        this.ui.right = (((int) this.ug.width()) + childAt.getMeasuredWidth()) >> 1;
                        this.ui.bottom = (((int) this.ug.height()) + childAt.getMeasuredHeight()) >> 1;
                        this.ui.offset(this.ug.left, this.ug.top);
                        break;
                }
                this.ui.offset((int) ((aVar.uq * f) + 0.5f), (int) ((aVar.ur * f) + 0.5f));
                childAt.layout((int) this.ui.left, (int) this.ui.top, (int) this.ui.right, (int) this.ui.bottom);
            }
        }
    }

    private void a(View view, RectF rectF, int i) {
        switch (i) {
            case 16:
                rectF.left = this.ug.left;
                rectF.right = rectF.left + view.getMeasuredWidth();
                return;
            case 32:
                rectF.left = (this.ug.width() - view.getMeasuredWidth()) / 2.0f;
                rectF.right = (this.ug.width() + view.getMeasuredWidth()) / 2.0f;
                rectF.offset(this.ug.left, 0.0f);
                return;
            case 48:
                rectF.right = this.ug.right;
                rectF.left = rectF.right - view.getMeasuredWidth();
                return;
            default:
                return;
        }
    }

    private void b(View view, RectF rectF, int i) {
        switch (i) {
            case 16:
                rectF.top = this.ug.top;
                rectF.bottom = rectF.top + view.getMeasuredHeight();
                return;
            case 32:
                rectF.top = (this.ug.width() - view.getMeasuredHeight()) / 2.0f;
                rectF.bottom = (this.ug.width() + view.getMeasuredHeight()) / 2.0f;
                rectF.offset(0.0f, this.ug.top);
                return;
            case 48:
                rectF.bottom = this.ug.bottom;
                rectF.top = this.ug.bottom - view.getMeasuredHeight();
                return;
            default:
                return;
        }
    }

    private void gD() {
        this.uk.reset();
        this.uk.addRect(this.ug, Path.Direction.CW);
        this.uk.addRect(this.uh, Path.Direction.CW);
    }

    public void a(Rect rect) {
        this.ug.set(rect);
        gD();
        invalidate();
    }

    public void b(Rect rect) {
        this.uh.set(rect);
        gD();
        this.ul = true;
        invalidate();
    }

    public void Q(int i) {
        this.uj.setAlpha(i);
        invalidate();
    }

    public void R(int i) {
        this.uj.setColor(i);
        invalidate();
    }

    public void x(boolean z) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* renamed from: gE */
    public a generateDefaultLayoutParams() {
        return new a(-2, -2);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        long drawingTime = getDrawingTime();
        canvas.save();
        canvas.drawRect(this.uh, this.uj);
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
        public int uo;
        public int up;
        public int uq;
        public int ur;

        public a(int i, int i2) {
            super(i, i2);
            this.uo = 4;
            this.up = 32;
            this.uq = 0;
            this.ur = 0;
        }
    }
}
