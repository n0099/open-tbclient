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
    private int boe;
    private int bof;
    private float boq;
    private boolean bor;
    private LinearGradient bos;
    private boolean bot;
    private float mSelectedTextSize;

    public TabTextView(Context context) {
        this(context, null);
    }

    public TabTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TabTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bot = true;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.k.sdk_TabTextView);
        this.boe = obtainStyledAttributes.getColor(a.k.sdk_TabTextView_startTextColor, -1);
        this.bof = obtainStyledAttributes.getColor(a.k.sdk_TabTextView_endTextColor, -1);
        this.boq = obtainStyledAttributes.getDimension(a.k.sdk_TabTextView_defaultTextSize, -1.0f);
        this.mSelectedTextSize = obtainStyledAttributes.getDimension(a.k.sdk_TabTextView_selectedTextSize, -1.0f);
        this.bor = obtainStyledAttributes.getBoolean(a.k.sdk_TabTextView_selectedBold, false);
        obtainStyledAttributes.recycle();
        cv(false);
    }

    @Override // android.view.View
    protected void dispatchSetSelected(boolean z) {
        super.dispatchSetSelected(z);
        cv(z);
        cw(z);
        cx(z);
    }

    public void setGradientAttrs(int i, int i2, float f, float f2, boolean z) {
        this.boe = i;
        this.bof = i2;
        this.boq = f;
        this.mSelectedTextSize = f2;
        this.bor = z;
        invalidate();
    }

    private boolean On() {
        return (this.boe == -1 || this.bof == -1) ? false : true;
    }

    private void cv(boolean z) {
        if (this.bot) {
            if (z) {
                if (this.mSelectedTextSize != -1.0f) {
                    setTextSize(0, this.mSelectedTextSize);
                }
            } else if (this.boq != -1.0f) {
                setTextSize(0, this.boq);
            }
        }
    }

    public TabTextView cw(boolean z) {
        if (this.bor) {
            if (z) {
                setTypeface(Typeface.DEFAULT_BOLD);
            } else {
                setTypeface(Typeface.DEFAULT);
            }
        }
        return this;
    }

    private void cx(boolean z) {
        if (z && On()) {
            if (this.bos == null) {
                if (getMeasuredWidth() == 0) {
                    int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                    measure(makeMeasureSpec, makeMeasureSpec);
                }
                this.bos = new LinearGradient(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight(), new int[]{this.boe, this.bof}, (float[]) null, Shader.TileMode.CLAMP);
            }
            getPaint().setShader(this.bos);
            return;
        }
        getPaint().setShader(null);
    }
}
