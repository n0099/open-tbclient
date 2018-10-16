package com.baidu.tbadk.core.dialog;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.tieba.e;
/* loaded from: classes.dex */
public class CircleView1080 extends View {
    private static int asK = 360;
    private static int asL = 100;
    private Paint asN;
    private RectF asP;
    private int mLineWidth;
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
        this.mWidth = getResources().getDimensionPixelSize(e.C0175e.tbds122);
        this.mLineWidth = getResources().getDimensionPixelSize(e.C0175e.tbds6);
        this.asN = new Paint();
        this.asN.setStrokeWidth(this.mLineWidth);
        this.asN.setColor(getResources().getColor(e.d.cp_cont_g));
        this.asN.setStyle(Paint.Style.STROKE);
        this.asN.setAntiAlias(true);
        this.asN.setStrokeCap(Paint.Cap.ROUND);
        this.asP = new RectF(this.mLineWidth / 2, this.mLineWidth / 2, this.mWidth + (this.mLineWidth / 2), this.mWidth + (this.mLineWidth / 2));
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.drawArc(this.asP, 270.0f, (asK * this.mValue) / asL, false, this.asN);
    }
}
