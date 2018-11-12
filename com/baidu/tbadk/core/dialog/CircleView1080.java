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
    private static int atx = 360;
    private static int aty = 100;
    private Paint atA;
    private RectF atC;
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
        this.mWidth = getResources().getDimensionPixelSize(e.C0200e.tbds122);
        this.mLineWidth = getResources().getDimensionPixelSize(e.C0200e.tbds6);
        this.atA = new Paint();
        this.atA.setStrokeWidth(this.mLineWidth);
        this.atA.setColor(getResources().getColor(e.d.cp_cont_g));
        this.atA.setStyle(Paint.Style.STROKE);
        this.atA.setAntiAlias(true);
        this.atA.setStrokeCap(Paint.Cap.ROUND);
        this.atC = new RectF(this.mLineWidth / 2, this.mLineWidth / 2, this.mWidth + (this.mLineWidth / 2), this.mWidth + (this.mLineWidth / 2));
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.drawArc(this.atC, 270.0f, (atx * this.mValue) / aty, false, this.atA);
    }
}
