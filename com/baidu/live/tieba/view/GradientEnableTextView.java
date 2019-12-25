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
import com.baidu.live.q.a;
/* loaded from: classes2.dex */
public class GradientEnableTextView extends TextView {
    private boolean amm;
    private int awA;
    private String awB;
    private boolean awC;
    private int awD;
    private int awE;
    private int awx;
    private int awy;
    private int awz;

    public GradientEnableTextView(Context context) {
        this(context, null);
    }

    public GradientEnableTextView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public GradientEnableTextView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.k.sdk_GradientEnableTextView);
        this.awx = obtainStyledAttributes.getColor(a.k.sdk_GradientEnableTextView_startColorEnable, -1);
        this.awy = obtainStyledAttributes.getColor(a.k.sdk_GradientEnableTextView_endColorEnable, -1);
        this.awz = obtainStyledAttributes.getColor(a.k.sdk_GradientEnableTextView_startColorDisableEnable, -1);
        this.awA = obtainStyledAttributes.getColor(a.k.sdk_GradientEnableTextView_endColorDisableEnable, -1);
        obtainStyledAttributes.recycle();
        this.awC = true;
    }

    @Override // android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (isClickable()) {
            if (motionEvent.getAction() == 0) {
                this.amm = true;
            } else if (motionEvent.getAction() == 3 || motionEvent.getAction() == 1) {
                this.amm = false;
            }
        } else {
            this.amm = false;
        }
        if (isClickable() && !this.amm) {
            this.awD = this.awx;
            this.awE = this.awy;
        } else {
            this.awD = this.awz;
            this.awE = this.awA;
        }
        invalidate();
        return super.onTouchEvent(motionEvent);
    }

    public void setCheckStrEquals(boolean z) {
        this.awC = z;
    }

    public void setGradientTextColor(int i, int i2) {
        this.awx = i;
        this.awy = i2;
        invalidate();
    }

    public void setGradientDisableTextColor(int i, int i2) {
        this.awz = i;
        this.awA = i2;
        invalidate();
    }

    @Override // android.view.View
    public void setClickable(boolean z) {
        super.setClickable(z);
        if (z && !this.amm) {
            this.awD = this.awx;
            this.awE = this.awy;
        } else {
            this.awD = this.awz;
            this.awE = this.awA;
        }
        invalidate();
    }

    @Override // android.widget.TextView, android.view.View
    @SuppressLint({"DrawAllocation"})
    protected void onDraw(Canvas canvas) {
        String charSequence = getText().toString();
        if (this.awD == -1 || this.awE == -1) {
            this.awD = this.awx;
            this.awE = this.awy;
        }
        if (!TextUtils.isEmpty(charSequence) && this.awD != -1 && this.awE != -1 && (!this.awC || !charSequence.equals(this.awB))) {
            this.awB = charSequence;
            float measureText = getPaint().measureText(charSequence);
            float width = (getWidth() - measureText) / 2.0f;
            getPaint().setShader(new LinearGradient(width, 0.0f, width + measureText, 0.0f, this.awD, this.awE, Shader.TileMode.CLAMP));
        }
        super.onDraw(canvas);
    }
}
