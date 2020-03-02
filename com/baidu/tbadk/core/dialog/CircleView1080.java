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
    private static int cVj = 360;
    private static int cVk = 100;
    private int aBh;
    private Paint cVm;
    private RectF cVo;
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
        this.aBh = getResources().getDimensionPixelSize(R.dimen.tbds6);
        this.cVm = new Paint();
        this.cVm.setStrokeWidth(this.aBh);
        this.cVm.setColor(getResources().getColor(R.color.cp_cont_g));
        this.cVm.setStyle(Paint.Style.STROKE);
        this.cVm.setAntiAlias(true);
        this.cVm.setStrokeCap(Paint.Cap.ROUND);
        this.cVo = new RectF(this.aBh / 2, this.aBh / 2, this.mWidth + (this.aBh / 2), this.mWidth + (this.aBh / 2));
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.drawArc(this.cVo, 270.0f, (cVj * this.mValue) / cVk, false, this.cVm);
    }
}
