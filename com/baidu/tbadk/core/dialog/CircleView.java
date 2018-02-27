package com.baidu.tbadk.core.dialog;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class CircleView extends View {
    private static int aRP = 360;
    private static int aRQ = 100;
    private int aRR;
    private int aRS;
    private Paint aRT;
    private Paint aRU;
    private RectF aRV;
    private int aRW;
    private int mWidth;

    public CircleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aRW = 0;
        init();
    }

    public CircleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aRW = 0;
        init();
    }

    public CircleView(Context context) {
        super(context);
        this.aRW = 0;
        init();
    }

    public void setProgress(int i) {
        this.aRW = i;
        invalidate();
    }

    public void init() {
        this.mWidth = getResources().getDimensionPixelSize(d.e.ds100);
        this.aRR = getResources().getDimensionPixelSize(d.e.ds4);
        this.aRS = getResources().getDimensionPixelSize(d.e.ds2);
        this.aRT = new Paint();
        this.aRT.setStrokeWidth(this.aRR);
        this.aRT.setColor(getResources().getColor(d.C0141d.cp_cont_g));
        this.aRT.setStyle(Paint.Style.STROKE);
        this.aRT.setAntiAlias(true);
        this.aRU = new Paint();
        this.aRU.setStrokeWidth(this.aRS);
        this.aRU.setColor(getResources().getColor(d.C0141d.common_color_10042));
        this.aRU.setStyle(Paint.Style.STROKE);
        this.aRU.setAntiAlias(true);
        this.aRV = new RectF(this.aRR, this.aRR, this.mWidth + this.aRR, this.mWidth + this.aRR);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.drawArc(this.aRV, 0.0f, aRP, false, this.aRU);
        canvas.drawArc(this.aRV, 270.0f, (aRP * this.aRW) / aRQ, false, this.aRT);
    }
}
