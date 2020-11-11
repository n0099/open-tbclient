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
    private static int eIe = EncoderTextureDrawer.X264_WIDTH;
    private static int eIf = 100;
    private int bCK;
    private Paint eIh;
    private RectF eIj;
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
        this.bCK = getResources().getDimensionPixelSize(R.dimen.tbds6);
        this.eIh = new Paint();
        this.eIh.setStrokeWidth(this.bCK);
        this.eIh.setColor(getResources().getColor(R.color.cp_cont_g));
        this.eIh.setStyle(Paint.Style.STROKE);
        this.eIh.setAntiAlias(true);
        this.eIh.setStrokeCap(Paint.Cap.ROUND);
        this.eIj = new RectF(this.bCK / 2, this.bCK / 2, this.mWidth + (this.bCK / 2), this.mWidth + (this.bCK / 2));
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.drawArc(this.eIj, 270.0f, (eIe * this.mValue) / eIf, false, this.eIh);
    }
}
