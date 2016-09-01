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
    private final RectF ns;
    private final RectF nt;
    private final RectF nu;
    private final Paint nv;
    private final Path nw;
    private boolean nx;
    private final Paint ny;

    public h(Context context) {
        this(context, null, 0);
    }

    public h(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ns = new RectF();
        this.nt = new RectF();
        this.nu = new RectF();
        this.nv = new Paint();
        this.nw = new Path();
        this.ny = new Paint();
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.ny.setColor(SupportMenu.CATEGORY_MASK);
        this.ny.setStrokeWidth(10.0f);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        setFocusable(true);
        setFocusableInTouchMode(true);
        requestFocus();
        this.nw.setFillType(Path.FillType.EVEN_ODD);
        dS();
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
        if (!this.nx) {
            this.nt.set(0.0f, 0.0f, i3, i4);
            dS();
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
                switch (aVar.nz) {
                    case 1:
                        this.nu.right = this.ns.left;
                        this.nu.left = this.nu.right - childAt.getMeasuredWidth();
                        b(childAt, this.nu, aVar.nA);
                        break;
                    case 2:
                        this.nu.bottom = this.ns.top;
                        this.nu.top = this.nu.bottom - childAt.getMeasuredHeight();
                        a(childAt, this.nu, aVar.nA);
                        break;
                    case 3:
                        this.nu.left = this.ns.right;
                        this.nu.right = this.nu.left + childAt.getMeasuredWidth();
                        b(childAt, this.nu, aVar.nA);
                        break;
                    case 4:
                        this.nu.top = this.ns.bottom;
                        this.nu.bottom = this.nu.top + childAt.getMeasuredHeight();
                        a(childAt, this.nu, aVar.nA);
                        break;
                    case 5:
                        this.nu.left = (((int) this.ns.width()) - childAt.getMeasuredWidth()) >> 1;
                        this.nu.top = (((int) this.ns.height()) - childAt.getMeasuredHeight()) >> 1;
                        this.nu.right = (((int) this.ns.width()) + childAt.getMeasuredWidth()) >> 1;
                        this.nu.bottom = (((int) this.ns.height()) + childAt.getMeasuredHeight()) >> 1;
                        this.nu.offset(this.ns.left, this.ns.top);
                        break;
                }
                this.nu.offset((int) ((aVar.nB * f) + 0.5f), (int) ((aVar.nC * f) + 0.5f));
                childAt.layout((int) this.nu.left, (int) this.nu.top, (int) this.nu.right, (int) this.nu.bottom);
            }
        }
    }

    private void a(View view, RectF rectF, int i) {
        switch (i) {
            case 16:
                rectF.left = this.ns.left;
                rectF.right = rectF.left + view.getMeasuredWidth();
                return;
            case 32:
                rectF.left = (this.ns.width() - view.getMeasuredWidth()) / 2.0f;
                rectF.right = (this.ns.width() + view.getMeasuredWidth()) / 2.0f;
                rectF.offset(this.ns.left, 0.0f);
                return;
            case 48:
                rectF.right = this.ns.right;
                rectF.left = rectF.right - view.getMeasuredWidth();
                return;
            default:
                return;
        }
    }

    private void b(View view, RectF rectF, int i) {
        switch (i) {
            case 16:
                rectF.top = this.ns.top;
                rectF.bottom = rectF.top + view.getMeasuredHeight();
                return;
            case 32:
                rectF.top = (this.ns.width() - view.getMeasuredHeight()) / 2.0f;
                rectF.bottom = (this.ns.width() + view.getMeasuredHeight()) / 2.0f;
                rectF.offset(0.0f, this.ns.top);
                return;
            case 48:
                rectF.bottom = this.ns.bottom;
                rectF.top = this.ns.bottom - view.getMeasuredHeight();
                return;
            default:
                return;
        }
    }

    private void dS() {
        this.nw.reset();
        this.nw.addRect(this.ns, Path.Direction.CW);
        this.nw.addRect(this.nt, Path.Direction.CW);
    }

    public void a(Rect rect) {
        this.ns.set(rect);
        dS();
        invalidate();
    }

    public void b(Rect rect) {
        this.nt.set(rect);
        dS();
        this.nx = true;
        invalidate();
    }

    public void af(int i) {
        this.nv.setAlpha(i);
        invalidate();
    }

    public void ag(int i) {
        this.nv.setColor(i);
        invalidate();
    }

    public void A(boolean z) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* renamed from: dT */
    public a generateDefaultLayoutParams() {
        return new a(-2, -2);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        long drawingTime = getDrawingTime();
        canvas.save();
        canvas.drawRect(this.nt, this.nv);
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
        public int nA;
        public int nB;
        public int nC;
        public int nz;

        public a(int i, int i2) {
            super(i, i2);
            this.nz = 4;
            this.nA = 32;
            this.nB = 0;
            this.nC = 0;
        }
    }
}
