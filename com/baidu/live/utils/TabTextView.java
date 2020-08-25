package com.baidu.live.utils;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.baidu.live.sdk.a;
/* loaded from: classes7.dex */
public class TabTextView extends TextView {
    private LinearGradient bop;
    private boolean boq;
    private final float bqC;
    private final float bqD;
    private final boolean bqE;
    private final int endTextColor;
    private final int startTextColor;

    public TabTextView(Context context) {
        this(context, null);
    }

    public TabTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TabTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.boq = true;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.k.sdk_TabTextView);
        this.startTextColor = obtainStyledAttributes.getColor(a.k.sdk_TabTextView_startTextColor, -1);
        this.endTextColor = obtainStyledAttributes.getColor(a.k.sdk_TabTextView_endTextColor, -1);
        this.bqC = obtainStyledAttributes.getDimension(a.k.sdk_TabTextView_defaultTextSize, -1.0f);
        this.bqD = obtainStyledAttributes.getDimension(a.k.sdk_TabTextView_selectedTextSize, -1.0f);
        this.bqE = obtainStyledAttributes.getBoolean(a.k.sdk_TabTextView_selectedBold, false);
        obtainStyledAttributes.recycle();
        cu(false);
    }

    @Override // android.view.View
    protected void dispatchSetSelected(boolean z) {
        super.dispatchSetSelected(z);
        cu(z);
        setSelectedBold(z);
        cw(z);
    }

    private boolean On() {
        return (this.startTextColor == -1 || this.endTextColor == -1) ? false : true;
    }

    private void cu(boolean z) {
        if (this.boq) {
            if (z) {
                if (this.bqD != -1.0f) {
                    setTextSize(0, this.bqD);
                }
            } else if (this.bqC != -1.0f) {
                setTextSize(0, this.bqC);
            }
        }
    }

    private void setSelectedBold(boolean z) {
        if (this.bqE) {
            if (z) {
                setTypeface(Typeface.DEFAULT_BOLD);
            } else {
                setTypeface(Typeface.DEFAULT);
            }
        }
    }

    private void cw(boolean z) {
        if (z && On()) {
            if (this.bop == null) {
                if (getMeasuredWidth() == 0) {
                    int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                    measure(makeMeasureSpec, makeMeasureSpec);
                }
                this.bop = new LinearGradient(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight(), new int[]{this.startTextColor, this.endTextColor}, (float[]) null, Shader.TileMode.CLAMP);
            }
            getPaint().setShader(this.bop);
            return;
        }
        getPaint().setShader(null);
    }
}
