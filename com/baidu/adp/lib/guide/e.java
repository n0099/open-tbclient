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
    private final RectF wp;
    private final RectF wq;
    private final RectF wr;
    private final Paint ws;
    private final Path wt;
    private boolean wu;
    private final Paint wv;

    public e(Context context) {
        this(context, null, 0);
    }

    public e(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.wp = new RectF();
        this.wq = new RectF();
        this.wr = new RectF();
        this.ws = new Paint();
        this.wt = new Path();
        this.wv = new Paint();
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.wv.setColor(SupportMenu.CATEGORY_MASK);
        this.wv.setStrokeWidth(10.0f);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        setFocusable(true);
        setFocusableInTouchMode(true);
        requestFocus();
        this.wt.setFillType(Path.FillType.EVEN_ODD);
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
        if (!this.wu) {
            this.wq.set(0.0f, 0.0f, i3, i4);
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
                switch (aVar.ww) {
                    case 1:
                        this.wr.right = this.wp.left;
                        this.wr.left = this.wr.right - childAt.getMeasuredWidth();
                        b(childAt, this.wr, aVar.wx);
                        break;
                    case 2:
                        this.wr.bottom = this.wp.top;
                        this.wr.top = this.wr.bottom - childAt.getMeasuredHeight();
                        a(childAt, this.wr, aVar.wx);
                        break;
                    case 3:
                        this.wr.left = this.wp.right;
                        this.wr.right = this.wr.left + childAt.getMeasuredWidth();
                        b(childAt, this.wr, aVar.wx);
                        break;
                    case 4:
                        this.wr.top = this.wp.bottom;
                        this.wr.bottom = this.wr.top + childAt.getMeasuredHeight();
                        a(childAt, this.wr, aVar.wx);
                        break;
                    case 5:
                        this.wr.left = (((int) this.wp.width()) - childAt.getMeasuredWidth()) >> 1;
                        this.wr.top = (((int) this.wp.height()) - childAt.getMeasuredHeight()) >> 1;
                        this.wr.right = (((int) this.wp.width()) + childAt.getMeasuredWidth()) >> 1;
                        this.wr.bottom = (((int) this.wp.height()) + childAt.getMeasuredHeight()) >> 1;
                        this.wr.offset(this.wp.left, this.wp.top);
                        break;
                }
                this.wr.offset((int) ((aVar.wy * f) + 0.5f), (int) ((aVar.wz * f) + 0.5f));
                childAt.layout((int) this.wr.left, (int) this.wr.top, (int) this.wr.right, (int) this.wr.bottom);
            }
        }
    }

    private void a(View view, RectF rectF, int i) {
        switch (i) {
            case 16:
                rectF.left = this.wp.left;
                rectF.right = rectF.left + view.getMeasuredWidth();
                return;
            case 32:
                rectF.left = (this.wp.width() - view.getMeasuredWidth()) / 2.0f;
                rectF.right = (this.wp.width() + view.getMeasuredWidth()) / 2.0f;
                rectF.offset(this.wp.left, 0.0f);
                return;
            case d.n.View_onClick /* 48 */:
                rectF.right = this.wp.right;
                rectF.left = rectF.right - view.getMeasuredWidth();
                return;
            default:
                return;
        }
    }

    private void b(View view, RectF rectF, int i) {
        switch (i) {
            case 16:
                rectF.top = this.wp.top;
                rectF.bottom = rectF.top + view.getMeasuredHeight();
                return;
            case 32:
                rectF.top = (this.wp.width() - view.getMeasuredHeight()) / 2.0f;
                rectF.bottom = (this.wp.width() + view.getMeasuredHeight()) / 2.0f;
                rectF.offset(0.0f, this.wp.top);
                return;
            case d.n.View_onClick /* 48 */:
                rectF.bottom = this.wp.bottom;
                rectF.top = this.wp.bottom - view.getMeasuredHeight();
                return;
            default:
                return;
        }
    }

    private void fm() {
        this.wt.reset();
        this.wt.addRect(this.wp, Path.Direction.CW);
        this.wt.addRect(this.wq, Path.Direction.CW);
    }

    public void a(Rect rect) {
        this.wp.set(rect);
        fm();
        invalidate();
    }

    public void b(Rect rect) {
        this.wq.set(rect);
        fm();
        this.wu = true;
        invalidate();
    }

    public void ai(int i) {
        this.ws.setAlpha(i);
        invalidate();
    }

    public void aj(int i) {
        this.ws.setColor(i);
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
        canvas.drawRect(this.wq, this.ws);
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
        public int ww;
        public int wx;
        public int wy;
        public int wz;

        public a(int i, int i2) {
            super(i, i2);
            this.ww = 4;
            this.wx = 32;
            this.wy = 0;
            this.wz = 0;
        }
    }
}
