package com.baidu.tbadk.core.dialog;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class CircleView extends View {
    private static int VD = 360;
    private static int VE = 100;
    private int VF;
    private int VG;
    private Paint VH;
    private Paint VI;
    private RectF VJ;
    private int VK;
    private int mWidth;

    public CircleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.VK = 0;
        init();
    }

    public CircleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.VK = 0;
        init();
    }

    public CircleView(Context context) {
        super(context);
        this.VK = 0;
        init();
    }

    public void setProgress(int i) {
        this.VK = i;
        invalidate();
    }

    public void init() {
        this.mWidth = getResources().getDimensionPixelSize(r.f.ds100);
        this.VF = getResources().getDimensionPixelSize(r.f.ds4);
        this.VG = getResources().getDimensionPixelSize(r.f.ds2);
        this.VH = new Paint();
        this.VH.setStrokeWidth(this.VF);
        this.VH.setColor(getResources().getColor(r.e.cp_cont_g));
        this.VH.setStyle(Paint.Style.STROKE);
        this.VH.setAntiAlias(true);
        this.VI = new Paint();
        this.VI.setStrokeWidth(this.VG);
        this.VI.setColor(getResources().getColor(r.e.common_color_10042));
        this.VI.setStyle(Paint.Style.STROKE);
        this.VI.setAntiAlias(true);
        this.VJ = new RectF(this.VF, this.VF, this.mWidth + this.VF, this.mWidth + this.VF);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.drawArc(this.VJ, 0.0f, VD, false, this.VI);
        canvas.drawArc(this.VJ, 270.0f, (VD * this.VK) / VE, false, this.VH);
    }
}
