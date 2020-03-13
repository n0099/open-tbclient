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
    private static int cVk = 360;
    private static int cVl = 100;
    private int aBi;
    private int cVm;
    private Paint cVn;
    private Paint cVo;
    private RectF cVp;
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
        this.aBi = getResources().getDimensionPixelSize(R.dimen.ds4);
        this.cVm = getResources().getDimensionPixelSize(R.dimen.ds2);
        this.cVn = new Paint();
        this.cVn.setStrokeWidth(this.aBi);
        this.cVn.setColor(getResources().getColor(R.color.cp_cont_g));
        this.cVn.setStyle(Paint.Style.STROKE);
        this.cVn.setAntiAlias(true);
        this.cVo = new Paint();
        this.cVo.setStrokeWidth(this.cVm);
        this.cVo.setColor(getResources().getColor(R.color.common_color_10042));
        this.cVo.setStyle(Paint.Style.STROKE);
        this.cVo.setAntiAlias(true);
        this.cVp = new RectF(this.aBi, this.aBi, this.mWidth + this.aBi, this.mWidth + this.aBi);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.drawArc(this.cVp, 0.0f, cVk, false, this.cVo);
        canvas.drawArc(this.cVp, 270.0f, (cVk * this.mValue) / cVl, false, this.cVn);
    }
}
