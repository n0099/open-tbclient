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
    private boolean aZy;
    private int brp;
    private int brq;
    private int brr;
    private int brs;
    private String brt;
    private boolean bru;
    private int brv;
    private int brw;

    public GradientEnableTextView(Context context) {
        this(context, null);
    }

    public GradientEnableTextView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public GradientEnableTextView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.k.sdk_GradientEnableTextView);
        this.brp = obtainStyledAttributes.getColor(a.k.sdk_GradientEnableTextView_startColorEnable, -1);
        this.brq = obtainStyledAttributes.getColor(a.k.sdk_GradientEnableTextView_endColorEnable, -1);
        this.brr = obtainStyledAttributes.getColor(a.k.sdk_GradientEnableTextView_startColorDisableEnable, -1);
        this.brs = obtainStyledAttributes.getColor(a.k.sdk_GradientEnableTextView_endColorDisableEnable, -1);
        obtainStyledAttributes.recycle();
        this.bru = true;
    }

    @Override // android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (isClickable()) {
            if (motionEvent.getAction() == 0) {
                this.aZy = true;
            } else if (motionEvent.getAction() == 3 || motionEvent.getAction() == 1) {
                this.aZy = false;
            }
        } else {
            this.aZy = false;
        }
        if (isClickable() && !this.aZy) {
            this.brv = this.brp;
            this.brw = this.brq;
        } else {
            this.brv = this.brr;
            this.brw = this.brs;
        }
        invalidate();
        return super.onTouchEvent(motionEvent);
    }

    public void setCheckStrEquals(boolean z) {
        this.bru = z;
    }

    public void setGradientTextColor(int i, int i2) {
        this.brp = i;
        this.brq = i2;
        invalidate();
    }

    public void setGradientDisableTextColor(int i, int i2) {
        this.brr = i;
        this.brs = i2;
        invalidate();
    }

    @Override // android.view.View
    public void setClickable(boolean z) {
        super.setClickable(z);
        if (z && !this.aZy) {
            this.brv = this.brp;
            this.brw = this.brq;
        } else {
            this.brv = this.brr;
            this.brw = this.brs;
        }
        invalidate();
    }

    @Override // android.widget.TextView, android.view.View
    @SuppressLint({"DrawAllocation"})
    protected void onDraw(Canvas canvas) {
        String charSequence = getText().toString();
        if (this.brv == -1 || this.brw == -1) {
            this.brv = this.brp;
            this.brw = this.brq;
        }
        if (!TextUtils.isEmpty(charSequence) && this.brv != -1 && this.brw != -1 && (!this.bru || !charSequence.equals(this.brt))) {
            this.brt = charSequence;
            float measureText = getPaint().measureText(charSequence);
            float width = (getWidth() - measureText) / 2.0f;
            getPaint().setShader(new LinearGradient(width, 0.0f, width + measureText, 0.0f, this.brv, this.brw, Shader.TileMode.CLAMP));
        }
        super.onDraw(canvas);
    }
}
