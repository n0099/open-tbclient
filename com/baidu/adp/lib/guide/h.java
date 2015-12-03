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
    private final RectF uk;
    private final RectF ul;
    private final RectF um;
    private final Paint uo;
    private final Path up;
    private boolean uq;
    private final Paint ur;

    public h(Context context) {
        this(context, null, 0);
    }

    public h(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.uk = new RectF();
        this.ul = new RectF();
        this.um = new RectF();
        this.uo = new Paint();
        this.up = new Path();
        this.ur = new Paint();
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.ur.setColor(SupportMenu.CATEGORY_MASK);
        this.ur.setStrokeWidth(10.0f);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        setFocusable(true);
        setFocusableInTouchMode(true);
        requestFocus();
        this.up.setFillType(Path.FillType.EVEN_ODD);
        gB();
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
        if (!this.uq) {
            this.ul.set(0.0f, 0.0f, i3, i4);
            gB();
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
                switch (aVar.us) {
                    case 1:
                        this.um.right = this.uk.left;
                        this.um.left = this.um.right - childAt.getMeasuredWidth();
                        b(childAt, this.um, aVar.ut);
                        break;
                    case 2:
                        this.um.bottom = this.uk.top;
                        this.um.top = this.um.bottom - childAt.getMeasuredHeight();
                        a(childAt, this.um, aVar.ut);
                        break;
                    case 3:
                        this.um.left = this.uk.right;
                        this.um.right = this.um.left + childAt.getMeasuredWidth();
                        b(childAt, this.um, aVar.ut);
                        break;
                    case 4:
                        this.um.top = this.uk.bottom;
                        this.um.bottom = this.um.top + childAt.getMeasuredHeight();
                        a(childAt, this.um, aVar.ut);
                        break;
                    case 5:
                        this.um.left = (((int) this.uk.width()) - childAt.getMeasuredWidth()) >> 1;
                        this.um.top = (((int) this.uk.height()) - childAt.getMeasuredHeight()) >> 1;
                        this.um.right = (((int) this.uk.width()) + childAt.getMeasuredWidth()) >> 1;
                        this.um.bottom = (((int) this.uk.height()) + childAt.getMeasuredHeight()) >> 1;
                        this.um.offset(this.uk.left, this.uk.top);
                        break;
                }
                this.um.offset((int) ((aVar.uu * f) + 0.5f), (int) ((aVar.uv * f) + 0.5f));
                childAt.layout((int) this.um.left, (int) this.um.top, (int) this.um.right, (int) this.um.bottom);
            }
        }
    }

    private void a(View view, RectF rectF, int i) {
        switch (i) {
            case 16:
                rectF.left = this.uk.left;
                rectF.right = rectF.left + view.getMeasuredWidth();
                return;
            case 32:
                rectF.left = (this.uk.width() - view.getMeasuredWidth()) / 2.0f;
                rectF.right = (this.uk.width() + view.getMeasuredWidth()) / 2.0f;
                rectF.offset(this.uk.left, 0.0f);
                return;
            case 48:
                rectF.right = this.uk.right;
                rectF.left = rectF.right - view.getMeasuredWidth();
                return;
            default:
                return;
        }
    }

    private void b(View view, RectF rectF, int i) {
        switch (i) {
            case 16:
                rectF.top = this.uk.top;
                rectF.bottom = rectF.top + view.getMeasuredHeight();
                return;
            case 32:
                rectF.top = (this.uk.width() - view.getMeasuredHeight()) / 2.0f;
                rectF.bottom = (this.uk.width() + view.getMeasuredHeight()) / 2.0f;
                rectF.offset(0.0f, this.uk.top);
                return;
            case 48:
                rectF.bottom = this.uk.bottom;
                rectF.top = this.uk.bottom - view.getMeasuredHeight();
                return;
            default:
                return;
        }
    }

    private void gB() {
        this.up.reset();
        this.up.addRect(this.uk, Path.Direction.CW);
        this.up.addRect(this.ul, Path.Direction.CW);
    }

    public void a(Rect rect) {
        this.uk.set(rect);
        gB();
        invalidate();
    }

    public void b(Rect rect) {
        this.ul.set(rect);
        gB();
        this.uq = true;
        invalidate();
    }

    public void R(int i) {
        this.uo.setAlpha(i);
        invalidate();
    }

    public void S(int i) {
        this.uo.setColor(i);
        invalidate();
    }

    public void x(boolean z) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* renamed from: gC */
    public a generateDefaultLayoutParams() {
        return new a(-2, -2);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        long drawingTime = getDrawingTime();
        canvas.save();
        canvas.drawRect(this.ul, this.uo);
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
        public int us;
        public int ut;
        public int uu;
        public int uv;

        public a(int i, int i2) {
            super(i, i2);
            this.us = 4;
            this.ut = 32;
            this.uu = 0;
            this.uv = 0;
        }
    }
}
