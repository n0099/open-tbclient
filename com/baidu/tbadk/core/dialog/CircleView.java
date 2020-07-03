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
    private static int dPx = 360;
    private static int dPy = 100;
    private int bhG;
    private Paint dPA;
    private Paint dPB;
    private RectF dPC;
    private int dPz;
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
        this.bhG = getResources().getDimensionPixelSize(R.dimen.ds4);
        this.dPz = getResources().getDimensionPixelSize(R.dimen.ds2);
        this.dPA = new Paint();
        this.dPA.setStrokeWidth(this.bhG);
        this.dPA.setColor(getResources().getColor(R.color.cp_cont_g));
        this.dPA.setStyle(Paint.Style.STROKE);
        this.dPA.setAntiAlias(true);
        this.dPB = new Paint();
        this.dPB.setStrokeWidth(this.dPz);
        this.dPB.setColor(getResources().getColor(R.color.common_color_10042));
        this.dPB.setStyle(Paint.Style.STROKE);
        this.dPB.setAntiAlias(true);
        this.dPC = new RectF(this.bhG, this.bhG, this.mWidth + this.bhG, this.mWidth + this.bhG);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.drawArc(this.dPC, 0.0f, dPx, false, this.dPB);
        canvas.drawArc(this.dPC, 270.0f, (dPx * this.mValue) / dPy, false, this.dPA);
    }
}
