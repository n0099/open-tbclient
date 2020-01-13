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
    private static int cRg = 360;
    private static int cRh = 100;
    private int awQ;
    private Paint cRj;
    private RectF cRl;
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
        this.awQ = getResources().getDimensionPixelSize(R.dimen.tbds6);
        this.cRj = new Paint();
        this.cRj.setStrokeWidth(this.awQ);
        this.cRj.setColor(getResources().getColor(R.color.cp_cont_g));
        this.cRj.setStyle(Paint.Style.STROKE);
        this.cRj.setAntiAlias(true);
        this.cRj.setStrokeCap(Paint.Cap.ROUND);
        this.cRl = new RectF(this.awQ / 2, this.awQ / 2, this.mWidth + (this.awQ / 2), this.mWidth + (this.awQ / 2));
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.drawArc(this.cRl, 270.0f, (cRg * this.mValue) / cRh, false, this.cRj);
    }
}
