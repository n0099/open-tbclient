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
import com.baidu.live.sdk.a;
/* loaded from: classes4.dex */
public class GradientEnableTextView extends TextView {
    private boolean aRP;
    private String biA;
    private boolean biB;
    private int biC;
    private int biD;
    private int biw;
    private int bix;
    private int biy;
    private int biz;

    public GradientEnableTextView(Context context) {
        this(context, null);
    }

    public GradientEnableTextView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public GradientEnableTextView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.k.sdk_GradientEnableTextView);
        this.biw = obtainStyledAttributes.getColor(a.k.sdk_GradientEnableTextView_startColorEnable, -1);
        this.bix = obtainStyledAttributes.getColor(a.k.sdk_GradientEnableTextView_endColorEnable, -1);
        this.biy = obtainStyledAttributes.getColor(a.k.sdk_GradientEnableTextView_startColorDisableEnable, -1);
        this.biz = obtainStyledAttributes.getColor(a.k.sdk_GradientEnableTextView_endColorDisableEnable, -1);
        obtainStyledAttributes.recycle();
        this.biB = true;
    }

    @Override // android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (isClickable()) {
            if (motionEvent.getAction() == 0) {
                this.aRP = true;
            } else if (motionEvent.getAction() == 3 || motionEvent.getAction() == 1) {
                this.aRP = false;
            }
        } else {
            this.aRP = false;
        }
        if (isClickable() && !this.aRP) {
            this.biC = this.biw;
            this.biD = this.bix;
        } else {
            this.biC = this.biy;
            this.biD = this.biz;
        }
        invalidate();
        return super.onTouchEvent(motionEvent);
    }

    public void setCheckStrEquals(boolean z) {
        this.biB = z;
    }

    public void setGradientTextColor(int i, int i2) {
        this.biw = i;
        this.bix = i2;
        invalidate();
    }

    public void setGradientDisableTextColor(int i, int i2) {
        this.biy = i;
        this.biz = i2;
        invalidate();
    }

    @Override // android.view.View
    public void setClickable(boolean z) {
        super.setClickable(z);
        if (z && !this.aRP) {
            this.biC = this.biw;
            this.biD = this.bix;
        } else {
            this.biC = this.biy;
            this.biD = this.biz;
        }
        invalidate();
    }

    @Override // android.widget.TextView, android.view.View
    @SuppressLint({"DrawAllocation"})
    protected void onDraw(Canvas canvas) {
        String charSequence = getText().toString();
        if (this.biC == -1 || this.biD == -1) {
            this.biC = this.biw;
            this.biD = this.bix;
        }
        if (!TextUtils.isEmpty(charSequence) && this.biC != -1 && this.biD != -1 && (!this.biB || !charSequence.equals(this.biA))) {
            this.biA = charSequence;
            float measureText = getPaint().measureText(charSequence);
            float width = (getWidth() - measureText) / 2.0f;
            getPaint().setShader(new LinearGradient(width, 0.0f, width + measureText, 0.0f, this.biC, this.biD, Shader.TileMode.CLAMP));
        }
        super.onDraw(canvas);
    }
}
