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
    private static int Sw = 360;
    private static int Sx = 100;
    private Paint SA;
    private Paint SB;
    private RectF SC;
    private int SD;
    private int Sy;
    private int Sz;
    private int mWidth;

    public CircleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.SD = 0;
        init();
    }

    public CircleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.SD = 0;
        init();
    }

    public CircleView(Context context) {
        super(context);
        this.SD = 0;
        init();
    }

    public void setProgress(int i) {
        this.SD = i;
        invalidate();
    }

    public void init() {
        this.mWidth = getResources().getDimensionPixelSize(t.e.ds100);
        this.Sy = getResources().getDimensionPixelSize(t.e.ds4);
        this.Sz = getResources().getDimensionPixelSize(t.e.ds2);
        this.SA = new Paint();
        this.SA.setStrokeWidth(this.Sy);
        this.SA.setColor(getResources().getColor(t.d.white_alpha100));
        this.SA.setStyle(Paint.Style.STROKE);
        this.SA.setAntiAlias(true);
        this.SB = new Paint();
        this.SB.setStrokeWidth(this.Sz);
        this.SB.setColor(getResources().getColor(t.d.white_alpha40));
        this.SB.setStyle(Paint.Style.STROKE);
        this.SB.setAntiAlias(true);
        this.SC = new RectF(this.Sy, this.Sy, this.mWidth + this.Sy, this.mWidth + this.Sy);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.drawArc(this.SC, 0.0f, Sw, false, this.SB);
        canvas.drawArc(this.SC, 270.0f, (Sw * this.SD) / Sx, false, this.SA);
    }
}
