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
    private boolean aXe;
    private int boe;
    private int bof;
    private int bog;
    private int boh;
    private String boi;
    private boolean boj;
    private int bok;
    private int bol;

    public GradientEnableTextView(Context context) {
        this(context, null);
    }

    public GradientEnableTextView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public GradientEnableTextView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.k.sdk_GradientEnableTextView);
        this.boe = obtainStyledAttributes.getColor(a.k.sdk_GradientEnableTextView_startColorEnable, -1);
        this.bof = obtainStyledAttributes.getColor(a.k.sdk_GradientEnableTextView_endColorEnable, -1);
        this.bog = obtainStyledAttributes.getColor(a.k.sdk_GradientEnableTextView_startColorDisableEnable, -1);
        this.boh = obtainStyledAttributes.getColor(a.k.sdk_GradientEnableTextView_endColorDisableEnable, -1);
        obtainStyledAttributes.recycle();
        this.boj = true;
    }

    @Override // android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (isClickable()) {
            if (motionEvent.getAction() == 0) {
                this.aXe = true;
            } else if (motionEvent.getAction() == 3 || motionEvent.getAction() == 1) {
                this.aXe = false;
            }
        } else {
            this.aXe = false;
        }
        if (isClickable() && !this.aXe) {
            this.bok = this.boe;
            this.bol = this.bof;
        } else {
            this.bok = this.bog;
            this.bol = this.boh;
        }
        invalidate();
        return super.onTouchEvent(motionEvent);
    }

    public void setCheckStrEquals(boolean z) {
        this.boj = z;
    }

    public void setGradientTextColor(int i, int i2) {
        this.boe = i;
        this.bof = i2;
        invalidate();
    }

    public void setGradientDisableTextColor(int i, int i2) {
        this.bog = i;
        this.boh = i2;
        invalidate();
    }

    @Override // android.view.View
    public void setClickable(boolean z) {
        super.setClickable(z);
        if (z && !this.aXe) {
            this.bok = this.boe;
            this.bol = this.bof;
        } else {
            this.bok = this.bog;
            this.bol = this.boh;
        }
        invalidate();
    }

    @Override // android.widget.TextView, android.view.View
    @SuppressLint({"DrawAllocation"})
    protected void onDraw(Canvas canvas) {
        String charSequence = getText().toString();
        if (this.bok == -1 || this.bol == -1) {
            this.bok = this.boe;
            this.bol = this.bof;
        }
        if (!TextUtils.isEmpty(charSequence) && this.bok != -1 && this.bol != -1 && (!this.boj || !charSequence.equals(this.boi))) {
            this.boi = charSequence;
            float measureText = getPaint().measureText(charSequence);
            float width = (getWidth() - measureText) / 2.0f;
            getPaint().setShader(new LinearGradient(width, 0.0f, width + measureText, 0.0f, this.bok, this.bol, Shader.TileMode.CLAMP));
        }
        super.onDraw(canvas);
    }
}
