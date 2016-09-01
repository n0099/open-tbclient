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
    private static int Wl = 360;
    private static int Wm = 100;
    private int Wn;
    private int Wo;
    private Paint Wp;
    private Paint Wq;
    private RectF Wr;
    private int Ws;
    private int mWidth;

    public CircleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.Ws = 0;
        init();
    }

    public CircleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Ws = 0;
        init();
    }

    public CircleView(Context context) {
        super(context);
        this.Ws = 0;
        init();
    }

    public void setProgress(int i) {
        this.Ws = i;
        invalidate();
    }

    public void init() {
        this.mWidth = getResources().getDimensionPixelSize(t.e.ds100);
        this.Wn = getResources().getDimensionPixelSize(t.e.ds4);
        this.Wo = getResources().getDimensionPixelSize(t.e.ds2);
        this.Wp = new Paint();
        this.Wp.setStrokeWidth(this.Wn);
        this.Wp.setColor(getResources().getColor(t.d.cp_cont_g));
        this.Wp.setStyle(Paint.Style.STROKE);
        this.Wp.setAntiAlias(true);
        this.Wq = new Paint();
        this.Wq.setStrokeWidth(this.Wo);
        this.Wq.setColor(getResources().getColor(t.d.common_color_10042));
        this.Wq.setStyle(Paint.Style.STROKE);
        this.Wq.setAntiAlias(true);
        this.Wr = new RectF(this.Wn, this.Wn, this.mWidth + this.Wn, this.mWidth + this.Wn);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.drawArc(this.Wr, 0.0f, Wl, false, this.Wq);
        canvas.drawArc(this.Wr, 270.0f, (Wl * this.Ws) / Wm, false, this.Wp);
    }
}
