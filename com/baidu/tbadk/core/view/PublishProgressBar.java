package com.baidu.tbadk.core.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
class PublishProgressBar extends View {
    private Rect fgk;
    private Paint mPaint;
    private int mProgress;

    public PublishProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mProgress = 0;
        init(context, attributeSet);
    }

    public PublishProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mProgress = 0;
        init(context, attributeSet);
    }

    public int pz(int i) {
        if (i < 0) {
            return 0;
        }
        if (i <= 100) {
            if (i == this.mProgress) {
                return this.mProgress;
            }
            this.mProgress = i;
            postInvalidate();
            return this.mProgress;
        }
        return 100;
    }

    public void onChangeSkinType() {
        int color = ao.getColor(R.color.CAM_X0302);
        setBackgroundColor(color);
        getBackground().setAlpha(168);
        this.mPaint.setColor(color);
        this.mPaint.setAlpha(168);
        postInvalidate();
    }

    private void init(Context context, AttributeSet attributeSet) {
        this.mPaint = new Paint(1);
        this.fgk = new Rect();
        onChangeSkinType();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.fgk.set(0, 0, (int) ((this.mProgress / 100.0f) * getWidth()), getHeight());
        canvas.drawRect(this.fgk, this.mPaint);
    }
}
