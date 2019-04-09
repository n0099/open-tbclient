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
    private static int bFm = 360;
    private static int bFn = 100;
    private int amd;
    private Paint bFp;
    private RectF bFr;
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
        this.amd = getResources().getDimensionPixelSize(d.e.tbds6);
        this.bFp = new Paint();
        this.bFp.setStrokeWidth(this.amd);
        this.bFp.setColor(getResources().getColor(d.C0277d.cp_cont_g));
        this.bFp.setStyle(Paint.Style.STROKE);
        this.bFp.setAntiAlias(true);
        this.bFp.setStrokeCap(Paint.Cap.ROUND);
        this.bFr = new RectF(this.amd / 2, this.amd / 2, this.mWidth + (this.amd / 2), this.mWidth + (this.amd / 2));
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.drawArc(this.bFr, 270.0f, (bFm * this.mValue) / bFn, false, this.bFp);
    }
}
