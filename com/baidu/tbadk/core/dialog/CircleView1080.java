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
    private static int cVx = 360;
    private static int cVy = 100;
    private int aBw;
    private Paint cVA;
    private RectF cVC;
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
        this.aBw = getResources().getDimensionPixelSize(R.dimen.tbds6);
        this.cVA = new Paint();
        this.cVA.setStrokeWidth(this.aBw);
        this.cVA.setColor(getResources().getColor(R.color.cp_cont_g));
        this.cVA.setStyle(Paint.Style.STROKE);
        this.cVA.setAntiAlias(true);
        this.cVA.setStrokeCap(Paint.Cap.ROUND);
        this.cVC = new RectF(this.aBw / 2, this.aBw / 2, this.mWidth + (this.aBw / 2), this.mWidth + (this.aBw / 2));
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.drawArc(this.cVC, 270.0f, (cVx * this.mValue) / cVy, false, this.cVA);
    }
}
