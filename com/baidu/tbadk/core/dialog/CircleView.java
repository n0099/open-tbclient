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
    private static int eXw = EncoderTextureDrawer.X264_WIDTH;
    private static int eXx = 100;
    private int bKW;
    private Paint eXA;
    private RectF eXB;
    private int eXy;
    private Paint eXz;
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
        this.bKW = getResources().getDimensionPixelSize(R.dimen.ds4);
        this.eXy = getResources().getDimensionPixelSize(R.dimen.ds2);
        this.eXz = new Paint();
        this.eXz.setStrokeWidth(this.bKW);
        this.eXz.setColor(getResources().getColor(R.color.CAM_X0111));
        this.eXz.setStyle(Paint.Style.STROKE);
        this.eXz.setAntiAlias(true);
        this.eXA = new Paint();
        this.eXA.setStrokeWidth(this.eXy);
        this.eXA.setColor(getResources().getColor(R.color.common_color_10042));
        this.eXA.setStyle(Paint.Style.STROKE);
        this.eXA.setAntiAlias(true);
        this.eXB = new RectF(this.bKW, this.bKW, this.mWidth + this.bKW, this.mWidth + this.bKW);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.drawArc(this.eXB, 0.0f, eXw, false, this.eXA);
        canvas.drawArc(this.eXB, 270.0f, (eXw * this.mValue) / eXx, false, this.eXz);
    }
}
