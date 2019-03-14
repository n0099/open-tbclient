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
    private static int bFj = 360;
    private static int bFk = 100;
    private int alY;
    private Paint bFm;
    private RectF bFo;
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
        this.alY = getResources().getDimensionPixelSize(d.e.tbds6);
        this.bFm = new Paint();
        this.bFm.setStrokeWidth(this.alY);
        this.bFm.setColor(getResources().getColor(d.C0277d.cp_cont_g));
        this.bFm.setStyle(Paint.Style.STROKE);
        this.bFm.setAntiAlias(true);
        this.bFm.setStrokeCap(Paint.Cap.ROUND);
        this.bFo = new RectF(this.alY / 2, this.alY / 2, this.mWidth + (this.alY / 2), this.mWidth + (this.alY / 2));
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.drawArc(this.bFo, 270.0f, (bFj * this.mValue) / bFk, false, this.bFm);
    }
}
