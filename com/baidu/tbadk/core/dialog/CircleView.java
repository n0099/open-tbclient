package com.baidu.tbadk.core.dialog;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.tieba.e;
/* loaded from: classes.dex */
public class CircleView extends View {
    private static int awX = 360;
    private static int awY = 100;
    private int awZ;
    private Paint axa;
    private Paint axb;
    private RectF axc;
    private int mLineWidth;
    private int mValue;
    private int mWidth;

    public CircleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mValue = 0;
        init();
    }

    public CircleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mValue = 0;
        init();
    }

    public CircleView(Context context) {
        super(context);
        this.mValue = 0;
        init();
    }

    public void setProgress(int i) {
        this.mValue = i;
        invalidate();
    }

    public void init() {
        this.mWidth = getResources().getDimensionPixelSize(e.C0210e.ds100);
        this.mLineWidth = getResources().getDimensionPixelSize(e.C0210e.ds4);
        this.awZ = getResources().getDimensionPixelSize(e.C0210e.ds2);
        this.axa = new Paint();
        this.axa.setStrokeWidth(this.mLineWidth);
        this.axa.setColor(getResources().getColor(e.d.cp_cont_g));
        this.axa.setStyle(Paint.Style.STROKE);
        this.axa.setAntiAlias(true);
        this.axb = new Paint();
        this.axb.setStrokeWidth(this.awZ);
        this.axb.setColor(getResources().getColor(e.d.common_color_10042));
        this.axb.setStyle(Paint.Style.STROKE);
        this.axb.setAntiAlias(true);
        this.axc = new RectF(this.mLineWidth, this.mLineWidth, this.mWidth + this.mLineWidth, this.mWidth + this.mLineWidth);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.drawArc(this.axc, 0.0f, awX, false, this.axb);
        canvas.drawArc(this.axc, 270.0f, (awX * this.mValue) / awY, false, this.axa);
    }
}
