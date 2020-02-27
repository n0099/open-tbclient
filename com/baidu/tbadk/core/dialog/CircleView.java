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
    private static int cVi = 360;
    private static int cVj = 100;
    private int aBg;
    private int cVk;
    private Paint cVl;
    private Paint cVm;
    private RectF cVn;
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
        this.aBg = getResources().getDimensionPixelSize(R.dimen.ds4);
        this.cVk = getResources().getDimensionPixelSize(R.dimen.ds2);
        this.cVl = new Paint();
        this.cVl.setStrokeWidth(this.aBg);
        this.cVl.setColor(getResources().getColor(R.color.cp_cont_g));
        this.cVl.setStyle(Paint.Style.STROKE);
        this.cVl.setAntiAlias(true);
        this.cVm = new Paint();
        this.cVm.setStrokeWidth(this.cVk);
        this.cVm.setColor(getResources().getColor(R.color.common_color_10042));
        this.cVm.setStyle(Paint.Style.STROKE);
        this.cVm.setAntiAlias(true);
        this.cVn = new RectF(this.aBg, this.aBg, this.mWidth + this.aBg, this.mWidth + this.aBg);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.drawArc(this.cVn, 0.0f, cVi, false, this.cVm);
        canvas.drawArc(this.cVn, 270.0f, (cVi * this.mValue) / cVj, false, this.cVl);
    }
}
