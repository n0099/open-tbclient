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
    private static int anQ = 360;
    private static int anR = 100;
    private int anS;
    private int anT;
    private Paint anU;
    private Paint anV;
    private RectF anW;
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
        this.mWidth = getResources().getDimensionPixelSize(e.C0141e.ds100);
        this.anS = getResources().getDimensionPixelSize(e.C0141e.ds4);
        this.anT = getResources().getDimensionPixelSize(e.C0141e.ds2);
        this.anU = new Paint();
        this.anU.setStrokeWidth(this.anS);
        this.anU.setColor(getResources().getColor(e.d.cp_cont_g));
        this.anU.setStyle(Paint.Style.STROKE);
        this.anU.setAntiAlias(true);
        this.anV = new Paint();
        this.anV.setStrokeWidth(this.anT);
        this.anV.setColor(getResources().getColor(e.d.common_color_10042));
        this.anV.setStyle(Paint.Style.STROKE);
        this.anV.setAntiAlias(true);
        this.anW = new RectF(this.anS, this.anS, this.mWidth + this.anS, this.mWidth + this.anS);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.drawArc(this.anW, 0.0f, anQ, false, this.anV);
        canvas.drawArc(this.anW, 270.0f, (anQ * this.mValue) / anR, false, this.anU);
    }
}
