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
    private static int dVP = 360;
    private static int dVQ = 100;
    private int bhZ;
    private Paint dVS;
    private RectF dVU;
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
        this.bhZ = getResources().getDimensionPixelSize(R.dimen.tbds6);
        this.dVS = new Paint();
        this.dVS.setStrokeWidth(this.bhZ);
        this.dVS.setColor(getResources().getColor(R.color.cp_cont_g));
        this.dVS.setStyle(Paint.Style.STROKE);
        this.dVS.setAntiAlias(true);
        this.dVS.setStrokeCap(Paint.Cap.ROUND);
        this.dVU = new RectF(this.bhZ / 2, this.bhZ / 2, this.mWidth + (this.bhZ / 2), this.mWidth + (this.bhZ / 2));
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.drawArc(this.dVU, 270.0f, (dVP * this.mValue) / dVQ, false, this.dVS);
    }
}
