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
    private static int eSL = EncoderTextureDrawer.X264_WIDTH;
    private static int eSM = 100;
    private int bGk;
    private Paint eSO;
    private RectF eSQ;
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
        this.bGk = getResources().getDimensionPixelSize(R.dimen.tbds6);
        this.eSO = new Paint();
        this.eSO.setStrokeWidth(this.bGk);
        this.eSO.setColor(getResources().getColor(R.color.CAM_X0111));
        this.eSO.setStyle(Paint.Style.STROKE);
        this.eSO.setAntiAlias(true);
        this.eSO.setStrokeCap(Paint.Cap.ROUND);
        this.eSQ = new RectF(this.bGk / 2, this.bGk / 2, this.mWidth + (this.bGk / 2), this.mWidth + (this.bGk / 2));
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.drawArc(this.eSQ, 270.0f, (eSL * this.mValue) / eSM, false, this.eSO);
    }
}
