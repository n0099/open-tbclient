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
    private static int eSL = EncoderTextureDrawer.X264_WIDTH;
    private static int eSM = 100;
    private int bGk;
    private int eSN;
    private Paint eSO;
    private Paint eSP;
    private RectF eSQ;
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
        this.bGk = getResources().getDimensionPixelSize(R.dimen.ds4);
        this.eSN = getResources().getDimensionPixelSize(R.dimen.ds2);
        this.eSO = new Paint();
        this.eSO.setStrokeWidth(this.bGk);
        this.eSO.setColor(getResources().getColor(R.color.CAM_X0111));
        this.eSO.setStyle(Paint.Style.STROKE);
        this.eSO.setAntiAlias(true);
        this.eSP = new Paint();
        this.eSP.setStrokeWidth(this.eSN);
        this.eSP.setColor(getResources().getColor(R.color.common_color_10042));
        this.eSP.setStyle(Paint.Style.STROKE);
        this.eSP.setAntiAlias(true);
        this.eSQ = new RectF(this.bGk, this.bGk, this.mWidth + this.bGk, this.mWidth + this.bGk);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.drawArc(this.eSQ, 0.0f, eSL, false, this.eSP);
        canvas.drawArc(this.eSQ, 270.0f, (eSL * this.mValue) / eSM, false, this.eSO);
    }
}
