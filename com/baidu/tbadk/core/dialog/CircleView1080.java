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
    private static int aRR = 360;
    private static int aRS = 100;
    private int aRT;
    private Paint aRV;
    private RectF aRX;
    private int aRY;
    private int mWidth;

    public CircleView1080(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aRY = 0;
        init();
    }

    public CircleView1080(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aRY = 0;
        init();
    }

    public CircleView1080(Context context) {
        super(context);
        this.aRY = 0;
        init();
    }

    public void setProgress(int i) {
        this.aRY = i;
        invalidate();
    }

    public void init() {
        this.mWidth = getResources().getDimensionPixelSize(d.e.tbds122);
        this.aRT = getResources().getDimensionPixelSize(d.e.tbds6);
        this.aRV = new Paint();
        this.aRV.setStrokeWidth(this.aRT);
        this.aRV.setColor(getResources().getColor(d.C0141d.cp_cont_g));
        this.aRV.setStyle(Paint.Style.STROKE);
        this.aRV.setAntiAlias(true);
        this.aRV.setStrokeCap(Paint.Cap.ROUND);
        this.aRX = new RectF(this.aRT / 2, this.aRT / 2, this.mWidth + (this.aRT / 2), this.mWidth + (this.aRT / 2));
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.drawArc(this.aRX, 270.0f, (aRR * this.aRY) / aRS, false, this.aRV);
    }
}
