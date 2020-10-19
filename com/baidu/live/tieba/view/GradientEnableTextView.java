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
    private boolean bcS;
    private int bvd;
    private int bve;
    private int bvf;
    private int bvg;
    private String bvh;
    private boolean bvi;
    private int bvj;
    private int bvk;

    public GradientEnableTextView(Context context) {
        this(context, null);
    }

    public GradientEnableTextView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public GradientEnableTextView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.k.sdk_GradientEnableTextView);
        this.bvd = obtainStyledAttributes.getColor(a.k.sdk_GradientEnableTextView_startColorEnable, -1);
        this.bve = obtainStyledAttributes.getColor(a.k.sdk_GradientEnableTextView_endColorEnable, -1);
        this.bvf = obtainStyledAttributes.getColor(a.k.sdk_GradientEnableTextView_startColorDisableEnable, -1);
        this.bvg = obtainStyledAttributes.getColor(a.k.sdk_GradientEnableTextView_endColorDisableEnable, -1);
        obtainStyledAttributes.recycle();
        this.bvi = true;
    }

    @Override // android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (isClickable()) {
            if (motionEvent.getAction() == 0) {
                this.bcS = true;
            } else if (motionEvent.getAction() == 3 || motionEvent.getAction() == 1) {
                this.bcS = false;
            }
        } else {
            this.bcS = false;
        }
        if (isClickable() && !this.bcS) {
            this.bvj = this.bvd;
            this.bvk = this.bve;
        } else {
            this.bvj = this.bvf;
            this.bvk = this.bvg;
        }
        invalidate();
        return super.onTouchEvent(motionEvent);
    }

    public void setCheckStrEquals(boolean z) {
        this.bvi = z;
    }

    public void setGradientTextColor(int i, int i2) {
        this.bvd = i;
        this.bve = i2;
        invalidate();
    }

    public void setGradientDisableTextColor(int i, int i2) {
        this.bvf = i;
        this.bvg = i2;
        invalidate();
    }

    @Override // android.view.View
    public void setClickable(boolean z) {
        super.setClickable(z);
        if (z && !this.bcS) {
            this.bvj = this.bvd;
            this.bvk = this.bve;
        } else {
            this.bvj = this.bvf;
            this.bvk = this.bvg;
        }
        invalidate();
    }

    @Override // android.widget.TextView, android.view.View
    @SuppressLint({"DrawAllocation"})
    protected void onDraw(Canvas canvas) {
        String charSequence = getText().toString();
        if (this.bvj == -1 || this.bvk == -1) {
            this.bvj = this.bvd;
            this.bvk = this.bve;
        }
        if (!TextUtils.isEmpty(charSequence) && this.bvj != -1 && this.bvk != -1 && (!this.bvi || !charSequence.equals(this.bvh))) {
            this.bvh = charSequence;
            float measureText = getPaint().measureText(charSequence);
            float width = (getWidth() - measureText) / 2.0f;
            getPaint().setShader(new LinearGradient(width, 0.0f, width + measureText, 0.0f, this.bvj, this.bvk, Shader.TileMode.CLAMP));
        }
        super.onDraw(canvas);
    }
}
