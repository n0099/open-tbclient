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
    private boolean BN;
    private final RectF BT;
    private final RectF BU;
    private final RectF BV;
    private final Paint BW;
    private final Path BX;
    private boolean BY;
    private final Paint BZ;
    private final Paint mPaint;

    public MaskView(Context context) {
        this(context, null, 0);
    }

    public MaskView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MaskView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.BT = new RectF();
        this.BU = new RectF();
        this.BV = new RectF();
        this.BW = new Paint();
        this.BX = new Path();
        this.BN = false;
        this.BZ = new Paint();
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.BZ.setColor(SupportMenu.CATEGORY_MASK);
        this.BZ.setStrokeWidth(10.0f);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        setFocusable(true);
        setFocusableInTouchMode(true);
        requestFocus();
        this.BX.setFillType(Path.FillType.EVEN_ODD);
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
        if (!this.BY) {
            this.BU.set(0.0f, 0.0f, i3, i4);
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
                switch (aVar.Ca) {
                    case 1:
                        this.BV.right = this.BT.left;
                        this.BV.left = this.BV.right - childAt.getMeasuredWidth();
                        b(childAt, this.BV, aVar.Cb);
                        break;
                    case 2:
                        this.BV.bottom = this.BT.top;
                        this.BV.top = this.BV.bottom - childAt.getMeasuredHeight();
                        a(childAt, this.BV, aVar.Cb);
                        break;
                    case 3:
                        this.BV.left = this.BT.right;
                        this.BV.right = this.BV.left + childAt.getMeasuredWidth();
                        b(childAt, this.BV, aVar.Cb);
                        break;
                    case 4:
                        this.BV.top = this.BT.bottom;
                        this.BV.bottom = this.BV.top + childAt.getMeasuredHeight();
                        a(childAt, this.BV, aVar.Cb);
                        break;
                    case 5:
                        this.BV.left = (((int) this.BT.width()) - childAt.getMeasuredWidth()) >> 1;
                        this.BV.top = (((int) this.BT.height()) - childAt.getMeasuredHeight()) >> 1;
                        this.BV.right = (((int) this.BT.width()) + childAt.getMeasuredWidth()) >> 1;
                        this.BV.bottom = (((int) this.BT.height()) + childAt.getMeasuredHeight()) >> 1;
                        this.BV.offset(this.BT.left, this.BT.top);
                        break;
                }
                if (this.BN) {
                    this.BV.offset(aVar.Cc, aVar.Cd);
                } else {
                    this.BV.offset((int) ((aVar.Cc * f) + 0.5f), (int) ((aVar.Cd * f) + 0.5f));
                }
                childAt.layout((int) this.BV.left, (int) this.BV.top, (int) this.BV.right, (int) this.BV.bottom);
            }
        }
    }

    public void aa(boolean z) {
        this.BN = z;
    }

    private void a(View view, RectF rectF, int i) {
        switch (i) {
            case 16:
                rectF.left = this.BT.left;
                rectF.right = rectF.left + view.getMeasuredWidth();
                return;
            case 32:
                rectF.left = (this.BT.width() - view.getMeasuredWidth()) / 2.0f;
                rectF.right = (this.BT.width() + view.getMeasuredWidth()) / 2.0f;
                rectF.offset(this.BT.left, 0.0f);
                return;
            case 48:
                rectF.right = this.BT.right;
                rectF.left = rectF.right - view.getMeasuredWidth();
                return;
            default:
                return;
        }
    }

    private void b(View view, RectF rectF, int i) {
        switch (i) {
            case 16:
                rectF.top = this.BT.top;
                rectF.bottom = rectF.top + view.getMeasuredHeight();
                return;
            case 32:
                rectF.top = (this.BT.width() - view.getMeasuredHeight()) / 2.0f;
                rectF.bottom = (this.BT.width() + view.getMeasuredHeight()) / 2.0f;
                rectF.offset(0.0f, this.BT.top);
                return;
            case 48:
                rectF.bottom = this.BT.bottom;
                rectF.top = this.BT.bottom - view.getMeasuredHeight();
                return;
            default:
                return;
        }
    }

    private void iU() {
        this.BX.reset();
        this.BX.addRect(this.BT, Path.Direction.CW);
        this.BX.addRect(this.BU, Path.Direction.CW);
    }

    public void b(Rect rect) {
        this.BT.set(rect);
        iU();
        invalidate();
    }

    public void c(Rect rect) {
        this.BU.set(rect);
        iU();
        this.BY = true;
        invalidate();
    }

    public void ag(int i) {
        this.BW.setAlpha(i);
        invalidate();
    }

    public void ah(int i) {
        this.BW.setColor(i);
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
        canvas.drawRect(this.BU, this.BW);
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
        public int Ca;
        public int Cb;
        public int Cc;
        public int Cd;

        public a(int i, int i2) {
            super(i, i2);
            this.Ca = 4;
            this.Cb = 32;
            this.Cc = 0;
            this.Cd = 0;
        }
    }
}
