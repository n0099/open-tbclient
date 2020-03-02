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
    private int aBB;
    private float aBM;
    private boolean aBN;
    private LinearGradient aBO;
    private boolean aBP;
    private float mSelectedTextSize;

    public TabTextView(Context context) {
        this(context, null);
    }

    public TabTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TabTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aBP = true;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.k.sdk_TabTextView);
        this.aBA = obtainStyledAttributes.getColor(a.k.sdk_TabTextView_startTextColor, -1);
        this.aBB = obtainStyledAttributes.getColor(a.k.sdk_TabTextView_endTextColor, -1);
        this.aBM = obtainStyledAttributes.getDimension(a.k.sdk_TabTextView_defaultTextSize, -1.0f);
        this.mSelectedTextSize = obtainStyledAttributes.getDimension(a.k.sdk_TabTextView_selectedTextSize, -1.0f);
        this.aBN = obtainStyledAttributes.getBoolean(a.k.sdk_TabTextView_selectedBold, false);
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
        this.aBA = i;
        this.aBB = i2;
        this.aBM = f;
        this.mSelectedTextSize = f2;
        this.aBN = z;
        invalidate();
    }

    private boolean Ag() {
        return (this.aBA == -1 || this.aBB == -1) ? false : true;
    }

    private void bp(boolean z) {
        if (this.aBP) {
            if (z) {
                if (this.mSelectedTextSize != -1.0f) {
                    setTextSize(0, this.mSelectedTextSize);
                }
            } else if (this.aBM != -1.0f) {
                setTextSize(0, this.aBM);
            }
        }
    }

    public TabTextView bq(boolean z) {
        if (this.aBN) {
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
            if (this.aBO == null) {
                if (getMeasuredWidth() == 0) {
                    int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                    measure(makeMeasureSpec, makeMeasureSpec);
                }
                this.aBO = new LinearGradient(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight(), new int[]{this.aBA, this.aBB}, (float[]) null, Shader.TileMode.CLAMP);
            }
            getPaint().setShader(this.aBO);
            return;
        }
        getPaint().setShader(null);
    }
}
