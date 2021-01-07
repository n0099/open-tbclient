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
    private int bLM;
    private int bLN;
    private float bLV;
    private float bLW;
    private boolean bLX;
    private LinearGradient bLY;
    private boolean bLZ;

    public TabTextView(Context context) {
        this(context, null);
    }

    public TabTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TabTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bLZ = true;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.j.sdk_TabTextView);
        this.bLM = obtainStyledAttributes.getColor(a.j.sdk_TabTextView_startTextColor, -1);
        this.bLN = obtainStyledAttributes.getColor(a.j.sdk_TabTextView_endTextColor, -1);
        this.bLV = obtainStyledAttributes.getDimension(a.j.sdk_TabTextView_defaultTextSize, -1.0f);
        this.bLW = obtainStyledAttributes.getDimension(a.j.sdk_TabTextView_selectedTextSize, -1.0f);
        this.bLX = obtainStyledAttributes.getBoolean(a.j.sdk_TabTextView_selectedBold, false);
        obtainStyledAttributes.recycle();
        df(false);
    }

    @Override // android.view.View
    protected void dispatchSetSelected(boolean z) {
        super.dispatchSetSelected(z);
        df(z);
        dg(z);
        dh(z);
    }

    public void setGradientAttrs(int i, int i2, float f, float f2, boolean z) {
        this.bLM = i;
        this.bLN = i2;
        this.bLV = f;
        this.bLW = f2;
        this.bLX = z;
        invalidate();
    }

    private boolean Ws() {
        return (this.bLM == -1 || this.bLN == -1) ? false : true;
    }

    private void df(boolean z) {
        if (this.bLZ) {
            if (z) {
                if (this.bLW != -1.0f) {
                    setTextSize(0, this.bLW);
                }
            } else if (this.bLV != -1.0f) {
                setTextSize(0, this.bLV);
            }
        }
    }

    public TabTextView dg(boolean z) {
        if (this.bLX) {
            if (z) {
                setTypeface(Typeface.DEFAULT_BOLD);
            } else {
                setTypeface(Typeface.DEFAULT);
            }
        }
        return this;
    }

    private void dh(boolean z) {
        if (z && Ws()) {
            if (this.bLY == null) {
                if (getMeasuredWidth() == 0) {
                    int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                    measure(makeMeasureSpec, makeMeasureSpec);
                }
                this.bLY = new LinearGradient(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight(), new int[]{this.bLM, this.bLN}, (float[]) null, Shader.TileMode.CLAMP);
            }
            getPaint().setShader(this.bLY);
            return;
        }
        getPaint().setShader(null);
    }
}
