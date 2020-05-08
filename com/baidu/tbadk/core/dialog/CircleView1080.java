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
    private static int duM = 360;
    private static int duN = 100;
    private int aVi;
    private Paint duP;
    private RectF duR;
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
        this.aVi = getResources().getDimensionPixelSize(R.dimen.tbds6);
        this.duP = new Paint();
        this.duP.setStrokeWidth(this.aVi);
        this.duP.setColor(getResources().getColor(R.color.cp_cont_g));
        this.duP.setStyle(Paint.Style.STROKE);
        this.duP.setAntiAlias(true);
        this.duP.setStrokeCap(Paint.Cap.ROUND);
        this.duR = new RectF(this.aVi / 2, this.aVi / 2, this.mWidth + (this.aVi / 2), this.mWidth + (this.aVi / 2));
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.drawArc(this.duR, 270.0f, (duM * this.mValue) / duN, false, this.duP);
    }
}
