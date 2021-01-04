package com.baidu.live.utils;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.widget.TextView;
import com.baidu.live.adp.lib.util.BdUtilHelper;
/* loaded from: classes11.dex */
public class LinearGradientTextView extends TextView {
    private LinearGradient bLY;
    private Rect bOU;
    private int bOV;
    private int bOW;
    private Paint mPaint;
    private int mViewWidth;

    public LinearGradientTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mViewWidth = 0;
        this.bOU = new Rect();
    }

    @Override // android.widget.TextView
    public void setTextColor(int i) {
        this.bOV = i;
        this.bOW = i;
        super.setTextColor(i);
    }

    public void setGradientColor(int i, int i2) {
        this.bOV = i;
        this.bOW = i2;
        invalidate();
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        this.mViewWidth = getMeasuredWidth();
        this.mPaint = getPaint();
        String charSequence = getText().toString();
        this.mPaint.getTextBounds(charSequence, 0, charSequence.length(), this.bOU);
        this.bLY = new LinearGradient(0.0f, 0.0f, this.mViewWidth, 0.0f, new int[]{this.bOV, this.bOW}, (float[]) null, Shader.TileMode.REPEAT);
        this.mPaint.setShader(this.bLY);
        canvas.drawText(charSequence, (getMeasuredWidth() / 2) - (this.bOU.width() / 2), ((getMeasuredHeight() / 2) + (this.bOU.height() / 2)) - BdUtilHelper.dip2px(getContext(), 1.0f), this.mPaint);
    }
}
