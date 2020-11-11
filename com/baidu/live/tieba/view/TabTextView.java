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
    private int bDC;
    private int bDD;
    private float bDM;
    private boolean bDN;
    private LinearGradient bDO;
    private boolean bDP;
    private float mSelectedTextSize;

    public TabTextView(Context context) {
        this(context, null);
    }

    public TabTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TabTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bDP = true;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.j.sdk_TabTextView);
        this.bDC = obtainStyledAttributes.getColor(a.j.sdk_TabTextView_startTextColor, -1);
        this.bDD = obtainStyledAttributes.getColor(a.j.sdk_TabTextView_endTextColor, -1);
        this.bDM = obtainStyledAttributes.getDimension(a.j.sdk_TabTextView_defaultTextSize, -1.0f);
        this.mSelectedTextSize = obtainStyledAttributes.getDimension(a.j.sdk_TabTextView_selectedTextSize, -1.0f);
        this.bDN = obtainStyledAttributes.getBoolean(a.j.sdk_TabTextView_selectedBold, false);
        obtainStyledAttributes.recycle();
        cM(false);
    }

    @Override // android.view.View
    protected void dispatchSetSelected(boolean z) {
        super.dispatchSetSelected(z);
        cM(z);
        cN(z);
        cO(z);
    }

    public void setGradientAttrs(int i, int i2, float f, float f2, boolean z) {
        this.bDC = i;
        this.bDD = i2;
        this.bDM = f;
        this.mSelectedTextSize = f2;
        this.bDN = z;
        invalidate();
    }

    private boolean Ty() {
        return (this.bDC == -1 || this.bDD == -1) ? false : true;
    }

    private void cM(boolean z) {
        if (this.bDP) {
            if (z) {
                if (this.mSelectedTextSize != -1.0f) {
                    setTextSize(0, this.mSelectedTextSize);
                }
            } else if (this.bDM != -1.0f) {
                setTextSize(0, this.bDM);
            }
        }
    }

    public TabTextView cN(boolean z) {
        if (this.bDN) {
            if (z) {
                setTypeface(Typeface.DEFAULT_BOLD);
            } else {
                setTypeface(Typeface.DEFAULT);
            }
        }
        return this;
    }

    private void cO(boolean z) {
        if (z && Ty()) {
            if (this.bDO == null) {
                if (getMeasuredWidth() == 0) {
                    int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                    measure(makeMeasureSpec, makeMeasureSpec);
                }
                this.bDO = new LinearGradient(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight(), new int[]{this.bDC, this.bDD}, (float[]) null, Shader.TileMode.CLAMP);
            }
            getPaint().setShader(this.bDO);
            return;
        }
        getPaint().setShader(null);
    }
}
