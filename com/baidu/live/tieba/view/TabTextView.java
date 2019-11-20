package com.baidu.live.tieba.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.baidu.live.k.a;
/* loaded from: classes6.dex */
public class TabTextView extends TextView {
    private int aoA;
    private int aoB;
    private float aoS;
    private float aoT;
    private boolean aoU;
    private LinearGradient aoV;
    private boolean aoW;

    public TabTextView(Context context) {
        this(context, null);
    }

    public TabTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TabTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aoW = true;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.k.sdk_TabTextView);
        this.aoA = obtainStyledAttributes.getColor(a.k.sdk_TabTextView_startTextColor, -1);
        this.aoB = obtainStyledAttributes.getColor(a.k.sdk_TabTextView_endTextColor, -1);
        this.aoS = obtainStyledAttributes.getDimension(a.k.sdk_TabTextView_defaultTextSize, -1.0f);
        this.aoT = obtainStyledAttributes.getDimension(a.k.sdk_TabTextView_selectedTextSize, -1.0f);
        this.aoU = obtainStyledAttributes.getBoolean(a.k.sdk_TabTextView_selectedBold, false);
        obtainStyledAttributes.recycle();
        aM(false);
    }

    @Override // android.view.View
    protected void dispatchSetSelected(boolean z) {
        super.dispatchSetSelected(z);
        aM(z);
        aN(z);
        aO(z);
    }

    public void setGradientAttrs(int i, int i2, float f, float f2, boolean z) {
        this.aoA = i;
        this.aoB = i2;
        this.aoS = f;
        this.aoT = f2;
        this.aoU = z;
        invalidate();
    }

    private boolean vz() {
        return (this.aoA == -1 || this.aoB == -1) ? false : true;
    }

    private void aM(boolean z) {
        if (this.aoW) {
            if (z) {
                if (this.aoT != -1.0f) {
                    setTextSize(0, this.aoT);
                }
            } else if (this.aoS != -1.0f) {
                setTextSize(0, this.aoS);
            }
        }
    }

    public TabTextView aN(boolean z) {
        if (this.aoU) {
            if (z) {
                setTypeface(Typeface.DEFAULT_BOLD);
            } else {
                setTypeface(Typeface.DEFAULT);
            }
        }
        return this;
    }

    private void aO(boolean z) {
        if (z && vz()) {
            if (this.aoV == null) {
                if (getMeasuredWidth() == 0) {
                    int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                    measure(makeMeasureSpec, makeMeasureSpec);
                }
                this.aoV = new LinearGradient(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight(), new int[]{this.aoA, this.aoB}, (float[]) null, Shader.TileMode.CLAMP);
            }
            getPaint().setShader(this.aoV);
            return;
        }
        getPaint().setShader(null);
    }
}
