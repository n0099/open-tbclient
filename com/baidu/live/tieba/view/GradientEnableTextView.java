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
/* loaded from: classes10.dex */
public class GradientEnableTextView extends TextView {
    private int bMk;
    private int bMl;
    private int bMm;
    private int bMn;
    private String bMo;
    private boolean bMp;
    private int bMq;
    private int bMr;
    private boolean bjz;

    public GradientEnableTextView(Context context) {
        this(context, null);
    }

    public GradientEnableTextView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public GradientEnableTextView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.j.sdk_GradientEnableTextView);
        this.bMk = obtainStyledAttributes.getColor(a.j.sdk_GradientEnableTextView_startColorEnable, -1);
        this.bMl = obtainStyledAttributes.getColor(a.j.sdk_GradientEnableTextView_endColorEnable, -1);
        this.bMm = obtainStyledAttributes.getColor(a.j.sdk_GradientEnableTextView_startColorDisableEnable, -1);
        this.bMn = obtainStyledAttributes.getColor(a.j.sdk_GradientEnableTextView_endColorDisableEnable, -1);
        obtainStyledAttributes.recycle();
        this.bMp = true;
    }

    @Override // android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (isClickable()) {
            if (motionEvent.getAction() == 0) {
                this.bjz = true;
            } else if (motionEvent.getAction() == 3 || motionEvent.getAction() == 1) {
                this.bjz = false;
            }
        } else {
            this.bjz = false;
        }
        if (isClickable() && !this.bjz) {
            this.bMq = this.bMk;
            this.bMr = this.bMl;
        } else {
            this.bMq = this.bMm;
            this.bMr = this.bMn;
        }
        invalidate();
        return super.onTouchEvent(motionEvent);
    }

    public void setCheckStrEquals(boolean z) {
        this.bMp = z;
    }

    public void setGradientTextColor(int i, int i2) {
        this.bMk = i;
        this.bMl = i2;
        invalidate();
    }

    public void setGradientDisableTextColor(int i, int i2) {
        this.bMm = i;
        this.bMn = i2;
        invalidate();
    }

    @Override // android.view.View
    public void setClickable(boolean z) {
        super.setClickable(z);
        if (z && !this.bjz) {
            this.bMq = this.bMk;
            this.bMr = this.bMl;
        } else {
            this.bMq = this.bMm;
            this.bMr = this.bMn;
        }
        invalidate();
    }

    @Override // android.widget.TextView, android.view.View
    @SuppressLint({"DrawAllocation"})
    protected void onDraw(Canvas canvas) {
        String charSequence = getText().toString();
        if (this.bMq == -1 || this.bMr == -1) {
            this.bMq = this.bMk;
            this.bMr = this.bMl;
        }
        if (!TextUtils.isEmpty(charSequence) && this.bMq != -1 && this.bMr != -1 && (!this.bMp || !charSequence.equals(this.bMo))) {
            this.bMo = charSequence;
            float measureText = getPaint().measureText(charSequence);
            float width = (getWidth() - measureText) / 2.0f;
            getPaint().setShader(new LinearGradient(width, 0.0f, width + measureText, 0.0f, this.bMq, this.bMr, Shader.TileMode.CLAMP));
        }
        super.onDraw(canvas);
    }
}
