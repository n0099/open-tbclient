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
    private static int cew = 360;
    private static int cex = 100;
    private int aoh;
    private RectF ceB;
    private Paint cez;
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
        this.aoh = getResources().getDimensionPixelSize(R.dimen.tbds6);
        this.cez = new Paint();
        this.cez.setStrokeWidth(this.aoh);
        this.cez.setColor(getResources().getColor(R.color.cp_cont_g));
        this.cez.setStyle(Paint.Style.STROKE);
        this.cez.setAntiAlias(true);
        this.cez.setStrokeCap(Paint.Cap.ROUND);
        this.ceB = new RectF(this.aoh / 2, this.aoh / 2, this.mWidth + (this.aoh / 2), this.mWidth + (this.aoh / 2));
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.drawArc(this.ceB, 270.0f, (cew * this.mValue) / cex, false, this.cez);
    }
}
