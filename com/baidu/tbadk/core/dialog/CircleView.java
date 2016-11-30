package com.baidu.tbadk.core.dialog;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class CircleView extends View {
    private static int WT = 360;
    private static int WU = 100;
    private int WV;
    private int WW;
    private Paint WX;
    private Paint WY;
    private RectF WZ;
    private int Xa;
    private int mWidth;

    public CircleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.Xa = 0;
        init();
    }

    public CircleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Xa = 0;
        init();
    }

    public CircleView(Context context) {
        super(context);
        this.Xa = 0;
        init();
    }

    public void setProgress(int i) {
        this.Xa = i;
        invalidate();
    }

    public void init() {
        this.mWidth = getResources().getDimensionPixelSize(r.e.ds100);
        this.WV = getResources().getDimensionPixelSize(r.e.ds4);
        this.WW = getResources().getDimensionPixelSize(r.e.ds2);
        this.WX = new Paint();
        this.WX.setStrokeWidth(this.WV);
        this.WX.setColor(getResources().getColor(r.d.cp_cont_g));
        this.WX.setStyle(Paint.Style.STROKE);
        this.WX.setAntiAlias(true);
        this.WY = new Paint();
        this.WY.setStrokeWidth(this.WW);
        this.WY.setColor(getResources().getColor(r.d.common_color_10042));
        this.WY.setStyle(Paint.Style.STROKE);
        this.WY.setAntiAlias(true);
        this.WZ = new RectF(this.WV, this.WV, this.mWidth + this.WV, this.mWidth + this.WV);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.drawArc(this.WZ, 0.0f, WT, false, this.WY);
        canvas.drawArc(this.WZ, 270.0f, (WT * this.Xa) / WU, false, this.WX);
    }
}
