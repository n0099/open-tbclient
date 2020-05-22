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
    private int bcP;
    private int bcQ;
    private String bcT;
    private boolean bcU;

    public GradientTextView(Context context) {
        this(context, null);
    }

    public GradientTextView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public GradientTextView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.k.sdk_GradientTextView);
        this.bcP = obtainStyledAttributes.getColor(a.k.sdk_GradientTextView_startColor, -1);
        this.bcQ = obtainStyledAttributes.getColor(a.k.sdk_GradientTextView_endColor, -1);
        obtainStyledAttributes.recycle();
        this.bcU = true;
    }

    public void setCheckStrEquals(boolean z) {
        this.bcU = z;
    }

    public void setGradientTextColor(int i, int i2) {
        this.bcP = i;
        this.bcQ = i2;
        invalidate();
    }

    @Override // android.widget.TextView, android.view.View
    @SuppressLint({"DrawAllocation"})
    protected void onDraw(Canvas canvas) {
        String charSequence = getText().toString();
        if (!TextUtils.isEmpty(charSequence) && ((this.bcP != 0 || this.bcQ != 0) && (!this.bcU || !charSequence.equals(this.bcT)))) {
            this.bcT = charSequence;
            float measureText = getPaint().measureText(charSequence);
            float width = (getWidth() - measureText) / 2.0f;
            getPaint().setShader(new LinearGradient(width, 0.0f, width + measureText, 0.0f, this.bcP, this.bcQ, Shader.TileMode.CLAMP));
        }
        super.onDraw(canvas);
    }
}
