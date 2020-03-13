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
import com.baidu.live.u.a;
/* loaded from: classes3.dex */
public class GradientTextView extends TextView {
    private int aBB;
    private int aBC;
    private String aBF;
    private boolean aBG;

    public GradientTextView(Context context) {
        this(context, null);
    }

    public GradientTextView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public GradientTextView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.k.sdk_GradientTextView);
        this.aBB = obtainStyledAttributes.getColor(a.k.sdk_GradientTextView_startColor, -1);
        this.aBC = obtainStyledAttributes.getColor(a.k.sdk_GradientTextView_endColor, -1);
        obtainStyledAttributes.recycle();
        this.aBG = true;
    }

    public void setCheckStrEquals(boolean z) {
        this.aBG = z;
    }

    public void setGradientTextColor(int i, int i2) {
        this.aBB = i;
        this.aBC = i2;
        invalidate();
    }

    @Override // android.widget.TextView, android.view.View
    @SuppressLint({"DrawAllocation"})
    protected void onDraw(Canvas canvas) {
        String charSequence = getText().toString();
        if (!TextUtils.isEmpty(charSequence) && this.aBB != -1 && this.aBC != -1 && (!this.aBG || !charSequence.equals(this.aBF))) {
            this.aBF = charSequence;
            float measureText = getPaint().measureText(charSequence);
            float width = (getWidth() - measureText) / 2.0f;
            getPaint().setShader(new LinearGradient(width, 0.0f, width + measureText, 0.0f, this.aBB, this.aBC, Shader.TileMode.CLAMP));
        }
        super.onDraw(canvas);
    }
}
