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
    private static int alm = 360;
    private static int aln = 100;
    private int alo;
    private Paint alq;
    private RectF als;
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
        this.alo = getResources().getDimensionPixelSize(d.e.tbds6);
        this.alq = new Paint();
        this.alq.setStrokeWidth(this.alo);
        this.alq.setColor(getResources().getColor(d.C0141d.cp_cont_g));
        this.alq.setStyle(Paint.Style.STROKE);
        this.alq.setAntiAlias(true);
        this.alq.setStrokeCap(Paint.Cap.ROUND);
        this.als = new RectF(this.alo / 2, this.alo / 2, this.mWidth + (this.alo / 2), this.mWidth + (this.alo / 2));
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.drawArc(this.als, 270.0f, (alm * this.mValue) / aln, false, this.alq);
    }
}
