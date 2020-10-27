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
    private boolean beh;
    private int bxr;
    private int bxs;
    private int bxt;
    private int bxu;
    private String bxv;
    private boolean bxw;
    private int bxx;
    private int bxy;

    public GradientEnableTextView(Context context) {
        this(context, null);
    }

    public GradientEnableTextView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public GradientEnableTextView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.k.sdk_GradientEnableTextView);
        this.bxr = obtainStyledAttributes.getColor(a.k.sdk_GradientEnableTextView_startColorEnable, -1);
        this.bxs = obtainStyledAttributes.getColor(a.k.sdk_GradientEnableTextView_endColorEnable, -1);
        this.bxt = obtainStyledAttributes.getColor(a.k.sdk_GradientEnableTextView_startColorDisableEnable, -1);
        this.bxu = obtainStyledAttributes.getColor(a.k.sdk_GradientEnableTextView_endColorDisableEnable, -1);
        obtainStyledAttributes.recycle();
        this.bxw = true;
    }

    @Override // android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (isClickable()) {
            if (motionEvent.getAction() == 0) {
                this.beh = true;
            } else if (motionEvent.getAction() == 3 || motionEvent.getAction() == 1) {
                this.beh = false;
            }
        } else {
            this.beh = false;
        }
        if (isClickable() && !this.beh) {
            this.bxx = this.bxr;
            this.bxy = this.bxs;
        } else {
            this.bxx = this.bxt;
            this.bxy = this.bxu;
        }
        invalidate();
        return super.onTouchEvent(motionEvent);
    }

    public void setCheckStrEquals(boolean z) {
        this.bxw = z;
    }

    public void setGradientTextColor(int i, int i2) {
        this.bxr = i;
        this.bxs = i2;
        invalidate();
    }

    public void setGradientDisableTextColor(int i, int i2) {
        this.bxt = i;
        this.bxu = i2;
        invalidate();
    }

    @Override // android.view.View
    public void setClickable(boolean z) {
        super.setClickable(z);
        if (z && !this.beh) {
            this.bxx = this.bxr;
            this.bxy = this.bxs;
        } else {
            this.bxx = this.bxt;
            this.bxy = this.bxu;
        }
        invalidate();
    }

    @Override // android.widget.TextView, android.view.View
    @SuppressLint({"DrawAllocation"})
    protected void onDraw(Canvas canvas) {
        String charSequence = getText().toString();
        if (this.bxx == -1 || this.bxy == -1) {
            this.bxx = this.bxr;
            this.bxy = this.bxs;
        }
        if (!TextUtils.isEmpty(charSequence) && this.bxx != -1 && this.bxy != -1 && (!this.bxw || !charSequence.equals(this.bxv))) {
            this.bxv = charSequence;
            float measureText = getPaint().measureText(charSequence);
            float width = (getWidth() - measureText) / 2.0f;
            getPaint().setShader(new LinearGradient(width, 0.0f, width + measureText, 0.0f, this.bxx, this.bxy, Shader.TileMode.CLAMP));
        }
        super.onDraw(canvas);
    }
}
