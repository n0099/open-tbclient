package com.baidu.live.tieba.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.baidu.live.q.a;
/* loaded from: classes2.dex */
public class TabTextView extends TextView {
    private float awM;
    private boolean awN;
    private LinearGradient awO;
    private boolean awP;
    private int awx;
    private int awy;
    private float mSelectedTextSize;

    public TabTextView(Context context) {
        this(context, null);
    }

    public TabTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TabTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.awP = true;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.k.sdk_TabTextView);
        this.awx = obtainStyledAttributes.getColor(a.k.sdk_TabTextView_startTextColor, -1);
        this.awy = obtainStyledAttributes.getColor(a.k.sdk_TabTextView_endTextColor, -1);
        this.awM = obtainStyledAttributes.getDimension(a.k.sdk_TabTextView_defaultTextSize, -1.0f);
        this.mSelectedTextSize = obtainStyledAttributes.getDimension(a.k.sdk_TabTextView_selectedTextSize, -1.0f);
        this.awN = obtainStyledAttributes.getBoolean(a.k.sdk_TabTextView_selectedBold, false);
        obtainStyledAttributes.recycle();
        bd(false);
    }

    @Override // android.view.View
    protected void dispatchSetSelected(boolean z) {
        super.dispatchSetSelected(z);
        bd(z);
        be(z);
        bf(z);
    }

    public void setGradientAttrs(int i, int i2, float f, float f2, boolean z) {
        this.awx = i;
        this.awy = i2;
        this.awM = f;
        this.mSelectedTextSize = f2;
        this.awN = z;
        invalidate();
    }

    private boolean xx() {
        return (this.awx == -1 || this.awy == -1) ? false : true;
    }

    private void bd(boolean z) {
        if (this.awP) {
            if (z) {
                if (this.mSelectedTextSize != -1.0f) {
                    setTextSize(0, this.mSelectedTextSize);
                }
            } else if (this.awM != -1.0f) {
                setTextSize(0, this.awM);
            }
        }
    }

    public TabTextView be(boolean z) {
        if (this.awN) {
            if (z) {
                setTypeface(Typeface.DEFAULT_BOLD);
            } else {
                setTypeface(Typeface.DEFAULT);
            }
        }
        return this;
    }

    private void bf(boolean z) {
        if (z && xx()) {
            if (this.awO == null) {
                if (getMeasuredWidth() == 0) {
                    int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                    measure(makeMeasureSpec, makeMeasureSpec);
                }
                this.awO = new LinearGradient(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight(), new int[]{this.awx, this.awy}, (float[]) null, Shader.TileMode.CLAMP);
            }
            getPaint().setShader(this.awO);
            return;
        }
        getPaint().setShader(null);
    }
}
