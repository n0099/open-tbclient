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
    private static int Wv = 360;
    private static int Ww = 100;
    private Paint WA;
    private RectF WB;
    private int WC;
    private int Wx;
    private int Wy;
    private Paint Wz;
    private int mWidth;

    public CircleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.WC = 0;
        init();
    }

    public CircleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.WC = 0;
        init();
    }

    public CircleView(Context context) {
        super(context);
        this.WC = 0;
        init();
    }

    public void setProgress(int i) {
        this.WC = i;
        invalidate();
    }

    public void init() {
        this.mWidth = getResources().getDimensionPixelSize(r.e.ds100);
        this.Wx = getResources().getDimensionPixelSize(r.e.ds4);
        this.Wy = getResources().getDimensionPixelSize(r.e.ds2);
        this.Wz = new Paint();
        this.Wz.setStrokeWidth(this.Wx);
        this.Wz.setColor(getResources().getColor(r.d.cp_cont_g));
        this.Wz.setStyle(Paint.Style.STROKE);
        this.Wz.setAntiAlias(true);
        this.WA = new Paint();
        this.WA.setStrokeWidth(this.Wy);
        this.WA.setColor(getResources().getColor(r.d.common_color_10042));
        this.WA.setStyle(Paint.Style.STROKE);
        this.WA.setAntiAlias(true);
        this.WB = new RectF(this.Wx, this.Wx, this.mWidth + this.Wx, this.mWidth + this.Wx);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.drawArc(this.WB, 0.0f, Wv, false, this.WA);
        canvas.drawArc(this.WB, 270.0f, (Wv * this.WC) / Ww, false, this.Wz);
    }
}
