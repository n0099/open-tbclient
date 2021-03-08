package com.baidu.live.tieba.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.baidu.live.sdk.a;
/* loaded from: classes10.dex */
public class GradientTextView extends TextView {
    private int bMk;
    private int bMl;
    private String bMo;
    private boolean bMp;

    public GradientTextView(Context context) {
        this(context, null);
    }

    public GradientTextView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public GradientTextView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.j.sdk_GradientTextView);
        this.bMk = obtainStyledAttributes.getColor(a.j.sdk_GradientTextView_startColor, -1);
        this.bMl = obtainStyledAttributes.getColor(a.j.sdk_GradientTextView_endColor, -1);
        obtainStyledAttributes.recycle();
        this.bMp = true;
    }

    public void setCheckStrEquals(boolean z) {
        this.bMp = z;
    }

    public void setGradientTextColor(int i, int i2) {
        this.bMk = i;
        this.bMl = i2;
        invalidate();
    }

    @Override // android.widget.TextView, android.view.View
    @SuppressLint({"DrawAllocation"})
    protected void onDraw(Canvas canvas) {
        String charSequence = getText().toString();
        if (!TextUtils.isEmpty(charSequence) && ((this.bMk != 0 || this.bMl != 0) && (!this.bMp || !charSequence.equals(this.bMo)))) {
            this.bMo = charSequence;
            float measureText = getPaint().measureText(charSequence);
            float width = (getWidth() - measureText) / 2.0f;
            getPaint().setShader(new LinearGradient(width, 0.0f, width + measureText, 0.0f, this.bMk, this.bMl, Shader.TileMode.CLAMP));
        }
        super.onDraw(canvas);
    }
}
