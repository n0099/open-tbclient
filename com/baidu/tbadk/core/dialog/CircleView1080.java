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
    private static int dPx = 360;
    private static int dPy = 100;
    private int bhG;
    private Paint dPA;
    private RectF dPC;
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
        this.bhG = getResources().getDimensionPixelSize(R.dimen.tbds6);
        this.dPA = new Paint();
        this.dPA.setStrokeWidth(this.bhG);
        this.dPA.setColor(getResources().getColor(R.color.cp_cont_g));
        this.dPA.setStyle(Paint.Style.STROKE);
        this.dPA.setAntiAlias(true);
        this.dPA.setStrokeCap(Paint.Cap.ROUND);
        this.dPC = new RectF(this.bhG / 2, this.bhG / 2, this.mWidth + (this.bhG / 2), this.mWidth + (this.bhG / 2));
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.drawArc(this.dPC, 270.0f, (dPx * this.mValue) / dPy, false, this.dPA);
    }
}
