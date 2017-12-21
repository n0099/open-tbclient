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
    private final RectF uf;
    private final RectF ug;
    private final RectF uh;
    private final Paint ui;
    private final Path uj;
    private boolean uk;
    private final Paint ul;

    public e(Context context) {
        this(context, null, 0);
    }

    public e(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.uf = new RectF();
        this.ug = new RectF();
        this.uh = new RectF();
        this.ui = new Paint();
        this.uj = new Path();
        this.ul = new Paint();
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.ul.setColor(SupportMenu.CATEGORY_MASK);
        this.ul.setStrokeWidth(10.0f);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        setFocusable(true);
        setFocusableInTouchMode(true);
        requestFocus();
        this.uj.setFillType(Path.FillType.EVEN_ODD);
        fa();
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
        if (!this.uk) {
            this.ug.set(0.0f, 0.0f, i3, i4);
            fa();
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
                switch (aVar.um) {
                    case 1:
                        this.uh.right = this.uf.left;
                        this.uh.left = this.uh.right - childAt.getMeasuredWidth();
                        b(childAt, this.uh, aVar.uo);
                        break;
                    case 2:
                        this.uh.bottom = this.uf.top;
                        this.uh.top = this.uh.bottom - childAt.getMeasuredHeight();
                        a(childAt, this.uh, aVar.uo);
                        break;
                    case 3:
                        this.uh.left = this.uf.right;
                        this.uh.right = this.uh.left + childAt.getMeasuredWidth();
                        b(childAt, this.uh, aVar.uo);
                        break;
                    case 4:
                        this.uh.top = this.uf.bottom;
                        this.uh.bottom = this.uh.top + childAt.getMeasuredHeight();
                        a(childAt, this.uh, aVar.uo);
                        break;
                    case 5:
                        this.uh.left = (((int) this.uf.width()) - childAt.getMeasuredWidth()) >> 1;
                        this.uh.top = (((int) this.uf.height()) - childAt.getMeasuredHeight()) >> 1;
                        this.uh.right = (((int) this.uf.width()) + childAt.getMeasuredWidth()) >> 1;
                        this.uh.bottom = (((int) this.uf.height()) + childAt.getMeasuredHeight()) >> 1;
                        this.uh.offset(this.uf.left, this.uf.top);
                        break;
                }
                this.uh.offset((int) ((aVar.up * f) + 0.5f), (int) ((aVar.uq * f) + 0.5f));
                childAt.layout((int) this.uh.left, (int) this.uh.top, (int) this.uh.right, (int) this.uh.bottom);
            }
        }
    }

    private void a(View view, RectF rectF, int i) {
        switch (i) {
            case 16:
                rectF.left = this.uf.left;
                rectF.right = rectF.left + view.getMeasuredWidth();
                return;
            case 32:
                rectF.left = (this.uf.width() - view.getMeasuredWidth()) / 2.0f;
                rectF.right = (this.uf.width() + view.getMeasuredWidth()) / 2.0f;
                rectF.offset(this.uf.left, 0.0f);
                return;
            case d.l.View_onClick /* 48 */:
                rectF.right = this.uf.right;
                rectF.left = rectF.right - view.getMeasuredWidth();
                return;
            default:
                return;
        }
    }

    private void b(View view, RectF rectF, int i) {
        switch (i) {
            case 16:
                rectF.top = this.uf.top;
                rectF.bottom = rectF.top + view.getMeasuredHeight();
                return;
            case 32:
                rectF.top = (this.uf.width() - view.getMeasuredHeight()) / 2.0f;
                rectF.bottom = (this.uf.width() + view.getMeasuredHeight()) / 2.0f;
                rectF.offset(0.0f, this.uf.top);
                return;
            case d.l.View_onClick /* 48 */:
                rectF.bottom = this.uf.bottom;
                rectF.top = this.uf.bottom - view.getMeasuredHeight();
                return;
            default:
                return;
        }
    }

    private void fa() {
        this.uj.reset();
        this.uj.addRect(this.uf, Path.Direction.CW);
        this.uj.addRect(this.ug, Path.Direction.CW);
    }

    public void a(Rect rect) {
        this.uf.set(rect);
        fa();
        invalidate();
    }

    public void b(Rect rect) {
        this.ug.set(rect);
        fa();
        this.uk = true;
        invalidate();
    }

    public void ae(int i) {
        this.ui.setAlpha(i);
        invalidate();
    }

    public void af(int i) {
        this.ui.setColor(i);
        invalidate();
    }

    public void C(boolean z) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* renamed from: fb */
    public a generateDefaultLayoutParams() {
        return new a(-2, -2);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        long drawingTime = getDrawingTime();
        canvas.save();
        canvas.drawRect(this.ug, this.ui);
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
        public int um;
        public int uo;
        public int up;
        public int uq;

        public a(int i, int i2) {
            super(i, i2);
            this.um = 4;
            this.uo = 32;
            this.up = 0;
            this.uq = 0;
        }
    }
}
