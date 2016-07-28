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
    private final RectF kX;
    private final RectF kY;
    private final RectF kZ;
    private final Paint la;
    private final Path lb;
    private boolean lc;
    private final Paint ld;
    private final Paint mPaint;

    public h(Context context) {
        this(context, null, 0);
    }

    public h(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.kX = new RectF();
        this.kY = new RectF();
        this.kZ = new RectF();
        this.la = new Paint();
        this.lb = new Path();
        this.ld = new Paint();
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.ld.setColor(SupportMenu.CATEGORY_MASK);
        this.ld.setStrokeWidth(10.0f);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        setFocusable(true);
        setFocusableInTouchMode(true);
        requestFocus();
        this.lb.setFillType(Path.FillType.EVEN_ODD);
        cX();
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
        if (!this.lc) {
            this.kY.set(0.0f, 0.0f, i3, i4);
            cX();
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
                switch (aVar.le) {
                    case 1:
                        this.kZ.right = this.kX.left;
                        this.kZ.left = this.kZ.right - childAt.getMeasuredWidth();
                        b(childAt, this.kZ, aVar.lf);
                        break;
                    case 2:
                        this.kZ.bottom = this.kX.top;
                        this.kZ.top = this.kZ.bottom - childAt.getMeasuredHeight();
                        a(childAt, this.kZ, aVar.lf);
                        break;
                    case 3:
                        this.kZ.left = this.kX.right;
                        this.kZ.right = this.kZ.left + childAt.getMeasuredWidth();
                        b(childAt, this.kZ, aVar.lf);
                        break;
                    case 4:
                        this.kZ.top = this.kX.bottom;
                        this.kZ.bottom = this.kZ.top + childAt.getMeasuredHeight();
                        a(childAt, this.kZ, aVar.lf);
                        break;
                    case 5:
                        this.kZ.left = (((int) this.kX.width()) - childAt.getMeasuredWidth()) >> 1;
                        this.kZ.top = (((int) this.kX.height()) - childAt.getMeasuredHeight()) >> 1;
                        this.kZ.right = (((int) this.kX.width()) + childAt.getMeasuredWidth()) >> 1;
                        this.kZ.bottom = (((int) this.kX.height()) + childAt.getMeasuredHeight()) >> 1;
                        this.kZ.offset(this.kX.left, this.kX.top);
                        break;
                }
                this.kZ.offset((int) ((aVar.lg * f) + 0.5f), (int) ((aVar.lh * f) + 0.5f));
                childAt.layout((int) this.kZ.left, (int) this.kZ.top, (int) this.kZ.right, (int) this.kZ.bottom);
            }
        }
    }

    private void a(View view, RectF rectF, int i) {
        switch (i) {
            case 16:
                rectF.left = this.kX.left;
                rectF.right = rectF.left + view.getMeasuredWidth();
                return;
            case 32:
                rectF.left = (this.kX.width() - view.getMeasuredWidth()) / 2.0f;
                rectF.right = (this.kX.width() + view.getMeasuredWidth()) / 2.0f;
                rectF.offset(this.kX.left, 0.0f);
                return;
            case 48:
                rectF.right = this.kX.right;
                rectF.left = rectF.right - view.getMeasuredWidth();
                return;
            default:
                return;
        }
    }

    private void b(View view, RectF rectF, int i) {
        switch (i) {
            case 16:
                rectF.top = this.kX.top;
                rectF.bottom = rectF.top + view.getMeasuredHeight();
                return;
            case 32:
                rectF.top = (this.kX.width() - view.getMeasuredHeight()) / 2.0f;
                rectF.bottom = (this.kX.width() + view.getMeasuredHeight()) / 2.0f;
                rectF.offset(0.0f, this.kX.top);
                return;
            case 48:
                rectF.bottom = this.kX.bottom;
                rectF.top = this.kX.bottom - view.getMeasuredHeight();
                return;
            default:
                return;
        }
    }

    private void cX() {
        this.lb.reset();
        this.lb.addRect(this.kX, Path.Direction.CW);
        this.lb.addRect(this.kY, Path.Direction.CW);
    }

    public void a(Rect rect) {
        this.kX.set(rect);
        cX();
        invalidate();
    }

    public void b(Rect rect) {
        this.kY.set(rect);
        cX();
        this.lc = true;
        invalidate();
    }

    public void S(int i) {
        this.la.setAlpha(i);
        invalidate();
    }

    public void T(int i) {
        this.la.setColor(i);
        invalidate();
    }

    public void y(boolean z) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* renamed from: cY */
    public a generateDefaultLayoutParams() {
        return new a(-2, -2);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        long drawingTime = getDrawingTime();
        canvas.save();
        canvas.drawRect(this.kY, this.la);
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
        public int le;
        public int lf;
        public int lg;
        public int lh;

        public a(int i, int i2) {
            super(i, i2);
            this.le = 4;
            this.lf = 32;
            this.lg = 0;
            this.lh = 0;
        }
    }
}
