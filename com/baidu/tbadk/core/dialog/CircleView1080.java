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
    private static int axB = 360;
    private static int axC = 100;
    private Paint axE;
    private RectF axG;
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
        this.mWidth = getResources().getDimensionPixelSize(e.C0210e.tbds122);
        this.mLineWidth = getResources().getDimensionPixelSize(e.C0210e.tbds6);
        this.axE = new Paint();
        this.axE.setStrokeWidth(this.mLineWidth);
        this.axE.setColor(getResources().getColor(e.d.cp_cont_g));
        this.axE.setStyle(Paint.Style.STROKE);
        this.axE.setAntiAlias(true);
        this.axE.setStrokeCap(Paint.Cap.ROUND);
        this.axG = new RectF(this.mLineWidth / 2, this.mLineWidth / 2, this.mWidth + (this.mLineWidth / 2), this.mWidth + (this.mLineWidth / 2));
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.drawArc(this.axG, 270.0f, (axB * this.mValue) / axC, false, this.axE);
    }
}
