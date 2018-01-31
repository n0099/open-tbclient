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
    private static int aQB = 360;
    private static int aQC = 100;
    private int aQD;
    private int aQE;
    private Paint aQF;
    private Paint aQG;
    private RectF aQH;
    private int aQI;
    private int mWidth;

    public CircleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aQI = 0;
        init();
    }

    public CircleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aQI = 0;
        init();
    }

    public CircleView(Context context) {
        super(context);
        this.aQI = 0;
        init();
    }

    public void setProgress(int i) {
        this.aQI = i;
        invalidate();
    }

    public void init() {
        this.mWidth = getResources().getDimensionPixelSize(d.e.ds100);
        this.aQD = getResources().getDimensionPixelSize(d.e.ds4);
        this.aQE = getResources().getDimensionPixelSize(d.e.ds2);
        this.aQF = new Paint();
        this.aQF.setStrokeWidth(this.aQD);
        this.aQF.setColor(getResources().getColor(d.C0108d.cp_cont_g));
        this.aQF.setStyle(Paint.Style.STROKE);
        this.aQF.setAntiAlias(true);
        this.aQG = new Paint();
        this.aQG.setStrokeWidth(this.aQE);
        this.aQG.setColor(getResources().getColor(d.C0108d.common_color_10042));
        this.aQG.setStyle(Paint.Style.STROKE);
        this.aQG.setAntiAlias(true);
        this.aQH = new RectF(this.aQD, this.aQD, this.mWidth + this.aQD, this.mWidth + this.aQD);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.drawArc(this.aQH, 0.0f, aQB, false, this.aQG);
        canvas.drawArc(this.aQH, 270.0f, (aQB * this.aQI) / aQC, false, this.aQF);
    }
}
