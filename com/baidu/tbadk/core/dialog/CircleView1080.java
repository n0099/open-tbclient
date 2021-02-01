package com.baidu.tbadk.core.dialog;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.ala.recorder.video.drawer.EncoderTextureDrawer;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class CircleView1080 extends View {
    private static int eVa = EncoderTextureDrawer.X264_WIDTH;
    private static int eVb = 100;
    private int bJU;
    private Paint eVd;
    private RectF eVf;
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
        this.mWidth = getResources().getDimensionPixelSize(R.dimen.tbds122);
        this.bJU = getResources().getDimensionPixelSize(R.dimen.tbds6);
        this.eVd = new Paint();
        this.eVd.setStrokeWidth(this.bJU);
        this.eVd.setColor(getResources().getColor(R.color.CAM_X0111));
        this.eVd.setStyle(Paint.Style.STROKE);
        this.eVd.setAntiAlias(true);
        this.eVd.setStrokeCap(Paint.Cap.ROUND);
        this.eVf = new RectF(this.bJU / 2, this.bJU / 2, this.mWidth + (this.bJU / 2), this.mWidth + (this.bJU / 2));
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.drawArc(this.eVf, 270.0f, (eVa * this.mValue) / eVb, false, this.eVd);
    }
}
