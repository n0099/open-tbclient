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
    private int bBR;
    private int bBS;
    private int bBT;
    private int bBU;
    private String bBV;
    private boolean bBW;
    private int bBX;
    private int bBY;
    private boolean bdO;

    public GradientEnableTextView(Context context) {
        this(context, null);
    }

    public GradientEnableTextView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public GradientEnableTextView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.j.sdk_GradientEnableTextView);
        this.bBR = obtainStyledAttributes.getColor(a.j.sdk_GradientEnableTextView_startColorEnable, -1);
        this.bBS = obtainStyledAttributes.getColor(a.j.sdk_GradientEnableTextView_endColorEnable, -1);
        this.bBT = obtainStyledAttributes.getColor(a.j.sdk_GradientEnableTextView_startColorDisableEnable, -1);
        this.bBU = obtainStyledAttributes.getColor(a.j.sdk_GradientEnableTextView_endColorDisableEnable, -1);
        obtainStyledAttributes.recycle();
        this.bBW = true;
    }

    @Override // android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (isClickable()) {
            if (motionEvent.getAction() == 0) {
                this.bdO = true;
            } else if (motionEvent.getAction() == 3 || motionEvent.getAction() == 1) {
                this.bdO = false;
            }
        } else {
            this.bdO = false;
        }
        if (isClickable() && !this.bdO) {
            this.bBX = this.bBR;
            this.bBY = this.bBS;
        } else {
            this.bBX = this.bBT;
            this.bBY = this.bBU;
        }
        invalidate();
        return super.onTouchEvent(motionEvent);
    }

    public void setCheckStrEquals(boolean z) {
        this.bBW = z;
    }

    public void setGradientTextColor(int i, int i2) {
        this.bBR = i;
        this.bBS = i2;
        invalidate();
    }

    public void setGradientDisableTextColor(int i, int i2) {
        this.bBT = i;
        this.bBU = i2;
        invalidate();
    }

    @Override // android.view.View
    public void setClickable(boolean z) {
        super.setClickable(z);
        if (z && !this.bdO) {
            this.bBX = this.bBR;
            this.bBY = this.bBS;
        } else {
            this.bBX = this.bBT;
            this.bBY = this.bBU;
        }
        invalidate();
    }

    @Override // android.widget.TextView, android.view.View
    @SuppressLint({"DrawAllocation"})
    protected void onDraw(Canvas canvas) {
        String charSequence = getText().toString();
        if (this.bBX == -1 || this.bBY == -1) {
            this.bBX = this.bBR;
            this.bBY = this.bBS;
        }
        if (!TextUtils.isEmpty(charSequence) && this.bBX != -1 && this.bBY != -1 && (!this.bBW || !charSequence.equals(this.bBV))) {
            this.bBV = charSequence;
            float measureText = getPaint().measureText(charSequence);
            float width = (getWidth() - measureText) / 2.0f;
            getPaint().setShader(new LinearGradient(width, 0.0f, width + measureText, 0.0f, this.bBX, this.bBY, Shader.TileMode.CLAMP));
        }
        super.onDraw(canvas);
    }
}
