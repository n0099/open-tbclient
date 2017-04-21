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
    private static int abg = 360;
    private static int abh = 100;
    private int abi;
    private int abj;
    private Paint abk;
    private Paint abl;
    private RectF abm;
    private int abn;
    private int mWidth;

    public CircleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.abn = 0;
        init();
    }

    public CircleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.abn = 0;
        init();
    }

    public CircleView(Context context) {
        super(context);
        this.abn = 0;
        init();
    }

    public void setProgress(int i) {
        this.abn = i;
        invalidate();
    }

    public void init() {
        this.mWidth = getResources().getDimensionPixelSize(w.f.ds100);
        this.abi = getResources().getDimensionPixelSize(w.f.ds4);
        this.abj = getResources().getDimensionPixelSize(w.f.ds2);
        this.abk = new Paint();
        this.abk.setStrokeWidth(this.abi);
        this.abk.setColor(getResources().getColor(w.e.cp_cont_g));
        this.abk.setStyle(Paint.Style.STROKE);
        this.abk.setAntiAlias(true);
        this.abl = new Paint();
        this.abl.setStrokeWidth(this.abj);
        this.abl.setColor(getResources().getColor(w.e.common_color_10042));
        this.abl.setStyle(Paint.Style.STROKE);
        this.abl.setAntiAlias(true);
        this.abm = new RectF(this.abi, this.abi, this.mWidth + this.abi, this.mWidth + this.abi);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.drawArc(this.abm, 0.0f, abg, false, this.abl);
        canvas.drawArc(this.abm, 270.0f, (abg * this.abn) / abh, false, this.abk);
    }
}
