package com.baidu.tbadk.core.dialog;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class CircleView1080 extends View {
    private static int bFl = 360;
    private static int bFm = 100;
    private int amc;
    private Paint bFo;
    private RectF bFq;
    private int mValue;
    private int mWidth;

    public CircleView1080(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mValue = 0;
        init();
    }

    public CircleView1080(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mValue = 0;
        init();
    }

    public CircleView1080(Context context) {
        super(context);
        this.mValue = 0;
        init();
    }

    public void setProgress(int i) {
        this.mValue = i;
        invalidate();
    }

    public void init() {
        this.mWidth = getResources().getDimensionPixelSize(d.e.tbds122);
        this.amc = getResources().getDimensionPixelSize(d.e.tbds6);
        this.bFo = new Paint();
        this.bFo.setStrokeWidth(this.amc);
        this.bFo.setColor(getResources().getColor(d.C0277d.cp_cont_g));
        this.bFo.setStyle(Paint.Style.STROKE);
        this.bFo.setAntiAlias(true);
        this.bFo.setStrokeCap(Paint.Cap.ROUND);
        this.bFq = new RectF(this.amc / 2, this.amc / 2, this.mWidth + (this.amc / 2), this.mWidth + (this.amc / 2));
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.drawArc(this.bFq, 270.0f, (bFl * this.mValue) / bFm, false, this.bFo);
    }
}
