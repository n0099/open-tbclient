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
    private static int aQy = 360;
    private static int aQz = 100;
    private int aQA;
    private int aQB;
    private Paint aQC;
    private Paint aQD;
    private RectF aQE;
    private int aQF;
    private int mWidth;

    public CircleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aQF = 0;
        init();
    }

    public CircleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aQF = 0;
        init();
    }

    public CircleView(Context context) {
        super(context);
        this.aQF = 0;
        init();
    }

    public void setProgress(int i) {
        this.aQF = i;
        invalidate();
    }

    public void init() {
        this.mWidth = getResources().getDimensionPixelSize(d.e.ds100);
        this.aQA = getResources().getDimensionPixelSize(d.e.ds4);
        this.aQB = getResources().getDimensionPixelSize(d.e.ds2);
        this.aQC = new Paint();
        this.aQC.setStrokeWidth(this.aQA);
        this.aQC.setColor(getResources().getColor(d.C0107d.cp_cont_g));
        this.aQC.setStyle(Paint.Style.STROKE);
        this.aQC.setAntiAlias(true);
        this.aQD = new Paint();
        this.aQD.setStrokeWidth(this.aQB);
        this.aQD.setColor(getResources().getColor(d.C0107d.common_color_10042));
        this.aQD.setStyle(Paint.Style.STROKE);
        this.aQD.setAntiAlias(true);
        this.aQE = new RectF(this.aQA, this.aQA, this.mWidth + this.aQA, this.mWidth + this.aQA);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.drawArc(this.aQE, 0.0f, aQy, false, this.aQD);
        canvas.drawArc(this.aQE, 270.0f, (aQy * this.aQF) / aQz, false, this.aQC);
    }
}
