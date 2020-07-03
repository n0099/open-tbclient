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
/* loaded from: classes3.dex */
public class TabTextView extends TextView {
    private int bhZ;
    private int bia;
    private float bin;
    private boolean bip;
    private LinearGradient biq;
    private boolean bir;
    private float mSelectedTextSize;

    public TabTextView(Context context) {
        this(context, null);
    }

    public TabTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TabTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bir = true;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.k.sdk_TabTextView);
        this.bhZ = obtainStyledAttributes.getColor(a.k.sdk_TabTextView_startTextColor, -1);
        this.bia = obtainStyledAttributes.getColor(a.k.sdk_TabTextView_endTextColor, -1);
        this.bin = obtainStyledAttributes.getDimension(a.k.sdk_TabTextView_defaultTextSize, -1.0f);
        this.mSelectedTextSize = obtainStyledAttributes.getDimension(a.k.sdk_TabTextView_selectedTextSize, -1.0f);
        this.bip = obtainStyledAttributes.getBoolean(a.k.sdk_TabTextView_selectedBold, false);
        obtainStyledAttributes.recycle();
        cj(false);
    }

    @Override // android.view.View
    protected void dispatchSetSelected(boolean z) {
        super.dispatchSetSelected(z);
        cj(z);
        ck(z);
        cl(z);
    }

    public void setGradientAttrs(int i, int i2, float f, float f2, boolean z) {
        this.bhZ = i;
        this.bia = i2;
        this.bin = f;
        this.mSelectedTextSize = f2;
        this.bip = z;
        invalidate();
    }

    private boolean Io() {
        return (this.bhZ == -1 || this.bia == -1) ? false : true;
    }

    private void cj(boolean z) {
        if (this.bir) {
            if (z) {
                if (this.mSelectedTextSize != -1.0f) {
                    setTextSize(0, this.mSelectedTextSize);
                }
            } else if (this.bin != -1.0f) {
                setTextSize(0, this.bin);
            }
        }
    }

    public TabTextView ck(boolean z) {
        if (this.bip) {
            if (z) {
                setTypeface(Typeface.DEFAULT_BOLD);
            } else {
                setTypeface(Typeface.DEFAULT);
            }
        }
        return this;
    }

    private void cl(boolean z) {
        if (z && Io()) {
            if (this.biq == null) {
                if (getMeasuredWidth() == 0) {
                    int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                    measure(makeMeasureSpec, makeMeasureSpec);
                }
                this.biq = new LinearGradient(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight(), new int[]{this.bhZ, this.bia}, (float[]) null, Shader.TileMode.CLAMP);
            }
            getPaint().setShader(this.biq);
            return;
        }
        getPaint().setShader(null);
    }
}
