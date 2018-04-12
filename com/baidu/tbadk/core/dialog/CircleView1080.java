package com.baidu.tbadk.core.dialog;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class CircleView1080 extends View {
    private static int adn = 360;
    private static int ado = 100;
    private int adp;
    private Paint adr;
    private RectF adt;
    private int adu;
    private int mWidth;

    public CircleView1080(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.adu = 0;
        init();
    }

    public CircleView1080(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.adu = 0;
        init();
    }

    public CircleView1080(Context context) {
        super(context);
        this.adu = 0;
        init();
    }

    public void setProgress(int i) {
        this.adu = i;
        invalidate();
    }

    public void init() {
        this.mWidth = getResources().getDimensionPixelSize(d.e.tbds122);
        this.adp = getResources().getDimensionPixelSize(d.e.tbds6);
        this.adr = new Paint();
        this.adr.setStrokeWidth(this.adp);
        this.adr.setColor(getResources().getColor(d.C0126d.cp_cont_g));
        this.adr.setStyle(Paint.Style.STROKE);
        this.adr.setAntiAlias(true);
        this.adr.setStrokeCap(Paint.Cap.ROUND);
        this.adt = new RectF(this.adp / 2, this.adp / 2, this.mWidth + (this.adp / 2), this.mWidth + (this.adp / 2));
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.drawArc(this.adt, 270.0f, (adn * this.adu) / ado, false, this.adr);
    }
}
