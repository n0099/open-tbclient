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
    private static int acx = 360;
    private static int acy = 100;
    private int acA;
    private Paint acB;
    private Paint acC;
    private RectF acD;
    private int acE;
    private int acz;
    private int mWidth;

    public CircleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.acE = 0;
        init();
    }

    public CircleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.acE = 0;
        init();
    }

    public CircleView(Context context) {
        super(context);
        this.acE = 0;
        init();
    }

    public void setProgress(int i) {
        this.acE = i;
        invalidate();
    }

    public void init() {
        this.mWidth = getResources().getDimensionPixelSize(d.f.ds100);
        this.acz = getResources().getDimensionPixelSize(d.f.ds4);
        this.acA = getResources().getDimensionPixelSize(d.f.ds2);
        this.acB = new Paint();
        this.acB.setStrokeWidth(this.acz);
        this.acB.setColor(getResources().getColor(d.e.cp_cont_g));
        this.acB.setStyle(Paint.Style.STROKE);
        this.acB.setAntiAlias(true);
        this.acC = new Paint();
        this.acC.setStrokeWidth(this.acA);
        this.acC.setColor(getResources().getColor(d.e.common_color_10042));
        this.acC.setStyle(Paint.Style.STROKE);
        this.acC.setAntiAlias(true);
        this.acD = new RectF(this.acz, this.acz, this.mWidth + this.acz, this.mWidth + this.acz);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.drawArc(this.acD, 0.0f, acx, false, this.acC);
        canvas.drawArc(this.acD, 270.0f, (acx * this.acE) / acy, false, this.acB);
    }
}
