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
/* loaded from: classes4.dex */
public class GradientTextView extends TextView {
    private int bDC;
    private int bDD;
    private String bDG;
    private boolean bDH;

    public GradientTextView(Context context) {
        this(context, null);
    }

    public GradientTextView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public GradientTextView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.j.sdk_GradientTextView);
        this.bDC = obtainStyledAttributes.getColor(a.j.sdk_GradientTextView_startColor, -1);
        this.bDD = obtainStyledAttributes.getColor(a.j.sdk_GradientTextView_endColor, -1);
        obtainStyledAttributes.recycle();
        this.bDH = true;
    }

    public void setCheckStrEquals(boolean z) {
        this.bDH = z;
    }

    public void setGradientTextColor(int i, int i2) {
        this.bDC = i;
        this.bDD = i2;
        invalidate();
    }

    @Override // android.widget.TextView, android.view.View
    @SuppressLint({"DrawAllocation"})
    protected void onDraw(Canvas canvas) {
        String charSequence = getText().toString();
        if (!TextUtils.isEmpty(charSequence) && ((this.bDC != 0 || this.bDD != 0) && (!this.bDH || !charSequence.equals(this.bDG)))) {
            this.bDG = charSequence;
            float measureText = getPaint().measureText(charSequence);
            float width = (getWidth() - measureText) / 2.0f;
            getPaint().setShader(new LinearGradient(width, 0.0f, width + measureText, 0.0f, this.bDC, this.bDD, Shader.TileMode.CLAMP));
        }
        super.onDraw(canvas);
    }
}
