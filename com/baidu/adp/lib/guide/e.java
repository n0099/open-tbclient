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
    private final RectF ue;
    private final RectF uf;
    private final RectF ug;
    private final Paint uh;
    private final Path ui;
    private boolean uj;
    private final Paint uk;

    public e(Context context) {
        this(context, null, 0);
    }

    public e(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ue = new RectF();
        this.uf = new RectF();
        this.ug = new RectF();
        this.uh = new Paint();
        this.ui = new Path();
        this.uk = new Paint();
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.uk.setColor(SupportMenu.CATEGORY_MASK);
        this.uk.setStrokeWidth(10.0f);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        setFocusable(true);
        setFocusableInTouchMode(true);
        requestFocus();
        this.ui.setFillType(Path.FillType.EVEN_ODD);
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
        if (!this.uj) {
            this.uf.set(0.0f, 0.0f, i3, i4);
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
                switch (aVar.ul) {
                    case 1:
                        this.ug.right = this.ue.left;
                        this.ug.left = this.ug.right - childAt.getMeasuredWidth();
                        b(childAt, this.ug, aVar.um);
                        break;
                    case 2:
                        this.ug.bottom = this.ue.top;
                        this.ug.top = this.ug.bottom - childAt.getMeasuredHeight();
                        a(childAt, this.ug, aVar.um);
                        break;
                    case 3:
                        this.ug.left = this.ue.right;
                        this.ug.right = this.ug.left + childAt.getMeasuredWidth();
                        b(childAt, this.ug, aVar.um);
                        break;
                    case 4:
                        this.ug.top = this.ue.bottom;
                        this.ug.bottom = this.ug.top + childAt.getMeasuredHeight();
                        a(childAt, this.ug, aVar.um);
                        break;
                    case 5:
                        this.ug.left = (((int) this.ue.width()) - childAt.getMeasuredWidth()) >> 1;
                        this.ug.top = (((int) this.ue.height()) - childAt.getMeasuredHeight()) >> 1;
                        this.ug.right = (((int) this.ue.width()) + childAt.getMeasuredWidth()) >> 1;
                        this.ug.bottom = (((int) this.ue.height()) + childAt.getMeasuredHeight()) >> 1;
                        this.ug.offset(this.ue.left, this.ue.top);
                        break;
                }
                this.ug.offset((int) ((aVar.uo * f) + 0.5f), (int) ((aVar.up * f) + 0.5f));
                childAt.layout((int) this.ug.left, (int) this.ug.top, (int) this.ug.right, (int) this.ug.bottom);
            }
        }
    }

    private void a(View view, RectF rectF, int i) {
        switch (i) {
            case 16:
                rectF.left = this.ue.left;
                rectF.right = rectF.left + view.getMeasuredWidth();
                return;
            case 32:
                rectF.left = (this.ue.width() - view.getMeasuredWidth()) / 2.0f;
                rectF.right = (this.ue.width() + view.getMeasuredWidth()) / 2.0f;
                rectF.offset(this.ue.left, 0.0f);
                return;
            case d.n.View_onClick /* 48 */:
                rectF.right = this.ue.right;
                rectF.left = rectF.right - view.getMeasuredWidth();
                return;
            default:
                return;
        }
    }

    private void b(View view, RectF rectF, int i) {
        switch (i) {
            case 16:
                rectF.top = this.ue.top;
                rectF.bottom = rectF.top + view.getMeasuredHeight();
                return;
            case 32:
                rectF.top = (this.ue.width() - view.getMeasuredHeight()) / 2.0f;
                rectF.bottom = (this.ue.width() + view.getMeasuredHeight()) / 2.0f;
                rectF.offset(0.0f, this.ue.top);
                return;
            case d.n.View_onClick /* 48 */:
                rectF.bottom = this.ue.bottom;
                rectF.top = this.ue.bottom - view.getMeasuredHeight();
                return;
            default:
                return;
        }
    }

    private void fb() {
        this.ui.reset();
        this.ui.addRect(this.ue, Path.Direction.CW);
        this.ui.addRect(this.uf, Path.Direction.CW);
    }

    public void a(Rect rect) {
        this.ue.set(rect);
        fb();
        invalidate();
    }

    public void b(Rect rect) {
        this.uf.set(rect);
        fb();
        this.uj = true;
        invalidate();
    }

    public void af(int i) {
        this.uh.setAlpha(i);
        invalidate();
    }

    public void ag(int i) {
        this.uh.setColor(i);
        invalidate();
    }

    public void C(boolean z) {
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
        canvas.drawRect(this.uf, this.uh);
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
        public int ul;
        public int um;
        public int uo;
        public int up;

        public a(int i, int i2) {
            super(i, i2);
            this.ul = 4;
            this.um = 32;
            this.uo = 0;
            this.up = 0;
        }
    }
}
