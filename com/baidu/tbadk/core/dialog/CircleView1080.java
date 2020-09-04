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
    private static int eft = EncoderTextureDrawer.X264_WIDTH;
    private static int efu = 100;
    private int bnK;
    private Paint efw;
    private RectF efy;
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
        this.bnK = getResources().getDimensionPixelSize(R.dimen.tbds6);
        this.efw = new Paint();
        this.efw.setStrokeWidth(this.bnK);
        this.efw.setColor(getResources().getColor(R.color.cp_cont_g));
        this.efw.setStyle(Paint.Style.STROKE);
        this.efw.setAntiAlias(true);
        this.efw.setStrokeCap(Paint.Cap.ROUND);
        this.efy = new RectF(this.bnK / 2, this.bnK / 2, this.mWidth + (this.bnK / 2), this.mWidth + (this.bnK / 2));
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.drawArc(this.efy, 270.0f, (eft * this.mValue) / efu, false, this.efw);
    }
}
