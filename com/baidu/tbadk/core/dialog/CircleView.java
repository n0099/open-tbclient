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
    private static int acp = 360;
    private static int acq = 100;
    private int acr;
    private int acs;
    private Paint act;
    private Paint acu;
    private RectF acv;
    private int acw;
    private int mWidth;

    public CircleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.acw = 0;
        init();
    }

    public CircleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.acw = 0;
        init();
    }

    public CircleView(Context context) {
        super(context);
        this.acw = 0;
        init();
    }

    public void setProgress(int i) {
        this.acw = i;
        invalidate();
    }

    public void init() {
        this.mWidth = getResources().getDimensionPixelSize(d.e.ds100);
        this.acr = getResources().getDimensionPixelSize(d.e.ds4);
        this.acs = getResources().getDimensionPixelSize(d.e.ds2);
        this.act = new Paint();
        this.act.setStrokeWidth(this.acr);
        this.act.setColor(getResources().getColor(d.C0082d.cp_cont_g));
        this.act.setStyle(Paint.Style.STROKE);
        this.act.setAntiAlias(true);
        this.acu = new Paint();
        this.acu.setStrokeWidth(this.acs);
        this.acu.setColor(getResources().getColor(d.C0082d.common_color_10042));
        this.acu.setStyle(Paint.Style.STROKE);
        this.acu.setAntiAlias(true);
        this.acv = new RectF(this.acr, this.acr, this.mWidth + this.acr, this.mWidth + this.acr);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.drawArc(this.acv, 0.0f, acp, false, this.acu);
        canvas.drawArc(this.acv, 270.0f, (acp * this.acw) / acq, false, this.act);
    }
}
