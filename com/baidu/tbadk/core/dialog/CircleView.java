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
    private static int asK = 360;
    private static int asL = 100;
    private int asM;
    private Paint asN;
    private Paint asO;
    private RectF asP;
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
        this.mWidth = getResources().getDimensionPixelSize(e.C0175e.ds100);
        this.mLineWidth = getResources().getDimensionPixelSize(e.C0175e.ds4);
        this.asM = getResources().getDimensionPixelSize(e.C0175e.ds2);
        this.asN = new Paint();
        this.asN.setStrokeWidth(this.mLineWidth);
        this.asN.setColor(getResources().getColor(e.d.cp_cont_g));
        this.asN.setStyle(Paint.Style.STROKE);
        this.asN.setAntiAlias(true);
        this.asO = new Paint();
        this.asO.setStrokeWidth(this.asM);
        this.asO.setColor(getResources().getColor(e.d.common_color_10042));
        this.asO.setStyle(Paint.Style.STROKE);
        this.asO.setAntiAlias(true);
        this.asP = new RectF(this.mLineWidth, this.mLineWidth, this.mWidth + this.mLineWidth, this.mWidth + this.mLineWidth);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.drawArc(this.asP, 0.0f, asK, false, this.asO);
        canvas.drawArc(this.asP, 270.0f, (asK * this.mValue) / asL, false, this.asN);
    }
}
