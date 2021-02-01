package com.baidu.live.tieba.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.baidu.live.sdk.a;
/* loaded from: classes11.dex */
public class GradientEnableTextView extends TextView {
    private int bKK;
    private int bKL;
    private int bKM;
    private int bKN;
    private String bKO;
    private boolean bKP;
    private int bKQ;
    private int bKR;
    private boolean bhX;

    public GradientEnableTextView(Context context) {
        this(context, null);
    }

    public GradientEnableTextView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public GradientEnableTextView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.j.sdk_GradientEnableTextView);
        this.bKK = obtainStyledAttributes.getColor(a.j.sdk_GradientEnableTextView_startColorEnable, -1);
        this.bKL = obtainStyledAttributes.getColor(a.j.sdk_GradientEnableTextView_endColorEnable, -1);
        this.bKM = obtainStyledAttributes.getColor(a.j.sdk_GradientEnableTextView_startColorDisableEnable, -1);
        this.bKN = obtainStyledAttributes.getColor(a.j.sdk_GradientEnableTextView_endColorDisableEnable, -1);
        obtainStyledAttributes.recycle();
        this.bKP = true;
    }

    @Override // android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (isClickable()) {
            if (motionEvent.getAction() == 0) {
                this.bhX = true;
            } else if (motionEvent.getAction() == 3 || motionEvent.getAction() == 1) {
                this.bhX = false;
            }
        } else {
            this.bhX = false;
        }
        if (isClickable() && !this.bhX) {
            this.bKQ = this.bKK;
            this.bKR = this.bKL;
        } else {
            this.bKQ = this.bKM;
            this.bKR = this.bKN;
        }
        invalidate();
        return super.onTouchEvent(motionEvent);
    }

    public void setCheckStrEquals(boolean z) {
        this.bKP = z;
    }

    public void setGradientTextColor(int i, int i2) {
        this.bKK = i;
        this.bKL = i2;
        invalidate();
    }

    public void setGradientDisableTextColor(int i, int i2) {
        this.bKM = i;
        this.bKN = i2;
        invalidate();
    }

    @Override // android.view.View
    public void setClickable(boolean z) {
        super.setClickable(z);
        if (z && !this.bhX) {
            this.bKQ = this.bKK;
            this.bKR = this.bKL;
        } else {
            this.bKQ = this.bKM;
            this.bKR = this.bKN;
        }
        invalidate();
    }

    @Override // android.widget.TextView, android.view.View
    @SuppressLint({"DrawAllocation"})
    protected void onDraw(Canvas canvas) {
        String charSequence = getText().toString();
        if (this.bKQ == -1 || this.bKR == -1) {
            this.bKQ = this.bKK;
            this.bKR = this.bKL;
        }
        if (!TextUtils.isEmpty(charSequence) && this.bKQ != -1 && this.bKR != -1 && (!this.bKP || !charSequence.equals(this.bKO))) {
            this.bKO = charSequence;
            float measureText = getPaint().measureText(charSequence);
            float width = (getWidth() - measureText) / 2.0f;
            getPaint().setShader(new LinearGradient(width, 0.0f, width + measureText, 0.0f, this.bKQ, this.bKR, Shader.TileMode.CLAMP));
        }
        super.onDraw(canvas);
    }
}
