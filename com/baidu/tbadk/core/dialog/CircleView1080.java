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
    private static int bFh = 360;
    private static int bFi = 100;
    private int alX;
    private Paint bFk;
    private RectF bFm;
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
        this.alX = getResources().getDimensionPixelSize(d.e.tbds6);
        this.bFk = new Paint();
        this.bFk.setStrokeWidth(this.alX);
        this.bFk.setColor(getResources().getColor(d.C0236d.cp_cont_g));
        this.bFk.setStyle(Paint.Style.STROKE);
        this.bFk.setAntiAlias(true);
        this.bFk.setStrokeCap(Paint.Cap.ROUND);
        this.bFm = new RectF(this.alX / 2, this.alX / 2, this.mWidth + (this.alX / 2), this.mWidth + (this.alX / 2));
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.drawArc(this.bFm, 270.0f, (bFh * this.mValue) / bFi, false, this.bFk);
    }
}
