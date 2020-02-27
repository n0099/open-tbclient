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
    private int aBA;
    private int aBB;
    private int aBC;
    private String aBD;
    private boolean aBE;
    private int aBF;
    private int aBG;
    private int aBz;
    private boolean apm;

    public GradientEnableTextView(Context context) {
        this(context, null);
    }

    public GradientEnableTextView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public GradientEnableTextView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.k.sdk_GradientEnableTextView);
        this.aBz = obtainStyledAttributes.getColor(a.k.sdk_GradientEnableTextView_startColorEnable, -1);
        this.aBA = obtainStyledAttributes.getColor(a.k.sdk_GradientEnableTextView_endColorEnable, -1);
        this.aBB = obtainStyledAttributes.getColor(a.k.sdk_GradientEnableTextView_startColorDisableEnable, -1);
        this.aBC = obtainStyledAttributes.getColor(a.k.sdk_GradientEnableTextView_endColorDisableEnable, -1);
        obtainStyledAttributes.recycle();
        this.aBE = true;
    }

    @Override // android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (isClickable()) {
            if (motionEvent.getAction() == 0) {
                this.apm = true;
            } else if (motionEvent.getAction() == 3 || motionEvent.getAction() == 1) {
                this.apm = false;
            }
        } else {
            this.apm = false;
        }
        if (isClickable() && !this.apm) {
            this.aBF = this.aBz;
            this.aBG = this.aBA;
        } else {
            this.aBF = this.aBB;
            this.aBG = this.aBC;
        }
        invalidate();
        return super.onTouchEvent(motionEvent);
    }

    public void setCheckStrEquals(boolean z) {
        this.aBE = z;
    }

    public void setGradientTextColor(int i, int i2) {
        this.aBz = i;
        this.aBA = i2;
        invalidate();
    }

    public void setGradientDisableTextColor(int i, int i2) {
        this.aBB = i;
        this.aBC = i2;
        invalidate();
    }

    @Override // android.view.View
    public void setClickable(boolean z) {
        super.setClickable(z);
        if (z && !this.apm) {
            this.aBF = this.aBz;
            this.aBG = this.aBA;
        } else {
            this.aBF = this.aBB;
            this.aBG = this.aBC;
        }
        invalidate();
    }

    @Override // android.widget.TextView, android.view.View
    @SuppressLint({"DrawAllocation"})
    protected void onDraw(Canvas canvas) {
        String charSequence = getText().toString();
        if (this.aBF == -1 || this.aBG == -1) {
            this.aBF = this.aBz;
            this.aBG = this.aBA;
        }
        if (!TextUtils.isEmpty(charSequence) && this.aBF != -1 && this.aBG != -1 && (!this.aBE || !charSequence.equals(this.aBD))) {
            this.aBD = charSequence;
            float measureText = getPaint().measureText(charSequence);
            float width = (getWidth() - measureText) / 2.0f;
            getPaint().setShader(new LinearGradient(width, 0.0f, width + measureText, 0.0f, this.aBF, this.aBG, Shader.TileMode.CLAMP));
        }
        super.onDraw(canvas);
    }
}
