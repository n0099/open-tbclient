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
    private static int aba = 360;
    private static int abb = 100;
    private int abc;
    private int abd;
    private Paint abe;
    private Paint abf;
    private RectF abg;
    private int abh;
    private int mWidth;

    public CircleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.abh = 0;
        init();
    }

    public CircleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.abh = 0;
        init();
    }

    public CircleView(Context context) {
        super(context);
        this.abh = 0;
        init();
    }

    public void setProgress(int i) {
        this.abh = i;
        invalidate();
    }

    public void init() {
        this.mWidth = getResources().getDimensionPixelSize(d.f.ds100);
        this.abc = getResources().getDimensionPixelSize(d.f.ds4);
        this.abd = getResources().getDimensionPixelSize(d.f.ds2);
        this.abe = new Paint();
        this.abe.setStrokeWidth(this.abc);
        this.abe.setColor(getResources().getColor(d.e.cp_cont_g));
        this.abe.setStyle(Paint.Style.STROKE);
        this.abe.setAntiAlias(true);
        this.abf = new Paint();
        this.abf.setStrokeWidth(this.abd);
        this.abf.setColor(getResources().getColor(d.e.common_color_10042));
        this.abf.setStyle(Paint.Style.STROKE);
        this.abf.setAntiAlias(true);
        this.abg = new RectF(this.abc, this.abc, this.mWidth + this.abc, this.mWidth + this.abc);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.drawArc(this.abg, 0.0f, aba, false, this.abf);
        canvas.drawArc(this.abg, 270.0f, (aba * this.abh) / abb, false, this.abe);
    }
}
