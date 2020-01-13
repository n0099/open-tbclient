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
import com.baidu.live.r.a;
/* loaded from: classes2.dex */
public class GradientEnableTextView extends TextView {
    private boolean amZ;
    private int axj;
    private int axk;
    private int axl;
    private int axm;
    private String axn;
    private boolean axo;
    private int axp;
    private int axq;

    public GradientEnableTextView(Context context) {
        this(context, null);
    }

    public GradientEnableTextView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public GradientEnableTextView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.k.sdk_GradientEnableTextView);
        this.axj = obtainStyledAttributes.getColor(a.k.sdk_GradientEnableTextView_startColorEnable, -1);
        this.axk = obtainStyledAttributes.getColor(a.k.sdk_GradientEnableTextView_endColorEnable, -1);
        this.axl = obtainStyledAttributes.getColor(a.k.sdk_GradientEnableTextView_startColorDisableEnable, -1);
        this.axm = obtainStyledAttributes.getColor(a.k.sdk_GradientEnableTextView_endColorDisableEnable, -1);
        obtainStyledAttributes.recycle();
        this.axo = true;
    }

    @Override // android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (isClickable()) {
            if (motionEvent.getAction() == 0) {
                this.amZ = true;
            } else if (motionEvent.getAction() == 3 || motionEvent.getAction() == 1) {
                this.amZ = false;
            }
        } else {
            this.amZ = false;
        }
        if (isClickable() && !this.amZ) {
            this.axp = this.axj;
            this.axq = this.axk;
        } else {
            this.axp = this.axl;
            this.axq = this.axm;
        }
        invalidate();
        return super.onTouchEvent(motionEvent);
    }

    public void setCheckStrEquals(boolean z) {
        this.axo = z;
    }

    public void setGradientTextColor(int i, int i2) {
        this.axj = i;
        this.axk = i2;
        invalidate();
    }

    public void setGradientDisableTextColor(int i, int i2) {
        this.axl = i;
        this.axm = i2;
        invalidate();
    }

    @Override // android.view.View
    public void setClickable(boolean z) {
        super.setClickable(z);
        if (z && !this.amZ) {
            this.axp = this.axj;
            this.axq = this.axk;
        } else {
            this.axp = this.axl;
            this.axq = this.axm;
        }
        invalidate();
    }

    @Override // android.widget.TextView, android.view.View
    @SuppressLint({"DrawAllocation"})
    protected void onDraw(Canvas canvas) {
        String charSequence = getText().toString();
        if (this.axp == -1 || this.axq == -1) {
            this.axp = this.axj;
            this.axq = this.axk;
        }
        if (!TextUtils.isEmpty(charSequence) && this.axp != -1 && this.axq != -1 && (!this.axo || !charSequence.equals(this.axn))) {
            this.axn = charSequence;
            float measureText = getPaint().measureText(charSequence);
            float width = (getWidth() - measureText) / 2.0f;
            getPaint().setShader(new LinearGradient(width, 0.0f, width + measureText, 0.0f, this.axp, this.axq, Shader.TileMode.CLAMP));
        }
        super.onDraw(canvas);
    }
}
