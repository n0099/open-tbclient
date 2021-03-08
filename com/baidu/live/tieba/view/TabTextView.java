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
/* loaded from: classes10.dex */
public class TabTextView extends TextView {
    private int bMk;
    private int bMl;
    private float bMt;
    private float bMu;
    private boolean bMv;
    private LinearGradient bMw;
    private boolean bMx;

    public TabTextView(Context context) {
        this(context, null);
    }

    public TabTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TabTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bMx = true;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.j.sdk_TabTextView);
        this.bMk = obtainStyledAttributes.getColor(a.j.sdk_TabTextView_startTextColor, -1);
        this.bMl = obtainStyledAttributes.getColor(a.j.sdk_TabTextView_endTextColor, -1);
        this.bMt = obtainStyledAttributes.getDimension(a.j.sdk_TabTextView_defaultTextSize, -1.0f);
        this.bMu = obtainStyledAttributes.getDimension(a.j.sdk_TabTextView_selectedTextSize, -1.0f);
        this.bMv = obtainStyledAttributes.getBoolean(a.j.sdk_TabTextView_selectedBold, false);
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
        this.bMk = i;
        this.bMl = i2;
        this.bMt = f;
        this.bMu = f2;
        this.bMv = z;
        invalidate();
    }

    private boolean Uj() {
        return (this.bMk == -1 || this.bMl == -1) ? false : true;
    }

    private void dj(boolean z) {
        if (this.bMx) {
            if (z) {
                if (this.bMu != -1.0f) {
                    setTextSize(0, this.bMu);
                }
            } else if (this.bMt != -1.0f) {
                setTextSize(0, this.bMt);
            }
        }
    }

    public TabTextView dk(boolean z) {
        if (this.bMv) {
            if (z) {
                setTypeface(Typeface.DEFAULT_BOLD);
            } else {
                setTypeface(Typeface.DEFAULT);
            }
        }
        return this;
    }

    private void dl(boolean z) {
        if (z && Uj()) {
            if (this.bMw == null) {
                if (getMeasuredWidth() == 0) {
                    int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                    measure(makeMeasureSpec, makeMeasureSpec);
                }
                this.bMw = new LinearGradient(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight(), new int[]{this.bMk, this.bMl}, (float[]) null, Shader.TileMode.CLAMP);
            }
            getPaint().setShader(this.bMw);
            return;
        }
        getPaint().setShader(null);
    }
}
