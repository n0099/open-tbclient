package com.baidu.live.tieba.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.TextView;
import com.baidu.live.q.a;
/* loaded from: classes2.dex */
public class GradientTextView extends TextView {
    private String awB;
    private boolean awC;
    private int awx;
    private int awy;

    public GradientTextView(Context context) {
        this(context, null);
    }

    public GradientTextView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public GradientTextView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.k.sdk_GradientTextView);
        this.awx = obtainStyledAttributes.getColor(a.k.sdk_GradientTextView_startColor, -1);
        this.awy = obtainStyledAttributes.getColor(a.k.sdk_GradientTextView_endColor, -1);
        obtainStyledAttributes.recycle();
        this.awC = true;
    }

    public void setCheckStrEquals(boolean z) {
        this.awC = z;
    }

    public void setGradientTextColor(int i, int i2) {
        this.awx = i;
        this.awy = i2;
        invalidate();
    }

    @Override // android.widget.TextView, android.view.View
    @SuppressLint({"DrawAllocation"})
    protected void onDraw(Canvas canvas) {
        String charSequence = getText().toString();
        if (!TextUtils.isEmpty(charSequence) && this.awx != -1 && this.awy != -1 && (!this.awC || !charSequence.equals(this.awB))) {
            this.awB = charSequence;
            float measureText = getPaint().measureText(charSequence);
            float width = (getWidth() - measureText) / 2.0f;
            getPaint().setShader(new LinearGradient(width, 0.0f, width + measureText, 0.0f, this.awx, this.awy, Shader.TileMode.CLAMP));
        }
        super.onDraw(canvas);
    }
}
