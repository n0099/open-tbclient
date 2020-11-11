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
    private int bDC;
    private int bDD;
    private int bDE;
    private int bDF;
    private String bDG;
    private boolean bDH;
    private int bDI;
    private int bDJ;
    private boolean bfD;

    public GradientEnableTextView(Context context) {
        this(context, null);
    }

    public GradientEnableTextView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public GradientEnableTextView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.j.sdk_GradientEnableTextView);
        this.bDC = obtainStyledAttributes.getColor(a.j.sdk_GradientEnableTextView_startColorEnable, -1);
        this.bDD = obtainStyledAttributes.getColor(a.j.sdk_GradientEnableTextView_endColorEnable, -1);
        this.bDE = obtainStyledAttributes.getColor(a.j.sdk_GradientEnableTextView_startColorDisableEnable, -1);
        this.bDF = obtainStyledAttributes.getColor(a.j.sdk_GradientEnableTextView_endColorDisableEnable, -1);
        obtainStyledAttributes.recycle();
        this.bDH = true;
    }

    @Override // android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (isClickable()) {
            if (motionEvent.getAction() == 0) {
                this.bfD = true;
            } else if (motionEvent.getAction() == 3 || motionEvent.getAction() == 1) {
                this.bfD = false;
            }
        } else {
            this.bfD = false;
        }
        if (isClickable() && !this.bfD) {
            this.bDI = this.bDC;
            this.bDJ = this.bDD;
        } else {
            this.bDI = this.bDE;
            this.bDJ = this.bDF;
        }
        invalidate();
        return super.onTouchEvent(motionEvent);
    }

    public void setCheckStrEquals(boolean z) {
        this.bDH = z;
    }

    public void setGradientTextColor(int i, int i2) {
        this.bDC = i;
        this.bDD = i2;
        invalidate();
    }

    public void setGradientDisableTextColor(int i, int i2) {
        this.bDE = i;
        this.bDF = i2;
        invalidate();
    }

    @Override // android.view.View
    public void setClickable(boolean z) {
        super.setClickable(z);
        if (z && !this.bfD) {
            this.bDI = this.bDC;
            this.bDJ = this.bDD;
        } else {
            this.bDI = this.bDE;
            this.bDJ = this.bDF;
        }
        invalidate();
    }

    @Override // android.widget.TextView, android.view.View
    @SuppressLint({"DrawAllocation"})
    protected void onDraw(Canvas canvas) {
        String charSequence = getText().toString();
        if (this.bDI == -1 || this.bDJ == -1) {
            this.bDI = this.bDC;
            this.bDJ = this.bDD;
        }
        if (!TextUtils.isEmpty(charSequence) && this.bDI != -1 && this.bDJ != -1 && (!this.bDH || !charSequence.equals(this.bDG))) {
            this.bDG = charSequence;
            float measureText = getPaint().measureText(charSequence);
            float width = (getWidth() - measureText) / 2.0f;
            getPaint().setShader(new LinearGradient(width, 0.0f, width + measureText, 0.0f, this.bDI, this.bDJ, Shader.TileMode.CLAMP));
        }
        super.onDraw(canvas);
    }
}
