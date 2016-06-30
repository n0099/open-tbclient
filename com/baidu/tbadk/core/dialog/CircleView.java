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
    private static int SN = 360;
    private static int SO = 100;
    private int SP;
    private int SQ;
    private Paint SR;
    private Paint SS;
    private RectF ST;
    private int SU;
    private int mWidth;

    public CircleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.SU = 0;
        init();
    }

    public CircleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.SU = 0;
        init();
    }

    public CircleView(Context context) {
        super(context);
        this.SU = 0;
        init();
    }

    public void setProgress(int i) {
        this.SU = i;
        invalidate();
    }

    public void init() {
        this.mWidth = getResources().getDimensionPixelSize(u.e.ds100);
        this.SP = getResources().getDimensionPixelSize(u.e.ds4);
        this.SQ = getResources().getDimensionPixelSize(u.e.ds2);
        this.SR = new Paint();
        this.SR.setStrokeWidth(this.SP);
        this.SR.setColor(getResources().getColor(u.d.cp_cont_g));
        this.SR.setStyle(Paint.Style.STROKE);
        this.SR.setAntiAlias(true);
        this.SS = new Paint();
        this.SS.setStrokeWidth(this.SQ);
        this.SS.setColor(getResources().getColor(u.d.common_color_10042));
        this.SS.setStyle(Paint.Style.STROKE);
        this.SS.setAntiAlias(true);
        this.ST = new RectF(this.SP, this.SP, this.mWidth + this.SP, this.mWidth + this.SP);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.drawArc(this.ST, 0.0f, SN, false, this.SS);
        canvas.drawArc(this.ST, 270.0f, (SN * this.SU) / SO, false, this.SR);
    }
}
