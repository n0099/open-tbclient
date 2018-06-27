package com.baidu.tbadk.core.dialog;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class CircleView1080 extends View {
    private static int alM = 360;
    private static int alN = 100;
    private int alO;
    private Paint alQ;
    private RectF alS;
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
        this.mWidth = getResources().getDimensionPixelSize(d.e.tbds122);
        this.alO = getResources().getDimensionPixelSize(d.e.tbds6);
        this.alQ = new Paint();
        this.alQ.setStrokeWidth(this.alO);
        this.alQ.setColor(getResources().getColor(d.C0142d.cp_cont_g));
        this.alQ.setStyle(Paint.Style.STROKE);
        this.alQ.setAntiAlias(true);
        this.alQ.setStrokeCap(Paint.Cap.ROUND);
        this.alS = new RectF(this.alO / 2, this.alO / 2, this.mWidth + (this.alO / 2), this.mWidth + (this.alO / 2));
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.drawArc(this.alS, 270.0f, (alM * this.mValue) / alN, false, this.alQ);
    }
}
