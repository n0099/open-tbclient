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
    private static int bFl = 360;
    private static int bFm = 100;
    private int amc;
    private int bFn;
    private Paint bFo;
    private Paint bFp;
    private RectF bFq;
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
        this.amc = getResources().getDimensionPixelSize(d.e.ds4);
        this.bFn = getResources().getDimensionPixelSize(d.e.ds2);
        this.bFo = new Paint();
        this.bFo.setStrokeWidth(this.amc);
        this.bFo.setColor(getResources().getColor(d.C0277d.cp_cont_g));
        this.bFo.setStyle(Paint.Style.STROKE);
        this.bFo.setAntiAlias(true);
        this.bFp = new Paint();
        this.bFp.setStrokeWidth(this.bFn);
        this.bFp.setColor(getResources().getColor(d.C0277d.common_color_10042));
        this.bFp.setStyle(Paint.Style.STROKE);
        this.bFp.setAntiAlias(true);
        this.bFq = new RectF(this.amc, this.amc, this.mWidth + this.amc, this.mWidth + this.amc);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.drawArc(this.bFq, 0.0f, bFl, false, this.bFp);
        canvas.drawArc(this.bFq, 270.0f, (bFl * this.mValue) / bFm, false, this.bFo);
    }
}
