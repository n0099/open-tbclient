package com.baidu.tbadk.core.dialog;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class CircleView extends View {
    private static int bOk = 360;
    private static int bOl = 100;
    private int anq;
    private int bOm;
    private Paint bOn;
    private Paint bOo;
    private RectF bOp;
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
        this.mWidth = getResources().getDimensionPixelSize(R.dimen.ds100);
        this.anq = getResources().getDimensionPixelSize(R.dimen.ds4);
        this.bOm = getResources().getDimensionPixelSize(R.dimen.ds2);
        this.bOn = new Paint();
        this.bOn.setStrokeWidth(this.anq);
        this.bOn.setColor(getResources().getColor(R.color.cp_cont_g));
        this.bOn.setStyle(Paint.Style.STROKE);
        this.bOn.setAntiAlias(true);
        this.bOo = new Paint();
        this.bOo.setStrokeWidth(this.bOm);
        this.bOo.setColor(getResources().getColor(R.color.common_color_10042));
        this.bOo.setStyle(Paint.Style.STROKE);
        this.bOo.setAntiAlias(true);
        this.bOp = new RectF(this.anq, this.anq, this.mWidth + this.anq, this.mWidth + this.anq);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.drawArc(this.bOp, 0.0f, bOk, false, this.bOo);
        canvas.drawArc(this.bOp, 270.0f, (bOk * this.mValue) / bOl, false, this.bOn);
    }
}
