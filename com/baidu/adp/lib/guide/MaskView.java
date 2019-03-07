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
    private boolean BO;
    private final RectF BU;
    private final RectF BV;
    private final RectF BW;
    private final Paint BX;
    private final Path BY;
    private boolean BZ;
    private final Paint Ca;
    private final Paint mPaint;

    public MaskView(Context context) {
        this(context, null, 0);
    }

    public MaskView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MaskView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.BU = new RectF();
        this.BV = new RectF();
        this.BW = new RectF();
        this.BX = new Paint();
        this.BY = new Path();
        this.BO = false;
        this.Ca = new Paint();
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.Ca.setColor(SupportMenu.CATEGORY_MASK);
        this.Ca.setStrokeWidth(10.0f);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        setFocusable(true);
        setFocusableInTouchMode(true);
        requestFocus();
        this.BY.setFillType(Path.FillType.EVEN_ODD);
        iU();
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
        if (!this.BZ) {
            this.BV.set(0.0f, 0.0f, i3, i4);
            iU();
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
                switch (aVar.Cb) {
                    case 1:
                        this.BW.right = this.BU.left;
                        this.BW.left = this.BW.right - childAt.getMeasuredWidth();
                        b(childAt, this.BW, aVar.Cc);
                        break;
                    case 2:
                        this.BW.bottom = this.BU.top;
                        this.BW.top = this.BW.bottom - childAt.getMeasuredHeight();
                        a(childAt, this.BW, aVar.Cc);
                        break;
                    case 3:
                        this.BW.left = this.BU.right;
                        this.BW.right = this.BW.left + childAt.getMeasuredWidth();
                        b(childAt, this.BW, aVar.Cc);
                        break;
                    case 4:
                        this.BW.top = this.BU.bottom;
                        this.BW.bottom = this.BW.top + childAt.getMeasuredHeight();
                        a(childAt, this.BW, aVar.Cc);
                        break;
                    case 5:
                        this.BW.left = (((int) this.BU.width()) - childAt.getMeasuredWidth()) >> 1;
                        this.BW.top = (((int) this.BU.height()) - childAt.getMeasuredHeight()) >> 1;
                        this.BW.right = (((int) this.BU.width()) + childAt.getMeasuredWidth()) >> 1;
                        this.BW.bottom = (((int) this.BU.height()) + childAt.getMeasuredHeight()) >> 1;
                        this.BW.offset(this.BU.left, this.BU.top);
                        break;
                }
                if (this.BO) {
                    this.BW.offset(aVar.Cd, aVar.Ce);
                } else {
                    this.BW.offset((int) ((aVar.Cd * f) + 0.5f), (int) ((aVar.Ce * f) + 0.5f));
                }
                childAt.layout((int) this.BW.left, (int) this.BW.top, (int) this.BW.right, (int) this.BW.bottom);
            }
        }
    }

    public void aa(boolean z) {
        this.BO = z;
    }

    private void a(View view, RectF rectF, int i) {
        switch (i) {
            case 16:
                rectF.left = this.BU.left;
                rectF.right = rectF.left + view.getMeasuredWidth();
                return;
            case 32:
                rectF.left = (this.BU.width() - view.getMeasuredWidth()) / 2.0f;
                rectF.right = (this.BU.width() + view.getMeasuredWidth()) / 2.0f;
                rectF.offset(this.BU.left, 0.0f);
                return;
            case 48:
                rectF.right = this.BU.right;
                rectF.left = rectF.right - view.getMeasuredWidth();
                return;
            default:
                return;
        }
    }

    private void b(View view, RectF rectF, int i) {
        switch (i) {
            case 16:
                rectF.top = this.BU.top;
                rectF.bottom = rectF.top + view.getMeasuredHeight();
                return;
            case 32:
                rectF.top = (this.BU.width() - view.getMeasuredHeight()) / 2.0f;
                rectF.bottom = (this.BU.width() + view.getMeasuredHeight()) / 2.0f;
                rectF.offset(0.0f, this.BU.top);
                return;
            case 48:
                rectF.bottom = this.BU.bottom;
                rectF.top = this.BU.bottom - view.getMeasuredHeight();
                return;
            default:
                return;
        }
    }

    private void iU() {
        this.BY.reset();
        this.BY.addRect(this.BU, Path.Direction.CW);
        this.BY.addRect(this.BV, Path.Direction.CW);
    }

    public void b(Rect rect) {
        this.BU.set(rect);
        iU();
        invalidate();
    }

    public void c(Rect rect) {
        this.BV.set(rect);
        iU();
        this.BZ = true;
        invalidate();
    }

    public void ah(int i) {
        this.BX.setAlpha(i);
        invalidate();
    }

    public void ai(int i) {
        this.BX.setColor(i);
        invalidate();
    }

    public void ae(boolean z) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* renamed from: iV */
    public a generateDefaultLayoutParams() {
        return new a(-2, -2);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        long drawingTime = getDrawingTime();
        canvas.save();
        canvas.drawRect(this.BV, this.BX);
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
        public int Cb;
        public int Cc;
        public int Cd;
        public int Ce;

        public a(int i, int i2) {
            super(i, i2);
            this.Cb = 4;
            this.Cc = 32;
            this.Cd = 0;
            this.Ce = 0;
        }
    }
}
