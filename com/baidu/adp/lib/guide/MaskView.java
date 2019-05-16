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
    private final RectF zC;
    private final RectF zD;
    private final RectF zE;
    private final Paint zF;
    private final Path zG;
    private boolean zH;
    private final Paint zI;
    private boolean zw;

    public MaskView(Context context) {
        this(context, null, 0);
    }

    public MaskView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MaskView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.zC = new RectF();
        this.zD = new RectF();
        this.zE = new RectF();
        this.zF = new Paint();
        this.zG = new Path();
        this.zw = false;
        this.zI = new Paint();
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.zI.setColor(SupportMenu.CATEGORY_MASK);
        this.zI.setStrokeWidth(10.0f);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        setFocusable(true);
        setFocusableInTouchMode(true);
        requestFocus();
        this.zG.setFillType(Path.FillType.EVEN_ODD);
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
        if (!this.zH) {
            this.zD.set(0.0f, 0.0f, i3, i4);
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
                switch (aVar.zJ) {
                    case 1:
                        this.zE.right = this.zC.left;
                        this.zE.left = this.zE.right - childAt.getMeasuredWidth();
                        b(childAt, this.zE, aVar.zK);
                        break;
                    case 2:
                        this.zE.bottom = this.zC.top;
                        this.zE.top = this.zE.bottom - childAt.getMeasuredHeight();
                        a(childAt, this.zE, aVar.zK);
                        break;
                    case 3:
                        this.zE.left = this.zC.right;
                        this.zE.right = this.zE.left + childAt.getMeasuredWidth();
                        b(childAt, this.zE, aVar.zK);
                        break;
                    case 4:
                        this.zE.top = this.zC.bottom;
                        this.zE.bottom = this.zE.top + childAt.getMeasuredHeight();
                        a(childAt, this.zE, aVar.zK);
                        break;
                    case 5:
                        this.zE.left = (((int) this.zC.width()) - childAt.getMeasuredWidth()) >> 1;
                        this.zE.top = (((int) this.zC.height()) - childAt.getMeasuredHeight()) >> 1;
                        this.zE.right = (((int) this.zC.width()) + childAt.getMeasuredWidth()) >> 1;
                        this.zE.bottom = (((int) this.zC.height()) + childAt.getMeasuredHeight()) >> 1;
                        this.zE.offset(this.zC.left, this.zC.top);
                        break;
                }
                if (this.zw) {
                    this.zE.offset(aVar.zL, aVar.zM);
                } else {
                    this.zE.offset((int) ((aVar.zL * f) + 0.5f), (int) ((aVar.zM * f) + 0.5f));
                }
                childAt.layout((int) this.zE.left, (int) this.zE.top, (int) this.zE.right, (int) this.zE.bottom);
            }
        }
    }

    public void S(boolean z) {
        this.zw = z;
    }

    private void a(View view, RectF rectF, int i) {
        switch (i) {
            case 16:
                rectF.left = this.zC.left;
                rectF.right = rectF.left + view.getMeasuredWidth();
                return;
            case 32:
                rectF.left = (this.zC.width() - view.getMeasuredWidth()) / 2.0f;
                rectF.right = (this.zC.width() + view.getMeasuredWidth()) / 2.0f;
                rectF.offset(this.zC.left, 0.0f);
                return;
            case 48:
                rectF.right = this.zC.right;
                rectF.left = rectF.right - view.getMeasuredWidth();
                return;
            default:
                return;
        }
    }

    private void b(View view, RectF rectF, int i) {
        switch (i) {
            case 16:
                rectF.top = this.zC.top;
                rectF.bottom = rectF.top + view.getMeasuredHeight();
                return;
            case 32:
                rectF.top = (this.zC.width() - view.getMeasuredHeight()) / 2.0f;
                rectF.bottom = (this.zC.width() + view.getMeasuredHeight()) / 2.0f;
                rectF.offset(0.0f, this.zC.top);
                return;
            case 48:
                rectF.bottom = this.zC.bottom;
                rectF.top = this.zC.bottom - view.getMeasuredHeight();
                return;
            default:
                return;
        }
    }

    private void hM() {
        this.zG.reset();
        this.zG.addRect(this.zC, Path.Direction.CW);
        this.zG.addRect(this.zD, Path.Direction.CW);
    }

    public void b(Rect rect) {
        this.zC.set(rect);
        hM();
        invalidate();
    }

    public void c(Rect rect) {
        this.zD.set(rect);
        hM();
        this.zH = true;
        invalidate();
    }

    public void Z(int i) {
        this.zF.setAlpha(i);
        invalidate();
    }

    public void aa(int i) {
        this.zF.setColor(i);
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
        canvas.drawRect(this.zD, this.zF);
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
        public int zJ;
        public int zK;
        public int zL;
        public int zM;

        public a(int i, int i2) {
            super(i, i2);
            this.zJ = 4;
            this.zK = 32;
            this.zL = 0;
            this.zM = 0;
        }
    }
}
