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
    private static int bNL = 360;
    private static int bNM = 100;
    private int amS;
    private Paint bNO;
    private RectF bNQ;
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
        this.bNO = new Paint();
        this.bNO.setStrokeWidth(this.amS);
        this.bNO.setColor(getResources().getColor(R.color.cp_cont_g));
        this.bNO.setStyle(Paint.Style.STROKE);
        this.bNO.setAntiAlias(true);
        this.bNO.setStrokeCap(Paint.Cap.ROUND);
        this.bNQ = new RectF(this.amS / 2, this.amS / 2, this.mWidth + (this.amS / 2), this.mWidth + (this.amS / 2));
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.drawArc(this.bNQ, 270.0f, (bNL * this.mValue) / bNM, false, this.bNO);
    }
}
