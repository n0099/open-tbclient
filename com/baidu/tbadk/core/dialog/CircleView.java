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
    private static int abH = 360;
    private static int abI = 100;
    private int abJ;
    private int abK;
    private Paint abL;
    private Paint abM;
    private RectF abN;
    private int abO;
    private int mWidth;

    public CircleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.abO = 0;
        init();
    }

    public CircleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.abO = 0;
        init();
    }

    public CircleView(Context context) {
        super(context);
        this.abO = 0;
        init();
    }

    public void setProgress(int i) {
        this.abO = i;
        invalidate();
    }

    public void init() {
        this.mWidth = getResources().getDimensionPixelSize(d.f.ds100);
        this.abJ = getResources().getDimensionPixelSize(d.f.ds4);
        this.abK = getResources().getDimensionPixelSize(d.f.ds2);
        this.abL = new Paint();
        this.abL.setStrokeWidth(this.abJ);
        this.abL.setColor(getResources().getColor(d.e.cp_cont_g));
        this.abL.setStyle(Paint.Style.STROKE);
        this.abL.setAntiAlias(true);
        this.abM = new Paint();
        this.abM.setStrokeWidth(this.abK);
        this.abM.setColor(getResources().getColor(d.e.common_color_10042));
        this.abM.setStyle(Paint.Style.STROKE);
        this.abM.setAntiAlias(true);
        this.abN = new RectF(this.abJ, this.abJ, this.mWidth + this.abJ, this.mWidth + this.abJ);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.drawArc(this.abN, 0.0f, abH, false, this.abM);
        canvas.drawArc(this.abN, 270.0f, (abH * this.abO) / abI, false, this.abL);
    }
}
