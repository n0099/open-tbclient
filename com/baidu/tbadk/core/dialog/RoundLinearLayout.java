package com.baidu.tbadk.core.dialog;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.drawable.shapes.RoundRectShape;
import android.graphics.drawable.shapes.Shape;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.baidu.tieba.R;
import java.util.Arrays;
/* loaded from: classes.dex */
public class RoundLinearLayout extends LinearLayout {
    private Shape dWB;
    private int dWC;
    private Paint mPaint;
    private float mRadius;

    public RoundLinearLayout(Context context) {
        this(context, null);
    }

    public RoundLinearLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RoundLinearLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mRadius = 0.0f;
        this.dWC = 4;
        setLayerType(1, null);
        this.mRadius = getResources().getDimension(R.dimen.tbds32);
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.mPaint.setColor(-7829368);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
    }

    public void setRadius(float f) {
        this.mRadius = f;
    }

    public void setRoundCount(int i) {
        this.dWC = i;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            if (this.dWB == null) {
                float[] fArr = new float[8];
                Arrays.fill(fArr, 0.0f);
                RectF rectF = new RectF(getPaddingLeft(), getPaddingTop() > 0 ? getPaddingTop() : 1.0f, getPaddingRight() <= 0 ? 1.0f : getPaddingRight(), getPaddingBottom());
                float[] fArr2 = new float[8];
                Arrays.fill(fArr, 0.0f);
                Arrays.fill(fArr2, 0, this.dWC, this.mRadius);
                this.dWB = new RoundRectShape(fArr, rectF, fArr2);
            }
            this.dWB.resize(getWidth(), getHeight());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        int saveCount = canvas.getSaveCount();
        canvas.save();
        super.dispatchDraw(canvas);
        if (this.dWB != null) {
            this.dWB.draw(canvas, this.mPaint);
        }
        if (saveCount >= 1 && saveCount <= canvas.getSaveCount()) {
            canvas.restoreToCount(saveCount);
        }
    }
}
