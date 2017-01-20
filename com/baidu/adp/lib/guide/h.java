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
    private final RectF nl;
    private final RectF nm;
    private final RectF nn;
    private final Paint np;
    private final Path nq;
    private boolean nr;
    private final Paint ns;

    public h(Context context) {
        this(context, null, 0);
    }

    public h(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.nl = new RectF();
        this.nm = new RectF();
        this.nn = new RectF();
        this.np = new Paint();
        this.nq = new Path();
        this.ns = new Paint();
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.ns.setColor(SupportMenu.CATEGORY_MASK);
        this.ns.setStrokeWidth(10.0f);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        setFocusable(true);
        setFocusableInTouchMode(true);
        requestFocus();
        this.nq.setFillType(Path.FillType.EVEN_ODD);
        dQ();
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
        if (!this.nr) {
            this.nm.set(0.0f, 0.0f, i3, i4);
            dQ();
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
                switch (aVar.nt) {
                    case 1:
                        this.nn.right = this.nl.left;
                        this.nn.left = this.nn.right - childAt.getMeasuredWidth();
                        b(childAt, this.nn, aVar.nu);
                        break;
                    case 2:
                        this.nn.bottom = this.nl.top;
                        this.nn.top = this.nn.bottom - childAt.getMeasuredHeight();
                        a(childAt, this.nn, aVar.nu);
                        break;
                    case 3:
                        this.nn.left = this.nl.right;
                        this.nn.right = this.nn.left + childAt.getMeasuredWidth();
                        b(childAt, this.nn, aVar.nu);
                        break;
                    case 4:
                        this.nn.top = this.nl.bottom;
                        this.nn.bottom = this.nn.top + childAt.getMeasuredHeight();
                        a(childAt, this.nn, aVar.nu);
                        break;
                    case 5:
                        this.nn.left = (((int) this.nl.width()) - childAt.getMeasuredWidth()) >> 1;
                        this.nn.top = (((int) this.nl.height()) - childAt.getMeasuredHeight()) >> 1;
                        this.nn.right = (((int) this.nl.width()) + childAt.getMeasuredWidth()) >> 1;
                        this.nn.bottom = (((int) this.nl.height()) + childAt.getMeasuredHeight()) >> 1;
                        this.nn.offset(this.nl.left, this.nl.top);
                        break;
                }
                this.nn.offset((int) ((aVar.nv * f) + 0.5f), (int) ((aVar.nw * f) + 0.5f));
                childAt.layout((int) this.nn.left, (int) this.nn.top, (int) this.nn.right, (int) this.nn.bottom);
            }
        }
    }

    private void a(View view, RectF rectF, int i) {
        switch (i) {
            case 16:
                rectF.left = this.nl.left;
                rectF.right = rectF.left + view.getMeasuredWidth();
                return;
            case 32:
                rectF.left = (this.nl.width() - view.getMeasuredWidth()) / 2.0f;
                rectF.right = (this.nl.width() + view.getMeasuredWidth()) / 2.0f;
                rectF.offset(this.nl.left, 0.0f);
                return;
            case 48:
                rectF.right = this.nl.right;
                rectF.left = rectF.right - view.getMeasuredWidth();
                return;
            default:
                return;
        }
    }

    private void b(View view, RectF rectF, int i) {
        switch (i) {
            case 16:
                rectF.top = this.nl.top;
                rectF.bottom = rectF.top + view.getMeasuredHeight();
                return;
            case 32:
                rectF.top = (this.nl.width() - view.getMeasuredHeight()) / 2.0f;
                rectF.bottom = (this.nl.width() + view.getMeasuredHeight()) / 2.0f;
                rectF.offset(0.0f, this.nl.top);
                return;
            case 48:
                rectF.bottom = this.nl.bottom;
                rectF.top = this.nl.bottom - view.getMeasuredHeight();
                return;
            default:
                return;
        }
    }

    private void dQ() {
        this.nq.reset();
        this.nq.addRect(this.nl, Path.Direction.CW);
        this.nq.addRect(this.nm, Path.Direction.CW);
    }

    public void a(Rect rect) {
        this.nl.set(rect);
        dQ();
        invalidate();
    }

    public void b(Rect rect) {
        this.nm.set(rect);
        dQ();
        this.nr = true;
        invalidate();
    }

    public void ag(int i) {
        this.np.setAlpha(i);
        invalidate();
    }

    public void ah(int i) {
        this.np.setColor(i);
        invalidate();
    }

    public void A(boolean z) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* renamed from: dR */
    public a generateDefaultLayoutParams() {
        return new a(-2, -2);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        long drawingTime = getDrawingTime();
        canvas.save();
        canvas.drawRect(this.nm, this.np);
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
        public int nt;
        public int nu;
        public int nv;
        public int nw;

        public a(int i, int i2) {
            super(i, i2);
            this.nt = 4;
            this.nu = 32;
            this.nv = 0;
            this.nw = 0;
        }
    }
}
