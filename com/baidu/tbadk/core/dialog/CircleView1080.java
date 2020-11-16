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
    private static int eGw = EncoderTextureDrawer.X264_WIDTH;
    private static int eGx = 100;
    private int bAZ;
    private RectF eGB;
    private Paint eGz;
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
        this.bAZ = getResources().getDimensionPixelSize(R.dimen.tbds6);
        this.eGz = new Paint();
        this.eGz.setStrokeWidth(this.bAZ);
        this.eGz.setColor(getResources().getColor(R.color.CAM_X0111));
        this.eGz.setStyle(Paint.Style.STROKE);
        this.eGz.setAntiAlias(true);
        this.eGz.setStrokeCap(Paint.Cap.ROUND);
        this.eGB = new RectF(this.bAZ / 2, this.bAZ / 2, this.mWidth + (this.bAZ / 2), this.mWidth + (this.bAZ / 2));
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.drawArc(this.eGB, 270.0f, (eGw * this.mValue) / eGx, false, this.eGz);
    }
}
