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
    private boolean yO;
    private final RectF yU;
    private final RectF yV;
    private final RectF yW;
    private final Paint yX;
    private final Path yY;
    private boolean yZ;
    private final Paint za;

    public MaskView(Context context) {
        this(context, null, 0);
    }

    public MaskView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MaskView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.yU = new RectF();
        this.yV = new RectF();
        this.yW = new RectF();
        this.yX = new Paint();
        this.yY = new Path();
        this.yO = false;
        this.za = new Paint();
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.za.setColor(SupportMenu.CATEGORY_MASK);
        this.za.setStrokeWidth(10.0f);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        setFocusable(true);
        setFocusableInTouchMode(true);
        requestFocus();
        this.yY.setFillType(Path.FillType.EVEN_ODD);
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
        if (!this.yZ) {
            this.yV.set(0.0f, 0.0f, i3, i4);
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
                switch (aVar.zb) {
                    case 1:
                        this.yW.right = this.yU.left;
                        this.yW.left = this.yW.right - childAt.getMeasuredWidth();
                        b(childAt, this.yW, aVar.zc);
                        break;
                    case 2:
                        this.yW.bottom = this.yU.top;
                        this.yW.top = this.yW.bottom - childAt.getMeasuredHeight();
                        a(childAt, this.yW, aVar.zc);
                        break;
                    case 3:
                        this.yW.left = this.yU.right;
                        this.yW.right = this.yW.left + childAt.getMeasuredWidth();
                        b(childAt, this.yW, aVar.zc);
                        break;
                    case 4:
                        this.yW.top = this.yU.bottom;
                        this.yW.bottom = this.yW.top + childAt.getMeasuredHeight();
                        a(childAt, this.yW, aVar.zc);
                        break;
                    case 5:
                        this.yW.left = (((int) this.yU.width()) - childAt.getMeasuredWidth()) >> 1;
                        this.yW.top = (((int) this.yU.height()) - childAt.getMeasuredHeight()) >> 1;
                        this.yW.right = (((int) this.yU.width()) + childAt.getMeasuredWidth()) >> 1;
                        this.yW.bottom = (((int) this.yU.height()) + childAt.getMeasuredHeight()) >> 1;
                        this.yW.offset(this.yU.left, this.yU.top);
                        break;
                }
                if (this.yO) {
                    this.yW.offset(aVar.zd, aVar.ze);
                } else {
                    this.yW.offset((int) ((aVar.zd * f) + 0.5f), (int) ((aVar.ze * f) + 0.5f));
                }
                childAt.layout((int) this.yW.left, (int) this.yW.top, (int) this.yW.right, (int) this.yW.bottom);
            }
        }
    }

    public void D(boolean z) {
        this.yO = z;
    }

    private void a(View view, RectF rectF, int i) {
        switch (i) {
            case 16:
                rectF.left = this.yU.left;
                rectF.right = rectF.left + view.getMeasuredWidth();
                return;
            case 32:
                rectF.left = (this.yU.width() - view.getMeasuredWidth()) / 2.0f;
                rectF.right = (this.yU.width() + view.getMeasuredWidth()) / 2.0f;
                rectF.offset(this.yU.left, 0.0f);
                return;
            case 48:
                rectF.right = this.yU.right;
                rectF.left = rectF.right - view.getMeasuredWidth();
                return;
            default:
                return;
        }
    }

    private void b(View view, RectF rectF, int i) {
        switch (i) {
            case 16:
                rectF.top = this.yU.top;
                rectF.bottom = rectF.top + view.getMeasuredHeight();
                return;
            case 32:
                rectF.top = (this.yU.width() - view.getMeasuredHeight()) / 2.0f;
                rectF.bottom = (this.yU.width() + view.getMeasuredHeight()) / 2.0f;
                rectF.offset(0.0f, this.yU.top);
                return;
            case 48:
                rectF.bottom = this.yU.bottom;
                rectF.top = this.yU.bottom - view.getMeasuredHeight();
                return;
            default:
                return;
        }
    }

    private void hz() {
        this.yY.reset();
        this.yY.addRect(this.yU, Path.Direction.CW);
        this.yY.addRect(this.yV, Path.Direction.CW);
    }

    public void b(Rect rect) {
        this.yU.set(rect);
        hz();
        invalidate();
    }

    public void c(Rect rect) {
        this.yV.set(rect);
        hz();
        this.yZ = true;
        invalidate();
    }

    public void Z(int i) {
        this.yX.setAlpha(i);
        invalidate();
    }

    public void aa(int i) {
        this.yX.setColor(i);
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
        canvas.drawRect(this.yV, this.yX);
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
        public int zb;
        public int zc;
        public int zd;
        public int ze;

        public a(int i, int i2) {
            super(i, i2);
            this.zb = 4;
            this.zc = 32;
            this.zd = 0;
            this.ze = 0;
        }
    }
}
