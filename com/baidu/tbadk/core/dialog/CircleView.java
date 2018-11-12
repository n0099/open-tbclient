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
    private static int atx = 360;
    private static int aty = 100;
    private Paint atA;
    private Paint atB;
    private RectF atC;
    private int atz;
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
        this.mWidth = getResources().getDimensionPixelSize(e.C0200e.ds100);
        this.mLineWidth = getResources().getDimensionPixelSize(e.C0200e.ds4);
        this.atz = getResources().getDimensionPixelSize(e.C0200e.ds2);
        this.atA = new Paint();
        this.atA.setStrokeWidth(this.mLineWidth);
        this.atA.setColor(getResources().getColor(e.d.cp_cont_g));
        this.atA.setStyle(Paint.Style.STROKE);
        this.atA.setAntiAlias(true);
        this.atB = new Paint();
        this.atB.setStrokeWidth(this.atz);
        this.atB.setColor(getResources().getColor(e.d.common_color_10042));
        this.atB.setStyle(Paint.Style.STROKE);
        this.atB.setAntiAlias(true);
        this.atC = new RectF(this.mLineWidth, this.mLineWidth, this.mWidth + this.mLineWidth, this.mWidth + this.mLineWidth);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.drawArc(this.atC, 0.0f, atx, false, this.atB);
        canvas.drawArc(this.atC, 270.0f, (atx * this.mValue) / aty, false, this.atA);
    }
}
