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
    private int bLu;
    private Paint eWC;
    private RectF eWE;
    private int mValue;
    private int mWidth;
    private static int eWz = EncoderTextureDrawer.X264_WIDTH;
    private static int eWA = 100;

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
        this.bLu = getResources().getDimensionPixelSize(R.dimen.tbds6);
        this.eWC = new Paint();
        this.eWC.setStrokeWidth(this.bLu);
        this.eWC.setColor(getResources().getColor(R.color.CAM_X0111));
        this.eWC.setStyle(Paint.Style.STROKE);
        this.eWC.setAntiAlias(true);
        this.eWC.setStrokeCap(Paint.Cap.ROUND);
        this.eWE = new RectF(this.bLu / 2, this.bLu / 2, this.mWidth + (this.bLu / 2), this.mWidth + (this.bLu / 2));
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.drawArc(this.eWE, 270.0f, (eWz * this.mValue) / eWA, false, this.eWC);
    }
}
