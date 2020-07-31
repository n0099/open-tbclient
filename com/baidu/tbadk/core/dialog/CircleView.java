package com.baidu.tbadk.core.dialog;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class CircleView extends View {
    private static int dVP = 360;
    private static int dVQ = 100;
    private int bhZ;
    private int dVR;
    private Paint dVS;
    private Paint dVT;
    private RectF dVU;
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
        this.bhZ = getResources().getDimensionPixelSize(R.dimen.ds4);
        this.dVR = getResources().getDimensionPixelSize(R.dimen.ds2);
        this.dVS = new Paint();
        this.dVS.setStrokeWidth(this.bhZ);
        this.dVS.setColor(getResources().getColor(R.color.cp_cont_g));
        this.dVS.setStyle(Paint.Style.STROKE);
        this.dVS.setAntiAlias(true);
        this.dVT = new Paint();
        this.dVT.setStrokeWidth(this.dVR);
        this.dVT.setColor(getResources().getColor(R.color.common_color_10042));
        this.dVT.setStyle(Paint.Style.STROKE);
        this.dVT.setAntiAlias(true);
        this.dVU = new RectF(this.bhZ, this.bhZ, this.mWidth + this.bhZ, this.mWidth + this.bhZ);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.drawArc(this.dVU, 0.0f, dVP, false, this.dVT);
        canvas.drawArc(this.dVU, 270.0f, (dVP * this.mValue) / dVQ, false, this.dVS);
    }
}
