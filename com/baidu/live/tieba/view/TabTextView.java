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
    private int bBR;
    private int bBS;
    private float bCb;
    private boolean bCc;
    private LinearGradient bCd;
    private boolean bCe;
    private float mSelectedTextSize;

    public TabTextView(Context context) {
        this(context, null);
    }

    public TabTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TabTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bCe = true;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.j.sdk_TabTextView);
        this.bBR = obtainStyledAttributes.getColor(a.j.sdk_TabTextView_startTextColor, -1);
        this.bBS = obtainStyledAttributes.getColor(a.j.sdk_TabTextView_endTextColor, -1);
        this.bCb = obtainStyledAttributes.getDimension(a.j.sdk_TabTextView_defaultTextSize, -1.0f);
        this.mSelectedTextSize = obtainStyledAttributes.getDimension(a.j.sdk_TabTextView_selectedTextSize, -1.0f);
        this.bCc = obtainStyledAttributes.getBoolean(a.j.sdk_TabTextView_selectedBold, false);
        obtainStyledAttributes.recycle();
        cO(false);
    }

    @Override // android.view.View
    protected void dispatchSetSelected(boolean z) {
        super.dispatchSetSelected(z);
        cO(z);
        cP(z);
        cQ(z);
    }

    public void setGradientAttrs(int i, int i2, float f, float f2, boolean z) {
        this.bBR = i;
        this.bBS = i2;
        this.bCb = f;
        this.mSelectedTextSize = f2;
        this.bCc = z;
        invalidate();
    }

    private boolean SP() {
        return (this.bBR == -1 || this.bBS == -1) ? false : true;
    }

    private void cO(boolean z) {
        if (this.bCe) {
            if (z) {
                if (this.mSelectedTextSize != -1.0f) {
                    setTextSize(0, this.mSelectedTextSize);
                }
            } else if (this.bCb != -1.0f) {
                setTextSize(0, this.bCb);
            }
        }
    }

    public TabTextView cP(boolean z) {
        if (this.bCc) {
            if (z) {
                setTypeface(Typeface.DEFAULT_BOLD);
            } else {
                setTypeface(Typeface.DEFAULT);
            }
        }
        return this;
    }

    private void cQ(boolean z) {
        if (z && SP()) {
            if (this.bCd == null) {
                if (getMeasuredWidth() == 0) {
                    int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                    measure(makeMeasureSpec, makeMeasureSpec);
                }
                this.bCd = new LinearGradient(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight(), new int[]{this.bBR, this.bBS}, (float[]) null, Shader.TileMode.CLAMP);
            }
            getPaint().setShader(this.bCd);
            return;
        }
        getPaint().setShader(null);
    }
}
