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
    private static int cew = 360;
    private static int cex = 100;
    private int aoh;
    private Paint ceA;
    private RectF ceB;
    private int cey;
    private Paint cez;
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
        this.aoh = getResources().getDimensionPixelSize(R.dimen.ds4);
        this.cey = getResources().getDimensionPixelSize(R.dimen.ds2);
        this.cez = new Paint();
        this.cez.setStrokeWidth(this.aoh);
        this.cez.setColor(getResources().getColor(R.color.cp_cont_g));
        this.cez.setStyle(Paint.Style.STROKE);
        this.cez.setAntiAlias(true);
        this.ceA = new Paint();
        this.ceA.setStrokeWidth(this.cey);
        this.ceA.setColor(getResources().getColor(R.color.common_color_10042));
        this.ceA.setStyle(Paint.Style.STROKE);
        this.ceA.setAntiAlias(true);
        this.ceB = new RectF(this.aoh, this.aoh, this.mWidth + this.aoh, this.mWidth + this.aoh);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.drawArc(this.ceB, 0.0f, cew, false, this.ceA);
        canvas.drawArc(this.ceB, 270.0f, (cew * this.mValue) / cex, false, this.cez);
    }
}
