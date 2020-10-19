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
    private static int etQ = EncoderTextureDrawer.X264_WIDTH;
    private static int etR = 100;
    private int but;
    private int etS;
    private Paint etT;
    private Paint etU;
    private RectF etV;
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
        this.but = getResources().getDimensionPixelSize(R.dimen.ds4);
        this.etS = getResources().getDimensionPixelSize(R.dimen.ds2);
        this.etT = new Paint();
        this.etT.setStrokeWidth(this.but);
        this.etT.setColor(getResources().getColor(R.color.cp_cont_g));
        this.etT.setStyle(Paint.Style.STROKE);
        this.etT.setAntiAlias(true);
        this.etU = new Paint();
        this.etU.setStrokeWidth(this.etS);
        this.etU.setColor(getResources().getColor(R.color.common_color_10042));
        this.etU.setStyle(Paint.Style.STROKE);
        this.etU.setAntiAlias(true);
        this.etV = new RectF(this.but, this.but, this.mWidth + this.but, this.mWidth + this.but);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.drawArc(this.etV, 0.0f, etQ, false, this.etU);
        canvas.drawArc(this.etV, 270.0f, (etQ * this.mValue) / etR, false, this.etT);
    }
}
