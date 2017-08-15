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
    private int acB;
    private int acC;
    private Paint acD;
    private Paint acE;
    private RectF acF;
    private int acG;
    private int mWidth;
    private static int acz = 360;
    private static int acA = 100;

    public CircleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.acG = 0;
        init();
    }

    public CircleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.acG = 0;
        init();
    }

    public CircleView(Context context) {
        super(context);
        this.acG = 0;
        init();
    }

    public void setProgress(int i) {
        this.acG = i;
        invalidate();
    }

    public void init() {
        this.mWidth = getResources().getDimensionPixelSize(d.f.ds100);
        this.acB = getResources().getDimensionPixelSize(d.f.ds4);
        this.acC = getResources().getDimensionPixelSize(d.f.ds2);
        this.acD = new Paint();
        this.acD.setStrokeWidth(this.acB);
        this.acD.setColor(getResources().getColor(d.e.cp_cont_g));
        this.acD.setStyle(Paint.Style.STROKE);
        this.acD.setAntiAlias(true);
        this.acE = new Paint();
        this.acE.setStrokeWidth(this.acC);
        this.acE.setColor(getResources().getColor(d.e.common_color_10042));
        this.acE.setStyle(Paint.Style.STROKE);
        this.acE.setAntiAlias(true);
        this.acF = new RectF(this.acB, this.acB, this.mWidth + this.acB, this.mWidth + this.acB);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.drawArc(this.acF, 0.0f, acz, false, this.acE);
        canvas.drawArc(this.acF, 270.0f, (acz * this.acG) / acA, false, this.acD);
    }
}
