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
    private boolean yH;
    private final RectF yN;
    private final RectF yO;
    private final RectF yP;
    private final Paint yQ;
    private final Path yR;
    private boolean yS;
    private final Paint yT;

    public MaskView(Context context) {
        this(context, null, 0);
    }

    public MaskView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MaskView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.yN = new RectF();
        this.yO = new RectF();
        this.yP = new RectF();
        this.yQ = new Paint();
        this.yR = new Path();
        this.yH = false;
        this.yT = new Paint();
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.yT.setColor(SupportMenu.CATEGORY_MASK);
        this.yT.setStrokeWidth(10.0f);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        setFocusable(true);
        setFocusableInTouchMode(true);
        requestFocus();
        this.yR.setFillType(Path.FillType.EVEN_ODD);
        hz();
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
        if (!this.yS) {
            this.yO.set(0.0f, 0.0f, i3, i4);
            hz();
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
                switch (aVar.yU) {
                    case 1:
                        this.yP.right = this.yN.left;
                        this.yP.left = this.yP.right - childAt.getMeasuredWidth();
                        b(childAt, this.yP, aVar.yV);
                        break;
                    case 2:
                        this.yP.bottom = this.yN.top;
                        this.yP.top = this.yP.bottom - childAt.getMeasuredHeight();
                        a(childAt, this.yP, aVar.yV);
                        break;
                    case 3:
                        this.yP.left = this.yN.right;
                        this.yP.right = this.yP.left + childAt.getMeasuredWidth();
                        b(childAt, this.yP, aVar.yV);
                        break;
                    case 4:
                        this.yP.top = this.yN.bottom;
                        this.yP.bottom = this.yP.top + childAt.getMeasuredHeight();
                        a(childAt, this.yP, aVar.yV);
                        break;
                    case 5:
                        this.yP.left = (((int) this.yN.width()) - childAt.getMeasuredWidth()) >> 1;
                        this.yP.top = (((int) this.yN.height()) - childAt.getMeasuredHeight()) >> 1;
                        this.yP.right = (((int) this.yN.width()) + childAt.getMeasuredWidth()) >> 1;
                        this.yP.bottom = (((int) this.yN.height()) + childAt.getMeasuredHeight()) >> 1;
                        this.yP.offset(this.yN.left, this.yN.top);
                        break;
                }
                if (this.yH) {
                    this.yP.offset(aVar.yW, aVar.yX);
                } else {
                    this.yP.offset((int) ((aVar.yW * f) + 0.5f), (int) ((aVar.yX * f) + 0.5f));
                }
                childAt.layout((int) this.yP.left, (int) this.yP.top, (int) this.yP.right, (int) this.yP.bottom);
            }
        }
    }

    public void C(boolean z) {
        this.yH = z;
    }

    private void a(View view, RectF rectF, int i) {
        switch (i) {
            case 16:
                rectF.left = this.yN.left;
                rectF.right = rectF.left + view.getMeasuredWidth();
                return;
            case 32:
                rectF.left = (this.yN.width() - view.getMeasuredWidth()) / 2.0f;
                rectF.right = (this.yN.width() + view.getMeasuredWidth()) / 2.0f;
                rectF.offset(this.yN.left, 0.0f);
                return;
            case 48:
                rectF.right = this.yN.right;
                rectF.left = rectF.right - view.getMeasuredWidth();
                return;
            default:
                return;
        }
    }

    private void b(View view, RectF rectF, int i) {
        switch (i) {
            case 16:
                rectF.top = this.yN.top;
                rectF.bottom = rectF.top + view.getMeasuredHeight();
                return;
            case 32:
                rectF.top = (this.yN.width() - view.getMeasuredHeight()) / 2.0f;
                rectF.bottom = (this.yN.width() + view.getMeasuredHeight()) / 2.0f;
                rectF.offset(0.0f, this.yN.top);
                return;
            case 48:
                rectF.bottom = this.yN.bottom;
                rectF.top = this.yN.bottom - view.getMeasuredHeight();
                return;
            default:
                return;
        }
    }

    private void hz() {
        this.yR.reset();
        this.yR.addRect(this.yN, Path.Direction.CW);
        this.yR.addRect(this.yO, Path.Direction.CW);
    }

    public void b(Rect rect) {
        this.yN.set(rect);
        hz();
        invalidate();
    }

    public void c(Rect rect) {
        this.yO.set(rect);
        hz();
        this.yS = true;
        invalidate();
    }

    public void Z(int i) {
        this.yQ.setAlpha(i);
        invalidate();
    }

    public void aa(int i) {
        this.yQ.setColor(i);
        invalidate();
    }

    public void G(boolean z) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* renamed from: hA */
    public a generateDefaultLayoutParams() {
        return new a(-2, -2);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        long drawingTime = getDrawingTime();
        canvas.save();
        canvas.drawRect(this.yO, this.yQ);
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
        public int yU;
        public int yV;
        public int yW;
        public int yX;

        public a(int i, int i2) {
            super(i, i2);
            this.yU = 4;
            this.yV = 32;
            this.yW = 0;
            this.yX = 0;
        }
    }
}
