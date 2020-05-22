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
    private boolean aNQ;
    private int bcP;
    private int bcQ;
    private int bcR;
    private int bcS;
    private String bcT;
    private boolean bcU;
    private int bcV;
    private int bcW;

    public GradientEnableTextView(Context context) {
        this(context, null);
    }

    public GradientEnableTextView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public GradientEnableTextView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.k.sdk_GradientEnableTextView);
        this.bcP = obtainStyledAttributes.getColor(a.k.sdk_GradientEnableTextView_startColorEnable, -1);
        this.bcQ = obtainStyledAttributes.getColor(a.k.sdk_GradientEnableTextView_endColorEnable, -1);
        this.bcR = obtainStyledAttributes.getColor(a.k.sdk_GradientEnableTextView_startColorDisableEnable, -1);
        this.bcS = obtainStyledAttributes.getColor(a.k.sdk_GradientEnableTextView_endColorDisableEnable, -1);
        obtainStyledAttributes.recycle();
        this.bcU = true;
    }

    @Override // android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (isClickable()) {
            if (motionEvent.getAction() == 0) {
                this.aNQ = true;
            } else if (motionEvent.getAction() == 3 || motionEvent.getAction() == 1) {
                this.aNQ = false;
            }
        } else {
            this.aNQ = false;
        }
        if (isClickable() && !this.aNQ) {
            this.bcV = this.bcP;
            this.bcW = this.bcQ;
        } else {
            this.bcV = this.bcR;
            this.bcW = this.bcS;
        }
        invalidate();
        return super.onTouchEvent(motionEvent);
    }

    public void setCheckStrEquals(boolean z) {
        this.bcU = z;
    }

    public void setGradientTextColor(int i, int i2) {
        this.bcP = i;
        this.bcQ = i2;
        invalidate();
    }

    public void setGradientDisableTextColor(int i, int i2) {
        this.bcR = i;
        this.bcS = i2;
        invalidate();
    }

    @Override // android.view.View
    public void setClickable(boolean z) {
        super.setClickable(z);
        if (z && !this.aNQ) {
            this.bcV = this.bcP;
            this.bcW = this.bcQ;
        } else {
            this.bcV = this.bcR;
            this.bcW = this.bcS;
        }
        invalidate();
    }

    @Override // android.widget.TextView, android.view.View
    @SuppressLint({"DrawAllocation"})
    protected void onDraw(Canvas canvas) {
        String charSequence = getText().toString();
        if (this.bcV == -1 || this.bcW == -1) {
            this.bcV = this.bcP;
            this.bcW = this.bcQ;
        }
        if (!TextUtils.isEmpty(charSequence) && this.bcV != -1 && this.bcW != -1 && (!this.bcU || !charSequence.equals(this.bcT))) {
            this.bcT = charSequence;
            float measureText = getPaint().measureText(charSequence);
            float width = (getWidth() - measureText) / 2.0f;
            getPaint().setShader(new LinearGradient(width, 0.0f, width + measureText, 0.0f, this.bcV, this.bcW, Shader.TileMode.CLAMP));
        }
        super.onDraw(canvas);
    }
}
