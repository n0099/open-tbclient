package com.baidu.tbadk.core.dialog;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class CircleView1080 extends View {
    private static int bOk = 360;
    private static int bOl = 100;
    private int anq;
    private Paint bOn;
    private RectF bOp;
    private int mValue;
    private int mWidth;

    public CircleView1080(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mValue = 0;
        init();
    }

    public CircleView1080(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mValue = 0;
        init();
    }

    public CircleView1080(Context context) {
        super(context);
        this.mValue = 0;
        init();
    }

    public void setProgress(int i) {
        this.mValue = i;
        invalidate();
    }

    public void init() {
        this.mWidth = getResources().getDimensionPixelSize(R.dimen.tbds122);
        this.anq = getResources().getDimensionPixelSize(R.dimen.tbds6);
        this.bOn = new Paint();
        this.bOn.setStrokeWidth(this.anq);
        this.bOn.setColor(getResources().getColor(R.color.cp_cont_g));
        this.bOn.setStyle(Paint.Style.STROKE);
        this.bOn.setAntiAlias(true);
        this.bOn.setStrokeCap(Paint.Cap.ROUND);
        this.bOp = new RectF(this.anq / 2, this.anq / 2, this.mWidth + (this.anq / 2), this.mWidth + (this.anq / 2));
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.drawArc(this.bOp, 270.0f, (bOk * this.mValue) / bOl, false, this.bOn);
    }
}
