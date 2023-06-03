package com.baidu.searchbox.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;
import android.widget.GridView;
/* loaded from: classes4.dex */
public class ExpandGridView extends GridView {
    public float lineWidth;
    public Paint mPaint;
    public Paint mPaintLine;
    public Path mPath;
    public Path mPathLine;

    public ExpandGridView(Context context) {
        super(context);
        initPaint();
    }

    @Override // android.widget.AbsListView, android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        int childCount = getChildCount();
        if (childCount > 0) {
            drawEdge(canvas, childCount);
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    public ExpandGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initPaint();
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(536870911, Integer.MIN_VALUE));
    }

    public ExpandGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initPaint();
    }

    private void drawEdge(Canvas canvas, int i) {
        int i2;
        int i3 = 0;
        int width = getChildAt(0).getWidth();
        if (width <= 0) {
            return;
        }
        int width2 = getWidth();
        int height = getHeight();
        int width3 = getWidth() / width;
        int ceil = (int) Math.ceil(i / width3);
        this.mPath.reset();
        this.mPathLine.reset();
        this.mPathLine.moveTo(0.0f, getChildAt(0).getTop());
        float f = width2;
        this.mPathLine.lineTo(f, getChildAt(0).getTop());
        this.mPathLine.moveTo(0.0f, (getChildAt(0).getBottom() * ceil) - getChildAt(0).getTop());
        this.mPathLine.lineTo(f, (getChildAt(0).getBottom() * ceil) - getChildAt(0).getTop());
        while (true) {
            if (i3 >= ceil - 1) {
                break;
            }
            float bottom = getChildAt(i3 * width3).getBottom();
            this.mPath.moveTo(0.0f, bottom);
            this.mPath.lineTo(f, bottom);
            i3++;
        }
        for (i2 = 1; i2 < width3; i2++) {
            float f2 = i2 * width;
            this.mPath.moveTo(f2, 0.0f);
            this.mPath.lineTo(f2, height);
        }
        canvas.drawPath(this.mPath, this.mPaint);
        canvas.drawPath(this.mPathLine, this.mPaintLine);
    }

    private void initPaint() {
        this.lineWidth = 1.0f;
        Paint paint = new Paint(1);
        this.mPaint = paint;
        paint.setStyle(Paint.Style.STROKE);
        this.mPaint.setColor(getContext().getResources().getColor(com.baidu.tieba.R.color.navigator_category_dash_line));
        this.mPaint.setStrokeWidth(this.lineWidth);
        this.mPaint.setPathEffect(new DashPathEffect(new float[]{2.0f, 2.0f}, 1.0f));
        this.mPath = new Path();
        Paint paint2 = new Paint(1);
        this.mPaintLine = paint2;
        paint2.setStyle(Paint.Style.STROKE);
        this.mPaintLine.setColor(getContext().getResources().getColor(com.baidu.tieba.R.color.navigator_category_dash_line));
        this.mPaintLine.setStrokeWidth(this.lineWidth);
        this.mPathLine = new Path();
    }
}
