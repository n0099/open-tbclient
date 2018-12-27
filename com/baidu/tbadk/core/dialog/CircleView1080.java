package com.baidu.tbadk.core.dialog;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.tieba.e;
/* loaded from: classes.dex */
public class CircleView1080 extends View {
    private static int awY = 360;
    private static int awZ = 100;
    private Paint axb;
    private RectF axd;
    private int mLineWidth;
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
        this.mWidth = getResources().getDimensionPixelSize(e.C0210e.tbds122);
        this.mLineWidth = getResources().getDimensionPixelSize(e.C0210e.tbds6);
        this.axb = new Paint();
        this.axb.setStrokeWidth(this.mLineWidth);
        this.axb.setColor(getResources().getColor(e.d.cp_cont_g));
        this.axb.setStyle(Paint.Style.STROKE);
        this.axb.setAntiAlias(true);
        this.axb.setStrokeCap(Paint.Cap.ROUND);
        this.axd = new RectF(this.mLineWidth / 2, this.mLineWidth / 2, this.mWidth + (this.mLineWidth / 2), this.mWidth + (this.mLineWidth / 2));
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.drawArc(this.axd, 270.0f, (awY * this.mValue) / awZ, false, this.axb);
    }
}
