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
    private static int cVk = 360;
    private static int cVl = 100;
    private int aBi;
    private Paint cVn;
    private RectF cVp;
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
        this.aBi = getResources().getDimensionPixelSize(R.dimen.tbds6);
        this.cVn = new Paint();
        this.cVn.setStrokeWidth(this.aBi);
        this.cVn.setColor(getResources().getColor(R.color.cp_cont_g));
        this.cVn.setStyle(Paint.Style.STROKE);
        this.cVn.setAntiAlias(true);
        this.cVn.setStrokeCap(Paint.Cap.ROUND);
        this.cVp = new RectF(this.aBi / 2, this.aBi / 2, this.mWidth + (this.aBi / 2), this.mWidth + (this.aBi / 2));
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.drawArc(this.cVp, 270.0f, (cVk * this.mValue) / cVl, false, this.cVn);
    }
}
