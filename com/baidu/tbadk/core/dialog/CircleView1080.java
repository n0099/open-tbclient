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
    private static int duI = 360;
    private static int duJ = 100;
    private int aVd;
    private Paint duL;
    private RectF duN;
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
        this.aVd = getResources().getDimensionPixelSize(R.dimen.tbds6);
        this.duL = new Paint();
        this.duL.setStrokeWidth(this.aVd);
        this.duL.setColor(getResources().getColor(R.color.cp_cont_g));
        this.duL.setStyle(Paint.Style.STROKE);
        this.duL.setAntiAlias(true);
        this.duL.setStrokeCap(Paint.Cap.ROUND);
        this.duN = new RectF(this.aVd / 2, this.aVd / 2, this.mWidth + (this.aVd / 2), this.mWidth + (this.aVd / 2));
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.drawArc(this.duN, 270.0f, (duI * this.mValue) / duJ, false, this.duL);
    }
}
