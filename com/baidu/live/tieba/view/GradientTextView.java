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
import com.baidu.live.sdk.a;
/* loaded from: classes7.dex */
public class GradientTextView extends TextView {
    private int bob;
    private int boc;
    private String bof;
    private boolean bog;

    public GradientTextView(Context context) {
        this(context, null);
    }

    public GradientTextView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public GradientTextView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.k.sdk_GradientTextView);
        this.bob = obtainStyledAttributes.getColor(a.k.sdk_GradientTextView_startColor, -1);
        this.boc = obtainStyledAttributes.getColor(a.k.sdk_GradientTextView_endColor, -1);
        obtainStyledAttributes.recycle();
        this.bog = true;
    }

    public void setCheckStrEquals(boolean z) {
        this.bog = z;
    }

    public void setGradientTextColor(int i, int i2) {
        this.bob = i;
        this.boc = i2;
        invalidate();
    }

    @Override // android.widget.TextView, android.view.View
    @SuppressLint({"DrawAllocation"})
    protected void onDraw(Canvas canvas) {
        String charSequence = getText().toString();
        if (!TextUtils.isEmpty(charSequence) && ((this.bob != 0 || this.boc != 0) && (!this.bog || !charSequence.equals(this.bof)))) {
            this.bof = charSequence;
            float measureText = getPaint().measureText(charSequence);
            float width = (getWidth() - measureText) / 2.0f;
            getPaint().setShader(new LinearGradient(width, 0.0f, width + measureText, 0.0f, this.bob, this.boc, Shader.TileMode.CLAMP));
        }
        super.onDraw(canvas);
    }
}
