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
    private boolean aIb;
    private String aVA;
    private boolean aVB;
    private int aVC;
    private int aVD;
    private int aVw;
    private int aVx;
    private int aVy;
    private int aVz;

    public GradientEnableTextView(Context context) {
        this(context, null);
    }

    public GradientEnableTextView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public GradientEnableTextView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.k.sdk_GradientEnableTextView);
        this.aVw = obtainStyledAttributes.getColor(a.k.sdk_GradientEnableTextView_startColorEnable, -1);
        this.aVx = obtainStyledAttributes.getColor(a.k.sdk_GradientEnableTextView_endColorEnable, -1);
        this.aVy = obtainStyledAttributes.getColor(a.k.sdk_GradientEnableTextView_startColorDisableEnable, -1);
        this.aVz = obtainStyledAttributes.getColor(a.k.sdk_GradientEnableTextView_endColorDisableEnable, -1);
        obtainStyledAttributes.recycle();
        this.aVB = true;
    }

    @Override // android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (isClickable()) {
            if (motionEvent.getAction() == 0) {
                this.aIb = true;
            } else if (motionEvent.getAction() == 3 || motionEvent.getAction() == 1) {
                this.aIb = false;
            }
        } else {
            this.aIb = false;
        }
        if (isClickable() && !this.aIb) {
            this.aVC = this.aVw;
            this.aVD = this.aVx;
        } else {
            this.aVC = this.aVy;
            this.aVD = this.aVz;
        }
        invalidate();
        return super.onTouchEvent(motionEvent);
    }

    public void setCheckStrEquals(boolean z) {
        this.aVB = z;
    }

    public void setGradientTextColor(int i, int i2) {
        this.aVw = i;
        this.aVx = i2;
        invalidate();
    }

    public void setGradientDisableTextColor(int i, int i2) {
        this.aVy = i;
        this.aVz = i2;
        invalidate();
    }

    @Override // android.view.View
    public void setClickable(boolean z) {
        super.setClickable(z);
        if (z && !this.aIb) {
            this.aVC = this.aVw;
            this.aVD = this.aVx;
        } else {
            this.aVC = this.aVy;
            this.aVD = this.aVz;
        }
        invalidate();
    }

    @Override // android.widget.TextView, android.view.View
    @SuppressLint({"DrawAllocation"})
    protected void onDraw(Canvas canvas) {
        String charSequence = getText().toString();
        if (this.aVC == -1 || this.aVD == -1) {
            this.aVC = this.aVw;
            this.aVD = this.aVx;
        }
        if (!TextUtils.isEmpty(charSequence) && this.aVC != -1 && this.aVD != -1 && (!this.aVB || !charSequence.equals(this.aVA))) {
            this.aVA = charSequence;
            float measureText = getPaint().measureText(charSequence);
            float width = (getWidth() - measureText) / 2.0f;
            getPaint().setShader(new LinearGradient(width, 0.0f, width + measureText, 0.0f, this.aVC, this.aVD, Shader.TileMode.CLAMP));
        }
        super.onDraw(canvas);
    }
}
