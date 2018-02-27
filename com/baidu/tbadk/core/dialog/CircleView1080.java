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
    private static int aRP = 360;
    private static int aRQ = 100;
    private int aRR;
    private Paint aRT;
    private RectF aRV;
    private int aRW;
    private int mWidth;

    public CircleView1080(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aRW = 0;
        init();
    }

    public CircleView1080(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aRW = 0;
        init();
    }

    public CircleView1080(Context context) {
        super(context);
        this.aRW = 0;
        init();
    }

    public void setProgress(int i) {
        this.aRW = i;
        invalidate();
    }

    public void init() {
        this.mWidth = getResources().getDimensionPixelSize(d.e.tbds122);
        this.aRR = getResources().getDimensionPixelSize(d.e.tbds6);
        this.aRT = new Paint();
        this.aRT.setStrokeWidth(this.aRR);
        this.aRT.setColor(getResources().getColor(d.C0141d.cp_cont_g));
        this.aRT.setStyle(Paint.Style.STROKE);
        this.aRT.setAntiAlias(true);
        this.aRT.setStrokeCap(Paint.Cap.ROUND);
        this.aRV = new RectF(this.aRR / 2, this.aRR / 2, this.mWidth + (this.aRR / 2), this.mWidth + (this.aRR / 2));
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.drawArc(this.aRV, 270.0f, (aRP * this.aRW) / aRQ, false, this.aRT);
    }
}
