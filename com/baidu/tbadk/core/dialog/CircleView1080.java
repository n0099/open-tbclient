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
    private int bGh;
    private Paint eNC;
    private RectF eNE;
    private int mValue;
    private int mWidth;
    private static int eNz = EncoderTextureDrawer.X264_WIDTH;
    private static int eNA = 100;

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
        this.bGh = getResources().getDimensionPixelSize(R.dimen.tbds6);
        this.eNC = new Paint();
        this.eNC.setStrokeWidth(this.bGh);
        this.eNC.setColor(getResources().getColor(R.color.CAM_X0111));
        this.eNC.setStyle(Paint.Style.STROKE);
        this.eNC.setAntiAlias(true);
        this.eNC.setStrokeCap(Paint.Cap.ROUND);
        this.eNE = new RectF(this.bGh / 2, this.bGh / 2, this.mWidth + (this.bGh / 2), this.mWidth + (this.bGh / 2));
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.drawArc(this.eNE, 270.0f, (eNz * this.mValue) / eNA, false, this.eNC);
    }
}
