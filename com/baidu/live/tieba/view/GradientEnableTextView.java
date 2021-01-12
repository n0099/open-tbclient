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
    private int bHa;
    private int bHb;
    private int bHc;
    private int bHd;
    private String bHe;
    private boolean bHf;
    private int bHg;
    private int bHh;
    private boolean beP;

    public GradientEnableTextView(Context context) {
        this(context, null);
    }

    public GradientEnableTextView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public GradientEnableTextView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.j.sdk_GradientEnableTextView);
        this.bHa = obtainStyledAttributes.getColor(a.j.sdk_GradientEnableTextView_startColorEnable, -1);
        this.bHb = obtainStyledAttributes.getColor(a.j.sdk_GradientEnableTextView_endColorEnable, -1);
        this.bHc = obtainStyledAttributes.getColor(a.j.sdk_GradientEnableTextView_startColorDisableEnable, -1);
        this.bHd = obtainStyledAttributes.getColor(a.j.sdk_GradientEnableTextView_endColorDisableEnable, -1);
        obtainStyledAttributes.recycle();
        this.bHf = true;
    }

    @Override // android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (isClickable()) {
            if (motionEvent.getAction() == 0) {
                this.beP = true;
            } else if (motionEvent.getAction() == 3 || motionEvent.getAction() == 1) {
                this.beP = false;
            }
        } else {
            this.beP = false;
        }
        if (isClickable() && !this.beP) {
            this.bHg = this.bHa;
            this.bHh = this.bHb;
        } else {
            this.bHg = this.bHc;
            this.bHh = this.bHd;
        }
        invalidate();
        return super.onTouchEvent(motionEvent);
    }

    public void setCheckStrEquals(boolean z) {
        this.bHf = z;
    }

    public void setGradientTextColor(int i, int i2) {
        this.bHa = i;
        this.bHb = i2;
        invalidate();
    }

    public void setGradientDisableTextColor(int i, int i2) {
        this.bHc = i;
        this.bHd = i2;
        invalidate();
    }

    @Override // android.view.View
    public void setClickable(boolean z) {
        super.setClickable(z);
        if (z && !this.beP) {
            this.bHg = this.bHa;
            this.bHh = this.bHb;
        } else {
            this.bHg = this.bHc;
            this.bHh = this.bHd;
        }
        invalidate();
    }

    @Override // android.widget.TextView, android.view.View
    @SuppressLint({"DrawAllocation"})
    protected void onDraw(Canvas canvas) {
        String charSequence = getText().toString();
        if (this.bHg == -1 || this.bHh == -1) {
            this.bHg = this.bHa;
            this.bHh = this.bHb;
        }
        if (!TextUtils.isEmpty(charSequence) && this.bHg != -1 && this.bHh != -1 && (!this.bHf || !charSequence.equals(this.bHe))) {
            this.bHe = charSequence;
            float measureText = getPaint().measureText(charSequence);
            float width = (getWidth() - measureText) / 2.0f;
            getPaint().setShader(new LinearGradient(width, 0.0f, width + measureText, 0.0f, this.bHg, this.bHh, Shader.TileMode.CLAMP));
        }
        super.onDraw(canvas);
    }
}
