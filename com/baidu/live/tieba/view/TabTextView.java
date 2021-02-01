package com.baidu.live.tieba.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.baidu.live.sdk.a;
/* loaded from: classes11.dex */
public class TabTextView extends TextView {
    private int bKK;
    private int bKL;
    private float bKT;
    private float bKU;
    private boolean bKV;
    private LinearGradient bKW;
    private boolean bKX;

    public TabTextView(Context context) {
        this(context, null);
    }

    public TabTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TabTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bKX = true;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.j.sdk_TabTextView);
        this.bKK = obtainStyledAttributes.getColor(a.j.sdk_TabTextView_startTextColor, -1);
        this.bKL = obtainStyledAttributes.getColor(a.j.sdk_TabTextView_endTextColor, -1);
        this.bKT = obtainStyledAttributes.getDimension(a.j.sdk_TabTextView_defaultTextSize, -1.0f);
        this.bKU = obtainStyledAttributes.getDimension(a.j.sdk_TabTextView_selectedTextSize, -1.0f);
        this.bKV = obtainStyledAttributes.getBoolean(a.j.sdk_TabTextView_selectedBold, false);
        obtainStyledAttributes.recycle();
        dj(false);
    }

    @Override // android.view.View
    protected void dispatchSetSelected(boolean z) {
        super.dispatchSetSelected(z);
        dj(z);
        dk(z);
        dl(z);
    }

    public void setGradientAttrs(int i, int i2, float f, float f2, boolean z) {
        this.bKK = i;
        this.bKL = i2;
        this.bKT = f;
        this.bKU = f2;
        this.bKV = z;
        invalidate();
    }

    private boolean Ug() {
        return (this.bKK == -1 || this.bKL == -1) ? false : true;
    }

    private void dj(boolean z) {
        if (this.bKX) {
            if (z) {
                if (this.bKU != -1.0f) {
                    setTextSize(0, this.bKU);
                }
            } else if (this.bKT != -1.0f) {
                setTextSize(0, this.bKT);
            }
        }
    }

    public TabTextView dk(boolean z) {
        if (this.bKV) {
            if (z) {
                setTypeface(Typeface.DEFAULT_BOLD);
            } else {
                setTypeface(Typeface.DEFAULT);
            }
        }
        return this;
    }

    private void dl(boolean z) {
        if (z && Ug()) {
            if (this.bKW == null) {
                if (getMeasuredWidth() == 0) {
                    int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                    measure(makeMeasureSpec, makeMeasureSpec);
                }
                this.bKW = new LinearGradient(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight(), new int[]{this.bKK, this.bKL}, (float[]) null, Shader.TileMode.CLAMP);
            }
            getPaint().setShader(this.bKW);
            return;
        }
        getPaint().setShader(null);
    }
}
