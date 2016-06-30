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
    private final Paint kA;
    private final RectF ks;
    private final RectF kt;
    private final RectF ku;
    private final Paint kv;
    private final Path kx;
    private boolean ky;
    private final Paint mPaint;

    public h(Context context) {
        this(context, null, 0);
    }

    public h(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ks = new RectF();
        this.kt = new RectF();
        this.ku = new RectF();
        this.kv = new Paint();
        this.kx = new Path();
        this.kA = new Paint();
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.kA.setColor(SupportMenu.CATEGORY_MASK);
        this.kA.setStrokeWidth(10.0f);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        setFocusable(true);
        setFocusableInTouchMode(true);
        requestFocus();
        this.kx.setFillType(Path.FillType.EVEN_ODD);
        cY();
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
        if (!this.ky) {
            this.kt.set(0.0f, 0.0f, i3, i4);
            cY();
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
                switch (aVar.kB) {
                    case 1:
                        this.ku.right = this.ks.left;
                        this.ku.left = this.ku.right - childAt.getMeasuredWidth();
                        b(childAt, this.ku, aVar.kC);
                        break;
                    case 2:
                        this.ku.bottom = this.ks.top;
                        this.ku.top = this.ku.bottom - childAt.getMeasuredHeight();
                        a(childAt, this.ku, aVar.kC);
                        break;
                    case 3:
                        this.ku.left = this.ks.right;
                        this.ku.right = this.ku.left + childAt.getMeasuredWidth();
                        b(childAt, this.ku, aVar.kC);
                        break;
                    case 4:
                        this.ku.top = this.ks.bottom;
                        this.ku.bottom = this.ku.top + childAt.getMeasuredHeight();
                        a(childAt, this.ku, aVar.kC);
                        break;
                    case 5:
                        this.ku.left = (((int) this.ks.width()) - childAt.getMeasuredWidth()) >> 1;
                        this.ku.top = (((int) this.ks.height()) - childAt.getMeasuredHeight()) >> 1;
                        this.ku.right = (((int) this.ks.width()) + childAt.getMeasuredWidth()) >> 1;
                        this.ku.bottom = (((int) this.ks.height()) + childAt.getMeasuredHeight()) >> 1;
                        this.ku.offset(this.ks.left, this.ks.top);
                        break;
                }
                this.ku.offset((int) ((aVar.kD * f) + 0.5f), (int) ((aVar.kE * f) + 0.5f));
                childAt.layout((int) this.ku.left, (int) this.ku.top, (int) this.ku.right, (int) this.ku.bottom);
            }
        }
    }

    private void a(View view, RectF rectF, int i) {
        switch (i) {
            case 16:
                rectF.left = this.ks.left;
                rectF.right = rectF.left + view.getMeasuredWidth();
                return;
            case 32:
                rectF.left = (this.ks.width() - view.getMeasuredWidth()) / 2.0f;
                rectF.right = (this.ks.width() + view.getMeasuredWidth()) / 2.0f;
                rectF.offset(this.ks.left, 0.0f);
                return;
            case 48:
                rectF.right = this.ks.right;
                rectF.left = rectF.right - view.getMeasuredWidth();
                return;
            default:
                return;
        }
    }

    private void b(View view, RectF rectF, int i) {
        switch (i) {
            case 16:
                rectF.top = this.ks.top;
                rectF.bottom = rectF.top + view.getMeasuredHeight();
                return;
            case 32:
                rectF.top = (this.ks.width() - view.getMeasuredHeight()) / 2.0f;
                rectF.bottom = (this.ks.width() + view.getMeasuredHeight()) / 2.0f;
                rectF.offset(0.0f, this.ks.top);
                return;
            case 48:
                rectF.bottom = this.ks.bottom;
                rectF.top = this.ks.bottom - view.getMeasuredHeight();
                return;
            default:
                return;
        }
    }

    private void cY() {
        this.kx.reset();
        this.kx.addRect(this.ks, Path.Direction.CW);
        this.kx.addRect(this.kt, Path.Direction.CW);
    }

    public void a(Rect rect) {
        this.ks.set(rect);
        cY();
        invalidate();
    }

    public void b(Rect rect) {
        this.kt.set(rect);
        cY();
        this.ky = true;
        invalidate();
    }

    public void P(int i) {
        this.kv.setAlpha(i);
        invalidate();
    }

    public void Q(int i) {
        this.kv.setColor(i);
        invalidate();
    }

    public void w(boolean z) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* renamed from: cZ */
    public a generateDefaultLayoutParams() {
        return new a(-2, -2);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        long drawingTime = getDrawingTime();
        canvas.save();
        canvas.drawRect(this.kt, this.kv);
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
        public int kB;
        public int kC;
        public int kD;
        public int kE;

        public a(int i, int i2) {
            super(i, i2);
            this.kB = 4;
            this.kC = 32;
            this.kD = 0;
            this.kE = 0;
        }
    }
}
