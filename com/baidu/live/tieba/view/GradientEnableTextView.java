package com.baidu.live.tieba.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.baidu.live.sdk.a;
/* loaded from: classes11.dex */
public class GradientEnableTextView extends TextView {
    private int bLM;
    private int bLN;
    private int bLO;
    private int bLP;
    private String bLQ;
    private boolean bLR;
    private int bLS;
    private int bLT;
    private boolean bjG;

    public GradientEnableTextView(Context context) {
        this(context, null);
    }

    public GradientEnableTextView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public GradientEnableTextView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.j.sdk_GradientEnableTextView);
        this.bLM = obtainStyledAttributes.getColor(a.j.sdk_GradientEnableTextView_startColorEnable, -1);
        this.bLN = obtainStyledAttributes.getColor(a.j.sdk_GradientEnableTextView_endColorEnable, -1);
        this.bLO = obtainStyledAttributes.getColor(a.j.sdk_GradientEnableTextView_startColorDisableEnable, -1);
        this.bLP = obtainStyledAttributes.getColor(a.j.sdk_GradientEnableTextView_endColorDisableEnable, -1);
        obtainStyledAttributes.recycle();
        this.bLR = true;
    }

    @Override // android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (isClickable()) {
            if (motionEvent.getAction() == 0) {
                this.bjG = true;
            } else if (motionEvent.getAction() == 3 || motionEvent.getAction() == 1) {
                this.bjG = false;
            }
        } else {
            this.bjG = false;
        }
        if (isClickable() && !this.bjG) {
            this.bLS = this.bLM;
            this.bLT = this.bLN;
        } else {
            this.bLS = this.bLO;
            this.bLT = this.bLP;
        }
        invalidate();
        return super.onTouchEvent(motionEvent);
    }

    public void setCheckStrEquals(boolean z) {
        this.bLR = z;
    }

    public void setGradientTextColor(int i, int i2) {
        this.bLM = i;
        this.bLN = i2;
        invalidate();
    }

    public void setGradientDisableTextColor(int i, int i2) {
        this.bLO = i;
        this.bLP = i2;
        invalidate();
    }

    @Override // android.view.View
    public void setClickable(boolean z) {
        super.setClickable(z);
        if (z && !this.bjG) {
            this.bLS = this.bLM;
            this.bLT = this.bLN;
        } else {
            this.bLS = this.bLO;
            this.bLT = this.bLP;
        }
        invalidate();
    }

    @Override // android.widget.TextView, android.view.View
    @SuppressLint({"DrawAllocation"})
    protected void onDraw(Canvas canvas) {
        String charSequence = getText().toString();
        if (this.bLS == -1 || this.bLT == -1) {
            this.bLS = this.bLM;
            this.bLT = this.bLN;
        }
        if (!TextUtils.isEmpty(charSequence) && this.bLS != -1 && this.bLT != -1 && (!this.bLR || !charSequence.equals(this.bLQ))) {
            this.bLQ = charSequence;
            float measureText = getPaint().measureText(charSequence);
            float width = (getWidth() - measureText) / 2.0f;
            getPaint().setShader(new LinearGradient(width, 0.0f, width + measureText, 0.0f, this.bLS, this.bLT, Shader.TileMode.CLAMP));
        }
        super.onDraw(canvas);
    }
}
