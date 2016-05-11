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
    private final Path kA;
    private boolean kB;
    private final Paint kC;
    private final RectF ku;
    private final RectF kv;
    private final RectF kx;
    private final Paint ky;
    private final Paint mPaint;

    public h(Context context) {
        this(context, null, 0);
    }

    public h(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ku = new RectF();
        this.kv = new RectF();
        this.kx = new RectF();
        this.ky = new Paint();
        this.kA = new Path();
        this.kC = new Paint();
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.kC.setColor(SupportMenu.CATEGORY_MASK);
        this.kC.setStrokeWidth(10.0f);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        setFocusable(true);
        setFocusableInTouchMode(true);
        requestFocus();
        this.kA.setFillType(Path.FillType.EVEN_ODD);
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
        if (!this.kB) {
            this.kv.set(0.0f, 0.0f, i3, i4);
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
                switch (aVar.kD) {
                    case 1:
                        this.kx.right = this.ku.left;
                        this.kx.left = this.kx.right - childAt.getMeasuredWidth();
                        b(childAt, this.kx, aVar.kE);
                        break;
                    case 2:
                        this.kx.bottom = this.ku.top;
                        this.kx.top = this.kx.bottom - childAt.getMeasuredHeight();
                        a(childAt, this.kx, aVar.kE);
                        break;
                    case 3:
                        this.kx.left = this.ku.right;
                        this.kx.right = this.kx.left + childAt.getMeasuredWidth();
                        b(childAt, this.kx, aVar.kE);
                        break;
                    case 4:
                        this.kx.top = this.ku.bottom;
                        this.kx.bottom = this.kx.top + childAt.getMeasuredHeight();
                        a(childAt, this.kx, aVar.kE);
                        break;
                    case 5:
                        this.kx.left = (((int) this.ku.width()) - childAt.getMeasuredWidth()) >> 1;
                        this.kx.top = (((int) this.ku.height()) - childAt.getMeasuredHeight()) >> 1;
                        this.kx.right = (((int) this.ku.width()) + childAt.getMeasuredWidth()) >> 1;
                        this.kx.bottom = (((int) this.ku.height()) + childAt.getMeasuredHeight()) >> 1;
                        this.kx.offset(this.ku.left, this.ku.top);
                        break;
                }
                this.kx.offset((int) ((aVar.kF * f) + 0.5f), (int) ((aVar.kG * f) + 0.5f));
                childAt.layout((int) this.kx.left, (int) this.kx.top, (int) this.kx.right, (int) this.kx.bottom);
            }
        }
    }

    private void a(View view, RectF rectF, int i) {
        switch (i) {
            case 16:
                rectF.left = this.ku.left;
                rectF.right = rectF.left + view.getMeasuredWidth();
                return;
            case 32:
                rectF.left = (this.ku.width() - view.getMeasuredWidth()) / 2.0f;
                rectF.right = (this.ku.width() + view.getMeasuredWidth()) / 2.0f;
                rectF.offset(this.ku.left, 0.0f);
                return;
            case 48:
                rectF.right = this.ku.right;
                rectF.left = rectF.right - view.getMeasuredWidth();
                return;
            default:
                return;
        }
    }

    private void b(View view, RectF rectF, int i) {
        switch (i) {
            case 16:
                rectF.top = this.ku.top;
                rectF.bottom = rectF.top + view.getMeasuredHeight();
                return;
            case 32:
                rectF.top = (this.ku.width() - view.getMeasuredHeight()) / 2.0f;
                rectF.bottom = (this.ku.width() + view.getMeasuredHeight()) / 2.0f;
                rectF.offset(0.0f, this.ku.top);
                return;
            case 48:
                rectF.bottom = this.ku.bottom;
                rectF.top = this.ku.bottom - view.getMeasuredHeight();
                return;
            default:
                return;
        }
    }

    private void cX() {
        this.kA.reset();
        this.kA.addRect(this.ku, Path.Direction.CW);
        this.kA.addRect(this.kv, Path.Direction.CW);
    }

    public void a(Rect rect) {
        this.ku.set(rect);
        cX();
        invalidate();
    }

    public void b(Rect rect) {
        this.kv.set(rect);
        cX();
        this.kB = true;
        invalidate();
    }

    public void P(int i) {
        this.ky.setAlpha(i);
        invalidate();
    }

    public void Q(int i) {
        this.ky.setColor(i);
        invalidate();
    }

    public void w(boolean z) {
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
        canvas.drawRect(this.kv, this.ky);
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
        public int kD;
        public int kE;
        public int kF;
        public int kG;

        public a(int i, int i2) {
            super(i, i2);
            this.kD = 4;
            this.kE = 32;
            this.kF = 0;
            this.kG = 0;
        }
    }
}
