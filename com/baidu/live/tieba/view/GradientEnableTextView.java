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
/* loaded from: classes7.dex */
public class GradientEnableTextView extends TextView {
    private boolean aXc;
    private int bob;
    private int boc;
    private int bod;
    private int boe;
    private String bof;
    private boolean bog;
    private int boh;
    private int boi;

    public GradientEnableTextView(Context context) {
        this(context, null);
    }

    public GradientEnableTextView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public GradientEnableTextView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.k.sdk_GradientEnableTextView);
        this.bob = obtainStyledAttributes.getColor(a.k.sdk_GradientEnableTextView_startColorEnable, -1);
        this.boc = obtainStyledAttributes.getColor(a.k.sdk_GradientEnableTextView_endColorEnable, -1);
        this.bod = obtainStyledAttributes.getColor(a.k.sdk_GradientEnableTextView_startColorDisableEnable, -1);
        this.boe = obtainStyledAttributes.getColor(a.k.sdk_GradientEnableTextView_endColorDisableEnable, -1);
        obtainStyledAttributes.recycle();
        this.bog = true;
    }

    @Override // android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (isClickable()) {
            if (motionEvent.getAction() == 0) {
                this.aXc = true;
            } else if (motionEvent.getAction() == 3 || motionEvent.getAction() == 1) {
                this.aXc = false;
            }
        } else {
            this.aXc = false;
        }
        if (isClickable() && !this.aXc) {
            this.boh = this.bob;
            this.boi = this.boc;
        } else {
            this.boh = this.bod;
            this.boi = this.boe;
        }
        invalidate();
        return super.onTouchEvent(motionEvent);
    }

    public void setCheckStrEquals(boolean z) {
        this.bog = z;
    }

    public void setGradientTextColor(int i, int i2) {
        this.bob = i;
        this.boc = i2;
        invalidate();
    }

    public void setGradientDisableTextColor(int i, int i2) {
        this.bod = i;
        this.boe = i2;
        invalidate();
    }

    @Override // android.view.View
    public void setClickable(boolean z) {
        super.setClickable(z);
        if (z && !this.aXc) {
            this.boh = this.bob;
            this.boi = this.boc;
        } else {
            this.boh = this.bod;
            this.boi = this.boe;
        }
        invalidate();
    }

    @Override // android.widget.TextView, android.view.View
    @SuppressLint({"DrawAllocation"})
    protected void onDraw(Canvas canvas) {
        String charSequence = getText().toString();
        if (this.boh == -1 || this.boi == -1) {
            this.boh = this.bob;
            this.boi = this.boc;
        }
        if (!TextUtils.isEmpty(charSequence) && this.boh != -1 && this.boi != -1 && (!this.bog || !charSequence.equals(this.bof))) {
            this.bof = charSequence;
            float measureText = getPaint().measureText(charSequence);
            float width = (getWidth() - measureText) / 2.0f;
            getPaint().setShader(new LinearGradient(width, 0.0f, width + measureText, 0.0f, this.boh, this.boi, Shader.TileMode.CLAMP));
        }
        super.onDraw(canvas);
    }
}
