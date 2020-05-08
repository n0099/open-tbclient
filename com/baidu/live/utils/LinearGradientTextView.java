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
/* loaded from: classes3.dex */
public class LinearGradientTextView extends TextView {
    private LinearGradient aVP;
    private Rect aXT;
    private int aXU;
    private int aXV;
    private Paint mPaint;
    private int mViewWidth;

    public LinearGradientTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mViewWidth = 0;
        this.aXT = new Rect();
    }

    @Override // android.widget.TextView
    public void setTextColor(int i) {
        this.aXU = i;
        this.aXV = i;
        super.setTextColor(i);
    }

    public void setGradientColor(int i, int i2) {
        this.aXU = i;
        this.aXV = i2;
        invalidate();
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        this.mViewWidth = getMeasuredWidth();
        this.mPaint = getPaint();
        String charSequence = getText().toString();
        this.mPaint.getTextBounds(charSequence, 0, charSequence.length(), this.aXT);
        this.aVP = new LinearGradient(0.0f, 0.0f, this.mViewWidth, 0.0f, new int[]{this.aXU, this.aXV}, (float[]) null, Shader.TileMode.REPEAT);
        this.mPaint.setShader(this.aVP);
        canvas.drawText(charSequence, (getMeasuredWidth() / 2) - (this.aXT.width() / 2), ((getMeasuredHeight() / 2) + (this.aXT.height() / 2)) - BdUtilHelper.dip2px(getContext(), 1.0f), this.mPaint);
    }
}
