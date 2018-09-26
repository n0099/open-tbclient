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
    private static int anQ = 360;
    private static int anR = 100;
    private int anS;
    private Paint anU;
    private RectF anW;
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
        this.mWidth = getResources().getDimensionPixelSize(e.C0141e.tbds122);
        this.anS = getResources().getDimensionPixelSize(e.C0141e.tbds6);
        this.anU = new Paint();
        this.anU.setStrokeWidth(this.anS);
        this.anU.setColor(getResources().getColor(e.d.cp_cont_g));
        this.anU.setStyle(Paint.Style.STROKE);
        this.anU.setAntiAlias(true);
        this.anU.setStrokeCap(Paint.Cap.ROUND);
        this.anW = new RectF(this.anS / 2, this.anS / 2, this.mWidth + (this.anS / 2), this.mWidth + (this.anS / 2));
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.drawArc(this.anW, 270.0f, (anQ * this.mValue) / anR, false, this.anU);
    }
}
