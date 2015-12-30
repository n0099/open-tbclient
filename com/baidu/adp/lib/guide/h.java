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
    private final RectF um;
    private final RectF uo;
    private final RectF up;
    private final Paint uq;
    private final Path ur;
    private boolean us;
    private final Paint ut;

    public h(Context context) {
        this(context, null, 0);
    }

    public h(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.um = new RectF();
        this.uo = new RectF();
        this.up = new RectF();
        this.uq = new Paint();
        this.ur = new Path();
        this.ut = new Paint();
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.ut.setColor(SupportMenu.CATEGORY_MASK);
        this.ut.setStrokeWidth(10.0f);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        setFocusable(true);
        setFocusableInTouchMode(true);
        requestFocus();
        this.ur.setFillType(Path.FillType.EVEN_ODD);
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
        if (!this.us) {
            this.uo.set(0.0f, 0.0f, i3, i4);
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
                switch (aVar.uu) {
                    case 1:
                        this.up.right = this.um.left;
                        this.up.left = this.up.right - childAt.getMeasuredWidth();
                        b(childAt, this.up, aVar.uv);
                        break;
                    case 2:
                        this.up.bottom = this.um.top;
                        this.up.top = this.up.bottom - childAt.getMeasuredHeight();
                        a(childAt, this.up, aVar.uv);
                        break;
                    case 3:
                        this.up.left = this.um.right;
                        this.up.right = this.up.left + childAt.getMeasuredWidth();
                        b(childAt, this.up, aVar.uv);
                        break;
                    case 4:
                        this.up.top = this.um.bottom;
                        this.up.bottom = this.up.top + childAt.getMeasuredHeight();
                        a(childAt, this.up, aVar.uv);
                        break;
                    case 5:
                        this.up.left = (((int) this.um.width()) - childAt.getMeasuredWidth()) >> 1;
                        this.up.top = (((int) this.um.height()) - childAt.getMeasuredHeight()) >> 1;
                        this.up.right = (((int) this.um.width()) + childAt.getMeasuredWidth()) >> 1;
                        this.up.bottom = (((int) this.um.height()) + childAt.getMeasuredHeight()) >> 1;
                        this.up.offset(this.um.left, this.um.top);
                        break;
                }
                this.up.offset((int) ((aVar.uw * f) + 0.5f), (int) ((aVar.ux * f) + 0.5f));
                childAt.layout((int) this.up.left, (int) this.up.top, (int) this.up.right, (int) this.up.bottom);
            }
        }
    }

    private void a(View view, RectF rectF, int i) {
        switch (i) {
            case 16:
                rectF.left = this.um.left;
                rectF.right = rectF.left + view.getMeasuredWidth();
                return;
            case 32:
                rectF.left = (this.um.width() - view.getMeasuredWidth()) / 2.0f;
                rectF.right = (this.um.width() + view.getMeasuredWidth()) / 2.0f;
                rectF.offset(this.um.left, 0.0f);
                return;
            case 48:
                rectF.right = this.um.right;
                rectF.left = rectF.right - view.getMeasuredWidth();
                return;
            default:
                return;
        }
    }

    private void b(View view, RectF rectF, int i) {
        switch (i) {
            case 16:
                rectF.top = this.um.top;
                rectF.bottom = rectF.top + view.getMeasuredHeight();
                return;
            case 32:
                rectF.top = (this.um.width() - view.getMeasuredHeight()) / 2.0f;
                rectF.bottom = (this.um.width() + view.getMeasuredHeight()) / 2.0f;
                rectF.offset(0.0f, this.um.top);
                return;
            case 48:
                rectF.bottom = this.um.bottom;
                rectF.top = this.um.bottom - view.getMeasuredHeight();
                return;
            default:
                return;
        }
    }

    private void gB() {
        this.ur.reset();
        this.ur.addRect(this.um, Path.Direction.CW);
        this.ur.addRect(this.uo, Path.Direction.CW);
    }

    public void a(Rect rect) {
        this.um.set(rect);
        gB();
        invalidate();
    }

    public void b(Rect rect) {
        this.uo.set(rect);
        gB();
        this.us = true;
        invalidate();
    }

    public void R(int i) {
        this.uq.setAlpha(i);
        invalidate();
    }

    public void S(int i) {
        this.uq.setColor(i);
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
        canvas.drawRect(this.uo, this.uq);
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
        public int uu;
        public int uv;
        public int uw;
        public int ux;

        public a(int i, int i2) {
            super(i, i2);
            this.uu = 4;
            this.uv = 32;
            this.uw = 0;
            this.ux = 0;
        }
    }
}
