package com.baidu.tbadk.core.dialog;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class CircleView extends View {
    private static int acm = 360;
    private static int acn = 100;
    private int aco;
    private int acp;
    private Paint acq;
    private Paint acr;
    private RectF acs;
    private int act;
    private int mWidth;

    public CircleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.act = 0;
        init();
    }

    public CircleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.act = 0;
        init();
    }

    public CircleView(Context context) {
        super(context);
        this.act = 0;
        init();
    }

    public void setProgress(int i) {
        this.act = i;
        invalidate();
    }

    public void init() {
        this.mWidth = getResources().getDimensionPixelSize(d.e.ds100);
        this.aco = getResources().getDimensionPixelSize(d.e.ds4);
        this.acp = getResources().getDimensionPixelSize(d.e.ds2);
        this.acq = new Paint();
        this.acq.setStrokeWidth(this.aco);
        this.acq.setColor(getResources().getColor(d.C0095d.cp_cont_g));
        this.acq.setStyle(Paint.Style.STROKE);
        this.acq.setAntiAlias(true);
        this.acr = new Paint();
        this.acr.setStrokeWidth(this.acp);
        this.acr.setColor(getResources().getColor(d.C0095d.common_color_10042));
        this.acr.setStyle(Paint.Style.STROKE);
        this.acr.setAntiAlias(true);
        this.acs = new RectF(this.aco, this.aco, this.mWidth + this.aco, this.mWidth + this.aco);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.drawArc(this.acs, 0.0f, acm, false, this.acr);
        canvas.drawArc(this.acs, 270.0f, (acm * this.act) / acn, false, this.acq);
    }
}
