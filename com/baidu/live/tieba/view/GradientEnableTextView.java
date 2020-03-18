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
import android.view.MotionEvent;
import android.widget.TextView;
import com.baidu.live.u.a;
/* loaded from: classes3.dex */
public class GradientEnableTextView extends TextView {
    private int aBP;
    private int aBQ;
    private int aBR;
    private int aBS;
    private String aBT;
    private boolean aBU;
    private int aBV;
    private int aBW;
    private boolean apy;

    public GradientEnableTextView(Context context) {
        this(context, null);
    }

    public GradientEnableTextView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public GradientEnableTextView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.k.sdk_GradientEnableTextView);
        this.aBP = obtainStyledAttributes.getColor(a.k.sdk_GradientEnableTextView_startColorEnable, -1);
        this.aBQ = obtainStyledAttributes.getColor(a.k.sdk_GradientEnableTextView_endColorEnable, -1);
        this.aBR = obtainStyledAttributes.getColor(a.k.sdk_GradientEnableTextView_startColorDisableEnable, -1);
        this.aBS = obtainStyledAttributes.getColor(a.k.sdk_GradientEnableTextView_endColorDisableEnable, -1);
        obtainStyledAttributes.recycle();
        this.aBU = true;
    }

    @Override // android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (isClickable()) {
            if (motionEvent.getAction() == 0) {
                this.apy = true;
            } else if (motionEvent.getAction() == 3 || motionEvent.getAction() == 1) {
                this.apy = false;
            }
        } else {
            this.apy = false;
        }
        if (isClickable() && !this.apy) {
            this.aBV = this.aBP;
            this.aBW = this.aBQ;
        } else {
            this.aBV = this.aBR;
            this.aBW = this.aBS;
        }
        invalidate();
        return super.onTouchEvent(motionEvent);
    }

    public void setCheckStrEquals(boolean z) {
        this.aBU = z;
    }

    public void setGradientTextColor(int i, int i2) {
        this.aBP = i;
        this.aBQ = i2;
        invalidate();
    }

    public void setGradientDisableTextColor(int i, int i2) {
        this.aBR = i;
        this.aBS = i2;
        invalidate();
    }

    @Override // android.view.View
    public void setClickable(boolean z) {
        super.setClickable(z);
        if (z && !this.apy) {
            this.aBV = this.aBP;
            this.aBW = this.aBQ;
        } else {
            this.aBV = this.aBR;
            this.aBW = this.aBS;
        }
        invalidate();
    }

    @Override // android.widget.TextView, android.view.View
    @SuppressLint({"DrawAllocation"})
    protected void onDraw(Canvas canvas) {
        String charSequence = getText().toString();
        if (this.aBV == -1 || this.aBW == -1) {
            this.aBV = this.aBP;
            this.aBW = this.aBQ;
        }
        if (!TextUtils.isEmpty(charSequence) && this.aBV != -1 && this.aBW != -1 && (!this.aBU || !charSequence.equals(this.aBT))) {
            this.aBT = charSequence;
            float measureText = getPaint().measureText(charSequence);
            float width = (getWidth() - measureText) / 2.0f;
            getPaint().setShader(new LinearGradient(width, 0.0f, width + measureText, 0.0f, this.aBV, this.aBW, Shader.TileMode.CLAMP));
        }
        super.onDraw(canvas);
    }
}
