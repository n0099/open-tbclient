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
    private static int awY = 360;
    private static int awZ = 100;
    private int axa;
    private Paint axb;
    private Paint axc;
    private RectF axd;
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
        this.axa = getResources().getDimensionPixelSize(e.C0210e.ds2);
        this.axb = new Paint();
        this.axb.setStrokeWidth(this.mLineWidth);
        this.axb.setColor(getResources().getColor(e.d.cp_cont_g));
        this.axb.setStyle(Paint.Style.STROKE);
        this.axb.setAntiAlias(true);
        this.axc = new Paint();
        this.axc.setStrokeWidth(this.axa);
        this.axc.setColor(getResources().getColor(e.d.common_color_10042));
        this.axc.setStyle(Paint.Style.STROKE);
        this.axc.setAntiAlias(true);
        this.axd = new RectF(this.mLineWidth, this.mLineWidth, this.mWidth + this.mLineWidth, this.mWidth + this.mLineWidth);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.drawArc(this.axd, 0.0f, awY, false, this.axc);
        canvas.drawArc(this.axd, 270.0f, (awY * this.mValue) / awZ, false, this.axb);
    }
}
