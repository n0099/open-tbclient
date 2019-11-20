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
    private int aoA;
    private int aoB;
    private int aoC;
    private int aoD;
    private String aoE;
    private boolean aoF;
    private boolean aoG;
    private int aoH;
    private int aoI;

    public GradientEnableTextView(Context context) {
        this(context, null);
    }

    public GradientEnableTextView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public GradientEnableTextView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.k.sdk_GradientEnableTextView);
        this.aoA = obtainStyledAttributes.getColor(a.k.sdk_GradientEnableTextView_startColorEnable, -1);
        this.aoB = obtainStyledAttributes.getColor(a.k.sdk_GradientEnableTextView_endColorEnable, -1);
        this.aoC = obtainStyledAttributes.getColor(a.k.sdk_GradientEnableTextView_startColorDisableEnable, -1);
        this.aoD = obtainStyledAttributes.getColor(a.k.sdk_GradientEnableTextView_endColorDisableEnable, -1);
        obtainStyledAttributes.recycle();
        this.aoG = true;
    }

    @Override // android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (isClickable()) {
            if (motionEvent.getAction() == 0) {
                this.aoF = true;
            } else if (motionEvent.getAction() == 3 || motionEvent.getAction() == 1) {
                this.aoF = false;
            }
        } else {
            this.aoF = false;
        }
        if (isClickable() && !this.aoF) {
            this.aoH = this.aoA;
            this.aoI = this.aoB;
        } else {
            this.aoH = this.aoC;
            this.aoI = this.aoD;
        }
        invalidate();
        return super.onTouchEvent(motionEvent);
    }

    public void setCheckStrEquals(boolean z) {
        this.aoG = z;
    }

    public void setGradientTextColor(int i, int i2) {
        this.aoA = i;
        this.aoB = i2;
        invalidate();
    }

    public void setGradientDisableTextColor(int i, int i2) {
        this.aoC = i;
        this.aoD = i2;
        invalidate();
    }

    @Override // android.view.View
    public void setClickable(boolean z) {
        super.setClickable(z);
        if (z && !this.aoF) {
            this.aoH = this.aoA;
            this.aoI = this.aoB;
        } else {
            this.aoH = this.aoC;
            this.aoI = this.aoD;
        }
        invalidate();
    }

    @Override // android.widget.TextView, android.view.View
    @SuppressLint({"DrawAllocation"})
    protected void onDraw(Canvas canvas) {
        String charSequence = getText().toString();
        if (this.aoH == -1 || this.aoI == -1) {
            this.aoH = this.aoA;
            this.aoI = this.aoB;
        }
        if (!TextUtils.isEmpty(charSequence) && this.aoH != -1 && this.aoI != -1 && (!this.aoG || !charSequence.equals(this.aoE))) {
            this.aoE = charSequence;
            float measureText = getPaint().measureText(charSequence);
            float width = (getWidth() - measureText) / 2.0f;
            getPaint().setShader(new LinearGradient(width, 0.0f, width + measureText, 0.0f, this.aoH, this.aoI, Shader.TileMode.CLAMP));
        }
        super.onDraw(canvas);
    }
}
