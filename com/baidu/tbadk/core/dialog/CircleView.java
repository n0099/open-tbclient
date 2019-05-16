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
    private static int bME = 360;
    private static int bMF = 100;
    private int amp;
    private int bMG;
    private Paint bMH;
    private Paint bMI;
    private RectF bMJ;
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
        this.amp = getResources().getDimensionPixelSize(R.dimen.ds4);
        this.bMG = getResources().getDimensionPixelSize(R.dimen.ds2);
        this.bMH = new Paint();
        this.bMH.setStrokeWidth(this.amp);
        this.bMH.setColor(getResources().getColor(R.color.cp_cont_g));
        this.bMH.setStyle(Paint.Style.STROKE);
        this.bMH.setAntiAlias(true);
        this.bMI = new Paint();
        this.bMI.setStrokeWidth(this.bMG);
        this.bMI.setColor(getResources().getColor(R.color.common_color_10042));
        this.bMI.setStyle(Paint.Style.STROKE);
        this.bMI.setAntiAlias(true);
        this.bMJ = new RectF(this.amp, this.amp, this.mWidth + this.amp, this.mWidth + this.amp);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.drawArc(this.bMJ, 0.0f, bME, false, this.bMI);
        canvas.drawArc(this.bMJ, 270.0f, (bME * this.mValue) / bMF, false, this.bMH);
    }
}
