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
    private final RectF wn;
    private final RectF wo;
    private final RectF wp;
    private final Paint wq;
    private final Path wr;
    private boolean ws;
    private final Paint wt;

    public e(Context context) {
        this(context, null, 0);
    }

    public e(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.wn = new RectF();
        this.wo = new RectF();
        this.wp = new RectF();
        this.wq = new Paint();
        this.wr = new Path();
        this.wt = new Paint();
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.wt.setColor(SupportMenu.CATEGORY_MASK);
        this.wt.setStrokeWidth(10.0f);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        setFocusable(true);
        setFocusableInTouchMode(true);
        requestFocus();
        this.wr.setFillType(Path.FillType.EVEN_ODD);
        fm();
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
        if (!this.ws) {
            this.wo.set(0.0f, 0.0f, i3, i4);
            fm();
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
                switch (aVar.wu) {
                    case 1:
                        this.wp.right = this.wn.left;
                        this.wp.left = this.wp.right - childAt.getMeasuredWidth();
                        b(childAt, this.wp, aVar.wv);
                        break;
                    case 2:
                        this.wp.bottom = this.wn.top;
                        this.wp.top = this.wp.bottom - childAt.getMeasuredHeight();
                        a(childAt, this.wp, aVar.wv);
                        break;
                    case 3:
                        this.wp.left = this.wn.right;
                        this.wp.right = this.wp.left + childAt.getMeasuredWidth();
                        b(childAt, this.wp, aVar.wv);
                        break;
                    case 4:
                        this.wp.top = this.wn.bottom;
                        this.wp.bottom = this.wp.top + childAt.getMeasuredHeight();
                        a(childAt, this.wp, aVar.wv);
                        break;
                    case 5:
                        this.wp.left = (((int) this.wn.width()) - childAt.getMeasuredWidth()) >> 1;
                        this.wp.top = (((int) this.wn.height()) - childAt.getMeasuredHeight()) >> 1;
                        this.wp.right = (((int) this.wn.width()) + childAt.getMeasuredWidth()) >> 1;
                        this.wp.bottom = (((int) this.wn.height()) + childAt.getMeasuredHeight()) >> 1;
                        this.wp.offset(this.wn.left, this.wn.top);
                        break;
                }
                this.wp.offset((int) ((aVar.ww * f) + 0.5f), (int) ((aVar.wx * f) + 0.5f));
                childAt.layout((int) this.wp.left, (int) this.wp.top, (int) this.wp.right, (int) this.wp.bottom);
            }
        }
    }

    private void a(View view, RectF rectF, int i) {
        switch (i) {
            case 16:
                rectF.left = this.wn.left;
                rectF.right = rectF.left + view.getMeasuredWidth();
                return;
            case 32:
                rectF.left = (this.wn.width() - view.getMeasuredWidth()) / 2.0f;
                rectF.right = (this.wn.width() + view.getMeasuredWidth()) / 2.0f;
                rectF.offset(this.wn.left, 0.0f);
                return;
            case d.n.View_onClick /* 48 */:
                rectF.right = this.wn.right;
                rectF.left = rectF.right - view.getMeasuredWidth();
                return;
            default:
                return;
        }
    }

    private void b(View view, RectF rectF, int i) {
        switch (i) {
            case 16:
                rectF.top = this.wn.top;
                rectF.bottom = rectF.top + view.getMeasuredHeight();
                return;
            case 32:
                rectF.top = (this.wn.width() - view.getMeasuredHeight()) / 2.0f;
                rectF.bottom = (this.wn.width() + view.getMeasuredHeight()) / 2.0f;
                rectF.offset(0.0f, this.wn.top);
                return;
            case d.n.View_onClick /* 48 */:
                rectF.bottom = this.wn.bottom;
                rectF.top = this.wn.bottom - view.getMeasuredHeight();
                return;
            default:
                return;
        }
    }

    private void fm() {
        this.wr.reset();
        this.wr.addRect(this.wn, Path.Direction.CW);
        this.wr.addRect(this.wo, Path.Direction.CW);
    }

    public void a(Rect rect) {
        this.wn.set(rect);
        fm();
        invalidate();
    }

    public void b(Rect rect) {
        this.wo.set(rect);
        fm();
        this.ws = true;
        invalidate();
    }

    public void ai(int i) {
        this.wq.setAlpha(i);
        invalidate();
    }

    public void aj(int i) {
        this.wq.setColor(i);
        invalidate();
    }

    public void B(boolean z) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* renamed from: fn */
    public a generateDefaultLayoutParams() {
        return new a(-2, -2);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        long drawingTime = getDrawingTime();
        canvas.save();
        canvas.drawRect(this.wo, this.wq);
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
        public int wu;
        public int wv;
        public int ww;
        public int wx;

        public a(int i, int i2) {
            super(i, i2);
            this.wu = 4;
            this.wv = 32;
            this.ww = 0;
            this.wx = 0;
        }
    }
}
