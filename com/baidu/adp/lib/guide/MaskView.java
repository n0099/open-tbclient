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
    private boolean yM;
    private final RectF yS;
    private final RectF yT;
    private final RectF yU;
    private final Paint yV;
    private final Path yW;
    private boolean yX;
    private final Paint yY;

    public MaskView(Context context) {
        this(context, null, 0);
    }

    public MaskView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MaskView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.yS = new RectF();
        this.yT = new RectF();
        this.yU = new RectF();
        this.yV = new Paint();
        this.yW = new Path();
        this.yM = false;
        this.yY = new Paint();
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.yY.setColor(SupportMenu.CATEGORY_MASK);
        this.yY.setStrokeWidth(10.0f);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        setFocusable(true);
        setFocusableInTouchMode(true);
        requestFocus();
        this.yW.setFillType(Path.FillType.EVEN_ODD);
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
        if (!this.yX) {
            this.yT.set(0.0f, 0.0f, i3, i4);
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
                switch (aVar.yZ) {
                    case 1:
                        this.yU.right = this.yS.left;
                        this.yU.left = this.yU.right - childAt.getMeasuredWidth();
                        b(childAt, this.yU, aVar.za);
                        break;
                    case 2:
                        this.yU.bottom = this.yS.top;
                        this.yU.top = this.yU.bottom - childAt.getMeasuredHeight();
                        a(childAt, this.yU, aVar.za);
                        break;
                    case 3:
                        this.yU.left = this.yS.right;
                        this.yU.right = this.yU.left + childAt.getMeasuredWidth();
                        b(childAt, this.yU, aVar.za);
                        break;
                    case 4:
                        this.yU.top = this.yS.bottom;
                        this.yU.bottom = this.yU.top + childAt.getMeasuredHeight();
                        a(childAt, this.yU, aVar.za);
                        break;
                    case 5:
                        this.yU.left = (((int) this.yS.width()) - childAt.getMeasuredWidth()) >> 1;
                        this.yU.top = (((int) this.yS.height()) - childAt.getMeasuredHeight()) >> 1;
                        this.yU.right = (((int) this.yS.width()) + childAt.getMeasuredWidth()) >> 1;
                        this.yU.bottom = (((int) this.yS.height()) + childAt.getMeasuredHeight()) >> 1;
                        this.yU.offset(this.yS.left, this.yS.top);
                        break;
                }
                if (this.yM) {
                    this.yU.offset(aVar.zb, aVar.zc);
                } else {
                    this.yU.offset((int) ((aVar.zb * f) + 0.5f), (int) ((aVar.zc * f) + 0.5f));
                }
                childAt.layout((int) this.yU.left, (int) this.yU.top, (int) this.yU.right, (int) this.yU.bottom);
            }
        }
    }

    public void D(boolean z) {
        this.yM = z;
    }

    private void a(View view, RectF rectF, int i) {
        switch (i) {
            case 16:
                rectF.left = this.yS.left;
                rectF.right = rectF.left + view.getMeasuredWidth();
                return;
            case 32:
                rectF.left = (this.yS.width() - view.getMeasuredWidth()) / 2.0f;
                rectF.right = (this.yS.width() + view.getMeasuredWidth()) / 2.0f;
                rectF.offset(this.yS.left, 0.0f);
                return;
            case 48:
                rectF.right = this.yS.right;
                rectF.left = rectF.right - view.getMeasuredWidth();
                return;
            default:
                return;
        }
    }

    private void b(View view, RectF rectF, int i) {
        switch (i) {
            case 16:
                rectF.top = this.yS.top;
                rectF.bottom = rectF.top + view.getMeasuredHeight();
                return;
            case 32:
                rectF.top = (this.yS.width() - view.getMeasuredHeight()) / 2.0f;
                rectF.bottom = (this.yS.width() + view.getMeasuredHeight()) / 2.0f;
                rectF.offset(0.0f, this.yS.top);
                return;
            case 48:
                rectF.bottom = this.yS.bottom;
                rectF.top = this.yS.bottom - view.getMeasuredHeight();
                return;
            default:
                return;
        }
    }

    private void hz() {
        this.yW.reset();
        this.yW.addRect(this.yS, Path.Direction.CW);
        this.yW.addRect(this.yT, Path.Direction.CW);
    }

    public void b(Rect rect) {
        this.yS.set(rect);
        hz();
        invalidate();
    }

    public void c(Rect rect) {
        this.yT.set(rect);
        hz();
        this.yX = true;
        invalidate();
    }

    public void Z(int i) {
        this.yV.setAlpha(i);
        invalidate();
    }

    public void aa(int i) {
        this.yV.setColor(i);
        invalidate();
    }

    public void H(boolean z) {
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
        canvas.drawRect(this.yT, this.yV);
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
        public int yZ;
        public int za;
        public int zb;
        public int zc;

        public a(int i, int i2) {
            super(i, i2);
            this.yZ = 4;
            this.za = 32;
            this.zb = 0;
            this.zc = 0;
        }
    }
}
