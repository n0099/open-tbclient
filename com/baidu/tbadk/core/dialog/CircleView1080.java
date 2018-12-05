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
    private static int awX = 360;
    private static int awY = 100;
    private Paint axa;
    private RectF axc;
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
        this.axa = new Paint();
        this.axa.setStrokeWidth(this.mLineWidth);
        this.axa.setColor(getResources().getColor(e.d.cp_cont_g));
        this.axa.setStyle(Paint.Style.STROKE);
        this.axa.setAntiAlias(true);
        this.axa.setStrokeCap(Paint.Cap.ROUND);
        this.axc = new RectF(this.mLineWidth / 2, this.mLineWidth / 2, this.mWidth + (this.mLineWidth / 2), this.mWidth + (this.mLineWidth / 2));
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.drawArc(this.axc, 270.0f, (awX * this.mValue) / awY, false, this.axa);
    }
}
