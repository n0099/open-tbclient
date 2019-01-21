package com.baidu.tbadk.core.dialog;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.tieba.e;
/* loaded from: classes.dex */
public class CircleView extends View {
    private static int axB = 360;
    private static int axC = 100;
    private int axD;
    private Paint axE;
    private Paint axF;
    private RectF axG;
    private int mLineWidth;
    private int mValue;
    private int mWidth;

    public CircleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mValue = 0;
        init();
    }

    public CircleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mValue = 0;
        init();
    }

    public CircleView(Context context) {
        super(context);
        this.mValue = 0;
        init();
    }

    public void setProgress(int i) {
        this.mValue = i;
        invalidate();
    }

    public void init() {
        this.mWidth = getResources().getDimensionPixelSize(e.C0210e.ds100);
        this.mLineWidth = getResources().getDimensionPixelSize(e.C0210e.ds4);
        this.axD = getResources().getDimensionPixelSize(e.C0210e.ds2);
        this.axE = new Paint();
        this.axE.setStrokeWidth(this.mLineWidth);
        this.axE.setColor(getResources().getColor(e.d.cp_cont_g));
        this.axE.setStyle(Paint.Style.STROKE);
        this.axE.setAntiAlias(true);
        this.axF = new Paint();
        this.axF.setStrokeWidth(this.axD);
        this.axF.setColor(getResources().getColor(e.d.common_color_10042));
        this.axF.setStyle(Paint.Style.STROKE);
        this.axF.setAntiAlias(true);
        this.axG = new RectF(this.mLineWidth, this.mLineWidth, this.mWidth + this.mLineWidth, this.mWidth + this.mLineWidth);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.drawArc(this.axG, 0.0f, axB, false, this.axF);
        canvas.drawArc(this.axG, 270.0f, (axB * this.mValue) / axC, false, this.axE);
    }
}
