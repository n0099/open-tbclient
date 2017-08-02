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
import com.baidu.tieba.d;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends ViewGroup {
    private final Paint mPaint;
    private final RectF uK;
    private final RectF uL;
    private final RectF uM;
    private final Paint uN;
    private final Path uO;
    private boolean uP;
    private final Paint uQ;

    public e(Context context) {
        this(context, null, 0);
    }

    public e(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.uK = new RectF();
        this.uL = new RectF();
        this.uM = new RectF();
        this.uN = new Paint();
        this.uO = new Path();
        this.uQ = new Paint();
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.uQ.setColor(SupportMenu.CATEGORY_MASK);
        this.uQ.setStrokeWidth(10.0f);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        setFocusable(true);
        setFocusableInTouchMode(true);
        requestFocus();
        this.uO.setFillType(Path.FillType.EVEN_ODD);
        fb();
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
        if (!this.uP) {
            this.uL.set(0.0f, 0.0f, i3, i4);
            fb();
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
                switch (aVar.uR) {
                    case 1:
                        this.uM.right = this.uK.left;
                        this.uM.left = this.uM.right - childAt.getMeasuredWidth();
                        b(childAt, this.uM, aVar.uS);
                        break;
                    case 2:
                        this.uM.bottom = this.uK.top;
                        this.uM.top = this.uM.bottom - childAt.getMeasuredHeight();
                        a(childAt, this.uM, aVar.uS);
                        break;
                    case 3:
                        this.uM.left = this.uK.right;
                        this.uM.right = this.uM.left + childAt.getMeasuredWidth();
                        b(childAt, this.uM, aVar.uS);
                        break;
                    case 4:
                        this.uM.top = this.uK.bottom;
                        this.uM.bottom = this.uM.top + childAt.getMeasuredHeight();
                        a(childAt, this.uM, aVar.uS);
                        break;
                    case 5:
                        this.uM.left = (((int) this.uK.width()) - childAt.getMeasuredWidth()) >> 1;
                        this.uM.top = (((int) this.uK.height()) - childAt.getMeasuredHeight()) >> 1;
                        this.uM.right = (((int) this.uK.width()) + childAt.getMeasuredWidth()) >> 1;
                        this.uM.bottom = (((int) this.uK.height()) + childAt.getMeasuredHeight()) >> 1;
                        this.uM.offset(this.uK.left, this.uK.top);
                        break;
                }
                this.uM.offset((int) ((aVar.uT * f) + 0.5f), (int) ((aVar.uU * f) + 0.5f));
                childAt.layout((int) this.uM.left, (int) this.uM.top, (int) this.uM.right, (int) this.uM.bottom);
            }
        }
    }

    private void a(View view, RectF rectF, int i) {
        switch (i) {
            case 16:
                rectF.left = this.uK.left;
                rectF.right = rectF.left + view.getMeasuredWidth();
                return;
            case 32:
                rectF.left = (this.uK.width() - view.getMeasuredWidth()) / 2.0f;
                rectF.right = (this.uK.width() + view.getMeasuredWidth()) / 2.0f;
                rectF.offset(this.uK.left, 0.0f);
                return;
            case d.n.View_onClick /* 48 */:
                rectF.right = this.uK.right;
                rectF.left = rectF.right - view.getMeasuredWidth();
                return;
            default:
                return;
        }
    }

    private void b(View view, RectF rectF, int i) {
        switch (i) {
            case 16:
                rectF.top = this.uK.top;
                rectF.bottom = rectF.top + view.getMeasuredHeight();
                return;
            case 32:
                rectF.top = (this.uK.width() - view.getMeasuredHeight()) / 2.0f;
                rectF.bottom = (this.uK.width() + view.getMeasuredHeight()) / 2.0f;
                rectF.offset(0.0f, this.uK.top);
                return;
            case d.n.View_onClick /* 48 */:
                rectF.bottom = this.uK.bottom;
                rectF.top = this.uK.bottom - view.getMeasuredHeight();
                return;
            default:
                return;
        }
    }

    private void fb() {
        this.uO.reset();
        this.uO.addRect(this.uK, Path.Direction.CW);
        this.uO.addRect(this.uL, Path.Direction.CW);
    }

    public void a(Rect rect) {
        this.uK.set(rect);
        fb();
        invalidate();
    }

    public void b(Rect rect) {
        this.uL.set(rect);
        fb();
        this.uP = true;
        invalidate();
    }

    public void af(int i) {
        this.uN.setAlpha(i);
        invalidate();
    }

    public void ag(int i) {
        this.uN.setColor(i);
        invalidate();
    }

    public void B(boolean z) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* renamed from: fc */
    public a generateDefaultLayoutParams() {
        return new a(-2, -2);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        long drawingTime = getDrawingTime();
        canvas.save();
        canvas.drawRect(this.uL, this.uN);
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
        public int uR;
        public int uS;
        public int uT;
        public int uU;

        public a(int i, int i2) {
            super(i, i2);
            this.uR = 4;
            this.uS = 32;
            this.uT = 0;
            this.uU = 0;
        }
    }
}
