package com.baidu.adp.lib.guide;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.v4.internal.view.SupportMenu;
import android.support.v4.widget.ExploreByTouchHelper;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h extends ViewGroup {
    private final Paint mPaint;
    private final RectF uJ;
    private final RectF uK;
    private final RectF uL;
    private final Paint uM;
    private final Path uN;
    private boolean uO;
    private final Paint uP;

    public h(Context context) {
        this(context, null, 0);
    }

    public h(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.uJ = new RectF();
        this.uK = new RectF();
        this.uL = new RectF();
        this.uM = new Paint();
        this.uN = new Path();
        this.uP = new Paint();
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.uP.setColor(SupportMenu.CATEGORY_MASK);
        this.uP.setStrokeWidth(10.0f);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        setFocusable(true);
        setFocusableInTouchMode(true);
        requestFocus();
        this.uN.setFillType(Path.FillType.EVEN_ODD);
        fd();
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
        if (!this.uO) {
            this.uK.set(0.0f, 0.0f, i3, i4);
            fd();
        }
        int childCount = getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (childAt != null) {
                a aVar = (a) childAt.getLayoutParams();
                if (aVar == null) {
                    childAt.setLayoutParams(aVar);
                }
                measureChild(childAt, i3 + ExploreByTouchHelper.INVALID_ID, i4 + ExploreByTouchHelper.INVALID_ID);
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
                switch (aVar.uQ) {
                    case 1:
                        this.uL.right = this.uJ.left;
                        this.uL.left = this.uL.right - childAt.getMeasuredWidth();
                        b(childAt, this.uL, aVar.uR);
                        break;
                    case 2:
                        this.uL.bottom = this.uJ.top;
                        this.uL.top = this.uL.bottom - childAt.getMeasuredHeight();
                        a(childAt, this.uL, aVar.uR);
                        break;
                    case 3:
                        this.uL.left = this.uJ.right;
                        this.uL.right = this.uL.left + childAt.getMeasuredWidth();
                        b(childAt, this.uL, aVar.uR);
                        break;
                    case 4:
                        this.uL.top = this.uJ.bottom;
                        this.uL.bottom = this.uL.top + childAt.getMeasuredHeight();
                        a(childAt, this.uL, aVar.uR);
                        break;
                    case 5:
                        this.uL.left = (((int) this.uJ.width()) - childAt.getMeasuredWidth()) >> 1;
                        this.uL.top = (((int) this.uJ.height()) - childAt.getMeasuredHeight()) >> 1;
                        this.uL.right = (((int) this.uJ.width()) + childAt.getMeasuredWidth()) >> 1;
                        this.uL.bottom = (((int) this.uJ.height()) + childAt.getMeasuredHeight()) >> 1;
                        this.uL.offset(this.uJ.left, this.uJ.top);
                        break;
                }
                this.uL.offset((int) ((aVar.uS * f) + 0.5f), (int) ((aVar.uT * f) + 0.5f));
                childAt.layout((int) this.uL.left, (int) this.uL.top, (int) this.uL.right, (int) this.uL.bottom);
            }
        }
    }

    private void a(View view, RectF rectF, int i) {
        switch (i) {
            case 16:
                rectF.left = this.uJ.left;
                rectF.right = rectF.left + view.getMeasuredWidth();
                return;
            case 32:
                rectF.left = (this.uJ.width() - view.getMeasuredWidth()) / 2.0f;
                rectF.right = (this.uJ.width() + view.getMeasuredWidth()) / 2.0f;
                rectF.offset(this.uJ.left, 0.0f);
                return;
            case w.n.View_onClick /* 48 */:
                rectF.right = this.uJ.right;
                rectF.left = rectF.right - view.getMeasuredWidth();
                return;
            default:
                return;
        }
    }

    private void b(View view, RectF rectF, int i) {
        switch (i) {
            case 16:
                rectF.top = this.uJ.top;
                rectF.bottom = rectF.top + view.getMeasuredHeight();
                return;
            case 32:
                rectF.top = (this.uJ.width() - view.getMeasuredHeight()) / 2.0f;
                rectF.bottom = (this.uJ.width() + view.getMeasuredHeight()) / 2.0f;
                rectF.offset(0.0f, this.uJ.top);
                return;
            case w.n.View_onClick /* 48 */:
                rectF.bottom = this.uJ.bottom;
                rectF.top = this.uJ.bottom - view.getMeasuredHeight();
                return;
            default:
                return;
        }
    }

    private void fd() {
        this.uN.reset();
        this.uN.addRect(this.uJ, Path.Direction.CW);
        this.uN.addRect(this.uK, Path.Direction.CW);
    }

    public void a(Rect rect) {
        this.uJ.set(rect);
        fd();
        invalidate();
    }

    public void b(Rect rect) {
        this.uK.set(rect);
        fd();
        this.uO = true;
        invalidate();
    }

    public void af(int i) {
        this.uM.setAlpha(i);
        invalidate();
    }

    public void ag(int i) {
        this.uM.setColor(i);
        invalidate();
    }

    public void B(boolean z) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* renamed from: fe */
    public a generateDefaultLayoutParams() {
        return new a(-2, -2);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        long drawingTime = getDrawingTime();
        canvas.save();
        canvas.drawRect(this.uK, this.uM);
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
        public int uQ;
        public int uR;
        public int uS;
        public int uT;

        public a(int i, int i2) {
            super(i, i2);
            this.uQ = 4;
            this.uR = 32;
            this.uS = 0;
            this.uT = 0;
        }
    }
}
