package com.baidu.tbadk.core.dialog;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class CircleView extends View {
    private static int aaQ = 360;
    private static int aaR = 100;
    private int aaS;
    private int aaT;
    private Paint aaU;
    private Paint aaV;
    private RectF aaW;
    private int aaX;
    private int mWidth;

    public CircleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aaX = 0;
        init();
    }

    public CircleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aaX = 0;
        init();
    }

    public CircleView(Context context) {
        super(context);
        this.aaX = 0;
        init();
    }

    public void setProgress(int i) {
        this.aaX = i;
        invalidate();
    }

    public void init() {
        this.mWidth = getResources().getDimensionPixelSize(w.f.ds100);
        this.aaS = getResources().getDimensionPixelSize(w.f.ds4);
        this.aaT = getResources().getDimensionPixelSize(w.f.ds2);
        this.aaU = new Paint();
        this.aaU.setStrokeWidth(this.aaS);
        this.aaU.setColor(getResources().getColor(w.e.cp_cont_g));
        this.aaU.setStyle(Paint.Style.STROKE);
        this.aaU.setAntiAlias(true);
        this.aaV = new Paint();
        this.aaV.setStrokeWidth(this.aaT);
        this.aaV.setColor(getResources().getColor(w.e.common_color_10042));
        this.aaV.setStyle(Paint.Style.STROKE);
        this.aaV.setAntiAlias(true);
        this.aaW = new RectF(this.aaS, this.aaS, this.mWidth + this.aaS, this.mWidth + this.aaS);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.drawArc(this.aaW, 0.0f, aaQ, false, this.aaV);
        canvas.drawArc(this.aaW, 270.0f, (aaQ * this.aaX) / aaR, false, this.aaU);
    }
}
