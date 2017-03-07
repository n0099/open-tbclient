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
    private final RectF vb;
    private final RectF vc;
    private final RectF vd;
    private final Paint ve;
    private final Path vf;
    private boolean vg;
    private final Paint vh;

    public h(Context context) {
        this(context, null, 0);
    }

    public h(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.vb = new RectF();
        this.vc = new RectF();
        this.vd = new RectF();
        this.ve = new Paint();
        this.vf = new Path();
        this.vh = new Paint();
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.vh.setColor(SupportMenu.CATEGORY_MASK);
        this.vh.setStrokeWidth(10.0f);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        setFocusable(true);
        setFocusableInTouchMode(true);
        requestFocus();
        this.vf.setFillType(Path.FillType.EVEN_ODD);
        eY();
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
        if (!this.vg) {
            this.vc.set(0.0f, 0.0f, i3, i4);
            eY();
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
                switch (aVar.vi) {
                    case 1:
                        this.vd.right = this.vb.left;
                        this.vd.left = this.vd.right - childAt.getMeasuredWidth();
                        b(childAt, this.vd, aVar.vj);
                        break;
                    case 2:
                        this.vd.bottom = this.vb.top;
                        this.vd.top = this.vd.bottom - childAt.getMeasuredHeight();
                        a(childAt, this.vd, aVar.vj);
                        break;
                    case 3:
                        this.vd.left = this.vb.right;
                        this.vd.right = this.vd.left + childAt.getMeasuredWidth();
                        b(childAt, this.vd, aVar.vj);
                        break;
                    case 4:
                        this.vd.top = this.vb.bottom;
                        this.vd.bottom = this.vd.top + childAt.getMeasuredHeight();
                        a(childAt, this.vd, aVar.vj);
                        break;
                    case 5:
                        this.vd.left = (((int) this.vb.width()) - childAt.getMeasuredWidth()) >> 1;
                        this.vd.top = (((int) this.vb.height()) - childAt.getMeasuredHeight()) >> 1;
                        this.vd.right = (((int) this.vb.width()) + childAt.getMeasuredWidth()) >> 1;
                        this.vd.bottom = (((int) this.vb.height()) + childAt.getMeasuredHeight()) >> 1;
                        this.vd.offset(this.vb.left, this.vb.top);
                        break;
                }
                this.vd.offset((int) ((aVar.vk * f) + 0.5f), (int) ((aVar.vl * f) + 0.5f));
                childAt.layout((int) this.vd.left, (int) this.vd.top, (int) this.vd.right, (int) this.vd.bottom);
            }
        }
    }

    private void a(View view, RectF rectF, int i) {
        switch (i) {
            case 16:
                rectF.left = this.vb.left;
                rectF.right = rectF.left + view.getMeasuredWidth();
                return;
            case 32:
                rectF.left = (this.vb.width() - view.getMeasuredWidth()) / 2.0f;
                rectF.right = (this.vb.width() + view.getMeasuredWidth()) / 2.0f;
                rectF.offset(this.vb.left, 0.0f);
                return;
            case 48:
                rectF.right = this.vb.right;
                rectF.left = rectF.right - view.getMeasuredWidth();
                return;
            default:
                return;
        }
    }

    private void b(View view, RectF rectF, int i) {
        switch (i) {
            case 16:
                rectF.top = this.vb.top;
                rectF.bottom = rectF.top + view.getMeasuredHeight();
                return;
            case 32:
                rectF.top = (this.vb.width() - view.getMeasuredHeight()) / 2.0f;
                rectF.bottom = (this.vb.width() + view.getMeasuredHeight()) / 2.0f;
                rectF.offset(0.0f, this.vb.top);
                return;
            case 48:
                rectF.bottom = this.vb.bottom;
                rectF.top = this.vb.bottom - view.getMeasuredHeight();
                return;
            default:
                return;
        }
    }

    private void eY() {
        this.vf.reset();
        this.vf.addRect(this.vb, Path.Direction.CW);
        this.vf.addRect(this.vc, Path.Direction.CW);
    }

    public void a(Rect rect) {
        this.vb.set(rect);
        eY();
        invalidate();
    }

    public void b(Rect rect) {
        this.vc.set(rect);
        eY();
        this.vg = true;
        invalidate();
    }

    public void ag(int i) {
        this.ve.setAlpha(i);
        invalidate();
    }

    public void ah(int i) {
        this.ve.setColor(i);
        invalidate();
    }

    public void B(boolean z) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* renamed from: eZ */
    public a generateDefaultLayoutParams() {
        return new a(-2, -2);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        long drawingTime = getDrawingTime();
        canvas.save();
        canvas.drawRect(this.vc, this.ve);
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
        public int vi;
        public int vj;
        public int vk;
        public int vl;

        public a(int i, int i2) {
            super(i, i2);
            this.vi = 4;
            this.vj = 32;
            this.vk = 0;
            this.vl = 0;
        }
    }
}
