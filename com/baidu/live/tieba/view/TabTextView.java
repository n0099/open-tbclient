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
/* loaded from: classes7.dex */
public class TabTextView extends TextView {
    private int bob;
    private int boc;
    private float bon;
    private boolean boo;
    private LinearGradient bop;
    private boolean boq;
    private float mSelectedTextSize;

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
        this.bob = obtainStyledAttributes.getColor(a.k.sdk_TabTextView_startTextColor, -1);
        this.boc = obtainStyledAttributes.getColor(a.k.sdk_TabTextView_endTextColor, -1);
        this.bon = obtainStyledAttributes.getDimension(a.k.sdk_TabTextView_defaultTextSize, -1.0f);
        this.mSelectedTextSize = obtainStyledAttributes.getDimension(a.k.sdk_TabTextView_selectedTextSize, -1.0f);
        this.boo = obtainStyledAttributes.getBoolean(a.k.sdk_TabTextView_selectedBold, false);
        obtainStyledAttributes.recycle();
        cu(false);
    }

    @Override // android.view.View
    protected void dispatchSetSelected(boolean z) {
        super.dispatchSetSelected(z);
        cu(z);
        cv(z);
        cw(z);
    }

    public void setGradientAttrs(int i, int i2, float f, float f2, boolean z) {
        this.bob = i;
        this.boc = i2;
        this.bon = f;
        this.mSelectedTextSize = f2;
        this.boo = z;
        invalidate();
    }

    private boolean On() {
        return (this.bob == -1 || this.boc == -1) ? false : true;
    }

    private void cu(boolean z) {
        if (this.boq) {
            if (z) {
                if (this.mSelectedTextSize != -1.0f) {
                    setTextSize(0, this.mSelectedTextSize);
                }
            } else if (this.bon != -1.0f) {
                setTextSize(0, this.bon);
            }
        }
    }

    public TabTextView cv(boolean z) {
        if (this.boo) {
            if (z) {
                setTypeface(Typeface.DEFAULT_BOLD);
            } else {
                setTypeface(Typeface.DEFAULT);
            }
        }
        return this;
    }

    private void cw(boolean z) {
        if (z && On()) {
            if (this.bop == null) {
                if (getMeasuredWidth() == 0) {
                    int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                    measure(makeMeasureSpec, makeMeasureSpec);
                }
                this.bop = new LinearGradient(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight(), new int[]{this.bob, this.boc}, (float[]) null, Shader.TileMode.CLAMP);
            }
            getPaint().setShader(this.bop);
            return;
        }
        getPaint().setShader(null);
    }
}
