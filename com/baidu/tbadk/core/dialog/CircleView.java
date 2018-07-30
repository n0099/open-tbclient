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
    private static int alm = 360;
    private static int aln = 100;
    private int alo;
    private int alp;
    private Paint alq;
    private Paint alr;
    private RectF als;
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
        this.mWidth = getResources().getDimensionPixelSize(d.e.ds100);
        this.alo = getResources().getDimensionPixelSize(d.e.ds4);
        this.alp = getResources().getDimensionPixelSize(d.e.ds2);
        this.alq = new Paint();
        this.alq.setStrokeWidth(this.alo);
        this.alq.setColor(getResources().getColor(d.C0140d.cp_cont_g));
        this.alq.setStyle(Paint.Style.STROKE);
        this.alq.setAntiAlias(true);
        this.alr = new Paint();
        this.alr.setStrokeWidth(this.alp);
        this.alr.setColor(getResources().getColor(d.C0140d.common_color_10042));
        this.alr.setStyle(Paint.Style.STROKE);
        this.alr.setAntiAlias(true);
        this.als = new RectF(this.alo, this.alo, this.mWidth + this.alo, this.mWidth + this.alo);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.drawArc(this.als, 0.0f, alm, false, this.alr);
        canvas.drawArc(this.als, 270.0f, (alm * this.mValue) / aln, false, this.alq);
    }
}
