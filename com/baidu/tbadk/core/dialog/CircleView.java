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
    private static int abU = 360;
    private static int abV = 100;
    private int abW;
    private int abX;
    private Paint abY;
    private Paint abZ;
    private RectF aca;
    private int acb;
    private int mWidth;

    public CircleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.acb = 0;
        init();
    }

    public CircleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.acb = 0;
        init();
    }

    public CircleView(Context context) {
        super(context);
        this.acb = 0;
        init();
    }

    public void setProgress(int i) {
        this.acb = i;
        invalidate();
    }

    public void init() {
        this.mWidth = getResources().getDimensionPixelSize(d.e.ds100);
        this.abW = getResources().getDimensionPixelSize(d.e.ds4);
        this.abX = getResources().getDimensionPixelSize(d.e.ds2);
        this.abY = new Paint();
        this.abY.setStrokeWidth(this.abW);
        this.abY.setColor(getResources().getColor(d.C0080d.cp_cont_g));
        this.abY.setStyle(Paint.Style.STROKE);
        this.abY.setAntiAlias(true);
        this.abZ = new Paint();
        this.abZ.setStrokeWidth(this.abX);
        this.abZ.setColor(getResources().getColor(d.C0080d.common_color_10042));
        this.abZ.setStyle(Paint.Style.STROKE);
        this.abZ.setAntiAlias(true);
        this.aca = new RectF(this.abW, this.abW, this.mWidth + this.abW, this.mWidth + this.abW);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.drawArc(this.aca, 0.0f, abU, false, this.abZ);
        canvas.drawArc(this.aca, 270.0f, (abU * this.acb) / abV, false, this.abY);
    }
}
