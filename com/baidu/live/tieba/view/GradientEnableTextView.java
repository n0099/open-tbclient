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
import com.baidu.live.k.a;
/* loaded from: classes6.dex */
public class GradientEnableTextView extends TextView {
    private int aoS;
    private int aoT;
    private int aoU;
    private int aoV;
    private String aoW;
    private boolean aoX;
    private boolean aoY;
    private int aoZ;
    private int apa;

    public GradientEnableTextView(Context context) {
        this(context, null);
    }

    public GradientEnableTextView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public GradientEnableTextView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.k.sdk_GradientEnableTextView);
        this.aoS = obtainStyledAttributes.getColor(a.k.sdk_GradientEnableTextView_startColorEnable, -1);
        this.aoT = obtainStyledAttributes.getColor(a.k.sdk_GradientEnableTextView_endColorEnable, -1);
        this.aoU = obtainStyledAttributes.getColor(a.k.sdk_GradientEnableTextView_startColorDisableEnable, -1);
        this.aoV = obtainStyledAttributes.getColor(a.k.sdk_GradientEnableTextView_endColorDisableEnable, -1);
        obtainStyledAttributes.recycle();
        this.aoY = true;
    }

    @Override // android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (isClickable()) {
            if (motionEvent.getAction() == 0) {
                this.aoX = true;
            } else if (motionEvent.getAction() == 3 || motionEvent.getAction() == 1) {
                this.aoX = false;
            }
        } else {
            this.aoX = false;
        }
        if (isClickable() && !this.aoX) {
            this.aoZ = this.aoS;
            this.apa = this.aoT;
        } else {
            this.aoZ = this.aoU;
            this.apa = this.aoV;
        }
        invalidate();
        return super.onTouchEvent(motionEvent);
    }

    public void setCheckStrEquals(boolean z) {
        this.aoY = z;
    }

    public void setGradientTextColor(int i, int i2) {
        this.aoS = i;
        this.aoT = i2;
        invalidate();
    }

    public void setGradientDisableTextColor(int i, int i2) {
        this.aoU = i;
        this.aoV = i2;
        invalidate();
    }

    @Override // android.view.View
    public void setClickable(boolean z) {
        super.setClickable(z);
        if (z && !this.aoX) {
            this.aoZ = this.aoS;
            this.apa = this.aoT;
        } else {
            this.aoZ = this.aoU;
            this.apa = this.aoV;
        }
        invalidate();
    }

    @Override // android.widget.TextView, android.view.View
    @SuppressLint({"DrawAllocation"})
    protected void onDraw(Canvas canvas) {
        String charSequence = getText().toString();
        if (this.aoZ == -1 || this.apa == -1) {
            this.aoZ = this.aoS;
            this.apa = this.aoT;
        }
        if (!TextUtils.isEmpty(charSequence) && this.aoZ != -1 && this.apa != -1 && (!this.aoY || !charSequence.equals(this.aoW))) {
            this.aoW = charSequence;
            float measureText = getPaint().measureText(charSequence);
            float width = (getWidth() - measureText) / 2.0f;
            getPaint().setShader(new LinearGradient(width, 0.0f, width + measureText, 0.0f, this.aoZ, this.apa, Shader.TileMode.CLAMP));
        }
        super.onDraw(canvas);
    }
}
