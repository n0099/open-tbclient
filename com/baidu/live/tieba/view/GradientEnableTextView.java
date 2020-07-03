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
/* loaded from: classes3.dex */
public class GradientEnableTextView extends TextView {
    private boolean aQw;
    private int bhZ;
    private int bia;
    private int bib;
    private int bic;
    private String bie;
    private boolean bif;
    private int bih;
    private int bii;

    public GradientEnableTextView(Context context) {
        this(context, null);
    }

    public GradientEnableTextView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public GradientEnableTextView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.k.sdk_GradientEnableTextView);
        this.bhZ = obtainStyledAttributes.getColor(a.k.sdk_GradientEnableTextView_startColorEnable, -1);
        this.bia = obtainStyledAttributes.getColor(a.k.sdk_GradientEnableTextView_endColorEnable, -1);
        this.bib = obtainStyledAttributes.getColor(a.k.sdk_GradientEnableTextView_startColorDisableEnable, -1);
        this.bic = obtainStyledAttributes.getColor(a.k.sdk_GradientEnableTextView_endColorDisableEnable, -1);
        obtainStyledAttributes.recycle();
        this.bif = true;
    }

    @Override // android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (isClickable()) {
            if (motionEvent.getAction() == 0) {
                this.aQw = true;
            } else if (motionEvent.getAction() == 3 || motionEvent.getAction() == 1) {
                this.aQw = false;
            }
        } else {
            this.aQw = false;
        }
        if (isClickable() && !this.aQw) {
            this.bih = this.bhZ;
            this.bii = this.bia;
        } else {
            this.bih = this.bib;
            this.bii = this.bic;
        }
        invalidate();
        return super.onTouchEvent(motionEvent);
    }

    public void setCheckStrEquals(boolean z) {
        this.bif = z;
    }

    public void setGradientTextColor(int i, int i2) {
        this.bhZ = i;
        this.bia = i2;
        invalidate();
    }

    public void setGradientDisableTextColor(int i, int i2) {
        this.bib = i;
        this.bic = i2;
        invalidate();
    }

    @Override // android.view.View
    public void setClickable(boolean z) {
        super.setClickable(z);
        if (z && !this.aQw) {
            this.bih = this.bhZ;
            this.bii = this.bia;
        } else {
            this.bih = this.bib;
            this.bii = this.bic;
        }
        invalidate();
    }

    @Override // android.widget.TextView, android.view.View
    @SuppressLint({"DrawAllocation"})
    protected void onDraw(Canvas canvas) {
        String charSequence = getText().toString();
        if (this.bih == -1 || this.bii == -1) {
            this.bih = this.bhZ;
            this.bii = this.bia;
        }
        if (!TextUtils.isEmpty(charSequence) && this.bih != -1 && this.bii != -1 && (!this.bif || !charSequence.equals(this.bie))) {
            this.bie = charSequence;
            float measureText = getPaint().measureText(charSequence);
            float width = (getWidth() - measureText) / 2.0f;
            getPaint().setShader(new LinearGradient(width, 0.0f, width + measureText, 0.0f, this.bih, this.bii, Shader.TileMode.CLAMP));
        }
        super.onDraw(canvas);
    }
}
