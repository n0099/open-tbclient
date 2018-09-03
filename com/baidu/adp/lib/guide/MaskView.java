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
    private boolean yI;
    private final RectF yO;
    private final RectF yP;
    private final RectF yQ;
    private final Paint yR;
    private final Path yS;
    private boolean yT;
    private final Paint yU;

    public MaskView(Context context) {
        this(context, null, 0);
    }

    public MaskView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MaskView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.yO = new RectF();
        this.yP = new RectF();
        this.yQ = new RectF();
        this.yR = new Paint();
        this.yS = new Path();
        this.yI = false;
        this.yU = new Paint();
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.yU.setColor(SupportMenu.CATEGORY_MASK);
        this.yU.setStrokeWidth(10.0f);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        setFocusable(true);
        setFocusableInTouchMode(true);
        requestFocus();
        this.yS.setFillType(Path.FillType.EVEN_ODD);
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
        if (!this.yT) {
            this.yP.set(0.0f, 0.0f, i3, i4);
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
                switch (aVar.yV) {
                    case 1:
                        this.yQ.right = this.yO.left;
                        this.yQ.left = this.yQ.right - childAt.getMeasuredWidth();
                        b(childAt, this.yQ, aVar.yW);
                        break;
                    case 2:
                        this.yQ.bottom = this.yO.top;
                        this.yQ.top = this.yQ.bottom - childAt.getMeasuredHeight();
                        a(childAt, this.yQ, aVar.yW);
                        break;
                    case 3:
                        this.yQ.left = this.yO.right;
                        this.yQ.right = this.yQ.left + childAt.getMeasuredWidth();
                        b(childAt, this.yQ, aVar.yW);
                        break;
                    case 4:
                        this.yQ.top = this.yO.bottom;
                        this.yQ.bottom = this.yQ.top + childAt.getMeasuredHeight();
                        a(childAt, this.yQ, aVar.yW);
                        break;
                    case 5:
                        this.yQ.left = (((int) this.yO.width()) - childAt.getMeasuredWidth()) >> 1;
                        this.yQ.top = (((int) this.yO.height()) - childAt.getMeasuredHeight()) >> 1;
                        this.yQ.right = (((int) this.yO.width()) + childAt.getMeasuredWidth()) >> 1;
                        this.yQ.bottom = (((int) this.yO.height()) + childAt.getMeasuredHeight()) >> 1;
                        this.yQ.offset(this.yO.left, this.yO.top);
                        break;
                }
                if (this.yI) {
                    this.yQ.offset(aVar.yX, aVar.yY);
                } else {
                    this.yQ.offset((int) ((aVar.yX * f) + 0.5f), (int) ((aVar.yY * f) + 0.5f));
                }
                childAt.layout((int) this.yQ.left, (int) this.yQ.top, (int) this.yQ.right, (int) this.yQ.bottom);
            }
        }
    }

    public void C(boolean z) {
        this.yI = z;
    }

    private void a(View view, RectF rectF, int i) {
        switch (i) {
            case 16:
                rectF.left = this.yO.left;
                rectF.right = rectF.left + view.getMeasuredWidth();
                return;
            case 32:
                rectF.left = (this.yO.width() - view.getMeasuredWidth()) / 2.0f;
                rectF.right = (this.yO.width() + view.getMeasuredWidth()) / 2.0f;
                rectF.offset(this.yO.left, 0.0f);
                return;
            case 48:
                rectF.right = this.yO.right;
                rectF.left = rectF.right - view.getMeasuredWidth();
                return;
            default:
                return;
        }
    }

    private void b(View view, RectF rectF, int i) {
        switch (i) {
            case 16:
                rectF.top = this.yO.top;
                rectF.bottom = rectF.top + view.getMeasuredHeight();
                return;
            case 32:
                rectF.top = (this.yO.width() - view.getMeasuredHeight()) / 2.0f;
                rectF.bottom = (this.yO.width() + view.getMeasuredHeight()) / 2.0f;
                rectF.offset(0.0f, this.yO.top);
                return;
            case 48:
                rectF.bottom = this.yO.bottom;
                rectF.top = this.yO.bottom - view.getMeasuredHeight();
                return;
            default:
                return;
        }
    }

    private void hz() {
        this.yS.reset();
        this.yS.addRect(this.yO, Path.Direction.CW);
        this.yS.addRect(this.yP, Path.Direction.CW);
    }

    public void b(Rect rect) {
        this.yO.set(rect);
        hz();
        invalidate();
    }

    public void c(Rect rect) {
        this.yP.set(rect);
        hz();
        this.yT = true;
        invalidate();
    }

    public void Z(int i) {
        this.yR.setAlpha(i);
        invalidate();
    }

    public void aa(int i) {
        this.yR.setColor(i);
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
        canvas.drawRect(this.yP, this.yR);
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
        public int yV;
        public int yW;
        public int yX;
        public int yY;

        public a(int i, int i2) {
            super(i, i2);
            this.yV = 4;
            this.yW = 32;
            this.yX = 0;
            this.yY = 0;
        }
    }
}
