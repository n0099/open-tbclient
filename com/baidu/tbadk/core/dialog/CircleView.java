package com.baidu.tbadk.core.dialog;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class CircleView extends View {
    private static int Tv = 360;
    private static int Tw = 100;
    private Paint TA;
    private RectF TB;
    private int TC;
    private int Tx;
    private int Ty;
    private Paint Tz;
    private int mWidth;

    public CircleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.TC = 0;
        init();
    }

    public CircleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.TC = 0;
        init();
    }

    public CircleView(Context context) {
        super(context);
        this.TC = 0;
        init();
    }

    public void setProgress(int i) {
        this.TC = i;
        invalidate();
    }

    public void init() {
        this.mWidth = getResources().getDimensionPixelSize(u.e.ds100);
        this.Tx = getResources().getDimensionPixelSize(u.e.ds4);
        this.Ty = getResources().getDimensionPixelSize(u.e.ds2);
        this.Tz = new Paint();
        this.Tz.setStrokeWidth(this.Tx);
        this.Tz.setColor(getResources().getColor(u.d.cp_cont_g));
        this.Tz.setStyle(Paint.Style.STROKE);
        this.Tz.setAntiAlias(true);
        this.TA = new Paint();
        this.TA.setStrokeWidth(this.Ty);
        this.TA.setColor(getResources().getColor(u.d.common_color_10042));
        this.TA.setStyle(Paint.Style.STROKE);
        this.TA.setAntiAlias(true);
        this.TB = new RectF(this.Tx, this.Tx, this.mWidth + this.Tx, this.mWidth + this.Tx);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.drawArc(this.TB, 0.0f, Tv, false, this.TA);
        canvas.drawArc(this.TB, 270.0f, (Tv * this.TC) / Tw, false, this.Tz);
    }
}
