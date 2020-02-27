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
    private static int cVi = 360;
    private static int cVj = 100;
    private int aBg;
    private Paint cVl;
    private RectF cVn;
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
        this.aBg = getResources().getDimensionPixelSize(R.dimen.tbds6);
        this.cVl = new Paint();
        this.cVl.setStrokeWidth(this.aBg);
        this.cVl.setColor(getResources().getColor(R.color.cp_cont_g));
        this.cVl.setStyle(Paint.Style.STROKE);
        this.cVl.setAntiAlias(true);
        this.cVl.setStrokeCap(Paint.Cap.ROUND);
        this.cVn = new RectF(this.aBg / 2, this.aBg / 2, this.mWidth + (this.aBg / 2), this.mWidth + (this.aBg / 2));
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.drawArc(this.cVn, 270.0f, (cVi * this.mValue) / cVj, false, this.cVl);
    }
}
