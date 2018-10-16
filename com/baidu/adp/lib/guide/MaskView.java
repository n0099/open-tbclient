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
    private boolean BL;
    private final RectF BR;
    private final RectF BS;
    private final RectF BT;
    private final Paint BU;
    private final Path BV;
    private boolean BW;
    private final Paint BX;
    private final Paint mPaint;

    public MaskView(Context context) {
        this(context, null, 0);
    }

    public MaskView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MaskView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.BR = new RectF();
        this.BS = new RectF();
        this.BT = new RectF();
        this.BU = new Paint();
        this.BV = new Path();
        this.BL = false;
        this.BX = new Paint();
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.BX.setColor(SupportMenu.CATEGORY_MASK);
        this.BX.setStrokeWidth(10.0f);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        setFocusable(true);
        setFocusableInTouchMode(true);
        requestFocus();
        this.BV.setFillType(Path.FillType.EVEN_ODD);
        iV();
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
        if (!this.BW) {
            this.BS.set(0.0f, 0.0f, i3, i4);
            iV();
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
                switch (aVar.BY) {
                    case 1:
                        this.BT.right = this.BR.left;
                        this.BT.left = this.BT.right - childAt.getMeasuredWidth();
                        b(childAt, this.BT, aVar.BZ);
                        break;
                    case 2:
                        this.BT.bottom = this.BR.top;
                        this.BT.top = this.BT.bottom - childAt.getMeasuredHeight();
                        a(childAt, this.BT, aVar.BZ);
                        break;
                    case 3:
                        this.BT.left = this.BR.right;
                        this.BT.right = this.BT.left + childAt.getMeasuredWidth();
                        b(childAt, this.BT, aVar.BZ);
                        break;
                    case 4:
                        this.BT.top = this.BR.bottom;
                        this.BT.bottom = this.BT.top + childAt.getMeasuredHeight();
                        a(childAt, this.BT, aVar.BZ);
                        break;
                    case 5:
                        this.BT.left = (((int) this.BR.width()) - childAt.getMeasuredWidth()) >> 1;
                        this.BT.top = (((int) this.BR.height()) - childAt.getMeasuredHeight()) >> 1;
                        this.BT.right = (((int) this.BR.width()) + childAt.getMeasuredWidth()) >> 1;
                        this.BT.bottom = (((int) this.BR.height()) + childAt.getMeasuredHeight()) >> 1;
                        this.BT.offset(this.BR.left, this.BR.top);
                        break;
                }
                if (this.BL) {
                    this.BT.offset(aVar.Ca, aVar.Cb);
                } else {
                    this.BT.offset((int) ((aVar.Ca * f) + 0.5f), (int) ((aVar.Cb * f) + 0.5f));
                }
                childAt.layout((int) this.BT.left, (int) this.BT.top, (int) this.BT.right, (int) this.BT.bottom);
            }
        }
    }

    public void M(boolean z) {
        this.BL = z;
    }

    private void a(View view, RectF rectF, int i) {
        switch (i) {
            case 16:
                rectF.left = this.BR.left;
                rectF.right = rectF.left + view.getMeasuredWidth();
                return;
            case 32:
                rectF.left = (this.BR.width() - view.getMeasuredWidth()) / 2.0f;
                rectF.right = (this.BR.width() + view.getMeasuredWidth()) / 2.0f;
                rectF.offset(this.BR.left, 0.0f);
                return;
            case 48:
                rectF.right = this.BR.right;
                rectF.left = rectF.right - view.getMeasuredWidth();
                return;
            default:
                return;
        }
    }

    private void b(View view, RectF rectF, int i) {
        switch (i) {
            case 16:
                rectF.top = this.BR.top;
                rectF.bottom = rectF.top + view.getMeasuredHeight();
                return;
            case 32:
                rectF.top = (this.BR.width() - view.getMeasuredHeight()) / 2.0f;
                rectF.bottom = (this.BR.width() + view.getMeasuredHeight()) / 2.0f;
                rectF.offset(0.0f, this.BR.top);
                return;
            case 48:
                rectF.bottom = this.BR.bottom;
                rectF.top = this.BR.bottom - view.getMeasuredHeight();
                return;
            default:
                return;
        }
    }

    private void iV() {
        this.BV.reset();
        this.BV.addRect(this.BR, Path.Direction.CW);
        this.BV.addRect(this.BS, Path.Direction.CW);
    }

    public void b(Rect rect) {
        this.BR.set(rect);
        iV();
        invalidate();
    }

    public void c(Rect rect) {
        this.BS.set(rect);
        iV();
        this.BW = true;
        invalidate();
    }

    public void ah(int i) {
        this.BU.setAlpha(i);
        invalidate();
    }

    public void ai(int i) {
        this.BU.setColor(i);
        invalidate();
    }

    public void Q(boolean z) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* renamed from: iW */
    public a generateDefaultLayoutParams() {
        return new a(-2, -2);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        long drawingTime = getDrawingTime();
        canvas.save();
        canvas.drawRect(this.BS, this.BU);
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
        public int BY;
        public int BZ;
        public int Ca;
        public int Cb;

        public a(int i, int i2) {
            super(i, i2);
            this.BY = 4;
            this.BZ = 32;
            this.Ca = 0;
            this.Cb = 0;
        }
    }
}
