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
    private float biI;
    private boolean biJ;
    private LinearGradient biK;
    private boolean biL;
    private int biw;
    private int bix;
    private float mSelectedTextSize;

    public TabTextView(Context context) {
        this(context, null);
    }

    public TabTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TabTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.biL = true;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.k.sdk_TabTextView);
        this.biw = obtainStyledAttributes.getColor(a.k.sdk_TabTextView_startTextColor, -1);
        this.bix = obtainStyledAttributes.getColor(a.k.sdk_TabTextView_endTextColor, -1);
        this.biI = obtainStyledAttributes.getDimension(a.k.sdk_TabTextView_defaultTextSize, -1.0f);
        this.mSelectedTextSize = obtainStyledAttributes.getDimension(a.k.sdk_TabTextView_selectedTextSize, -1.0f);
        this.biJ = obtainStyledAttributes.getBoolean(a.k.sdk_TabTextView_selectedBold, false);
        obtainStyledAttributes.recycle();
        cl(false);
    }

    @Override // android.view.View
    protected void dispatchSetSelected(boolean z) {
        super.dispatchSetSelected(z);
        cl(z);
        cm(z);
        cn(z);
    }

    public void setGradientAttrs(int i, int i2, float f, float f2, boolean z) {
        this.biw = i;
        this.bix = i2;
        this.biI = f;
        this.mSelectedTextSize = f2;
        this.biJ = z;
        invalidate();
    }

    private boolean Iu() {
        return (this.biw == -1 || this.bix == -1) ? false : true;
    }

    private void cl(boolean z) {
        if (this.biL) {
            if (z) {
                if (this.mSelectedTextSize != -1.0f) {
                    setTextSize(0, this.mSelectedTextSize);
                }
            } else if (this.biI != -1.0f) {
                setTextSize(0, this.biI);
            }
        }
    }

    public TabTextView cm(boolean z) {
        if (this.biJ) {
            if (z) {
                setTypeface(Typeface.DEFAULT_BOLD);
            } else {
                setTypeface(Typeface.DEFAULT);
            }
        }
        return this;
    }

    private void cn(boolean z) {
        if (z && Iu()) {
            if (this.biK == null) {
                if (getMeasuredWidth() == 0) {
                    int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                    measure(makeMeasureSpec, makeMeasureSpec);
                }
                this.biK = new LinearGradient(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight(), new int[]{this.biw, this.bix}, (float[]) null, Shader.TileMode.CLAMP);
            }
            getPaint().setShader(this.biK);
            return;
        }
        getPaint().setShader(null);
    }
}
