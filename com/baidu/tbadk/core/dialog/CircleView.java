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
    private static int abf = 360;
    private static int abg = 100;
    private int abh;
    private int abi;
    private Paint abj;
    private Paint abk;
    private RectF abl;
    private int abm;
    private int mWidth;

    public CircleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.abm = 0;
        init();
    }

    public CircleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.abm = 0;
        init();
    }

    public CircleView(Context context) {
        super(context);
        this.abm = 0;
        init();
    }

    public void setProgress(int i) {
        this.abm = i;
        invalidate();
    }

    public void init() {
        this.mWidth = getResources().getDimensionPixelSize(w.f.ds100);
        this.abh = getResources().getDimensionPixelSize(w.f.ds4);
        this.abi = getResources().getDimensionPixelSize(w.f.ds2);
        this.abj = new Paint();
        this.abj.setStrokeWidth(this.abh);
        this.abj.setColor(getResources().getColor(w.e.cp_cont_g));
        this.abj.setStyle(Paint.Style.STROKE);
        this.abj.setAntiAlias(true);
        this.abk = new Paint();
        this.abk.setStrokeWidth(this.abi);
        this.abk.setColor(getResources().getColor(w.e.common_color_10042));
        this.abk.setStyle(Paint.Style.STROKE);
        this.abk.setAntiAlias(true);
        this.abl = new RectF(this.abh, this.abh, this.mWidth + this.abh, this.mWidth + this.abh);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.drawArc(this.abl, 0.0f, abf, false, this.abk);
        canvas.drawArc(this.abl, 270.0f, (abf * this.abm) / abg, false, this.abj);
    }
}
