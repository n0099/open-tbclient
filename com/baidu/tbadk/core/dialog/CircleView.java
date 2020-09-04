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
public class CircleView extends View {
    private static int eft = EncoderTextureDrawer.X264_WIDTH;
    private static int efu = 100;
    private int bnK;
    private int efv;
    private Paint efw;
    private Paint efx;
    private RectF efy;
    private int mValue;
    private int mWidth;

    public CircleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mValue = 0;
        init();
    }

    public CircleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mValue = 0;
        init();
    }

    public CircleView(Context context) {
        super(context);
        this.mValue = 0;
        init();
    }

    public void setProgress(int i) {
        this.mValue = i;
        invalidate();
    }

    public void init() {
        this.mWidth = getResources().getDimensionPixelSize(R.dimen.ds100);
        this.bnK = getResources().getDimensionPixelSize(R.dimen.ds4);
        this.efv = getResources().getDimensionPixelSize(R.dimen.ds2);
        this.efw = new Paint();
        this.efw.setStrokeWidth(this.bnK);
        this.efw.setColor(getResources().getColor(R.color.cp_cont_g));
        this.efw.setStyle(Paint.Style.STROKE);
        this.efw.setAntiAlias(true);
        this.efx = new Paint();
        this.efx.setStrokeWidth(this.efv);
        this.efx.setColor(getResources().getColor(R.color.common_color_10042));
        this.efx.setStyle(Paint.Style.STROKE);
        this.efx.setAntiAlias(true);
        this.efy = new RectF(this.bnK, this.bnK, this.mWidth + this.bnK, this.mWidth + this.bnK);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.drawArc(this.efy, 0.0f, eft, false, this.efx);
        canvas.drawArc(this.efy, 270.0f, (eft * this.mValue) / efu, false, this.efw);
    }
}
