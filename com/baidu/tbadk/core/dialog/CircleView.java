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
    private static int abG = 360;
    private static int abH = 100;
    private int abI;
    private int abJ;
    private Paint abK;
    private Paint abL;
    private RectF abM;
    private int abN;
    private int mWidth;

    public CircleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.abN = 0;
        init();
    }

    public CircleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.abN = 0;
        init();
    }

    public CircleView(Context context) {
        super(context);
        this.abN = 0;
        init();
    }

    public void setProgress(int i) {
        this.abN = i;
        invalidate();
    }

    public void init() {
        this.mWidth = getResources().getDimensionPixelSize(d.f.ds100);
        this.abI = getResources().getDimensionPixelSize(d.f.ds4);
        this.abJ = getResources().getDimensionPixelSize(d.f.ds2);
        this.abK = new Paint();
        this.abK.setStrokeWidth(this.abI);
        this.abK.setColor(getResources().getColor(d.e.cp_cont_g));
        this.abK.setStyle(Paint.Style.STROKE);
        this.abK.setAntiAlias(true);
        this.abL = new Paint();
        this.abL.setStrokeWidth(this.abJ);
        this.abL.setColor(getResources().getColor(d.e.common_color_10042));
        this.abL.setStyle(Paint.Style.STROKE);
        this.abL.setAntiAlias(true);
        this.abM = new RectF(this.abI, this.abI, this.mWidth + this.abI, this.mWidth + this.abI);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.drawArc(this.abM, 0.0f, abG, false, this.abL);
        canvas.drawArc(this.abM, 270.0f, (abG * this.abN) / abH, false, this.abK);
    }
}
