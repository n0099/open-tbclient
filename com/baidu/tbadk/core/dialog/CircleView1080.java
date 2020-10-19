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
    private static int etQ = EncoderTextureDrawer.X264_WIDTH;
    private static int etR = 100;
    private int but;
    private Paint etT;
    private RectF etV;
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
        this.but = getResources().getDimensionPixelSize(R.dimen.tbds6);
        this.etT = new Paint();
        this.etT.setStrokeWidth(this.but);
        this.etT.setColor(getResources().getColor(R.color.cp_cont_g));
        this.etT.setStyle(Paint.Style.STROKE);
        this.etT.setAntiAlias(true);
        this.etT.setStrokeCap(Paint.Cap.ROUND);
        this.etV = new RectF(this.but / 2, this.but / 2, this.mWidth + (this.but / 2), this.mWidth + (this.but / 2));
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.drawArc(this.etV, 270.0f, (etQ * this.mValue) / etR, false, this.etT);
    }
}
