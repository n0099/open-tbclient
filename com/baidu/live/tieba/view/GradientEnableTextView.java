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
    private int bGZ;
    private int bHa;
    private int bHb;
    private int bHc;
    private String bHd;
    private boolean bHe;
    private int bHf;
    private int bHg;
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
        this.bGZ = obtainStyledAttributes.getColor(a.j.sdk_GradientEnableTextView_startColorEnable, -1);
        this.bHa = obtainStyledAttributes.getColor(a.j.sdk_GradientEnableTextView_endColorEnable, -1);
        this.bHb = obtainStyledAttributes.getColor(a.j.sdk_GradientEnableTextView_startColorDisableEnable, -1);
        this.bHc = obtainStyledAttributes.getColor(a.j.sdk_GradientEnableTextView_endColorDisableEnable, -1);
        obtainStyledAttributes.recycle();
        this.bHe = true;
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
            this.bHf = this.bGZ;
            this.bHg = this.bHa;
        } else {
            this.bHf = this.bHb;
            this.bHg = this.bHc;
        }
        invalidate();
        return super.onTouchEvent(motionEvent);
    }

    public void setCheckStrEquals(boolean z) {
        this.bHe = z;
    }

    public void setGradientTextColor(int i, int i2) {
        this.bGZ = i;
        this.bHa = i2;
        invalidate();
    }

    public void setGradientDisableTextColor(int i, int i2) {
        this.bHb = i;
        this.bHc = i2;
        invalidate();
    }

    @Override // android.view.View
    public void setClickable(boolean z) {
        super.setClickable(z);
        if (z && !this.bhX) {
            this.bHf = this.bGZ;
            this.bHg = this.bHa;
        } else {
            this.bHf = this.bHb;
            this.bHg = this.bHc;
        }
        invalidate();
    }

    @Override // android.widget.TextView, android.view.View
    @SuppressLint({"DrawAllocation"})
    protected void onDraw(Canvas canvas) {
        String charSequence = getText().toString();
        if (this.bHf == -1 || this.bHg == -1) {
            this.bHf = this.bGZ;
            this.bHg = this.bHa;
        }
        if (!TextUtils.isEmpty(charSequence) && this.bHf != -1 && this.bHg != -1 && (!this.bHe || !charSequence.equals(this.bHd))) {
            this.bHd = charSequence;
            float measureText = getPaint().measureText(charSequence);
            float width = (getWidth() - measureText) / 2.0f;
            getPaint().setShader(new LinearGradient(width, 0.0f, width + measureText, 0.0f, this.bHf, this.bHg, Shader.TileMode.CLAMP));
        }
        super.onDraw(canvas);
    }
}
