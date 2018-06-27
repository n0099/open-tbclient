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
    private static int alM = 360;
    private static int alN = 100;
    private int alO;
    private int alP;
    private Paint alQ;
    private Paint alR;
    private RectF alS;
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
        this.mWidth = getResources().getDimensionPixelSize(d.e.ds100);
        this.alO = getResources().getDimensionPixelSize(d.e.ds4);
        this.alP = getResources().getDimensionPixelSize(d.e.ds2);
        this.alQ = new Paint();
        this.alQ.setStrokeWidth(this.alO);
        this.alQ.setColor(getResources().getColor(d.C0142d.cp_cont_g));
        this.alQ.setStyle(Paint.Style.STROKE);
        this.alQ.setAntiAlias(true);
        this.alR = new Paint();
        this.alR.setStrokeWidth(this.alP);
        this.alR.setColor(getResources().getColor(d.C0142d.common_color_10042));
        this.alR.setStyle(Paint.Style.STROKE);
        this.alR.setAntiAlias(true);
        this.alS = new RectF(this.alO, this.alO, this.mWidth + this.alO, this.mWidth + this.alO);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.drawArc(this.alS, 0.0f, alM, false, this.alR);
        canvas.drawArc(this.alS, 270.0f, (alM * this.mValue) / alN, false, this.alQ);
    }
}
