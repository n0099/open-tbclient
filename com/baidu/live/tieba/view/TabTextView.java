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
/* loaded from: classes4.dex */
public class TabTextView extends TextView {
    private int bvd;
    private int bve;
    private float bvn;
    private boolean bvo;
    private LinearGradient bvp;
    private boolean bvq;
    private float mSelectedTextSize;

    public TabTextView(Context context) {
        this(context, null);
    }

    public TabTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TabTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bvq = true;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.k.sdk_TabTextView);
        this.bvd = obtainStyledAttributes.getColor(a.k.sdk_TabTextView_startTextColor, -1);
        this.bve = obtainStyledAttributes.getColor(a.k.sdk_TabTextView_endTextColor, -1);
        this.bvn = obtainStyledAttributes.getDimension(a.k.sdk_TabTextView_defaultTextSize, -1.0f);
        this.mSelectedTextSize = obtainStyledAttributes.getDimension(a.k.sdk_TabTextView_selectedTextSize, -1.0f);
        this.bvo = obtainStyledAttributes.getBoolean(a.k.sdk_TabTextView_selectedBold, false);
        obtainStyledAttributes.recycle();
        cz(false);
    }

    @Override // android.view.View
    protected void dispatchSetSelected(boolean z) {
        super.dispatchSetSelected(z);
        cz(z);
        cA(z);
        cB(z);
    }

    public void setGradientAttrs(int i, int i2, float f, float f2, boolean z) {
        this.bvd = i;
        this.bve = i2;
        this.bvn = f;
        this.mSelectedTextSize = f2;
        this.bvo = z;
        invalidate();
    }

    private boolean PV() {
        return (this.bvd == -1 || this.bve == -1) ? false : true;
    }

    private void cz(boolean z) {
        if (this.bvq) {
            if (z) {
                if (this.mSelectedTextSize != -1.0f) {
                    setTextSize(0, this.mSelectedTextSize);
                }
            } else if (this.bvn != -1.0f) {
                setTextSize(0, this.bvn);
            }
        }
    }

    public TabTextView cA(boolean z) {
        if (this.bvo) {
            if (z) {
                setTypeface(Typeface.DEFAULT_BOLD);
            } else {
                setTypeface(Typeface.DEFAULT);
            }
        }
        return this;
    }

    private void cB(boolean z) {
        if (z && PV()) {
            if (this.bvp == null) {
                if (getMeasuredWidth() == 0) {
                    int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                    measure(makeMeasureSpec, makeMeasureSpec);
                }
                this.bvp = new LinearGradient(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight(), new int[]{this.bvd, this.bve}, (float[]) null, Shader.TileMode.CLAMP);
            }
            getPaint().setShader(this.bvp);
            return;
        }
        getPaint().setShader(null);
    }
}
