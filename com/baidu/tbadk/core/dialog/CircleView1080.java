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
    private static int dIH = 360;
    private static int dII = 100;
    private int bcw;
    private Paint dIK;
    private RectF dIM;
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
        this.bcw = getResources().getDimensionPixelSize(R.dimen.tbds6);
        this.dIK = new Paint();
        this.dIK.setStrokeWidth(this.bcw);
        this.dIK.setColor(getResources().getColor(R.color.cp_cont_g));
        this.dIK.setStyle(Paint.Style.STROKE);
        this.dIK.setAntiAlias(true);
        this.dIK.setStrokeCap(Paint.Cap.ROUND);
        this.dIM = new RectF(this.bcw / 2, this.bcw / 2, this.mWidth + (this.bcw / 2), this.mWidth + (this.bcw / 2));
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.drawArc(this.dIM, 270.0f, (dIH * this.mValue) / dII, false, this.dIK);
    }
}
