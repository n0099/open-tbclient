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
    private static int cfn = 360;
    private static int cfo = 100;
    private int aoz;
    private Paint cfq;
    private RectF cfs;
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
        this.aoz = getResources().getDimensionPixelSize(R.dimen.tbds6);
        this.cfq = new Paint();
        this.cfq.setStrokeWidth(this.aoz);
        this.cfq.setColor(getResources().getColor(R.color.cp_cont_g));
        this.cfq.setStyle(Paint.Style.STROKE);
        this.cfq.setAntiAlias(true);
        this.cfq.setStrokeCap(Paint.Cap.ROUND);
        this.cfs = new RectF(this.aoz / 2, this.aoz / 2, this.mWidth + (this.aoz / 2), this.mWidth + (this.aoz / 2));
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.drawArc(this.cfs, 270.0f, (cfn * this.mValue) / cfo, false, this.cfq);
    }
}
