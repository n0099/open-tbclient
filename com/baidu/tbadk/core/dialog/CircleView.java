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
    private static int bFj = 360;
    private static int bFk = 100;
    private int alY;
    private int bFl;
    private Paint bFm;
    private Paint bFn;
    private RectF bFo;
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
        this.alY = getResources().getDimensionPixelSize(d.e.ds4);
        this.bFl = getResources().getDimensionPixelSize(d.e.ds2);
        this.bFm = new Paint();
        this.bFm.setStrokeWidth(this.alY);
        this.bFm.setColor(getResources().getColor(d.C0277d.cp_cont_g));
        this.bFm.setStyle(Paint.Style.STROKE);
        this.bFm.setAntiAlias(true);
        this.bFn = new Paint();
        this.bFn.setStrokeWidth(this.bFl);
        this.bFn.setColor(getResources().getColor(d.C0277d.common_color_10042));
        this.bFn.setStyle(Paint.Style.STROKE);
        this.bFn.setAntiAlias(true);
        this.bFo = new RectF(this.alY, this.alY, this.mWidth + this.alY, this.mWidth + this.alY);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.drawArc(this.bFo, 0.0f, bFj, false, this.bFn);
        canvas.drawArc(this.bFo, 270.0f, (bFj * this.mValue) / bFk, false, this.bFm);
    }
}
