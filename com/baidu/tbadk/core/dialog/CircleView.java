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
    private static int abv = 360;
    private static int abw = 100;
    private Paint abA;
    private RectF abB;
    private int abC;
    private int abx;
    private int aby;
    private Paint abz;
    private int mWidth;

    public CircleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.abC = 0;
        init();
    }

    public CircleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.abC = 0;
        init();
    }

    public CircleView(Context context) {
        super(context);
        this.abC = 0;
        init();
    }

    public void setProgress(int i) {
        this.abC = i;
        invalidate();
    }

    public void init() {
        this.mWidth = getResources().getDimensionPixelSize(d.f.ds100);
        this.abx = getResources().getDimensionPixelSize(d.f.ds4);
        this.aby = getResources().getDimensionPixelSize(d.f.ds2);
        this.abz = new Paint();
        this.abz.setStrokeWidth(this.abx);
        this.abz.setColor(getResources().getColor(d.e.cp_cont_g));
        this.abz.setStyle(Paint.Style.STROKE);
        this.abz.setAntiAlias(true);
        this.abA = new Paint();
        this.abA.setStrokeWidth(this.aby);
        this.abA.setColor(getResources().getColor(d.e.common_color_10042));
        this.abA.setStyle(Paint.Style.STROKE);
        this.abA.setAntiAlias(true);
        this.abB = new RectF(this.abx, this.abx, this.mWidth + this.abx, this.mWidth + this.abx);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.drawArc(this.abB, 0.0f, abv, false, this.abA);
        canvas.drawArc(this.abB, 270.0f, (abv * this.abC) / abw, false, this.abz);
    }
}
