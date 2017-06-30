package com.baidu.tbadk.core.dialog;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class CircleView extends View {
    private static int aaB = 360;
    private static int aaC = 100;
    private int aaD;
    private int aaE;
    private Paint aaF;
    private Paint aaG;
    private RectF aaH;
    private int aaI;
    private int mWidth;

    public CircleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aaI = 0;
        init();
    }

    public CircleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aaI = 0;
        init();
    }

    public CircleView(Context context) {
        super(context);
        this.aaI = 0;
        init();
    }

    public void setProgress(int i) {
        this.aaI = i;
        invalidate();
    }

    public void init() {
        this.mWidth = getResources().getDimensionPixelSize(w.f.ds100);
        this.aaD = getResources().getDimensionPixelSize(w.f.ds4);
        this.aaE = getResources().getDimensionPixelSize(w.f.ds2);
        this.aaF = new Paint();
        this.aaF.setStrokeWidth(this.aaD);
        this.aaF.setColor(getResources().getColor(w.e.cp_cont_g));
        this.aaF.setStyle(Paint.Style.STROKE);
        this.aaF.setAntiAlias(true);
        this.aaG = new Paint();
        this.aaG.setStrokeWidth(this.aaE);
        this.aaG.setColor(getResources().getColor(w.e.common_color_10042));
        this.aaG.setStyle(Paint.Style.STROKE);
        this.aaG.setAntiAlias(true);
        this.aaH = new RectF(this.aaD, this.aaD, this.mWidth + this.aaD, this.mWidth + this.aaD);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.drawArc(this.aaH, 0.0f, aaB, false, this.aaG);
        canvas.drawArc(this.aaH, 270.0f, (aaB * this.aaI) / aaC, false, this.aaF);
    }
}
