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
    private final RectF nt;
    private final RectF nu;
    private final RectF nv;
    private final Paint nw;
    private final Path nx;
    private boolean ny;
    private final Paint nz;

    public h(Context context) {
        this(context, null, 0);
    }

    public h(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.nt = new RectF();
        this.nu = new RectF();
        this.nv = new RectF();
        this.nw = new Paint();
        this.nx = new Path();
        this.nz = new Paint();
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.nz.setColor(SupportMenu.CATEGORY_MASK);
        this.nz.setStrokeWidth(10.0f);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        setFocusable(true);
        setFocusableInTouchMode(true);
        requestFocus();
        this.nx.setFillType(Path.FillType.EVEN_ODD);
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
        if (!this.ny) {
            this.nu.set(0.0f, 0.0f, i3, i4);
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
                switch (aVar.nA) {
                    case 1:
                        this.nv.right = this.nt.left;
                        this.nv.left = this.nv.right - childAt.getMeasuredWidth();
                        b(childAt, this.nv, aVar.nB);
                        break;
                    case 2:
                        this.nv.bottom = this.nt.top;
                        this.nv.top = this.nv.bottom - childAt.getMeasuredHeight();
                        a(childAt, this.nv, aVar.nB);
                        break;
                    case 3:
                        this.nv.left = this.nt.right;
                        this.nv.right = this.nv.left + childAt.getMeasuredWidth();
                        b(childAt, this.nv, aVar.nB);
                        break;
                    case 4:
                        this.nv.top = this.nt.bottom;
                        this.nv.bottom = this.nv.top + childAt.getMeasuredHeight();
                        a(childAt, this.nv, aVar.nB);
                        break;
                    case 5:
                        this.nv.left = (((int) this.nt.width()) - childAt.getMeasuredWidth()) >> 1;
                        this.nv.top = (((int) this.nt.height()) - childAt.getMeasuredHeight()) >> 1;
                        this.nv.right = (((int) this.nt.width()) + childAt.getMeasuredWidth()) >> 1;
                        this.nv.bottom = (((int) this.nt.height()) + childAt.getMeasuredHeight()) >> 1;
                        this.nv.offset(this.nt.left, this.nt.top);
                        break;
                }
                this.nv.offset((int) ((aVar.nC * f) + 0.5f), (int) ((aVar.nD * f) + 0.5f));
                childAt.layout((int) this.nv.left, (int) this.nv.top, (int) this.nv.right, (int) this.nv.bottom);
            }
        }
    }

    private void a(View view, RectF rectF, int i) {
        switch (i) {
            case 16:
                rectF.left = this.nt.left;
                rectF.right = rectF.left + view.getMeasuredWidth();
                return;
            case 32:
                rectF.left = (this.nt.width() - view.getMeasuredWidth()) / 2.0f;
                rectF.right = (this.nt.width() + view.getMeasuredWidth()) / 2.0f;
                rectF.offset(this.nt.left, 0.0f);
                return;
            case 48:
                rectF.right = this.nt.right;
                rectF.left = rectF.right - view.getMeasuredWidth();
                return;
            default:
                return;
        }
    }

    private void b(View view, RectF rectF, int i) {
        switch (i) {
            case 16:
                rectF.top = this.nt.top;
                rectF.bottom = rectF.top + view.getMeasuredHeight();
                return;
            case 32:
                rectF.top = (this.nt.width() - view.getMeasuredHeight()) / 2.0f;
                rectF.bottom = (this.nt.width() + view.getMeasuredHeight()) / 2.0f;
                rectF.offset(0.0f, this.nt.top);
                return;
            case 48:
                rectF.bottom = this.nt.bottom;
                rectF.top = this.nt.bottom - view.getMeasuredHeight();
                return;
            default:
                return;
        }
    }

    private void dS() {
        this.nx.reset();
        this.nx.addRect(this.nt, Path.Direction.CW);
        this.nx.addRect(this.nu, Path.Direction.CW);
    }

    public void a(Rect rect) {
        this.nt.set(rect);
        dS();
        invalidate();
    }

    public void b(Rect rect) {
        this.nu.set(rect);
        dS();
        this.ny = true;
        invalidate();
    }

    public void ag(int i) {
        this.nw.setAlpha(i);
        invalidate();
    }

    public void ah(int i) {
        this.nw.setColor(i);
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
        canvas.drawRect(this.nu, this.nw);
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
        public int nD;

        public a(int i, int i2) {
            super(i, i2);
            this.nA = 4;
            this.nB = 32;
            this.nC = 0;
            this.nD = 0;
        }
    }
}
