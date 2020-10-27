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
    private static int eCp = EncoderTextureDrawer.X264_WIDTH;
    private static int eCq = 100;
    private int bwz;
    private Paint eCs;
    private RectF eCu;
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
        this.bwz = getResources().getDimensionPixelSize(R.dimen.tbds6);
        this.eCs = new Paint();
        this.eCs.setStrokeWidth(this.bwz);
        this.eCs.setColor(getResources().getColor(R.color.cp_cont_g));
        this.eCs.setStyle(Paint.Style.STROKE);
        this.eCs.setAntiAlias(true);
        this.eCs.setStrokeCap(Paint.Cap.ROUND);
        this.eCu = new RectF(this.bwz / 2, this.bwz / 2, this.mWidth + (this.bwz / 2), this.mWidth + (this.bwz / 2));
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.drawArc(this.eCu, 270.0f, (eCp * this.mValue) / eCq, false, this.eCs);
    }
}
