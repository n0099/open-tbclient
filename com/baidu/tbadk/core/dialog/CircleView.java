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
    private static int cVx = 360;
    private static int cVy = 100;
    private int aBw;
    private Paint cVA;
    private Paint cVB;
    private RectF cVC;
    private int cVz;
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
        this.aBw = getResources().getDimensionPixelSize(R.dimen.ds4);
        this.cVz = getResources().getDimensionPixelSize(R.dimen.ds2);
        this.cVA = new Paint();
        this.cVA.setStrokeWidth(this.aBw);
        this.cVA.setColor(getResources().getColor(R.color.cp_cont_g));
        this.cVA.setStyle(Paint.Style.STROKE);
        this.cVA.setAntiAlias(true);
        this.cVB = new Paint();
        this.cVB.setStrokeWidth(this.cVz);
        this.cVB.setColor(getResources().getColor(R.color.common_color_10042));
        this.cVB.setStyle(Paint.Style.STROKE);
        this.cVB.setAntiAlias(true);
        this.cVC = new RectF(this.aBw, this.aBw, this.mWidth + this.aBw, this.mWidth + this.aBw);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.drawArc(this.cVC, 0.0f, cVx, false, this.cVB);
        canvas.drawArc(this.cVC, 270.0f, (cVx * this.mValue) / cVy, false, this.cVA);
    }
}
