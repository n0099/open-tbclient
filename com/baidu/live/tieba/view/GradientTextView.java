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
    private int bGZ;
    private int bHa;
    private String bHd;
    private boolean bHe;

    public GradientTextView(Context context) {
        this(context, null);
    }

    public GradientTextView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public GradientTextView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.j.sdk_GradientTextView);
        this.bGZ = obtainStyledAttributes.getColor(a.j.sdk_GradientTextView_startColor, -1);
        this.bHa = obtainStyledAttributes.getColor(a.j.sdk_GradientTextView_endColor, -1);
        obtainStyledAttributes.recycle();
        this.bHe = true;
    }

    public void setCheckStrEquals(boolean z) {
        this.bHe = z;
    }

    public void setGradientTextColor(int i, int i2) {
        this.bGZ = i;
        this.bHa = i2;
        invalidate();
    }

    @Override // android.widget.TextView, android.view.View
    @SuppressLint({"DrawAllocation"})
    protected void onDraw(Canvas canvas) {
        String charSequence = getText().toString();
        if (!TextUtils.isEmpty(charSequence) && ((this.bGZ != 0 || this.bHa != 0) && (!this.bHe || !charSequence.equals(this.bHd)))) {
            this.bHd = charSequence;
            float measureText = getPaint().measureText(charSequence);
            float width = (getWidth() - measureText) / 2.0f;
            getPaint().setShader(new LinearGradient(width, 0.0f, width + measureText, 0.0f, this.bGZ, this.bHa, Shader.TileMode.CLAMP));
        }
        super.onDraw(canvas);
    }
}
