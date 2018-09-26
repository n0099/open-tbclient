package com.baidu.adp.lib.guide;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.v4.internal.view.SupportMenu;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class MaskView extends ViewGroup {
    private boolean Bd;
    private final RectF Bj;
    private final RectF Bk;
    private final RectF Bl;
    private final Paint Bm;
    private final Path Bn;
    private boolean Bo;
    private final Paint Bp;
    private final Paint mPaint;

    public MaskView(Context context) {
        this(context, null, 0);
    }

    public MaskView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MaskView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.Bj = new RectF();
        this.Bk = new RectF();
        this.Bl = new RectF();
        this.Bm = new Paint();
        this.Bn = new Path();
        this.Bd = false;
        this.Bp = new Paint();
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.Bp.setColor(SupportMenu.CATEGORY_MASK);
        this.Bp.setStrokeWidth(10.0f);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        setFocusable(true);
        setFocusableInTouchMode(true);
        requestFocus();
        this.Bn.setFillType(Path.FillType.EVEN_ODD);
        iF();
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
        if (!this.Bo) {
            this.Bk.set(0.0f, 0.0f, i3, i4);
            iF();
        }
        int childCount = getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (childAt != null) {
                a aVar = (a) childAt.getLayoutParams();
                if (aVar == null) {
                    childAt.setLayoutParams(aVar);
                }
                measureChild(childAt, i3 - 2147483648, i4 - 2147483648);
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
                switch (aVar.Bq) {
                    case 1:
                        this.Bl.right = this.Bj.left;
                        this.Bl.left = this.Bl.right - childAt.getMeasuredWidth();
                        b(childAt, this.Bl, aVar.Br);
                        break;
                    case 2:
                        this.Bl.bottom = this.Bj.top;
                        this.Bl.top = this.Bl.bottom - childAt.getMeasuredHeight();
                        a(childAt, this.Bl, aVar.Br);
                        break;
                    case 3:
                        this.Bl.left = this.Bj.right;
                        this.Bl.right = this.Bl.left + childAt.getMeasuredWidth();
                        b(childAt, this.Bl, aVar.Br);
                        break;
                    case 4:
                        this.Bl.top = this.Bj.bottom;
                        this.Bl.bottom = this.Bl.top + childAt.getMeasuredHeight();
                        a(childAt, this.Bl, aVar.Br);
                        break;
                    case 5:
                        this.Bl.left = (((int) this.Bj.width()) - childAt.getMeasuredWidth()) >> 1;
                        this.Bl.top = (((int) this.Bj.height()) - childAt.getMeasuredHeight()) >> 1;
                        this.Bl.right = (((int) this.Bj.width()) + childAt.getMeasuredWidth()) >> 1;
                        this.Bl.bottom = (((int) this.Bj.height()) + childAt.getMeasuredHeight()) >> 1;
                        this.Bl.offset(this.Bj.left, this.Bj.top);
                        break;
                }
                if (this.Bd) {
                    this.Bl.offset(aVar.Bs, aVar.Bt);
                } else {
                    this.Bl.offset((int) ((aVar.Bs * f) + 0.5f), (int) ((aVar.Bt * f) + 0.5f));
                }
                childAt.layout((int) this.Bl.left, (int) this.Bl.top, (int) this.Bl.right, (int) this.Bl.bottom);
            }
        }
    }

    public void M(boolean z) {
        this.Bd = z;
    }

    private void a(View view, RectF rectF, int i) {
        switch (i) {
            case 16:
                rectF.left = this.Bj.left;
                rectF.right = rectF.left + view.getMeasuredWidth();
                return;
            case 32:
                rectF.left = (this.Bj.width() - view.getMeasuredWidth()) / 2.0f;
                rectF.right = (this.Bj.width() + view.getMeasuredWidth()) / 2.0f;
                rectF.offset(this.Bj.left, 0.0f);
                return;
            case 48:
                rectF.right = this.Bj.right;
                rectF.left = rectF.right - view.getMeasuredWidth();
                return;
            default:
                return;
        }
    }

    private void b(View view, RectF rectF, int i) {
        switch (i) {
            case 16:
                rectF.top = this.Bj.top;
                rectF.bottom = rectF.top + view.getMeasuredHeight();
                return;
            case 32:
                rectF.top = (this.Bj.width() - view.getMeasuredHeight()) / 2.0f;
                rectF.bottom = (this.Bj.width() + view.getMeasuredHeight()) / 2.0f;
                rectF.offset(0.0f, this.Bj.top);
                return;
            case 48:
                rectF.bottom = this.Bj.bottom;
                rectF.top = this.Bj.bottom - view.getMeasuredHeight();
                return;
            default:
                return;
        }
    }

    private void iF() {
        this.Bn.reset();
        this.Bn.addRect(this.Bj, Path.Direction.CW);
        this.Bn.addRect(this.Bk, Path.Direction.CW);
    }

    public void b(Rect rect) {
        this.Bj.set(rect);
        iF();
        invalidate();
    }

    public void c(Rect rect) {
        this.Bk.set(rect);
        iF();
        this.Bo = true;
        invalidate();
    }

    public void ah(int i) {
        this.Bm.setAlpha(i);
        invalidate();
    }

    public void ai(int i) {
        this.Bm.setColor(i);
        invalidate();
    }

    public void Q(boolean z) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* renamed from: iG */
    public a generateDefaultLayoutParams() {
        return new a(-2, -2);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        long drawingTime = getDrawingTime();
        canvas.save();
        canvas.drawRect(this.Bk, this.Bm);
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
        public int Bq;
        public int Br;
        public int Bs;
        public int Bt;

        public a(int i, int i2) {
            super(i, i2);
            this.Bq = 4;
            this.Br = 32;
            this.Bs = 0;
            this.Bt = 0;
        }
    }
}
