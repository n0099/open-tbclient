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
    private static int Wn = 360;
    private static int Wo = 100;
    private int Wp;
    private int Wq;
    private Paint Wr;
    private Paint Ws;
    private RectF Wt;
    private int Wu;
    private int mWidth;

    public CircleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.Wu = 0;
        init();
    }

    public CircleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Wu = 0;
        init();
    }

    public CircleView(Context context) {
        super(context);
        this.Wu = 0;
        init();
    }

    public void setProgress(int i) {
        this.Wu = i;
        invalidate();
    }

    public void init() {
        this.mWidth = getResources().getDimensionPixelSize(r.e.ds100);
        this.Wp = getResources().getDimensionPixelSize(r.e.ds4);
        this.Wq = getResources().getDimensionPixelSize(r.e.ds2);
        this.Wr = new Paint();
        this.Wr.setStrokeWidth(this.Wp);
        this.Wr.setColor(getResources().getColor(r.d.cp_cont_g));
        this.Wr.setStyle(Paint.Style.STROKE);
        this.Wr.setAntiAlias(true);
        this.Ws = new Paint();
        this.Ws.setStrokeWidth(this.Wq);
        this.Ws.setColor(getResources().getColor(r.d.common_color_10042));
        this.Ws.setStyle(Paint.Style.STROKE);
        this.Ws.setAntiAlias(true);
        this.Wt = new RectF(this.Wp, this.Wp, this.mWidth + this.Wp, this.mWidth + this.Wp);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.drawArc(this.Wt, 0.0f, Wn, false, this.Ws);
        canvas.drawArc(this.Wt, 270.0f, (Wn * this.Wu) / Wo, false, this.Wr);
    }
}
