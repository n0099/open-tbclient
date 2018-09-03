package com.baidu.tbadk.core.dialog;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.tieba.f;
/* loaded from: classes.dex */
public class CircleView1080 extends View {
    private static int alk = 360;
    private static int alm = 100;
    private int aln;
    private Paint alp;
    private RectF alr;
    private int mValue;
    private int mWidth;

    public CircleView1080(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mValue = 0;
        init();
    }

    public CircleView1080(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mValue = 0;
        init();
    }

    public CircleView1080(Context context) {
        super(context);
        this.mValue = 0;
        init();
    }

    public void setProgress(int i) {
        this.mValue = i;
        invalidate();
    }

    public void init() {
        this.mWidth = getResources().getDimensionPixelSize(f.e.tbds122);
        this.aln = getResources().getDimensionPixelSize(f.e.tbds6);
        this.alp = new Paint();
        this.alp.setStrokeWidth(this.aln);
        this.alp.setColor(getResources().getColor(f.d.cp_cont_g));
        this.alp.setStyle(Paint.Style.STROKE);
        this.alp.setAntiAlias(true);
        this.alp.setStrokeCap(Paint.Cap.ROUND);
        this.alr = new RectF(this.aln / 2, this.aln / 2, this.mWidth + (this.aln / 2), this.mWidth + (this.aln / 2));
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.drawArc(this.alr, 270.0f, (alk * this.mValue) / alm, false, this.alp);
    }
}
