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
    private static int aaA = 360;
    private static int aaB = 100;
    private int aaC;
    private int aaD;
    private Paint aaE;
    private Paint aaF;
    private RectF aaG;
    private int aaH;
    private int mWidth;

    public CircleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aaH = 0;
        init();
    }

    public CircleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aaH = 0;
        init();
    }

    public CircleView(Context context) {
        super(context);
        this.aaH = 0;
        init();
    }

    public void setProgress(int i) {
        this.aaH = i;
        invalidate();
    }

    public void init() {
        this.mWidth = getResources().getDimensionPixelSize(w.f.ds100);
        this.aaC = getResources().getDimensionPixelSize(w.f.ds4);
        this.aaD = getResources().getDimensionPixelSize(w.f.ds2);
        this.aaE = new Paint();
        this.aaE.setStrokeWidth(this.aaC);
        this.aaE.setColor(getResources().getColor(w.e.cp_cont_g));
        this.aaE.setStyle(Paint.Style.STROKE);
        this.aaE.setAntiAlias(true);
        this.aaF = new Paint();
        this.aaF.setStrokeWidth(this.aaD);
        this.aaF.setColor(getResources().getColor(w.e.common_color_10042));
        this.aaF.setStyle(Paint.Style.STROKE);
        this.aaF.setAntiAlias(true);
        this.aaG = new RectF(this.aaC, this.aaC, this.mWidth + this.aaC, this.mWidth + this.aaC);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.drawArc(this.aaG, 0.0f, aaA, false, this.aaF);
        canvas.drawArc(this.aaG, 270.0f, (aaA * this.aaH) / aaB, false, this.aaE);
    }
}
