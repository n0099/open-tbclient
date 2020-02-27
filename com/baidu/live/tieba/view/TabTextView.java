package com.baidu.live.tieba.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.baidu.live.u.a;
/* loaded from: classes3.dex */
public class TabTextView extends TextView {
    private int aBA;
    private float aBL;
    private boolean aBM;
    private LinearGradient aBN;
    private boolean aBO;
    private int aBz;
    private float mSelectedTextSize;

    public TabTextView(Context context) {
        this(context, null);
    }

    public TabTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TabTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aBO = true;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.k.sdk_TabTextView);
        this.aBz = obtainStyledAttributes.getColor(a.k.sdk_TabTextView_startTextColor, -1);
        this.aBA = obtainStyledAttributes.getColor(a.k.sdk_TabTextView_endTextColor, -1);
        this.aBL = obtainStyledAttributes.getDimension(a.k.sdk_TabTextView_defaultTextSize, -1.0f);
        this.mSelectedTextSize = obtainStyledAttributes.getDimension(a.k.sdk_TabTextView_selectedTextSize, -1.0f);
        this.aBM = obtainStyledAttributes.getBoolean(a.k.sdk_TabTextView_selectedBold, false);
        obtainStyledAttributes.recycle();
        bp(false);
    }

    @Override // android.view.View
    protected void dispatchSetSelected(boolean z) {
        super.dispatchSetSelected(z);
        bp(z);
        bq(z);
        br(z);
    }

    public void setGradientAttrs(int i, int i2, float f, float f2, boolean z) {
        this.aBz = i;
        this.aBA = i2;
        this.aBL = f;
        this.mSelectedTextSize = f2;
        this.aBM = z;
        invalidate();
    }

    private boolean Ae() {
        return (this.aBz == -1 || this.aBA == -1) ? false : true;
    }

    private void bp(boolean z) {
        if (this.aBO) {
            if (z) {
                if (this.mSelectedTextSize != -1.0f) {
                    setTextSize(0, this.mSelectedTextSize);
                }
            } else if (this.aBL != -1.0f) {
                setTextSize(0, this.aBL);
            }
        }
    }

    public TabTextView bq(boolean z) {
        if (this.aBM) {
            if (z) {
                setTypeface(Typeface.DEFAULT_BOLD);
            } else {
                setTypeface(Typeface.DEFAULT);
            }
        }
        return this;
    }

    private void br(boolean z) {
        if (z && Ae()) {
            if (this.aBN == null) {
                if (getMeasuredWidth() == 0) {
                    int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                    measure(makeMeasureSpec, makeMeasureSpec);
                }
                this.aBN = new LinearGradient(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight(), new int[]{this.aBz, this.aBA}, (float[]) null, Shader.TileMode.CLAMP);
            }
            getPaint().setShader(this.aBN);
            return;
        }
        getPaint().setShader(null);
    }
}
