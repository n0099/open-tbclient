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
    private static int bFh = 360;
    private static int bFi = 100;
    private int alX;
    private int bFj;
    private Paint bFk;
    private Paint bFl;
    private RectF bFm;
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
        this.alX = getResources().getDimensionPixelSize(d.e.ds4);
        this.bFj = getResources().getDimensionPixelSize(d.e.ds2);
        this.bFk = new Paint();
        this.bFk.setStrokeWidth(this.alX);
        this.bFk.setColor(getResources().getColor(d.C0236d.cp_cont_g));
        this.bFk.setStyle(Paint.Style.STROKE);
        this.bFk.setAntiAlias(true);
        this.bFl = new Paint();
        this.bFl.setStrokeWidth(this.bFj);
        this.bFl.setColor(getResources().getColor(d.C0236d.common_color_10042));
        this.bFl.setStyle(Paint.Style.STROKE);
        this.bFl.setAntiAlias(true);
        this.bFm = new RectF(this.alX, this.alX, this.mWidth + this.alX, this.mWidth + this.alX);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.drawArc(this.bFm, 0.0f, bFh, false, this.bFl);
        canvas.drawArc(this.bFm, 270.0f, (bFh * this.mValue) / bFi, false, this.bFk);
    }
}
