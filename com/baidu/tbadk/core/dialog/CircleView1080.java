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
    private static int bME = 360;
    private static int bMF = 100;
    private int amp;
    private Paint bMH;
    private RectF bMJ;
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
        this.amp = getResources().getDimensionPixelSize(R.dimen.tbds6);
        this.bMH = new Paint();
        this.bMH.setStrokeWidth(this.amp);
        this.bMH.setColor(getResources().getColor(R.color.cp_cont_g));
        this.bMH.setStyle(Paint.Style.STROKE);
        this.bMH.setAntiAlias(true);
        this.bMH.setStrokeCap(Paint.Cap.ROUND);
        this.bMJ = new RectF(this.amp / 2, this.amp / 2, this.mWidth + (this.amp / 2), this.mWidth + (this.amp / 2));
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.drawArc(this.bMJ, 270.0f, (bME * this.mValue) / bMF, false, this.bMH);
    }
}
