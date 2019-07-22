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
    private static int bNG = 360;
    private static int bNH = 100;
    private int amS;
    private int bNI;
    private Paint bNJ;
    private Paint bNK;
    private RectF bNL;
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
        this.amS = getResources().getDimensionPixelSize(R.dimen.ds4);
        this.bNI = getResources().getDimensionPixelSize(R.dimen.ds2);
        this.bNJ = new Paint();
        this.bNJ.setStrokeWidth(this.amS);
        this.bNJ.setColor(getResources().getColor(R.color.cp_cont_g));
        this.bNJ.setStyle(Paint.Style.STROKE);
        this.bNJ.setAntiAlias(true);
        this.bNK = new Paint();
        this.bNK.setStrokeWidth(this.bNI);
        this.bNK.setColor(getResources().getColor(R.color.common_color_10042));
        this.bNK.setStyle(Paint.Style.STROKE);
        this.bNK.setAntiAlias(true);
        this.bNL = new RectF(this.amS, this.amS, this.mWidth + this.amS, this.mWidth + this.amS);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.drawArc(this.bNL, 0.0f, bNG, false, this.bNK);
        canvas.drawArc(this.bNL, 270.0f, (bNG * this.mValue) / bNH, false, this.bNJ);
    }
}
