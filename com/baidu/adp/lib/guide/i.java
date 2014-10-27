package com.baidu.adp.lib.guide;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i extends ViewGroup {
    private final Paint gs;
    private final RectF jA;
    private final RectF jB;
    private final Paint jC;
    private final Path jD;
    private boolean jE;
    private final Paint jF;
    private final RectF jz;

    public i(Context context) {
        this(context, null, 0);
    }

    public i(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jz = new RectF();
        this.jA = new RectF();
        this.jB = new RectF();
        this.jC = new Paint();
        this.jD = new Path();
        this.jF = new Paint();
        this.gs = new Paint();
        this.gs.setAntiAlias(true);
        this.jF.setColor(-65536);
        this.jF.setStrokeWidth(10.0f);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        setFocusable(true);
        setFocusableInTouchMode(true);
        requestFocus();
        this.jD.setFillType(Path.FillType.EVEN_ODD);
        dC();
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
        if (!this.jE) {
            this.jA.set(0.0f, 0.0f, i3, i4);
            dC();
        }
        int childCount = getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (childAt != null) {
                j jVar = (j) childAt.getLayoutParams();
                if (jVar == null) {
                    childAt.setLayoutParams(jVar);
                }
                measureChild(childAt, i3 - 2147483648, i4 - 2147483648);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        j jVar;
        int childCount = getChildCount();
        float f = getResources().getDisplayMetrics().density;
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (childAt != null && (jVar = (j) childAt.getLayoutParams()) != null) {
                switch (jVar.jG) {
                    case 1:
                        this.jB.right = this.jz.left;
                        this.jB.left = this.jB.right - childAt.getMeasuredWidth();
                        b(childAt, this.jB, jVar.jH);
                        break;
                    case 2:
                        this.jB.bottom = this.jz.top;
                        this.jB.top = this.jB.bottom - childAt.getMeasuredHeight();
                        a(childAt, this.jB, jVar.jH);
                        break;
                    case 3:
                        this.jB.left = this.jz.right;
                        this.jB.right = this.jB.left + childAt.getMeasuredWidth();
                        b(childAt, this.jB, jVar.jH);
                        break;
                    case 4:
                        this.jB.top = this.jz.bottom;
                        this.jB.bottom = this.jB.top + childAt.getMeasuredHeight();
                        a(childAt, this.jB, jVar.jH);
                        break;
                    case 5:
                        this.jB.left = (((int) this.jz.width()) - childAt.getMeasuredWidth()) >> 1;
                        this.jB.top = (((int) this.jz.height()) - childAt.getMeasuredHeight()) >> 1;
                        this.jB.right = (((int) this.jz.width()) + childAt.getMeasuredWidth()) >> 1;
                        this.jB.bottom = (((int) this.jz.height()) + childAt.getMeasuredHeight()) >> 1;
                        this.jB.offset(this.jz.left, this.jz.top);
                        break;
                }
                this.jB.offset((int) ((jVar.jI * f) + 0.5f), (int) ((jVar.jJ * f) + 0.5f));
                childAt.layout((int) this.jB.left, (int) this.jB.top, (int) this.jB.right, (int) this.jB.bottom);
            }
        }
    }

    private void a(View view, RectF rectF, int i) {
        switch (i) {
            case 16:
                rectF.left = this.jz.left;
                rectF.right = rectF.left + view.getMeasuredWidth();
                return;
            case AccessibilityNodeInfoCompat.ACTION_LONG_CLICK /* 32 */:
                rectF.left = (this.jz.width() - view.getMeasuredWidth()) / 2.0f;
                rectF.right = (this.jz.width() + view.getMeasuredWidth()) / 2.0f;
                rectF.offset(this.jz.left, 0.0f);
                return;
            case 48:
                rectF.right = this.jz.right;
                rectF.left = rectF.right - view.getMeasuredWidth();
                return;
            default:
                return;
        }
    }

    private void b(View view, RectF rectF, int i) {
        switch (i) {
            case 16:
                rectF.top = this.jz.top;
                rectF.bottom = rectF.top + view.getMeasuredHeight();
                return;
            case AccessibilityNodeInfoCompat.ACTION_LONG_CLICK /* 32 */:
                rectF.top = (this.jz.width() - view.getMeasuredHeight()) / 2.0f;
                rectF.bottom = (this.jz.width() + view.getMeasuredHeight()) / 2.0f;
                rectF.offset(0.0f, this.jz.top);
                return;
            case 48:
                rectF.bottom = this.jz.bottom;
                rectF.top = this.jz.bottom - view.getMeasuredHeight();
                return;
            default:
                return;
        }
    }

    private void dC() {
        this.jD.reset();
        this.jD.addRect(this.jz, Path.Direction.CW);
        this.jD.addRect(this.jA, Path.Direction.CW);
    }

    public void a(Rect rect) {
        this.jz.set(rect);
        dC();
        invalidate();
    }

    public void b(Rect rect) {
        this.jA.set(rect);
        dC();
        this.jE = true;
        invalidate();
    }

    public void C(int i) {
        this.jC.setAlpha(i);
        invalidate();
    }

    public void D(int i) {
        this.jC.setColor(i);
        invalidate();
    }

    public void t(boolean z) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* renamed from: dD */
    public j generateDefaultLayoutParams() {
        return new j(-2, -2);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        long drawingTime = getDrawingTime();
        canvas.save();
        canvas.drawRect(this.jA, this.jC);
        canvas.restore();
        for (int i = 0; i < getChildCount(); i++) {
            try {
                drawChild(canvas, getChildAt(i), drawingTime);
            } catch (NullPointerException e) {
                return;
            }
        }
    }
}
