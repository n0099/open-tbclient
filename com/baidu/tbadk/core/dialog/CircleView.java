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
    private static int Xi = 360;
    private static int Xj = 100;
    private int Xk;
    private int Xl;
    private Paint Xm;
    private Paint Xn;
    private RectF Xo;
    private int Xp;
    private int mWidth;

    public CircleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.Xp = 0;
        init();
    }

    public CircleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Xp = 0;
        init();
    }

    public CircleView(Context context) {
        super(context);
        this.Xp = 0;
        init();
    }

    public void setProgress(int i) {
        this.Xp = i;
        invalidate();
    }

    public void init() {
        this.mWidth = getResources().getDimensionPixelSize(t.e.ds100);
        this.Xk = getResources().getDimensionPixelSize(t.e.ds4);
        this.Xl = getResources().getDimensionPixelSize(t.e.ds2);
        this.Xm = new Paint();
        this.Xm.setStrokeWidth(this.Xk);
        this.Xm.setColor(getResources().getColor(t.d.white_alpha100));
        this.Xm.setStyle(Paint.Style.STROKE);
        this.Xm.setAntiAlias(true);
        this.Xn = new Paint();
        this.Xn.setStrokeWidth(this.Xl);
        this.Xn.setColor(getResources().getColor(t.d.white_alpha40));
        this.Xn.setStyle(Paint.Style.STROKE);
        this.Xn.setAntiAlias(true);
        this.Xo = new RectF(this.Xk, this.Xk, this.mWidth + this.Xk, this.mWidth + this.Xk);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.drawArc(this.Xo, 0.0f, Xi, false, this.Xn);
        canvas.drawArc(this.Xo, 270.0f, (Xi * this.Xp) / Xj, false, this.Xm);
    }
}
