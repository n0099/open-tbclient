package com.baidu.tbadk.core.dialog;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class CircleView1080 extends View {
    private static int bNG = 360;
    private static int bNH = 100;
    private int amS;
    private Paint bNJ;
    private RectF bNL;
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
        this.mWidth = getResources().getDimensionPixelSize(R.dimen.tbds122);
        this.amS = getResources().getDimensionPixelSize(R.dimen.tbds6);
        this.bNJ = new Paint();
        this.bNJ.setStrokeWidth(this.amS);
        this.bNJ.setColor(getResources().getColor(R.color.cp_cont_g));
        this.bNJ.setStyle(Paint.Style.STROKE);
        this.bNJ.setAntiAlias(true);
        this.bNJ.setStrokeCap(Paint.Cap.ROUND);
        this.bNL = new RectF(this.amS / 2, this.amS / 2, this.mWidth + (this.amS / 2), this.mWidth + (this.amS / 2));
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.drawArc(this.bNL, 270.0f, (bNG * this.mValue) / bNH, false, this.bNJ);
    }
}
