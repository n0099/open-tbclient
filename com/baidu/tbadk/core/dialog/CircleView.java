package com.baidu.tbadk.core.dialog;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class CircleView extends View {
    private static int YQ = 360;
    private static int YR = 100;
    private int YS;
    private int YT;
    private Paint YU;
    private Paint YV;
    private RectF YW;
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
        this.mWidth = getResources().getDimensionPixelSize(t.e.ds100);
        this.YS = getResources().getDimensionPixelSize(t.e.ds4);
        this.YT = getResources().getDimensionPixelSize(t.e.ds2);
        this.YU = new Paint();
        this.YU.setStrokeWidth(this.YS);
        this.YU.setColor(getResources().getColor(t.d.white_alpha100));
        this.YU.setStyle(Paint.Style.STROKE);
        this.YU.setAntiAlias(true);
        this.YV = new Paint();
        this.YV.setStrokeWidth(this.YT);
        this.YV.setColor(getResources().getColor(t.d.white_alpha40));
        this.YV.setStyle(Paint.Style.STROKE);
        this.YV.setAntiAlias(true);
        this.YW = new RectF(this.YS, this.YS, this.mWidth + this.YS, this.mWidth + this.YS);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.drawArc(this.YW, 0.0f, YQ, false, this.YV);
        canvas.drawArc(this.YW, 270.0f, (YQ * this.mValue) / YR, false, this.YU);
    }
}
