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
    private static int aSa = 360;
    private static int aSb = 100;
    private int aSc;
    private Paint aSe;
    private RectF aSg;
    private int aSh;
    private int mWidth;

    public CircleView1080(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aSh = 0;
        init();
    }

    public CircleView1080(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aSh = 0;
        init();
    }

    public CircleView1080(Context context) {
        super(context);
        this.aSh = 0;
        init();
    }

    public void setProgress(int i) {
        this.aSh = i;
        invalidate();
    }

    public void init() {
        this.mWidth = getResources().getDimensionPixelSize(d.e.tbds122);
        this.aSc = getResources().getDimensionPixelSize(d.e.tbds6);
        this.aSe = new Paint();
        this.aSe.setStrokeWidth(this.aSc);
        this.aSe.setColor(getResources().getColor(d.C0140d.cp_cont_g));
        this.aSe.setStyle(Paint.Style.STROKE);
        this.aSe.setAntiAlias(true);
        this.aSe.setStrokeCap(Paint.Cap.ROUND);
        this.aSg = new RectF(this.aSc / 2, this.aSc / 2, this.mWidth + (this.aSc / 2), this.mWidth + (this.aSc / 2));
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.drawArc(this.aSg, 270.0f, (aSa * this.aSh) / aSb, false, this.aSe);
    }
}
