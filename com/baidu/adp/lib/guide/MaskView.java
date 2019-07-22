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
    private boolean zB;
    private final RectF zH;
    private final RectF zI;
    private final RectF zJ;
    private final Paint zK;
    private final Path zL;
    private boolean zM;
    private final Paint zN;

    public MaskView(Context context) {
        this(context, null, 0);
    }

    public MaskView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MaskView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.zH = new RectF();
        this.zI = new RectF();
        this.zJ = new RectF();
        this.zK = new Paint();
        this.zL = new Path();
        this.zB = false;
        this.zN = new Paint();
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.zN.setColor(SupportMenu.CATEGORY_MASK);
        this.zN.setStrokeWidth(10.0f);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        setFocusable(true);
        setFocusableInTouchMode(true);
        requestFocus();
        this.zL.setFillType(Path.FillType.EVEN_ODD);
        hW();
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
        if (!this.zM) {
            this.zI.set(0.0f, 0.0f, i3, i4);
            hW();
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
                switch (aVar.zO) {
                    case 1:
                        this.zJ.right = this.zH.left;
                        this.zJ.left = this.zJ.right - childAt.getMeasuredWidth();
                        b(childAt, this.zJ, aVar.zP);
                        break;
                    case 2:
                        this.zJ.bottom = this.zH.top;
                        this.zJ.top = this.zJ.bottom - childAt.getMeasuredHeight();
                        a(childAt, this.zJ, aVar.zP);
                        break;
                    case 3:
                        this.zJ.left = this.zH.right;
                        this.zJ.right = this.zJ.left + childAt.getMeasuredWidth();
                        b(childAt, this.zJ, aVar.zP);
                        break;
                    case 4:
                        this.zJ.top = this.zH.bottom;
                        this.zJ.bottom = this.zJ.top + childAt.getMeasuredHeight();
                        a(childAt, this.zJ, aVar.zP);
                        break;
                    case 5:
                        this.zJ.left = (((int) this.zH.width()) - childAt.getMeasuredWidth()) >> 1;
                        this.zJ.top = (((int) this.zH.height()) - childAt.getMeasuredHeight()) >> 1;
                        this.zJ.right = (((int) this.zH.width()) + childAt.getMeasuredWidth()) >> 1;
                        this.zJ.bottom = (((int) this.zH.height()) + childAt.getMeasuredHeight()) >> 1;
                        this.zJ.offset(this.zH.left, this.zH.top);
                        break;
                }
                if (this.zB) {
                    this.zJ.offset(aVar.zQ, aVar.zR);
                } else {
                    this.zJ.offset((int) ((aVar.zQ * f) + 0.5f), (int) ((aVar.zR * f) + 0.5f));
                }
                childAt.layout((int) this.zJ.left, (int) this.zJ.top, (int) this.zJ.right, (int) this.zJ.bottom);
            }
        }
    }

    public void S(boolean z) {
        this.zB = z;
    }

    private void a(View view, RectF rectF, int i) {
        switch (i) {
            case 16:
                rectF.left = this.zH.left;
                rectF.right = rectF.left + view.getMeasuredWidth();
                return;
            case 32:
                rectF.left = (this.zH.width() - view.getMeasuredWidth()) / 2.0f;
                rectF.right = (this.zH.width() + view.getMeasuredWidth()) / 2.0f;
                rectF.offset(this.zH.left, 0.0f);
                return;
            case 48:
                rectF.right = this.zH.right;
                rectF.left = rectF.right - view.getMeasuredWidth();
                return;
            default:
                return;
        }
    }

    private void b(View view, RectF rectF, int i) {
        switch (i) {
            case 16:
                rectF.top = this.zH.top;
                rectF.bottom = rectF.top + view.getMeasuredHeight();
                return;
            case 32:
                rectF.top = (this.zH.width() - view.getMeasuredHeight()) / 2.0f;
                rectF.bottom = (this.zH.width() + view.getMeasuredHeight()) / 2.0f;
                rectF.offset(0.0f, this.zH.top);
                return;
            case 48:
                rectF.bottom = this.zH.bottom;
                rectF.top = this.zH.bottom - view.getMeasuredHeight();
                return;
            default:
                return;
        }
    }

    private void hW() {
        this.zL.reset();
        this.zL.addRect(this.zH, Path.Direction.CW);
        this.zL.addRect(this.zI, Path.Direction.CW);
    }

    public void b(Rect rect) {
        this.zH.set(rect);
        hW();
        invalidate();
    }

    public void c(Rect rect) {
        this.zI.set(rect);
        hW();
        this.zM = true;
        invalidate();
    }

    public void Z(int i) {
        this.zK.setAlpha(i);
        invalidate();
    }

    public void aa(int i) {
        this.zK.setColor(i);
        invalidate();
    }

    public void W(boolean z) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* renamed from: hX */
    public a generateDefaultLayoutParams() {
        return new a(-2, -2);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        long drawingTime = getDrawingTime();
        canvas.save();
        canvas.drawRect(this.zI, this.zK);
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
        public int zO;
        public int zP;
        public int zQ;
        public int zR;

        public a(int i, int i2) {
            super(i, i2);
            this.zO = 4;
            this.zP = 32;
            this.zQ = 0;
            this.zR = 0;
        }
    }
}
