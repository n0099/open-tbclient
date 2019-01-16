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
    private static int axA = 360;
    private static int axB = 100;
    private int axC;
    private Paint axD;
    private Paint axE;
    private RectF axF;
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
        this.axC = getResources().getDimensionPixelSize(e.C0210e.ds2);
        this.axD = new Paint();
        this.axD.setStrokeWidth(this.mLineWidth);
        this.axD.setColor(getResources().getColor(e.d.cp_cont_g));
        this.axD.setStyle(Paint.Style.STROKE);
        this.axD.setAntiAlias(true);
        this.axE = new Paint();
        this.axE.setStrokeWidth(this.axC);
        this.axE.setColor(getResources().getColor(e.d.common_color_10042));
        this.axE.setStyle(Paint.Style.STROKE);
        this.axE.setAntiAlias(true);
        this.axF = new RectF(this.mLineWidth, this.mLineWidth, this.mWidth + this.mLineWidth, this.mWidth + this.mLineWidth);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.drawArc(this.axF, 0.0f, axA, false, this.axE);
        canvas.drawArc(this.axF, 270.0f, (axA * this.mValue) / axB, false, this.axD);
    }
}
