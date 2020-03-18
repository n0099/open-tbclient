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
    private int aBP;
    private int aBQ;
    private float aCb;
    private boolean aCc;
    private LinearGradient aCd;
    private boolean aCe;
    private float mSelectedTextSize;

    public TabTextView(Context context) {
        this(context, null);
    }

    public TabTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TabTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aCe = true;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.k.sdk_TabTextView);
        this.aBP = obtainStyledAttributes.getColor(a.k.sdk_TabTextView_startTextColor, -1);
        this.aBQ = obtainStyledAttributes.getColor(a.k.sdk_TabTextView_endTextColor, -1);
        this.aCb = obtainStyledAttributes.getDimension(a.k.sdk_TabTextView_defaultTextSize, -1.0f);
        this.mSelectedTextSize = obtainStyledAttributes.getDimension(a.k.sdk_TabTextView_selectedTextSize, -1.0f);
        this.aCc = obtainStyledAttributes.getBoolean(a.k.sdk_TabTextView_selectedBold, false);
        obtainStyledAttributes.recycle();
        bq(false);
    }

    @Override // android.view.View
    protected void dispatchSetSelected(boolean z) {
        super.dispatchSetSelected(z);
        bq(z);
        br(z);
        bs(z);
    }

    public void setGradientAttrs(int i, int i2, float f, float f2, boolean z) {
        this.aBP = i;
        this.aBQ = i2;
        this.aCb = f;
        this.mSelectedTextSize = f2;
        this.aCc = z;
        invalidate();
    }

    private boolean An() {
        return (this.aBP == -1 || this.aBQ == -1) ? false : true;
    }

    private void bq(boolean z) {
        if (this.aCe) {
            if (z) {
                if (this.mSelectedTextSize != -1.0f) {
                    setTextSize(0, this.mSelectedTextSize);
                }
            } else if (this.aCb != -1.0f) {
                setTextSize(0, this.aCb);
            }
        }
    }

    public TabTextView br(boolean z) {
        if (this.aCc) {
            if (z) {
                setTypeface(Typeface.DEFAULT_BOLD);
            } else {
                setTypeface(Typeface.DEFAULT);
            }
        }
        return this;
    }

    private void bs(boolean z) {
        if (z && An()) {
            if (this.aCd == null) {
                if (getMeasuredWidth() == 0) {
                    int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                    measure(makeMeasureSpec, makeMeasureSpec);
                }
                this.aCd = new LinearGradient(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight(), new int[]{this.aBP, this.aBQ}, (float[]) null, Shader.TileMode.CLAMP);
            }
            getPaint().setShader(this.aCd);
            return;
        }
        getPaint().setShader(null);
    }
}
