package com.baidu.tbadk.core.dialog;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class CircleView extends View {
    private static int duM = 360;
    private static int duN = 100;
    private int aVi;
    private int duO;
    private Paint duP;
    private Paint duQ;
    private RectF duR;
    private int mValue;
    private int mWidth;

    public CircleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mValue = 0;
        init();
    }

    public CircleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mValue = 0;
        init();
    }

    public CircleView(Context context) {
        super(context);
        this.mValue = 0;
        init();
    }

    public void setProgress(int i) {
        this.mValue = i;
        invalidate();
    }

    public void init() {
        this.mWidth = getResources().getDimensionPixelSize(R.dimen.ds100);
        this.aVi = getResources().getDimensionPixelSize(R.dimen.ds4);
        this.duO = getResources().getDimensionPixelSize(R.dimen.ds2);
        this.duP = new Paint();
        this.duP.setStrokeWidth(this.aVi);
        this.duP.setColor(getResources().getColor(R.color.cp_cont_g));
        this.duP.setStyle(Paint.Style.STROKE);
        this.duP.setAntiAlias(true);
        this.duQ = new Paint();
        this.duQ.setStrokeWidth(this.duO);
        this.duQ.setColor(getResources().getColor(R.color.common_color_10042));
        this.duQ.setStyle(Paint.Style.STROKE);
        this.duQ.setAntiAlias(true);
        this.duR = new RectF(this.aVi, this.aVi, this.mWidth + this.aVi, this.mWidth + this.aVi);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.drawArc(this.duR, 0.0f, duM, false, this.duQ);
        canvas.drawArc(this.duR, 270.0f, (duM * this.mValue) / duN, false, this.duP);
    }
}
