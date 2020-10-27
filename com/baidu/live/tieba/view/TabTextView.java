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
    private float bxB;
    private boolean bxC;
    private LinearGradient bxD;
    private boolean bxE;
    private int bxr;
    private int bxs;
    private float mSelectedTextSize;

    public TabTextView(Context context) {
        this(context, null);
    }

    public TabTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TabTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bxE = true;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.k.sdk_TabTextView);
        this.bxr = obtainStyledAttributes.getColor(a.k.sdk_TabTextView_startTextColor, -1);
        this.bxs = obtainStyledAttributes.getColor(a.k.sdk_TabTextView_endTextColor, -1);
        this.bxB = obtainStyledAttributes.getDimension(a.k.sdk_TabTextView_defaultTextSize, -1.0f);
        this.mSelectedTextSize = obtainStyledAttributes.getDimension(a.k.sdk_TabTextView_selectedTextSize, -1.0f);
        this.bxC = obtainStyledAttributes.getBoolean(a.k.sdk_TabTextView_selectedBold, false);
        obtainStyledAttributes.recycle();
        cF(false);
    }

    @Override // android.view.View
    protected void dispatchSetSelected(boolean z) {
        super.dispatchSetSelected(z);
        cF(z);
        cG(z);
        cH(z);
    }

    public void setGradientAttrs(int i, int i2, float f, float f2, boolean z) {
        this.bxr = i;
        this.bxs = i2;
        this.bxB = f;
        this.mSelectedTextSize = f2;
        this.bxC = z;
        invalidate();
    }

    private boolean QQ() {
        return (this.bxr == -1 || this.bxs == -1) ? false : true;
    }

    private void cF(boolean z) {
        if (this.bxE) {
            if (z) {
                if (this.mSelectedTextSize != -1.0f) {
                    setTextSize(0, this.mSelectedTextSize);
                }
            } else if (this.bxB != -1.0f) {
                setTextSize(0, this.bxB);
            }
        }
    }

    public TabTextView cG(boolean z) {
        if (this.bxC) {
            if (z) {
                setTypeface(Typeface.DEFAULT_BOLD);
            } else {
                setTypeface(Typeface.DEFAULT);
            }
        }
        return this;
    }

    private void cH(boolean z) {
        if (z && QQ()) {
            if (this.bxD == null) {
                if (getMeasuredWidth() == 0) {
                    int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                    measure(makeMeasureSpec, makeMeasureSpec);
                }
                this.bxD = new LinearGradient(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight(), new int[]{this.bxr, this.bxs}, (float[]) null, Shader.TileMode.CLAMP);
            }
            getPaint().setShader(this.bxD);
            return;
        }
        getPaint().setShader(null);
    }
}
