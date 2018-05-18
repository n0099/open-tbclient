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
    private boolean sE;
    private final RectF sK;
    private final RectF sL;
    private final RectF sM;
    private final Paint sN;
    private final Path sO;
    private boolean sP;
    private final Paint sQ;

    public MaskView(Context context) {
        this(context, null, 0);
    }

    public MaskView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MaskView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.sK = new RectF();
        this.sL = new RectF();
        this.sM = new RectF();
        this.sN = new Paint();
        this.sO = new Path();
        this.sE = false;
        this.sQ = new Paint();
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.sQ.setColor(SupportMenu.CATEGORY_MASK);
        this.sQ.setStrokeWidth(10.0f);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        setFocusable(true);
        setFocusableInTouchMode(true);
        requestFocus();
        this.sO.setFillType(Path.FillType.EVEN_ODD);
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
        if (!this.sP) {
            this.sL.set(0.0f, 0.0f, i3, i4);
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
                switch (aVar.sR) {
                    case 1:
                        this.sM.right = this.sK.left;
                        this.sM.left = this.sM.right - childAt.getMeasuredWidth();
                        b(childAt, this.sM, aVar.sS);
                        break;
                    case 2:
                        this.sM.bottom = this.sK.top;
                        this.sM.top = this.sM.bottom - childAt.getMeasuredHeight();
                        a(childAt, this.sM, aVar.sS);
                        break;
                    case 3:
                        this.sM.left = this.sK.right;
                        this.sM.right = this.sM.left + childAt.getMeasuredWidth();
                        b(childAt, this.sM, aVar.sS);
                        break;
                    case 4:
                        this.sM.top = this.sK.bottom;
                        this.sM.bottom = this.sM.top + childAt.getMeasuredHeight();
                        a(childAt, this.sM, aVar.sS);
                        break;
                    case 5:
                        this.sM.left = (((int) this.sK.width()) - childAt.getMeasuredWidth()) >> 1;
                        this.sM.top = (((int) this.sK.height()) - childAt.getMeasuredHeight()) >> 1;
                        this.sM.right = (((int) this.sK.width()) + childAt.getMeasuredWidth()) >> 1;
                        this.sM.bottom = (((int) this.sK.height()) + childAt.getMeasuredHeight()) >> 1;
                        this.sM.offset(this.sK.left, this.sK.top);
                        break;
                }
                if (this.sE) {
                    this.sM.offset(aVar.sT, aVar.sU);
                } else {
                    this.sM.offset((int) ((aVar.sT * f) + 0.5f), (int) ((aVar.sU * f) + 0.5f));
                }
                childAt.layout((int) this.sM.left, (int) this.sM.top, (int) this.sM.right, (int) this.sM.bottom);
            }
        }
    }

    public void B(boolean z) {
        this.sE = z;
    }

    private void a(View view2, RectF rectF, int i) {
        switch (i) {
            case 16:
                rectF.left = this.sK.left;
                rectF.right = rectF.left + view2.getMeasuredWidth();
                return;
            case 32:
                rectF.left = (this.sK.width() - view2.getMeasuredWidth()) / 2.0f;
                rectF.right = (this.sK.width() + view2.getMeasuredWidth()) / 2.0f;
                rectF.offset(this.sK.left, 0.0f);
                return;
            case 48:
                rectF.right = this.sK.right;
                rectF.left = rectF.right - view2.getMeasuredWidth();
                return;
            default:
                return;
        }
    }

    private void b(View view2, RectF rectF, int i) {
        switch (i) {
            case 16:
                rectF.top = this.sK.top;
                rectF.bottom = rectF.top + view2.getMeasuredHeight();
                return;
            case 32:
                rectF.top = (this.sK.width() - view2.getMeasuredHeight()) / 2.0f;
                rectF.bottom = (this.sK.width() + view2.getMeasuredHeight()) / 2.0f;
                rectF.offset(0.0f, this.sK.top);
                return;
            case 48:
                rectF.bottom = this.sK.bottom;
                rectF.top = this.sK.bottom - view2.getMeasuredHeight();
                return;
            default:
                return;
        }
    }

    private void eI() {
        this.sO.reset();
        this.sO.addRect(this.sK, Path.Direction.CW);
        this.sO.addRect(this.sL, Path.Direction.CW);
    }

    public void b(Rect rect) {
        this.sK.set(rect);
        eI();
        invalidate();
    }

    public void c(Rect rect) {
        this.sL.set(rect);
        eI();
        this.sP = true;
        invalidate();
    }

    public void Y(int i) {
        this.sN.setAlpha(i);
        invalidate();
    }

    public void Z(int i) {
        this.sN.setColor(i);
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
        canvas.drawRect(this.sL, this.sN);
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
        public int sR;
        public int sS;
        public int sT;
        public int sU;

        public a(int i, int i2) {
            super(i, i2);
            this.sR = 4;
            this.sS = 32;
            this.sT = 0;
            this.sU = 0;
        }
    }
}
