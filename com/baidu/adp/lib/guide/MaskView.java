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
    private final RectF zB;
    private final RectF zC;
    private final RectF zD;
    private final Paint zE;
    private final Path zF;
    private boolean zG;
    private final Paint zH;
    private boolean zv;

    public MaskView(Context context) {
        this(context, null, 0);
    }

    public MaskView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MaskView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.zB = new RectF();
        this.zC = new RectF();
        this.zD = new RectF();
        this.zE = new Paint();
        this.zF = new Path();
        this.zv = false;
        this.zH = new Paint();
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.zH.setColor(SupportMenu.CATEGORY_MASK);
        this.zH.setStrokeWidth(10.0f);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        setFocusable(true);
        setFocusableInTouchMode(true);
        requestFocus();
        this.zF.setFillType(Path.FillType.EVEN_ODD);
        hM();
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
        if (!this.zG) {
            this.zC.set(0.0f, 0.0f, i3, i4);
            hM();
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
                switch (aVar.zI) {
                    case 1:
                        this.zD.right = this.zB.left;
                        this.zD.left = this.zD.right - childAt.getMeasuredWidth();
                        b(childAt, this.zD, aVar.zJ);
                        break;
                    case 2:
                        this.zD.bottom = this.zB.top;
                        this.zD.top = this.zD.bottom - childAt.getMeasuredHeight();
                        a(childAt, this.zD, aVar.zJ);
                        break;
                    case 3:
                        this.zD.left = this.zB.right;
                        this.zD.right = this.zD.left + childAt.getMeasuredWidth();
                        b(childAt, this.zD, aVar.zJ);
                        break;
                    case 4:
                        this.zD.top = this.zB.bottom;
                        this.zD.bottom = this.zD.top + childAt.getMeasuredHeight();
                        a(childAt, this.zD, aVar.zJ);
                        break;
                    case 5:
                        this.zD.left = (((int) this.zB.width()) - childAt.getMeasuredWidth()) >> 1;
                        this.zD.top = (((int) this.zB.height()) - childAt.getMeasuredHeight()) >> 1;
                        this.zD.right = (((int) this.zB.width()) + childAt.getMeasuredWidth()) >> 1;
                        this.zD.bottom = (((int) this.zB.height()) + childAt.getMeasuredHeight()) >> 1;
                        this.zD.offset(this.zB.left, this.zB.top);
                        break;
                }
                if (this.zv) {
                    this.zD.offset(aVar.zK, aVar.zL);
                } else {
                    this.zD.offset((int) ((aVar.zK * f) + 0.5f), (int) ((aVar.zL * f) + 0.5f));
                }
                childAt.layout((int) this.zD.left, (int) this.zD.top, (int) this.zD.right, (int) this.zD.bottom);
            }
        }
    }

    public void S(boolean z) {
        this.zv = z;
    }

    private void a(View view, RectF rectF, int i) {
        switch (i) {
            case 16:
                rectF.left = this.zB.left;
                rectF.right = rectF.left + view.getMeasuredWidth();
                return;
            case 32:
                rectF.left = (this.zB.width() - view.getMeasuredWidth()) / 2.0f;
                rectF.right = (this.zB.width() + view.getMeasuredWidth()) / 2.0f;
                rectF.offset(this.zB.left, 0.0f);
                return;
            case 48:
                rectF.right = this.zB.right;
                rectF.left = rectF.right - view.getMeasuredWidth();
                return;
            default:
                return;
        }
    }

    private void b(View view, RectF rectF, int i) {
        switch (i) {
            case 16:
                rectF.top = this.zB.top;
                rectF.bottom = rectF.top + view.getMeasuredHeight();
                return;
            case 32:
                rectF.top = (this.zB.width() - view.getMeasuredHeight()) / 2.0f;
                rectF.bottom = (this.zB.width() + view.getMeasuredHeight()) / 2.0f;
                rectF.offset(0.0f, this.zB.top);
                return;
            case 48:
                rectF.bottom = this.zB.bottom;
                rectF.top = this.zB.bottom - view.getMeasuredHeight();
                return;
            default:
                return;
        }
    }

    private void hM() {
        this.zF.reset();
        this.zF.addRect(this.zB, Path.Direction.CW);
        this.zF.addRect(this.zC, Path.Direction.CW);
    }

    public void b(Rect rect) {
        this.zB.set(rect);
        hM();
        invalidate();
    }

    public void c(Rect rect) {
        this.zC.set(rect);
        hM();
        this.zG = true;
        invalidate();
    }

    public void Z(int i) {
        this.zE.setAlpha(i);
        invalidate();
    }

    public void aa(int i) {
        this.zE.setColor(i);
        invalidate();
    }

    public void W(boolean z) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* renamed from: hN */
    public a generateDefaultLayoutParams() {
        return new a(-2, -2);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        long drawingTime = getDrawingTime();
        canvas.save();
        canvas.drawRect(this.zC, this.zE);
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
        public int zI;
        public int zJ;
        public int zK;
        public int zL;

        public a(int i, int i2) {
            super(i, i2);
            this.zI = 4;
            this.zJ = 32;
            this.zK = 0;
            this.zL = 0;
        }
    }
}
