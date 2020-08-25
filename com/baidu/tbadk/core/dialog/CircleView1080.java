package com.baidu.tbadk.core.dialog;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.ala.recorder.video.drawer.EncoderTextureDrawer;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class CircleView1080 extends View {
    private static int efp = EncoderTextureDrawer.X264_WIDTH;
    private static int efq = 100;
    private int bnH;
    private Paint efs;
    private RectF efu;
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
        this.bnH = getResources().getDimensionPixelSize(R.dimen.tbds6);
        this.efs = new Paint();
        this.efs.setStrokeWidth(this.bnH);
        this.efs.setColor(getResources().getColor(R.color.cp_cont_g));
        this.efs.setStyle(Paint.Style.STROKE);
        this.efs.setAntiAlias(true);
        this.efs.setStrokeCap(Paint.Cap.ROUND);
        this.efu = new RectF(this.bnH / 2, this.bnH / 2, this.mWidth + (this.bnH / 2), this.mWidth + (this.bnH / 2));
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.drawArc(this.efu, 270.0f, (efp * this.mValue) / efq, false, this.efs);
    }
}
