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
    private int aBB;
    private int aBC;
    private float aBN;
    private boolean aBO;
    private LinearGradient aBP;
    private boolean aBQ;
    private float mSelectedTextSize;

    public TabTextView(Context context) {
        this(context, null);
    }

    public TabTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TabTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aBQ = true;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.k.sdk_TabTextView);
        this.aBB = obtainStyledAttributes.getColor(a.k.sdk_TabTextView_startTextColor, -1);
        this.aBC = obtainStyledAttributes.getColor(a.k.sdk_TabTextView_endTextColor, -1);
        this.aBN = obtainStyledAttributes.getDimension(a.k.sdk_TabTextView_defaultTextSize, -1.0f);
        this.mSelectedTextSize = obtainStyledAttributes.getDimension(a.k.sdk_TabTextView_selectedTextSize, -1.0f);
        this.aBO = obtainStyledAttributes.getBoolean(a.k.sdk_TabTextView_selectedBold, false);
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
        this.aBB = i;
        this.aBC = i2;
        this.aBN = f;
        this.mSelectedTextSize = f2;
        this.aBO = z;
        invalidate();
    }

    private boolean Ag() {
        return (this.aBB == -1 || this.aBC == -1) ? false : true;
    }

    private void bp(boolean z) {
        if (this.aBQ) {
            if (z) {
                if (this.mSelectedTextSize != -1.0f) {
                    setTextSize(0, this.mSelectedTextSize);
                }
            } else if (this.aBN != -1.0f) {
                setTextSize(0, this.aBN);
            }
        }
    }

    public TabTextView bq(boolean z) {
        if (this.aBO) {
            if (z) {
                setTypeface(Typeface.DEFAULT_BOLD);
            } else {
                setTypeface(Typeface.DEFAULT);
            }
        }
        return this;
    }

    private void br(boolean z) {
        if (z && Ag()) {
            if (this.aBP == null) {
                if (getMeasuredWidth() == 0) {
                    int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                    measure(makeMeasureSpec, makeMeasureSpec);
                }
                this.aBP = new LinearGradient(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight(), new int[]{this.aBB, this.aBC}, (float[]) null, Shader.TileMode.CLAMP);
            }
            getPaint().setShader(this.aBP);
            return;
        }
        getPaint().setShader(null);
    }
}
