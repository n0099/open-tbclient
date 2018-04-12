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
    private final Paint mPaint;
    private boolean sF;
    private final RectF sL;
    private final RectF sM;
    private final RectF sN;
    private final Paint sO;
    private final Path sP;
    private boolean sQ;
    private final Paint sR;

    public MaskView(Context context) {
        this(context, null, 0);
    }

    public MaskView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MaskView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.sL = new RectF();
        this.sM = new RectF();
        this.sN = new RectF();
        this.sO = new Paint();
        this.sP = new Path();
        this.sF = false;
        this.sR = new Paint();
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.sR.setColor(SupportMenu.CATEGORY_MASK);
        this.sR.setStrokeWidth(10.0f);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        setFocusable(true);
        setFocusableInTouchMode(true);
        requestFocus();
        this.sP.setFillType(Path.FillType.EVEN_ODD);
        eI();
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
        if (!this.sQ) {
            this.sM.set(0.0f, 0.0f, i3, i4);
            eI();
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
                switch (aVar.sS) {
                    case 1:
                        this.sN.right = this.sL.left;
                        this.sN.left = this.sN.right - childAt.getMeasuredWidth();
                        b(childAt, this.sN, aVar.sT);
                        break;
                    case 2:
                        this.sN.bottom = this.sL.top;
                        this.sN.top = this.sN.bottom - childAt.getMeasuredHeight();
                        a(childAt, this.sN, aVar.sT);
                        break;
                    case 3:
                        this.sN.left = this.sL.right;
                        this.sN.right = this.sN.left + childAt.getMeasuredWidth();
                        b(childAt, this.sN, aVar.sT);
                        break;
                    case 4:
                        this.sN.top = this.sL.bottom;
                        this.sN.bottom = this.sN.top + childAt.getMeasuredHeight();
                        a(childAt, this.sN, aVar.sT);
                        break;
                    case 5:
                        this.sN.left = (((int) this.sL.width()) - childAt.getMeasuredWidth()) >> 1;
                        this.sN.top = (((int) this.sL.height()) - childAt.getMeasuredHeight()) >> 1;
                        this.sN.right = (((int) this.sL.width()) + childAt.getMeasuredWidth()) >> 1;
                        this.sN.bottom = (((int) this.sL.height()) + childAt.getMeasuredHeight()) >> 1;
                        this.sN.offset(this.sL.left, this.sL.top);
                        break;
                }
                if (this.sF) {
                    this.sN.offset(aVar.sU, aVar.sV);
                } else {
                    this.sN.offset((int) ((aVar.sU * f) + 0.5f), (int) ((aVar.sV * f) + 0.5f));
                }
                childAt.layout((int) this.sN.left, (int) this.sN.top, (int) this.sN.right, (int) this.sN.bottom);
            }
        }
    }

    public void B(boolean z) {
        this.sF = z;
    }

    private void a(View view2, RectF rectF, int i) {
        switch (i) {
            case 16:
                rectF.left = this.sL.left;
                rectF.right = rectF.left + view2.getMeasuredWidth();
                return;
            case 32:
                rectF.left = (this.sL.width() - view2.getMeasuredWidth()) / 2.0f;
                rectF.right = (this.sL.width() + view2.getMeasuredWidth()) / 2.0f;
                rectF.offset(this.sL.left, 0.0f);
                return;
            case 48:
                rectF.right = this.sL.right;
                rectF.left = rectF.right - view2.getMeasuredWidth();
                return;
            default:
                return;
        }
    }

    private void b(View view2, RectF rectF, int i) {
        switch (i) {
            case 16:
                rectF.top = this.sL.top;
                rectF.bottom = rectF.top + view2.getMeasuredHeight();
                return;
            case 32:
                rectF.top = (this.sL.width() - view2.getMeasuredHeight()) / 2.0f;
                rectF.bottom = (this.sL.width() + view2.getMeasuredHeight()) / 2.0f;
                rectF.offset(0.0f, this.sL.top);
                return;
            case 48:
                rectF.bottom = this.sL.bottom;
                rectF.top = this.sL.bottom - view2.getMeasuredHeight();
                return;
            default:
                return;
        }
    }

    private void eI() {
        this.sP.reset();
        this.sP.addRect(this.sL, Path.Direction.CW);
        this.sP.addRect(this.sM, Path.Direction.CW);
    }

    public void b(Rect rect) {
        this.sL.set(rect);
        eI();
        invalidate();
    }

    public void c(Rect rect) {
        this.sM.set(rect);
        eI();
        this.sQ = true;
        invalidate();
    }

    public void Y(int i) {
        this.sO.setAlpha(i);
        invalidate();
    }

    public void Z(int i) {
        this.sO.setColor(i);
        invalidate();
    }

    public void F(boolean z) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* renamed from: eJ */
    public a generateDefaultLayoutParams() {
        return new a(-2, -2);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        long drawingTime = getDrawingTime();
        canvas.save();
        canvas.drawRect(this.sM, this.sO);
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
        public int sS;
        public int sT;
        public int sU;
        public int sV;

        public a(int i, int i2) {
            super(i, i2);
            this.sS = 4;
            this.sT = 32;
            this.sU = 0;
            this.sV = 0;
        }
    }
}
